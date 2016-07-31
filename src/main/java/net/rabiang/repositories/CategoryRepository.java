package net.rabiang.repositories;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;

import net.rabiang.models.Category;

public interface CategoryRepository extends Repository<Category, Long> {

	public Category findById(Long id) throws DataAccessException;
	
	public Category save(Category category) throws DataAccessException;
	
	public void delete(Category category) throws DataAccessException;

}
