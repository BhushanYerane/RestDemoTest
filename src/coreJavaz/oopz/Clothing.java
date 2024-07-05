package coreJavaz.oopz;

public class Clothing extends Product 
{
	private String size;
	
	public Clothing(String name, double price, String size) {
		super(name, price);
		this.size = size;		
	}

	public String getSize() {
		return size;
	}

	public String toString()
	{
	//	return "Clothing [size=" + size + ", name=" + getName() + ", price=" + getPrice() + "]";	
		return "Clothing [" + "size=" + size + ", " + super.toString() + "]";
	}
}
