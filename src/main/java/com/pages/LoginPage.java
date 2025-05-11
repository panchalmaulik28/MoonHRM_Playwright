package com.pages;

import com.microsoft.playwright.Locator;
import com.utilities.WebDriverManager;

public class LoginPage extends WebDriverManager {

	Locator emailValidation = page.locator("//mat-error[@id='mat-mdc-error-0']");
	Locator passwordValidation = page.locator("//mat-error[@id='mat-mdc-error-1']");
	Locator loginEmailTxt = page.locator("//input[@name='email']");
	Locator loginPasswordTxt = page.locator("//input[@name='password']");
	Locator submitBtn = page.locator("//button[@id='login_click']");

	public void fillEmail(String email) {
		loginEmailTxt.fill(email);
	}

	public String getEmailValidationText() {
		return emailValidation.textContent().trim();
	}
	
	public String getPasswordValidationText() {
		return passwordValidation.textContent().trim();
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
}