package com.hw_9;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.GregorianCalendar;

import com.hw_9.Calendar;

class TestCalendar {

	GregorianCalendar cal = (GregorianCalendar) GregorianCalendar.getInstance();

	@ParameterizedTest
	@ValueSource(ints = {1956, 1957, 1960, 1961, 1980, 1981, 1992, 1993})
	public void should_return_correct_output(int year) {
		Calendar calendar = new Calendar(year);
		boolean expectedResult = cal.isLeapYear(year);
		boolean actualResult = calendar.isLeapYear();
		assertEquals(expectedResult, actualResult);


	}

	@ParameterizedTest
	@ValueSource(ints = {1956, 1960, 1968, 1980, 1992})
	public void Should_return_true(int year) {
		Calendar calendar = new Calendar(year);
		boolean actualResult = calendar.isLeapYear();
		assertTrue(actualResult);
		
	}

	@ParameterizedTest
	@ValueSource(ints = {1957, 1961, 1969, 1981, 1993})
	public void Should_return_false(int year) {
		Calendar calendar = new Calendar(year);
		boolean actualResult = calendar.isLeapYear();
		assertFalse(actualResult);
	}

	@ParameterizedTest
	@ValueSource( ints = {1896, 1899, 1900, 1901, 1996, 1999, 2000, 2001})
	public void should_return_boundary_test(int year) {
		if (year >= 1900 && year < 2000) {
			Calendar calendar = new Calendar(year);
			boolean expectedResult = cal.isLeapYear(year);
			boolean actualResult = calendar.isLeapYear();
			assertEquals(expectedResult, actualResult);
		} else{
			try {
				Calendar calendar = new Calendar(year);
				boolean actualResult = calendar.isLeapYear();
				assertTrue(false);
			} catch (ArrayIndexOutOfBoundsException e){
				assertTrue(e.getMessage().contains("Year isnt within 20th century"));

			}
		}
		

	}
}
