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

public class UserAccountPage 
{
	WebDriver driver;
	
	@FindBy(xpath = Constant.xpath_dashboardPage_logoutLink)
	private WebElement logoutLink;
	
	@FindBy(xpath = Constant.xpath_dashboardPage_messageBanner)
	private WebElement pageBanner;

	@FindBy(xpath = Constant.xpath_dashboardPage_userEmailId)
	private WebElement userEmailId;

	@FindBy(xpath = Constant.xpath_loginPage_logOutBanner)
	private WebElement logoutMessage;
	
			
	public UserAccountPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void verify_user_account_page() throws Throwable 
	{	
		Assert.assertEquals(pageBanner.getText(),"Welcome to your NHS");
		Assert.assertTrue(userEmailId.isDisplayed());
		Assert.assertTrue(logoutLink.isDisplayed());
	}
	
	public void user_logout() throws Throwable 
	{	
		Assert.assertTrue(logoutLink.isDisplayed());
		logoutLink.click();
		Assert.assertEquals(logoutMessage.getText(),"You have been logged out.");
	    Assert.assertEquals(driver.getTitle(),"Sign in to your NHS Account");
		Thread.sleep(1000);
	}
	
}