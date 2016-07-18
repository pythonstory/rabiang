package net.rabiang;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-mvc-config.xml", "classpath:spring/business-config.xml" })
@WebAppConfiguration
public class PostControllerTest {

	private MockMvc mockMvc;

	@Autowired
	WebApplicationContext wac;

	@Before
	public void setup() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void testIndex() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/post/")).andExpect(MockMvcResultMatchers.status().isOk());
	}

}
