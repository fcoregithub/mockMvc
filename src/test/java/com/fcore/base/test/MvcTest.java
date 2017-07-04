package com.fcore.base.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@RunWith(SpringRunner.class)
@WebMvcTest  //这种方式需要 @MockBean来指定service
public class MvcTest {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired    
	private MockMvc mockMvc; 
	
	@Test
	public void add() throws Exception {
		MultiValueMap<String, String> formData = new LinkedMultiValueMap<String, String>();
		formData.add("str", "test001");
		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.post("/rest/add")
						// .param("str", "test001")
						.params(formData).accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
				/*.andDo(MockMvcResultHandlers.print())*/
				.andReturn();
		logger.error("==================" + result.getResponse().getContentAsString());
	}
}
