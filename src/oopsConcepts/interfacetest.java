package oopsConcepts;

interface in1 {
	final int a = 11;

	void dispaly();

	default void display1() {
		System.out.println("The Default method so access with obj of class");
	}

	static void display2() {
		System.out.println("The Static method so access directly with interface");
	}
}

public class interfacetest implements in1 {

	@Override
	public void dispaly() {
		System.out.println("Dispaly method in Interface");
	}

	public static void main(String[] args) {

		interfacetest inter = new interfacetest();
		inter.dispaly();
		System.out.println(a);
		
		in1.display2(); // As this is static in interface
		inter.display1(); // as thsi is default in interface
	}
}
