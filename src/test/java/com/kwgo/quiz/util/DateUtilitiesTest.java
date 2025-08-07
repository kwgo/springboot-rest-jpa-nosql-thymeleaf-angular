package com.kwgo.quiz.util;

import java.sql.Date;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
/**
 * 
 * Junit Test cases for DateUtilities class
 *
 */
public class DateUtilitiesTest {
	
	/**
	 * Test parseDate method with valid test cases
	 * @throws Exception
	 */
	@Test
	public void parseDateValidTest() throws Exception {
		Assert.assertEquals(DateUtilities.parseDate("02/28/2015"), Date.valueOf("2015-02-28"));
		Assert.assertEquals(DateUtilities.parseDate("03/15/2015"), Date.valueOf("2015-03-15"));
		Assert.assertEquals(DateUtilities.parseDate("02/29/2016"), Date.valueOf("2016-02-29"));
	}

	/**
	 * Test parseDate method with invalid test cases
	 * @throws Exception
	 */
	@Test
	public void parseDateInvalidTest() throws Exception {
		Assert.assertNull(DateUtilities.parseDate(null));
		Assert.assertNull(DateUtilities.parseDate("02/29/2015"));
		Assert.assertNull(DateUtilities.parseDate("02/30/2015"));
		Assert.assertNull(DateUtilities.parseDate("22/24/2015"));
	}
}
