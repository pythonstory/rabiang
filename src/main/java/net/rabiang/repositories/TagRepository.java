package net.rabiang.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import net.rabiang.models.Tag;
import net.rabiang.models.results.TagCount;

public interface TagRepository extends Repository<Tag, Long> {

	public Tag findByName(String name) throws DataAccessException;

	public List<Tag> findByNameIn(Set<String> names) throws DataAccessException;
	
	@Query(value = "SELECT new net.rabiang.models.results.TagCount(t.name, count(t.id)) FROM Tag t JOIN t.posts p WHERE p.stage = :stage GROUP BY t.id ORDER BY t.name")
	public List<TagCount> findAll(@Param("stage") int stage);
	
	public Tag save(Tag tag) throws DataAccessException;

	public void delete(Tag tag) throws DataAccessException;

}
