/**
 * @author Kaushal Chandwani
 *
 */
package com.cucumber.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cucumber.config.Constant;


public class VerifyEmailPage 
{
	WebDriver driver;
	@FindBy(xpath = Constant.xpath_confirmEmailPage_messageBanner)
	private WebElement messageBanner;
	
	@FindBy(xpath = Constant.xpath_confirmEmailPage_messageHeader)
	private WebElement pageHeader;
	
	@FindBy(xpath = Constant.xpath_confirmEmailPage_resendEmailLink)
	private WebElement resendEmailLink;
	
	@FindBy(xpath = Constant.xpath_confirmEmailPage_loginLink)
	private WebElement loginLink;
	
		
	public VerifyEmailPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	public void verify_Email_Page_Validation() throws Throwable 
	{	
		Assert.assertEquals(pageHeader.getText(),"Validate your email");
		Assert.assertEquals(messageBanner.getText(),"You need to validate your email address before you can log in. Please check your email.");
		Assert.assertTrue(resendEmailLink.isDisplayed());
		Assert.assertTrue(loginLink.isDisplayed());

	}
	

	
	public void user_back_to_signIn_Link_from_verify_page() throws Throwable
	{
		Assert.assertTrue(loginLink.isDisplayed());
		loginLink.click();
	}
	
	
}


