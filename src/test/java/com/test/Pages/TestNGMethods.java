package com.test.Pages;

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

public class TestNGMethods {

	SoftAssert softAssert = new SoftAssert();
	@BeforeSuite
	void Method()
	{
		System.out.println("BeforeSuite");
	}
	@BeforeTest
	void Method1()
	{
		System.out.println("BeforeTest");
	}
	@BeforeClass
	void Method2()
	{
		System.out.println("BeforeClass");
	}
	@BeforeMethod
	void Method3()
	{
		System.out.println("BeforeMethod");
	}
	@Test
	void firstMethod()
	{
		System.out.println("firstMethod");
		
	}
	@Test
	void secMethod()
	{
		System.out.println("secMethod");
		
		
	}
	@AfterMethod
	void Method4()
	{
		System.out.println("AfterMethod");
	}
	@AfterClass
	void Method5()
	{
		System.out.println("AfterClass");
	}
	@AfterTest
	void Method6()
	{
		System.out.println("AfterTest");
	}
	@AfterSuite
	void Method7()
	{
		System.out.println("AfterSuite");
		
	}
	
}
