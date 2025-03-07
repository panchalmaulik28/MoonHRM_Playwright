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
		skillDepartmentPlatformsCRUD("Customizations", "Skills", "add");
	}

	@Test(dependsOnMethods = "addSkill")
	public void editSkill() {
		skillDepartmentPlatformsCRUD("Customizations", "Skills", "edit");
	}

	@Test(dependsOnMethods = "editSkill")
	public void deleteSkill() {
		skillDepartmentPlatformsCRUD("Customizations", "Skills", "delete");
	}

	@Test(priority = 2)
	public void addDepartment() {
		skillDepartmentPlatformsCRUD("Customizations", "Departments", "add");
	}

	@Test(dependsOnMethods = "addDepartment")
	public void editDepartment() {
		skillDepartmentPlatformsCRUD("Customizations", "Departments", "edit");
	}

	@Test(dependsOnMethods = "editDepartment")
	public void deleteDepartment() {
		skillDepartmentPlatformsCRUD("Customizations", "Departments", "delete");
	}

	@Test(priority = 3)
	public void addPlatforms() {
		skillDepartmentPlatformsCRUD("Customizations", "Platforms", "add");
	}

	@Test(dependsOnMethods = "addPlatforms")
	public void editPlatforms() {
		skillDepartmentPlatformsCRUD("Customizations", "Platforms", "edit");
	}

	@Test(dependsOnMethods = "editPlatforms")
	public void deletePlatforms() {
		skillDepartmentPlatformsCRUD("Customizations", "Platforms", "delete");
	}

	public void skillDepartmentPlatformsCRUD(String menu, String subMenu, String operation) {
		customizationsPage = new CustomizationsPage();
		SideMenuPage.sideMenuClick(menu);
		SideMenuPage.subMenu(subMenu);

		if (operation.equals("add")) {
			customizationsPage.addSkill();
			if (subMenu.equals("Skills")) {
				assertEquals(SideMenuPage.getToastMessage(), AppConstant.SKILL_ADD);
			} else if (subMenu.equals("Departments")) {
				assertEquals(SideMenuPage.getToastMessage(), AppConstant.DEPARTMENT_ADD);
			} else if (subMenu.equals("Platforms")) {
				assertEquals(SideMenuPage.getToastMessage(), AppConstant.PLATFORM_ADD);
			}
		} else if (operation.equals("edit")) {
			customizationsPage.editSkill();
			if (subMenu.equals("Skills")) {
				assertEquals(SideMenuPage.getToastMessage().trim(), AppConstant.SKILL_UPDATE);
			} else if (subMenu.equals("Departments")) {
				assertEquals(SideMenuPage.getToastMessage(), AppConstant.DEPARTMENT_UPDATE);
			} else if (subMenu.equals("Platforms")) {
				assertEquals(SideMenuPage.getToastMessage(), AppConstant.PLATFORM_UPDATE);
			}
		} else if (operation.equals("delete")) {
			customizationsPage.deleteSkill();
			if (subMenu.equals("Skills")) {
				assertEquals(SideMenuPage.getToastMessage().trim(), AppConstant.SKILL_DELETE);
			} else if (subMenu.equals("Departments")) {
				assertEquals(SideMenuPage.getToastMessage(), AppConstant.DEPARTMENT_DELETE);
			} else if (subMenu.equals("Platforms")) {
				assertEquals(SideMenuPage.getToastMessage(), AppConstant.PLATFORM_DELETE);
			}
		}
		SideMenuPage.hiddenToastMessage();
	}
}