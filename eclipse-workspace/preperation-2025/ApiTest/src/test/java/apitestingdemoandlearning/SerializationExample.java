package apitestingdemoandlearning;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializationExample {
public static void main(String[] args)  {
	User user=new User(1,"jkb");
	ObjectMapper mapper=new ObjectMapper();
	try {
	String jsonString=mapper.writeValueAsString(user);
	System.out.println("Serialized Json : "+jsonString); 
	} catch (JsonProcessingException e) { 
		System.out.println("Serialization failed: " + e.getMessage()); 
		}

	try {
		String jsonString = "{\"id\":2,\"name\":\"QA Tester\"}";
		User user1=mapper.readValue(jsonString, User.class);
		System.out.println("deserialization object :");
		System.out.println("id :" +user1.getId());
		System.out.println("name :" +user1.getName());
	}  catch (Exception e) {
e.printStackTrace();	}
}
}

