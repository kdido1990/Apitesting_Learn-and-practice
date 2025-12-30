package projects;

import static org.junit.Assert.assertEquals;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DigestAuthDemo {
	public static void main(String[] args) { 
		Response res = RestAssured.given()
				.auth().digest("user", "passwd")
				.get("https://httpbin.org/digest-auth/auth/user/passwd"); 
		assertEquals(200, res.getStatusCode());
		System.out.println("Response: " + res.getBody().asPrettyString());
	}
}
