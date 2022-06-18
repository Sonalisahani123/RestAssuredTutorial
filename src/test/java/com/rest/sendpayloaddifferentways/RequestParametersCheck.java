package com.rest.sendpayloaddifferentways;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

public class RequestParametersCheck {
	
	@Test(enabled=false)
	public void single_query_parameter()
	{
		given().baseUri("https://postman-echo.com/").
		//param("foo1", "bar1").
		queryParam("foo2", "bar12")
		.log().all()
		.when().get("/get")
		.then().log().all().assertThat().statusCode(200);
	}

	
	@Test
	public void multiple_query_parameters()
	{
		given().baseUri("https://postman-echo.com/").
		//param("foo1", "bar1").
		queryParam("foo2", "bar12").
		queryParam("foo3", "bar13").log().all()
		.when().get("/get")
		.then().log().all().assertThat().statusCode(200);
	}
	
	
	@Test
	public void multiple_query_parameters_usingHashMap()
	{
		
		HashMap<String,String> queryparams = new HashMap<String, String>();
		queryparams.put("foo2", "bar12");
		queryparams.put("foo3", "bar14");
		
		given().baseUri("https://postman-echo.com/").queryParams(queryparams)
		
		.log().all()
		.when().get("/get")
		.then().log().all().assertThat().statusCode(200);
	}
	
	@Test
	public void multiple_value_query_parameters()
	{
		given().baseUri("https://postman-echo.com/").
		//param("foo1", "bar1").
		//queryParam("foo2","bar1","bar2","bar1" ).
		queryParam("foo2","bar1;bar2;bar1" ).//another way to send multivalue
		log().all()
		.when().get("/get")
		.then().log().all().assertThat().statusCode(200);
	}
	

	@Test
	public void pathParameter()
	{
		given().baseUri("https://reqres.in/")
		.pathParam("userId", "2")
		.log().all()
		.when().get("/api/users/{userId}")
		.then()
		.log().all()
		.assertThat()
		.statusCode(200);
	}
	
	@Test
	public void pathParameters_usingHashMap()
	{
		HashMap<String, String> hm =new HashMap<String, String>();
		hm.put("userId", "2");
		hm.put("bookId", "2");
		
		given().baseUri("https://reqres.in/").pathParams(hm)
		
		.log().all()
		.when().get("/api/users/{userId}/{bookId}")
		.then()
		.log().all()
		.assertThat()
		.statusCode(200);
	}
	
	@Test
	public void multipart_form_data()
	{
		
		
		given().baseUri("https://postman-echo.com/").multiPart("foo1", "bar1")//mutlipart() takes the argument as key,value pair f001 is controller,bar1 is value
		.multiPart("foo2", "bar2")
		.log().all()
		.when().post("/post")
		.then()
		.log().all()
		.assertThat()
		.statusCode(200);
	}
	
}
