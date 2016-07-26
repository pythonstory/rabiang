package net.rabiang.controllers.front;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.rabiang.services.BlogService;
import net.rabiang.utils.helpers.Breadcrumb;

@Controller
public class TagController {
	public static final int RECENT_POSTS = 5;

	@Autowired
	private BlogService blogService;

	@Autowired
	private MessageSource messageSource;

	@RequestMapping(value = { "/tag", "/tag/index" }, method = RequestMethod.GET)
	public String index(Locale locale, ModelMap model) {
		Breadcrumb breadcrumb = new Breadcrumb();

		breadcrumb.add(messageSource.getMessage("home", null, locale), "/");
		breadcrumb.add(messageSource.getMessage("blog.tags", null, locale), null);

		model.put("title", messageSource.getMessage("blog.tags", null, locale));
		model.put("breadcrumb", breadcrumb.getBreadcrumb());
		model.put("recentPosts", this.blogService.findRecentPosts(RECENT_POSTS));

		return "default/pages/blog/tag/index";
	}

	@RequestMapping(value = "/tag/{name}", method = RequestMethod.GET)
	public String detail(Locale locale, @RequestParam(value = "p", required = false, defaultValue = "1") Integer p,
			@PathVariable String name, ModelMap model) {
		
		Breadcrumb breadcrumb = new Breadcrumb();

		breadcrumb.add(messageSource.getMessage("home", null, locale), "/");
		breadcrumb.add(messageSource.getMessage("blog.tags", null, locale), "/tag");
		breadcrumb.add(name, null);

		model.put("title", name);
		model.put("breadcrumb", breadcrumb.getBreadcrumb());
		model.put("recentPosts", this.blogService.findRecentPosts(RECENT_POSTS));

		return "default/pages/blog/tag/detail";
	}
}
