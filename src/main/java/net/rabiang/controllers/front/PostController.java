package net.rabiang.controllers.front;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.rabiang.forms.PostForm;
import net.rabiang.models.Post;
import net.rabiang.models.Tag;
import net.rabiang.services.BlogService;
import net.rabiang.utils.exceptions.PostNotFoundException;
import net.rabiang.utils.helpers.Breadcrumb;

@Controller
public class PostController {
	public static final int RECENT_POSTS = 5;

	private final Logger logger = LoggerFactory.getLogger(PostController.class);

	@Autowired
	private BlogService blogService;

	@Autowired
	private MessageSource messageSource;

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@RequestMapping(value = { "/post", "/post/index" }, method = RequestMethod.GET)
	public String index(Locale locale, @RequestParam(value = "p", required = false, defaultValue = "1") Integer p,
			@RequestParam(value = "q", required = false) String q, ModelMap model) {
		Breadcrumb breadcrumb = new Breadcrumb();

		breadcrumb.add(messageSource.getMessage("home", null, locale), "/");
		breadcrumb.add(messageSource.getMessage("blog", null, locale), null);

		model.put("page", this.blogService.findPostsByStage(Post.STATUS_PUBLIC, p, q));
		model.put("title", messageSource.getMessage("blog", null, locale));
		model.put("breadcrumb", breadcrumb.getBreadcrumb());
		model.put("recentPosts", this.blogService.findRecentPosts(Post.STATUS_PUBLIC, RECENT_POSTS));
		model.put("tags", this.blogService.findTags(Post.STATUS_PUBLIC));

		return "default/pages/blog/post/index";
	}

	@RequestMapping(value = "/post/{slug}", method = RequestMethod.GET)
	public String detail(Locale locale, @PathVariable String slug, ModelMap model) {
		Post post = this.blogService.findPostBySlug(slug);

		if (post == null) {
			logger.debug("Post not found");
			throw new PostNotFoundException();
		}

		Breadcrumb breadcrumb = new Breadcrumb();

		breadcrumb.add(messageSource.getMessage("home", null, locale), "/");
		breadcrumb.add(messageSource.getMessage("blog", null, locale), "/post");
		breadcrumb.add(post.getTitle(), null);

		model.put("post", post);
		model.put("title", post.getTitle());
		model.put("breadcrumb", breadcrumb.getBreadcrumb());
		model.put("recentPosts", this.blogService.findRecentPosts(Post.STATUS_PUBLIC, RECENT_POSTS));
		model.put("tags", this.blogService.findTags(Post.STATUS_PUBLIC));

		return "default/pages/blog/post/detail";
	}

	@RequestMapping(value = "/post/detail/{id}", method = RequestMethod.GET)
	public String detail(Locale locale, @PathVariable("id") Long id, ModelMap model) {
		Post post = this.blogService.findPostById(id);

		if (post == null) {
			logger.debug("Post not found");
			throw new PostNotFoundException();
		}

		Breadcrumb breadcrumb = new Breadcrumb();

		breadcrumb.add(messageSource.getMessage("home", null, locale), "/");
		breadcrumb.add(messageSource.getMessage("blog", null, locale), "/post");
		breadcrumb.add(post.getTitle(), null);

		model.put("post", post);
		model.put("title", post.getTitle());
		model.put("breadcrumb", breadcrumb.getBreadcrumb());
		model.put("recentPosts", this.blogService.findRecentPosts(Post.STATUS_PUBLIC, RECENT_POSTS));
		model.put("tags", this.blogService.findTags(Post.STATUS_PUBLIC));

		return "default/pages/blog/post/detail";
	}

	@RequestMapping(value = "/post/create", method = RequestMethod.GET)
	public String create(Locale locale, ModelMap model) {
		PostForm form = new PostForm();

		Map<Integer, String> statusList = new HashMap<Integer, String>();
		statusList.put(Post.STATUS_DRAFT, messageSource.getMessage("blog.draft", null, locale));
		statusList.put(Post.STATUS_PUBLIC, messageSource.getMessage("blog.public", null, locale));

		Map<Integer, String> formatList = new HashMap<Integer, String>();
		formatList.put(Post.FORMAT_TEXT, messageSource.getMessage("blog.format_text", null, locale));
		formatList.put(Post.FORMAT_HTML, messageSource.getMessage("blog.format_html", null, locale));
		formatList.put(Post.FORMAT_MARKDOWN, messageSource.getMessage("blog.format_markdown", null, locale));

		Breadcrumb breadcrumb = new Breadcrumb();

		breadcrumb.add(messageSource.getMessage("home", null, locale), "/");
		breadcrumb.add(messageSource.getMessage("blog", null, locale), "/post");
		breadcrumb.add(messageSource.getMessage("blog.write", null, locale), null);

		model.put("form", form);
		model.put("statusList", statusList);
		model.put("formatList", formatList);
		model.put("title", messageSource.getMessage("blog", null, locale));
		model.put("breadcrumb", breadcrumb.getBreadcrumb());
		model.put("recentPosts", this.blogService.findRecentPosts(Post.STATUS_PUBLIC, RECENT_POSTS));
		model.put("tags", this.blogService.findTags(Post.STATUS_PUBLIC));

		return "default/pages/blog/post/createOrEditForm";
	}

	@RequestMapping(value = "/post/save", method = RequestMethod.POST)
	public String saveAction(Locale locale, @ModelAttribute("form") @Valid PostForm form, BindingResult result,
			ModelMap model) {
		if (!result.hasErrors()) {
			Post post;

			if (form.getId() == null) {
				post = new Post();
			} else {
				post = this.blogService.findPostById(form.getId());

				if (post == null) {
					logger.debug("Post not found");
					throw new PostNotFoundException();
				}
			}

			post.setId(form.getId());
			post.setTitle(form.getTitle());
			post.setSlug(form.getSlug());
			post.setBody(form.getBody());
			post.setStage(form.getStage());
			post.setFormat(form.getFormat());
			post.setTagString(form.getTagString());

			String tagString = form.getTagString();

			Set<String> newTagSet;

			// Empty string cannot be the tag. Make sure the empty set.
			if (tagString != null && !tagString.trim().isEmpty()) {
				newTagSet = new HashSet<String>(Arrays.asList(form.getTagString().split("\\s*(,\\s*)+")));
			} else {
				newTagSet = new HashSet<String>();
			}

			Set<String> newTagSetCopy = new HashSet<String>(newTagSet);

			Set<String> oldTagSet = new HashSet<String>();
			for (Tag tag : post.getTags()) {
				oldTagSet.add(tag.getName());
			}

			// Find new tags to add
			newTagSet.removeAll(oldTagSet);

			List<Tag> tags;

			tags = this.blogService.findTagsByNames(newTagSet);

			for (String name : newTagSet) {
				boolean found = false;

				for (Tag tag : tags) {
					if (name.equals(tag.getName())) {
						found = true;
						post.addTag(tag);
						break;
					}
				}

				if (!found) {
					Tag t = new Tag(name);
					this.blogService.saveTag(t);
					post.addTag(t);
				}
			}

			// Find old tags to remove
			oldTagSet.removeAll(newTagSetCopy);

			if (!oldTagSet.isEmpty()) {
				tags = this.blogService.findTagsByNames(oldTagSet);

				for (Tag tag : tags) {
					post.removeTag(tag);
				}
			}

			post = this.blogService.savePost(post);

			return "redirect:/post/detail/" + post.getId();
		}

		Map<Integer, String> statusList = new HashMap<Integer, String>();
		statusList.put(Post.STATUS_DRAFT, messageSource.getMessage("blog.draft", null, locale));
		statusList.put(Post.STATUS_PUBLIC, messageSource.getMessage("blog.public", null, locale));

		Map<Integer, String> formatList = new HashMap<Integer, String>();
		formatList.put(Post.FORMAT_TEXT, messageSource.getMessage("blog.format_text", null, locale));
		formatList.put(Post.FORMAT_HTML, messageSource.getMessage("blog.format_html", null, locale));
		formatList.put(Post.FORMAT_MARKDOWN, messageSource.getMessage("blog.format_markdown", null, locale));

		Breadcrumb breadcrumb = new Breadcrumb();

		breadcrumb.add(messageSource.getMessage("home", null, locale), "/");
		breadcrumb.add(messageSource.getMessage("blog", null, locale), "/post");
		breadcrumb.add(messageSource.getMessage("blog.write", null, locale), null);

		model.put("form", form);
		model.put("statusList", statusList);
		model.put("formatList", formatList);
		model.put("title", messageSource.getMessage("blog", null, locale));
		model.put("breadcrumb", breadcrumb.getBreadcrumb());
		model.put("recentPosts", this.blogService.findRecentPosts(Post.STATUS_PUBLIC, RECENT_POSTS));
		model.put("tags", this.blogService.findTags(Post.STATUS_PUBLIC));

		return "default/pages/blog/post/createOrEditForm";
	}

	@RequestMapping(value = "/post/edit/{id}", method = RequestMethod.GET)
	public String edit(Locale locale, @PathVariable("id") Long id, ModelMap model) {
		Post post = this.blogService.findPostById(id);

		if (post == null) {
			throw new PostNotFoundException();
		}

		PostForm form = new PostForm(post);

		Map<Integer, String> statusList = new HashMap<Integer, String>();
		statusList.put(Post.STATUS_DRAFT, messageSource.getMessage("blog.draft", null, locale));
		statusList.put(Post.STATUS_PUBLIC, messageSource.getMessage("blog.public", null, locale));

		Map<Integer, String> formatList = new HashMap<Integer, String>();
		formatList.put(Post.FORMAT_TEXT, messageSource.getMessage("blog.format_text", null, locale));
		formatList.put(Post.FORMAT_HTML, messageSource.getMessage("blog.format_html", null, locale));
		formatList.put(Post.FORMAT_MARKDOWN, messageSource.getMessage("blog.format_markdown", null, locale));

		Breadcrumb breadcrumb = new Breadcrumb();

		breadcrumb.add(messageSource.getMessage("home", null, locale), "/");
		breadcrumb.add(messageSource.getMessage("blog", null, locale), "/post");
		breadcrumb.add(messageSource.getMessage("blog.edit", null, locale), null);

		model.put("form", form);
		model.put("statusList", statusList);
		model.put("formatList", formatList);
		model.put("title", messageSource.getMessage("blog", null, locale));
		model.put("breadcrumb", breadcrumb.getBreadcrumb());
		model.put("recentPosts", this.blogService.findRecentPosts(Post.STATUS_PUBLIC, RECENT_POSTS));
		model.put("tags", this.blogService.findTags(Post.STATUS_PUBLIC));

		return "default/pages/blog/post/createOrEditForm";
	}

	@RequestMapping(value = "/post/delete/{id}", method = RequestMethod.GET)
	public String delete(Locale locale, @PathVariable("id") Long id, ModelMap model) {
		Post post = this.blogService.findPostById(id);

		if (post == null) {
			logger.debug("Post not found");
			throw new PostNotFoundException();
		}

		Breadcrumb breadcrumb = new Breadcrumb();

		breadcrumb.add(messageSource.getMessage("home", null, locale), "/");
		breadcrumb.add(messageSource.getMessage("blog", null, locale), "/post");
		breadcrumb.add(messageSource.getMessage("blog.delete", null, locale), null);

		model.put("post", post);
		model.put("title", messageSource.getMessage("blog", null, locale));
		model.put("breadcrumb", breadcrumb.getBreadcrumb());
		model.put("recentPosts", this.blogService.findRecentPosts(Post.STATUS_PUBLIC, RECENT_POSTS));
		model.put("tags", this.blogService.findTags(Post.STATUS_PUBLIC));

		return "default/pages/blog/post/delete";
	}

	@RequestMapping(value = "/post/delete/{id}", method = RequestMethod.POST)
	public String deleteAction(@PathVariable("id") Long id, ModelMap model) {
		Post post = this.blogService.findPostById(id);

		if (post == null) {
			logger.debug("Post not found");
			throw new PostNotFoundException();
		}

		this.blogService.deletePost(post);

		return "redirect:/post/";
	}
}
