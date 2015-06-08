package com.wikia.testng.maven.page.common;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.wikia.testng.maven.page.common.CommonPage.CommonPageObjects;
import com.wikia.testng.maven.util.UtilityCommon;

public class Common {

	/**
	 * The function logs in to the application with provided url, user id and password.
	 * @param url 
	 * @param username
	 * @param password
	 * @param driver
	 * 
	 * @throws Exception
	 */
	public static void loginToPlatform(String url, String username, String password, WebDriver driver) throws Exception {
		driver.navigate().to(url);
		if (!UtilityCommon.waitForElementPresent(CommonPageObjects.SIGNIN.byLocator(), driver)) {
			Assert.fail("Sign in label is not loaded properly.");
		}
		UtilityCommon.hoverOverMenuItem(CommonPageObjects.SIGNIN.byLocator(), driver);
		
		driver.findElement(CommonPageObjects.USERNAME.byLocator()).sendKeys(username);
		driver.findElement(CommonPageObjects.PASSWORD.byLocator()).sendKeys(password);

		UtilityCommon.clickAndWait(CommonPageObjects.LOGIN.byLocator(), driver);
	}
	
	/**
	 * This function logs out from the application. 
	 * @param url
	 * @param driver
	 * 
	 * @throws Exception
	 */
	public static void logoutFromPlatform(String url, WebDriver driver) throws Exception {
		driver.navigate().to(url);
		UtilityCommon.hoverOverMenuItem(CommonPageObjects.SIGNIN.byLocator(), driver);
		if (!UtilityCommon.waitForElementPresent(CommonPageObjects.SIGNOUT.byLocator(), driver)) {
			Assert.fail("Sign out label is not loaded properly.");
		}
		UtilityCommon.hoverOverMenuItem(CommonPageObjects.SIGNIN.byLocator(), driver);
		UtilityCommon.clickAndWait(CommonPageObjects.SIGNOUT.byLocator(), driver);	
	}
}