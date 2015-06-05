package com.wikia.testng.maven.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilityCommon {
	
	public static int timeoutSec = 180;
	
	public static void sleepForGivenTime(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * The waitForElementPresent function will wait for the element for a
	 * default duration of customized seconds To increase or decrease this time
	 * change the value of the integer 'timeoutSec' in "Common.java"
	 * 
	 * @param Locator
	 * @param driver
	 */
	public static boolean waitForElementPresent(final By locator, WebDriver driver) {

		boolean exists = false;
		for (int i = 0; i < timeoutSec; i = i + 1) {
			WebDriverWait wait = new WebDriverWait(driver, timeoutSec);
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			System.out.println(element);
			sleepForGivenTime(1000);
			if (element != null) {
				exists = true;
				break;
			} else {
				sleepForGivenTime(1000);
			}
		}

		return exists;
	}

	/**
	 * This function checks if element is available on page.
	 * 
	 * @param locator
	 * @param driver
	 * @return boolean
	 * @throws Exception
	 */
	public static boolean isElementPresent(By locator, WebDriver driver) {
		if (driver.findElements(locator).size() != 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * The clickAndWait function will wait for a default time of customized
	 * milliseconds To increase or decrease this time change the value of the
	 * string 'timeout' in "Common.java"
	 * 
	 * @param locator
	 * @param selenium
	 * @throws InterruptedException
	 */

	public static void clickAndWait(By locator, WebDriver driver) {
		waitForElementPresent(locator, driver);
		driver.findElement(locator).click();
		WaitForPageToLoad waitForPageToLoad = new WaitForPageToLoad();
		waitForPageToLoad.getReadyStateUsingWait(driver);
	}	
}
