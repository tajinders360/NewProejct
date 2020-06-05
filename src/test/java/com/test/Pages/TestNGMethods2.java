package com.test.Pages;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class TestNGMethods2 {
	static WebDriver driver;

	public static void Setup() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + File.separator + "Drivers" + File.separator + "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ui.cogmento.com/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.quit();
	}

	@Test
	void Test1() throws ParseException, IOException {
		File filename = new File("C:\\Users\\User\\db.json");
		String json = FileUtils.readFileToString(filename, "UTF-8");
		Object obj = new JSONParser().parse(json);
		JSONObject jsonObject = (JSONObject) obj;
		System.out.println(jsonObject.containsKey("firstName"));
		
		}

	// @SuppressWarnings("unchecked")
	// @Test
	void Test2() {
		JSONObject requestParams = new JSONObject();
		requestParams.put("firstName", "Test3");
		requestParams.put("lastName", "User3");

		// pass the object as input after converting it to string
		Response resp = given().header("Content-Type", "application/json").body(requestParams.toString()).when()
				.post("http://localhost:3004/users");

		// validate status code
		Assert.assertEquals(resp.getStatusCode(), 201);
	}

	//@Test
	void Test3() {

		// save the parameter value to pass in the variable "year" of type String
		String id = "1";

		// In resp we are saving the response of our request
		Response resp = given().pathParam("id", id).when().get("http://localhost:3004/users?id={id}");

		// printing the response body from Get() api call
		System.out.println("************" + resp.getBody().asString() + "**************");
		// validating response status code
		Assert.assertEquals(resp.getStatusCode(), 200);
	}
	
	@Test
	public static void doGetRequest() {
        //RestAssured.defaultParser = Parser.JSON;
           Response response= given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
                when().get("https://jsonplaceholder.typicode.com/users/1").
                then().contentType(ContentType.JSON).extract().response();
            Map<String, String> company = response.jsonPath().getMap("company");
            System.out.println(company.get("name"));
     }

	
}
