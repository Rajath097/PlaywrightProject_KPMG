package com.kpmg.assignments;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.ElementHandle.ClickOptions;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class AssignmentDay2_Medibuddy {
	
	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false).setChannel("chrome"));

		BrowserContext context = browser.newContext();
		//tab 1
		Page page = context.newPage();
				
		//Navigate onto https://www.medibuddy.in/
		page.navigate("https://www.medibuddy.in");
		//Close if any popup and Click on Login
		page.locator("xpath = //a[.='Login']").click();
		//Click on I have Corporate Account
		page.locator("xpath = //div[.='I have a Corporate Account']").click();
		//Click on Learn More
		page.locator("xpath = //a[.='Learn More']").click();
		//Click on Skip
		page.locator("xpath = //a[.='skip']").click();
		//Click on Login using Username & Password
		page.locator("xpath = //a[.='Login using Username & Password']").click();
		//Enter username as john
		page.locator("xpath = //input[@aria-label='Enter Registered Email ID / Username']").fill("john");
		page.locator("xpath = //button[.='Proceed']").click();
		//Enter password as john123
		page.locator("xpath = //input[@id='password']").fill("john123");
		//Click on show password
		page.locator("xpath = //input[@id='password']/..//img").click();
		//Click log in
		page.locator("xpath = //button[.='Sign In']").click();
		//Get the error message shown and print it in the terminal
		String actualErrorMsg = page.locator("xpath = //div[contains(@class, 'errorTxt')]").innerText();
		System.out.println("Error Message displayed: " + actualErrorMsg );
		playwright.close();
	}

}
