package com.udemy.RESTAssured;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;

import com.udemy.RESTAssured.files.Info;
import com.udemy.RESTAssured.files.apiTest;
import com.udemy.RESTAssured.files.webTest;

import io.restassured.path.json.JsonPath;

public class test1 {

	public static void main(String[] args) throws InterruptedException {
		String[] CourseTitle = {"Selenium Webdriver Java","Cypress","Protractor"};
		List<String> actualList = Arrays.asList(CourseTitle);

	String response =given()
						.formParams("client_id",
								"692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
						.formParams("client_secret", "H0JZdHAizi/sCFLn4+WacQ==")
						.formParams("grant_type", "client_credentials")
						.formParams("scope", "trust")
					.when().log().all()
						.post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token")
						.asString();
		System.out.println(response);

		JsonPath jsonPath = new JsonPath(response);
		String accessToken = jsonPath.getString("access_token");
		System.out.println(accessToken);

//		String r2 = given()
//						.queryParams("access_token", accessToken)
//					.when()
//						.get("https://rahulshettyacademy.com/oauthapi/getCourseDetails")
//						.asString();
		Info data = given()
				.queryParams("access_token", accessToken)
			.when()
				.get("https://rahulshettyacademy.com/oauthapi/getCourseDetails")
				.as(Info.class);
		System.out.println(data);
		
		System.out.println(data.getInstructor());
		System.out.println(data.getExpertise());
		// for single title
		String Title = data.getCourses().getWebAutomation().get(1).getCourseTitle();
		System.out.println(Title);
		
		// for list of title
		List<webTest> WebAutomationCourse = data.getCourses().getWebAutomation();
		for(webTest webEle1 : WebAutomationCourse)
		{
			System.out.println("Course Title "+webEle1.getCourseTitle()+", Course Price"+webEle1.getCoursePrice());
		}
		
		ArrayList<String> al = new ArrayList<String>();
		for(int i=0;i<WebAutomationCourse.size();i++)
		{
			al.add(WebAutomationCourse.get(i).getCourseTitle());
		}
		
		Assert.assertTrue(al.equals(actualList));
		
		
		List<apiTest> apiCourse = data.getCourses().getApi();
		for(int i=0;i<apiCourse.size();i++)
		{
			if(apiCourse.get(i).getCourseTitle().equalsIgnoreCase("Rest Assured Automation using Java"))
			{
				System.out.println(apiCourse.get(i).getCoursePrice());
			}
		}
		
		
	}
}
