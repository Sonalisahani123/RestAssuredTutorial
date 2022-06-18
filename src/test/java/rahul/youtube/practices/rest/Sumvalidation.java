package rahul.youtube.practices.rest;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import utility.Payload;

public class Sumvalidation {
	
	
	public  static void main(String[] args)
	{
		
		//6. Verify if Sum of all Course prices matches with Purchase Amount
		JsonPath js=new JsonPath(Payload.coursePrice());
		int count = js.getInt("courses.size()");
		int sum=0;
		for(int i=0;i<count;i++) {
			int price=js.getInt("courses["+i+"].price");
			int copies=js.getInt("courses["+i+"].copies");
			int  priceForCopies=price * copies;
			sum=sum+priceForCopies;
			
			
		}
		System.out.println("total sum of course price:" +sum );
		
			int purchaseamount=js.getInt("dashboard.purchaseAmount");	
			System.out.println("purchaseamount:"+ purchaseamount);
		
			if(sum == purchaseamount)
			{
			System.out.println("both are same");	
			}else
			{
				System.out.println("both are not same");
			}
						
		
		
	}

}
