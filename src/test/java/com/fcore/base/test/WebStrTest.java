package com.fcore.base.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

/**
 * @RunWith 指定测试运行器
 * @SpringBootTest 带有Spring Boot支持的引导程序
 * @author Lenovo
 *
 */
@RunWith(SpringRunner.class)
//@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class WebStrTest {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	/**
	 * 修饰的方法会在所有方法被调用前被执行，而且该方法是静态的，
	 * 所以当测试类被加载后接着就会运行它，而且在内存中它只会存在一份实例，
	 * 它比较适合加载配置文件，进行初始化等等
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("this is setUpBeforeClass()...");
	}

	/**
	 * 所修饰的方法会在所有方法被调用后被执行，
	 * 通常用来对资源的清理，如关闭数据库的连接
	 * @throws Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("this is tearDownAfterClass()...");
	}

	/**
	 * 在每个测试方法之前各执行一次。
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		logger.info("this is setUp()...");
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	/**
	 * 在每个测试方法的之后各执行一次。
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		logger.info("this is tearDown()...");
	}

	@Test
	@Rollback
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
	
	/**
	 * @Ignore 所修饰的测试方法会被测试运行器忽略
	 */
	/*@Ignore*/
	@Test
	public void testIgnore(){
		logger.debug("================我肯定没有执行===============");
	}
}
