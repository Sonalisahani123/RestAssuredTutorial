package rahul.youtube.practices.rest;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import utility.Payload;

public class AddPlaceApiTest {

	public static void main(String[] args) {
		
		//Validate the add place api working fine or not
		/*
		 * Given-all input details 
		 * When-submit the api 
		 * Then=Validate the response
		 */
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response=given().queryParam("key","qaclick123").log().all()
		.header("Content-Type","application/json")
		.body(Payload.addPlace())
		.when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope",equalTo("APP")).extract().response().asString();
		
		System.out.println("response: "+ response);
		
		JsonPath jsonpath=new JsonPath(response);
		String place_id=jsonpath.getString("place_id");
		System.out.println("place_id:" + place_id);
		
		
	}

}
