package apitestingdemoandlearning;


import static org.junit.jupiter.api.Assertions.assertEquals;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DELETE {
	public static void main(String[] args) {
		String baseUrl="https://jsonplaceholder.typicode.com/comments";
		int id=31;
		Response response=RestAssured.given()
			.log().all()
			.delete(baseUrl +"/" +id)
			.then()
			.log().all()
			.extract()
			.response();
		
		assertEquals(200, response.getStatusCode());
		System.out.println("status code : " + response.getStatusCode());
		System.out.println("resource body : " +response.getBody().asPrettyString());

					
}}
