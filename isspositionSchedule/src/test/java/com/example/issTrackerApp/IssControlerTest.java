package com.example.issTrackerApp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringRunner.class)
@SpringBootTest
public class IssControlerTest extends AbstractTest{

	@Autowired
	private WebApplicationContext webApplicationContext;
	@Autowired
	private IssControler issTestcontroller = new IssControler();
	private MockMvc mockMvc;
	
	@org.junit.jupiter.api.BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void last10IssPos() throws Exception {
	      String uri = "localhost:8080/last10Iss";
	        
	      MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)
	         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      Iss[] las10Isslist = super.mapFromJson(content, Iss[].class);
	      System.out.println(las10Isslist.length);
	      assertTrue(las10Isslist.length == 10);
	   }
	@Test
	public void addingNewPosition() {
		
	}
	
}
