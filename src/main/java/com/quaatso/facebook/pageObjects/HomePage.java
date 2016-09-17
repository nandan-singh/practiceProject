package com.quaatso.facebook.pageObjects;

import org.openqa.selenium.By;

public class HomePage extends Page {
	
	public void openHomePage(){
		driver.get("http://www.facebook.com");
	}

	public void enterUserName(String userName) {
		driver.findElement(By.id("email")).sendKeys(userName);
	}

	public void enterPassword(String password) {
		driver.findElement(By.id("pass")).sendKeys(password);
	}

	public void clickOnLoginButton() {
		driver.findElement(By.id("loginbutton")).click();
	}

}
