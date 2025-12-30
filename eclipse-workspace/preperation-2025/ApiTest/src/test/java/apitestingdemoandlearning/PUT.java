package apitestingdemoandlearning;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PUT {
	public static void main(String[] args) {
		String baseUrl="https://jsonplaceholder.typicode.com/";
		String payload="{\"userId\":1,\"title\":\"learn and master api testing with REST Assured\",\"body\":\"practice  makes perfect\"}";
		Response response=RestAssured
				.given()
				.header("Content-Type","application/json")
				.body(payload)
				.put(baseUrl + "posts/1");
		assertEquals(200, response.getStatusCode());
		assertTrue(response.getBody().asString().contains("REST"));
		System.out.println("status code :" +response.getStatusCode());
		System.out.println(response.getBody().asPrettyString());
}
}