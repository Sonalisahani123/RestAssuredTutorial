package rahul.youtube.practices.rest;

import io.restassured.path.json.JsonPath;
import utility.Payload;

public class ComplexJsonParser {

	public static void main(String[] args) {

		// 1. Print No of courses returned by API
		JsonPath jsonpath = new JsonPath(Payload.coursePrice());
		int courseCount = jsonpath.getInt("courses.size()");
		System.out.println("no of couse:" + courseCount);
		// print purchase amount
		int totalamount = jsonpath.getInt("dashboard.purchaseAmount");
		System.out.println("totalamount:" + totalamount);

		// 3. Print Title of the first course
		String title = jsonpath.getString("courses[2].title");
		System.out.println("title of course:" + title);

		// 4. Print All course titles and their respective Prices
		for (int i = 0; i < courseCount; i++) {
			String courseTitle = jsonpath.getString("courses[" + i + "].title");
			int coursePrice = jsonpath.getInt("courses[" + i + "].price");
			System.out.println("courseTitle:" + courseTitle + " coursePrice:" + coursePrice);

		}
		
		
		// 5. Print no of copies sold by RPA Course
		System.out.println("Print no of copies sold by Cypress Course");
		for (int i = 0; i < courseCount; i++) {
			String courseTitle = jsonpath.getString("courses[" + i + "].title");
			if (courseTitle.equalsIgnoreCase("Cypress")) {
				int copies = jsonpath.getInt("courses[" + i + "].copies");

				System.out.println("copies:" + copies);
				break;
			}
		}
		
		

	}

}
