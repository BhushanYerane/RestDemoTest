package com.udemy.RESTAssured;
//bhushan@19yahoo.in --BhushanQA1@ https://rahulshettyacademy.com/client/auth/login

import io.restassured.specification.*;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;

import com.udemy.RESTAssured.files.LoginRequest;
import com.udemy.RESTAssured.files.LoginResponse;
import com.udemy.RESTAssured.files.OrderDetail;
import com.udemy.RESTAssured.files.Orders;

import io.restassured.builder.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

public class EcomApiTest1 {

	public static void main(String[] args) {
		
		RequestSpecification reqSpec = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com/")
										.setContentType(ContentType.JSON).build();
		
		LoginRequest logreq = new LoginRequest();
		logreq.setUserEmail("bhushan@19yahoo.in");
		logreq.setUserPassword("BhushanQA1@");
		
		RequestSpecification respObjlogin = given().log().all().spec(reqSpec).body(logreq);
		LoginResponse logresp =	respObjlogin.when().post("api/ecom/auth/login").then().log().all().extract().response().as(LoginResponse.class);
		System.out.println(logresp.getToken());
			String token = logresp.getToken();
		System.out.println(logresp.getUserId());	
			String userID = logresp.getUserId();
		
		//add product
		RequestSpecification addProductBaseReq = new RequestSpecBuilder()
	                .setBaseUri("https://rahulshettyacademy.com/")
	                .addHeader("Authorization", token)
	                .build();
		RequestSpecification reqAddProduct = given().log().all()
                .spec(addProductBaseReq)
                .param("productName", "appleMac book")
                .param("productAddedBy", userID)
                .param("productCategory", "electronics")
                .param("productSubCategory", "laptops") 
                .param("productPrice", "$600")
                .param("productDescription", "A Original Apple Products")
                .param("productFor", "men") 
                .multiPart("productImage", new File("C:\\Users\\byerane\\workspace\\CaptureCourse.PNG"));

		String addProductResponse = reqAddProduct.when()
                .post("api/ecom/product/add-product")
                .then().log().all()
                .extract().response().asString();
		
            JsonPath jsp = new JsonPath(addProductResponse);
            String productID = jsp.getString("productId");
            System.out.println("Product ID: " + productID);
            
        // Create Order
        RequestSpecification createOrderBaseReq = new RequestSpecBuilder()
	                .setBaseUri("https://rahulshettyacademy.com/")
	                .addHeader("Authorization", token)
	                .setContentType(ContentType.JSON)
	                .build();
        OrderDetail orderdetail = new OrderDetail();
        orderdetail.setProductOrderID(productID);
        orderdetail.setCountry("Argentina");
        
        List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
        orderDetailList.add(orderdetail);
        Orders order = new Orders();
        order.setOrders(orderDetailList);
        
        RequestSpecification createOrderReq = given().spec(createOrderBaseReq).body(order);
        String responseAddOrder = createOrderReq.when()
        			.post("api/ecom/order/create-order")
        		.then().log().all()
        			.extract()
        			.response()
        			.asString();
        System.out.println(responseAddOrder);
        
        //Delete product
        RequestSpecification deleteProductBaseReq = new RequestSpecBuilder()
                .setBaseUri("https://rahulshettyacademy.com/")
                .addHeader("Authorization", token)
                .setContentType(ContentType.JSON)
                .build();
        RequestSpecification deleteProdReq = given().spec(deleteProductBaseReq).pathParam("productID", productID);
        String deleteProductResponse = deleteProdReq.when()
    		   		.delete("api/ecom/product/delete-product/{productID}")
    		   .then().log().all()
    		   		.extract()
    		   		.response()
    		   		.asString();
       
       JsonPath js1 = new JsonPath(deleteProductResponse);
       Assert.assertEquals("Product Deleted Successfully",js1.get("message"));
       
     //Delete Order
       RequestSpecification deleteOrderBaseReq = new RequestSpecBuilder()
               .setBaseUri("https://rahulshettyacademy.com/")
               .addHeader("Authorization", token)
               .setContentType(ContentType.JSON)
               .build();
       RequestSpecification deleteOrderReq = given().spec(deleteOrderBaseReq).pathParam("", );

	}
}
