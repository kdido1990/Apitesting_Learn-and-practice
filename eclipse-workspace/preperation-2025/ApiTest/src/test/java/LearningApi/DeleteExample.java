package LearningApi;


import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteExample {
public static void main(String[] args) {
	String baseUrl = "https://jsonplaceholder.typicode.com/";
	String payload = "{\"title\":\"Api testing\",\"body\":\"Practicing rest assured with copilot\",\"userId\":1}";

	// Step 1: POST (create)
	Response response = RestAssured
	        .given()
	        .header("Content-Type", "application/json")
	        .body(payload)
	        .post(baseUrl + "posts");

	System.out.println("POST Status: " + response.getStatusCode());
	System.out.println("POST Body: " + response.getBody().asPrettyString());

	// Extract ID
//	int id = postResponse.jsonPath().getInt("id");
	String title = response.jsonPath().getString("title");
	System.out.println("Created ID: " + title);

	// Step 2: DELETE (remove)
	Response deleteResponse = RestAssured
	        .given()
	        .header("Content-Type", "application/json")
	        .delete(baseUrl + "posts/" + title);

	System.out.println("DELETE Status: " + deleteResponse.getStatusCode());
	System.out.println("DELETE Body: " + deleteResponse.getBody().asPrettyString());

	 }
}
