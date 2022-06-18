package jsonpathexample;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class JsonPathIntro {
	
	@Test
	public void jsonPathDemo()
	{
		
		String JsonObject="{\r\n"
				+ "  \"firstname\":\"sonali\",\r\n"
				+ "  \"secondname\":\"sahani\",\r\n"
				+ "  \"age\":28,\r\n"
				+ "  \"address\":\"Bangalore\",\r\n"
				+ "  \"salary\":9.6\r\n"
				+ "  \r\n"
				+ "}";
		
           JsonPath jsonPath=new JsonPath(JsonObject);
          String firstName= jsonPath.getString("firstname");
          System.out.println(firstName);
		  
           String age=jsonPath.getString("age");
          System.out.println(age);
          
		
	}
	
	
	

}
