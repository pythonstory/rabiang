package net.rabiang.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.rabiang.forms.PostForm;
import net.rabiang.models.Post;
import net.rabiang.repositories.PostRepository;

@Service
@Transactional(readOnly = true)
public class BlogService {

	private PostRepository postRepository;

	@Autowired
	public BlogService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	public Collection<Post> findPosts() throws DataAccessException {
		return this.postRepository.findAll();
	}

	public Post findPostById(long id) {
		return this.postRepository.findById(id);
	}

	public Post findPostBySlug(String slug) {
		return this.postRepository.findBySlug(slug);
	}

	@Transactional(readOnly = false)
	public Post savePost(PostForm postForm) throws DataAccessException {
		Post post = new Post();

		post.setTitle(postForm.getTitle());
		post.setSlug(postForm.getSlug());
		post.setBody(postForm.getBody());
		post.setStatus(postForm.getStatus());
		post.setFormat(postForm.getFormat());

		return this.postRepository.save(post);
	}

	@Transactional(readOnly = false)
	public void deletePost(long id) throws DataAccessException {
		this.postRepository.delete(id);
	}
}
