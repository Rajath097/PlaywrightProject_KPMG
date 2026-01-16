package com.kpmg.assignments;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.ElementHandle.ClickOptions;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class AssignmentDay3_Inmotionhosting {
	
	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false).setChannel("chrome"));

		BrowserContext context = browser.newContext();
		//tab 1
		Page page = context.newPage();
				
		//Navigate to https://secure1.inmotionhosting.com/index/login
		page.navigate("https://secure1.inmotionhosting.com/index/login");
		//Click on visit our support center
		Page newPage = page.waitForPopup(()->{
			page.locator("xpath= //div[@id = 'navbarNavDropdown']//span[.=' Visit Our Support Center']").click();
		});
		//Click on “No Thanks” if any popup
		//Search for “diskspace”  
		newPage.locator("xpath= //input[@title='Search for:']").fill("diskspace");
		newPage.locator("xpath= //button[@type='submit']").click();
		//Get the text “Search Results for: diskspace” and print it
		String headerText = newPage.locator("xpath= //div[@class='content']//h1").innerText();
		System.out.println("Header text displayed: " +"'"+ headerText +"'");
		playwright.close();
	}

}
