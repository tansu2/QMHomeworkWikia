package com.wikia.testng.maven.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
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
	 * change the value of the integer 'timeoutSec' 
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
	 * This function waits for the page to load fully.
	 * 
	 * @param driver
	 */
	public static void waitForPageToLoad(WebDriver driver) {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try {
			wait.until(expectation);
		} catch (Throwable error) {
			error.getMessage();
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
		waitForPageToLoad(driver);
	}	

	/**
	 * Hover mouse over a particular menu item and 
	 * wait long enough for the text to become visible. 
	 * 
	 * @param locator
	 * @param driver
	 */
	public static void hoverOverMenuItem(By locator, WebDriver driver){
		waitForPageToLoad(driver);
		waitForElementPresent(locator, driver);
		Actions action = new Actions(driver);
		WebElement elem = driver.findElement(locator);
		action.moveToElement(elem).perform();
		sleepForGivenTime(1000);
	}

	/**
	 * This function captures a screenshot whenever there is an error happening
	 * It provides the screenshot for further analysis to determine if it's a 
	 * defect or script errors
	 * 
	 * @param filename
	 * @param driver
	 */
	public static void capturescreenshot(String filename, WebDriver driver) {
		try {
			Date date = new Date();
			String scrFolder = System.getProperty("user.dir") + "\\screenshots\\"
					+ new SimpleDateFormat("yyyy-MM-dd").format(date);
			new File(scrFolder).mkdir();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");

			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(scrFolder + "\\" + filename + "_" + dateFormat.format(date) + ".jpg"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
