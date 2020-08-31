//package com.singularity.EamilClassifivationSystem;
//
//import static org.junit.Assert.assertEquals;
//
//import org.junit.Before;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import com.singularity.EamilClassifivationSystem.beans.User;
//import com.singularity.EamilClassifivationSystem.beans.UserInfo;
//
//@SpringBootTest
//class EamilClassifivationSystemApplicationTests extends AbstractTest {
//
//	@Test
//	void contextLoads() {
//	}
//	
//	@Before
//	public void setup() throws Exception {
//		String uri = "/login";
//		User user = new User();
//		user.setUsername("yuxi");
//		user.setPassword("123123");
//		String inputJson = super.mapToJson(user);
//		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
//				.contentType(MediaType.APPLICATION_JSON_VALUE)
//				.content(inputJson)).andReturn();
//		super.setUp();
//	}
//	
//
////	@Test
////	public void createUser() throws Exception {
////		String uri = "/users";
////		User user = new User();
////		user.setUsername(null);// will not pass because of the null
////		user.setPassword("123456");
////		user.setEmail("hhhh@gmail.com");
////		UserInfo ui = new UserInfo();
////		ui.setFirstName("kai");
////		ui.setLastName("chen");
////		ui.setMailAddress("1111 ahh");
////		ui.setMiddleName("k");
////		ui.setOccupation("student");
////		ui.setPhoneNumber("72222222");
////		ui.setUser(user);
////		user.setUserInfo(ui);
////		String inputJson = super.mapToJson(user);
////		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
////				.contentType(MediaType.APPLICATION_JSON_VALUE)
////				.content(inputJson)).andReturn();
////   
////		int status = mvcResult.getResponse().getStatus();
////		assertEquals(201, status);
////		String content = mvcResult.getResponse().getContentAsString();
////		assertEquals(content, "Product is created successfully");
////	}
////
//
//}
