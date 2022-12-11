package com.hw_9;

public class Calendar {

	int year;

	public Calendar(int year) {
		this.year = year;
	}

	public boolean isLeapYear() {
		if (!(this.year >= 1900 && this.year < 2000)) {
			throw new ArrayIndexOutOfBoundsException("Year isnt within 20th century");
		} else {
			return (this.year > 0 && this.year % 4 == 0) && (this.year % 100 != 0 || this.year % 400 == 0);
		}
	}
}
