package com.kpmg.assignments;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.ElementHandle.ClickOptions;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class AssignmentDay2_Salesforce {
	
	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false).setChannel("chrome"));

		BrowserContext context = browser.newContext();
		//tab 1
		Page page = context.newPage();
				
		//Navigate onto https://www.salesforce.com /in/form/signup/freetrial-sales/
		page.navigate("https://www.salesforce.com /in/form/signup/freetrial-sales/");
		//Enter first name as “John”
		//Enter last name as “wick”
		//Enter work email as “john@gmail.com”
		//Select Job title as “IT Manager”
		//Select Employees as “101-500 employees”
		//Select country as “United Kingdom”
		//Do not fill the phone number
		//Click on check box
		//Click on start my free trial
		//Get the error message displayed “Enter a valid phone number”
		playwright.close();
	}

}
