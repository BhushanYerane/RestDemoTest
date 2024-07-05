package RESTAssuredTest.sample;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class XmlPlaceholderTests {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://example.com"; // Replace with actual mock API base URL
    }

    @Test
    public void testFind() {
        Response response = get("/mock-xml-endpoint"); // Replace with actual endpoint
        XmlPath xmlPath = new XmlPath(response.asString());
        Map<String, ?> user = xmlPath.get("users.user.find { it.username == 'Bret' }");
        System.out.println("User Data: " + user);
    }

    @Test
    public void testFindAll() {
        Response response = get("/mock-xml-endpoint"); // Replace with actual endpoint
        XmlPath xmlPath = new XmlPath(response.asString());
        List<Map<String, ?>> users = xmlPath.getList("users.user.findAll { it.address.city == 'Lebsackbury' }");
        System.out.println("Users in Lebsackbury: " + users);
    }

    @Test
    public void testMin() {
        Response response = get("/mock-xml-endpoint"); // Replace with actual endpoint
        XmlPath xmlPath = new XmlPath(response.asString());
        int minUserId = xmlPath.getInt("users.user.collect { it.userId }.min()");
        System.out.println("Minimum User ID: " + minUserId);
    }

    @Test
    public void testMax() {
        Response response = get("/mock-xml-endpoint"); // Replace with actual endpoint
        XmlPath xmlPath = new XmlPath(response.asString());
        int maxUserId = xmlPath.getInt("users.user.collect { it.userId }.max()");
        System.out.println("Maximum User ID: " + maxUserId);
    }

    @Test
    public void testSum() {
        Response response = get("/mock-xml-endpoint"); // Replace with actual endpoint
        XmlPath xmlPath = new XmlPath(response.asString());
        int sumUserId = xmlPath.getInt("users.user.collect { it.userId }.sum()");
        System.out.println("Sum of User IDs: " + sumUserId);
    }

    @Test
    public void testAverage() {
        Response response = get("/mock-xml-endpoint"); // Replace with actual endpoint
        XmlPath xmlPath = new XmlPath(response.asString());
        List<Integer> userIds = xmlPath.getList("users.user.userId", Integer.class);
        double averageUserId = userIds.stream().mapToInt(Integer::intValue).average().orElse(0);
        System.out.println("Average User ID: " + averageUserId);
    }

    @Test
    public void testCount() {
        Response response = get("/mock-xml-endpoint"); // Replace with actual endpoint
        XmlPath xmlPath = new XmlPath(response.asString());
        int countPosts = xmlPath.getInt("users.user.size()");
        System.out.println("Count of Users: " + countPosts);
    }

    @Test
    public void testCollect() {
        Response response = get("/mock-xml-endpoint"); // Replace with actual endpoint
        XmlPath xmlPath = new XmlPath(response.asString());
        List<String> usernames = xmlPath.getList("users.user.username");
        System.out.println("Usernames: " + usernames);
    }

    @Test
    public void testGroupBy() {
        Response response = get("/mock-xml-endpoint"); // Replace with actual endpoint
        XmlPath xmlPath = new XmlPath(response.asString());
        Map<Integer, List<Map<String, ?>>> groupedByUserId = xmlPath.getMap("users.user.groupBy { it.userId }");
        System.out.println("Users Grouped by User ID: " + groupedByUserId);
    }
}
