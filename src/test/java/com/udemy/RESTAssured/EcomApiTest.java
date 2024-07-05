package com.udemy.RESTAssured;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class EcomApiTest {

	private static String token;
	private static String userId;
	private static String productId;
	private static String orderId;

	@BeforeClass
	public void setup() {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
	}

	@Test(priority = 1)
	public void loginTest() {
		String loginPayload = "{\r\n"
				+ "    \"userEmail\": \"bhushan@19yahoo.in\",\r\n"
				+ "    \"userPassword\": \"BhushanQA1@\"\r\n"
				+ "}";

		Response response = given().contentType(ContentType.JSON).body(loginPayload).when().post("/api/ecom/auth/login")
				.then().log().all().assertThat().statusCode(200).extract().response();

		token = response.jsonPath().getString("token");
		userId = response.jsonPath().getString("userId");

		AssertJUnit.assertNotNull(token, "Token should not be null");
		AssertJUnit.assertNotNull(userId, "User ID should not be null");
	}

	@Test(priority = 2)
	public void addProductTest() {
		String addProductPayload = "{ \"productName\": \"Test Product\", \"productAddedBy\": \"" + userId
				+ "\", \"productCategory\": \"Electronics\", \"productSubCategory\": \"Mobile\", \"productPrice\": \"999\", \"productDescription\": \"Test Description\", \"productFor\": \"all\" }";

		Response response = given().header("Authorization", token).contentType(ContentType.JSON).body(addProductPayload)
				.post("/api/ecom/product/add-product").then().statusCode(201).extract().response();

		productId = response.jsonPath().getString("productId");

		AssertJUnit.assertNotNull(productId, "Product ID should not be null");
		AssertJUnit.assertEquals(response.jsonPath().getString("message"), "Product Added Successfully");
	}

	@Test(priority = 3)
	public void createOrderTest() {
		String createOrderPayload = "{ \"orders\": [{ \"country\": \"British Indian Ocean Territory\", \"productOrderedId\": \""
				+ productId + "\" }] }";

		Response response = given().header("Authorization", token).contentType(ContentType.JSON)
				.body(createOrderPayload).post("/api/ecom/order/create-order").then().statusCode(201).extract()
				.response();
		orderId = response.jsonPath().getString("orderId");

		AssertJUnit.assertEquals(response.jsonPath().getString("message"), "Order Placed Successfully");
	}

	@Test(priority = 4, dependsOnMethods = "addProductTest")
	public void viewOrderTest() {
		Response response = given().header("Authorization", token)
				.get("/api/ecom/order/get-orders-details?id=" + productId).then().statusCode(200).extract().response();

		AssertJUnit.assertNotNull(response.jsonPath().getString("orderDetails"), "Order details should not be null");
	}

	@Test(priority = 5, dependsOnMethods = "addProductTest")
	public void deleteProductTest() {
		Response response = given().header("Authorization", token)
				.delete("/api/ecom/product/delete-product/" + productId).then().statusCode(200).extract().response();

		AssertJUnit.assertEquals(response.jsonPath().getString("message"), "Product Deleted Successfully");
	}
	
	@Test(priority = 6, dependsOnMethods = "createOrderTest")
    public void deleteOrderTest() {
        String deleteOrderPayload = "{ \"orderId\": \"" + orderId + "\" }";

        Response response = given()
                .header("Authorization", token)
                .contentType(ContentType.JSON)
                .body(deleteOrderPayload)
                .delete("/api/ecom/order/delete-order")
                .then()
                .statusCode(200)
                .extract()
                .response();

        AssertJUnit.assertEquals(response.jsonPath().getString("message"), "Order Deleted Successfully");
    }
}
