package EcomTest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class EcomApiNew {

    private static String token;
    private static String userId;
    private static String productId;

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://rahulshettyacademy.com";
    }

    @Test(priority = 1)
    @Parameters({"userEmail", "userPassword"})
    public void loginTest(String userEmail, String userPassword) {
        LoginRequest loginRequest = new LoginRequest(userEmail, userPassword);

        Response response = given()
                .contentType(ContentType.JSON)
                .body(loginRequest)
                .when()
                .post("/api/ecom/auth/login")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .extract()
                .response();

        token = response.jsonPath().getString("token");
        userId = response.jsonPath().getString("userId");

        AssertJUnit.assertNotNull(token, "Token should not be null");
        AssertJUnit.assertNotNull(userId, "User ID should not be null");
    }

    @Test(priority = 2)
    @Parameters({"productName", "productCategory", "productSubCategory", "productPrice", "productDescription", "productFor"})
    public void addProductTest(String productName, String productCategory, String productSubCategory, String productPrice, String productDescription, String productFor) {
        Product product = new Product(productName, userId, productCategory, productSubCategory, productPrice, productDescription, productFor);

        Response response = given()
                .header("Authorization", token)
                .contentType(ContentType.JSON)
                .body(product)
                .post("/api/ecom/product/add-product")
                .then()
                .statusCode(201)
                .extract()
                .response();

        productId = response.jsonPath().getString("productId");

        AssertJUnit.assertNotNull(productId, "Product ID should not be null");
        AssertJUnit.assertEquals(response.jsonPath().getString("message"), "Product Added Successfully");
    }

    @Test(priority = 3)
    @Parameters({"country"})
    public void createOrderTest(String country) {
        Order order = new Order(country, productId);
        OrderRequest orderRequest = new OrderRequest(List.of(order));

        Response response = given()
                .header("Authorization", token)
                .contentType(ContentType.JSON)
                .body(orderRequest)
                .post("/api/ecom/order/create-order")
                .then()
                .statusCode(201)
                .extract()
                .response();

        AssertJUnit.assertEquals(response.jsonPath().getString("message"), "Order Placed Successfully");
    }

    @Test(priority = 4, dependsOnMethods = "addProductTest")
    public void viewOrderTest() {
        Response response = given()
                .header("Authorization", token)
                .get("/api/ecom/order/get-orders-details?id=" + productId)
                .then()
                .statusCode(200)
                .extract()
                .response();

        AssertJUnit.assertNotNull(response.jsonPath().getString("orderDetails"), "Order details should not be null");
    }

    @Test(priority = 5, dependsOnMethods = "addProductTest")
    public void deleteProductTest() {
        Response response = given()
                .header("Authorization", token)
                .delete("/api/ecom/product/delete-product/" + productId)
                .then()
                .statusCode(200)
                .extract()
                .response();

        AssertJUnit.assertEquals(response.jsonPath().getString("message"), "Product Deleted Successfully");
    }
}
