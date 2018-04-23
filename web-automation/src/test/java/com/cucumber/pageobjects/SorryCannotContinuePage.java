package com.cucumber.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cucumber.config.Constant;

public class SorryCannotContinuePage {
	
	WebDriver driver;
	
	@FindBy(xpath = Constant.xpath_sorryCannotContinuePage_MainHeader)
	private WebElement pageHeader;
	
	@FindBy(xpath = Constant.xpath_sorryCannotContinuePage_Content)
	private WebElement content;
	
	@FindBy(xpath = Constant.xpath_sorryCannotContinuePage_goBackLink)
	private WebElement goBackLink;
	
	public SorryCannotContinuePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void display_sorry_you_cannot_continue_page() throws Throwable 
	{	
		Assert.assertEquals(pageHeader.getText(),"Sorry you cannot continue");
		Assert.assertEquals(content.getText(),"You don't have the correct information to continue using this service.");
		Assert.assertEquals(goBackLink.getText(),"Go back");
		Assert.assertTrue(goBackLink.isDisplayed());
		Thread.sleep(1000);
	}
	
	public void verify_go_back_link() throws Throwable
	{
		Assert.assertTrue(goBackLink.isDisplayed());
		goBackLink.click();
	}
	
	
	}
