package com.hw_9;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.hw_9.Calculator;


class TestCalculator {

	Calculator calculator = new Calculator();

	@Test
	public void Should_add_two_numbers_and_return_result() {
		int expectedResult = 3 + 7;
		int actualResult = calculator.add(3, 7);
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void should_subtract_two_numbers_and_return_result() {
		int expectedResult = 10 - 2;
		int actualResult = calculator.sub(10, 2);
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void Should_multiply_two_numbers_and_return_result() {
		int expectedResult = 20 * 15;
		int actualResult = calculator.multiply(20, 15);
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void Should_divide_two_numbers_and_return_result() {
		float expectedResult = 15 / 3;
		float actualResult = calculator.divide(15, 3);
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void Should_throw_an_arithmetic_exception_if_denominator_is_zero() {
		try {
			calculator.divide(10, 0);
		} catch (ArrayIndexOutOfBoundsException e) {
			assertTrue(e.getMessage().contains("ZeroDivisionError"));
		}
	}
}
