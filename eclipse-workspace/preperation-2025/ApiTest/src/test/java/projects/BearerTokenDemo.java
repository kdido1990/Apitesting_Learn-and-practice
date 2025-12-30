package projects;

import static org.junit.Assert.assertEquals;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BearerTokenDemo {

	public static void main(String[] args) { 
		// Step 1: Login to get token 
		Response loginRes = RestAssured.given() 
				.contentType("application/json") 
				.body("{\"email\":\"eve.holt@reqres.in\",\"password\":\"cityslicka\"}") 
				.post("https://reqres.in/api/users"); 
		System.out.println("Login Response: " + loginRes.getBody().asString());
        if (loginRes.getHeader("Content-Type").contains("application/json")) { 

		String token = loginRes.jsonPath().getString("token");
		System.out.println("Bearer Token: " + token);
		
		// Step 2: Use token in Authorization header 
		Response userRes = RestAssured.given() 
				.header("Authorization", "Bearer " + token) 
				.get("https://reqres.in/api/users?page=2"); 
		
		assertEquals(200, userRes.getStatusCode()); 
		System.out.println("User Response: " + userRes.getBody().asPrettyString()); } else {
			 
            	 System.out.println("Response is not JSON, cannot parse with JsonPath.");
            	 }
	}
		}
	