package com.rafter.pages;

import org.openqa.selenium.By;

import com.rafter.base.RafterBase;

public class LoginPage extends RafterBase {
	
	public DashboardPage login() {
		driver.findElement(By.name("username")).sendKeys(prop.getProperty("uname"));
		driver.findElement(By.name("password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		return new DashboardPage();
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
}
