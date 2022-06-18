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

public class SendPayloadComplexJson {
	
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
	public void validate_post_request_payloadJson_complexJson()
	{
		//as id in array put it into array list
		List<Integer> idArrayList = new ArrayList<Integer>();
		idArrayList.add(5);
		idArrayList.add(9);
		
		//
		HashMap<String,Object> idtypemap=new HashMap<String,Object>();
		idtypemap.put("id", idArrayList);
		idtypemap.put("type", "Chocolate");
		
		
		HashMap<String,Object> battermap=new HashMap<String,Object>();
		battermap.put("id", "1001");
		battermap.put("type", "Regular");
		
		List<HashMap<String, Object>> batterArrayList = new ArrayList<HashMap<String, Object>>();
		batterArrayList.add(idtypemap);
		batterArrayList.add(battermap);
		
		HashMap<String,List<HashMap<String, Object>>> completebatterHashMap = new HashMap<String,List<HashMap<String, Object>>>();
		completebatterHashMap.put("batter", batterArrayList);
		
		List<String> typeArraylist = new ArrayList<>();
		typeArraylist.add("type1");
		typeArraylist.add("type2");

	     HashMap<String, Object> toppingIdtype= new HashMap<String, Object>();
	     toppingIdtype.put("id", "5002");
	     toppingIdtype.put("type", typeArraylist);
	     
	     HashMap<String, Object> toppinghashmap= new HashMap<String, Object>();
	     toppinghashmap.put("id", "5001");
	     toppinghashmap.put("type", "None");
	     
	     List<HashMap<String,Object>> toppingArrayList = new ArrayList<HashMap<String, Object>>();
	     toppingArrayList.add(toppingIdtype);
	     toppingArrayList.add(toppinghashmap);
	     
	     HashMap<String,Object> mainhashmap= new HashMap<String,Object>();
	     mainhashmap.put("id","001");
	     mainhashmap.put("type","donut");
	     mainhashmap.put("name","cake");
	     mainhashmap.put("ppu",0.55);
	     mainhashmap.put("batters",completebatterHashMap);
	     mainhashmap.put("batters",completebatterHashMap);
	     mainhashmap.put("topping",toppingArrayList);
	     
		given().
		body(mainhashmap)
	
		.when().post("/PostComplexJson")
		.then().log().all()
		.assertThat().body("msg", equalTo("Success"));	
		
	}
	
	

}
