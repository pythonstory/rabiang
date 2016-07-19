package net.rabiang;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import net.rabiang.models.Post;
import net.rabiang.repositories.PostRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-mvc-config.xml", "classpath:spring/business-config.xml" })
public class PostRepositoryTest {

	@Autowired
	private PostRepository postRepository;

	@Test
	@Transactional
	public void testCRUD() {
		Post actual = new Post();
		actual.setTitle("Test Post");
		actual.setSlug("test-post");

		Post expected = postRepository.save(actual);
		assertEquals("created", expected.getTitle(), "Test Post");

		expected = postRepository.findById(1L);
		assertEquals("retrieved by id", expected.getTitle(), "Test Post");

		expected = postRepository.findBySlug("test-post");
		assertEquals("retrieved by slug", expected.getTitle(), "Test Post");

		postRepository.delete(expected.getId());
		expected = postRepository.findById(1L);
		assertEquals("deleted", null, expected);
	}

}
