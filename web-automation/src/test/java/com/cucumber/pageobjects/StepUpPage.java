package com.cucumber.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cucumber.config.Constant;

public class StepUpPage {
	private static final Object False = null;

	WebDriver driver;
	
	@FindBy(xpath = Constant.xpath_stepUpPage_option1MainHeader)
	private WebElement option1MainHeader;
	
	@FindBy(xpath = Constant.xpath_stepUpPage_option2MainHeader)
	private WebElement option2MainHeader;
	
	@FindBy(xpath = Constant.xpath_stepUpPage_option2SubHeader)
	private WebElement option2SubHeader;
	
	@FindBy(xpath = Constant.xpath_stepUpPage_option3MainHeader)
	private WebElement option3MainHeader;
	
	@FindBy(xpath = Constant.xpath_stepUpPage_option3SubHeader)
	private WebElement option3SubHeader;
	
	@FindBy(xpath = Constant.xpath_stepUpPage_option4MainHeader)
	private WebElement option4MainHeader;
	
	@FindBy(xpath = Constant.xpath_stepUpPage_option4SubHeader)
	private WebElement option4SubHeader;
	
	@FindBy(xpath = Constant.xpath_stepUpPage_option2StartButton)
	private WebElement option2StartButton;
	
	@FindBy(xpath = Constant.xpath_stepUpPage_option3StartButton)
	private WebElement option3StartButton;
	
	@FindBy(xpath = Constant.xpath_stepUpPage_option4StartButton)
	private WebElement option4StartButton;
	
	@FindBy(xpath = Constant.xpath_stepUpPage_option1Completed)
	private WebElement option1Completed;
	
	@FindBy(xpath = Constant.xpath_stepUpPage_option2Completed)
	private WebElement option2Completed;
	
	public StepUpPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void display_step_up_page() throws Throwable{
		
		Assert.assertEquals(driver.getTitle(),"NHS - Citizen ID");
		Thread.sleep(1000);
		
	}
	
	public void verify_create_nhs_account_status() throws Throwable{
		Assert.assertEquals(option1MainHeader.getText(), "Create an NHS account");
		Assert.assertEquals(option1Completed.getText(), "COMPLETED");
		//Assert.assertTrue(Constant.xpath_stepUpPage_option1Completed.equalsIgnoreCase( "COMPLETED"));
	}
	
	public void verify_your_nhs_number_has_clickbale_start_button() throws Throwable{
		Assert.assertEquals(option2MainHeader.getText(),"Your NHS number");
		Assert.assertEquals(option2SubHeader.getText(),"You will need your NHS number so we can get your details.");
		Assert.assertTrue(option2StartButton.isDisplayed());
		Assert.assertTrue(option2StartButton.isEnabled());
	}
	
	public void your_nhs_number_start_button() throws Throwable 
	{
		Assert.assertTrue(option2StartButton.isDisplayed());
		Thread.sleep(1000);
		option2StartButton.click();
	}
	
	public void verify_your_nhs_number_status() throws Throwable{
		//Assert.assertEquals(option2MainHeader.getText(), "Your NHS number");
		Assert.assertEquals(option2Completed.getText(), "COMPLETED");
		//Assert.assertTrue(Constant.xpath_stepUpPage_option1Completed.equalsIgnoreCase( "COMPLETED"));
	}
	
	public void verify_photo_ID_document_details_has_clickbale_start_button() throws Throwable{
		Assert.assertEquals(option3MainHeader.getText(),"Photo ID document");
		Assert.assertEquals(option3SubHeader.getText(),"You will need to take a photo of your passport or driving licence.");
		Assert.assertTrue(option3StartButton.isDisplayed());
		Assert.assertTrue(option3StartButton.isEnabled());
		//option3StartButton.click();
	}
	
	public void photo_id_document_start_button() throws InterruptedException {
		Assert.assertTrue(option3StartButton.isDisplayed());
		Thread.sleep(1000);
		option3StartButton.click();
		Thread.sleep(3000);
	}
	
	public void verify_submit_video_selfie_has_clicakble_start_button() throws Throwable {
		driver.get(Constant.url_nhsStepUpPage);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
		new StepUpPage(driver).your_nhs_number_start_button();
		Thread.sleep(2000);
		new YourNhsNumberPage(driver).user_provides_the_nhs_number_as("1234567890");
		Thread.sleep(1000);
		new YourNhsNumberPage(driver).user_clicks_continue_button();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
		new StepUpPage(driver).photo_id_document_start_button();
		Thread.sleep(2000);
		// new PhotoIDPage(driver).uk_driving_licence_radio_button_selection();
		Thread.sleep(3000);
		new PhotoIDPage(driver).user_clicks_continue_button();
		Thread.sleep(1000);
		new IDInstructionsPage(driver).openCameraButton();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(1000);
		Assert.assertTrue(option4StartButton.isDisplayed());
		Assert.assertTrue(option4StartButton.isEnabled());
	}
	
	public void video_selfie_start_button() throws Throwable {
		verify_submit_video_selfie_has_clicakble_start_button();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		option4StartButton.click();
		Thread.sleep(1000);
	}
	
	public void display_video_selfie_page() {
		Assert.assertTrue(option4StartButton.isDisplayed());
		Assert.assertTrue(option4StartButton.isEnabled());
	}
	
	
	
	
	
	


}
