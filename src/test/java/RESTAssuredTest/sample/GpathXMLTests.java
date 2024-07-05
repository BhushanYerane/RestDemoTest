package RESTAssuredTest.sample;

import static io.restassured.RestAssured.get;

import java.util.List;

import org.testng.annotations.Test;

import RESTAssuredTest.config.VideoGameConfig;
import RESTAssuredTest.config.VideoGameEndpoints;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.path.xml.XmlPath;
import io.restassured.path.xml.element.*;

public class GpathXMLTests extends VideoGameConfig 
{
	//@BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://videogamedb.uk:443/api/v2/";
    }
	
	@Test
	public void getFirstGameInList()
	{
		//Response resp = get(VideoGameEndpoints.getALL_VIDEO_GAMES());
		Response resp = get("https://videogamedb.uk:443/api/v2/videogame");
		String name = resp.path("List.item.name[1]");
		System.out.println(name);
	}
	
	@Test
	public void getAttribute()
	{
		//Response resp = get(VideoGameEndpoints.getALL_VIDEO_GAMES());
		Response resp = get("https://videogamedb.uk:443/api/v2/videogame");
		String category = resp.path("List.item[0].@category");
		System.out.println(category);
	}
	
	@Test
	public void getListOfXmlNodes()
	{
		String responseAsString = get("https://videogamedb.uk:443/api/v2/videogame").asString();
		List<Node> allResults = XmlPath.from(responseAsString).get("List.item.findAll {element -> return element}");
		System.out.println(allResults.get(2).get("name").toString());
	}
	
	@Test
    public void getListOfXmlNodesByFindAllOnAttribute() {
        String responseAsString = get(VideoGameEndpoints.ALL_VIDEO_GAMES).asString();

        List<Node> allDrivingGames = XmlPath.from(responseAsString).get(
                "List.item.findAll { game -> def category = game.@category; category == 'Driving' }"
        );

        System.out.println(allDrivingGames.get(0).get("name").toString());
    }

    @Test
    public void getSingleNode() {
        String responseAsString = get(VideoGameEndpoints.ALL_VIDEO_GAMES).asString();

        Node videoGame = XmlPath.from(responseAsString).get(
                "List.item.find { game -> def name = game.name; name == 'Tetris' }"
        );

        String videoGameName = videoGame.get("name").toString();

        System.out.println(videoGameName);
    }

    @Test
    public void getSingleElementDepthFirstSearch() {
        String responseAsString = get(VideoGameEndpoints.ALL_VIDEO_GAMES).asString();

        int reviewScore = XmlPath.from(responseAsString).getInt(
                "**.find { it.name == 'Gran Turismo 3' }.reviewScore"
        );

        System.out.println(reviewScore);
    }

    @Test
    public void getAllNodesBasedOnCondtion() {
        String responseAsString = get(VideoGameEndpoints.ALL_VIDEO_GAMES).asString();

        int reviewScore = 90;

        List<Node> allVideoGamesOverCertainScore = XmlPath.from(responseAsString).get(
                "List.item.findAll { it.reviewScore.toFloat() >= " + reviewScore + "}"
        );

        System.out.println(allVideoGamesOverCertainScore);
    }
}
