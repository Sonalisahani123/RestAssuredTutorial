package com.restpractice.toolsqa;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetpagesFromTitle {
	
	@Test
	public void  getpages()
	{
		String response = given().baseUri("https://demoqa.com")
		.when().get("/BookStore/v1/Books")
		.then().log().all().extract().response().asString();
		
		//System.out.println(response);
		
		JsonPath jsonpath = new JsonPath(response);
	
		int booksCount = jsonpath.getInt("books.size()");
		System.out.println("booksCount" + booksCount);
		
		//get the pages when you passed title as Learning JavaScript Design Patterns
		 for(int i=0; i<booksCount; i++)
		 {
			 String pageTitle = jsonpath.getString("books["+i+"].title");
			// System.out.println(pageTitle);
			 if(pageTitle.equals("Learning JavaScript Design Patterns"))
			 {
				 int pages = jsonpath.getInt("books["+i+"].pages");
				 System.out.println(pages);
				 break;
			 }
			 
		 }
		
	}

}
