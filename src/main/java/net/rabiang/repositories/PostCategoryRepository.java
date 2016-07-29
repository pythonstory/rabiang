package net.rabiang.repositories;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;

import net.rabiang.models.PostCategory;
import net.rabiang.models.Tag;

public interface PostCategoryRepository extends Repository<PostCategory, Long> {

	public List<PostCategory> findByParent(PostCategory parent) throws DataAccessException;

	public PostCategory findByName(String name) throws DataAccessException;

	public Tag save(PostCategory category) throws DataAccessException;

	public void delete(PostCategory category) throws DataAccessException;

}
