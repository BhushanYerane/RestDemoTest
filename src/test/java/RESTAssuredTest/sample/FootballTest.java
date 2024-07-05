package RESTAssuredTest.sample;

import org.testng.annotations.Test;
//import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import RESTAssuredTest.config.FootballConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.hamcrest.CoreMatchers.equalTo;

import java.util.List;

public class FootballTest extends FootballConfig
{
	@Test
	public void getdetailsOfOneArea()
	{
		given()
			.queryParam("areas", 2076)
		.when()
			.get("/areas")
		.then();
	}
	
	@Test
	public void getdetailsOfMultipleArea()
	{
		String areaID ="2076,2078,2080";
		given()
			.urlEncodingEnabled(false)
			.queryParam("areas", areaID)
		.when()
			.get("/areas")
		.then();
	}
	
	@Test
	public void getDateFounded()
	{
		given()
		.when()
			.get("teams/57")
		.then()
			.body("founded", equalTo(1886));
	}

	@Test
	public void getFirstTeamName()
	{
		given()
		.when()
			.get("competitions/WC/teams")
		.then()
			.body("teams.name[0]",equalTo("Uruguay"));
	}
	
	@Test
	public void getAllTeamData()
	{
		String responseBody = get("teams/57").asString();
		System.out.println(responseBody);
	}
	
	@Test
	public void getAllTeamData_DoCheckFirst()
	{
		Response respObj = given()
						 .when()
						 	.get("teams/57")
						 .then()
							.contentType(ContentType.JSON)
							.extract().response();
		String jsonResponseAsString = respObj.asString();
		System.out.println(jsonResponseAsString);
	}
	
	@Test
	public void extractHeaders()
	{
		Response respObj = get("teams/57").then().extract().response();
		String contentTypeHeader = respObj.getContentType();
		System.out.println("---"+contentTypeHeader);
		
		String apiVersionHeader = respObj.getHeader("X-API-Version");
		System.out.println("---"+apiVersionHeader);
		
		int statusCode = respObj.getStatusCode();
		System.out.println("---"+statusCode);
		
		long apiTime = respObj.getTime();
		System.out.println("---"+apiTime);	
	}
	
	@Test
	public void extractFirstTeamName()
	{
		String FirstTeamName = get("competitions/WC/teams").jsonPath().getString("teams.name[0]");
		System.out.println(FirstTeamName);
	}
	
	@Test
	public void extractAllTeamNames()
	{
		Response respObj = get("competitions/WC/teams").then().extract().response();
		List<String> teamsName = respObj.path("teams.name");
		for(String TeamName :teamsName)
		{
			System.out.println("\n"+TeamName);
		}		
	}
	
	@Test
	public void xx()
	{
		
	}
}
