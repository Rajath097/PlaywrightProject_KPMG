package com.kpmg.alerts;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Demo1Alert {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(
				new LaunchOptions().setHeadless(false).setChannel("chrome"));

		BrowserContext context = browser.newContext();
		// tab 1
		Page page = context.newPage();

		page.navigate("https://netbanking.hdfcbank.com/netbanking/IpinResetUsingOTP.htm");
		
		page.onceDialog((dialog)-> {
			String actualAlertMsg = dialog.message();
			System.out.println(actualAlertMsg);
			dialog.accept();
		});	
		
		//click on Go
		page.locator("xpath = //img[@alt='Go']").click();
		
		page.waitForTimeout(5000);
		playwright.close();
		

	}

}

