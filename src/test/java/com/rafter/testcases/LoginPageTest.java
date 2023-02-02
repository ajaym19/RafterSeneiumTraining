package com.rafter.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rafter.base.ExcelReader;
import com.rafter.base.RafterBase;
import com.rafter.pages.LoginPage;

public class LoginPageTest {

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

	@Test
	public void validateTitleTest() {
		String expTitle = "OrangeHRM";
		Assert.assertEquals(lp.getPageTitle(), expTitle);

	}

	@Test
	public void validateLoginTest() {
		lp.login();
		String currentUrl = lp.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("dashboard"));
	}
	
	@Test
	public void forgotPasswordTest() {
		// automate
	}

	@AfterMethod
	public void closeBrowserSetup() {
		lp.tearDown();
	}
	
	@DataProvider
	public Object[][] getUserData() {
		ExcelReader reader = new ExcelReader("filename", "sheetname");
		return reader.getData();
	}

}
