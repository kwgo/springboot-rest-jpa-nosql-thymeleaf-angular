package com.kwgo.quiz.util;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 * 
 * Junit Test cases for StringUtilities class
 *
 */
public class StringUtilitiesTest {
	/**
	 * Test isNullOrEmptyTest method
	 * @throws Exception
	 */
	@Test
	public void isNullOrEmptyTest() throws Exception {
		Assert.assertTrue(StringUtilities.isNullOrEmpty(null));
		Assert.assertTrue(StringUtilities.isNullOrEmpty(""));
		Assert.assertTrue(StringUtilities.isNullOrEmpty("    "));
		Assert.assertFalse(StringUtilities.isNullOrEmpty("QUIZ"));
		Assert.assertFalse(StringUtilities.isNullOrEmpty("  QUIZ  "));
	}

	/**
	 * Test isLengthTest method
	 * @throws Exception
	 */
	@Test
	public void isLengthTest() throws Exception {
		Assert.assertFalse(StringUtilities.isLength(null, 0));
		Assert.assertTrue(StringUtilities.isLength("", 0));
		Assert.assertTrue(StringUtilities.isLength("    ", 4));
		Assert.assertTrue(StringUtilities.isLength("QUIZ", 4));
		Assert.assertTrue(StringUtilities.isLength("  QUIZ  ", 8));
	}
}
