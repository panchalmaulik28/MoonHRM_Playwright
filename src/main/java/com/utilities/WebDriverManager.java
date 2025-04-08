package com.utilities;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class WebDriverManager {

	static Playwright playwright;
	static Browser browser;
	static BrowserContext browserContext;
	public static Page page;
	public static Properties prop;

	public static void browserInvoke() {

		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int) dimension.getHeight();
		int width = (int) dimension.getWidth();

		prop = ConfigRead.config();
		String browserName = (String) prop.get("browser");
		String URL = (String) prop.get("url");
		playwright = Playwright.create();

		switch (browserName.trim()) {
		case "Chromium":
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
		case "firefox":
			browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
		case "safari":
			browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
		case "chrome":
			browser = playwright.chromium()
					.launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
			break;
		default:
			System.out.println("Please correct browser spelling...");
			break;
		}

		browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(width, height));
		page = browserContext.newPage();
		page.navigate(URL);
	}

	public static void tearDown() {
		if (page != null) {
			page.close();
			page = null;
		}
	}

}
