package com.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.constant.AppConstant;
import com.page.CustomizationsPage;
import com.page.SideMenuPage;

public class CustomizationsTC extends BaseTest {

	CustomizationsPage customizationsPage;

	@BeforeClass
	public void login() {
		LoginTC.loginWithValidCredentials();
	}

	@Test(priority = 1)
	public void addSkill() {
		customizationsPage = new CustomizationsPage();
		SideMenuPage.sideMenuClick("Customizations");
		SideMenuPage.subMenu("Skills");
		customizationsPage.addSkill();
		assertEquals(SideMenuPage.getToastMessage(), AppConstant.SKILL_ADD);
		SideMenuPage.hiddenToastMessage();
	}

	@Test(priority = 2, dependsOnMethods = "addSkill")
	public void editSkill() {
		customizationsPage = new CustomizationsPage();
		SideMenuPage.sideMenuClick("Customizations");
		SideMenuPage.subMenu("Skills");
		customizationsPage.editSkill();
		assertEquals(SideMenuPage.getToastMessage().trim(), AppConstant.SKILL_UPDATE);
		SideMenuPage.hiddenToastMessage();
	}

	@Test(priority = 3, dependsOnMethods = "editSkill")
	public void deleteSkill() {
		customizationsPage = new CustomizationsPage();
		SideMenuPage.sideMenuClick("Customizations");
		SideMenuPage.subMenu("Skills");
		customizationsPage.deleteSkill();
		assertEquals(SideMenuPage.getToastMessage().trim(), AppConstant.SKILL_DELETE);
		SideMenuPage.hiddenToastMessage();
	}
}