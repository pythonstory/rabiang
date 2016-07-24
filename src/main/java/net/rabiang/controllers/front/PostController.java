package net.rabiang.controllers.front;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.rabiang.models.Post;
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

	@RequestMapping(value = { "/post", "/post/index" }, method = RequestMethod.GET)
	public String index(Locale locale, @RequestParam(value = "p", required = false, defaultValue = "1") Integer p,
			@RequestParam(value = "q", required = false) String q, ModelMap model) {
		Breadcrumb breadcrumb = new Breadcrumb();

		breadcrumb.add(messageSource.getMessage("home", null, locale), "/");
		breadcrumb.add(messageSource.getMessage("blog", null, locale), null);

		model.put("page", this.blogService.findPosts(p, q));
		model.put("title", messageSource.getMessage("blog", null, locale));
		model.put("breadcrumb", breadcrumb.getBreadcrumb());
		model.put("recentPosts", this.blogService.findRecentPosts(RECENT_POSTS));

		return "default/pages/post/index";
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
		model.put("recentPosts", this.blogService.findRecentPosts(RECENT_POSTS));

		return "default/pages/post/detail";
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
		model.put("recentPosts", this.blogService.findRecentPosts(RECENT_POSTS));

		return "default/pages/post/detail";
	}

	@RequestMapping(value = "/post/create", method = RequestMethod.GET)
	public String create(Locale locale, ModelMap model) {
		Post post = new Post();

		Map<Integer, String> statusList = new HashMap<Integer, String>();
		statusList.put(Post.STATUS_DRAFT, messageSource.getMessage("blog.draft", null, locale));
		statusList.put(Post.STATUS_PUBLIC, messageSource.getMessage("blog.public", null, locale));

		Map<Integer, String> formatList = new HashMap<Integer, String>();
		formatList.put(Post.FORMAT_TEXT, messageSource.getMessage("blog.format_text", null, locale));
		formatList.put(Post.FORMAT_HTML, messageSource.getMessage("blog.format_html", null, locale));
		formatList.put(Post.FORMAT_MARKDOWN, messageSource.getMessage("blog.format_markdown", null, locale));

		model.put("post", post);
		model.put("statusList", statusList);
		model.put("formatList", formatList);
		model.put("title", messageSource.getMessage("blog", null, locale));

		return "default/pages/post/create_or_edit";
	}

	@RequestMapping(value = "/post/save", method = RequestMethod.POST)
	public String saveAction(Locale locale, @Valid @ModelAttribute Post post, BindingResult result, ModelMap model) {
		if (!result.hasErrors()) {
			this.blogService.savePost(post);

			return "redirect:/post/detail/" + post.getId();
		}

		Map<Integer, String> statusList = new HashMap<Integer, String>();
		statusList.put(Post.STATUS_DRAFT, messageSource.getMessage("blog.draft", null, locale));
		statusList.put(Post.STATUS_PUBLIC, messageSource.getMessage("blog.public", null, locale));

		Map<Integer, String> formatList = new HashMap<Integer, String>();
		formatList.put(Post.FORMAT_TEXT, messageSource.getMessage("blog.format_text", null, locale));
		formatList.put(Post.FORMAT_HTML, messageSource.getMessage("blog.format_html", null, locale));
		formatList.put(Post.FORMAT_MARKDOWN, messageSource.getMessage("blog.format_markdown", null, locale));

		model.put("post", post);
		model.put("statusList", statusList);
		model.put("formatList", formatList);
		model.put("title", messageSource.getMessage("blog", null, locale));

		return "default/pages/post/create_or_edit";
	}

	@RequestMapping(value = "/post/edit/{id}", method = RequestMethod.GET)
	public String edit(Locale locale, @PathVariable("id") Long id, ModelMap model) {
		Post post = this.blogService.findPostById(id);

		if (post == null) {
			throw new PostNotFoundException();
		}

		Map<Integer, String> statusList = new HashMap<Integer, String>();
		statusList.put(Post.STATUS_DRAFT, messageSource.getMessage("blog.draft", null, locale));
		statusList.put(Post.STATUS_PUBLIC, messageSource.getMessage("blog.public", null, locale));

		Map<Integer, String> formatList = new HashMap<Integer, String>();
		formatList.put(Post.FORMAT_TEXT, messageSource.getMessage("blog.format_text", null, locale));
		formatList.put(Post.FORMAT_HTML, messageSource.getMessage("blog.format_html", null, locale));
		formatList.put(Post.FORMAT_MARKDOWN, messageSource.getMessage("blog.format_markdown", null, locale));

		model.put("post", post);
		model.put("statusList", statusList);
		model.put("formatList", formatList);
		model.put("title", messageSource.getMessage("blog", null, locale));

		return "default/pages/post/create_or_edit";
	}

	@RequestMapping(value = "/post/delete/{id}", method = RequestMethod.GET)
	public String delete(Locale locale, @PathVariable("id") Long id, ModelMap model) {
		Post post = this.blogService.findPostById(id);

		if (post == null) {
			logger.debug("Post not found");
			throw new PostNotFoundException();
		}

		model.put("title", messageSource.getMessage("blog", null, locale));

		return "default/pages/post/delete";
	}

	@RequestMapping(value = "/post/delete/{id}", method = RequestMethod.POST)
	public String deleteAction(@PathVariable("id") Long id, ModelMap model) {
		Post post = this.blogService.findPostById(id);

		if (post == null) {
			logger.debug("Post not found");
			throw new PostNotFoundException();
		}

		return "redirect:/post/";
	}
}
