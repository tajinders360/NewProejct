package com.test.Pages;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FirstPage {
	
	@Test
	public void getWeatherDetails() {
		
		 RestAssured.baseURI ="http://restapi.demoqa.com/utilities/weather/city";
		 RequestSpecification httpRequest = RestAssured.given();
		 
		 // Make a request to the server by specifying the method Type and the method URL.
		 // This will return the Response from the server. Store the response in a variable.
		// Response response = httpRequest.request(Method.GET, "/Hyderabad");
		 Response response = httpRequest.get("/Hyderabad");
		 // Now let us print the body of the message to see what response
		 // we have recieved from the server
		 //String responseBody = response.getBody().asString();
		 System.out.println("Response Body is =>  " + response.asString());
		 
		 int statusCode = response.getStatusCode();
		 
		 System.out.println(statusCode);
		 
		 String statusLine= response.getStatusLine();
		 
		 System.out.println(statusLine);
		 
		 // Assert that correct status code is returned.
		 Assert.assertEquals(statusLine /*actual value*/, "HTTP/1.1 200 OK" /*expected value*/, "Correct status code returned");
	}
	
	@Test(priority=1)
	void getAllHeaders()
	{
		
			
			RestAssured.baseURI ="http://restapi.demoqa.com/utilities/weatherfull/city";
			 RequestSpecification httpRequest = RestAssured.given();
		 
		
			 Response response = httpRequest.get("/Hyderabad");
			 Headers header= response.headers();
			 
			 for(Header head:header)
			 {
				 System.out.println("Key: " + head.getName() + " Value: " + head.getValue());
			 }
			 
	}

}
