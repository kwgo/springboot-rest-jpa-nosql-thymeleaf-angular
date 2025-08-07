package com.kwgo.quiz.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import com.kwgo.quiz.data.Climate;
import com.kwgo.quiz.logger.Log;

/**
 * 
 * Junit test cases for ClimateService class with Mockito
 *  
 */
public class ClimateServiceMockTest {
	private static final Logger log = Log.getLogger();

	private static final int pageSize = 10;

	/**
	 * Mock test queryByName method with an invalid mock
	 * @throws Exception
	 */
	@Test
	public void queryByNameTest1() throws Exception {
		final String stationName = "QUIZ STATION";

		ClimateService climateService = Mockito.mock(ClimateService.class);
		Mockito.when(climateService.queryByName(null)).thenReturn(null);

		Climate item = climateService.queryByName(stationName);
		log.debug("queryByNameTest1 stationName=" + item);

		Assert.assertNull(item);
	}

	/**
	 * Mock test queryByName method with an valid mock
	 * @throws Exception
	 */
	@Test
	public void queryByNameTest2() throws Exception {
		final String stationName = "AGASSIZ RCS";

		Climate climate = new Climate();
		climate.setStationName(stationName);

		ClimateService climateService = Mockito.mock(ClimateService.class);
		Mockito.when(climateService.queryByName(Mockito.anyString())).thenReturn(climate);

		Climate item = climateService.queryByName(stationName);
		log.debug("queryByNameTest2 stationName=" + item);

		Assert.assertNotNull(item);
		Assert.assertEquals(stationName, item.getStationName());
	}

	/**
	 * Mock test queryByDateRange method with a whole set query
	 * 
	 * @throws Exception
	 */
	@Test
	public void queryByDateRangeTest1() throws Exception {
		final Date date = Date.valueOf("2000-01-01");

		List<Climate> climateList = new ArrayList<>();
		for (int index = 0; index < pageSize; index++) {
			Climate climate = new Climate();
			climate.setStationName("mock station " + index);
			climate.setDate(date);
			climateList.add(climate);
		}

		Page<Climate> page = new PageImpl<Climate>(climateList, PageRequest.of(0, pageSize), climateList.size());

		ClimateService climateService = Mockito.mock(ClimateService.class);
		Mockito.when(climateService.queryByDateRange(Mockito.<Date>any(), Mockito.<Date>any(), Mockito.anyInt(),
				Mockito.anyInt())).thenReturn(page);

		Page<Climate> list = climateService.queryByDateRange(date, date, 0, pageSize);
		list.forEach((item) -> log.debug("queryByDateRangeRealTest1 stationName=" + item.getStationName()));

		Assert.assertEquals(10, list.getNumberOfElements());
		list.forEach((item) -> Assert.assertEquals(date, item.getDate()));
	}

	/**
	 * Mock test queryByDateRange method with an empty query
	 * 
	 * @throws Exception
	 */
	@Test
	public void queryByDateRangeTest2() throws Exception {
		Page<Climate> page = new PageImpl<Climate>(new ArrayList<>(), PageRequest.of(0, pageSize), 0);

		ClimateService climateService = Mockito.mock(ClimateService.class);
		Mockito.when(climateService.queryByDateRange(Mockito.<Date>any(), Mockito.<Date>any(), Mockito.anyInt(),
				Mockito.anyInt())).thenReturn(page);

		Page<Climate> list = climateService.queryByDateRange(null, null, 0, pageSize);
		list.forEach((item) -> log.debug("queryByDateRangeRealTest2 stationName=" + item.getStationName()));

		Assert.assertEquals(0, list.getNumberOfElements());
	}
}
