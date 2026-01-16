package com.kpmg.tabs;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class DemoHdfc {
	
	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false).setChannel("chrome"));

		BrowserContext context = browser.newContext();
		//tab 1
		Page page = context.newPage();
		
		page.navigate("https://netbanking.hdfcbank.com/netbanking/");
		
		FrameLocator frameLoginPage = page.frameLocator("//frame[@name='login_page']");
		//enter userid as john123
		frameLoginPage.locator("xpath = //input[@name = 'fldLoginUserId']").fill("john123");
		
		frameLoginPage.locator("//a[.='CONTINUE']").click();
	
		
		
	}

}
