package net.rabiang.repositories;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.Repository;

import net.rabiang.models.Post;
import net.rabiang.repositories.custom.PostRepositoryCustom;

public interface PostRepository extends Repository<Post, Long>, PostRepositoryCustom {

	public Page<Post> findAll(Specification<Post> spec, Pageable pageable) throws DataAccessException;

	public Post findById(Long id) throws DataAccessException;

	public Post findBySlug(String slug) throws DataAccessException;

	public Post save(Post post) throws DataAccessException;

	public void delete(Post post) throws DataAccessException;

}
