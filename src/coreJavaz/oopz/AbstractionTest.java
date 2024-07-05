package coreJavaz.oopz;

public class AbstractionTest {

	public static void main(String[] args) 
	{
		Notification email = new EmailNotification(null, null, null);
		Notification sms = new SMSNotification(null, null);
		Notification push = new PushNotification(null, null, null);
		
		email.send();
		sms.send();
		push.send();
	}
}
