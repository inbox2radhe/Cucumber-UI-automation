package com.FXO_Shiftleft_BDD.automation.stepDefinations;

import java.util.logging.LogManager;

import com.FXO_Shiftleft_BDD.automation.Factory.playwrightFactory;
import com.FXO_Shiftleft_BDD.automation.Pages.homePage;
import com.FXO_Shiftleft_BDD.automation.Pages.mirkalDesignTemplatesPage;
import com.FXO_Shiftleft_BDD.automation.testBase.BaseClass;
import com.microsoft.playwright.Page;

import io.cucumber.core.logging.Logger;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;

public class mirkalpickupSteps{
	
	playwrightFactory pf;
	Page page;
	homePage homepage;
	mirkalDesignTemplatesPage mkd;

	
	@Given("launch application")
	public void launch_application() {
		pf=new playwrightFactory();
		page=pf.initBrowser("chrome");
		homepage=new homePage(page);
		String pageTitle=homepage.getHomePageTitile();
		String pageUrl=homepage.getHomePageurl();
		mkd=new mirkalDesignTemplatesPage(page);
		
	}

	@When("^click on ThirdPartyApp templates$")
	public void click_on_ThirdPartyApp_templates() throws InterruptedException{

		mkd.selectProduct("ThirdPartyApp item1");
	 
	}

//	@And("select design\\/size of product")
//	public void select_design_size_of_product() throws InterruptedException {
//		mkd.searchMirkalproducts("Flyers");
//	}
	
	
	@And("^select design of product$")
	public void select_design_of_product () throws InterruptedException{
		mkd.searchMirkalproducts("Flyers");
	}
	
	@And("^upload template$")
	public void upload_template() throws InterruptedException {
		mkd.uploadTemp();
	}
	
	@And("^select ThirdPartyApp(.*)$")
	public void select_ThirdPartyApp(String productName) throws InterruptedException {
		
		System.out.println("Product Name is ::"+productName);
		mkd.searchMirkalproducts(productName);
		
	}
	@When("^upload template (.*)$")
	public void upload_template(String tempName) throws InterruptedException {
		System.out.println("tempName"+tempName);
		if(tempName.equals("Invitations")||tempName.equals("Flyers")) {
			System.out.println("Templetes Available");
		}
		else if(tempName.equals("productThree33")){
			System.out.println("Templetes Available");
		}
			
		else {
			homepage.uploadTemplates("ThirdPartyApp item1");
		}
		
	}

	@Then("click add to cart")
	public void click_add_to_cart() {

	}

	@Then("proceed to checkout")
	public void proceed_to_checkout() {
	
	}

	@Then("select pickup")
	public void select_pickup() {

	}

	@Then("continue to payment")
	public void continue_to_payment() {

	}

	@Then("select CC payment method")
	public void select_cc_payment_method() {

	}

	@Then("click review")
	public void click_review() {
	    
	}

	@Then("submit order")
	public void submit_order() {
	    
	}

}
