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

import com.cucumber.config.Constant;
import com.cucumber.utility.MessageBox;

public class PhoneNoPage 
{
	WebDriver driver;
	
	@FindBy(xpath = Constant.xpath_otpPhoneNoPage_phoneNoInputBox)
	private WebElement phoneNoTextBox;
	
	@FindBy(xpath = Constant.xpath_otpPhoneNoPage_pageContent)
	private WebElement pageBanner;

	@FindBy(xpath = Constant.xpath_otpPhoneNoPage_pagelegend)
	private WebElement pageHeader;

	@FindBy(xpath = Constant.xpath_otpPhoneNoPage_submitButtion)
	private WebElement submitButton;
	
			
	public PhoneNoPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	public void verify_phoneno_page() throws Throwable 
	{	
		Assert.assertTrue(pageHeader.isDisplayed());
		Assert.assertTrue(pageBanner.isDisplayed());
		Assert.assertEquals(pageHeader.getText(),"Enter your phone number");
		Assert.assertEquals(pageBanner.getText(),"We'll send you a security code to your mobile. This is to make sure that the mobile number you enter belongs to you.\n\nWe'll send you a code every time you sign in, to make sure its not someone pretending to be you.");
		Assert.assertTrue(phoneNoTextBox.isDisplayed());
		Assert.assertTrue(submitButton.isDisplayed());
		Thread.sleep(1000);
	}	
	
	public void user_provides_phone_no(String phoneno) throws Throwable 
	{	
		Assert.assertTrue(phoneNoTextBox.isDisplayed());
		phoneNoTextBox.clear();
		phoneNoTextBox.sendKeys(phoneno);
		MessageBox.printMessage("Contact number: "+phoneno,3000);
	}

	public void user_submit_phone_no() throws Throwable 
	{
		Assert.assertTrue(submitButton.isDisplayed());
		submitButton.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(1000);
	}
		
	public void invalid_phone_no_error_message() throws Throwable 
	{
		WebElement errorMessage = driver.findElement(By.xpath(Constant.xpath_otpPhoneNoPage_invalidPhoneNoError));
		Assert.assertTrue(errorMessage.isDisplayed());
		Assert.assertEquals(errorMessage.getText(),"Invalid mobile number. Please enter a valid UK mobile number.");
	}
	
	public void valid_phone_no_check()
	{	
		//have to look into it
		WebElement errorMessage = driver.findElement(By.xpath(Constant.xpath_otpPhoneNoPage_invalidPhoneNoError));
		Assert.assertFalse(errorMessage.isDisplayed());

	}
		
}