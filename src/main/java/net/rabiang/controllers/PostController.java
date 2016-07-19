package net.rabiang.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.rabiang.services.PostService;

@Controller
@RequestMapping("/post")
public class PostController {

	private final PostService postService;

	@Autowired
	public PostController(PostService postService) {
		this.postService = postService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		this.postService.findPosts();

		return "default/post/index";
	}

	@RequestMapping(value = "/{slug}", method = RequestMethod.GET)
	public String detail(@PathVariable String slug, Model model) {
		return "default/post/detail";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String detail(@PathVariable("id") int id, Model model) {
		return "default/post/detail";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Model model) {
		return "default/post/create";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createAction(Model model) {
		int id = 1;
		return "redirect:/post/detail/" + id;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable("id") int id, Model model) {
		return "default/post/edit";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String editAction(@PathVariable("id") int id, Model model) {
		return "redirect:/post/detail/" + id;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id, Model model) {
		return "default/post/delete";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public String deleteAction(@PathVariable("id") int id, Model model) {
		return "redirect:/post/";
	}

}
