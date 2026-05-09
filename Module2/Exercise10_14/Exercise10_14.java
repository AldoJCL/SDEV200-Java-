 package Module2.Exercise10_14;

import java.util.GregorianCalendar;

public class Exercise10_14 {
    public static void main(String[] args) {
        MyDate date1 = new MyDate();
        MyDate date2 = new MyDate(34355555133101L);

        // Print the current date object
        System.out.println("Date 1");
        System.out.println("Year: " + date1.getYear());
        System.out.println("Month: " + date1.getMonth());
        System.out.println("Day: " + date1.getDay());

        System.out.println();

        // Print the date made from elapsed milliseconds
        System.out.println("Date 2");
        System.out.println("Year: " + date2.getYear());
        System.out.println("Month: " + date2.getMonth());
        System.out.println("Day: " + date2.getDay());
    }
}

class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate() {
        // Use current time for the no-arg constructor
        GregorianCalendar calendar = new GregorianCalendar();

        year = calendar.get(GregorianCalendar.YEAR);
        month = calendar.get(GregorianCalendar.MONTH);
        day = calendar.get(GregorianCalendar.DAY_OF_MONTH);
    }

    public MyDate(long elapsedTime) {
        // Use the setDate method so the code is not repeated
        setDate(elapsedTime);
    }

    public MyDate(int year, int month, int day) {
        // Set the date directly from the values given
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public void setDate(long elapsedTime) {
        // GregorianCalendar can convert milliseconds into a real date
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTimeInMillis(elapsedTime);

        year = calendar.get(GregorianCalendar.YEAR);
        month = calendar.get(GregorianCalendar.MONTH);
        day = calendar.get(GregorianCalendar.DAY_OF_MONTH);
    }
}