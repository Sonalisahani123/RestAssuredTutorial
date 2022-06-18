package RestfulBooker;

import io.restassured.RestAssured;

public class PathParameterExample {

	public static void main(String[] args) {
		RestAssured.given()
		.log().all().baseUri("https://restful-booker.herokuapp.com/").basePath("{base path}/{booking Id}").pathParam("base path", "booking")
		.pathParam("booking Id", 10).when().get().then()
		.log().all();
		

	}

}
