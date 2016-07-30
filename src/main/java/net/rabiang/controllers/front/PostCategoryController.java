package net.rabiang.controllers.front;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.rabiang.models.Post;
import net.rabiang.services.BlogService;
import net.rabiang.utils.helpers.Breadcrumb;
import net.rabiang.utils.helpers.Node;

@Controller
public class PostCategoryController {
	public static final int RECENT_POSTS = 5;

	@Autowired
	private BlogService blogService;

	@Autowired
	private MessageSource messageSource;

	@RequestMapping(value = { "/category", "/category/index" }, method = RequestMethod.GET)
	public String index(Locale locale, ModelMap model) {

		Node<String> root = new Node<String>("post");
		root.addChild("node0");
		root.addChild("node1");
		Node<String> node2 = root.addChild("node2");

		Node<String> node20 = node2.addChild("node20");
		node2.addChild("node21");

		node20.addChild("node210");

		Breadcrumb breadcrumb = new Breadcrumb();

		breadcrumb.add(messageSource.getMessage("home", null, locale), "/");
		breadcrumb.add(messageSource.getMessage("blog.categories", null, locale), null);

		model.put("node", root);
		model.put("title", messageSource.getMessage("blog.categories", null, locale));
		model.put("breadcrumb", breadcrumb.getBreadcrumb());
		model.put("recentPosts", this.blogService.findRecentPosts(Post.STATUS_PUBLIC, RECENT_POSTS));

		return "default/pages/blog/category/index";
	}

	@RequestMapping(value = "/category/{slug}", method = RequestMethod.GET)
	public String detail(Locale locale, @RequestParam(value = "p", required = false, defaultValue = "1") Integer p,
			ModelMap model) {
		Breadcrumb breadcrumb = new Breadcrumb();

		breadcrumb.add(messageSource.getMessage("home", null, locale), "/");
		breadcrumb.add(messageSource.getMessage("blog.categories", null, locale), null);

		model.put("title", messageSource.getMessage("blog.categories", null, locale));
		model.put("breadcrumb", breadcrumb.getBreadcrumb());
		model.put("recentPosts", this.blogService.findRecentPosts(Post.STATUS_PUBLIC, RECENT_POSTS));

		return "default/pages/blog/post/index";
	}

	@RequestMapping(value = "/category/create", method = RequestMethod.GET)
	public String create(Locale locale, ModelMap model) {
		//CategoryForm form = new CategoryForm();

		Breadcrumb breadcrumb = new Breadcrumb();

		breadcrumb.add(messageSource.getMessage("home", null, locale), "/");
		breadcrumb.add(messageSource.getMessage("blog.categories", null, locale), null);

		//model.put("form", form);
		model.put("title", messageSource.getMessage("blog.categories", null, locale));
		model.put("breadcrumb", breadcrumb.getBreadcrumb());
		model.put("recentPosts", this.blogService.findRecentPosts(Post.STATUS_PUBLIC, RECENT_POSTS));

		return "default/pages/blog/category/create_or_edit";
	}

	@RequestMapping(value = "/category/save", method = RequestMethod.POST)
	public String saveAction(Locale locale, ModelMap model) {
		

		Breadcrumb breadcrumb = new Breadcrumb();

		breadcrumb.add(messageSource.getMessage("home", null, locale), "/");
		breadcrumb.add(messageSource.getMessage("blog.categories", null, locale), null);

		model.put("title", messageSource.getMessage("blog.categories", null, locale));
		model.put("breadcrumb", breadcrumb.getBreadcrumb());
		model.put("recentPosts", this.blogService.findRecentPosts(Post.STATUS_PUBLIC, RECENT_POSTS));

		return "default/pages/blog/category/create_or_edit";
	}

	@RequestMapping(value = "/category/edit/{id}", method = RequestMethod.GET)
	public String edit(Locale locale, ModelMap model) {
		Breadcrumb breadcrumb = new Breadcrumb();

		breadcrumb.add(messageSource.getMessage("home", null, locale), "/");
		breadcrumb.add(messageSource.getMessage("blog.categories", null, locale), null);

		model.put("title", messageSource.getMessage("blog.categories", null, locale));
		model.put("breadcrumb", breadcrumb.getBreadcrumb());
		model.put("recentPosts", this.blogService.findRecentPosts(Post.STATUS_PUBLIC, RECENT_POSTS));

		return "default/pages/blog/category/create_or_edit";
	}

	@RequestMapping(value = "/category/delete/{id}", method = RequestMethod.GET)
	public String delete(Locale locale, ModelMap model) {
		Breadcrumb breadcrumb = new Breadcrumb();

		breadcrumb.add(messageSource.getMessage("home", null, locale), "/");
		breadcrumb.add(messageSource.getMessage("blog.categories", null, locale), null);

		model.put("title", messageSource.getMessage("blog.categories", null, locale));
		model.put("breadcrumb", breadcrumb.getBreadcrumb());
		model.put("recentPosts", this.blogService.findRecentPosts(Post.STATUS_PUBLIC, RECENT_POSTS));

		return "default/pages/blog/category/delete";
	}

	@RequestMapping(value = "/category/delete/{id}", method = RequestMethod.POST)
	public String deleteAction() {
		return "default/pages/blog/category/delete";
	}

}
