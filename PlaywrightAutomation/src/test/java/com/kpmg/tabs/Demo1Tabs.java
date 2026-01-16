package com.kpmg.tabs;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;

public class Demo1Tabs {
	
	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false).setChannel("chrome"));

		BrowserContext context = browser.newContext(); 
		Page page = context.newPage(); 

		page.navigate("https://www.db4free.net/");
		
		//click on phpMyAdmin »
		Page newPage = page.waitForPopup(()-> {
			page.locator("xpath= //b[contains(text(), 'phpMyAdmin')]").click();
		});
	
		newPage.locator("xpath = //input[@id='input_username']").fill("Admin");
		newPage.locator("xpath = //input[@id='input_password']").fill("Admin123");
		newPage.locator("xpath = //input[@id='input_go']").click();
		String errorMsg = newPage.locator("xpath = //div[@id='pma_errors']//div[@class='alert alert-danger']").innerText();
		
		System.out.println("Error message displayed is: " + errorMsg);
		
		page.waitForTimeout(5000);
		playwright.close();
	}
}
