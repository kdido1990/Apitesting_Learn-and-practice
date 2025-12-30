package LearningApi;

import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Post {
	public static void main(String[] args) {
Map<String, Object> payload=new HashMap<>();
payload.put("title","map example");
payload.put("body", "payload created using hash map");
payload.put("userId", 2);
Response response=RestAssured.given()
   .contentType("application/json")
   .body(payload)
   .post("https://jsonplaceholder.typicode.com/posts");
System.out.println("Response: " + response.getBody().asPrettyString());
}}