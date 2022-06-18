package RestfulBooker;

import io.restassured.RestAssured;

public class GetBooking {
	public static void main(String[] args){
	
	//Build Request
		RestAssured
		.given()
		.log()
		.all()
		.baseUri("https://restful-booker.herokuapp.com/")
		.basePath("booking/{id}")
		.pathParam("id", 1)
		.when()
		  .get()
		.then()
		  .log()
		  .all()
		  .statusCode(200);
		
	//Hit the request and get the response
	//validate the response

	}
}
