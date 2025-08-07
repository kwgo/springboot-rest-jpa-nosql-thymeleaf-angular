package com.kwgo.quiz.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * 
 * Junit Test cases for ClimateController class with SpringMockMvc
 * 
 */
@SpringBootTest
@AutoConfigureMockMvc
public class ClimateControllerTest {
	@Autowired
	private MockMvc mvc;

	/**
	 * Test first page
	 * 
	 * @throws Exception
	 */
	@Test
	public void firstPageTest() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/")).andExpect(MockMvcResultMatchers.status().isOk());
		mvc.perform(MockMvcRequestBuilders.get("/climate")).andExpect(MockMvcResultMatchers.status().isOk());
	}

	/**
	 * Test queryByDateRange controller method without from and to date
	 * 
	 * @throws Exception
	 */
	@Test
	public void queryByDateRangeTest1() throws Exception {
		mvc.perform(MockMvcRequestBuilders.post("/climate/list").param("pageIndex", "0").param("pageSize", "0"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.jsonPath("page.content").isArray()).andExpect(
						MockMvcResultMatchers.jsonPath("page.content", Matchers.hasSize(Matchers.greaterThan(1000))));
	}

	/**
	 * Test queryByDateRange controller method with only from date
	 * 
	 * @throws Exception
	 */
	@Test
	public void queryByDateRangeTest2() throws Exception {
		final String fromDate = "01/01/2015";
		mvc.perform(MockMvcRequestBuilders.post("/climate/list").param("fromDate", fromDate).param("pageIndex", "0")
				.param("pageSize", "0")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.jsonPath("page.content").isArray()).andExpect(
						MockMvcResultMatchers.jsonPath("page.content", Matchers.hasSize(Matchers.greaterThan(1000))));
	}

	/**
	 * Test queryByDateRange controller method with only to date
	 * 
	 * @throws Exception
	 */
	@Test
	public void queryByDateRangeTest3() throws Exception {
		final String toDate = "12/12/2020";
		mvc.perform(MockMvcRequestBuilders.post("/climate/list").param("toDate", toDate).param("pageIndex", "0")
				.param("pageSize", "0")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.jsonPath("page.content").isArray()).andExpect(
						MockMvcResultMatchers.jsonPath("page.content", Matchers.hasSize(Matchers.greaterThan(1000))));
	}

	/**
	 * Test queryByDateRange controller method with an empty return
	 * 
	 * @throws Exception
	 */
	@Test
	public void queryByDateRangeTest4() throws Exception {
		final String fromDate = "01/01/2000";
		final String toDate = "12/12/2010";
		mvc.perform(MockMvcRequestBuilders.post("/climate/list").param("fromDate", fromDate).param("toDate", toDate)
				.param("pageIndex", "0").param("pageSize", "10")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.jsonPath("page.content").isArray())
				.andExpect(MockMvcResultMatchers.jsonPath("page.content", Matchers.hasSize(0)));
	}

	/**
	 * Test queryByDateRange controller method with a data set return
	 * 
	 * @throws Exception
	 */
	@Test
	public void queryByDateRangeTest5() throws Exception {
		final String fromDate = "01/01/2015";
		final String toDate = "12/12/2020";
		mvc.perform(MockMvcRequestBuilders.post("/climate/list").param("fromDate", fromDate).param("toDate", toDate)
				.param("pageIndex", "0").param("pageSize", "10")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.jsonPath("page.content").isArray())
				.andExpect(MockMvcResultMatchers.jsonPath("page.content", Matchers.hasSize(10)));
	}

	/**
	 * Test queryByName controller method with an invalid data
	 * 
	 * @throws Exception
	 */
	@Test
	public void queryByNameTest1() throws Exception {
		final String stationName = "QUIZ STATION";
		mvc.perform(MockMvcRequestBuilders.post("/climate/detail").param("stationName", stationName))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string(Matchers.emptyOrNullString()));
	}

	/**
	 * Test queryByName controller method with a valid data
	 * 
	 * @throws Exception
	 */
	@Test
	public void queryByNameTest2() throws Exception {
		final String stationName = "AGASSIZ RCS";
		mvc.perform(MockMvcRequestBuilders.post("/climate/detail").param("stationName", stationName))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.jsonPath("stationName", Matchers.equalTo(stationName)));
	}
}
