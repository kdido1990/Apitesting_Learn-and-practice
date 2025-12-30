package projects;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.junit.Assert.assertEquals;
public class BasicAuthDemo {
	    public static void main(String[] args) {
	        Response res = RestAssured.given()
	            .auth().basic("user", "passwd")   // credentials
	            .get("https://httpbin.org/basic-auth/user/passwd");

	        assertEquals(200, res.getStatusCode());
	        System.out.println("Response: " + res.getBody().asPrettyString());
	    }
	}


