package com.wikia.testng.maven.test.qmhomework;

import org.testng.annotations.Test;

public class Login extends CommonTest{

	@Test
	public void loginLogout() {
        driver.navigate().to(baseurl);
	}
}
