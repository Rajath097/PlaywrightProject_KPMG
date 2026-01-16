package com.kpmg.basics;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;

public class Demo3FBSignUp {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));

		BrowserContext context = browser.newContext(); // kind of profile in browser
		Page page = context.newPage(); // tab 1

		page.navigate("https://www.facebook.com/");
		
		//click on create new account
		page.locator("xpath=//a[.='Create new account']").click();
		//enter firstname as john
		page.locator("xpath=//input[@name='firstname']").fill("john");
		//enter lastname as wick
		page.locator("xpath=//input[@name='lastname']").fill("wick");
		//click on custom radio button
		page.locator("xpath=//label[.='Custom']//input").click();
		//Select Date dropdowns
		page.locator("xpath=//select[@aria-label='Day']").selectOption("13");
		page.getByTitle("Month").selectOption("Feb");
		page.getByTitle("Year").selectOption(new SelectOption().setLabel("2000"));
		
		page.waitForTimeout(5000);
		playwright.close();

	}

}
