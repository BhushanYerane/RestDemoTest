package oopsConcepts;

class Bicycle {
	public int gear;
	public int speed;

	public Bicycle(int gear, int speed) {
		this.gear = gear;
		this.speed = speed;
	}

	public void applybreak(int decrement) {
		speed = speed - decrement;
	}

	public void speedup(int increment) {
		speed = speed + increment;
	}

	@Override
	public String toString() {
		return ("No of Gears- " + gear + "\n" + "Speed of Bicycle-" + speed);
	}
}

class MountainBike extends Bicycle {

	public int seatHeight;

	public MountainBike(int gear, int speed, int startHeight) {
		super(gear, speed);
		seatHeight = startHeight;
	}

	public void setHeight(int newValue) {
		seatHeight = newValue;
	}

	@Override
	public String toString() {
		return (super.toString() + "\nseat height is " + seatHeight);
	}
}

public class InheritanceTest {

	public static void main(String[] args) {
		
		MountainBike mb = new MountainBike(7, 80, 25);
        System.out.println(mb.toString());

	}
}
