package com.wikia.testng.maven.page.video;

import org.openqa.selenium.By;

public class VideoAddPage {
	public enum VideoAddPageObjects {
		
		VIDEO_ADD_TITLE(By.id(""), By.cssSelector(""), By.xpath("//*[@id='WikiaPageHeader']/div/div[1]/h1"), By.name(""), By.linkText("")),
		VIDEO_ADD_SUBTITLE(By.id(""), By.cssSelector(""), By.xpath("//*[@id='WikiaPageHeader']/div/div[1]/h2"), By.name(""), By.linkText("")),
		
		VIDEO_ADD_URL(By.id(""), By.cssSelector(""), By.xpath("//*[@id='wpWikiaVideoAddUrl']"), By.name(""), By.linkText("")),
		VIDEO_ADD_URL_SUBMIT(By.id(""), By.cssSelector(""), By.xpath("//*[@id='mw-content-text']/form/div/input"), By.name(""), By.linkText("")),
		
		FLASH_MESSAGE(By.id(""), By.cssSelector(""), By.xpath("//*[@id='WikiaPage']/div[2]/div/div/div/text()[1]"), By.name(""), By.linkText("")),
		FLASH_MESSAGE_FILELINK(By.id(""), By.cssSelector(""), By.xpath("//*[@id='WikiaPage']/div[2]/div/div/div/a"), By.name(""), By.linkText("")),
		FLASH_MESSAGE_CLOSE(By.id(""), By.cssSelector(""), By.xpath("//*[@id='WikiaPage']/div[2]/div/div/button"), By.name(""), By.linkText(""));
		
		private By id;
		private By cssPath;
		private By xPath;
		private By name;
		private By linktext;

		private VideoAddPageObjects(By idLoc, By cssPathLoc, By xPathLoc, By nameObj, By linkText) {
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