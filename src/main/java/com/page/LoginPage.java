package com.page;

import com.factory.BrowserFactory;
import com.microsoft.playwright.Locator;

public class LoginPage extends BrowserFactory {

	public Locator emailValidation = page.locator("//mat-error[@id='mat-mdc-error-0']");
	public Locator passwordValidation = page.locator("//mat-error[@id='mat-mdc-error-1']");
	Locator loginEmailTxt = page.locator("//input[@name='email']");
	Locator loginPasswordTxt = page.locator("//input[@name='password']");
	Locator submitBtn = page.locator("//button[@id='login_click']");
	Locator snackBar = page.locator("//simple-snack-bar[contains(@class,\"mat-mdc-simple-snack-bar\")]/div");

	public void fillEmail(String email) {
		loginEmailTxt.fill(email);
	}

	public void fillPassword(String password) {
		loginPasswordTxt.fill(password);
	}

	public void loginWithValidCredentials(String email, String password) {
		fillEmail(email);
		fillPassword(password);
		submitBtn.click();
	}

	public void emailPassMandatory() {
		loginEmailTxt.clear();
		loginPasswordTxt.clear();
		submitBtn.click();
	}

	public String snackBarVisible() {
		return snackBar.textContent().trim();
	}

	public void snackBarInVisible() {
		if (snackBar.isHidden() == false) {
			snackBarInVisible();
		}
	}
}