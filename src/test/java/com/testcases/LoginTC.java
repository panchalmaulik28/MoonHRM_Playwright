package com.testcases;

import org.testng.annotations.Test;

import com.base.BaseTest;
import com.page.LoginPage;

public class LoginTC extends BaseTest {
	LoginPage loginPage;
	
	@Test
	public void loginWithValidCredentials() {
		loginPage = new LoginPage();
		loginPage.loginWithValidCredentials("maulik.p+@moontechnolabs.com","Qa@12345");
	}
	 
	
}
