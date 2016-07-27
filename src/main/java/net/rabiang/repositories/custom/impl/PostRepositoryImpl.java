package net.rabiang.repositories.custom.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
		TypedQuery<Post> query = em.createQuery("SELECT p FROM Post p ORDER BY p.createdDate DESC", Post.class);

		query.setMaxResults(limit);

		return query.getResultList();
	}

}
