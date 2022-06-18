package com.rest.sendpayloaddifferentways;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.config.Config;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class SendPayloadJsonArrayAsList {
	
	ResponseSpecification customresponse;
	
	@BeforeClass
	public void create_requestresponsespecification()
	{
		RequestSpecBuilder requestBuilder=new RequestSpecBuilder()
				.setBaseUri("https://617fd3a0-a1e9-446e-a18d-6d9d8260d8d2.mock.pstmn.io")
				.addHeader("x-mock-match-request-body","true").
				setContentType("application/json;charset=utf-8")
				.log(LogDetail.ALL);
		RestAssured.requestSpecification =requestBuilder.build();
		
		ResponseSpecBuilder responseBuilder = new ResponseSpecBuilder()
				.expectStatusCode(200)
				.expectContentType(ContentType.JSON)
				.log(LogDetail.ALL);
		customresponse = responseBuilder.build();
	}
	
	@Test
	public void validate_post_request_payloadJson_as_arrayList()
	{
		HashMap<String,String> obj5001=new HashMap<String,String>();
		obj5001.put("id", "5001");
		obj5001.put("type", "None");
		
		HashMap<String,String> obj5002=new HashMap<String,String>();
		obj5002.put("id", "5002");
		obj5002.put("type", "Glazed");
		
		List<HashMap> jsonlist= new ArrayList<HashMap>();
		jsonlist.add(obj5001);
		jsonlist.add(obj5002);
		
	given().body(jsonlist)
	
		.when().post("/post")
		.then()
		.assertThat().body("msg", equalTo("Success"));
		
		
		
	}
	
	

}
