package coreJavaz.oopz;

abstract class libraryItem1 {
	
	private String title;
	private String itemID;
	
	public libraryItem1(String tit1, String item)
	{
		this.itemID = item;
		this.title = tit1;
	}

	public String getTitle() {
		return title;
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
	}
	
	public abstract void checkOut();
	public abstract void returnItem();	

}
