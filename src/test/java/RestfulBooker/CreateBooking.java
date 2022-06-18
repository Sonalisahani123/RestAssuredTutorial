package RestfulBooker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreateBooking {

	public static void main(String[] args) {
		//Build Request
		RequestSpecification requestSpecification=RestAssured.given();
		requestSpecification=requestSpecification.log().all();
		requestSpecification= requestSpecification.log().all();
            requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
            requestSpecification.basePath("booking");
            requestSpecification.body("{\r\n"+
    "  \"firstname\" : \"Jim\",\r\n"+
    "  \"lastname\" : \"Brown\",\r\n"+
    "  \"totalprice\" : 111,\r\n"+
    "  \"depositpaid\" : true,\r\n"+
    "  \"bookingdates\" : {\r\n"+
    "  \"checkin\" :\"2018-01-01\",\r\n"+
    "   \"checkout\" : \"2019-01-01\"\r\n"+
    " },\r\n"+
    "  \"additionalneeds\" : \"Breakfast\"\r\n"+
 "}");

	
            requestSpecification.contentType(ContentType.JSON);
	//Hit the request and get the response
	Response response= requestSpecification.post();
	
	//validate response
	ValidatableResponse validatableresponse=response.then().log().all();
	validatableresponse.statusCode(200);
	System.out.println();
	

}
}
