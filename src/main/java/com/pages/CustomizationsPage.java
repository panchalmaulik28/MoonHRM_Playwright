package com.pages;

import com.microsoft.playwright.Locator;
import com.utilities.WebDriverManager;


public class CustomizationsPage extends WebDriverManager {
 
	Locator addBtn = page.locator("//button[contains(@class,'menu-button mdc-fab')]");
	Locator addSkillBtn = page.locator("//button[contains(@class,'two ')][1]");
	Locator nameTxt = page.locator("//input[@formcontrolname='name']");
	Locator saveBtn = page.locator("//span[text()=' Save ']");
	Locator actionBtn = page.locator("//tbody[@role='rowgroup']/tr/td[3]/button");
	Locator actionBtn1 = page.locator("//tbody[@role='rowgroup']/tr/td[4]/button");
	Locator nameList = page.locator("//tbody[@role='rowgroup']/tr/td[1]");
	Locator editBtn = page.locator("//span[text()='Edit']");
	Locator deleteBtn = page.locator("//span[text()='Delete']");
	Locator updateBtn = page.locator("//span[text()=' Update ']");
	Locator yesBtn = page.locator("//span[text()='Yes']");
	Locator roleDD = page.locator("//mat-select[@id='mat-select-16']");
	Locator listBox = page.locator("//div[@role='listbox']");
	Locator rolelistTxt = page.locator("//div[@role='listbox']/mat-option/span");
	Locator popup = page.locator("//mat-dialog-container[@role='dialog']");

	String text = "Playwright Automation";

	public void addSkill() {
		addBtn.click();
		addSkillBtn.click();
		nameTxt.fill(text);
		saveBtn.click();
	}

	public void editSkill() {
		int count = nameList.count();
		for (int i = 0; i < count - 1; i++) {
			if (nameList.nth(i).textContent().trim().equals(text.trim())) {
				actionBtn.nth(i).scrollIntoViewIfNeeded();
				actionBtn.nth(i).click();
				editBtn.click();
				SideMenuPage.spinnerDismiss();
				nameTxt.clear();
				nameTxt.fill(text + " Update");
				updateBtn.click();
			}
		}
	}

	public void deleteSkill() {
		int count = nameList.count();
		for (int i = 0; i < count - 1; i++) {
			if (nameList.nth(i).textContent().trim().equals(text.trim() + " Update")) {
				actionBtn.nth(i).scrollIntoViewIfNeeded();
				actionBtn.nth(i).click();
				deleteBtn.click();
				yesBtn.click();
			}
		}
	}

	public void addDesignationsTeam(String role) {
		addBtn.click();
		addSkillBtn.click();
		nameTxt.fill(text);
		roleDD.click();
		int count = rolelistTxt.count();
		System.out.println("Add Count" + count);
		for (int i = 0; i < count - 1; i++) {
			if (rolelistTxt.nth(i).textContent().trim().equals(role)) {
				rolelistTxt.nth(i).scrollIntoViewIfNeeded();
				rolelistTxt.nth(i).click();
				break;
			}
		}
		saveBtn.click();
	}

	public void editDesignationsTeam(String role) {
		int count = nameList.count();
		for (int i = 0; i < count - 1; i++) {
			if (nameList.nth(i).textContent().trim().equals(text.trim())) {
				actionBtn1.nth(i).scrollIntoViewIfNeeded();
				actionBtn1.nth(i).click();
				editBtn.click();
				SideMenuPage.spinnerDismiss();
				break;
			}
		}
		nameTxt.clear();
		nameTxt.fill(text + " Update");

		//roleDD.waitFor();
		roleDD.click();
		//listBox.waitFor();
		int count1 = rolelistTxt.count();
		System.out.println("edit Count" + count);
		for (int i = 0; i < count1 - 1; i++) {
			if (rolelistTxt.nth(i).textContent().trim().equals(role)) {
				rolelistTxt.nth(i).scrollIntoViewIfNeeded();
				rolelistTxt.nth(i).click();
				break;
			}
		}
		updateBtn.click();
	}

	public void deleteDesignationsTeam() {
		int count = nameList.count();
		System.out.println("edit Count" + count);
		for (int i = 0; i < count - 1; i++) {
			if (nameList.nth(i).textContent().trim().equals(text.trim() + " Update")) {
				actionBtn1.nth(i).scrollIntoViewIfNeeded();
				actionBtn1.nth(i).click();
				deleteBtn.click();
				yesBtn.click();
				break;
			}
		}
	}
}