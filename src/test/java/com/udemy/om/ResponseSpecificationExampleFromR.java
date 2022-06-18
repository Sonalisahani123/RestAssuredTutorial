package com.udemy.om;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpecificationExampleFromR {
	
	RequestSpecification requestSpecification;
	ResponseSpecification responseSpecification;
	@BeforeClass
	public void setupRequestSpecification()
	{
		requestSpecification=RestAssured.given().baseUri("https://api.postman.com").basePath("/workspaces");
		responseSpecification=RestAssured.expect();
		responseSpecification.contentType(ContentType.JSON);
		responseSpecification.statusCode(200);
		responseSpecification.time(Matchers.lessThan(5000L));
		responseSpecification.statusLine("HTTP/1.1 200 OK");
		
		
		
	}
	
	@Test
	public void validate_workspace_status_code()
	{
		//BDD approach
		//Given
		RestAssured.given(requestSpecification)
		//when
		.when()
		//then
		.then().spec(responseSpecification);
		
	}
		
	@Test
	public void validate_workspaces_response_body()
	{
		given().spec(requestSpecification).
		when().  
		then().spec(responseSpecification);
		 
		 
		
	}
	
	
	
	
}
