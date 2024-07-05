package coreJavaz.oopz;

public class EmailNotification extends Notification 
{
	private String subject, body;

	public EmailNotification(String recipient, String sub, String bdy) 
	{
		super(recipient);
		this.body = bdy;
		this.subject = sub;
	}

	@Override
	public void send() 
	{
		System.out.println("Sending Email to " + getRecipient() + " with subject: " + subject + " and body: " + body);
	}
}
