package coreJavaz.oopz;

public class users {
	private String username;
	private String password;
	
	public users(String uname,String pword)
	{
		this.username=uname;
		this.password=pword;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean login(String username, String passowrd)
	{
		return this.username.equals(username) && this.password.equals(passowrd);	
	}

}
