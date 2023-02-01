package com.rafter.pages;

import org.openqa.selenium.By;

import com.rafter.base.RafterBase;

public class DashboardPage extends RafterBase{

	public boolean getDashboardLabelPresence() {
		return driver.findElement(By.xpath("//h6[text()='Dashboard']")).isDisplayed();
	}
}
