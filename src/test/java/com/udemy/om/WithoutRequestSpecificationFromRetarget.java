package com.udemy.om;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class WithoutRequestSpecificationFromRetarget {
	
	@Test
	public void getAllBookingsWithoutRS()
	{
		//BDD approach
		//Given
		RestAssured.given().baseUri("https://restful-booker.herokuapp.com").basePath("/booking")
		//when
		.when()
		//then
		.then()
		.statusLine("HTTP/1.1 200 OK");
	}
		
	@Test
	public void getBookingDetailsWithInvalidFirstName()
	{
		//Given
		RestAssured.given().baseUri("https://restful-booker.herokuapp.com").basePath("/booking")
		//when
		.when()
        //Then
		.then()
		.statusLine("HTTP/1.1 200 OK");
		
		
	}
	
	
	
	public void justForPractices()
	{/*
		 * RestAssured.given().baseUri(null).body("") .when().post("")
		 * .then().assertThat().body(null, null);
		 */
	}
	

}
