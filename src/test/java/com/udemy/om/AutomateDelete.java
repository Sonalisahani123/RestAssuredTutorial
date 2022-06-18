package com.udemy.om;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;

public class AutomateDelete {
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
	public void validate_delete_request_BDDFormat()
	{
		String workspaceId = "76b1cd14-7d53-425a-8273-9dff3ddf52d2";
		given().pathParam("workspaceId", workspaceId)
		.when()
		.delete("workspaces/{workspaceId}").then().log().all().assertThat().body("workspace.id", equalTo(workspaceId));
		
	}

}
