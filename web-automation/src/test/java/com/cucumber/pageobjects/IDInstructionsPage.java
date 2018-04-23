package com.cucumber.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.cucumber.config.Constant;



public class IDInstructionsPage {
	WebDriver driver;
	
	@FindBy(xpath = Constant.xpath_iDInstructionsPage_mainHeader)
	private WebElement mainHeader;
	
	@FindBy(xpath = Constant.xpath_iDInstructionsPage_subHeader)
	private WebElement subHeader;

	@FindBy(xpath = Constant.xpath_iDInstructionsPage_instruction1)
	private WebElement instruction1;

	@FindBy(xpath = Constant.xpath_iDInstructionsPage_instruction2)
	private WebElement instruction2;

	@FindBy(xpath = Constant.xpath_iDInstructionsPage_instruction3)
	private WebElement instruction3;

	@FindBy(xpath = Constant.xpath_iDInstructionsPage_instruction4)
	private WebElement instruction4;

	@FindBy(xpath = Constant.xpath_iDInstructionsPage_goBackLink)
	private WebElement goBackLink;

	@FindBy(xpath = Constant.xpath_iDInstructionsPage_openCameraButton)
	private WebElement openCameraButton;
	
	public IDInstructionsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void display_passport_intructions_page() {
		
		//SoftAssert softAssertion= new SoftAssert();		
		Assert.assertEquals(mainHeader.getText(), "Take a photo of your passport");
		Assert.assertEquals(subHeader.getText(), "Please ensure:");
		Assert.assertEquals(instruction1.getText(), "the whole document is visible");
		Assert.assertEquals(instruction2.getText(), "you hold the camera straight above the document");
		Assert.assertEquals(instruction3.getText(), "the details are clear and readable");
		Assert.assertEquals(instruction4.getText(), "there are no reflections");
		Assert.assertEquals(goBackLink.getText(), "Go back");
		Assert.assertTrue(goBackLink.isDisplayed());
		Assert.assertTrue(goBackLink.isEnabled());
		Assert.assertEquals(openCameraButton.getText(), "Open camera");
		Assert.assertTrue(openCameraButton.isDisplayed());
	}

	public void display_drivinglicence_intructions_page() {
		
		//SoftAssert softAssertion= new SoftAssert();		
		Assert.assertEquals(mainHeader.getText(), "Take a photo of your driving licence");
		//Assert.assertEquals(subHeader.getText(), "You need to make sure:");
		Assert.assertEquals(instruction1.getText(), "the whole document is visible");
		Assert.assertEquals(instruction2.getText(), "you hold the camera straight above the document");
		Assert.assertEquals(instruction3.getText(), "the details are clear and readable");
		Assert.assertEquals(instruction4.getText(), "there are no reflections");
		Assert.assertEquals(goBackLink.getText(), "Go back");
		Assert.assertTrue(goBackLink.isDisplayed());
		Assert.assertTrue(goBackLink.isEnabled());
		Assert.assertEquals(openCameraButton.getText(), "Open camera");
		Assert.assertTrue(openCameraButton.isDisplayed());
	}
	
	public void goBack_Link() {
		goBackLink.click();
	}
	
	public void openCameraButton() {
		openCameraButton.isDisplayed();
		openCameraButton.click();
		
	}


}
