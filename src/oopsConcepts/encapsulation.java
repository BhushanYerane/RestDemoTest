package oopsConcepts;

class encapsulate {
	private String name;
	private int age;
	private int rollno;
	private double percentage;
	
	public String getName() {	return name;	}
	public double getPercentage() {	return percentage;	}
	public int getAge() { return age;	}
	public int getRollno() { return rollno;	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
}

public class encapsulation {

	public static void main(String[] args) {
		encapsulate encapobj = new encapsulate();
		encapobj.setName("Bhushan");
		encapobj.setPercentage(73.77);
		encapobj.setAge(21);
		encapobj.setRollno(1001);
		
		System.out.println("Name: "+encapobj.getName());
		System.out.println("Age:  "+encapobj.getAge());
		System.out.println("Percentage: "+encapobj.getPercentage());
		System.out.println("Roll_No: "+encapobj.getRollno());	
	}
}
