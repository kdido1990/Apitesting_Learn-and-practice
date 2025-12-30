package LearningApi;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*; 
import static org.hamcrest.Matchers.*;

public class RestApi {
    @Test 
    public void testCreatePost() {
    	given()
    	.baseUri("https://jsonplaceholder.typicode.com")
    	.contentType("application/json")
     .when()
    	.get("/posts")
    	.then()
    	.log().all()
    	.statusCode(200);
    	
    }}