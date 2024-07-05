package com.post_request;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

import org.json.JSONObject;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class PostMethodSD {
	Response response;

	@Given("Create User with data")
	public void create_user_with_data() {
		RestAssured.config = RestAssuredConfig.config().sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation());

		response = RestAssured.given().relaxedHTTPSValidation().accept(ContentType.JSON)
				.body("{\r\n" + "\"name\" : \"BhushanYerane\",\r\n" + "\"job\" : \"senior consultant\" ,\r\n"
						+ "\"dept\" : \"HR\",\r\n" + "\"mob\" : \"9876512345\"\r\n" + "}")
				.post("https://reqres.in/api/users");
	}

	@Given("Create User with data1")
	public void create_user_with_data1() {
		RestAssured.config = RestAssuredConfig.config().sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation());

		response = RestAssured.given().relaxedHTTPSValidation().accept(ContentType.JSON)
				.body("{\r\n" + "\"name\" : \"lalaji\",\r\n" + "\"job\" : \"SinConsultant\" ,\r\n"
						+ "\"dept\" : \"QA automation\",\r\n" + "\"mob\" : \"1234987650\"\r\n" + "}")
				.post("https://reqres.in/api/users");

	}

	@Then("validate user created.")
	public void validate_user_created() {
		String allResp = response.asString();
		System.out.println("all details = " + allResp);
		System.out.println("status code = " + response.getStatusCode());
		Assert.assertTrue(response.getStatusCode() == 201);
	}

	@Then("validate user ID have non null value")
	public void validate_user_ID_have_non_null_value() {
		String actID = response.body().jsonPath().getString("id");
		System.out.println(actID);
		Assert.assertTrue(Integer.parseInt(actID) > 0);
		Assert.assertTrue(actID != null);
	}

	@Given("Create User {string} with data from file")
	public void create_user_with_data_from_file(String userName) throws IOException {
		String jsonData = new String(Files.readAllBytes(Paths.get("src/test/resources/com/post_request_FF/User.json")));
		JSONObject jsonObj = new JSONObject(jsonData);
		jsonObj.put("name", userName);
		jsonObj.put("mob", "333");
		String actJson = jsonObj.toString();
		System.out.println("Json before POST = " + actJson);
		response = RestAssured.given().relaxedHTTPSValidation().accept(ContentType.JSON).body(actJson)
				.post("https://reqres.in/api/users");
	}

	@Then("validate all headers")
	public void validate_headers() {
		Headers allHeaders = response.getHeaders();
		List<Header> listHeaders = allHeaders.asList();

		for (Iterator<Header> iterator = listHeaders.iterator(); iterator.hasNext();) {
			Header header = (Header) iterator.next();
			System.out.println(header.toString());
		}
	}

}
