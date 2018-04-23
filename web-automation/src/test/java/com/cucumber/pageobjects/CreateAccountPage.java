/**
 * @author Kaushal Chandwani
 *
 */
package com.cucumber.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.cucumber.config.Constant;
import com.cucumber.utility.MessageBox;

public class CreateAccountPage 
{
	WebDriver driver;
	SoftAssert softAssert = new SoftAssert();
	@FindBy(xpath = Constant.xpath_registerPage_EmailInputBox)
	private WebElement emailTextBox;

	@FindBy(xpath = Constant.xpath_registerPage_PasswordInputBox)
	private WebElement passwordTextBox;

	@FindBy(xpath = Constant.xpath_registerPage_confirmPasswordInputBox)
	private WebElement confirmPasswordTextBox;
	
	@FindBy(xpath = Constant.xpath_registerPage_registerButton)
	private WebElement registerButton;
	
	@FindBy(xpath = Constant.xpath_registerPage_backToSignInLink)
	private WebElement backToSignInLink;
	
	@FindBy(xpath = Constant.xpath_registerPage_passwordRules)
	private WebElement passwordRules;
	
	public CreateAccountPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void user_provides_the_email_as(String email) throws Throwable 
	{	
	    emailTextBox.sendKeys(email);
	}

	public void user_provides_the_password_as(String password) throws Throwable 
	{
	    passwordTextBox.sendKeys(password);
	}

	public void user_provides_the_confirm_password_again_as(String confirmPassword) throws Throwable 
	{
	    confirmPasswordTextBox.sendKeys(confirmPassword);
	}

	public void user_register() throws Throwable 
	{
		Assert.assertTrue(registerButton.isDisplayed());
		registerButton.click();
	}
	
	public void user_back_to_signIn_Link() throws Throwable
	{
		Assert.assertTrue(backToSignInLink.isDisplayed());
		backToSignInLink.click();
	}
	
	public void create_nhs_account_page_validation() throws Throwable 
	{	
		Assert.assertEquals(driver.getTitle(),"Create an NHS account");
		//softAssert.assertTrue(passwordRules.isDisplayed());
		Assert.assertEquals(passwordRules.getText(),"at least 8 characters\nat least one capital letter\nat least one number\nat least one symbol, for example: ?!£%");
		MessageBox.printMessage("Password Rules Message :- \nYour password must have: \n"+ passwordRules.getText(),3000);

	}
	
}
