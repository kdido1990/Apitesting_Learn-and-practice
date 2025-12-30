package apitestingdemoandlearning;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class POST {
public static void main(String[] args) {
String baseUrl="https://jsonplaceholder.typicode.com/";
String payload="{\"userId\":1,\"title\":\"learn and master api testing with REST Assured\",\"body\":\"practice  makes perfect\"}";
Response response=RestAssured
 .given()
  .header("Content-Type","application/json")
  .body(payload)
  .post(baseUrl + "posts");
assertEquals(201, response.getStatusCode());
System.out.println(" post body : " +response.getBody().asPrettyString());
System.out.println("status code : " +response.getStatusCode());

//put method
}}