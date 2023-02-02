package com.rafter.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rafter.pages.DashboardPage;
import com.rafter.pages.LoginPage;

public class DashboardPageTest{

	DashboardPage dp;
	LoginPage lp;

	@BeforeMethod
	public void browserConfig() {
		lp = new LoginPage();
		lp.initialization();
	}

	@Test
	public void dashboardLabel() {
		dp = lp.login();
		Assert.assertTrue(dp.getDashboardLabelPresence());
	}

	@Test
	public void timeAtWorkSectionPresent() {
		dp = lp.login();
	}
	
	@AfterMethod
	public void closeBrowserSetup() {
		lp.tearDown();
	}

}
