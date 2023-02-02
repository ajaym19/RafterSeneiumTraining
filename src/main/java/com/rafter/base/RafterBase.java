package com.rafter.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RafterBase {

	public static WebDriver driver;
	public static Properties prop;
	
	public void initialization() {
		//open the browser based on the value
		readPropertyFile();
		driver = new ChromeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
	}
	
	public void readPropertyFile() {
		String propFilePath = "./src/main/java/com/rafter/config/config.properties";
		prop = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(propFilePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void tearDown() {
		driver.quit();
	}
}
