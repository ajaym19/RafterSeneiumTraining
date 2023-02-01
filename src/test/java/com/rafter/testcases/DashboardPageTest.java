package com.rafter.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rafter.pages.DashboardPage;

public class DashboardPageTest {

	DashboardPage dp;

	@BeforeMethod
	public void browserConfig() {
		dp = new DashboardPage();
		dp.initialization();
	}

	@Test
	public void dashboardLabel() {
		Assert.assertTrue(dp.getDashboardLabelPresence());
	}

	@Test
	public void timeAtWorkSectionPresent() {

	}

}
