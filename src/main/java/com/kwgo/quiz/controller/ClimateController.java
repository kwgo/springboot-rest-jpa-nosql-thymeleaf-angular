package com.kwgo.quiz.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kwgo.quiz.data.Climate;
import com.kwgo.quiz.logger.Log;
import com.kwgo.quiz.service.ClimateService;
import com.kwgo.quiz.util.DateUtilities;
import com.kwgo.quiz.util.StringUtilities;

/**
 * 
 * Controller class to response the climate page request
 *
 */
@RestController
@RequestMapping("/climate")
public class ClimateController {
	private static final Logger log = Log.getLogger();

	@Autowired
	private ClimateService climateService;

	/**
	 * Climate summary query mapping method
	 * 
	 * @param inFromDate Input from date
	 * @param inToDate   Input to date
	 * @param pageIndex  Page index
	 * @param pageSize   Page size
	 * @return Page properties
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Map<String, Object> queryByDateRange(@RequestParam(value = "fromDate", required = false) String inFromDate,
			@RequestParam(value = "toDate", required = false) String inToDate,
			@RequestParam(value = "pageIndex", defaultValue = "0") int pageIndex,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {

		log.debug("---- climate list rest:" + inFromDate + "-" + inToDate + "  " + pageIndex + " - " + pageSize);

		Date fromDate = DateUtilities.parseDate(inFromDate);
		Date toDate = DateUtilities.parseDate(inToDate);

		Map<String, Boolean> errors = new HashMap<>();
		boolean invalidInput = false;
		if (fromDate == null && !StringUtilities.isNullOrEmpty(inFromDate)) { // invalid from
			invalidInput = true;
			errors.put("errorFromDate", true);
		}
		if (toDate == null && !StringUtilities.isNullOrEmpty(inToDate)) { // invalid to
			invalidInput = true;
			errors.put("errorToDate", true);
		}
		if (fromDate != null && toDate != null && fromDate.compareTo(toDate) > 0) { // invalid: from > to
			invalidInput = true;
			errors.put("errorCompareDate", true);
		}

		Page<Climate> climateList;
		if (invalidInput) {
			climateList = new PageImpl<Climate>(new ArrayList<Climate>(), PageRequest.of(0, 1), 0);
		} else {
			climateList = climateService.queryByDateRange(fromDate, toDate, pageIndex, pageSize);
		}

		Map<String, Object> page = new HashMap<>();
		page.put("page", climateList);
		page.put("errors", errors);
		return page;
	}

	/**
	 * Climate detail query mapping method
	 * 
	 * @param stationName Station name
	 * @return Climate
	 */
	@RequestMapping("/detail")
	@ResponseBody
	public Climate queryByName(@RequestParam("stationName") String stationName) {
		log.debug("---- climate detail rest:" + stationName);
		return climateService.queryByName(stationName);
	}

}
