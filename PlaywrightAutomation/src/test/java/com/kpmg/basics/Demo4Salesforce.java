package com.kpmg.basics;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;

public class Demo4Salesforce {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));

		BrowserContext context = browser.newContext(); // kind of profile in browser
		Page page = context.newPage(); // tab 1
		
		//Navigate onto https://www.salesforce.com/form/signup/freetrial-salesforce-starter/?d=pb
		page.navigate("https://www.salesforce.com/form/signup/freetrial-salesforce-starter/?d=pb");
		//Enter first name as “John”
		page.locator("xpath = //input[@name='UserFirstName']").fill("John");
		//Enter last name as “wick”
		page.locator("xpath = //input[@name='UserLastName']").fill("wick");
		//Select Job title as “IT Manager”
		page.locator("xpath = //input[@name='UserTitle']").fill("IT Manager");
		
		page.locator("xpath = //a[@data-page-cntrl='next']").click();
		//Enter work email as “john@gmail.com”
		
		//Select Employees as “21-100 employees”
		page.locator("xpath = //select[@name='CompanyEmployees']").selectOption(new SelectOption().setLabel("21 - 200 employees"));
		page.getByPlaceholder("Company").fill("KPMG");
		//Select country as “United Kingdom”
		page.locator("xpath = //select[@name='CompanyCountry']").selectOption(new SelectOption().setLabel("United Kingdom"));
		
		page.locator("xpath = //a[@data-page-cntrl='next']").click();

		//Do not fill the phone number. Fill email address only
		page.locator("xpath = //input[@name='UserEmail']").fill("rajathheblikar@kpmg.com");
		//Click on check box
		page.locator("xpath = (//div[@class= 'checkbox-ui'])[2]").click();
		//Click on start my free trial
		page.locator("xpath = //button[.='Start my free trial']").click();
		//Get the error message displayed “Enter a valid phone number”
		String errorMsg = page.locator("xpath= //span[contains(text(), 'valid phone')]").innerText();
		System.out.println("Error Message displayed: " + errorMsg);
		page.waitForTimeout(5000);
		playwright.close();

	}

}
