package com.wikia.testng.maven.page.common;

import org.openqa.selenium.By;

public class CommonPage {

	public enum CommonPageObjects
	{
		/** Header icon **/
		HEADER(By.id(""), By.cssSelector("#globalNavigation"), By.xpath("//*[@id=['globalNavigation']"), By.name(""), By.linkText("")),
		
		/**	Category dropdown menu **/
		CATEGORY(By.id(""), By.cssSelector(""), By.xpath(""), By.name(""), By.linkText("")),
		
		/** Search box options **/
		SEARCH_SCOPE(By.id(""), By.cssSelector(""), By.xpath(""), By.name(""), By.linkText("")),
		SEARCH_BAR(By.id(""), By.cssSelector(""), By.xpath(""), By.name(""), By.linkText("")),
		SEARCH_GO(By.id(""), By.cssSelector(""), By.xpath(""), By.name(""), By.linkText("")),
		
		/**	Sign in dropdown menu **/
		SIGNIN(By.id(""), By.cssSelector("#AccountNavigation > li"), By.xpath("//*[@id='AccountNavigation']/li"), By.name(""), By.linkText("")),
		SIGNUP(By.id(""), By.cssSelector(""), By.xpath(""), By.name(""), By.linkText("")),
		USERNAME(By.id("usernameInput"), By.cssSelector("#usernameInput"), By.xpath(""), By.name(""), By.linkText("")),
		PASSWORD(By.id("passwordInput"), By.cssSelector("#passwordInput"), By.xpath(""), By.name(""), By.linkText("")),
		FORGET_PASSWORD(By.id(""), By.cssSelector(""), By.xpath(""), By.name(""), By.linkText("")),
		STAY_LOGGEDIN_CKBX(By.id(""), By.cssSelector("#UserLoginDropdown > form > fieldset > div.input-group.keep-logged-in > label > input"), By.xpath(""), By.name(""), By.linkText("")),
		LOGIN(By.id(""), By.cssSelector("#UserLoginDropdown > form > fieldset > div.input-group.login-button > input"), By.xpath(""), By.name(""), By.linkText("")),
		FACEBOOK_CONNECT(By.id(""), By.cssSelector(""), By.xpath(""), By.name(""), By.linkText("")),
		
		/** User dropdown menu after sign in **/
		MESSAGE_WALL(By.id(""), By.cssSelector("#AccountNavigation > li > ul > li:nth-child(1) > a"), By.xpath(""), By.name(""), By.linkText("")),
		MY_PREFERENCE(By.id(""), By.cssSelector("#AccountNavigation > li > ul > li:nth-child(2) > a"), By.xpath(""), By.name(""), By.linkText("")),
		HELP(By.id(""), By.cssSelector("#AccountNavigation > li > ul > li:nth-child(3) > a"), By.xpath(""), By.name(""), By.linkText("")),
		SIGNOUT(By.id(""), By.cssSelector("#AccountNavigation > li > ul > li:nth-child(4) > a"), By.xpath(""), By.name(""), By.linkText("")),
		
		/** Notification dropdown menu after sign in **/
		
		/** Start a wikia **/
		START_A_WIKIA(By.id(""), By.cssSelector(""), By.xpath(""), By.name(""), By.linkText(""));
		
		private By id;
		private By cssPath;
		private By xPath;
		private By name;
		private By linktext;

		private CommonPageObjects(By idLoc, By cssPathLoc, By xPathLoc, By nameObj, By linkText) {
			id = idLoc;
			cssPath = cssPathLoc;
			xPath = xPathLoc;
			name = nameObj;
			linktext = linkText;
		}

		public By getId() {
			return id;
		}

		public By getCssPath() {
			return cssPath;
		}

		public By getXPath() {
			return xPath;
		}

		public By getLabel() {
			return name;
		}

		public By byLocator() {
			if (id.equals(By.id(""))) {
				if (cssPath.equals(By.cssSelector(""))) {
					if (name.equals(By.name(""))) {
						if (linktext.equals(By.linkText("")))
							return (xPath);
						else
							return linktext;
					} else {
						return (name);
					}
				} else {
					return (cssPath);
				}
			} else {
				return (id);
			}
		}
	}
}
