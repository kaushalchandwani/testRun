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

public class ResetPasswordPage 
{
	WebDriver driver;
	
	@FindBy(xpath = Constant.xpath_resetPasswordPage_label)
	private WebElement pageHeader;

	@FindBy(xpath = Constant.xpath_resetPasswordPage_bannerMessage)
	private WebElement messageBanner;
	
	@FindBy(xpath = Constant.xpath_resetPasswordPage_continueButton)
	private WebElement continueButton;
	
	@FindBy(xpath = Constant.xpath_resetPasswordPage_newPasswordInputBox)
	private WebElement newPasswordTextBox;
	
	@FindBy(xpath = Constant.xpath_resetPasswordPage_retypePasswordInputBox)
	private WebElement retypeNewpasswordTextBox;
	
	@FindBy(xpath = Constant.xpath_resetPasswordPage_contents)
	private WebElement passwordRulesContent;
	
	public ResetPasswordPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void verify_ResetPasswordPage_message() throws Throwable 
	{	
		Assert.assertEquals(pageHeader.getText(),"Reset password");
		Assert.assertEquals( driver.getTitle(),"Reset password");
		Assert.assertEquals( messageBanner.getText(),"You need to change your password.");
		Assert.assertEquals( passwordRulesContent.getText(),"New password\nYour password must have:\nat least 8 characters\nat least one capital letter\nat least one number\nat least one symbol, for example: ?!£%");
		Thread.sleep(1000);
	}
	
	public void user_provides_the_password_as(String password) throws Throwable 
	{	
		newPasswordTextBox.clear();
		newPasswordTextBox.sendKeys(password);
		retypeNewpasswordTextBox.clear();
		retypeNewpasswordTextBox.sendKeys(password);
	}

			
	public void user_click_continue_button() throws Throwable 
	{
		Assert.assertTrue(continueButton.isDisplayed());
		continueButton.click();
	}
	
}
