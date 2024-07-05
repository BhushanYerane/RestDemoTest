package com.udemy.RESTAssured;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import io.restassured.path.json.JsonPath;
import io.restassured.specification.ResponseSpecification;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.udemy.RESTAssured.files.ReUsableMethods;
import com.udemy.RESTAssured.files.payload;

public class testDemo {
	
	// validate if Add Place API is workimg as expected //bhushan@19yahoo.in --BhushanQA1@ https://rahulshettyacademy.com/client/auth/login
	//Add place-> Update Place with New Address -> Get Place to validate if New address is present in response
	@Test
	public void firstTest() {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().log().all()
			.queryParam("Key","qaclick123")
			.header("Content-Type","application/json")
			.body(payload.AddPlace())
		.when()
			.post("/maps/api/place/add/json")
		.then().log().all()
			.assertThat()
				.statusCode(200)
				.body("scope", equalTo("APP"))
				.header("server", "Apache/2.4.52 (Ubuntu)")
				.extract()
				.response()
				.asString();
		
		System.out.println(response);
		
		JsonPath  jsonpath1 = new JsonPath(response);
		String placeID = jsonpath1.getString("place_id");
		String id = jsonpath1.getString("id");
		
		payload.updateaddress(placeID);
		
		System.out.println("PlaceID: "+ placeID + ", ID: "+id);
		
		// Add place -- update place
		String newAddress = "night walker pandu, USAz";
		
			given().log().all()
				.queryParam("Key","qaclick123")
					.header("Content-Type","application/json")
					.body("{\r\n"
							+ "\"place_id\":\""+ placeID +"\",\r\n"
							+ "\"address\":\""+ newAddress +"\",\r\n"
							+ "\"key\":\"qaclick123\"\r\n"
							+ "}\r\n"
							+ "")
			.when()
				.put("/maps/api/place/update/json")
			.then().log().all()
				.assertThat().statusCode(200).body("msg",equalTo("Address successfully updated"));
			
		// get place to verify
		String getPlaceResponse =	given().log().all()
				.queryParam("Key","qaclick123")
					.queryParam("place_id",placeID)
			.when()
				.get("/maps/api/place/get/json")
			.then().log().all()
				.assertThat().statusCode(200).extract().response().asString();
		
		//JsonPath  jsonpath2 = new JsonPath(getPlaceResponse);
		JsonPath jsp2 = ReUsableMethods.rawToJson(getPlaceResponse);
		String actualAddress = jsp2.getString("address");
		System.out.println(actualAddress);
		
		AssertJUnit.assertEquals(actualAddress, newAddress);
	}
	
	
	@Test
	public void xx()
	{
		ResponseSpecification response = given().log().all()
										.when()	
										.then().log().all();
	}
	
	@Test
	public void complexJSONParse()
	{
		JsonPath  jsonpath1 = new JsonPath(payload.courseDetails());
		
		int count = jsonpath1.getInt("courses.size()");
		System.out.println(count);
		
		int totalAmt = jsonpath1.getInt("dashboard.purchaseAmount");
		System.out.println(totalAmt);
		
		String CourseTitle = jsonpath1.getString("courses[3].title");
		System.out.println(CourseTitle);
		
		for(int i=0;i<count;i++)
		{
			String AllCourseTitle = jsonpath1.getString("courses["+ i +"].title");
			int AllCoursePrices = jsonpath1.getInt("courses["+ i +"].price");
			
			System.out.println("Title: "+ AllCourseTitle +", Price: "+AllCoursePrices);
			
			System.out.println(jsonpath1.getString("courses["+ i +"].title").toString());
			System.out.println(jsonpath1.get("courses["+ i +"].price").toString());	
		}
		
		System.out.println("Print no of copies sold by RPA Course");	 
		for(int i=0;i<count;i++)
		 {
			  String courseTitles=jsonpath1.get("courses["+i+"].title");
			  if(courseTitles.equalsIgnoreCase("Cypress"))
			  {
				  int copies=jsonpath1.get("courses["+i+"].copies");
				  System.out.println(copies);
				  break;
			  }
		 }
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void sumOfCourses()
	{
		int sum = 0, courseAmt=0;
		JsonPath  jsonpath1 = new JsonPath(payload.courseDetails());
		int count = jsonpath1.getInt("courses.size()");
		for(int i=0;i<count;i++)
		{
			 int price = jsonpath1.get("courses["+i+"].price");
			 int copies = jsonpath1.get("courses["+i+"].copies");
			 courseAmt = price * copies;
			 System.out.println(courseAmt);
			 sum = courseAmt + sum;
		}
		
		System.out.println("Total of all courses: "+sum);
		AssertJUnit.assertEquals(sum, jsonpath1.getInt("dashboard.purchaseAmount"));
	}
	
	@Test
	public void readNewJson()
	{
		JsonPath  jsonpath1 = new JsonPath(payload.UserJSONData());
		
		String ProjNM = jsonpath1.get("projects.name[1]");
		System.out.println(ProjNM);	
	}
}
