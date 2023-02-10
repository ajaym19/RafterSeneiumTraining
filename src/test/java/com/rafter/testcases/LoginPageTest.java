package com.rafter.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.rafter.base.ExcelReader;
import com.rafter.base.RafterBase;
import com.rafter.pages.LoginPage;

public class LoginPageTest extends RafterBase {

	/*
	 * Mistakes: 1. webdriver/browser config code everytime 2. Hard Coded the data
	 * 3. Mixing the code and the test cases
	 */

	LoginPage lp;

	@BeforeMethod
	public void browserConfig() {
		lp = new LoginPage();
		lp.initialization();
	}

	@BeforeTest
	public void reportSetup() {
		configureReport();
	}

	@Test
	public void validateTitleTest() {
		ExtentTest test = extent.createTest("Orange HRM Title Test Case");
		String expTitle = "OrangeHRM";
		Assert.assertEquals(lp.getPageTitle(), expTitle);
		test.log(Status.PASS, "Marking TC Passed");
	}

	@Test
	public void validateLoginTest() {
		ExtentTest test = extent.createTest("Orange HRM Login Test Case");
		lp.login();
		String currentUrl = lp.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("dashboard"));
		test.log(Status.PASS, "Marking TC Passed");
	}

	@Test(enabled = false)
	public void forgotPasswordTest() {
		// automate
	}

	@AfterMethod
	public void closeBrowserSetup() {
		lp.tearDown();
	}

	@AfterTest
	public void generateReport() {
		extent.flush();
	}

	@DataProvider
	public Object[][] getUserData() {
		ExcelReader reader = new ExcelReader("filename", "sheetname");
		return reader.getData();
	}

}
