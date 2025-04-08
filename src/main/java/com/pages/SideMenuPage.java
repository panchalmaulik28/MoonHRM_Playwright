package com.pages;

import com.microsoft.playwright.Locator;
import com.utilities.WebDriverManager;

public class SideMenuPage extends WebDriverManager {

	static Locator sideMenuTextList = page.locator("//span[@class='mdc-list-item__content']/span/span");
	static Locator project = page.locator("//mat-nav-list[contains(@class,'mat-mdc-nav-list')][8]");
	static Locator admin = page.locator("//mat-nav-list[contains(@class,'mat-mdc-nav-list')][15]");
	static Locator subMenuList = page.locator("//div[@class='left_wrap']/div[2]/ul/li");
	static Locator spinner = page.locator("//div[@class='tbl_spinner']");
	static Locator toastMessage = page.locator("//div[@id='toast-container']/div/div");

	public static void sideMenuClick(String sideMenuText) {
		int count = sideMenuTextList.count();
		for (int i = 0; i < count - 1; i++) {
			if (sideMenuTextList.nth(i).textContent().trim().equals(sideMenuText)) {
				if (sideMenuText.equals("Project Summary") || sideMenuText.equals("Project List")
						|| sideMenuText.equals("Project Sprint")) {
					project.first().click();
				}
				if (sideMenuText.equals("Settings") || sideMenuText.equals("Customizations")
						|| sideMenuText.equals("Role & Permissions")) {
					admin.last().click();
				}
				sideMenuTextList.nth(i).click();
				break;
			}
		}
	}

	public static void subMenu(String subMenuValue) {
		int count = subMenuList.count();
		for (int i = 0; i < count - 1; i++) {
			if (subMenuList.nth(i).textContent().trim().equals(subMenuValue)) {
				subMenuList.nth(i).click();
				spinnerDismiss();
				break;
			}
		}
	}

	public static void spinnerDismiss() {
		if (spinner.isVisible()) {
			spinnerDismiss();
		}
	}

	public static String getToastMessage() {
		if (!toastMessage.isVisible()) {
			getToastMessage();
		}
		return toastMessage.textContent().trim();
	}

	public static void hiddenToastMessage() {
		if (toastMessage.isVisible()) {
			hiddenToastMessage();
		}
	}
}