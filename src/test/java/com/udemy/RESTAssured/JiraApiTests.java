package com.udemy.RESTAssured;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;


public class JiraApiTests {
	
	final String BASE_URL = "https://bhushyerane.atlassian.net";
    final String AUTH_TOKEN = "Basic Ymh1c2h5ZXJhbmVAZ21haWwuY29tOkFUQVRUM3hGZkdGMElrVTQtMWp3Y2hqcno4M0Y4QnNjbFN4bWI2cEg2Uzk2N1hkcWExVU9zNlZfTk1QcEJuc085ZlFXWk9oTW52aGFHT0Mya2VRRkl2QTZjZ2M0S09jdU4wTDdSbFo4ZDJtVUhvVV9fZ1FneGhsYUZWeXVFWW50VG4tQVA0UFZkdEJQN2dLeEt2UEFqY192dEs5Yjc3NHNMU3dyaHdWOFo2WHpkTDB3NGZxUVJVMD1GMUY3QzI3Ng==";
    String issueId;
	
	@Test
	public void jiraTest()
	{
		RestAssured.baseURI = BASE_URL;
		String requestBody = "{\n" +
                "    \"fields\": {\n" +
                "       \"project\":\n" +
                "       {\n" +
                "          \"key\": \"SCRUM\"\n" +
                "       },\n" +
                "       \"summary\": \"Bug created via API\",\n" +
                "       \"description\": \"Creating a bug via REST API\",\n" +
                "       \"issuetype\": {\n" +
                "          \"name\": \"Bug\"\n" +
                "       }\n" +
                "   }\n" +
                "}";
		
		Response respobj = given().log().all()
						.header("Authorization", AUTH_TOKEN).header("Content-Type", "application/json").body(requestBody)
				.when().post("/rest/api/2/issue")
				.then().log().all()
						.assertThat().statusCode(201).extract().response();	 
		
		JsonPath jsonPath1 = respobj.jsonPath();
        issueId = jsonPath1.getString("id");
        System.out.println("Created issue ID: " + issueId);
	}
}
