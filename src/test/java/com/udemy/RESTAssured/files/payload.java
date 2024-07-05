package com.udemy.RESTAssured.files;

public class payload {
	
	public static String  AddBook(String isbn, String aisle)
	{
		String payload ="{\r\n"
				+ "\r\n"
				+ "\"name\":\"Learn Automation with Python\",\r\n"
				+ "\"isbn\":\""+ isbn +"\",\r\n"
				+ "\"aisle\":\""+ aisle +"\",\r\n"
				+ "\"author\":\"John Shade\"\r\n"
				+ "}\r\n"
				+ "";
		return payload;
	}
	
	public static String DeleteBook(String id) {
        return "{\n" +
                "\"ID\" : \"" + id + "\"\n" +
                "}";
    }
	
	public static String AddPlace()
	{
		return "{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.383494,\r\n"
				+ "    \"lng\": 33.427362\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"Frontline house\",\r\n"
				+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"http://google.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n"
				+ "}\r\n"
				+ "";
	}
	
	public static String updateaddress(String plcID)
	{
		return "{\r\n"
				+ "\"place_id\":\""+ plcID +"\",\r\n"
				+ "\"address\":\"70 Winter Walk, USA\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}\r\n"
				+ "";
	}
	
	public static String courseDetails()
	{
		return "{\r\n"
				+ "\"dashboard\": {\r\n"
				+ "\"purchaseAmount\": 1185,\r\n"
				+ "\"website\": \"rahulshettyacademy.com\",\r\n"
				+ "\"Total Copies\": \"25\"\r\n"
				+ "},\r\n"
				+ "\"courses\":[\r\n"
				+ "{\r\n"
				+ "\"title\": \"Selenium Python\",\r\n"
				+ "\"price\": 50,\r\n"
				+ "\"copies\": 6\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"title\": \"Cypress\",\r\n"
				+ "\"price\": 40,\r\n"
				+ "\"copies\": 4\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"title\": \"Karate API\",\r\n"
				+ "\"price\": 45,\r\n"
				+ "\"copies\": 10\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"title\": \"REST Assured Testing\",\r\n"
				+ "\"price\": 55,\r\n"
				+ "\"copies\": 5\r\n"
				+ "}]}";
	}
	
	public static String UserJSONData()
	{
		return "{\r\n"
				+ "    \"name\": \"John Doe\",\r\n"
				+ "    \"gender\": \"male\",\r\n"
				+ "    \"email\": \"johndoe@example.com\",\r\n"
				+ "    \"status\": \"active\",\r\n"
				+ "    \"address\": {\r\n"
				+ "        \"street\": \"123 Main St\",\r\n"
				+ "        \"city\": \"Anytown\",\r\n"
				+ "        \"state\": \"CA\",\r\n"
				+ "        \"postalCode\": \"12345\"\r\n"
				+ "    },\r\n"
				+ "    \"phones\": [\r\n"
				+ "        {\r\n"
				+ "            \"type\": \"home\",\r\n"
				+ "            \"number\": \"123-456-7890\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"type\": \"work\",\r\n"
				+ "            \"number\": \"987-654-3210\"\r\n"
				+ "        }\r\n"
				+ "    ],\r\n"
				+ "    \"projects\": [\r\n"
				+ "        {\r\n"
				+ "            \"name\": \"Project A\",\r\n"
				+ "            \"role\": \"Developer\",\r\n"
				+ "            \"technologies\": [\"Java\", \"Spring\", \"REST\"]\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"name\": \"Project B\",\r\n"
				+ "            \"role\": \"Lead\",\r\n"
				+ "            \"technologies\": [\"JavaScript\", \"React\", \"Node.js\"]\r\n"
				+ "        }\r\n"
				+ "    ]\r\n"
				+ "}\r\n"
				+ "";
	}
	
	public static String xxJd()
	{
		String jsonPayload ="{\r\n"
				+ "	\"id\": \"0001\",\r\n"
				+ "	\"type\": \"donut\",\r\n"
				+ "	\"name\": \"Cake\",\r\n"
				+ "	\"ppu\": 0.55,\r\n"
				+ "	\"batters\":\r\n"
				+ "		{\r\n"
				+ "			\"batter\":\r\n"
				+ "				[\r\n"
				+ "					{ \"id\": \"1001\", \"type\": \"Regular\" },\r\n"
				+ "					{ \"id\": \"1002\", \"type\": \"Chocolate\" },\r\n"
				+ "					{ \"id\": \"1003\", \"type\": \"Blueberry\" },\r\n"
				+ "					{ \"id\": \"1004\", \"type\": \"Devil's Food\" }\r\n"
				+ "				]\r\n"
				+ "		},\r\n"
				+ "	\"topping\":\r\n"
				+ "		[\r\n"
				+ "			{ \"id\": \"5001\", \"type\": \"None\" },\r\n"
				+ "			{ \"id\": \"5002\", \"type\": \"Glazed\" },\r\n"
				+ "			{ \"id\": \"5005\", \"type\": \"Sugar\" },\r\n"
				+ "			{ \"id\": \"5007\", \"type\": \"Powdered Sugar\" },\r\n"
				+ "			{ \"id\": \"5006\", \"type\": \"Chocolate with Sprinkles\" },\r\n"
				+ "			{ \"id\": \"5003\", \"type\": \"Chocolate\" },\r\n"
				+ "			{ \"id\": \"5004\", \"type\": \"Maple\" }\r\n"
				+ "		]\r\n"
				+ "}\r\n"
				+ "  ";
		return jsonPayload;
	}
}
