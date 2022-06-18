package com.authorization.test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class BasicAuthenticationCheck {
	
	
	@Test
	public void  basic_preemtive_authentication_check()
	{
		
		int code=RestAssured.given().auth().preemptive().basic("postman", "password")
		.when()
		.get("https://postman-echo.com/basic-auth")
		.getStatusCode();
		System.out.println("Response code from server:" + code);
		
		
	}
	
	@Test
	public void get_user_Data() {
		
		String responeBody=RestAssured.given().auth().preemptive().basic("postman", "password")
		.when().get("https://postman-echo.com/basic-auth")
		.then().extract().response().asString();
		
		System.out.println("Data from get API:" + responeBody);
		
	}
	
	

}
