package com.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.base.BaseTest;
import com.constant.AppConstant;
import com.factory.BrowserFactory;
import com.page.LoginPage;

public class LoginTC extends BaseTest {
	static LoginPage loginPage;
	static String email =(String) BrowserFactory.prop.get("emailAdmin");
	static String password = (String) BrowserFactory.prop.get("password");
	
	@Test(priority = 1)
	public void emailPassMandatory() {
		loginPage = new LoginPage();
		loginPage.emailPassMandatory();
		assertEquals(loginPage.emailValidation.textContent().trim(), AppConstant.EMAIL_VALIDATION);
		assertEquals(loginPage.passwordValidation.textContent().trim(), AppConstant.PASSWORD_VALIDATION);
	}

	@Test(priority = 2)
	public void loginWithWrongCredentials() {
		loginPage = new LoginPage();
		loginPage.loginWithValidCredentials(email, password + "1");
		assertEquals(loginPage.snackBarVisible(), AppConstant.LOGIN_FAILED);
		loginPage.snackBarInVisible();
	}

	@Test(priority = 3)
	public static void loginWithValidCredentials() {
		loginPage = new LoginPage();
		loginPage.loginWithValidCredentials(email, password);
		assertEquals(loginPage.snackBarVisible(), AppConstant.LOGIN_SUCCESSFUL);
		loginPage.snackBarInVisible();
	}
}