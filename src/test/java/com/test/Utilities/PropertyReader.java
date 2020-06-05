package com.test.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

	public String readProperty(String key) {
		try {
			FileInputStream f = new FileInputStream("E:\\New folder\\com.test.firstProject\\src\\test\\java\\com\\test\\Configuration\\configuration.properties");
			Properties prop = new Properties();
			prop.load(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return key;
	}
}
