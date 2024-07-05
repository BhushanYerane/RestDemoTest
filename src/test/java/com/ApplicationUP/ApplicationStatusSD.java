package com.ApplicationUP;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Assert;

import java.io.IOException;

public class ApplicationStatusSD {

 private CloseableHttpClient httpClient;
 private CloseableHttpResponse response;

 @Given("the application is running")
 public void the_application_is_running() {
	 RestAssured.config = RestAssuredConfig.config().sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation());
     httpClient = HttpClients.createDefault();
 }

 @When("I check the application status")
 public void i_check_the_application_status() throws IOException {
     HttpGet request = new HttpGet("http://ergast.com/api/f1/2017/circuits.json");
     response = httpClient.execute(request);
 }

 @Then("the status should be 200 OK")
 public void the_status_should_be_200_OK() {
     int statusCode = response.getStatusLine().getStatusCode();
     Assert.assertEquals(200, statusCode);
 }
}
