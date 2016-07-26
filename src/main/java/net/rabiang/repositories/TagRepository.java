package net.rabiang.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;

import net.rabiang.models.Tag;

public interface TagRepository extends Repository<Tag, Long> {

	public Tag findByName(String name) throws DataAccessException;
	
	public List<Tag> findByNameIn(Set<String> names) throws DataAccessException;

	public Tag save(Tag tag) throws DataAccessException;

	public void delete(Tag tag) throws DataAccessException;

}
