package com.rest.sendpayloaddifferentways;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import java.io.File;

public class UploadFile {
	
	
	@Test
	public void upload_file_multipart_form_data()
	{
		
		given().baseUri("https://postman-echo.com")
		.multiPart(new File("src\\test\\resources\\filecheck.txt"))
		.when().post("/post")//  /post-this is called base path or end point
		.then().log().all()
		.assertThat().statusCode(200);
		
		
	}

}
