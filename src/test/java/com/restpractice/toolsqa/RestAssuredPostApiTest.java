package com.restpractice.toolsqa;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.util.JSONPObject;


import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class RestAssuredPostApiTest {
	
	
	@Test
	
	public void postBooK()
	{
		 RestAssured.baseURI="https://demoqa.com/BookStore/v1/Books";	
		 RequestSpecification request=RestAssured.given();
		 JSONObject json=new JSONObject();
		 json.put("userId", "testPost");
		 json.put("isbn", "9781449325862"); 
		 request.header("Content-Type", "application/json");
		 request.body(json.toJSONString());
		 Response response = request.post("/BookStoreV1BooksPost"); 
		 System.out.println("The status received: " + response.statusLine());

	}
	
	
  
   
	
	
}
