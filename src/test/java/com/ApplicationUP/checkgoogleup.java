package com.ApplicationUP;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class checkgoogleup {
	
	Response respObj = null;
	
	@Given("Open google")
	public void open_google() {
		System.out.println("in open google method");
		respObj = RestAssured.get("https://google.com");
		System.out.println("END - open google method");
	}
	@Then("Check google up and running")
	public void check_google_up_and_running() {
		int statusCode = respObj.getStatusCode();
		System.out.println("Status code is = "+statusCode);
		Assert.assertTrue(statusCode == 200);
	}
}
