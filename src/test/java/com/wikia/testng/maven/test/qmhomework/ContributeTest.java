package com.wikia.testng.maven.test.qmhomework;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.wikia.testng.maven.page.common.Common;
import com.wikia.testng.maven.page.common.CommonPage.CommonPageObjects;
import com.wikia.testng.maven.page.home.HomePage.HomePageObjects;
import com.wikia.testng.maven.page.video.VideoAddPage.VideoAddPageObjects;
import com.wikia.testng.maven.page.video.VideoDisplayPage.VideoDisplayPageObjects;
import com.wikia.testng.maven.util.UtilityCommon;

public class ContributeTest extends CommonTest{

	public static String  videoAddPageURL, youtubeVideoURL, youtubeVideoName;

	/**
	 * @author Tan Su
	 * @throws Exception 
	 * @date 2015-06-07
	 */
	@Test(groups = "ContributeTest", dependsOnGroups = "SigninTest")
	public void addVideo() throws Exception {
		/**
		 * Pre-condition
		 */
		Common.loginToPlatform(baseURL, username, password, driver);
		videoAddPageURL = config.getProperty("videoAddPageURL");
		youtubeVideoURL =  config.getProperty("youtubeVideoURL");
		youtubeVideoName = config.getProperty("youtubeVideoName");

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
				Assert.assertEquals(currentURL, homePageURL, "User is not redirected to homepageurl");
			}
		} catch (AssertionError e){
			e.getMessage();
			Reporter.log(this.getClass().getSimpleName()+"_Step_1: " + e.getMessage());
			UtilityCommon.capturescreenshot(this.getClass().getSimpleName()+"_Step_1", driver);
		}

		/**
		 * Step 2:
		 * Action: Left click on Contribute button
		 * Expected: The Contribute dropdown expanded
		 */
		boolean addAVideoFlag = false;
		try{
			if (!UtilityCommon.waitForElementPresent(HomePageObjects.CONTRIBUTE.byLocator(), driver)) {
				Assert.fail("Homepage is not loaded properly.");
			} else {
				driver.findElement(HomePageObjects.CONTRIBUTE.byLocator()).click();
				addAVideoFlag = UtilityCommon.waitForElementPresent(HomePageObjects.ADD_A_VIDEO.byLocator(),driver);
				Assert.assertTrue(addAVideoFlag, "The Contribute dropdown is not expanded");
			}
		} catch (AssertionError e){
			e.getMessage();
			Reporter.log(this.getClass().getSimpleName()+"_Step_2: " + e.getMessage());
			UtilityCommon.capturescreenshot(this.getClass().getSimpleName()+"_Step_2", driver);
		}

		/**
		 * Step 3:
		 * Action: Left click on Add a video button
		 * Expected: User is redirected to The Wikia video add page 
		 * of http://qm-homework.wikia.com/wiki/Special:WikiaVideoAdd
		 */
		try{
			UtilityCommon.clickAndWait(HomePageObjects.ADD_A_VIDEO.byLocator(), driver);
			
			if (!(driver.findElement(VideoAddPageObjects.VIDEO_ADD_TITLE.byLocator()).getText().contains("WikiaVideoAdd")
					&& UtilityCommon.waitForElementPresent(VideoAddPageObjects.VIDEO_ADD_URL.byLocator(), driver)
					&& UtilityCommon.waitForElementPresent(VideoAddPageObjects.VIDEO_ADD_URL_SUBMIT.byLocator(), driver))) {
				Assert.fail("VideoAddPage is not loaded properly.");
			} else {
				String currentURL = driver.getCurrentUrl();
				Assert.assertEquals(currentURL, videoAddPageURL, 
						"User is not redirected to videoAddPage of http://qm-homework.wikia.com/wiki/Special:WikiaVideoAdd");
			}
		} catch (AssertionError e){
			e.getMessage();
			Reporter.log(this.getClass().getSimpleName()+"_Step_3: " + e.getMessage());
			UtilityCommon.capturescreenshot(this.getClass().getSimpleName()+"_Step_3", driver);
		}

		/**
		 * Step 4:
		 * Action: Type URL to video from youtube into the “Video URL” field 
		 * and left click the “Add” button e.g. url http://www.youtube.com/watch?v=h9tRIZyTXTI
		 * Expected: Flash message with text: “Video page File:FILENAME successfully added.” 
		 * is displayed near the top of the page
		 */
		try{
			driver.findElement(VideoAddPageObjects.VIDEO_ADD_URL.byLocator()).sendKeys(youtubeVideoURL);
			UtilityCommon.clickAndWait(VideoAddPageObjects.VIDEO_ADD_URL_SUBMIT.byLocator(), driver);

			String flashMessage = driver.findElement(VideoAddPageObjects.FLASH_MESSAGE.byLocator()).getText();
			Assert.assertTrue(flashMessage.contains("Video page File:" + youtubeVideoName +" was successfully added."),
					"Flash message with text: 'Video page File:FILENAME was successfully added.' "
							+ "is not displayed near the top of the page");
		} catch (AssertionError e){
			e.getMessage();
			Reporter.log(this.getClass().getSimpleName()+"_Step_4: " + e.getMessage());
			UtilityCommon.capturescreenshot(this.getClass().getSimpleName()+"_Step_4", driver);
		}

		/**
		 * Step 5:
		 * Action: Left click the link to file on the flash message
		 * Expected: User is redirected to the http://qm-homework.wikia.com/wiki/File:FILENAME page
		 */
		try{
			UtilityCommon.clickAndWait(VideoAddPageObjects.FLASH_MESSAGE_FILELINK.byLocator(), driver);
			String currentURL = driver.getCurrentUrl();
			String youtubeVideoNameWithUnderscores = youtubeVideoName.replaceAll(" ", "_");
			Assert.assertEquals(currentURL, "http://qm-homework.wikia.com/wiki/File:"+youtubeVideoNameWithUnderscores, 
					"User is redirected to the http://qm-homework.wikia.com/wiki/File:FILENAME page");
		} catch (AssertionError e){
			e.getMessage();
			Reporter.log(this.getClass().getSimpleName()+"_Step_5: " + e.getMessage());
			UtilityCommon.capturescreenshot(this.getClass().getSimpleName()+"_Step_5", driver);
		}

		/**
		 * Step 6:
		 * Action: Verify that the filename is the same as on the flash message 
		 * (note spaces may be shown as underscores)
		 * Expected: Confirmed
		 */
		try{
			Assert.assertEquals(driver.findElement(VideoDisplayPageObjects.VIDEO_DISPLAY_TITLE.byLocator()).getText(),
					youtubeVideoName, "The filename is not the same as on the flash message ");			
		} catch (AssertionError e){
			e.getMessage();
			Reporter.log(this.getClass().getSimpleName()+"_Step_6: " + e.getMessage());
			UtilityCommon.capturescreenshot(this.getClass().getSimpleName()+"_Step_6", driver);
		}

		// User logout
		Common.logoutFromPlatform(homePageURL, driver);
	}
}
