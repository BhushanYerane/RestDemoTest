package RESTAssuredTest.sample;

import org.testng.annotations.Test;
import RESTAssuredTest.config.VideoGameConfig;
import RESTAssuredTest.config.VideoGameEndpoints;
import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import objects.videoGames;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.lessThan;

public class VideoGameTests extends VideoGameConfig {
	
	 String gameBodyJson = "{\n" +
             "  \"category\": \"Platform\",\n" +
             "  \"name\": \"Mario\",\n" +
             "  \"rating\": \"Mature\",\n" +
             "  \"releaseDate\": \"2025-05-04\",\n" +
             "  \"reviewScore\": 88\n" +
             "}";
	 String gameBodyXml = "<VideoGameRequest>\n" +
             "\t<category>Platform</category>\n" +
             "\t<name>Mario</name>\n" +
             "\t<rating>Mature</rating>\n" +
             "\t<releaseDate>2025-05-04</releaseDate>\n" +
             "\t<reviewScore>88</reviewScore>\n" +
             "</VideoGameRequest>";

    @Test
    public void getAllGames() {
        given()
        .when()
                .get(VideoGameEndpoints.getALL_VIDEO_GAMES())
        .then();
    }

    @Test
    public void createNewGameByJSON() {
        given()
                .body(gameBodyJson)
        .when()
                .post(VideoGameEndpoints.getALL_VIDEO_GAMES())
        .then();
    }

    @Test
    public void createNewGameByXML() {
        given()
                .body(gameBodyXml)
                .contentType("application/xml")
                .accept("application/xml")
        .when()
                .post(VideoGameEndpoints.getALL_VIDEO_GAMES())
        .then();
    }
    
    @Test
    public void updateGame()
    {
    	given()
    		.body(gameBodyJson)
    	.when()
    		.put("videogame/3")
    	.then();
    }
    
    @Test
    public void deleteGame()
    {
    	given()
    		.accept("text/plain")
    	.when()
    		.delete("videogame/8")
    	.then();
    }
    
    @Test
    public void getSingleGame()
    {
    	given()
    		.params("videoGameId",1)
    	.when()
    		.get(VideoGameEndpoints.getSINGLE_VIDEO_GAME())
    	.then();
    }
    
    @Test
    public void testVideoGameSerializationByJSON() {
        videoGames videoGame = new videoGames("Zendulala", "babalala", "Mature-DW", "2025-04-04", 88);

        given()
                .body(videoGame)
       .when()
                .post(VideoGameEndpoints.getALL_VIDEO_GAMES())
       .then();
    }
    
    @Test
    public void convertJsonToPojo() {
        Response response =
                given()
                        .pathParam("videoGameId", 5)
                .when()
                        .get(VideoGameEndpoints.getSINGLE_VIDEO_GAME());

        videoGames videoGame = response.getBody().as(videoGames.class);

        System.out.println(videoGame.toString());
    }
    
  //  @Test
    @Test
	public void testVideoGameSchemaXML()
    {
    	given()
    		.pathParam("videoGameId",5)
    		.accept("application/xml")
    	.when()
    		.get(VideoGameEndpoints.getSINGLE_VIDEO_GAME())
    	.then()
    		.body(RestAssuredMatchers.matchesXsdInClasspath("videoGameXSD.xsd"));
    }
    
  //  @Test
    @Test
	public void testVideoGameSchemaJSON() {
    	
    	given()
		.pathParam("videoGameId",5)
		.accept("application/json")
	.when()
		.get(VideoGameEndpoints.getSINGLE_VIDEO_GAME())
	.then()
		.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("videoGameJsonSchema.json"));  	
    }
    
    @Test
    public void captureResponseTime()
    {
    	long responseTime = get(VideoGameEndpoints.getALL_VIDEO_GAMES()).time();
    	System.out.println("Response Time in MS: "+responseTime);
    }
    
    @Test
    public void assertOnResponseTime()
    {
    		get(VideoGameEndpoints.getALL_VIDEO_GAMES())
    	.then().time(lessThan(1000L));
    }
    
}
