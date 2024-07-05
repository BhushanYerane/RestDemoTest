package RESTAssuredTest;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class RestAssuredAPITest2 
{

	@Test
	public void generalDetails() 
	{
		RestAssured.baseURI = "https://gorest.co.in/public/v2/";
		RestAssured.config = RestAssuredConfig.config().sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation());
		
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/users");
		
		ResponseBody body = response.getBody();
		System.out.println("Response Body is: " + body.asString());
		
		String bodyAsString = body.asString();
		AssertJUnit.assertEquals(bodyAsString.contains("Swapnil Asan JD"), true, "Response body contains Fr. Bilwa Dutta");
		AssertJUnit.assertEquals(bodyAsString.contains("lala ji"),false,"Response body contains lala ji" );
	}

}
