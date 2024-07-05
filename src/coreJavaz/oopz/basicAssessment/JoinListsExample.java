package coreJavaz.oopz.basicAssessment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JoinListsExample {

	public static void main(String[] args) {
        List<String> list1 = new ArrayList<String>();
        list1.add("qa1zx");
        list1.add("ws2xc");
        list1.add("ed3cv");
        list1.add("rf4vb");
        list1.add("tg5nm");

        List<String> list2 = new ArrayList<String>();
        // Corrected to add elements to list2
        list2.add("qaz1xpl");
        list2.add("qaz2xpl");
        list2.add("qaz3xpl");
        list2.add("qaz4xpl");
        list2.add("qaz5xpl");

        list1.addAll(2, list2); // Merging list2 into list1 at index 2
        System.out.print("\t" + list1);

        // Removed as it causes duplication
        // list2.addAll(list1);
        // System.out.print("\n" + list1 + "\t");

        // Using stream to join lists without modifying original lists
        List<String> joinedList = Stream.concat(list1.stream(), list2.stream()).collect(Collectors.toList());
        System.out.println("\n Joined List: " + joinedList);

        List<String> list3 = new ArrayList<String>();
        list3.add("Equity Markets");
        list3.add("Forex Trading");
        list3.add("Treasury Bills");
        list3.add("Secondary Markets");
        list3.add("Apple");
        list3.add("Banana");
        list3.add("Cherry");

        List<String> list4 = new ArrayList<String>();
        list4.add("Stock Exchanges");
        list4.add("Primary Markets");
        list4.add("Arbitrage");
        list4.add("Bid-Ask Spread");
        list4.add("Bull and Bear Markets");
        list4.add("Capital Gains");
        list4.add("Credit Rating Agencies");
        list4.add("Dividend Yield");
        list4.add("Earnings Per Share (EPS)");

        list3.addAll(2, list4); // Merging list4 into list3 at index 2
        System.out.println(list3);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the position in List 1 where List 2 should be inserted: ");
        int position = scanner.nextInt();

        if (position < 0 || position > list3.size()) { // Corrected list size check to list3
            System.out.println("Invalid position. It should be between 0 and " + list3.size());
        } else {
            // Insert list2 into list1 at the specified position
            list1.addAll(position, list4); // Corrected to add into list1

            // Display the modified list
            System.out.println("Modified List 1: " + list3);
        }

        // Sorting list1 instead of list3
        Collections.sort(list3);
        System.out.println("Sorted List 3: " + list3);

        scanner.close();
    }
}
