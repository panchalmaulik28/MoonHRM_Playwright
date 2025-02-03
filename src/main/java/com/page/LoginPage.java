package com.page;

import com.factory.BrowserFactory;

public class LoginPage extends BrowserFactory {

	private String snackBar = "//simple-snack-bar[contains(@class,\"mat-mdc-simple-snack-bar\")]/div";
	private String loginEmailTxt = "//input[@name='email']";
	private String loginPasswordTxt = "//input[@name='password']";
	private String submitBtn = "//button[@id='login_click']";

	public void fillEmail(String email) {
		page.fill(loginEmailTxt, email);
	}

	public void fillPassword(String password) {
		page.fill(loginPasswordTxt, password);
	}

	public void loginWithValidCredentials(String email, String password) {
		fillEmail(email);
		fillPassword(password);
		page.click(submitBtn);
	}

	public String snackBarVisible() {
		return page.textContent(snackBar).trim();
	}

	public void snackBarInVisible() {
		 if(page.locator(snackBar).isHidden() == false) {
			 snackBarInVisible();
		 }
	}	
}