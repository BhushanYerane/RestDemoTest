package oopsConcepts;

class parent {
	void print()
	{
		System.out.println("Parent class");
	}
	
	void dispaly()
	{
		System.out.println("Dispaly in parent class");
	}
}

class subclass1 extends parent
{
	void print()
	{
		System.out.println("Subclass 1");
	}
}

class subclass2 extends parent
{
	void print()
	{
		System.out.println("Subclass 2");
	}
}
public class overriding {

	public static void main(String[] args) {
		parent obj;
		
		obj = new parent();
		obj.print();
		
		obj = new subclass1();
		obj.print();
		
		obj = new subclass2();
		obj.print();
		
		obj.dispaly();
	}

}
