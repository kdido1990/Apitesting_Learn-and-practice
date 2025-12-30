package apitestingdemoandlearning;

import static org.junit.jupiter.api.Assertions.assertEquals;


import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BearerTokenExample {
	public static void main(String[] args) {
		String token="your_actual_token_here";
		Response response=RestAssured.given()
				.header("Authorization","Bearer" +token)
				.get("https://reqres.in/api/users?page=2");
		assertEquals(200, response.getStatusCode());
		System.out.println("response : " +response.getBody().asPrettyString());
	}
}
