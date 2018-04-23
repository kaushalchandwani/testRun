package com.cucumber.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cucumber.config.Constant;

//import junit.framework.Assert;

public class VideoSelfiePage {
	WebDriver driver;
	
	@FindBy(xpath = Constant.xpath_videoSelfiePage_mainHeader)
	private WebElement mainHeader;
	
	@FindBy(xpath = Constant.xpath_videoSelfiePage_subHeader)
	private WebElement subHeader;
	
	@FindBy(xpath = Constant.xpath_videoSelfiePage_instruction1)
	private WebElement instruction1;
	
	@FindBy(xpath = Constant.xpath_videoSelfiePage_instruction2)
	private WebElement instruction2;
	
	@FindBy(xpath = Constant.xpath_videoSelfiePage_instruction3)
	private WebElement instruction3;
	
	@FindBy(xpath = Constant.xpath_videoSelfiePage_instruction4)
	private WebElement instruction4;
	
	@FindBy(xpath = Constant.xpath_videoSelfiePage_openCameraButton)
	private WebElement openCameraButton;
	
	@FindBy(xpath = Constant.xpath_videoSelfiePage_goBackLink)
	private WebElement goBackLink;
	
	public VideoSelfiePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void verify_take_a_video_selfie_page() {
		Assert.assertEquals(mainHeader.getText(), "Take a video selfie");
		Assert.assertEquals(subHeader.getText(), "Please ensure:");
		Assert.assertEquals(instruction1.getText(), "you use the front-facing camera");
		Assert.assertEquals(instruction2.getText(), "your whole face is visible");
		Assert.assertEquals(instruction3.getText(), "you follow the instructions on screen");
		Assert.assertEquals(instruction4.getText(), "the video is at least 3 seconds long");
		Assert.assertTrue(openCameraButton.isDisplayed());
		Assert.assertTrue(goBackLink.isDisplayed());
	}
	
	public void video_selfie_page_goBack_link() throws InterruptedException {
		goBackLink.click();
		Thread.sleep(1000);
		
	}
	
}
