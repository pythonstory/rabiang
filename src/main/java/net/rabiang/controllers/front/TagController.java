package net.rabiang.controllers.front;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.rabiang.models.Post;
import net.rabiang.models.results.TagCount;
import net.rabiang.services.BlogService;
import net.rabiang.utils.exceptions.TagNotFoundException;
import net.rabiang.utils.helpers.Breadcrumb;

@Controller
public class TagController {
	public static final int RECENT_POSTS = 5;

	private final Logger logger = LoggerFactory.getLogger(TagController.class);

	@Autowired
	private BlogService blogService;

	@Autowired
	private MessageSource messageSource;

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@ModelAttribute("recentPosts")
	public List<Post> populateRecentPosts() {
		return this.blogService.findRecentPosts(Post.STATUS_PUBLIC, RECENT_POSTS);
	}

	@ModelAttribute("tags")
	public List<TagCount> populateTags() {
		return this.blogService.findTags(Post.STATUS_PUBLIC);
	}

	@RequestMapping(value = { "/tag", "/tag/index" }, method = RequestMethod.GET)
	public String index(Locale locale, ModelMap model) {
		List<TagCount> tags = this.blogService.findTags(Post.STATUS_PUBLIC);

		Breadcrumb breadcrumb = new Breadcrumb();

		breadcrumb.add(messageSource.getMessage("home", null, locale), "/");
		breadcrumb.add(messageSource.getMessage("blog.tags", null, locale), null);

		model.put("tags", tags);
		model.put("title", messageSource.getMessage("blog.tags", null, locale));
		model.put("breadcrumb", breadcrumb.getBreadcrumb());

		return "default/pages/blog/tag/index";
	}

	@RequestMapping(value = "/tag/{tagName}", method = RequestMethod.GET)
	public String detail(Locale locale, @RequestParam(value = "p", required = false, defaultValue = "1") Integer p,
			@PathVariable String tagName, ModelMap model) {
		Page<Post> page = this.blogService.findPostsByStageAndTagName(p, Post.STATUS_PUBLIC, tagName);

		if (page.getTotalPages() == 0) {
			logger.debug("Tag not found");
			throw new TagNotFoundException();
		}

		Breadcrumb breadcrumb = new Breadcrumb();

		breadcrumb.add(messageSource.getMessage("home", null, locale), "/");
		breadcrumb.add(messageSource.getMessage("blog.tags", null, locale), "/tag");
		breadcrumb.add(tagName, null);

		model.put("page", page);
		model.put("title", tagName);
		model.put("breadcrumb", breadcrumb.getBreadcrumb());

		return "default/pages/blog/post/index";
	}
}
