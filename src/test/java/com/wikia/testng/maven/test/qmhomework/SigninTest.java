package com.wikia.testng.maven.test.qmhomework;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.wikia.testng.maven.page.common.CommonPage.CommonPageObjects;
import com.wikia.testng.maven.util.UtilityCommon;

public class SigninTest extends CommonTest {

	/**
	 * @author Tan Su
	 * @date 2015-06-05
	 */
	@Test
	public void loginLogout() {
		
		/**
		 *  Step 1: 
		 *  Action: navigate to baseurl of http://qm-homework.wikia.com
		 *  Expected: user is redirected to homepageurl of
		 *  http://qm-homework.wikia.com/wiki/QM_HomeWork_Wikia
		 */
		try{
			driver.navigate().to(baseurl);	
			String currentURL = driver.getCurrentUrl();
			Assert.assertEquals(currentURL, homepageurl);
		} catch (AssertionError e){
			e.getMessage();
			UtilityCommon.capturescreenshot(this.getClass().getSimpleName()+"_Step_1", driver);
		}
		
		UtilityCommon.hoverOverMenuItem(CommonPageObjects.SIGNIN.byLocator(), driver);
	}
}
