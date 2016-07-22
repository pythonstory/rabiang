package net.rabiang.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.rabiang.forms.PostForm;
import net.rabiang.models.Post;
import net.rabiang.models.specs.PostSpecs;
import net.rabiang.repositories.PostRepository;

@Service
@Transactional(readOnly = true)
public class BlogService {

	private PostRepository postRepository;

	public static final int PAGE_SIZE = 5;

	@Autowired
	public BlogService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	public Page<Post> findPosts(int page, String keyword) throws DataAccessException {
		Specifications<Post> spec = null;

		if (keyword != null && keyword.trim().length() > 0) {
			spec = Specifications.where(PostSpecs.titleLike(keyword)).and(PostSpecs.bodyLike(keyword));
		}

		Pageable pageable = new PageRequest(page - 1, PAGE_SIZE, Sort.Direction.DESC, "createdDate");

		return this.postRepository.findAll(spec, pageable);
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
		post.setCreatedDate(new Date());
		post.setModifiedDate(new Date());

		return this.postRepository.save(post);
	}

	@Transactional(readOnly = false)
	public void deletePost(long id) throws DataAccessException {
		this.postRepository.delete(id);
	}
}
