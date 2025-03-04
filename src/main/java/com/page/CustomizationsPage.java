package com.page;

import com.factory.BrowserFactory;
import com.microsoft.playwright.Locator;

public class CustomizationsPage extends BrowserFactory {

	Locator addBtn = page.locator("//button[contains(@class,'menu-button mdc-fab')]");
	Locator addSkillBtn = page.locator("//button[contains(@class,'two ')][1]");
	Locator nameTxt = page.locator("//input[@formcontrolname='name']");
	Locator saveBtn = page.locator("//span[text()=' Save ']");
	Locator actionBtn = page.locator("//tbody[@role='rowgroup']/tr/td[3]/button");
	Locator nameList = page.locator("//tbody[@role='rowgroup']/tr/td[1]");
	Locator editBtn = page.locator("//span[text()='Edit']");
	Locator deleteBtn = page.locator("//span[text()='Delete']");
	Locator updateBtn = page.locator("//span[text()=' Update ']");
	Locator yesBtn = page.locator("//span[text()='Yes']");
	
	String skillName = "Playwright";

	public void addSkill() {
		addBtn.click();
		addSkillBtn.click();
		nameTxt.fill(skillName);
		saveBtn.click();
	}

	public void editSkill() {
		int count = nameList.count();
		for (int i = 0; i < count - 1; i++) {
			if (nameList.nth(i).textContent().trim().equals(skillName.trim())) {
				actionBtn.nth(i).scrollIntoViewIfNeeded();
				actionBtn.nth(i).click();
				editBtn.click();
				SideMenuPage.spinnerDismiss();
				nameTxt.clear();
				nameTxt.fill(skillName + " Update");
				updateBtn.click();
			}
		}
	}

	public void deleteSkill() {
		int count = nameList.count();
		for (int i = 0; i < count - 1; i++) {
			if (nameList.nth(i).textContent().trim().equals(skillName.trim()+" Update")) {
				actionBtn.nth(i).scrollIntoViewIfNeeded();
				actionBtn.nth(i).click();
				deleteBtn.click();
				yesBtn.click();
			}
		}
	}
}