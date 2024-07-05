package oopsConcepts;

abstract class shape {
	String color;

	abstract double area();

	public abstract String toString();

	public shape(String color) {
		System.out.println("Shape constructor called");
		this.color = color;
	}

	public String getColor() {
		return color;
	}
}

class circle extends shape {
	double radius;

	public circle(String color, double rad) {
		super(color);
		System.out.println("Circle constructor called");
		this.radius = rad;
	}

	@Override
	double area() {
		return Math.PI * Math.pow(radius, 2);
	}

	@Override
	public String toString() {
		return "Circle color is: " + super.getColor() + " and area is: " + area();
	}
}

class rectangle extends shape {
	double length;
	double width;

	public rectangle(String color, double len, double wid) {
		super(color);
		System.out.println("Rectangle constructor called");
		this.length = len;
		this.width = wid;
	}

	@Override
	double area() {
		return length * width;
	}

	@Override
	public String toString() {
		return "Rectangle color is " + super.getColor() + " and area is : " + area();
	}
}

public class AbstractionTest {
	public static void main(String[] args) {
		shape s1 = new circle("Red", 2.5);
		shape s2 = new rectangle("Yellow", 3, 4);

		System.out.println(s1.toString());
		System.out.println(s2.toString());
	}
}
