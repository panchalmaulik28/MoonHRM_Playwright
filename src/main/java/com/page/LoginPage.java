package com.page;

import com.factory.BrowserFactory;

public class LoginPage extends BrowserFactory{

	
	
	private String loginEmailTxt = "//input[@name='email']";
	private String loginPasswordTxt = "//input[@name='password']";
	
	
	public void fillEmail(String email) {
		page.fill(loginEmailTxt, email);
	}

	public void fillPassword(String password) {
		page.fill(loginPasswordTxt, password);
	}

	public void loginWithValidCredentials(String email, String password) {
		fillEmail(email);
		fillPassword(password);
	}

}

