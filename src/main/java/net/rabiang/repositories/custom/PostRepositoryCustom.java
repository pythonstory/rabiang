package net.rabiang.repositories.custom;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.rabiang.models.Post;

public interface PostRepositoryCustom {

	public List<Post> findRecentPostsByStage(int stage, int limit);

	public Page<Post> findByStageAndTagName(int stage, String tagName, Pageable pageable);

}
