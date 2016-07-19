package net.rabiang.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.rabiang.models.Post;
import net.rabiang.repositories.PostRepository;

@Service
public class PostService {
	
	private PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
	
	@Transactional(readOnly = true)
	public Collection<Post> findPosts() throws DataAccessException {
		return this.postRepository.findAll();
	}

}
