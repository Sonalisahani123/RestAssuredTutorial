package com.rest.sendpayloaddifferentways;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;

public class SendPayloadAsFile {
	
	@BeforeClass
	public void create_requestresponsespecification()
	{
		RequestSpecBuilder requestBuilder=new RequestSpecBuilder()
				.setBaseUri("https://api.postman.com")
				.addHeader("X-Api-Key","PMAK-629edffbe35fb965a9f25392-a9e647899df89a50fe44137e7b44361c4a")
				.log(LogDetail.ALL);
		RestAssured.requestSpecification =requestBuilder.build();
		
		ResponseSpecBuilder responseBuilder = new ResponseSpecBuilder().expectStatusCode(200).
				expectContentType(ContentType.JSON).log(LogDetail.ALL);
		RestAssured.responseSpecification = responseBuilder.build();
	}
	
	@Test
	public void validate_post_request_payload_from_file()
	{
		
		File file=new File("src/test/resources/CreateworkspacePayload.json");
		given().body(file)
		.when().post("/workspaces")
		.then().log().all()
		.assertThat().body("workspace.name", equalTo("sonu workspace"));
		
		
	}
	
	

}
