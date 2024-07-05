package coreJavaz.oopz;

public class libraryItem2_Books extends libraryItem1 {
	
	private String author;

	public libraryItem2_Books(String tit1, String item, String auth) {
		super(tit1, item);
		this.author = auth;		
	}
	
	public String getAuthor()
	{
		return author;	
	}

	@Override
	public void checkOut() {
		
		System.out.println("Checking out the book "+ getTitle() +" By "+ getAuthor());
	}

	@Override
	public void returnItem() {
		
		System.out.println("Return the book "+ getTitle() +" By "+ getAuthor());
	}
	
	
}
