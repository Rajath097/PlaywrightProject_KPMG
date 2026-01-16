package com.kpmg.basics;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class DemoLaunchBrowser {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch();
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		
		page.navigate("https://www.facebook.com/");
		
		String actualtitle = page.title();
		
		System.out.println(actualtitle);
		page.waitForTimeout(5000);
		
	}

}
