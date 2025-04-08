package com.base;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.utilities.WebDriverManager;

public class BaseTest {

	@BeforeTest
	public void invoke() {
		WebDriverManager.browserInvoke();
	}

	@AfterTest
	public void closeBrowser() {
		WebDriverManager.tearDown();
	}
}