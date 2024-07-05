package coreJavaz.oopz;

public class adminz extends users {
	private String adminCode;
	 
	public adminz(String username,String password,String adminCode)
	{
		super (username,password);
		this.adminCode = adminCode;
	}

	public String getAdminCode() {
		return adminCode;
	}

	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}
	
	public boolean adminlogin(String uname, String pword, String adCode)
	{
		return login(uname,pword) && this.adminCode.equals(adCode);
	}

}
