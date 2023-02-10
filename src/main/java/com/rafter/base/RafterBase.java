package com.rafter.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class RafterBase {

	public static WebDriver driver;
	public static Properties prop;
	public static ExtentReports extent;
	public static ExtentSparkReporter reporter;

	public void initialization() {
		// Configuring Browser
		// open the browser based on the value
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

	public void configureReport() {
		// Configuring Extent Report
		String reportPath = "./ExtentReports/ExtReport.html";
		reporter = new ExtentSparkReporter(reportPath);
		reporter.config().setDocumentTitle("Rafter Automation Testing Report");
		reporter.config().setReportName("Automation Test Result");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("QA", "Ajay");
		extent.setSystemInfo("Sprint", "Sprint 12");
	}

	public void tearDown() {
		driver.quit();
	}
}
