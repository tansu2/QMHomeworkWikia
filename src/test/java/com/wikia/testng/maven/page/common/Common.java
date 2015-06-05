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
		driver.findElement(CommonPageObjects.USERNAME.byLocator()).clear();
		driver.findElement(CommonPageObjects.USERNAME.byLocator()).sendKeys(username);
		driver.findElement(CommonPageObjects.PASSWORD.byLocator()).clear();
		driver.findElement(CommonPageObjects.PASSWORD.byLocator()).sendKeys(password);

		UtilityCommon.clickAndWait(CommonPageObjects.LOGIN.byLocator(), driver);
		Thread.sleep(10000);
	}

}
