package com.kpmg.tabs;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;

public class Demo2Tabs {
	
	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false).setChannel("chrome"));

		BrowserContext context = browser.newContext(); 
		Page page = context.newPage(); 

		//Navigate onto https://www.online.citibank.co.in/
		page.navigate("https://www.online.citibank.co.in/");
		//Close if any pop up comes
		page.locator("xpath = //button[@id='onetrust-accept-btn-handler']").click();
		//Hover over My Account
		page.waitForTimeout(2000);
		page.locator("xpath= //div[@id='accountPopup']//preceding-sibling::div").hover();
		page.waitForTimeout(2000);
		//Click on Banking with citi
		page.locator("xpath = //div[.='Banking with Citi']").click();
		//In new tab
		//Enter userid as john123
		page.waitForLoadState();
		page.locator("xpath= //input[@id='username']").fill("john123");
		//Click on signup
		page.locator("xpath= //button[@id='signInBtn']").click();
		//Get the error displayed for the password
		String actualErrorMsg = page.locator("xpath = //div[@id='autoFillBannerAlert']//p").innerText();
		System.out.println("Error Message displayed: "+ actualErrorMsg );
		
		page.waitForTimeout(5000);
		playwright.close();
	}
}
