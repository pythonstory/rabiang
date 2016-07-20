package net.rabiang.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.rabiang.services.BlogService;

@Controller
public class PostController {

	private final BlogService postService;

	@Autowired
	public PostController(BlogService postService) {
		this.postService = postService;
	}

	@RequestMapping(value = "/post", method = RequestMethod.GET)
	public String index(Model model) {
		this.postService.findPosts();

		model.addAttribute("title", "Blog - Rabiang.net");

		return "default/pages/post/index";
	}

	@RequestMapping(value = "/post/{slug}", method = RequestMethod.GET)
	public String detail(@PathVariable String slug, Model model) {
		return "default/pages/post/detail";
	}

	@RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
	public String detail(@PathVariable("id") int id, Model model) {
		return "default/pages/post/detail";
	}

	@RequestMapping(value = "/post/create", method = RequestMethod.GET)
	public String create(Model model) {
		return "default/pages/post/create";
	}

	@RequestMapping(value = "/post/create", method = RequestMethod.POST)
	public String createAction(Model model) {
		int id = 1;
		return "redirect:/post/detail/" + id;
	}

	@RequestMapping(value = "/post/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable("id") int id, Model model) {
		return "default/pages/post/edit";
	}

	@RequestMapping(value = "/post/edit/{id}", method = RequestMethod.POST)
	public String editAction(@PathVariable("id") int id, Model model) {
		return "redirect:/post/detail/" + id;
	}

	@RequestMapping(value = "/post/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id, Model model) {
		return "default/pages/post/delete";
	}

	@RequestMapping(value = "/post/delete/{id}", method = RequestMethod.POST)
	public String deleteAction(@PathVariable("id") int id, Model model) {
		return "redirect:/post/";
	}
}
