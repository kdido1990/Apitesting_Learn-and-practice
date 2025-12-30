package apitestingdemoandlearning;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PATCH {
	public static void main(String[] args) {
		String baseUrl="https://jsonplaceholder.typicode.com/";
		String payload="{\"username\":\"Dido\"}";
		Response response=RestAssured
				.given()
				.header("Content-Type","application/json")
				.body(payload)
				.patch(baseUrl + "users/1");
		assertEquals(200, response.getStatusCode());
		assertTrue(response.getBody().asPrettyString().contains("Dido"));
		System.out.println("status code :" +response.getStatusCode());
		System.out.println("response body : " +response.getBody().asPrettyString());
}}
