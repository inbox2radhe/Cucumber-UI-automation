package com.FXO_Shiftleft_BDD.automation.objectRepository;

import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;




public class objRepo {
	
	public Page page;
	
	
	public objRepo(Page page) {
		this.page=page;
		
	}

	//1. String locator- Object Repository
	
	public String search="input[name='q']";
	public String searchIcon="button.action.search.p-0";
	public String searchpagetitle="li.item.search";
	public String login_lnk="div.customer-name";
	public String login_btn="(//a[@class='btn-popup-login'])[2]";
	public String userID="input[id='userId']";
	public String userPWD="input[id='password']";
	public String loginSubmit_btn="button[id='login-btn']";
	
	//Select product after search
	public String selectFlyer="xpath=(//a[contains(text(),'Flyers')])[3]";
	
	//upload button
	public String upload_btn="xpath=//button[@id='upload-a-file-button']";
	
	//Switch Frame
	public FrameLocator framelocator;
	
	public String addTocart_btn="xpath=//button//span[text()='Add To Cart']";
	public String goTochkout_btn="xpath=(//button[@title='Go To Checkout'])[1]";
	public String continueguest_btn="xpath=//a[text()='Continue As A Guest']";
	public String pickUpStore_btn="xpath=//button[text()='PICK UP AT STORE']";
	public String zipcode="xpath=//input[@id='zipcodePickup']";
	public String pickUPlocation_radiobtn="xpath=(//div[@class='pickup-location-container']//span[@class='radio-label'])[9]";
	
	//pickup person contact details
	public String pickup_fname="xpath=//input[@id='contact-fname']";
	public String pickup_lname="xpath=//input[@id='contact-lname']";
	public String pickup_contNum="xpath=//input[@id='contact-number']";
	public String pickup_email="xpath=//input[@id='contact-email']";
	
	//continue payment
	public String contPayment_btn="xpath=//button[@class='place-pickup-order']//span[text()='CONTINUE TO PAYMENT']";
	public String selectCC_btn="xpath=//div[@class='select-credit-card pointer']//p[contains(text(),'Credit card')]";
	
	public String cc_contactName="xpath=//input[@id='name-card']";
	public String cc_Num="xpath=//input[@id='card-number']";
	public String cc_expMM="xpath=//select[@id='expiration-month']";
	public String cc_expYY="xpath=//select[@id='expiration-year']";
	public String cvv="xpath=//input[@id='cvv-number']";
	public String compny_name="xpath=//input[@id='company-name']";
	public String addressOne="xpath=//input[@id='address-one']";
	public String cityName="xpath=//input[@id='add-city']";
	public String cc_zipcode="xpath=//input[@id='add-zip']";
	public String reviewOrder_btn="xpath=(//button[text()='REVIEW ORDER'])[1]";
	public String termsCondition_chkBox="xpath=//input[@class='required-entry agreement_enable']";
	public String submitOrder_btn="xpath=//button[@id='place-order-trigger']";
	
	
	
	
	
	

}
