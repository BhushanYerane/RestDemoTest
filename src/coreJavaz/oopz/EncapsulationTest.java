package coreJavaz.oopz;

import java.util.ArrayList;
import java.util.List;

public class EncapsulationTest {
	
	public static void main(String[] args) 
	{
		List<libraryItem1> libraryItems = new ArrayList<>();
		
		libraryItems.add(new libraryItem2_Books("laal ji", "B001", "Pandu"));
		libraryItems.add(new libraryItem3_DVD("seth ji", "D001", "Bhoola"));
        
        for (libraryItem1 item : libraryItems) {
            item.checkOut();
            item.returnItem();
        }
	}
}
