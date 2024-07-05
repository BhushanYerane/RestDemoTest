package RESTAssuredTest.sample;

import static io.restassured.RestAssured.get;

import java.util.List;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class JsonPlaceholderTests {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    public void testFind() {
        Response response = get("/users");
        Map<String, ?> user = response.path("find { it.username == 'Bret' }");
        System.out.println("User Data: " + user);
    }

    @Test
    public void testFindAll() {
        Response response = get("/users");
        List<Map<String, ?>> users = response.path("findAll { it.address.city == 'Lebsackbury' }");
        System.out.println("Users in Lebsackbury: " + users);
    }

    @Test
    public void testMin() {
        Response response = get("/posts");
        int minUserId = response.path("min { it.userId }.userId");
        System.out.println("Minimum User ID: " + minUserId);
    }

    @Test
    public void testMax() {
        Response response = get("/posts");
        int maxUserId = response.path("max { it.userId }.userId");
        System.out.println("Maximum User ID: " + maxUserId);
    }

    @Test
    public void testSum() {
        Response response = get("/posts");
        int sumUserId = response.path("sum { it.userId }");
        System.out.println("Sum of User IDs: " + sumUserId);
    }

    @Test
    public void testAverage() {
        Response response = get("/posts");
        List<Integer> userIds = response.path("userId");
        double averageUserId = userIds.stream().mapToInt(Integer::intValue).average().orElse(0);
        System.out.println("Average User ID: " + averageUserId);
    }

    @Test
    public void testCount() {
        Response response = get("/posts");
        int countPosts = response.path("size()");
        System.out.println("Count of Posts: " + countPosts);
    }

    @Test
    public void testCollect() {
        Response response = get("/users");
        List<String> usernames = response.path("collect { it.username }");
        System.out.println("Usernames: " + usernames);
    }

    @Test
    public void testGroupBy() {
        Response response = get("/posts");
        Map<Integer, List<Map<String, ?>>> groupedByUserId = response.path("groupBy { it.userId }");
        System.out.println("Posts Grouped by User ID: " + groupedByUserId);
    }
}
