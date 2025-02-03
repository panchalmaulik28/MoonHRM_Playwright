package com.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.base.BaseTest;
import com.constant.AppConstant;
import com.page.LoginPage;

public class LoginTC extends BaseTest {
	LoginPage loginPage;

	@Test(priority = 1)
	public void loginWithWrongCredentials() {
		loginPage = new LoginPage();
		loginPage.loginWithValidCredentials("maulik.p+admin@moontechnolabs.com", "Qa@123451");
		assertEquals(loginPage.snackBarVisible(), AppConstant.LOGIN_FAILED);
		loginPage.snackBarInVisible();
	}

	@Test(priority = 2)
	public void loginWithValidCredentials() {
		loginPage = new LoginPage();
		loginPage.loginWithValidCredentials("maulik.p+admin@moontechnolabs.com", "Qa@12345");
		assertEquals(loginPage.snackBarVisible(), AppConstant.LOGIN_SUCCESSFUL);
		loginPage.snackBarInVisible();
	}  
}