package com.wikia.testng.maven.page.video;

import org.openqa.selenium.By;

public class VideoDisplayPage {
	
	public enum VideoDisplayPageObjects {

		VIDEO_DISPLAY_TITLE(By.id(""), By.cssSelector(""), By.xpath("//*[@id='WikiaPageHeader']/div/div[1]/h1"), By.name(""), By.linkText(""));

		private By id;
		private By cssPath;
		private By xPath;
		private By name;
		private By linktext;

		private VideoDisplayPageObjects(By idLoc, By cssPathLoc, By xPathLoc, By nameObj, By linkText) {
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
