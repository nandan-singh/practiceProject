package com.quaatso.facebook.loginTest;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.quaatso.facebook.pageObjects.HomePage;
import com.quaatso.facebook.utilities.CsvTestData;

public class LoginTest {

	HomePage homePage;

	@BeforeClass
	public void init() {
		homePage = new HomePage();
	}

	@BeforeMethod
	public void openPage() {
		homePage.openHomePage();
	}

	@Test(dataProvider = "getExcelData")
	public void verifyLogin(String userName, String password) {
		homePage.enterUserName(userName);
		homePage.enterPassword(password);
		homePage.clickOnLoginButton();
		// verification step
	}

	/*
	 * // dataprovider
	 * 
	 * @DataProvider public Object[][] getCSVData() throws IOException {
	 * Object[][] data = CsvTestData.getCsvData(); return data; }
	 */

	@DataProvider
	public Object[][] getExcelData() throws IOException {
		// Object[][] data = CsvTestData.getCsvData();
		Object[][] data = { { "firstUser", "firstPass" }, { "secondUser", "SecondPass" } };

		return data;
	}

}
