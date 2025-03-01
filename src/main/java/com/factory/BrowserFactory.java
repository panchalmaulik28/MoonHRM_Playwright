package com.factory;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

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
	public static Properties prop;

	public static void browserInvoke() {

		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int) dimension.getHeight();
		int width = (int) dimension.getWidth();

		prop = config();
		String browserName = (String) prop.get("browser");
		String URL = (String) prop.get("url");
		playwright = Playwright.create();
		browser = playwright.chromium().launch(new LaunchOptions().setChannel(browserName).setHeadless(false));
		browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(width, height));
		page = browserContext.newPage();
		page.navigate(URL);
	}

	public static void tearDown() {
		page.close();
	}

	public static Properties config() {
		try {
			prop = new Properties();
			FileInputStream file = new FileInputStream("./src/test/resources/config.properites");
			prop.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
}
