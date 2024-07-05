package EcomAPITest;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.*;

public class EcomAPISD {

    private static String token;
    private static String userId;
    private static String productId;
    private static String orderId;

    @Given("I am logged in with valid credentials")
    public void i_am_logged_in_with_valid_credentials() {
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String loginPayload = "{ \"userEmail\": \"your-email@example.com\", \"userPassword\": \"your-password\" }";

        Response response = given()
                .contentType(ContentType.JSON)
                .body(loginPayload)
                .post("/api/ecom/auth/login")
                .then()
                .statusCode(200)
                .extract()
                .response();

        token = response.jsonPath().getString("token");
        userId = response.jsonPath().getString("userId");

        assertNotNull(token, "Token should not be null");
        assertNotNull(userId, "User ID should not be null");
    }

    @When("I add a new product")
    public void i_add_a_new_product() {
        String addProductPayload = "{ \"productName\": \"Test Product\", \"productAddedBy\": \"" + userId + "\", \"productCategory\": \"Electronics\", \"productSubCategory\": \"Mobile\", \"productPrice\": \"999\", \"productDescription\": \"Test Description\", \"productFor\": \"all\" }";

        Response response = given()
                .header("Authorization", token)
                .contentType(ContentType.JSON)
                .body(addProductPayload)
                .post("/api/ecom/product/add-product")
                .then()
                .statusCode(201)
                .extract()
                .response();

        productId = response.jsonPath().getString("productId");

        assertNotNull(productId, "Product ID should not be null");
        assertEquals(response.jsonPath().getString("message"), "Product Added Successfully");
    }

    @Then("the product is added successfully")
    public void the_product_is_added_successfully() {
        // This step is covered in the previous method's assertions.
    }

    @When("I create an order with the added product")
    public void i_create_an_order_with_the_added_product() {
        String createOrderPayload = "{ \"orders\": [{ \"country\": \"India\", \"productOrderedId\": \"" + productId + "\" }] }";

        Response response = given()
                .header("Authorization", token)
                .contentType(ContentType.JSON)
                .body(createOrderPayload)
                .post("/api/ecom/order/create-order")
                .then()
                .statusCode(201)
                .extract()
                .response();

        orderId = response.jsonPath().getString("orderId");

        assertNotNull(orderId, "Order ID should not be null");
        assertEquals(response.jsonPath().getString("message"), "Order Placed Successfully");
    }

    @Then("the order is created successfully")
    public void the_order_is_created_successfully() {
        // This step is covered in the previous method's assertions.
    }

    @When("I view the order details")
    public void i_view_the_order_details() {
        Response response = given()
                .header("Authorization", token)
                .get("/api/ecom/order/get-orders-details?id=" + orderId)
                .then()
                .statusCode(200)
                .extract()
                .response();

        assertNotNull(response.jsonPath().getString("orderDetails"), "Order details should not be null");
    }

    @Then("the order details are retrieved successfully")
    public void the_order_details_are_retrieved_successfully() {
        // This step is covered in the previous method's assertions.
    }

    @When("I delete the added product")
    public void i_delete_the_added_product() {
        Response response = given()
                .header("Authorization", token)
                .delete("/api/ecom/product/delete-product/" + productId)
                .then()
                .statusCode(200)
                .extract()
                .response();

        assertEquals(response.jsonPath().getString("message"), "Product Deleted Successfully");
    }

    @Then("the product is deleted successfully")
    public void the_product_is_deleted_successfully() {
        // This step is covered in the previous method's assertions.
    }
}

