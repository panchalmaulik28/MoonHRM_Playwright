package tests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.BeforeClass; 
import org.testng.annotations.Test;
import com.base.BaseTest;
import com.constant.AppConstant;
import com.pages.BasePage;
import com.pages.LoginPage;
import com.pages.SideMenuPage;
import com.utilities.ConfigRead;

public class LoginTest extends BaseTest {
	static LoginPage loginPage;
	static String email;
	static String password;

	@BeforeClass
	public void object() {
		loginPage = new LoginPage();
	}

	@Test(priority = 0)
	public void emailPassMandatory() {
		loginPage.emailPassMandatory();
		assertEquals(loginPage.getEmailValidationText(), AppConstant.EMAIL_VALIDATION);
		assertEquals(loginPage.getPasswordValidationText(), AppConstant.PASSWORD_VALIDATION);
	}

	@Test(priority = 1)
	public void loginWithWrongCredentials() {
		email = (String) ConfigRead.prop.get("emailAdmin");
		password = (String) ConfigRead.prop.get("password");
		loginPage.loginWithValidCredentials(email, password + "1");
		assertEquals(BasePage.snackBarVisible(), AppConstant.LOGIN_FAILED);
		BasePage.snackBarInVisible();
	}

	@Test(priority = 2)
	public static void loginWithValidCredentials() {
		if (loginPage == null) {
			loginPage = new LoginPage();
		}
		email = (String) ConfigRead.prop.get("emailAdmin");
		password = (String) ConfigRead.prop.get("password");
		loginPage.loginWithValidCredentials(email, password);
		assertEquals(BasePage.snackBarVisible(), AppConstant.LOGIN_SUCCESSFUL);
		BasePage.snackBarInVisible();
		BasePage.spinnerDismiss();
	}
}