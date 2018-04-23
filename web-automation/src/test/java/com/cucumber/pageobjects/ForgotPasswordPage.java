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

public class ForgotPasswordPage 
{
	WebDriver driver;
	@FindBy(xpath = Constant.xpath_forgotPasswordPage_emailIdInputBox)
	private WebElement emailTextBox;

	@FindBy(xpath = Constant.xpath_forgotPasswordPage_header)
	private WebElement pageHeader;

	@FindBy(xpath = Constant.xpath_forgotPasswordPage_banner)
	private WebElement messageBanner;
	
	@FindBy(xpath = Constant.xpath_forgotPasswordPage_submitButton)
	private WebElement submitButton;
	
	@FindBy(xpath = Constant.xpath_forgotPasswordPage_backToSigninLink)
	private WebElement backToSignInLink;
	

	
	public ForgotPasswordPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void verify_ForgotPasswordPage_message() throws Throwable 
	{	
		Assert.assertEquals(pageHeader.getText(),"Please specify your email address");
		Assert.assertEquals( driver.getTitle(),"Please specify your email address");
		Assert.assertEquals( messageBanner.getText(),"We will send you instructions on how to reset your password");
		Thread.sleep(1000);
	}
	
	public void user_provides_the_email_as(String email) throws Throwable 
	{	
		emailTextBox.clear();
	    emailTextBox.sendKeys(email);
	}

			
	public void user_click_submit_button() throws Throwable 
	{
		Assert.assertTrue(submitButton.isDisplayed());
		submitButton.click();
	}
	
	
	public void user_back_to_signIn_Link() throws Throwable
	{
		Assert.assertTrue(backToSignInLink.isDisplayed());
		backToSignInLink.click();
	}
	
}
