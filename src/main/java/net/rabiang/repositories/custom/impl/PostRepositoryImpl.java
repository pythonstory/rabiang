package net.rabiang.repositories.custom.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import net.rabiang.models.Post;
import net.rabiang.repositories.custom.PostRepositoryCustom;

@Repository
public class PostRepositoryImpl implements PostRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Post> findRecentPosts(int limit) {

		// Avoids unnecessary "count".
		TypedQuery<Post> query = em
				.createQuery("SELECT p"
						+ " FROM Post p"
						+ " ORDER BY p.createdDate DESC", Post.class)
				.setMaxResults(limit);

		return query.getResultList();
	}

	public Page<Post> findByTagName(String tagName, Pageable pageable) {

		long total = (long) em
				.createQuery("SELECT COUNT(p.id)"
						+ " FROM Post p"
						+ " JOIN p.tags t"
						+ " WHERE t.name = :tagName")
				.setParameter("tagName", tagName)
				.getSingleResult();

		TypedQuery<Post> query = em
				.createQuery("SELECT p FROM Post p"
						+ " JOIN FETCH p.tags t"
						+ " WHERE t.name = :tagName"
						+ " ORDER BY p.createdDate DESC", Post.class)
				.setParameter("tagName", tagName)
				.setFirstResult(pageable.getOffset())
				.setMaxResults(pageable.getPageSize());
		
		List<Post> content = query.getResultList();
		
		PageImpl<Post> page = new PageImpl<Post>(content, pageable, total);

		return page;
	}

}
