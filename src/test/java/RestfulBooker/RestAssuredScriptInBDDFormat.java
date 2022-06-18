package RestfulBooker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class RestAssuredScriptInBDDFormat {

	public static void main(String[] args) {
		//Given-Build request
		RestAssured
		.given()
		.log()
		   .all()
		   .baseUri("https://restful-booker.herokuapp.com/")
		   .basePath("booking")
		   .body("{\r\n"+
				    "  \"firstname\" : \"Sonali\",\r\n"+
				    "  \"lastname\" : \"Sahani\",\r\n"+
				    "  \"totalprice\" : 111,\r\n"+
				    "  \"depositpaid\" : true,\r\n"+
				    "  \"bookingdates\" : {\r\n"+
				    "  \"checkin\" :\"2020-01-01\",\r\n"+
				    "   \"checkout\" : \"2021-01-01\"\r\n"+
				    " },\r\n"+
				    "  \"additionalneeds\" : \"lunch\"\r\n"+
				 "}")
		   .contentType(ContentType.JSON)
		//When
		   .when()
		     .post()
		     
		//Then
		     .then()
		      .statusCode(200);

	}

}
