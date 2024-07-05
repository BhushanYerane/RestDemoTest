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
import static org.hamcrest.Matchers.equalTo;

public class userAPITest{

    private static final String BASE_URL = "https://gorest.co.in/public/v2";
    private static final String TOKEN = "7d4707316afdb12fa54510025dd70739ebb26d3732cd797093baa15a6dfe4cbd";

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = BASE_URL;
    }

    @Test
    public void testGetUser() {
        Response response = given()
            .header("Authorization", "Bearer " + TOKEN)
            .when()
            .get("/users")
            .then()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .extract()
            .response();

        AssertJUnit.assertEquals(response.getStatusCode(), 200);
        AssertJUnit.assertTrue(response.jsonPath().getList("id").size() > 0);
    }

    @Test
    public void testCreateUser() {
        String requestBody = "{\"name\": \"John Doe\", \"gender\": \"male\", \"email\": \"johndoe@example.com\", \"status\": \"active\"}";

        Response response = given().log().all()
        			.header("Authorization", "Bearer " + TOKEN)
        			.contentType(ContentType.JSON)
        			.body(requestBody)
            .when()
            		.post("/users")
            .then().log().all()
            		.statusCode(201)
            		.contentType(ContentType.JSON)
            		.body("name", equalTo("John Doe"))
            		.extract()
            		.response();

        AssertJUnit.assertEquals(response.getStatusCode(), 201);
        AssertJUnit.assertEquals(response.jsonPath().getString("name"), "John Doe");
    }

    @Test
    public void testUpdateUser() {
        String userId = createTestUser(); // Create a test user and get its ID

        String requestBody = "{\"name\": \"John Updated\", \"status\": \"inactive\"}";

        Response response = given()
            .header("Authorization", "Bearer " + TOKEN)
            .contentType(ContentType.JSON)
            .body(requestBody)
            .when()
            .put("/users/" + userId)
            .then()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body("name", equalTo("John Updated"))
            .extract()
            .response();

        AssertJUnit.assertEquals(response.getStatusCode(), 200);
        AssertJUnit.assertEquals(response.jsonPath().getString("name"), "John Updated");

        deleteTestUser(userId); // Clean up the test user
    }

    @Test
    public void testPatchUser() {
        String userId = createTestUser(); // Create a test user and get its ID

        String requestBody = "{\"status\": \"active\"}";

        Response response = given()
            .header("Authorization", "Bearer " + TOKEN)
            .contentType(ContentType.JSON)
            .body(requestBody)
            .when()
            .patch("/users/" + userId)
            .then()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body("status", equalTo("active"))
            .extract()
            .response();

        AssertJUnit.assertEquals(response.getStatusCode(), 200);
        AssertJUnit.assertEquals(response.jsonPath().getString("status"), "active");

        deleteTestUser(userId); // Clean up the test user
    }

    @Test
    public void testDeleteUser() {
        String userId = createTestUser(); // Create a test user and get its ID

        Response response = given()
            .header("Authorization", "Bearer " + TOKEN)
            .when()
            .delete("/users/" + userId)
            .then()
            .statusCode(204)
            .extract()
            .response();

        AssertJUnit.assertEquals(response.getStatusCode(), 204);
    }

    private String createTestUser() {
        String requestBody = "{\"name\": \"Test User\", \"gender\": \"male\", \"email\": \"testuser@example.com\", \"status\": \"active\"}";

        Response response = given()
            .header("Authorization", "Bearer " + TOKEN)
            .contentType(ContentType.JSON)
            .body(requestBody)
            .when()
            .post("/users")
            .then()
            .statusCode(201)
            .extract()
            .response();

        return response.jsonPath().getString("id");
    }

    private void deleteTestUser(String userId) {
        given()
            .header("Authorization", "Bearer " + TOKEN)
            .when()
            .delete("/users/" + userId)
            .then()
            .statusCode(204);
    }
}

