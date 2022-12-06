package com.FXO_Shiftleft_BDD.automation.stepDefinations;


import com.FXO_Shiftleft_BDD.automation.Factory.playwrightFactory;
import com.FXO_Shiftleft_BDD.automation.Pages.homePage;
import com.FXO_Shiftleft_BDD.automation.Pages.mirkalDesignTemplatesPage;
import com.FXO_Shiftleft_BDD.automation.testBase.BaseClass;
import com.microsoft.playwright.Page;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class pickupFlowSteps extends BaseClass{
	
	
	playwrightFactory pf;
	Page page;
	homePage homepage;
	mirkalDesignTemplatesPage mkd;
	
	
	@Given("launch application nonlogin")
	public void launch_application_nonlogin() {
		
		
		pf=new playwrightFactory();
		page=pf.initBrowser("chrome");
		homepage=new homePage(page);
		String pageTitle=homepage.getHomePageTitile();
		String pageUrl=homepage.getHomePageurl();
		mkd=new mirkalDesignTemplatesPage(page);
		
		
	}

	@When("search product")
	public void search_product() {
		homepage.globalSearch("Flyers");
		System.out.println("Product found in search successfully");
	}

	@And("upload templateFile")
	public void upload_templateFile() throws InterruptedException {
	 homepage.uploadTemplates("Flyers");
	 System.out.println("Product template uploaded successfully");
	}

	@Then("add to cart")
	public void add_to_cart() throws InterruptedException {
		homepage.scrollwindow();
		homepage.addTocart();
		System.out.println("Product added to cart successfully");
	}

	@And("proceed to checkout nonlogin")
	public void proceed_to_checkout_nonlogin() throws InterruptedException {
		homepage.proceedTocheckout();
		System.out.println("Product procceded to checkout");
	}

	@And("select pickup option")
	public void select_pickup_option() throws InterruptedException {
		homepage.selectpickUP();
		System.out.println("Pickup option selected");
	}

	@Then("continue to payment nonlogin")
	public void continue_to_payment_nonlogin() throws InterruptedException {
		homepage.continuePyment();
		System.out.println("Continue to Payment successfully");
	}

	@Then("select CC payment method nonlogin")
	public void select_cc_payment_method_nonlogin() throws InterruptedException {
		homepage.ccPaymentflow();
		System.out.println("Credit Card Selected as Payment");
		
	}

	@And("click revirew order")
	public void click_revirew_order() throws InterruptedException {
		
		homepage.reviewOrder();
		System.out.println("Order reviewed successfully");
	}

	@Then("submit order nonlogin")
	public void submit_order_nonlogin() throws InterruptedException {
		
		homepage.submitOrder();
		System.out.println("Order created successfully");
	    
	}
	@And("close browser")
	public void close_bowser() {
		
		homepage.tearDown();
		System.out.println("Browser closed");
		
	}

}
