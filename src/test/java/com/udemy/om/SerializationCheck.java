package com.udemy.om;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;

public class SerializationCheck {
	
	@BeforeClass
	public void create_requestresponsespecification()
	{
		RequestSpecBuilder requestBuilder=new RequestSpecBuilder()
				.setBaseUri("https://api.postman.com")
				.addHeader("X-Api-Key","PMAK-629edffbe35fb965a9f25392-a9e647899df89a50fe44137e7b44361c4a")
				.log(LogDetail.ALL);
		RestAssured.requestSpecification =requestBuilder.build();
		
		ResponseSpecBuilder responseBuilder = new ResponseSpecBuilder().expectStatusCode(200).
				expectContentType(ContentType.JSON).log(LogDetail.ALL);
		RestAssured.responseSpecification = responseBuilder.build();
	}
	
	@Test
	public void serialization_using_jacksonAPI_JsonObject() throws JsonProcessingException
	{
		HashMap<String, Object> mainobject= new HashMap<String, Object>();
		HashMap<String, String> nestedobject= new HashMap<String, String>();
		nestedobject.put("name", "My workspace1");
		nestedobject.put("type", "personal");
		nestedobject.put("description", "workspace created");
		
		mainobject.put("workspace", nestedobject);
		//convert this map object to Json object by using ObjectMapper class
		ObjectMapper objectmapper = new ObjectMapper();
		objectmapper.writeValueAsString(mainobject);
		
		given().body(mainobject)
		.when().post("/workspaces")
		.then().log().all()
		.assertThat().body("workspace.name", equalTo("My workspace1"));
		
		
		
	}

	

}
