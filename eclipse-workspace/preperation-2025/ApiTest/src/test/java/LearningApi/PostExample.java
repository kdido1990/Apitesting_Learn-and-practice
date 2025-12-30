package LearningApi;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PostExample {
public static void main(String[] args) {
	String baseUrl="https://jsonplaceholder.typicode.com/";
	String payload="{\"title\":\"Api testing\",\"body\":\"Practicing rest assured with copilot\",\"userId\":1}";
	Response response=RestAssured
			.given()
			.header("Content-Type","application/json")
			.body(payload)
			.post(baseUrl + "posts");
	assertEquals(201,response.getStatusCode());
	assertTrue(response.getBody().asString().contains("Api testing"));
	// Print output to console 
	System.out.println("Status Code: " + response.getStatusCode()); 
    System.out.println("Response Body: " + response.getBody().asPrettyString());
    //System.out.println("Response Body: " + response.getBody());

}
}
