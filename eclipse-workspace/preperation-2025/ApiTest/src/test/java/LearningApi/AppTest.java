package LearningApi;
import org.junit.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*; 
import static org.hamcrest.Matchers.*;

import javax.management.InvalidApplicationException;

public class AppTest {



	static {
	RestAssured.baseURI="https://jsonplaceholder.typicode.com";
	}
	
	@Test
public void testGetResource() {
	// get method
	given()
	 .when()
	   .get("/posts/3")
	 .then()
	   .statusCode(200)
	   .body("id",equalTo(3));
}
	
	// POST - Create resource
	@Test 
	public void testCreateResource() { 
		given() 
		.header("Content-Type", "application/json") 
		.body("{\"title\":\"foo\",\"body\":\"bar\",\"userId\":1}")
		.when() .post("/posts") .then() .statusCode(201)
		.body("title", equalTo("foo")) 
		.body("body", equalTo("bar")) 
		.body("userId", equalTo(1)); }
	
	// PUT - Update/replace resource
@Test 
public void testUpdateResource() {
	given() 
	.header("Content-Type", "application/json") 
	.body("{\"id\":1,\"title\":\"updated\",\"body\":\"new body\",\"userId\":1}") 
	.when() 
	.put("/posts/1") 
	.then() 
	.statusCode(200) 
	.body("title", equalTo("updated"))
	.body("body", equalTo("new body")); }

//PATCH - Partial update
@Test
public void testPatchResource() { 
	given() 
	.header("Content-Type", "application/json") 
	.body("{\"title\":\"patched title\"}")
	.when() 
	.patch("/posts/1") 
	.then() 
	.statusCode(200)
	.body("title", equalTo("patched title")); }

//DELETE - Remove resource 
@Test
public void testDeleteResource() { 
	given() 
	.when() 
	.delete("/posts/1") 
	.then()
	.statusCode(anyOf(equalTo(200), equalTo(204))); // JSONPlaceholder fakes deletion, returns 200 instead of 204 }
}

}