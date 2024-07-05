package com.udemy.RESTAssured.files;

import java.util.List;

public class InfoCourses {
	
	private List<webTest> webAutomation;
	private List<apiTest> api;
	private List<mobileTest> mobile;
	
	public List<webTest> getWebAutomation() {
		return webAutomation;
	}
	public void setWebAutomation(List<webTest> webAutomation) {
		this.webAutomation = webAutomation;
	}
	public List<apiTest> getApi() {
		return api;
	}
	public void setApi(List<apiTest> api) {
		this.api = api;
	}
	public List<mobileTest> getMobile() {
		return mobile;
	}
	public void setMobile(List<mobileTest> mobile) {
		this.mobile = mobile;
	}

}
