package com.wikia.testng.maven.util;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.internal.seleniumemulation.SeleneseCommand;

import com.thoughtworks.selenium.Wait;

public class WaitForPageToLoad extends SeleneseCommand<Void> {
	Logger log = Logger.getLogger(WaitForPageToLoad.class.getName());
	private int timeToWait = 250;

	/**
	 * Overrides the default time to wait (in milliseconds) after a page has
	 * finished loading.
	 *
	 * @param timeToWait
	 */
	public void setTimeToWait(int timeToWait) {
		this.timeToWait = timeToWait;
	}

	public Wait getReadyStateUsingWait(final WebDriver driver) {
		return new Wait() {
			@Override
			public boolean until() {
				try {
					Object result = ((JavascriptExecutor) driver)
							.executeScript("return 'complete' == document.readyState;");

					if (result != null && result instanceof Boolean && (Boolean) result) {
						return true;
					}
				} catch (Exception e) {
					// Possible page reload. Fine
				}
				return false;
			}
		};
	}

	public Wait getLengthCheckingWait(final WebDriver driver) {
		return new Wait() {
			private int length;
			private long seenAt;

			@Override
			public boolean until() {
				// Page length needs to be stable for a second
				try {
					int currentLength = driver.findElement(By.tagName("body")).getText().length();
					if (seenAt == 0) {
						seenAt = System.currentTimeMillis();
						length = currentLength;
						return false;
					}

					if (currentLength != length) {
						seenAt = System.currentTimeMillis();
						length = currentLength;
						return false;
					}

					return System.currentTimeMillis() - seenAt > 1000;
				} catch (NoSuchElementException ignored) {} catch (NullPointerException ignored) {}

				return false;
			}
		};
	}

	@Override
	protected Void handleSeleneseCommand(WebDriver driver, String locator, String value) {
		// TODO Auto-generated method stub
		return null;
	}
}