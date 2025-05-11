package com.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.WaitForSelectorState;
import com.utilities.WebDriverManager;

public class BasePage extends WebDriverManager {
	private static Locator snackBar = page.locator("//simple-snack-bar[contains(@class,\"mat-mdc-simple-snack-bar\")]/div");
	private static Locator toastMessage = page.locator("//div[@id='toast-container']/div/div");
	private static Locator progressBar = page.locator("//mat-progress-bar[@role='progressbar']");
	private static Locator spinner = page.locator("//div[contains(@class,'tbl_spinner')]");
	
	public static String snackBarVisible() {
		return snackBar.textContent().trim();
	}

	public static void snackBarInVisible() {
		if (snackBar.isVisible()) {
			snackBarInVisible();
		}
	}

	public static String getToastMessage() {
		if (!toastMessage.isVisible()) {
			getToastMessage();
		}
		return toastMessage.textContent().trim();
	}

	public static void hiddenToastMessage() {
		if (toastMessage.isVisible()) {
			hiddenToastMessage();
		}
	}
	
	public static void hiddenProgressBar() {
		if (progressBar.isVisible()) {
			hiddenProgressBar();
		}
	}
	
	public static void searchValueWait(Locator locator) {
		locator.waitFor(new Locator.WaitForOptions()
			    .setState(WaitForSelectorState.VISIBLE)
			    .setTimeout(5000));
	}
	
	public static void spinnerDismiss() {
		if (spinner.isVisible()) {
			spinnerDismiss();
		}
	}
	
}
