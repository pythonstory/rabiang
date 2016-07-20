package net.rabiang.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.rabiang.models.Post;
import net.rabiang.repositories.PostRepository;

@Service
public class BlogService {

	private PostRepository postRepository;

	@Autowired
	public BlogService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	@Transactional(readOnly = true)
	public Collection<Post> findPosts() throws DataAccessException {
		return this.postRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Post findPostById(long id) {
		return this.postRepository.findById(id);
	}

	@Transactional(readOnly = true)
	public Post findPostBySlug(String slug) {
		return this.postRepository.findBySlug(slug);
	}

	@Transactional
	public void savePost(Post post) throws DataAccessException {
		this.postRepository.save(post);
	}

	@Transactional
	public void deletePost(long id) throws DataAccessException {
		this.postRepository.delete(id);
	}
}
