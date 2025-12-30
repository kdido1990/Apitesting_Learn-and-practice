package projects;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FormAuthDemo {

	public static void main(String[] args) {
		Response res = RestAssured.given() 
				.contentType("application/x-www-form-urlencoded")
				.formParam("username", "user")
				.formParam("password", "passwd") 
				.post("https://httpbin.org/post"); 
		System.out.println("Response: " + res.getBody().asPrettyString());
	}

}
