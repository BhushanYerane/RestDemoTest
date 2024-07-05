package RESTAssuredTest.sample;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

import RESTAssuredTest.config.VideoGameConfig;
import RESTAssuredTest.config.VideoGameEndpoints;

public class MyFirstTest extends VideoGameConfig {

    @Test
    public void myFirstTest() {
        given()
                .log().all()
        .when()
                .get("/videogame")
        .then()
                .log().all();

    }

   @Test
    public void myFirstTestWithEndpoint() {
        get(VideoGameEndpoints.getALL_VIDEO_GAMES())
                .then().log().all();
    }
}