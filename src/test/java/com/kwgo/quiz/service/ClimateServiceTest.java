package com.kwgo.quiz.service;

import java.sql.Date;

import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.kwgo.quiz.data.Climate;
import com.kwgo.quiz.logger.Log;

/**
 * 
 * Junit Test cases for ClimateService class with Springboot
 * 
 */
@SpringBootTest
public class ClimateServiceTest {
	private static final Logger log = Log.getLogger();

	private static final int pageSize = 10;

	@Autowired
	private ClimateService climateService;

	/**
	 * Test queryByName method with an invalid data
	 * 
	 * @throws Exception
	 */
	@Test
	public void queryByNameTest1() throws Exception {
		Climate item = climateService.queryByName("QUIZ STATION");
		log.debug("queryByNameTest1 stationName=" + item);

		Assert.assertNull(item);
	}

	/**
	 * Test queryByName method with a valid data
	 * 
	 * @throws Exception
	 */
	@Test
	public void queryByNameTest2() throws Exception {
		final String stationName = "AGASSIZ RCS";
		Climate item = climateService.queryByName(stationName);
		log.debug("queryByNameTest2 stationName=" + item);

		Assert.assertNotNull(item);
		Assert.assertEquals(stationName, item.getStationName());
	}

	/**
	 * Test queryByDateRange method with a whole set query
	 * 
	 * @throws Exception
	 */
	@Test
	public void queryByDateRangeTest1() throws Exception {
		final Date fromDate = Date.valueOf("2000-01-01");
		final Date toDate = Date.valueOf("2020-03-15");

		Page<Climate> list = climateService.queryByDateRange(fromDate, toDate, 0, pageSize);
		list.forEach((item) -> log.debug("queryByDateRangeRealTest1 stationName=" + item.getStationName()));

		Assert.assertEquals(pageSize, list.getNumberOfElements());
	}

	/**
	 * Test queryByDateRange method with an empty query
	 * 
	 * @throws Exception
	 */
	@Test
	public void queryByDateRangeTest2() throws Exception {
		final Date fromDate = Date.valueOf("2000-01-01");
		final Date toDate = Date.valueOf("2015-03-15");

		Page<Climate> list = climateService.queryByDateRange(fromDate, toDate, 0, pageSize);
		list.forEach((item) -> log.debug("queryByDateRangeRealTest2 stationName=" + item.getStationName()));

		Assert.assertEquals(0, list.getNumberOfElements());
	}
}
