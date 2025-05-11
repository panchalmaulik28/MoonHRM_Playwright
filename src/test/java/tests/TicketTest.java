package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.constant.AppConstant;
import com.pages.BasePage;
import com.pages.SideMenuPage;
import com.pages.TicketPage;

public class TicketTest extends BaseTest {

	TicketPage ticketPage;

	@BeforeClass
	public void object() {
		ticketPage = new TicketPage();
	}

	@BeforeTest
	public void login() {
		LoginTest.loginWithValidCredentials();
	}

	@Test(priority = 0)
	public void addTicketWithoutCC() {
		SideMenuPage.sideMenuClick("Tickets");
		ticketPage.addTicket("Playwright Automation", "Problem", "High", "Nikunj Live", "", "", "", "Hello World",
				"Notes");
		assertEquals(BasePage.getToastMessage(), AppConstant.TICKET_ADD);
		BasePage.hiddenToastMessage();
	}

	@Test(priority = 1, dependsOnMethods = "addTicketWithoutCC")
	public void updateTicketWithoutCC() {
		SideMenuPage.sideMenuClick("Tickets");
		ticketPage.updateTicket("Playwright Automation", "Critical", "Low", "Maulik Live", "");
		assertEquals(BasePage.getToastMessage(), AppConstant.TICKET_UPDATE);
		BasePage.hiddenToastMessage();
	}

	@Test(priority = 2, dependsOnMethods = "updateTicketWithoutCC")
	public void deleteTicket() {
		SideMenuPage.sideMenuClick("Tickets");
		ticketPage.deleteTicket("Playwright Automation Update");
		assertEquals(BasePage.getToastMessage(), "1 " + AppConstant.TICKET_DELETE);
		BasePage.hiddenToastMessage();
	}
}