package com.kwgo.quiz.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kwgo.quiz.data.Climate;

/**
 * 
 * Interface to build JAP methods for database query
 *
 */
@Repository
public interface ClimateRepository extends JpaRepository<Climate, String> {

	/**
	 * 
	 * Query all climate list, and order by date asc
	 * 
	 * @return A climate list
	 */
	public List<Climate> findAllByOrderByDateAsc();

	/**
	 * 
	 * Query a climate list by to date, and order by date asc
	 * 
	 * @param fromDate From Date
	 * @return A climate list
	 */
	public List<Climate> findAllByDateGreaterThanEqualOrderByDateAsc(Date fromDate);

	/**
	 * 
	 * Query a climate list by from date, and order by date asc
	 * 
	 * @param toDate To Data
	 * @return A climate list
	 */
	public List<Climate> findAllByDateLessThanEqualOrderByDateAsc(Date toDate);

	/**
	 * 
	 * Query a climate list by date range, and order by date asc
	 * 
	 * @param fromDate From Date
	 * @param toDate   To Data
	 * @return A climate list
	 */
	public List<Climate> findAllByDateGreaterThanEqualAndDateLessThanEqualOrderByDateAsc(Date fromDate, Date toDate);

	/**
	 * 
	 * Query a climate by station name
	 * 
	 * @param stationName Station name
	 * @return Climate
	 * 
	 */
	public Climate findByStationName(String stationName);

}