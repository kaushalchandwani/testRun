package com.cucumber.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cucumber.config.Constant;

public class YourNhsNumberPage {
WebDriver driver;
	
	@FindBy(xpath = Constant.xpath_yourNhsNumberPage_header)
	private WebElement pageHeader;
	
	@FindBy(xpath = Constant.xpath_yourNhsNumberPage_nhsNoInputBox)
	private WebElement nhsTextBox;
	
	@FindBy(xpath = Constant.xpath_yourNhsNumberPage_continueButton)
	private WebElement continueButton;
	
	@FindBy(xpath = Constant.xpath_yourNhsNumberPage_dontKnowNhsNumberLink)
	private WebElement link;
	
	@FindBy(xpath = Constant.xpath_yourNhsNumberPage_validNhsNumberRules)
	private WebElement validMessageBanner;
	
	public YourNhsNumberPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void verify_your_nhs_number_page() throws Throwable 
	{	
		Assert.assertEquals(pageHeader.getText(),"Your NHS number");
		Thread.sleep(1000);
	}
	
	public void verify_textBox_displayed() throws Throwable
	{
		nhsTextBox.isDisplayed();
		Assert.assertEquals( validMessageBanner.getText(),"NHS numbers are 10 digits long, for example 943 476 5919.\nYou can find it on prescriptions or doctor/hospital letters.");
	}
	public void user_provides_the_nhs_number_as(String nhsNumber) throws Throwable 
	{
		nhsTextBox.clear();
		nhsTextBox.sendKeys(nhsNumber);
	}
	
	public void user_clicks_continue_button() throws Throwable 
	{
		Assert.assertTrue(continueButton.isDisplayed());
		continueButton.click();
	}
	
	public void user_dont_know_nhs_number_link() throws Throwable 
	{
		Assert.assertTrue(link.isDisplayed());
		link.click();
	}
	
	public void invalid_nhs_no_error_message() throws Throwable 
	{
		WebElement errorMessage = driver.findElement(By.xpath(Constant.invalid_nhs_no_error_message));
		Assert.assertTrue(errorMessage.isDisplayed());
		Assert.assertEquals("Please enter a valid NHS number", errorMessage.getText());
	}
	


}
