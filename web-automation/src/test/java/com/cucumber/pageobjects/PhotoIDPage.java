package com.cucumber.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cucumber.config.Constant;

public class PhotoIDPage {
	WebDriver driver;
		
		@FindBy(xpath = Constant.xpath_photoIDDocumentPage_header)
		private WebElement pageHeader;
		
		@FindBy(xpath = Constant.xpath_photoIDDocumentPage_passport_radiobutton)
		private WebElement radio1;
		
		@FindBy(xpath = Constant.xpath_photoIDDocumentPage_drivinglicence_radiobutton)
		private WebElement radio2;
		
		@FindBy(xpath = Constant.xpath_photoIDDocumentPage_neitherofthese_radiobutton)
		private WebElement radio3;
		
		@FindBy(xpath = Constant.xpath_photoIDDocumentPage_continueButton)
		private WebElement continueButton;
		
		@FindBy(xpath = Constant.xpath_photoIDDocumentPage_goBackLink)
		private WebElement link;
		
		public PhotoIDPage(WebDriver driver)
		{
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		public void verify_photo_id_document_page() throws Throwable 
		{	
			Assert.assertEquals(pageHeader.getText(),"What type of Photo ID do you have?");
			Assert.assertEquals(radio1.getText(), "UK Passport");
			Assert.assertEquals(radio2.getText(), "UK Driving Licence");
			Assert.assertEquals(radio3.getText(), "Neither of these");
			Assert.assertEquals(continueButton.getText(), "Continue");
			Assert.assertTrue(continueButton.isDisplayed());
			Assert.assertEquals(link.getText(),"Go back");
			
		}
		
		
		
		public void user_clicks_continue_button() throws Throwable 
		{
			Assert.assertTrue(continueButton.isDisplayed());
			continueButton.click();
		}
		
		public void back_link() throws Throwable 
		{
			Assert.assertTrue(link.isDisplayed());
			link.click();
		}
		
		


	}

	
