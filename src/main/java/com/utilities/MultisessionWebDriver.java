package com.utilities;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class MultisessionWebDriver {
	private static ThreadLocal<Playwright> playwright;
	private static ThreadLocal<Browser> browser;
	private static ThreadLocal<BrowserContext> browserContext;
	private static ThreadLocal<Page> page;
	Properties pro;

	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int screenWidth = screenSize.width;
	int screenHeight = screenSize.height;
	 
	public Playwright getPlaywright() {
		return playwright.get();
	}

	public Browser getBrowser() {
		return browser.get();
	}

	public BrowserContext getBrowserContext() {
		return browserContext.get();
	}

	public Page getPage() {
		return page.get();
	}

	public Page invokeBrowser(Properties pro) {
		String browserName = (String) pro.get("browser");
		String url = (String) pro.get("url");

		playwright = new ThreadLocal<Playwright>();
		browser = new ThreadLocal<Browser>();
		browserContext = new ThreadLocal<BrowserContext>();
		page = new ThreadLocal<Page>();
		playwright.set(Playwright.create());

		switch (browserName.trim()) {
		case "Chromium":
			browser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)));
			break;
		case "firefox":
			browser.set(getPlaywright().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false)));
			break;
		case "safari":
			browser.set(getPlaywright().webkit().launch(new BrowserType.LaunchOptions().setHeadless(false)));
			break;
		case "chrome":
			browser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false)));
			break;
		default:
			System.out.println("Please correct browser spelling...");
			break;
		}

		browserContext.set(getBrowser().newContext(new Browser.NewContextOptions().setViewportSize(null)));
		page.set(getBrowserContext().newPage());
		getPage().navigate(url);
		return getPage();
	}
}
