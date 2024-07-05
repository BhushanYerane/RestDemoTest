package coreJavaz.oopz;

public abstract class Notification {
	private String recipient;
	
	public Notification(String recipient)
	{
		this.recipient = recipient;
	}

	public String getRecipient() {
		return recipient;
	}

	public abstract void send();	
}
