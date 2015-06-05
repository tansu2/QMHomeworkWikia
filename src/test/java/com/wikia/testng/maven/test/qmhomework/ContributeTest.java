package com.wikia.testng.maven.test.qmhomework;

import org.testng.annotations.Test;

public class ContributeTest extends CommonTest{
	
	@Test
	public void addVideo() {
        driver.navigate().to(baseurl);
	}
}
