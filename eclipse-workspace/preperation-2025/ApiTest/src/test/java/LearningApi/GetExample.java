package LearningApi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetExample {
public static void main(String[] args) {
	String baseUrl="https://jsonplaceholder.typicode.com/";
	Response response=RestAssured
			.given()
			.header("Content-Type","application/json")
			.get(baseUrl + "posts");	

	assertEquals(200, response.getStatusCode());
	assertTrue(response.getBody().asPrettyString().contains("userId"));
	
	System.out.println("Status Code :" +response.getStatusCode());
	System.out.println("response :" +response.getBody().asPrettyString());

}
}
