package com.isa.section1.chapter2;

public class BasicDate {

	private int year;
	private int month;
	private int day;
	
	public BasicDate(int year, int month, int day){
		this.year = year;
		this.month = month;
		this.day = day;
	}

	@Override
	public String toString() {
		return "BasicDate [year=" + year + ", month=" + month + ", day=" + day
				+ "]";
	}

	public static void main(String[] args) {
		BasicDate date = new BasicDate(2016, 2, 23);
		System.out.println(date.toString());
	}
	
}
