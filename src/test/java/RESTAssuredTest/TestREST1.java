package RESTAssuredTest;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification; 

public class TestREST1 {
	
	String id = "6958835"; 
	String baseUrl="https://gorest.co.in"; 
	String token = "7d4707316afdb12fa54510025dd70739ebb26d3732cd797093baa15a6dfe4cbd"; 

	@Test
	public void updUsers1() {
	    String name ="Test3";
	    RestAssured.baseURI = baseUrl;
	    RequestSpecification httpRequest = RestAssured.given().header("Authorization", "Bearer " + token)
	            .header("Content-Type", "application/json");

	    Response res = httpRequest.body("{\"name\":" + name + ", \"id\": " + id + "}").put("/public/v2/users/6958831");
	    
	    System.out.println("The response code - " +res.getStatusCode());
	    AssertJUnit.assertEquals(res.getStatusCode(),200);
	}
	
	@Test
	public void updUsers2() {
		String name ="Test4";
	    String token1 = "b173629dbbaa7908f92f98523a8a06f3d033f0722d43b25742c5a212f5969f3c1";
	    RestAssured.baseURI = baseUrl;
	    RequestSpecification httpRequest = RestAssured.given().header("Authorization", "Bearer " + token1)
	            .header("Content-Type", "application/json");

	    Response res = httpRequest.body("{\"name\":" + name + ", \"id\": " + id + "}").put("/public/v2/users/6958831");
	    
	    System.out.println("The response code - " +res.getStatusCode());
	    AssertJUnit.assertEquals(res.getStatusCode(),401);

	}

}
