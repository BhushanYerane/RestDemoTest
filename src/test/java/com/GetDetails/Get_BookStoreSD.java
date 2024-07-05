package com.GetDetails;

import java.io.IOException;

import org.junit.Assert;

import com.lib.PropertiesOperation;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;

public class Get_BookStoreSD {

	Response respobj = null;

	@Given("Hit the bookstore api")
	public void hit_the_bookstore_api() throws IOException {
		RestAssured.config = RestAssuredConfig.config().sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation());
		String URL = PropertiesOperation.getPropValue("uri");
		respobj = RestAssured.get(URL);
	}

	@Then("validate as status code")
	public void validate_as_status_code() {
		int statusCode = respobj.statusCode();
		Assert.assertTrue("Status code Matching ", statusCode == 200);
	}

	@Then("validate Git Pocket Guide title present")
	public void validate_git_pocket_guide_title_present() {
		String titleArr[] = { "Git Pocket Guide", "Learning JavaScript Design Patterns" };
		String jsonDataString = respobj.getBody().asString();
		System.out.println("JSON = " + jsonDataString);
		String bookTitle = respobj.getBody().jsonPath().getString("books[0].title");
		Assert.assertTrue("Title not maching", bookTitle.equals("Git Pocket Guide"));
	}

	@Then("validate Learning JavaScript Design Patterns title present")
	public void validate_learning_java_script_design_patterns_title_present() {
		String jsonDataString = respobj.getBody().asString();
		System.out.println("JSON = " + jsonDataString);
		String bookTitle = respobj.getBody().jsonPath().getString("books[1].title");
		Assert.assertTrue("Title not maching", bookTitle.equals("Learning JavaScript Design Patterns"));
	}

	@Then("validate {string} at jsonpath {string} title present")
	public void validate_title_present(String title, String jsonPath) {
		String jsonDataString = respobj.getBody().asString();
		System.out.println("JSON = " + jsonDataString);
		String actualbookTitle = respobj.getBody().jsonPath().getString(jsonPath);
		Assert.assertTrue("PageNumbers not maching", actualbookTitle.equals(title));
	}

	@Then("validate {string} at jsonpath {string} pageNumbers present")
	public void validate_pageNumbers_present(String pageNumbers, String jsonPath) {
		int actualPageNum = respobj.getBody().jsonPath().getInt(jsonPath);
		int expectedPageNum = Integer.parseInt(pageNumbers);
		Assert.assertTrue("Title not maching", actualPageNum == expectedPageNum);
	}

	@Then("validate {string} at jsonpath {string} present")
	public void validate_Value_present(String expValue, String jsonPath) {
		String actualValue = respobj.getBody().jsonPath().getString(jsonPath);
		Assert.assertTrue("Title not maching", expValue.equals(actualValue));
	}
}
