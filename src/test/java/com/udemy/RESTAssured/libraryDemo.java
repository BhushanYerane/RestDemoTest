package com.udemy.RESTAssured;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.udemy.RESTAssured.files.ReUsableMethods;
import com.udemy.RESTAssured.files.payload;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

public class libraryDemo {
	private static final String BASE_URI = "http://216.10.245.166";
	private static final String TOKEN = "7d4707316afdb12fa54510025dd70739ebb26d3732cd797093baa15a6dfe4cbd";
	private static final List<String> addedBookIds = new ArrayList<>();

	// passing parameter in method API below this will be using data provider
	// @Test
	public void AddBook() {
		RestAssured.baseURI = "http://216.10.245.166";
		String response1 = given().log().all()
					.header("Content-Type", "application/json")
					.body(payload.AddBook("1234", "qwez-A"))
				.when()
					.post("/Library/Addbook.php")
				.then().log().all()
					.assertThat()
						.statusCode(200)
						.extract()
						.asString();

		JsonPath jsonpath1 = ReUsableMethods.rawToJson(response1);
		String id = jsonpath1.getString("ID");
		System.out.println("ID" + id);
	}

	@Test(dataProvider = "BookData")
	public void AddBook1(String isbn, String aisle) {
		RestAssured.baseURI = "http://216.10.245.166";
		String response1 = given().log().all()
					.header("Content-Type", "application/json")
					.body(payload.AddBook(isbn, aisle))
				.when()
					.post("/Library/Addbook.php")
				.then()
					.log().all()
					.assertThat()
						.statusCode(200)
						.extract()
						.asString();
		
		JsonPath jsonpath1 = ReUsableMethods.rawToJson(response1);
		String id = jsonpath1.getString("ID");
		System.out.println("ID: " + id);

		StoreBookId(id);
	}

	@Test(dataProvider = "BookIds", dependsOnMethods = "AddBook1")
	public void DeleteBook(String id) {
		RestAssured.baseURI = "http://216.10.245.166";
		String response = given().log().all()
					.header("Content-Type", "application/json")
					.body(payload.DeleteBook(id))
				.when()
					.post("/Library/DeleteBook.php")
				.then().log().all()
					.assertThat()
						.statusCode(200)
						.extract()
						.asString();

		JsonPath jsonpath = ReUsableMethods.rawToJson(response);
		String msg = jsonpath.getString("msg");
		System.out.println("Message: " + msg);
	}
	
	// Data Provider for Test NG to enter data to test
	@DataProvider(name = "BookData")
	public Object[][] getData() {
		return new Object[][] { { "qetuo", "13579" }, { "sfhk", "2468" }, { "xvnzc", "3456" } };
	}

	private void StoreBookId(String id) {
		// Implement a way to store the IDs, e.g., in a static list
		// This is just an example; adjust the storage mechanism as needed
		addedBookIds.add(id);
	}

	@DataProvider(name = "BookIds")
	public Object[][] getBookIds() {
		// Convert the stored IDs to the format required by the DataProvider
		Object[][] ids = new Object[addedBookIds.size()][1];
		for (int i = 0; i < addedBookIds.size(); i++) {
			ids[i][0] = addedBookIds.get(i);
		}
		return ids;
	}
}
