package com.jsonRefData;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;
import io.restassured.http.ContentType;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UserStepsSD {

    private static final String TOKEN = "7d4707316afdb12fa54510025dd70739ebb26d3732cd797093baa15a6dfe4cbd";
    private Response response;
    private String userId;

    @Given("the base URL is {string}")
    public void the_base_URL_is(String baseURL) {
    	RestAssured.config = RestAssuredConfig.config().sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation());
        RestAssured.baseURI = baseURL;
    }

    @When("I send a POST request to {string} with complex body:")
    public void i_send_a_POST_request_to_with_complex_body(String endpoint, String requestBody) {
        response = given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post(endpoint);
        userId = response.jsonPath().getString("id");
        
        System.out.println(response+" "+userId);
    }

    @Then("the status code should be {int}")
    public void the_status_code_should_be(int statusCode) {
        Assert.assertEquals(response.getStatusCode(), statusCode);
    }

    @Then("the content type should be {string}")
    public void the_content_type_should_be(String contentType) {
        Assert.assertEquals(response.getContentType(), contentType);
    }

    @Then("the response should contain {string} with value {string}")
    public void the_response_should_contain_with_value(String key, String value) {
        response.then().body(key, equalTo(value));
    }

    @Then("the header {string} should be {string}")
    public void the_header_should_be(String header, String headerValue) {
        Assert.assertEquals(response.getHeader(header), headerValue);
    }
}
