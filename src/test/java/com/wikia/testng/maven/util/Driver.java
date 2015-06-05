package com.wikia.testng.maven.util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Driver {
	
	public enum Browser
	{
		Firefox, Chrome
	}
	
	private static WebDriver driver;

	public static WebDriver initializeDriver(String browserFromConfig) throws Exception {
		Browser browser = determineBrowser(browserFromConfig);
		try {
			switch (browser) {
			case Firefox:
				driver = new FirefoxDriver();
				break;
			case Chrome:
				System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
				DesiredCapabilities chromeCapabilities = DesiredCapabilities.chrome();
				driver = new ChromeDriver(chromeCapabilities);
				break;
			default:
				driver = new FirefoxDriver();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}
	
	private static Browser determineBrowser(String browserName) throws Exception {
		if (browserName.equalsIgnoreCase("firefox")) {
			return Browser.Firefox;
		} else if (browserName.equalsIgnoreCase("chrome")) {
			return Browser.Chrome;
		} else {
			throw new Exception("Unsupported Browser : " + browserName);
		}
	}
}
