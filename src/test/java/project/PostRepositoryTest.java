package project;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.rabiang.model.Post;
import net.rabiang.repository.PostRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-mvc-config.xml", "classpath:spring/business-config.xml" })
public class PostRepositoryTest {

	@Autowired
	private PostRepository postRepository;

	@Test
	public void testCreatePost() {
		Post actual = new Post();
		actual.setTitle("Test Post");
		Post expected = postRepository.save(actual);

		assertEquals("created", expected.getTitle(), "Test Post");
	}

}
