package net.rabiang.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/post")
public class PostController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String postIndex() {
		return "post/index";
	}

	@RequestMapping(value = "/{slug}", method = RequestMethod.GET)
	public String postDetailSlug(@PathVariable String slug) {
		return "post/detail";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String postDetailId(@PathVariable("id") int id) {
		return "post/detail";
	}

	@RequestMapping(value = "/create", method = { RequestMethod.GET, RequestMethod.POST })
	public String postCreate() {
		return "post/create";
	}

	@RequestMapping(value = "/edit/{id}", method = { RequestMethod.GET, RequestMethod.POST })
	public String postEdit(@PathVariable("id") int id) {
		return "post/edit";
	}

	@RequestMapping(value = "/delete/{id}", method = { RequestMethod.GET, RequestMethod.POST })
	public String postDelete(@PathVariable("id") int id) {
		return "post/delete";
	}

}
