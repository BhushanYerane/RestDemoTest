package coreJavaz.oopz;

public class PushNotification extends Notification 
{
	private String title, content;
	
	public PushNotification(String recipient, String title, String content) 
	{
		super(recipient);
		this.content = content;
		this.title = title;
	}

	@Override
	public void send() 
	{
		System.out.println("Sending Push Notification to " + getRecipient() + " with title: " + title + " and content: " + content);
	}
}
