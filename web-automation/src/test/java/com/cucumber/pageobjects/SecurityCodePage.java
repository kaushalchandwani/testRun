/**
 * @author Kaushal Chandwani
 *
 */
package com.cucumber.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.cucumber.config.Constant;
import com.cucumber.helper.VerifyOTPCode;
import com.cucumber.utility.MessageBox;

public class SecurityCodePage 
{
	WebDriver driver;
	
	@FindBy(xpath = Constant.xpath_otpCodePage_otpCodeInputBox)
	private WebElement securityCodeTextBox;
	
	@FindBy(xpath = Constant.xpath_otpCodePage_content)
	private WebElement pageBanner;

	@FindBy(xpath = Constant.xpath_otpCodePage_legend)
	private WebElement pageHeader;

	@FindBy(xpath = Constant.xpath_otpCodePage_continueButton)
	private WebElement continueButton;
	
	@FindBy(xpath = Constant.xpath_otpCodePage_resendOtpLink)
	private WebElement resendOtpLink;
	
	@FindBy(xpath = Constant.xpath_otpCodePage_resendOtpMessage)
	private WebElement resendOtpMessage;
	
	public SecurityCodePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	public void verify_security_code_page() throws Throwable 
	{	
		Assert.assertEquals(pageHeader.getText(),"Security code");
		Assert.assertTrue(pageBanner.getText().matches("Enter security code\n\nWe have sent a security code to your phone(.*)"));
		Assert.assertTrue(securityCodeTextBox.isDisplayed());
		Assert.assertTrue(continueButton.isDisplayed());
		Assert.assertTrue(resendOtpLink.isDisplayed());
		Assert.assertEquals(resendOtpMessage.getText(),"Text messages sometimes take a few minutes to arrive. If you do not receive the text message,");
		Thread.sleep(1000);
	}	
	
	public void user_provides_security_code(String phoneno) throws Throwable 
	{	
		Assert.assertTrue(securityCodeTextBox.isDisplayed());
		String securityCode = VerifyOTPCode.fetchOTPcode(phoneno);
		securityCodeTextBox.clear();
		securityCodeTextBox.sendKeys(securityCode);
		Reporter.log( "User enter security code no: "+securityCode , true );

		MessageBox.printMessage("Security Code: "+securityCode,3000);
	}

	public void user_submit_security_code() throws Throwable 
	{
		Assert.assertTrue(continueButton.isDisplayed());
		continueButton.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(1000);
	}
		
	public void invalid_security_code_error_message() throws Throwable 
	{
		WebElement errorMessage_resendMessage = driver.findElement(By.xpath(Constant.xpath_otpCodePage_invalidOtpCodeError_resendMessage));
		Assert.assertTrue(errorMessage_resendMessage.isDisplayed());
		Assert.assertEquals(errorMessage_resendMessage.getText(),"The code entered is not valid. Please try again.");
	}
	
	public void security_code_resend() throws Throwable 
	{
		resendOtpLink.click();
		WebElement errorMessage_resendMessage = driver.findElement(By.xpath(Constant.xpath_otpCodePage_invalidOtpCodeError_resendMessage));
		Assert.assertTrue(errorMessage_resendMessage.isDisplayed());
		Assert.assertEquals( errorMessage_resendMessage.getText(),"Your security code has been resent.");
	}
	
	public void valid_security_code_check()
	{
		//have to look into it
		WebElement errorMessage_resendMessage = driver.findElement(By.xpath(Constant.xpath_otpCodePage_invalidOtpCodeError_resendMessage));
		Assert.assertFalse(errorMessage_resendMessage.isDisplayed());

	}
		
}