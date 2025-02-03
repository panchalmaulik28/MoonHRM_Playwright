package com.base;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.factory.BrowserFactory;

public class BaseTest {

	@BeforeTest
	public void invoke() {
		BrowserFactory.browserInvoke();
	}

	@AfterTest
	public void closeBrowser() {
		BrowserFactory.tearDown();
	}

}
