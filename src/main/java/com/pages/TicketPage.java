package com.pages;

import static org.testng.Assert.assertEquals;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Locator.WaitForOptions;
import com.microsoft.playwright.options.WaitForSelectorState;
import com.utilities.WebDriverManager;

public class TicketPage extends WebDriverManager {

	/*-----List-----*/
	private Locator addTicket_Btn = page.locator("(//div[contains(@class,'add_new_icon')]/button)[1]");
	private Locator ticketCount_Text = page.locator("//h5[contains(@class,'total_value_txt')]");
	private Locator ticketListStatus_TextList = page.locator("//div[contains(@class,'status_div')]/span");
	private Locator subjectTitle_TextList = page.locator("//div[@class='user_name_div']/span");
	private Locator ticketIdInList = page.locator("//div[@class='number_div']/span");
	private Locator ticketIdInDetails = page.locator("//div[@class='ticket-info-box']/span[2]");
	// private Locator delete_Btn =
	// page.locator("//button[contains(@class,'delete-icon')]");

	/*-----detail----*/
	private Locator createTicketHeader_Text = page.locator("//div[contains(@class,'main_wrap')] //h1");
	private Locator subject_Txtbox = page.locator("//input[@formcontrolname='subject']");
	private Locator ticketType_DD = page.locator("(//mat-select[@formcontrolname='type'])[2]");
	private Locator ticketPriority_DD = page.locator("(//mat-select[@formcontrolname='priority'])[2]");
	private Locator listBox = page.locator("//div[@role='listbox']");
	private Locator typePriority_List = page.locator("//mat-option //span");
	private Locator assignee_Txtbox = page.locator("//input[@formcontrolname='assigned_to']");
	private Locator assigneeCC_ListText = page.locator("//mat-option[@role='option']/span/span/span[2]");
	private Locator cc_Txtbox = page.locator("//input[@formcontrolname='assigned_to_cc']");
	private Locator separateTicketForEachAssignee_Chkbox = page.locator("(//div[@class='mdc-checkbox']/input)[22]");
	private Locator anonymously_Chkbox = page.locator("(//div[@class='mdc-checkbox']/input)[23]");
	private Locator tag_Txtbox = page.locator("//input[@formcontrolname='tags']");
	private Locator save_btn = page.locator("//button[@type='submit']");
	private Locator notesTextArea = page.locator("//div[contains(@class,'ql-editor')]");
	private Locator ticketEditBtn = page.locator("//div[contains(@class,'top_right_btn_div')]/button[1]");
	private Locator ticketStatusEdit_Btn = page.locator("//div[contains(@class,'top_right_btn_div')]/button[3]");
	private Locator ticketStatusList = page.locator("//button[@role='menuitem']/span");
	// Locator delete_Btn =
	// page.locator("//div[contains(@class,'list_scroll_view_ticekts')]/div["+i+1+"]/div[2]/div/div[2]/button");

	/*-----Alert Box----*/
	private Locator alertBox = page.locator("//div[contains(@class,'project_popup_div')]");
	private Locator alertBox_Text = page.locator("//h2[contains(@class,'alert_message')]");
	private Locator alertBox_Yes_Btn = page.locator("//div[contains(@class,'project_popup_div')]/div[3]/button[2]");

	/*-----------------Reusable Methods-----------------*/

	public void selectDropDownValue(String dropDown, String value) {
		if (dropDown.equals("type")) {
			ticketType_DD.click();
			listBox.waitFor(new WaitForOptions().setState(WaitForSelectorState.VISIBLE));
			int count = typePriority_List.count();

			for (int i = 0; i <= count - 1; i++) {
				if (typePriority_List.nth(i).textContent().trim().equals(value.trim())) {
					typePriority_List.nth(i).click();
					listBox.waitFor(new WaitForOptions().setState(WaitForSelectorState.HIDDEN));
					break;
				}
			}
		} else if (dropDown.equals("priority")) {
			ticketPriority_DD.click();
			listBox.waitFor(new WaitForOptions().setState(WaitForSelectorState.VISIBLE));
			int count = typePriority_List.count();

			for (int i = 0; i <= count - 1; i++) {
				if (typePriority_List.nth(i).textContent().trim().equals(value.trim())) {
					typePriority_List.nth(i).click();
					listBox.waitFor(new WaitForOptions().setState(WaitForSelectorState.HIDDEN));
					break;
				}
			}
		} else if (dropDown.equals("assignee")) {
			assignee_Txtbox.fill(value);
			listBox.waitFor(new WaitForOptions().setState(WaitForSelectorState.VISIBLE));
			int count = assigneeCC_ListText.count();
			for (int i = 0; i <= count - 1; i++) {
				if (assigneeCC_ListText.nth(i).textContent().trim().equals(value.trim())) {
					assigneeCC_ListText.nth(i).click();
					listBox.waitFor(new WaitForOptions().setState(WaitForSelectorState.HIDDEN));
					break;
				}
			}
		} else if (dropDown.equals("cc")) {
			cc_Txtbox.fill(value);
			listBox.waitFor(new WaitForOptions().setState(WaitForSelectorState.VISIBLE));
			int count = assigneeCC_ListText.count();
			for (int i = 0; i <= count - 1; i++) {
				if (assigneeCC_ListText.nth(i).textContent().trim().equals(value.trim())) {
					assigneeCC_ListText.nth(i).click();
					listBox.waitFor(new WaitForOptions().setState(WaitForSelectorState.HIDDEN));
					break;
				}
			}
		} else {
			System.out.println("Wrong dropdown selected..!");
		}
	}

	public void separateTicketForEachAssignee() {
		separateTicketForEachAssignee_Chkbox.check();
	}

	public void anonymouslyClick() {
		anonymously_Chkbox.check();
	}

	public void addTag(String value) {
		tag_Txtbox.fill(value);
	}

	public void addNotes(String value) {
		notesTextArea.fill(value);
	}

	/*-----------------Cases Methods-----------------*/

	public void addTicket(String subject, String type, String priority, String assignee, String cc, String eachAsignee,
			String anonymously, String tag, String notes) {

		addTicket_Btn.click();
		createTicketHeader_Text.waitFor();
		if (createTicketHeader_Text.textContent().trim().equals("Create Ticket")) {
			subject_Txtbox.fill(subject);
			selectDropDownValue("type", type);
			selectDropDownValue("priority", priority);
			selectDropDownValue("assignee", assignee);
			notesTextArea.fill(notes);

			if (!cc.isEmpty()) {
				selectDropDownValue("cc", cc);
			}

			if (!eachAsignee.isEmpty()) {
				separateTicketForEachAssignee();
			}

			if (!anonymously.isEmpty()) {
				anonymouslyClick();
			}

			if (!tag.isEmpty()) {
				addTag(tag);
			}
			save_btn.click();
		}
	}

	public void updateTicket(String subject, String type, String priority, String assignee, String cc) {
		BasePage.hiddenProgressBar();
		String ticketID_Number = null;
		int count = subjectTitle_TextList.count();

		if (count > 0) {
			for (int i = 0; i <= count - 1; i++) {
				if (subjectTitle_TextList.nth(i).textContent().trim().equals(subject.trim())) {
					subjectTitle_TextList.nth(i).scrollIntoViewIfNeeded();
					subjectTitle_TextList.nth(i).click();
					ticketID_Number = ticketIdInList.nth(i).textContent().trim();
					break;
				}
			}
			if (ticketID_Number.equals(ticketIdInDetails.textContent().trim())) {
				ticketEditBtn.click();
				BasePage.spinnerDismiss();
				subject_Txtbox.clear();
				subject_Txtbox.fill(subject + " Update");
				selectDropDownValue("type", type);
				selectDropDownValue("priority", priority);
				selectDropDownValue("assignee", assignee);
				save_btn.click();

			} else {
				System.out.println("Ticket not open!");
			}
		} else {
			updateTicket(subject, type, priority, assignee, cc);
		}
	}

	public void deleteTicket(String subject) {

		BasePage.hiddenProgressBar();
		int count = subjectTitle_TextList.count();
		String ticketID_Number = null;

		if (count > 0) {
			for (int i = 0; i <= count - 1; i++) {
				if (subjectTitle_TextList.nth(i).textContent().trim().equals(subject.trim())) {
					subjectTitle_TextList.nth(i).scrollIntoViewIfNeeded();
					subjectTitle_TextList.nth(i).click();
					ticketID_Number = ticketIdInList.nth(i).textContent().trim();
					String alertTempText = "Are you sure you want to trash ticket " + ticketID_Number + "?";
					updateTicketStatus("Delete");
					alertBox.waitFor();
					assertEquals(alertBox_Text.textContent().trim(), alertTempText);
					alertBox_Yes_Btn.click();
					break;
				}
			} 
		} else {
			deleteTicket(subject);
		}
	}

	public void updateTicketStatus(String value) {
		ticketStatusEdit_Btn.click();
		for (int i = 0; i < ticketStatusList.count(); i++) {
			if (ticketStatusList.nth(i).textContent().trim().equals(value.trim())) {
				ticketStatusList.nth(i).click();
				break;
			}
		}
	}
}