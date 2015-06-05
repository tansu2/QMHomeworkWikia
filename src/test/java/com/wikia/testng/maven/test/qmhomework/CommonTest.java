package com.wikia.testng.maven.test.qmhomework;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.wikia.testng.maven.util.Config;
import com.wikia.testng.maven.util.Driver;

public class CommonTest {
	public static Config config;
	public static WebDriver driver;
	public static String baseurl, homepageurl;
	
	@BeforeClass
    public static void beforeClass() throws Exception{
		config = new Config(System.getProperty("env"));
        baseurl = config.getProperty("baseURL");
        homepageurl = config.getProperty("homepageURL");
        String browser = config.getProperty("browser");
        driver = Driver.initializeDriver(browser);
        driver.manage().window().maximize();
    }
	
	@AfterClass
	public static void afterClass(){		
		driver.close();
		driver.quit();
	}
}