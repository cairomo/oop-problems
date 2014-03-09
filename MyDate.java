/*
 * EXERCISE 10 MyDate class
 * A class called MyDate models a date instance
The MyDate class contains the following private instance variables:
year (int): Between 1 to 9999.
month (int): Between 1 (Jan) to 12 (Dec).
day (int): Between 1 to 28|29|30|31, where the last day depends on the month and whether it is a leap year for Feb (28|29).

It also contains the following private static variables:
strMonths (String[]), strDays (String[]), and dayInMonths (int[])

The MyDate class has the following public static methods
isLeapYear(int year): returns true if the given year is a leap year.
	A year is a leap year if it is divisible by 4 but not by 100, or it is divisible by 400.
isValidDate(int year, int month, int day): returns true if the given year, month, and day constitute a valid date.
	Assume that year is between 1 and 9999, month is between 1 (Jan) to 12 (Dec) and day shall be between 1 and 28|29|30|31
		depending on the month and whether it is a leap year on Feb.
getDayOfWeek(int year, int month, int day): returns the day of the week, where 0 for Sun, 1 for Mon, ..., 6 for Sat
	for the given date. Assume that the date is valid.
	
The MyDate class has one constructor, which takes 3 parameters: year, month and day.
	It shall invoke setDate() method (to be described later) to set the instance variables.
	
The MyDate class has the following public methods:
setDate(int year, int month, int day): It shall invoke the static method isValidDate() to verify that the given year,
	month and day constitute a valid date.
(Advanced: Otherwise, it shall throw an IllegalArgumentException with the message "Invalid year, month, or day!".)
setYear(int year): It shall verify that the given year is between 1 and 9999.
(Advanced: Otherwise, it shall throw an IllegalArgumentException with the message "Invalid year!".)
setMonth(int month): It shall verify that the given month is between 1 and 12.
(Advanced: Otherwise, it shall throw an IllegalArgumentException with the message "Invalid month!".)
setDay(int day): It shall verify that the given day is between 1 and dayMax,
	where dayMax depends on the month and whether it is a leap year for Feb.
(Advanced: Otherwise, it shall throw an IllegalArgumentException with the message "Invalid month!".)
getYear(), getMonth(), getDay(): return the value for the year, month and day, respectively.
toString(): returns a date string in the format "xxxday d mmm yyyy", e.g., "Tuesday 14 Feb 2012".
nextDay(): update this instance to the next day and return this instance.
nextMonth(): update this instance to the next month and return this instance.
nextYear(): update this instance to the next year and return this instance.
(Advanced: throw an IllegalStateException with the message "Year out of range!" if year > 9999.)
previousDay(), previousMonth(), previousYear(): similar to the above.
Write the code for the MyDate class.
 */
public class MyDate {
	private int year, month, day;
	private static String[] strMonths, strDays;
	private static int[] dayInMonths;
	
	public MyDate(int year, int month, int day) {
		setDate(year, month, day);
	}

	public static boolean isLeapYear(int year) {
		if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			return true;
		} else return false;
	}
	
	public static boolean isValidDate(int year, int month, int day) {
		if((year > 0 && year < 10000) && (month > 0 && month < 13)) {
			switch(month) {
				case 1: if(day > 0 && day < 32) return true;
					break;
				case 2: if((isLeapYear(year) && day > 0 && day < 30) || (!isLeapYear(year) && day > 0 && day < 29)) return true;
					break;
				case 3: if(day > 0 && day < 32) return true;
					break;
				case 4: if(day > 0 && day < 31) return true;
					break;
				case 5: if(day > 0 && day < 32) return true;
					break;
				case 6: if(day > 0 && day < 31) return true;
					break;
				case 7: if(day > 0 && day < 32) return true;
					break;
				case 8: if(day > 0 && day < 32) return true;
					break;	
				case 9: if(day > 0 && day < 31) return true;
					break;
				case 10: if(day > 0 && day < 32) return true;
					break;
				case 11: if(day > 0 && day < 31) return true;
					break;
				case 12: if(day > 0 && day < 32) return true;
					break;
			}
		} else return false;
		return false;
	}
	
	public static int getDayOfWeek(int year, int month, int day) {
		//Gauss's algorithm for determining the day of the week
		if((day += month) < 3) {
			year--;
		} else {
			year = year - 2;
		}
		return (23 * month / 9 + day + 4 + year/4 - year/100 + year/400) % 7;
	}
	
	public void setDate(int year, int month, int day) {
		try {
			if(isValidDate(year, month, day)) {
				this.year = year;
				this.month = month;
				this.day = day;
			}
		} catch(IllegalArgumentException e) {
			System.out.println("Invalid year, month, or day!");
		}
	}
	
	public void setYear(int year) {
		try {
			if(year > 0 && year < 10000) {
				this.year = year;
			}
		} catch(IllegalArgumentException e) {
			System.out.println("Invalid year!");
		}
	}
	
	public void setMonth(int month) {
		try {
			if(month > 0 && month < 13) {
				this.month = month;
			}
		} catch(IllegalArgumentException e) {
			System.out.println("Invalid month!");
		}
	}
	
	public void setDay(int day) {
		int dayMax = 31;
		switch(this.getMonth()) {
			case 1: dayMax = 31;
				break;
			case 2: if(isLeapYear(this.year)) dayMax = 29; else dayMax = 28;
				break;
			case 3: dayMax = 31;
				break;
			case 4: dayMax = 30;
				break;
			case 5: dayMax = 31;
				break;
			case 6: dayMax = 30;
				break;
			case 7: dayMax = 31;
				break;
			case 8: dayMax = 31;
				break;	
			case 9: dayMax = 30;
				break;
			case 10: dayMax = 31;
				break;
			case 11: dayMax = 30;
				break;
			case 12: dayMax = 31;
				break;
		}
		try {
			if(day > 0 && day <= dayMax) {
				this.day = day;
			}
		} catch(IllegalArgumentException e) {
			System.out.println("Invalid month!");
		}
	}
	 //getters below
	public int getYear() {
		return this.year;
	}
	
	public int getMonth() {
		return this.month;
	}
	
	public int getDay() {
		return this.day;
	}
	
	public String toString() {
		String pre = "";
		switch(getDayOfWeek(this.year,this.month,this.day)) {
			case 0: pre = "Sun";
				break;
			case 1: pre = "Mon";
				break;
			case 2: pre = "Tues";
				break;
			case 3: pre = "Wednes";
				break;
			case 4: pre = "Thurs";
				break;
			case 5: pre = "Fri";
				break;
			case 6: pre = "Satur";
				break;
		}
		String month = "";
		switch(this.getMonth()) {
			case 1: month = "Jan";
				break;
			case 2: month = "Feb";
				break;
			case 3: month = "Mar";
				break;
			case 4: month = "Apr";
				break;
			case 5: month = "May";
				break;
			case 6: month = "Jun";
				break;
			case 7: month = "Jul";
				break;
			case 8: month = "Aug";
				break;
			case 9: month = "Sep";
				break;
			case 10: month = "Oct";
				break;
			case 11: month = "Nov";
				break;
			case 12: month = "Dec";
				break;
		}
		return pre + "day " + this.day + " " + month + " " + this.year;
	}
	
	public MyDate nextDay() {
		int dayMax = 31;
		switch(this.getMonth()) {
			case 1: dayMax = 31;
				break;
			case 2: if(isLeapYear(this.year)) dayMax = 29; else dayMax = 28;
				break;
			case 3: dayMax = 31;
				break;
			case 4: dayMax = 30;
				break;
			case 5: dayMax = 31;
				break;
			case 6: dayMax = 30;
				break;
			case 7: dayMax = 31;
				break;
			case 8: dayMax = 31;
				break;	
			case 9: dayMax = 30;
				break;
			case 10: dayMax = 31;
				break;
			case 11: dayMax = 30;
				break;
			case 12: dayMax = 31;
				break;
		}
		if(this.getDay() != dayMax) {
			++ this.day;
		} else {
			this.day = 1;
			if(this.month == 12) {
				this.month = 1;
				++ this.year;
			}
		}
		return this;
	}
	
	public MyDate nextMonth() {
		if(this.month == 12) {
			this.month = 1;
			++ this.year;
		} else ++ this.month;
		return this;
	}
	
	public MyDate nextYear() {
		try {
			if(this.year<10000) {
				++ this.year;
				return this;
			}
		} catch(IllegalStateException e) {
			System.out.println("Year out of range!");
		}
		return this;
	}
	
	public MyDate previousDay() {
		if(this.day != 1) {
			-- this.day;
		} else {
			if(this.getMonth() != 1) {
				int dayMax = 31;
				switch(this.getMonth() -1) {
					case 1: dayMax = 31;
						break;
					case 2: if(isLeapYear(this.year)) dayMax = 29; else dayMax = 28;
						break;
					case 3: dayMax = 31;
						break;
					case 4: dayMax = 30;
						break;
					case 5: dayMax = 31;
						break;
					case 6: dayMax = 30;
						break;
					case 7: dayMax = 31;
						break;
					case 8: dayMax = 31;
						break;	
					case 9: dayMax = 30;
						break;
					case 10: dayMax = 31;
						break;
					case 11: dayMax = 30;
						break;
					case 12: dayMax = 31;
						break;
				}
				this.day = dayMax;
				-- this.month;
			} else {
				this.day = 31;
				this.month = 12;
				-- this.year;
			}
		}
		return this;
	}
	
	public MyDate previousMonth() {
		if(this.getMonth() != 1) {
			-- this.month;
		} else this.month = 12;
		return this;
	}
	
	public MyDate previousYear() {
		try {
			if(this.year > 0) {
				-- this.year;
			}
		} catch(IllegalStateException e) {
			System.out.println("Year out of range!");
		}
		return this;
	}
}
