package com.kwgo.quiz.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.kwgo.quiz.data.Climate;
import com.kwgo.quiz.repository.ClimateRepository;

/**
 * 
 * Implement class for Climate Service
 *
 */
@Service
public class ClimateServiceImpl implements ClimateService {

	@Autowired
	private ClimateRepository climateRepository;

	/**
	 * {@inheritDoc}
	 */
	public Page<Climate> queryByDateRange(Date fromDate, Date toDate, int pageIndex, int pageSize) {
		List<Climate> resultList = null;
		if (fromDate == null && toDate == null) {
			resultList = climateRepository.findAllByOrderByDateAsc();
		} else if (fromDate != null && toDate == null) {
			resultList = climateRepository.findAllByDateGreaterThanEqualOrderByDateAsc(fromDate);
		} else if (fromDate == null && toDate != null) {
			resultList = climateRepository.findAllByDateLessThanEqualOrderByDateAsc(toDate);
		} else {
			resultList = climateRepository.findAllByDateGreaterThanEqualAndDateLessThanEqualOrderByDateAsc(fromDate,
					toDate);
		}

		int resultSize = resultList.size();
		List<Climate> climateList = new ArrayList<>();
		for (int index = pageIndex
				* (pageSize > 0 ? pageSize : 0); index < (pageSize > 0 ? (pageIndex + 1) * pageSize : resultSize)
						&& index < resultSize; index++) {
			climateList.add(resultList.get(index));
		}

		return new PageImpl<Climate>(climateList,
				PageRequest.of(pageIndex, pageSize > 0 ? pageSize : Integer.MAX_VALUE), resultSize);
	}

	/**
	 * {@inheritDoc}
	 */
	public Climate queryByName(String stationName) {
		return climateRepository.findByStationName(stationName);
	}

}