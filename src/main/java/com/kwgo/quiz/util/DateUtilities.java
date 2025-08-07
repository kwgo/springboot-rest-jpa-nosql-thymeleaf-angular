package com.kwgo.quiz.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 
 * Utility class for Date
 *
 */
public class DateUtilities {
	/**
	 * Convert a string to Date
	 * 
	 * @param value Input format MM/dd/yyyy
	 * @return Date
	 */
	public static Date parseDate(String value) {
		if (!StringUtilities.isNullOrEmpty(value)) {
			try {
				SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
				java.util.Date date = dateFormat.parse(value);
				if (value.equals(dateFormat.format(date))) {
					return new Date(date.getTime());
				}
			} catch (ParseException e) {
				return null;
			}
		}
		return null;
	}
}
