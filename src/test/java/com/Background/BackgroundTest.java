package com.Background;

import java.io.IOException;

import org.junit.Assert;

import com.lib.PropertiesOperation;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;

public class BackgroundTest 
{
Response response  = null;
	
	@Given("login to application and get response")
	public void hit_the_bookstore_api() throws IOException {
		RestAssured.config = RestAssuredConfig.config().sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation());
		String url = PropertiesOperation.getPropValue("uri");
		response = RestAssured.get(url);
	}
	
	@Then("validate the status code")
	public void validate_statusCod_present() {
		int statusCode=  response.getStatusCode();
		Assert.assertTrue("Status code not matching", statusCode == 200);
	}
	
	@Then("validate Git Pocket Guide title is present")
	public void validate_git_pocket_guide_title_is_present() {
		String titleArr[] = {"Git Pocket Guide","Learning JavaScript Design Patterns"};
		String jsonDataString = response.getBody().asString();
		System.out.println("JSON = "+jsonDataString);
		String bookTitle = response.getBody().jsonPath().getString("books[0].title");
		Assert.assertTrue("Title not maching", bookTitle.equals("Git Pocket Guide"));
	}

}
