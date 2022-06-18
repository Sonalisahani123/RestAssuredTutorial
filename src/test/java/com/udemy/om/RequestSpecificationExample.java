package com.udemy.om;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class RequestSpecificationExample {
	RequestSpecification requestspecification;
	
	@BeforeClass
	public void beforeClass()
	{
		        requestspecification=given().
				baseUri("https://api.postman.com").
				header("X-Api-Key","PMAK-629edffbe35fb965a9f25392-a9e647899df89a50fe44137e7b44361c4a");
	}
	
	@Test
	public void validate_status_code()
	{
	
		//1st way
		/* given(requestspecification). */
		//2nd way
		given().spec(requestspecification).
		when().
		   get("/workspaces").
		then().
		  log().all().
		  assertThat().
		  statusCode(200);
	}
	
	@Test
	public void validate_response_body()
	{
		//1st way
		/* given(requestspecification). */
		//2nd way
		given().spec(requestspecification).
		when().
		   get("/workspaces").
		then().
		  log().all().
		  assertThat().
		  statusCode(200).body("workspaces[0].name", equalTo("My Workspace"));
		
	}
	
	
	public void validate_response_body_nonBDD()
     {
		Response response=requestspecification.get("/workspaces").then().log().all().extract().response();
		assertThat(response.statusCode(),is(equalTo(200)));
		assertThat(response.path("workspaces[0].name").toString(), equalTo("My Workspace"));
       
     }
}
	
