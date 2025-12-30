package LearningApi;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.http.HttpResponse.BodyHandler;
import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PatchExample {
	public static void main(String[] args) {
	Map<String, Object> payload=new HashMap<>();
	payload.put("title", "API Testing");
	Response response=RestAssured
			.given()
			.header("Content-Type","application/json")
	.body(payload)
	.patch("https://jsonplaceholder.typicode.com/posts/1");
	System.out.println("status code :" + response.getStatusCode());
	System.out.println("response patch :" +response.getBody().asPrettyString());

	}
	}

