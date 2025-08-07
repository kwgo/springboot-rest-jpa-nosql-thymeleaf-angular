package com.kwgo.quiz.data;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * Climate PoJo
 *
 */
@Entity
@Table(name = "eng-climate-summary")
public class Climate {

	@Id
	@Column(name = "Station_Name")
	String stationName;

	@Column(name = "Province")
	String province;

	@Column(name = "Date")
	Date date;

	@Column(name = "Mean_Temp")
	Double meanTemp;

	@Column(name = "Highest_Monthly_Maxi_Temp")
	Double highestMonthlyMaxTemp;

	@Column(name = "Lowest_Monthly_Min_Temp")
	Double lowestMonthlyMinTemp;

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getMeanTemp() {
		return meanTemp;
	}

	public void setMeanTemp(Double meanTemp) {
		this.meanTemp = meanTemp;
	}

	public Double getHighestMonthlyMaxTemp() {
		return highestMonthlyMaxTemp;
	}

	public void setHighestMonthlyMaxTemp(Double highestMonthlyMaxTemp) {
		this.highestMonthlyMaxTemp = highestMonthlyMaxTemp;
	}

	public Double getLowestMonthlyMinTemp() {
		return lowestMonthlyMinTemp;
	}

	public void setLowestMonthlyMinTemp(Double lowestMonthlyMinTemp) {
		this.lowestMonthlyMinTemp = lowestMonthlyMinTemp;
	}

	@Override
	public String toString() {
		return stationName + ", " + province;
	}
}
