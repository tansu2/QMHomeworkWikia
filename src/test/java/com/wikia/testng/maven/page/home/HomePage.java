package com.wikia.testng.maven.page.home;

import org.openqa.selenium.By;

public class HomePage {
	public enum HomePageObjects {
		HOME_TOPHEADER(By.id(""), By.cssSelector(""), By.xpath(""), By.name(""), By.linkText("")), 
		
		ON_THE_WIKI(By.id(""), By.cssSelector(""), By.xpath(""), By.name(""), By.linkText("")), 
		
		WIKI_CONTENT(By.id(""), By.cssSelector(""), By.xpath(""), By.name(""), By.linkText("")), 
		
		COMMUNITY(By.id(""), By.cssSelector(""), By.xpath(""), By.name(""), By.linkText("")), 
		
		CONTRIBUTE(By.id(""), By.cssSelector(""), By.xpath(""), By.name(""), By.linkText("")), 
		
		SHARE(By.id(""), By.cssSelector(""), By.xpath(""), By.name(""), By.linkText("")), 
		
		HOME_HELPPAGE_WELCOME(By.id(""), By.cssSelector("div.rtTop.rtSelected"), By.xpath(""), By.name(""), By.linkText(""));
		
		private By id;
		private By cssPath;
		private By xPath;
		private By name;
		private By linktext;

		private HomePageObjects(By idLoc, By cssPathLoc, By xPathLoc, By nameObj, By linkText) {
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