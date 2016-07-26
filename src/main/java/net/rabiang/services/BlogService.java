package net.rabiang.services;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.rabiang.models.Post;
import net.rabiang.models.Tag;
import net.rabiang.models.specs.PostSpecs;
import net.rabiang.repositories.PostRepository;
import net.rabiang.repositories.TagRepository;

@Service
@Transactional(readOnly = true)
public class BlogService {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private TagRepository tagRepository;

	public static final int PAGE_SIZE = 5;

	public Page<Post> findPosts(int page, String keyword) throws DataAccessException {
		Specifications<Post> spec = null;

		if (keyword != null && keyword.trim().length() > 0) {
			spec = Specifications.where(PostSpecs.titleLike(keyword)).or(PostSpecs.bodyLike(keyword));
		}

		Pageable pageable = new PageRequest(page - 1, PAGE_SIZE, Sort.Direction.DESC, "createdDate");

		return this.postRepository.findAll(spec, pageable);
	}

	public List<Post> findRecentPosts(int limit) throws DataAccessException {
		// FindAll(Pageable pageable) method runs an unnecessary "count".
		TypedQuery<Post> query = em.createQuery("SELECT p FROM Post p ORDER BY p.createdDate DESC", Post.class);

		query.setMaxResults(limit);

		return query.getResultList();
	}

	public Post findPostById(Long id) {
		return this.postRepository.findById(id);
	}

	public Post findPostBySlug(String slug) {
		return this.postRepository.findBySlug(slug);
	}

	@Transactional(readOnly = false)
	public Post savePost(Post post) throws DataAccessException {
		return this.postRepository.save(post);
	}

	@Transactional(readOnly = false)
	public void deletePost(Post post) throws DataAccessException {
		this.postRepository.delete(post);
	}

	public Tag findTagByName(String name) {
		return this.tagRepository.findByName(name);
	}

	public List<Tag> findTagsByNames(Set<String> names) {
		return this.tagRepository.findByNameIn(names);
	}

	@Transactional(readOnly = false)
	public void saveTag(Tag tag) throws DataAccessException {
		this.tagRepository.save(tag);
	}

	@Transactional(readOnly = false)
	public void deleteTag(Tag tag) throws DataAccessException {
		this.tagRepository.delete(tag);
	}
}
