package rahul.youtube.practices.rest;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utility.Payload;
import utility.ReusableMethods;

public class Basic {

	public static void main(String[] args) {
		// give the  base URI
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json").body(Payload.addPlace())
		   .post("/maps/api/place/add/json")
		   .then().assertThat().statusCode(200).body("scope", equalTo("APP"))
		   .body("status", equalTo("OK"))
		   .header("Server", equalTo("Apache/2.4.41 (Ubuntu)")).extract().response().asString();
		
		//print the response
		System.out.println(response);
		
      JsonPath js= new JsonPath(response);
      String placeid= js.get("place_id");
      System.out.println(placeid);
      
    //update place id for the different address
		
      String newAddress = "70 winter walk, USA";
    		given().queryParam("key", "qaclick123").header("Content-Type","application/json").body("{\r\n"
    				+ "\"place_id\":\""+placeid+"\",\r\n"
    				+ "\"address\":\""+newAddress+"\",\r\n"
    				+ "\"key\":\"qaclick123\"\r\n"
    				+ "}").when()
    		.put("/maps/api/place/update/json").then().log().all().assertThat().body("msg", equalTo("Address successfully updated"));
    		
    		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&7");
         // get place which  updated to new address
    		String addressResponse=given().log().all().queryParam("key", "qaclick123")
    		.queryParam("place_id",placeid )
    		.when().get("/maps/api/place/get/json").
    		then().log().all().assertThat().statusCode(200).assertThat().body("address",equalTo("70 winter walk, USA")).extract().response().asString();
    		
    	
			
			 JsonPath js1=ReusableMethods.convertresponseToJson(addressResponse);
			 
			 String
			  actual_address=js1.get("address"); 
			 System.out.println("actual_address" +
			  actual_address);
			 Assert.assertEquals(newAddress,actual_address );
			 
         System.out.println("addressResponse"+ addressResponse);
	}

	

}
