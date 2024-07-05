package oopsConcepts;

interface vehicle {
	void changegear(int a);

	void speedup(int a);

	void applybreak(int a);
}

class cycle implements vehicle {
	int gear;
	int speed;

	@Override
	public void changegear(int newGear) {
		gear = newGear;
	}

	@Override
	public void speedup(int increment) {
		speed = speed + increment;
	}

	@Override
	public void applybreak(int decrement) {
		speed = speed - decrement;
	}

	public void printState() {
		System.out.println("speed: " + speed + " gear: " + gear);
	}
}

class bike implements vehicle {
	int gear;
	int speed;

	@Override
	public void changegear(int newGear) {
		gear = newGear;
	}

	@Override
	public void speedup(int increment) {
		speed = speed + increment;
	}

	@Override
	public void applybreak(int decrement) {
		speed = speed - decrement;
	}

	public void printState() {
		System.out.println("speed: " + speed + " gear: " + gear);
	}
}

public class interfacetest1 {

	public static void main(String[] args) {
		cycle bic = new cycle();
		bic.changegear(3);
		bic.speedup(12);
		bic.applybreak(2);

		System.out.println("Bicycle present state :");
		bic.printState();

		bike byk = new bike();
		byk.changegear(4);
		byk.speedup(30);
		byk.applybreak(5);
		
		System.out.println("Bike present state :");
		byk.printState();
	}
}
