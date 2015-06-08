package com.wikia.testng.maven.test.qmhomework;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.wikia.testng.maven.page.common.Common;
import com.wikia.testng.maven.page.common.CommonPage.CommonPageObjects;
import com.wikia.testng.maven.util.UtilityCommon;

public class SigninTest extends CommonTest {

	/**
	 * @author Tan Su
	 * @throws Exception 
	 * @date 2015-06-05
	 */
	@Test(groups = "SigninTest")
	public void loginLogout() throws Exception {
		
		/**
		 *  Step 1: 
		 *  Action: navigate to baseurl of http://qm-homework.wikia.com
		 *  Expected: user is redirected to homepageurl of
		 *  http://qm-homework.wikia.com/wiki/QM_HomeWork_Wikia
		 */
		try{
			driver.navigate().to(baseURL);	
			if (!UtilityCommon.waitForElementPresent(CommonPageObjects.SIGNIN.byLocator(), driver)) {
				Assert.fail("Sign in page is not loaded properly.");
			} else {
				String currentURL = driver.getCurrentUrl();
				Assert.assertEquals(currentURL, homePageURL, 
						"User is not redirected to homePageURL of http://qm-homework.wikia.com/wiki/QM_HomeWork_Wikia");
			}
		} catch (AssertionError e){
			e.getMessage();
			Reporter.log(this.getClass().getSimpleName()+"_Step_1: " + e.getMessage());
			UtilityCommon.capturescreenshot(this.getClass().getSimpleName()+"_Step_1", driver);
		}
		
		/**
		 *  Step 2: 
		 *  Action: Hover mouse over the login label 
		 *  Expected: The login form is visible
		 */
		boolean usernameFlag = false, passwordFlag = false, loginFlag = false;
		try{
			UtilityCommon.hoverOverMenuItem(CommonPageObjects.SIGNIN.byLocator(), driver);
			usernameFlag = UtilityCommon.waitForElementPresent(CommonPageObjects.USERNAME.byLocator(),driver);
			passwordFlag = UtilityCommon.waitForElementPresent(CommonPageObjects.PASSWORD.byLocator(),driver);
			loginFlag = UtilityCommon.waitForElementPresent(CommonPageObjects.LOGIN.byLocator(),driver);
			Assert.assertTrue(usernameFlag && passwordFlag && loginFlag,
					"The login form is not visible");
		}
		catch(AssertionError e){
			e.getMessage();
			Reporter.log(this.getClass().getSimpleName()+"_Step_2: " + e.getMessage());
			UtilityCommon.capturescreenshot(this.getClass().getSimpleName()+"_Step_2", driver);
		}
		
		/**
		 *  Step 3: 
		 *  Action: Enter username and password, left click the login button 
		 *  Expected: Username is logged in, username is displayed instead
		 *  of the login label
		 */
		boolean signoutFlag = false;
		try{
			UtilityCommon.hoverOverMenuItem(CommonPageObjects.SIGNIN.byLocator(), driver);
			driver.findElement(CommonPageObjects.USERNAME.byLocator()).sendKeys(username);
			driver.findElement(CommonPageObjects.PASSWORD.byLocator()).sendKeys(password);
			UtilityCommon.clickAndWait(CommonPageObjects.LOGIN.byLocator(), driver);
			
			UtilityCommon.hoverOverMenuItem(CommonPageObjects.SIGNIN.byLocator(), driver);
			
			signoutFlag = UtilityCommon.waitForElementPresent(CommonPageObjects.SIGNOUT.byLocator(),driver);
			Assert.assertTrue(signoutFlag, "User is not logged in properly");
			
			String userTitle = driver.findElement(By.xpath("//*[@id='AccountNavigation']/li/div/a")).getAttribute("title");
			Assert.assertEquals(userTitle,username + " - My page",
					"Username is not displayed instead of the login label");
		} catch (AssertionError e){
			e.getMessage();
			Reporter.log(this.getClass().getSimpleName()+"_Step_3: " + e.getMessage());
			UtilityCommon.capturescreenshot(this.getClass().getSimpleName()+"_Step_3", driver);
		}
		
		// User logout
		Common.logoutFromPlatform(homePageURL, driver);
	}
}