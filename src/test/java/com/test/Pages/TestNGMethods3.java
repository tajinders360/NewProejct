package com.test.Pages;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.sun.xml.bind.v2.schemagen.xmlschema.List;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestNGMethods3 {
	WebDriver driver;
	
	@Test
	public void Method()
	{
		
	WebDriverManager.chromedriver().setup();
	//System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
	driver= new ChromeDriver();
	driver.manage().window().maximize();
	 
    //setting implicit time
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

	//Loading a URL
	driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
	
	//ArrayList<WebElement> al= new ArrayList<>(driver.findElements(By.id("multi-select")).size());
	
	Select sel = new Select(driver.findElement(By.id("multi-select")));
	Actions builder = new Actions(driver);
	builder.keyDown(Keys.CONTROL)
	.click(sel.getOptions().get(2))
	.click(sel.getOptions().get(3))
	.click(sel.getOptions().get(4))
	.keyUp(Keys.CONTROL);
	 builder.build().perform();
		
	java.util.List<WebElement> res = sel.getAllSelectedOptions();
	for(WebElement ele:res)
	{
		System.out.println(ele.getText());
	}
		
	
	
	
	
	}
	
}
