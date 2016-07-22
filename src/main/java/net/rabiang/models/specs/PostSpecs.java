package net.rabiang.models.specs;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import net.rabiang.models.Post;

public class PostSpecs {

	public static Specification<Post> titleLike(final String keyword) {
		return new Specification<Post>() {
			@Override
			public Predicate toPredicate(Root<Post> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.like(root.get("title"), "%" + keyword + "%");
			}
		};
	}

	public static Specification<Post> bodyLike(final String keyword) {
		return new Specification<Post>() {
			@Override
			public Predicate toPredicate(Root<Post> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.like(root.get("body"), "%" + keyword + "%");
			}
		};
	}

}
