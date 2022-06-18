package com.udemy.om;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestSpecBuilderExample {
	
	public static void main(String[]args) {
	RequestSpecBuilder reqspecBuilder=new RequestSpecBuilder();
	//setting base URI
	reqspecBuilder.setBaseUri("https://restful-booker.herokuapp.com").setBasePath("/booking");
	//getting  RequestSpecification refernce by using builder method
	RequestSpecification reqs= reqspecBuilder.build();
	
	//we can call directly http methods on RequestSpecification
//	 Response res1=reqs.get();
//	 System.out.println(res1.asString());
	
	// We can also pass RequestSpecification reference variable in overloaded given() method
			Response res2 = RestAssured.given(reqs).get();
			System.out.println(res2.asString());
			System.out.println("======================");
					
			// We can also pass RequestSpecification using spec() method
			Response res3 = RestAssured.given().spec(reqs).get();
			System.out.println(res3.asString());
	}

}
