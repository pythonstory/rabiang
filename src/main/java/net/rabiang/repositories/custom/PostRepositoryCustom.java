package net.rabiang.repositories.custom;

import java.util.List;

import net.rabiang.models.Post;

public interface PostRepositoryCustom {

	List<Post> findRecentPosts(int limit);

}
