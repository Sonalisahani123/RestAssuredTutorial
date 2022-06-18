package com.udemy.om;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class AutomateGet {
	

	@Test
	public void validate_status_code()
	{
		given().baseUri("https://api.postman.com").
		header("x-api-key","PMAK-628236bdcfa0877d4eafbf45-43d777a2aab8c355eaa7a2b0bad2a3ce9a").
		when().get("/workspaces").
		then().log().all().assertThat().statusCode(200);
	}
	
	@Test
	public void validate_response_body()
	{
		
	}
	
}
