package RESTAssuredTest.config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import org.junit.BeforeClass;

public class FootballConfig {
	private static RequestSpecification requestSpec;
	private static ResponseSpecification responseSpec;

	@BeforeClass
	public void setup() {
		RestAssured.config = RestAssuredConfig.config().sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation());

		setRequestSpec(new RequestSpecBuilder()
				.setBaseUri("https://api.football-data.org")
				.setBasePath("/v4")
				.addHeader("X-Auth-Token", "a37bc520f4c14c788d216cbf7d093c69")
				.addHeader("X-Response-Control", "minified")
				.addFilter(new RequestLoggingFilter())
				.addFilter(new ResponseLoggingFilter())
				.build());

		setResponseSpec(new ResponseSpecBuilder().expectStatusCode(200).build());
	}
	
//-------
	public static ResponseSpecification getResponseSpec() {
		return responseSpec;
	}

	public static void setResponseSpec(ResponseSpecification responseSpec) {
		FootballConfig.responseSpec = responseSpec;
	}

	public static RequestSpecification getRequestSpec() {
		return requestSpec;
	}

	public static void setRequestSpec(RequestSpecification requestSpec) {
		FootballConfig.requestSpec = requestSpec;
	}
//--------
}