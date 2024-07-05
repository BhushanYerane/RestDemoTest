package coreJavaz.oopz.basicAssessment.basics;

public class compareStrings {

	public static void main(String[] args) {
		String str1 = "Hello";
		String str2 = "Hello";
		String str3 = "World";
		String str4 = "hello";
		String str5 = new String("Hello");
		String str6 = new String("Hello");
		String str7 = "hELlO";
		String str8 = "olleH";
		
		//equals() method
		if(str1.equals(str2)) {
			System.out.println("String equals");			
		}else {
			System.out.println("String not equals");
		}
		
		if(str1.equals(str4)) {
			System.out.println("String equals");			
		}else {
			System.out.println("String not equals");
		}
		
		if(str1.equals(str7)) {
			System.out.println("String equals");			
		}else {
			System.out.println("String not equals");
		}
		
		if(str1.equals(str8)) {
			System.out.println("String equals");			
		}else {
			System.out.println("String not equals");
		}
		
		System.out.println("-----------------------");
		
		//equalsIgnoreCase() Method
		if(str1.equalsIgnoreCase(str7)) {
			System.out.println("String equals");			
		}else {
			System.out.println("String not equals");
		}
			
		if(str1.equalsIgnoreCase(str4)) {
			System.out.println("String equals");			
		}else {
			System.out.println("String not equals");
		}
		if(str1.equalsIgnoreCase(str3)) {
			System.out.println("String equals");			
		}else {
			System.out.println("String not equals");
		}
		
		System.out.println("-----------------------");
		
		//compareTo() method
		
		int result1 = str1.compareTo(str4);
		System.out.println("Comparison result of str1 and str4: " + result1);
		
		int result2= str1.compareTo(str7);
		System.out.println("Comparison result of str1 and str7: " + result2);
		int result21= str1.compareToIgnoreCase(str7);
		System.out.println("Comparison result of str1 and str7: " + result21);
		
		int result3= str3.compareToIgnoreCase(str5);
		System.out.println("Comparison result of str3 and str5: " + result3);
		
		//== Operator
		
		if (str5 == str6) {
            System.out.println("str5 and str6 are the same reference.");
        } else {
            System.out.println("str5 and str6 are different references.");
        }
		
		if (str1 == str2) {
            System.out.println("str1 and str2 are the same reference.");
        } else {
            System.out.println("str1 and str2 are different references.");
        }
		

//--------------------
	}
}
