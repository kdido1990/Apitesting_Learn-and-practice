package apitestingdemoandlearning;


import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GET {
	public static void main(String[] args) {
		String baseUrl="https://jsonplaceholder.typicode.com/";
		Response response=RestAssured
				.given()
				.headers("Content-Type","application/json")
				.get(baseUrl + "photos");
		assertEquals(200, response.getStatusCode());
		System.out.println("status code :" +response.getStatusCode());
		System.out.println("response body :" +response.getBody().asPrettyString());
		String firstString=response.jsonPath().getString("[5].title");
		assertTrue(firstString.contains("aliquid"));
		System.out.println("First photo title : " +firstString);

}}
