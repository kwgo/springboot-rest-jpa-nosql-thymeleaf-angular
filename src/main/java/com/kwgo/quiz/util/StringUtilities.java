package com.kwgo.quiz.util;

/**
 * 
 * Utility class for String
 * 
 */
public class StringUtilities {
	/**
	 * To check if the string is real 'empty'
	 * 
	 * @param value Input string
	 * @return true:empty; false: not empty
	 */
	public static boolean isNullOrEmpty(String value) {
		return value == null || value.trim().isEmpty();
	}

	/**
	 * To check the string length
	 * 
	 * @param value  Input string
	 * @param length Input length
	 * @return true:length is correct; false: length is incorrect
	 */
	public static boolean isLength(String value, int length) {
		return value != null && value.length() == length;
	}

}
