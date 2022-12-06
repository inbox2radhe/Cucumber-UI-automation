package com.FXO_Shiftleft_BDD.automation.Factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.options.WaitUntilState;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class playwrightFactory {
	
	Playwright playwright;
	Browser browser;
	BrowserContext browserContext;
	Page page;
	
	Properties prop;
	
	public Page initBrowser(String browserName) {
		
				System.out.println("Browser Type:: "+browserName);
				
				playwright=Playwright.create();
				
				switch(browserName.toLowerCase()) {
				
				case "chromium":
					browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
					break;
				case "firefox":
					browser=playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
					break;
				case "safari":
					browser=playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
					break;
				case "msedge":
					browser=playwright.chromium().launch(new LaunchOptions().setChannel("msedge").setHeadless(false));
					break;
				case "chrome":
					browser=playwright.chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false));
					break;	
					
				default:
					System.out.println("[ERROR] Invalid browser name");
					break;
		
		}
		
		browserContext=browser.newContext();
		browserContext.clearCookies();
		page=browserContext.newPage();
		page.navigate("https://staging2.office.fedex.com/",new Page.NavigateOptions()
				  .setWaitUntil(WaitUntilState.NETWORKIDLE));
		return page;
	}
	
	/**
	 * This method is to initialize config files
	 */
	public Properties init_configProp() {
		
		try {
			FileInputStream file=new FileInputStream("./Resources/config.properties");
			prop=new Properties();
			try {
				prop.load(file);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		return prop;
	}
	

}
