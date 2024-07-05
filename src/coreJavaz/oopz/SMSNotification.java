package coreJavaz.oopz;

public class SMSNotification extends Notification 
{
	private String message;

	public SMSNotification(String recipient, String msg) 
	{
		super(recipient);
		this.message = msg;
	}

	@Override
	public void send() 
	{
		System.out.println("Sending Message to " + getRecipient() + " with Message: " + message);
	}
}
