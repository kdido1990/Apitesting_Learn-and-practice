package apitestingdemoandlearning;

import static org.junit.jupiter.api.Assertions.assertEquals;


import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BasicAuth {
public static void main(String[] args) {
	//Basic authentication is a straightforward method to access  APIs 
	// by sending a username and password with your request
	Response response=RestAssured.given()
			.auth().basic("user", "passwd")
			.get("https://httpbin.org/basic-auth/user/passwd");
	assertEquals(200, response.getStatusCode());
	System.out.println("status code :" +response.getStatusCode());
	System.out.println("response body : " +response.getBody().asPrettyString());
}
}
