package com.udemy.om;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
public class AutomatePOST {
	
	
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
	public void validate_post_request_BDDFormat()
	{
		given().body("{\r\n"
				+ "    \"workspace\": {\r\n"
				+ "        \"name\": \"sonu workspace\",\r\n"
				+ "        \"type\": \"personal\",\r\n"
				+ "        \"description\": \"Some description\"\r\n"
				+ "        \r\n"
				+ "    }\r\n"
				+ "}")
		.when().post("/workspaces")
		.then().assertThat().body("workspace.name", equalTo("sonu workspace"));
		
	}
	

}
