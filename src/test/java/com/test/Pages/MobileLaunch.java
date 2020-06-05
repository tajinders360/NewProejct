package com.test.Pages;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MobileLaunch {
	
	static AppiumDriver driver;
	public static void main(String[] args) throws MalformedURLException {
		
		openCal();
	}
	
	public static void openCal() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "Custom");
		cap.setCapability("udid", "192.168.30.101:5555");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "7.0");
    	cap.setCapability("appPackage", "com.android.calculator2");
		cap.setCapability("appActivity", "com.android.calculator2.Calculator");
 
	    URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url,cap);
		
		System.out.println("Application started");
	}
}

