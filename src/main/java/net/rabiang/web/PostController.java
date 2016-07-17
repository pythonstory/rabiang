package net.rabiang.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/post")
public class PostController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String postIndex(Model model) {
		return "post/index";
	}

	@RequestMapping(value = "/{slug}", method = RequestMethod.GET)
	public String postDetailSlug(@PathVariable String slug, Model model) {
		return "post/detail";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String postDetailId(@PathVariable("id") int id, Model model) {
		return "post/detail";
	}

	@RequestMapping(value = "/create", method = { RequestMethod.GET, RequestMethod.POST })
	public String postCreate(Model model) {
		return "post/create";
	}

	@RequestMapping(value = "/edit/{id}", method = { RequestMethod.GET, RequestMethod.POST })
	public String postEdit(@PathVariable("id") int id, Model model) {
		return "post/edit";
	}

	@RequestMapping(value = "/delete/{id}", method = { RequestMethod.GET, RequestMethod.POST })
	public String postDelete(@PathVariable("id") int id, Model model) {
		return "post/delete";
	}

}
