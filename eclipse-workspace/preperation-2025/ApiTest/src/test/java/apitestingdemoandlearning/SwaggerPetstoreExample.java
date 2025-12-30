package apitestingdemoandlearning;

import static org.junit.Assert.assertEquals;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SwaggerPetstoreExample {

	    public static void main(String[] args) {
	        // Base URI
	        RestAssured.baseURI = "https://petstore.swagger.io/v2";

	        // Step 1: Add a new pet
	        String newPet = "{ \"id\": 12345, \"name\": \"doggie\", \"status\": \"available\" }";
	        Response postRes = RestAssured.given()
	            .contentType("application/json")
	            .body(newPet)
	            .post("pet");

	        assertEquals(200, postRes.getStatusCode());
	        System.out.println("Added Pet: " + postRes.getBody().asPrettyString());

	        // Step 2: Fetch the pet by ID
	        Response getRes = RestAssured.get("pet/12345");
	        assertEquals(200, getRes.getStatusCode());
	        System.out.println("Fetched Pet: " + getRes.getBody().asPrettyString());
	    }
	}


