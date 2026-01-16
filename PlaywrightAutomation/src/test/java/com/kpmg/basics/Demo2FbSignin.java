package com.kpmg.basics;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Demo2FbSignin {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch( new LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		
		page.navigate("https://www.facebook.com/");
		
		page.locator("//input[@id='email']").fill("rajathheblikar@gmail.com");
		page.locator("//input[@placeholder='Password']").fill("Rps@123");
		
		page.locator("xpath=//button[@name='login']").click();
		playwright.close();
	}

}
