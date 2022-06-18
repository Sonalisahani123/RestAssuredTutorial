package com.restpractice.toolsqa;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredGETApiTest {
	
	@Test(enabled=false)
	public void getBookDetails()
	
	{
		RestAssured.baseURI="https://demoqa.com/BookStore/v1/Books";
		RequestSpecification httprequest=RestAssured.given();
		Response response=httprequest.request(Method.GET);
		System.out.println("status received:"+ response.getStatusLine() );
		System.out.println("Response:" + response.prettyPrint());
	}
	
	@Test(enabled=false)
	public void getBookDetails2ndWay()
	{
		RestAssured.baseURI="https://demoqa.com/BookStore/v1/Books";
		RequestSpecification httprequest=RestAssured.given();
		Response response=httprequest.get();
		System.out.println(response.asPrettyString());
	}
	
	
	@Test
   public void  validateResponse()
   {
	   RestAssured.baseURI="https://demoqa.com/BookStore/v1/Books";
	    RequestSpecification httprequest=RestAssured.given();
	    Response response= httprequest.get();
	    //by using status code
	    int statusCode=response.getStatusCode();
	    Assert.assertEquals(statusCode,200,"correct status code return");
	    
	    //negative scenario
	    Response response1= httprequest.get("/aaa");
	    int statusCode1=response1.getStatusCode();
	    System.out.println("statusCode1" + statusCode1);
	    Assert.assertEquals(statusCode,200,"correct status code return");
	    
			   
		
		
   }
	
	
}
