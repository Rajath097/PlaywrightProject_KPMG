package com.kpmg.advance;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.FileChooser;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Demo2Upload {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false).setChannel("chrome"));

		BrowserContext context = browser.newContext();
		//tab 1
		Page page = context.newPage();
		
		page.navigate("https://www.ilovepdf.com/pdf_to_word");		
		//We user file chooser when there is no input type as file 
		FileChooser fileChooser = page.waitForFileChooser(()-> {
			page.locator("xpath= //div[@id='uploader']//span[contains(.,'Select PDF file')]").click();

		});		
		
		fileChooser.setFiles(Paths.get("C:\\automation_session\\DemoPdf.pdf"));
		
		page.waitForTimeout(5000);
		playwright.close();

	}

}
