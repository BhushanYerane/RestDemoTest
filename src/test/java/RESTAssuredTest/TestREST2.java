package RESTAssuredTest;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

public class TestREST2 {
	
	@Test
	public void MessageBody()
	{
		RestAssured.baseURI = "https://demoqa.com/BookStore/v1";
		RestAssured.config = RestAssuredConfig.config().sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation());
		
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/Books");

		// Retrieve the body of the Response
		ResponseBody body = response.getBody();

		// To check for sub string presence get the Response body as a String.
		// Do a String.contains
		String bodyAsString = body.asString();
		System.out.println("-:"+bodyAsString);
		
		AssertJUnit.assertEquals(bodyAsString.contains("Axel Rauschmayer") /*Expected value*/, true /*Actual Value*/);
	}
	
	public class QueryParam {
		
		@Test
		public void queryParameter() {
			//Defining the base URI
			RestAssured.baseURI= "https://bookstore.toolsqa.com/BookStore/v1";
			RestAssured.config = RestAssuredConfig.config().sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation());
			
			RequestSpecification httpRequest = RestAssured.given();
			//Passing the resource details
			Response res = httpRequest.queryParam("ISBN","9781449325862").get("/Book");
			//Retrieving the response body using getBody() method
			ResponseBody body = res.body();
			//Converting the response body to string object
			String rbdy = body.asString();
			//Creating object of JsonPath and passing the string response body as parameter
			JsonPath jpath = new JsonPath(rbdy);
			//Storing publisher name in a string variable
			String title = jpath.getString("title");
			System.out.println("The book title is - "+title);
		}

	}

}
