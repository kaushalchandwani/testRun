package com.cucumber.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cucumber.config.Constant;

public class AccountInfoPage 
{
WebDriver driver;
	
	@FindBy(xpath = Constant.xpath_accountInfoPage_header)
	private WebElement pageHeader;

	@FindBy(xpath = Constant.xpath_accountInfoPage_backToApplicationLink)
	private WebElement backToApplicationLink;
	

	public AccountInfoPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void verify_AccountInfoPage_message() throws Throwable 
	{	
		Assert.assertEquals(pageHeader.getText(),"Your account has been updated.");
		Assert.assertEquals( driver.getTitle(),"Your account has been updated.");
		
	}
	
	public void verify_back_to_application_link() throws Throwable 
	{
		Assert.assertTrue(backToApplicationLink.isDisplayed());
		backToApplicationLink.click();
	}
}
