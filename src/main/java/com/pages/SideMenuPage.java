package com.pages;

import com.microsoft.playwright.Locator;
import com.utilities.WebDriverManager;

public class SideMenuPage extends WebDriverManager {

	static Locator sideMenuTextList = page.locator("//span[@class='mdc-list-item__content']/span/span");
	static Locator project = page.locator("//mat-nav-list[contains(@class,'mat-mdc-nav-list')][8]");
	static Locator admin = page.locator("//mat-nav-list[contains(@class,'mat-mdc-nav-list')][15]");
	static Locator subMenuList = page.locator("//div[@class='left_wrap']/div[2]/ul/li");
	
	public static void sideMenuClick(String sideMenuText) {
		int count = sideMenuTextList.count();
		if (count > 0) {
			for (int i = 0; i < count - 1; i++) {
				if (sideMenuTextList.nth(i).textContent().trim().contains(sideMenuText)) {
					if (sideMenuText.equals("Project Summary") || sideMenuText.contains("Project List")
							|| sideMenuText.equals("Project Sprint")) {
						project.scrollIntoViewIfNeeded();
						project.first().click();
						BasePage.spinnerDismiss();
					}
					if (sideMenuText.equals("Settings") || sideMenuText.contains("Customizations")
							|| sideMenuText.equals("Role & Permissions")) {
						admin.scrollIntoViewIfNeeded();
						admin.last().click();
						BasePage.spinnerDismiss();
					}
					sideMenuTextList.nth(i).click();
					BasePage.spinnerDismiss();
					break;
				}
			}
		} else {
			sideMenuClick(sideMenuText);
		}
		BasePage.spinnerDismiss();
	}

	public static void subMenu(String subMenuValue) {
		int count = subMenuList.count();
		if (count > 0) {
			for (int i = 0; i < count - 1; i++) {
				if (subMenuList.nth(i).textContent().trim().equals(subMenuValue)) {
					subMenuList.nth(i).scrollIntoViewIfNeeded();
					subMenuList.nth(i).click();
					BasePage.spinnerDismiss();
					break;
				}
			}
		} else {
			subMenu(subMenuValue);
		}
		BasePage.spinnerDismiss();
	}
}