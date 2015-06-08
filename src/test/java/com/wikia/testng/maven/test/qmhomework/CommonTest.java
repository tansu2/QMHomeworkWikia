package com.wikia.testng.maven.test.qmhomework;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.wikia.testng.maven.util.Config;
import com.wikia.testng.maven.util.Driver;
import com.wikia.testng.maven.util.LogInitializer;

public class CommonTest {
	public static Config config;
	public static WebDriver driver;
	public static String baseURL, homePageURL;
	public static String username, password;
	
	@BeforeClass
    public static void beforeClass() throws Exception{
		config = new Config(System.getProperty("env"));
		PropertyConfigurator.configure(new LogInitializer());
        baseURL = config.getProperty("baseURL");
        homePageURL = config.getProperty("homePageURL");
        username = config.getProperty("username");
        password = config.getProperty("password");
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