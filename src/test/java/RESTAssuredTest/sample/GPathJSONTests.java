package RESTAssuredTest.sample;

import org.testng.annotations.Test;
import RESTAssuredTest.config.FootballConfig;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.util.List;
import java.util.Map;

public class GPathJSONTests extends FootballConfig
{
	@Test
    public void extractMapOfElementWithFind() {
        Response respObj = given()
                	.spec(RestAssured.requestSpecification)
                .when()
                	.get("/competitions/WC/teams")
                .then()
                	.spec(RestAssured.responseSpecification)
                	.extract()
                	.response();
        		
        Map<String, ?> allTeamDataForSingleTeam = respObj.path("teams.find { it.name == 'Germany' }");

        System.out.println("All Team Data: " + allTeamDataForSingleTeam);
    }
	
	@Test
	public void extractSingleValueWithFind()
	{
		 Response respObj = get("/teams/20");
		 String runningCompetitions = respObj.path("runningCompetitions.find {it.id == 2011}.name");
		 System.out.println(runningCompetitions);
	}
	
	@Test
	public void extractListofValueWithFindAll()
	{
		 Response respObj = get("/teams/20");
		 List<String> runningCompetitions1 = respObj.path("runningCompetitions.find {it.id >2010}.name");
		 System.out.println(runningCompetitions1);
	}
	
}
