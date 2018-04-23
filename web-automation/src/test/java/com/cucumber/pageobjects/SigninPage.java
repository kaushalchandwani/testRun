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

public class SigninPage 
{
	WebDriver driver;
	
	@FindBy(xpath = Constant.xpath_loginPage_header)
	private WebElement pageHeader;
	
	@FindBy(xpath = Constant.xpath_loginPage_EmailInputBox)
	private WebElement emailTextBox;

	@FindBy(xpath = Constant.xpath_loginPage_PasswordInputBox)
	private WebElement passwordTextBox;

	@FindBy(xpath = Constant.xpath_loginPage_loginButton)
	private WebElement signinButton;
	
	@FindBy(xpath = Constant.xpath_loginPage_registerLink)
	private WebElement registerNewUser;
	
	@FindBy(xpath = Constant.xpath_loginPage_forgotPasswordLink)
	private WebElement forgotPasswordLink;
	
	@FindBy(xpath = Constant.xpath_loginPage_emailVerificationBanner)
	private WebElement messageBanner;
	
	
	public SigninPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void verify_email_address_message() throws Throwable 
	{	
		Assert.assertEquals(pageHeader.getText(),"Sign in to your NHS Account");
		Assert.assertEquals(driver.getTitle(),"Sign in to your NHS Account");
		Assert.assertEquals( messageBanner.getText(),"Your email address has been verified.");
		Thread.sleep(1000);
	}
	
	public void successful_password_reset_message() throws Throwable 
	{	
		Assert.assertEquals(pageHeader.getText(),"Sign in to your NHS Account");
		Assert.assertEquals(driver.getTitle(),"Sign in to your NHS Account");
		Assert.assertEquals( messageBanner.getText(),"Password Reset Successfully");
		Thread.sleep(1000);
	}
	
	public void user_provides_the_email_as(String email) throws Throwable 
	{	
		emailTextBox.clear();
	    emailTextBox.sendKeys(email);
	}

	public void user_provides_the_password_as(String password) throws Throwable 
	{
		passwordTextBox.clear();
	    passwordTextBox.sendKeys(password);
	}

	
	public void user_forgotPassword() throws Throwable 
	{
		Assert.assertTrue(forgotPasswordLink.isDisplayed());
		forgotPasswordLink.click();
	}
	
	public void user_create_nhs_account() throws Throwable 
	{
		Assert.assertTrue(registerNewUser.isDisplayed());
		registerNewUser.click();
	}
	
	public void user_signin() throws Throwable 
	{
		Assert.assertTrue(signinButton.isDisplayed());
		signinButton.click();
	}
	
	
}
