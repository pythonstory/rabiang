package net.rabiang.controllers;

import java.util.List;
import java.util.Locale;

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

import net.rabiang.forms.PostForm;
import net.rabiang.models.Post;
import net.rabiang.services.BlogService;
import net.rabiang.utils.helpers.Breadcrumb;

@Controller
public class PostController {

	public static final String SITE_NAME = "Rabiang.net";

	public static final int RECENT_POSTS = 5;

	private final Logger logger = LoggerFactory.getLogger(PostController.class);

	private final BlogService blogService;

	@Autowired
	private MessageSource messageSource;

	@Autowired
	public PostController(BlogService postService) {
		this.blogService = postService;
	}

	@RequestMapping(value = { "/post", "/post/index" }, method = RequestMethod.GET)
	public String index(Locale locale, @RequestParam(value = "p", required = false, defaultValue = "1") int p,
			@RequestParam(value = "q", required = false) String q, ModelMap model) {
		Breadcrumb breadcrumb = new Breadcrumb();

		breadcrumb.add(messageSource.getMessage("home", null, locale), "/");
		breadcrumb.add(messageSource.getMessage("blog", null, locale), null);

		model.put("title", String.format("%s - %s", messageSource.getMessage("blog", null, locale), SITE_NAME));
		model.put("breadcrumb", breadcrumb.getBreadcrumb());
		model.put("page", this.blogService.findPosts(p, q));
		model.put("recentPosts", this.blogService.findRecentPosts(RECENT_POSTS));

		return "default/pages/post/index";
	}

	@RequestMapping(value = "/post/{slug}", method = RequestMethod.GET)
	public String detail(Locale locale, @PathVariable String slug, ModelMap model) {
		Post post = this.blogService.findPostBySlug(slug);

		Breadcrumb breadcrumb = new Breadcrumb();

		breadcrumb.add(messageSource.getMessage("home", null, locale), "/");
		breadcrumb.add(messageSource.getMessage("blog", null, locale), "/post");
		breadcrumb.add(post.getTitle(), null);

		model.put("title", String.format("%s - %s", post.getTitle(), SITE_NAME));
		model.put("breadcrumb", breadcrumb.getBreadcrumb());
		model.put("post", post);

		return "default/pages/post/detail";
	}

	@RequestMapping(value = "/post/detail/{id}", method = RequestMethod.GET)
	public String detail(Locale locale, @PathVariable("id") long id, ModelMap model) {
		Post post = this.blogService.findPostById(id);

		Breadcrumb breadcrumb = new Breadcrumb();

		breadcrumb.add(messageSource.getMessage("home", null, locale), "/");
		breadcrumb.add(messageSource.getMessage("blog", null, locale), "/post");
		breadcrumb.add(post.getTitle(), null);

		model.put("title", String.format("%s - %s", post.getTitle(), SITE_NAME));
		model.put("breadcrumb", breadcrumb.getBreadcrumb());
		model.put("post", post);

		return "default/pages/post/detail";
	}

	@RequestMapping(value = "/post/create", method = RequestMethod.GET)
	public String create(Locale locale, ModelMap model) {
		model.put("form", new PostForm());
		model.put("title", String.format("%s - %s", messageSource.getMessage("blog", null, locale), SITE_NAME));

		return "default/pages/post/create_or_edit";
	}

	@RequestMapping(value = "/post/save", method = RequestMethod.POST)
	public String saveAction(@Valid @ModelAttribute PostForm form, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			model.put("form", form);

			return "default/pages/post/create_or_edit";
		} else {
			Post post = this.blogService.savePost(form);

			return "redirect:/post/detail/" + post.getId();
		}
	}

	@RequestMapping(value = "/post/edit/{id}", method = RequestMethod.GET)
	public String edit(Locale locale, @PathVariable("id") long id, ModelMap model) {
		Post post = this.blogService.findPostById(id);

		PostForm form = new PostForm();

		form.setId(post.getId());
		form.setTitle(post.getTitle());
		form.setSlug(post.getSlug());
		form.setBody(post.getBody());
		form.setStatus(post.getStatus());
		form.setFormat(post.getFormat());

		model.put("form", form);
		model.put("title", String.format("%s - %s", messageSource.getMessage("blog", null, locale), SITE_NAME));

		return "default/pages/post/create_or_edit";
	}

	@RequestMapping(value = "/post/delete/{id}", method = RequestMethod.GET)
	public String delete(Locale locale, @PathVariable("id") long id, ModelMap model) {
		model.put("title", String.format("%s - %s", messageSource.getMessage("blog", null, locale), SITE_NAME));

		return "default/pages/post/delete";
	}

	@RequestMapping(value = "/post/delete/{id}", method = RequestMethod.POST)
	public String deleteAction(@PathVariable("id") long id, ModelMap model) {
		return "redirect:/post/";
	}
}
