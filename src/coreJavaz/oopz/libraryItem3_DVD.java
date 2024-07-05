package coreJavaz.oopz;

public class libraryItem3_DVD extends libraryItem1  
{
	private String director;

	public libraryItem3_DVD(String tit1, String item, String dir) {
		super(tit1, item);
		this.director = dir;
		
	}
	
	public String getDirector()
	{
		return director;
	}

	@Override
	public void checkOut()
	{
		System.out.println("Checking out the DVD "+ getTitle() +" Directed By "+ getDirector());
	}

	@Override
	public void returnItem()
	{
		System.out.println("Return the DVD "+ getTitle() +" Directed By "+ getDirector());
	}
}
