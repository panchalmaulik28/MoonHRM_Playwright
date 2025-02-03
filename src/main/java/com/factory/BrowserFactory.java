package com.factory;

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
		prop = config();
		String  browserConfig = (String) prop.get("browser");
		String  URL = (String) prop.get("url");
		
		LaunchOptions lp = new LaunchOptions();
		lp.setChannel(browserConfig);
		lp.setHeadless(false);
		playwright = Playwright.create();
		browser = playwright.chromium().launch(lp);
		browserContext = browser.newContext();
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
