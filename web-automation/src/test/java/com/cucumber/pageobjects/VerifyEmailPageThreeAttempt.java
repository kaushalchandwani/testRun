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

public class VerifyEmailPageThreeAttempt 
{
	WebDriver driver;

	@FindBy(xpath = Constant.xpath_validateEmailPage3rdAttempt_messageBanner)
	private WebElement messageBanner3rdAttempt;
	
	@FindBy(xpath = Constant.xpath_validateEmailPage3rdAttempt_messageHeader)
	private WebElement pageHeader3rdAttempt;
	
	@FindBy(xpath = Constant.xpath_validateEmailPage3rdAttempt_loginLink)
	private WebElement loginLink3rdAttempt;
	
	public VerifyEmailPageThreeAttempt(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void verify_Email_3rd_Attempt_Page_Validation() throws Throwable 
	{	
		Assert.assertEquals(pageHeader3rdAttempt.getText(),"This is your 3rd attempt");
		Assert.assertEquals(messageBanner3rdAttempt.getText(),"If you still havent received an email from us please can you email Michael.Tattersall@nhs.net or call 07402 833373.");
		Assert.assertTrue(loginLink3rdAttempt.isDisplayed());
	}
	
	public void user_back_to_signIn_Link_from_3rd_Attempt_Page() throws Throwable
	{
		Assert.assertTrue(loginLink3rdAttempt.isDisplayed());
		loginLink3rdAttempt.click();
	}
	
}
