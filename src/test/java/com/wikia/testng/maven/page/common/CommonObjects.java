package com.wikia.testng.maven.page.common;

import org.openqa.selenium.By;

public class CommonObjects {

	public enum CommonPageObjects
	{
		HEADER(By.id(""), By.cssSelector("#globalNavigation"), By.xpath("//*[@id=['globalNavigation']"), By.name(""), By.linkText(""));

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
