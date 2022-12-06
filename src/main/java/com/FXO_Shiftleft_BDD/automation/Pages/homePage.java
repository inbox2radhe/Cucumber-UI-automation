package com.FXO_Shiftleft_BDD.automation.Pages;

import java.nio.file.Paths;

import com.FXO_Shiftleft_BDD.automation.objectRepository.objRepo;
import com.FXO_Shiftleft_BDD.automation.testBase.BaseClass;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.SelectOption;



public class homePage extends BaseClass{
	
	
	private Page page;
	
	 
	//2. Create page constructor
	
	public homePage(Page page) {
		this.page=page;
		
	}
	
	objRepo or=new objRepo(page);
	
	public void POD2_Login(String id, String pwd) {
		
		clickelement(or.login_lnk);
		clickelement(or.login_btn);
		clickelement(or.userID);
		clickelement(or.userPWD);
		clickelement(or.loginSubmit_btn);
		
	}
	
	public String getHomePageTitile() {
		String pageTitle= page.title();
		System.out.println("Current Page Titile is :"+pageTitle);
		return pageTitle;
		
	}
	
	public String getHomePageurl() {
		String pageUrl=page.url();
		System.out.println("Page Url is "+pageUrl);
		return pageUrl;
	}
	
	public void globalSearch(String productName) {
		
		System.out.println("Product Name to search "+productName);
		page.fill(or.search, productName);
		page.click(or.searchIcon);
		clickelement(or.selectFlyer);
		//return page.textContent(searchpagetitle);
		
		
	}
	
	public void clickelement(String webelementName) {
		String webEleName=null;
		
			
			
					PlaywrightAssertions.assertThat(page.locator(webelementName)).isEnabled();
					webEleName=page.locator(webelementName).textContent();
					page.click(webelementName);
			
		
	}
	
	public void inputtext(String webelementName, String textValue ) {
		String webEleName=null;
		try {
			webEleName=page.locator(webelementName).textContent();
			page.isEnabled(webelementName);	
			page.fill(webelementName, textValue);
		}catch(Exception e) {
			System.err.println("Element not available to enter text"+webEleName);
		}
		
	}
	
	public void waitThreadLong() throws InterruptedException {
		Thread.sleep(10000);
	}
	
	public void waitThreadshot() throws InterruptedException {
		Thread.sleep(5000);
	}
	public void scrollwindow() {
		page.keyboard().down("ArrowDown");
		page.keyboard().down("ArrowDown");
		page.keyboard().down("ArrowDown");
		page.keyboard().down("ArrowDown");
	}
	
	
	public void uploadTemplates(String productName) throws InterruptedException {
		
		try {
			clickelement(or.upload_btn);
			waitThreadLong();
		}catch(Exception e)
		{
			System.err.println("Upload button not actionable");
		}
		switch(productName) {
		case "Flyers":or.framelocator= page.frameLocator("xpath=//iframe[@id='fedex_iframe']").first();
		String path="C:\\Users\\4652497\\git\\MergeCodeLocal\\FXO_Shiftleft_BDD_Framework_V001\\src\\main\\java\\com\\FXO_Shiftleft_BDD\\automation\\config\\Flyers.pdf";
		or.framelocator.locator("xpath=//div[@class='browse-files-btn']").first().setInputFiles(Paths.get(path));
		waitThreadLong();
		break;
		
		}
		
		
	}
	
	public void addTocart() throws InterruptedException {
		
		try {
			or.framelocator.locator(or.addTocart_btn).isEnabled();	
			or.framelocator.locator(or.addTocart_btn).click();
			waitThreadLong();
		System.out.println("Add to cart button clicked");
		}catch(Exception e) {
			System.err.println("Add to cart button not available");
		}
	}
	
	public void proceedTocheckout() throws InterruptedException {
		
		
		scrollwindow();
		System.out.println("Before proceed to checkout");
		waitThreadshot();
		clickelement(or.goTochkout_btn);
		System.out.println("Checkout button Clicked");
		clickelement(or.continueguest_btn);
		System.out.println("Continue as Guest clicked");
		
		
	}
	
	
	public void selectpickUP() throws InterruptedException {
		
		clickelement(or.pickUpStore_btn);
		System.out.println("Pickup at Store selected");
		inputtext(or.zipcode,"75024");
		page.keyboard().press("Enter");
		waitThreadshot();
		waitThreadshot();
		scrollwindow();
		clickelement(or.pickUPlocation_radiobtn);
		System.out.println("Pickup location selected");
		waitThreadLong();
		scrollwindow();
		
		inputtext(or.pickup_fname,"Radhe");
		inputtext(or.pickup_lname,"Singh");
		inputtext(or.pickup_contNum,"214-988-9876");
		inputtext(or.pickup_email,"radhe.singh.osv@fedex.com");
		waitThreadLong();
	}
	
	public void continuePyment() throws InterruptedException {
		
		System.out.println("Before clicking continue to payment button");
		clickelement(or.contPayment_btn);
		System.out.println("Continue to payment button clicked");
		waitThreadshot();
	}
	
	public void ccPaymentflow() throws InterruptedException	{
		
		clickelement(or.selectCC_btn);
		inputtext(or.cc_contactName,"Radhe Singh");
		inputtext(or.cc_Num,"4111111111111111");
		waitThreadshot();
		select_dropDown("5 - May");
		select_dropDown("2026");
		select_dropDown("TX");
		inputtext(or.cvv,"111");
		inputtext(or.compny_name,"FedEx");
		inputtext(or.addressOne,"7900 Legacy Dr");
		inputtext(or.cityName,"Plano");
		inputtext(or.cc_zipcode,"75024");
		waitThreadLong();
		  
		
	}
	
	public void select_dropDown(String drpDownValue) {
		
				if(drpDownValue.equals("5 - May")) {
					Locator selectmonth=page.locator("xpath=//select[@id='expiration-month']");
					selectmonth.selectOption(new SelectOption().setLabel("5 - May"));
				}
				else if(drpDownValue.equals("2026")){
					Locator selectyear=page.locator("xpath=//select[@id='expiration-year']");
					selectyear.selectOption(new SelectOption().setLabel("2026"));
				}
				
				else if(drpDownValue.equals("TX")){
					Locator selectState=page.locator("xpath=//select[@id='add-state']");
					selectState.selectOption("TX");
					
				}
				else
				{
					System.out.println("==Incorrect value provided==");
				}
			
		
	}
	
	public void reviewOrder() throws InterruptedException {
		clickelement(or.reviewOrder_btn);
		waitThreadLong();
	}
	
	public void submitOrder() throws InterruptedException {
		clickelement(or.termsCondition_chkBox);
		waitThreadshot();
		clickelement(or.submitOrder_btn);
		waitThreadLong();
		waitThreadLong();
		
	}
	
	public void tearDown() {
		
		page.close();
		
	}
}
