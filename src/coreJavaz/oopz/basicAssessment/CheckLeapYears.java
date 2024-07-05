package coreJavaz.oopz.basicAssessment;

import java.util.Scanner;

public class CheckLeapYears {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a year to check if it is a leap year: ");
		int year = scan.nextInt();
		if (isLeapYear(year)) {
			System.out.println(year + " is a leap year.");
		} else {
			System.out.println(year + " is not a leap year.");
		}
		
		System.out.print("Enter the First year: ");
        int year1 = scan.nextInt();
        System.out.print("Enter the Second year: ");
        int year2 = scan.nextInt();
        int count=0;
        
        int startYear = Math.min(year1, year2);
        int endYear = Math.max(year1, year2);

        for (int i = startYear; i <= endYear; i++) {
            if (isLeapYear1(i)) {
                //System.out.println(i);
                count++;
            }
        }
        System.out.println("Leap years between " + startYear + " and " + endYear + ":"+count);

		scan.close();
	}

	public static boolean isLeapYear(int year) {

		if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isLeapYear1(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else if (year % 4 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
