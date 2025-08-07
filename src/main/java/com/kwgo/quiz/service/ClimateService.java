package com.kwgo.quiz.service;

import java.sql.Date;

import org.springframework.data.domain.Page;

import com.kwgo.quiz.data.Climate;

/**
 * 
 * Interface for Climate Service
 *
 */
public interface ClimateService {
	/**
	 * Query a climate list by date range, and order by date asc
	 * 
	 * @param fromDate  From Date
	 * @param toDate    To Data
	 * @param pageIndex Page index
	 * @param pageSize  Page size
	 * @return A climate list
	 */
	public Page<Climate> queryByDateRange(Date fromDate, Date toDate, int pageIndex, int pageSize);

	/**
	 * 
	 * Query a climate by station name
	 * 
	 * @param stationName Station name
	 * @return Climate
	 * 
	 */
	public Climate queryByName(String stationName);
}