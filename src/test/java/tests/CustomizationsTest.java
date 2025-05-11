package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.base.BaseTest;
import com.constant.AppConstant;
import com.pages.BasePage;
import com.pages.CustomizationsPage;
import com.pages.SideMenuPage;

public class CustomizationsTest extends BaseTest {

	CustomizationsPage customizationsPage;

	@BeforeClass
	public void object() {
		customizationsPage = new CustomizationsPage();
	}

	@BeforeTest
	public void login() {
		LoginTest.loginWithValidCredentials();
	}

	@Test(priority = 0)
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

	@Test(priority = 1)
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

	@Test(priority = 2)
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

		SideMenuPage.sideMenuClick(menu);
		SideMenuPage.subMenu(subMenu);

		if (operation.equals("add")) {

			customizationsPage.addSkillDepartmentPlatformDesignationsTeam("");

			if (subMenu.equals("Skills")) {
				assertEquals(BasePage.getToastMessage(), AppConstant.SKILL_ADD);
			} else if (subMenu.equals("Departments")) {
				assertEquals(BasePage.getToastMessage(), AppConstant.DEPARTMENT_ADD);
			} else if (subMenu.equals("Platforms")) {
				assertEquals(BasePage.getToastMessage(), AppConstant.PLATFORM_ADD);
			}
		} else if (operation.equals("edit")) {

			customizationsPage.editSkillDepartmentPlatform();

			if (subMenu.equals("Skills")) {
				assertEquals(BasePage.getToastMessage().trim(), AppConstant.SKILL_UPDATE);
			} else if (subMenu.equals("Departments")) {
				assertEquals(BasePage.getToastMessage(), AppConstant.DEPARTMENT_UPDATE);
			} else if (subMenu.equals("Platforms")) {
				assertEquals(BasePage.getToastMessage(), AppConstant.PLATFORM_UPDATE);
			}
		} else if (operation.equals("delete")) {

			customizationsPage.deleteSkillDepartmentPlatform();

			if (subMenu.equals("Skills")) {
				assertEquals(BasePage.getToastMessage().trim(), AppConstant.SKILL_DELETE);
			} else if (subMenu.equals("Departments")) {
				assertEquals(BasePage.getToastMessage(), AppConstant.DEPARTMENT_DELETE);
			} else if (subMenu.equals("Platforms")) {
				assertEquals(BasePage.getToastMessage(), AppConstant.PLATFORM_DELETE);
			}
		}
		BasePage.hiddenToastMessage();
	}

	@Test(priority = 3)
	public void addTeams() {
		designationsTeamsCRUD("Customizations", "Teams", "add");
	}

	@Test(dependsOnMethods = "addTeams")
	public void editTeams() {
		designationsTeamsCRUD("Customizations", "Teams", "edit");
	}

	@Test(dependsOnMethods = "editTeams")
	public void deleteTeams() {
		designationsTeamsCRUD("Customizations", "Teams", "delete");
	}

	@Test(priority = 4)
	public void addDesignations() {
		designationsTeamsCRUD("Customizations", "Designations", "add");
	}

	@Test(dependsOnMethods = "addDesignations")
	public void editDesignations() {
		designationsTeamsCRUD("Customizations", "Designations", "edit");
	}

	@Test(dependsOnMethods = "editDesignations")
	public void deleteDesignations() {
		designationsTeamsCRUD("Customizations", "Designations", "delete");
	}

	public void designationsTeamsCRUD(String menu, String subMenu, String operation) {

		SideMenuPage.sideMenuClick(menu);
		SideMenuPage.subMenu(subMenu);

		if (operation.equals("add")) {

			if (subMenu.equals("Designations")) {
				customizationsPage.addSkillDepartmentPlatformDesignationsTeam("General");
				assertEquals(BasePage.getToastMessage(), AppConstant.DESIGNATION_ADD);
			} else if (subMenu.equals("Teams")) {
				customizationsPage.addSkillDepartmentPlatformDesignationsTeam("CEO CEO");
				assertEquals(BasePage.getToastMessage(), AppConstant.TEAM_ADD);
			}
		} else if (operation.equals("edit")) {

			if (subMenu.equals("Designations")) {
				customizationsPage.editDesignationsTeam("HR");
				assertEquals(BasePage.getToastMessage(), AppConstant.DESIGNATION_UPDATE);
			} else if (subMenu.equals("Teams")) {
				customizationsPage.editDesignationsTeam("CEO CEO");
				assertEquals(BasePage.getToastMessage(), AppConstant.TEAM_UPDATE);
			}
		} else if (operation.equals("delete")) {
			customizationsPage.deleteDesignationsTeam();
			if (subMenu.equals("Designations")) {
				assertEquals(BasePage.getToastMessage(), AppConstant.DESIGNATION_DELETE);
			} else if (subMenu.equals("Teams")) {
				assertEquals(BasePage.getToastMessage(), AppConstant.TEAM_DELETE);
			}
		}
		BasePage.hiddenToastMessage();
	}
}