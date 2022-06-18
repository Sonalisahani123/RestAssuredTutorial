package utility;

import io.restassured.path.json.JsonPath;

public class ReusableMethods {
	public static JsonPath convertresponseToJson(String response)
	{
		JsonPath jsonpath=new JsonPath(response);
		return jsonpath;
	}

}
