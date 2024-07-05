package RESTAssuredTest;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredAPITest1_Get {

	@Test
	public void GetBooksDetails() {

		//RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
		RestAssured.baseURI = "http://ergast.com/api/f1/2017/circuits.json";
		RestAssured.config = RestAssuredConfig.config().sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation());
    
		RequestSpecification httpRequest = RestAssured.given();

		Response response = httpRequest.request(Method.GET,"");
		Response response1 = httpRequest.get("");
		
		int statusCode = response.getStatusCode();
		String statusLine = response.getStatusLine();
		
		AssertJUnit.assertEquals(statusCode,200,"Correct status code returned");
		AssertJUnit.assertEquals(statusLine, "HTTP/1.1 200 OK", "Correct status code returned");
		
		Headers allHeaders = response.headers();
		for(Header header : allHeaders) 
		{ 
			   System.out.println("Key: " + header.getName() + " Value: " + header.getValue()); 
			 } 
		
		String contentType = response.header("Content-Type"); 
		System.out.println("Content-Type value: " + contentType); 
		AssertJUnit.assertEquals(contentType, "application/json; charset=utf-8"); 
		
		String serverType = response.header("Server"); 
		System.out.println("Server value: " + serverType); 
		AssertJUnit.assertEquals(serverType, "Apache/2.4.53 (AlmaLinux) OpenSSL/3.0.7");
		
		String acceptLanguage = response.header("Content-Encoding"); 
		System.out.println("Content-Encoding: " + acceptLanguage);
		
		
		System.out.println("Status received => " + response.getStatusLine());
//		System.out.println("Response=>" + response.prettyPrint());
//		System.out.println("----------");
//		System.out.println("Response=>" + response1.prettyPrint());
		
		

	}
}