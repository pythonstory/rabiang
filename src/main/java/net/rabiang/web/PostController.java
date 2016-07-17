package net.rabiang.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.rabiang.service.PostService;

@Controller
@RequestMapping("/post")
public class PostController {
	
	private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String postIndex(Model model) {
		this.postService.findPosts();
		
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
