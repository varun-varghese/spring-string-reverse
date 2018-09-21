package io.coding.challenge.controller;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WordReverseControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void basicTest() throws Exception {
		this.mockMvc.perform(
				post("/reverse")
					.accept(MediaType.APPLICATION_JSON_UTF8)
					.content("{\"Hello World!\"}"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("olleH dlroW!")));
	}

}
