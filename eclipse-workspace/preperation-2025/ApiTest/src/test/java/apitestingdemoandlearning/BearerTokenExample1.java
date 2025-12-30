package apitestingdemoandlearning;

import static org.junit.Assert.assertEquals;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BearerTokenExample1 {
    public static void main(String[] args) {
    
    	             Response loginRes = RestAssured.given()
    	            .contentType("application/json")
    	            .body("{\"email\":\"eve.holt@reqres.in\",\"password\":\"cityslicka\"}")
    	            .post("https://reqres.in/api/login");

    	          // Debug: print raw response
    	             System.out.println("Login Response: " + loginRes.getBody().asString());
    	             // Step 2: Extract token 
    	             if (loginRes.getHeader("Content-Type").contains("application/json")) { 
    	            	 String token = loginRes.jsonPath().getString("token"); 
    	            	 System.out.println("Token: " + token); } 
    	             else { 
    	            	 System.out.println("Response is not JSON, cannot parse with JsonPath."); }
    	          
    	            
    	    }
    	}

    
