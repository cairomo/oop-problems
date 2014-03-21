/*
 * /*
 * Exercise 1.9
 * 
 * A class called MyTime, which models a time instance, is designed as shown in the class diagram.
It contains the following private instance variables:
hour: between 0 to 23.
minute: between 0 to 59.
Second: between 0 to 59.
The constructor shall invoke the setTime() method (to be described later) to set the instance variable.
It contains the following public methods:
setTime(int hour, int minute, int second): It shall check if the given hour, minute and second are valid before setting the instance variables.
(Advanced: Otherwise, it shall throw an IllegalArgumentException with the message "Invalid hour, minute, or second!".)
Setters setHour(int hour), setMinute(int minute), setSecond(int second): It shall check if the parameters are valid, similar to the above.
Getters getHour(), getMinute(), getSecond().
toString(): returns "HH:MM:SS".
nextSecond(): Update this instance to the next second and return this instance. Take note that the nextSecond() of 23:59:59 is 00:00:00.
nextMinute(), nextHour(), previousSecond(), previousMinute(), previousHour(): similar to the above.
Write the code for the MyTime class. Also write a test program (called TestMyTime) to test all the methods defined in the MyTime class.
 */
package oneseven;

public class TestMyTime {
	public static void main(String[] args) {      
		MyTime a = new MyTime(10,59,34);
		System.out.println(a.toString() + " one hour later is " + (a.nextHour()).toString());
		System.out.println(a.toString() + " one minute later is " + (a.nextMinute()).toString());
		MyTime b = new MyTime(0,0,0);
		System.out.println("hour of " + b.toString() + " is " + b.getHour());
		System.out.println(b.toString() + " one second before is " + (b.previousSecond()).toString());
	}
}
