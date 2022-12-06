package com.FXO_Shiftleft_BDD.automation.stepDefinations;

import com.FXO_Shiftleft_BDD.automation.Factory.playwrightFactory;
import com.FXO_Shiftleft_BDD.automation.Pages.homePage;
import com.microsoft.playwright.Page;

import io.cucumber.java.en.*;

public class loginSteps {
	
	playwrightFactory pf;
	Page page;
	homePage homepage;
	
	@Given("User launched application url and clicked on login link")
	public void user_launched_application_url_and_clicked_on_login_link() {
		
		pf=new playwrightFactory();
		page=pf.initBrowser("chrome");
		homepage=new homePage(page);
		String pageTitle=homepage.getHomePageTitile();
		String pageUrl=homepage.getHomePageurl();
		//String searchResult=homepage.globalSearch("Flyers");
		
		
	 System.out.println("Application launched successfully");
	 System.out.println("Application page Title "+pageTitle);
	 System.out.println("Application page Url "+pageUrl);
	 //System.out.println("Application search Result"+searchResult);
	 
	}

	@When("User enters login and password")
	public void user_enters_login_and_password() {
		System.out.println("ID & PWD Entred");
	}

	@And("clicks on login button")
	public void clicks_on_login_button() {
		System.out.println("Login button clicked");
	}

	@Then("User navigated to the application home page")
	public void user_navigated_to_the_application_home_page() {
		System.out.println("User loggedin Successfully");
	   
	}
	

}
