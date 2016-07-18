package net.rabiang.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;

import net.rabiang.model.Post;

public interface PostRepository extends Repository<Post, Long> {

	public Collection<Post> findAll() throws DataAccessException;

	public Post findById(long id) throws DataAccessException;

	public Post findBySlug(String slug) throws DataAccessException;

	public Post save(Post post) throws DataAccessException;

	public void delete(Long id) throws DataAccessException;

}
