package com.authorization.test;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;

public class BaseClass {
	
	
	@BeforeClass
	public void setup_authenitcation()
	{
		RestAssured.authentication = RestAssured.preemptive().basic("postman", "password");
		RestAssured.baseURI = "https://postman-echo.com/basic-auth";
	}

}
