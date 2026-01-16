package com.kpmg.assignments;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.ElementHandle.ClickOptions;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class AssignmentDay3_Openemr {
	
	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false).setChannel("chrome"));

		BrowserContext context = browser.newContext();
		//tab 1
		Page page = context.newPage();
				
		//Navigate to https://secure1.inmotionhosting.com/index/login
		page.navigate("https://secure1.inmotionhosting.com/index/login");
		

		playwright.close();
	}

}