package net.rabiang.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import net.rabiang.model.Post;

public interface PostRepository extends Repository<Post, Long> {

	public List<Post> findAll();
	
	public Post save(Post post);

}
