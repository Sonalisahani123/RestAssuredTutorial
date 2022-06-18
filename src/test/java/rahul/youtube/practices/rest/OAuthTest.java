package rahul.youtube.practices.rest;
import static io.restassured.RestAssured.*;

import com.pojo.GetCoursePOJO;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

public class OAuthTest {

	public static void main(String[] args) {
		
		String url="https://rahulshettyacademy.com/getCourse.php?code=4%2F0AX4XfWjLG7RO-RnottHVqwCayGt3ar-yxf3wjFBK7iMA0kyY80RqT7p4T33w0PZ6Z3IaJQ&scope=email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&authuser=1&prompt=none#";
		String partialCode=url.split("code=")[1];
		//String code=partialCode.split("&scope")[0];
		//System.out.println("code:"+ code);
				
		String code="4%2F0AX4XfWgGcB4XSJ1xPSC3-rOF5SCq0n0T6eLA3ZXUe4MwfT6nfzCEbvzRL9zUwa0xZFnxdA";
		String accessTokenResponse=given().urlEncodingEnabled(false)
				
		.queryParams("code",code)
		.queryParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.queryParams("client_secret","erZOWM9g3UtwNRj340YYaK_W")
		.queryParams("redirect_uri","https://rahulshettyacademy.com/getCourse.php")
		.queryParams("grant_type","authorization_code").log().all()
		.when()
		.post("https://www.googleapis.com/oauth2/v4/token").asString();
		JsonPath path=new JsonPath(accessTokenResponse);
		String accessToken=path.getString("access_token");
		
		
		
		
		
		GetCoursePOJO response= given().queryParam("access_token", accessToken).expect().defaultParser(Parser.JSON)
		.when()
		.get("https://rahulshettyacademy.com/getCourse.php").as(GetCoursePOJO.class);
		//System.out.println(response);
		//System.out.println(response.getLinkedIN());
		//System.out.println(response.getInstructor());
		System.out.println(response);
		
		

	}

}
