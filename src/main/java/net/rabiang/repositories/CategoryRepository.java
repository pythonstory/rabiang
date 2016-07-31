package net.rabiang.repositories;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;

import net.rabiang.models.Category;
import net.rabiang.repositories.custom.CategoryRepositoryCustom;

public interface CategoryRepository extends Repository<Category, Long>, CategoryRepositoryCustom {

	public Category findById(Long id) throws DataAccessException;
	
	public Category save(Category category) throws DataAccessException;

}
