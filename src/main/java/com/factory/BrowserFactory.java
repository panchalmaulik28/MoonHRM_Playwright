package com.factory;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class BrowserFactory {

	static Playwright playwright;
	static Browser browser;
	static BrowserContext browserContext;
	public static Page page;
	
	public static void browserInvoke() {
		LaunchOptions lp = new LaunchOptions();
		lp.setChannel("chrome");
		lp.setHeadless(false);
		playwright = Playwright.create();
		browser = playwright.chromium().launch(lp);
		browserContext = browser.newContext();
		page = browserContext.newPage();
		page.navigate("https://beta2.moontechnolabs.com/clockinout/#/login");
	}
	
	public static void tearDown() {
		page.close();
	}
}
