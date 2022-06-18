package com.udemy.om;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpecificationBuilder {
	
	RequestSpecification requestSpecification;
	ResponseSpecification responseSpecification;
	@BeforeClass
	public void setupResponseSpecificationBuilder()
	{
		requestSpecification=RestAssured.given().baseUri("https://api.postman.com").basePath("/workspaces");
		
		responseSpecification = new ResponseSpecBuilder()
				.expectStatusCode(200)
			    .expectStatusLine("HTTP/1.1 200 OK")
			    .expectContentType(ContentType.JSON)
			    .expectResponseTime(Matchers.lessThan(5000L))	
			    .build();
		
		
		
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
