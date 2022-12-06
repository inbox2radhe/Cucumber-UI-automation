package com.FXO_Shiftleft_BDD.automation.Pages;

import java.nio.file.Paths;

import com.FXO_Shiftleft_BDD.automation.testBase.BaseClass;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;

public class mirkalDesignTemplatesPage extends BaseClass{
	
	 
	
	homePage hp;
	private Page page;
	
	//private String mirkalDesignTemp="(//a[contains(text(),'Mirkal Design Templates')])[1]";
	
	private String mirkalDesignTemp="(//a[contains(text(),'Design Templates')])[1]";
	private String searchMirkalProducts="xpath=//input[@type='search']";
	
	private String frameName="//iframe[@class='pC-ENQ lyePVA']";
	private String choseFlyers="(//div[@class='e_NdpQ gwb2Ug _7YslCg'])[5]";
	private String selectProduct="//div[@class='e_NdpQ gwb2Ug _7YslCg']";
	private String createDesignFlyers="//span[text()='Create MirkalProduct']";
	//private String customProd="xpath=//button[@class='_1QoxDw Qkd66A tYI0Vw o4TrkA zKTE_w Qkd66A tYI0Vw lsXp-w cwOZMg zQlusQ uRvRjQ']//span[text()='Create Wedding Invitation (Portrait)']";
	
	public mirkalDesignTemplatesPage(Page page) {
		this.page=page;
		
		
	}
	
	public void selectProduct(String productName) throws InterruptedException {
		
		hp=new homePage(page);
		page.locator(mirkalDesignTemp).click();
		hp.waitThreadLong();

	}
	
	public void searchMirkalproducts(String itemName) throws InterruptedException {
		
		FrameLocator framelocator= page.frameLocator("xpath=//iframe[@class='pC-ENQ lyePVA']").first();
		//framelocator.locator(searchMirkalProducts).click();
		System.out.println("itemName is "+itemName);
		String prodName=itemName.toString();
		framelocator.locator(searchMirkalProducts).fill(prodName);
		System.out.println("Product Name: "+prodName);
		hp.waitThreadshot();
		
		 page.keyboard().press("Backspace");
		 hp.waitThreadshot();
			page.keyboard().press("Tab");
			page.keyboard().press("Tab");
			hp.waitThreadshot();
			page.keyboard().press("Enter");
			hp.waitThreadLong();
			
			
		/*	
	
		if(prodName.equals("productOne")) {
		 	hp.waitThreadshot();
			page.keyboard().press("Enter");
			hp.clickelement(selectProduct);
			hp.uploadTemplates("selectProduct");
			
			
		}
		else if(prodName.equals("productTwo")) {
		 	hp.waitThreadshot();
			page.keyboard().press("Enter");
			hp.clickelement(selectProduct);
			hp.uploadTemplates("selectProduct");
		}
		else if(prodName.equalsIgnoreCase("productThree")) {
			hp.waitThreadshot();
			page.keyboard().press("Enter");
			hp.clickelement(selectProduct);
			hp.uploadTemplates("selectProduct");
		}
		else if(prodName.equals("Flyers")) {
			page.keyboard().press("Backspace");
			page.keyboard().press("Enter");
			hp.waitThreadLong();
			page.keyboard().press("Tab");
			page.keyboard().press("Tab");
			hp.waitThreadshot();
			page.keyboard().press("Enter");
			hp.waitThreadLong();
		}
		else if(prodName.equalsIgnoreCase("Invitations")) {
			 	System.out.println("Printing from invition");
			 page.keyboard().press("Backspace");
				page.keyboard().press("Enter");
				hp.waitThreadLong();
				page.keyboard().press("Tab");
				page.keyboard().press("Tab");
				hp.waitThreadshot();
				page.keyboard().press("Enter");
				hp.waitThreadLong();
		}
		else
		{
		
			System.err.println("Invalid product name");
		}
		
		/*
		switch(itemName.toLowerCase()) {
		
				case "productone":
				 	hp.waitThreadshot();
					page.keyboard().press("Enter");
					hp.clickelement(selectProduct);
					hp.uploadTemplates("selectProduct");
					break;
				case "producttwo":
				 	hp.waitThreadshot();
					page.keyboard().press("Enter");
					hp.clickelement(selectProduct);
					hp.uploadTemplates("selectProduct");
					break;
				case "productthree":
					hp.waitThreadshot();
					page.keyboard().press("Enter");
					hp.clickelement(selectProduct);
					hp.uploadTemplates("selectProduct");
					break;
				case "flyers":
					page.keyboard().press("Backspace");
					page.keyboard().press("Enter");
					hp.waitThreadLong();
					page.keyboard().press("Tab");
					page.keyboard().press("Tab");
					hp.waitThreadshot();
					page.keyboard().press("Enter");
					hp.waitThreadLong();
					break;
				case "invitations":
					 System.out.println("Printing from switch Case");	
					 page.keyboard().press("Backspace");
						page.keyboard().press("Enter");
						hp.waitThreadLong();
						page.keyboard().press("Tab");
						page.keyboard().press("Tab");
						hp.waitThreadshot();
						page.keyboard().press("Enter");
						hp.waitThreadLong();
						break;
				default:
					System.err.println("Invalid product name");
		
		}
		*/
	}
	
	public void uploadTemp() throws InterruptedException {
		FrameLocator framelocator= page.frameLocator("xpath=//iframe[@id='fedex_iframe']").first();
		String path="C:\\Users\\4652497\\git\\nonkeyword_futurereadyframework\\src\\main\\java\\com\\NonKeyword_FutureReadyFramework\\automation\\config\\Flyers.pdf";
		framelocator.locator("xpath=//div[@class='browse-files-btn']").first().setInputFiles(Paths.get(path));
		hp.waitThreadLong();
		page.keyboard().down("ArrowDown");
		page.keyboard().down("ArrowDown");
		page.keyboard().down("ArrowDown");
		page.keyboard().down("ArrowDown");
		System.out.println("Before clicking add to cart button");
		framelocator.locator("xpath=//button//span[text()='Add To Cart']").click();
		System.out.println("Add to cart button clicked");
	}

}
