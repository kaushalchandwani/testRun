package com.cucumber.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import net.sourceforge.htmlunit.corejs.javascript.debug.Debugger;

import com.cucumber.config.Constant;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

public class PatientOnlinePage {
	WebDriver driver;

	@FindBy(xpath = Constant.xpath_yourNhsNumberPage_header)
	private WebElement pageHeader;

	@FindBy(xpath = Constant.xpath_PatientOnlinePage_linkageKeyNoInputBox)
	private WebElement linkageKeyTextBox;

	@FindBy(xpath = Constant.xpath_PatientOnlinePage_odsCodeNoInputBox)
	private WebElement odsCodeTextBox;

	@FindBy(xpath = Constant.xpath_PatientOnlinePage_userIdNoInputBox)
	private WebElement userIDTextBox;

	@FindBy(xpath = Constant.xpath_PatientOnlinePage_continueButton)
	private WebElement continueButton;

	public PatientOnlinePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void verify_linkage_key_page_display() throws Throwable {
		Assert.assertEquals(pageHeader.getText(), "Enter your registration details");

		this.verify_linkageKeyText_UI();
		this.verify_odsCodeText_UI();
		this.verify_userIDKeyText_UI();

		Thread.sleep(1000);
	}

	public void verify_linkageKeyText_UI() throws Throwable {
		WebElement linkageKeyLabel = driver.findElement(By.xpath(Constant.xpath_PatientOnlinePage_linkageKeyLabel));
		WebElement linkageKeyHint = driver.findElement(By.xpath(Constant.xpath_PatientOnlinePage_linkageKeyHint));

		Assert.assertTrue(linkageKeyLabel.isDisplayed() && linkageKeyHint.isDisplayed());
		Assert.assertEquals("Linkage Key / Passphrase", linkageKeyLabel.getText());
		Assert.assertEquals("This must contain 16 characters", linkageKeyHint.getText());
	}

	public void verify_odsCodeText_UI() throws Throwable {
		WebElement odsCodeLabel = driver.findElement(By.xpath(Constant.xpath_PatientOnlinePage_odsCodeLabel));
		WebElement odsCodeHint = driver.findElement(By.xpath(Constant.xpath_PatientOnlinePage_odsCodeHint));

		Assert.assertTrue(odsCodeLabel.isDisplayed() && odsCodeHint.isDisplayed());

		Assert.assertEquals("ODS Code / Organisation ID", odsCodeLabel.getText());
		Assert.assertEquals("This is 1 character and 5 digits - eg E12345", odsCodeHint.getText());
	}

	public void verify_userIDKeyText_UI() throws Throwable {
		WebElement userIDLabel = driver.findElement(By.xpath(Constant.xpath_PatientOnlinePage_userIDLabel));
		WebElement userIDHint = driver.findElement(By.xpath(Constant.xpath_PatientOnlinePage_userIDHint));

		Assert.assertTrue(userIDLabel.isDisplayed() && userIDHint.isDisplayed());
		Assert.assertEquals("Account ID / User ID", userIDLabel.getText());
		Assert.assertEquals("This can be up to 30 characters", userIDHint.getText());
	}

	public void user_provides_input_data(String linkageKey, String odsCode, String userID) throws Throwable {
		linkageKeyTextBox.clear();
		linkageKeyTextBox.sendKeys(linkageKey);
		Thread.sleep(1000);

		odsCodeTextBox.clear();
		odsCodeTextBox.sendKeys(odsCode);
		Thread.sleep(1000);

		userIDTextBox.clear();
		userIDTextBox.sendKeys(userID);
		Thread.sleep(1000);

	}

	public void user_clicks_continue_button() throws Throwable {
		Assert.assertTrue(continueButton.isDisplayed());
		continueButton.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


	}

	public void displayLinkageKeyErrorMessages() throws Throwable {
		if (driver.findElements(By.xpath(Constant.linkageKeyErrorMessage_PatientOnlinePage)).size() > 0) {
			WebElement errorMessage = driver.findElement(By.xpath(Constant.linkageKeyErrorMessage_PatientOnlinePage));
			Assert.assertEquals("Please enter a valid Linkage Key", errorMessage.getText());
		}
	}

	public void displayOdsCodeErrorMessages() throws Throwable {
		if (driver.findElements(By.xpath(Constant.odsCodeErrorMessage_PatientOnlinePage)).size() > 0) {
			WebElement errorMessage = driver.findElement(By.xpath(Constant.odsCodeErrorMessage_PatientOnlinePage));
			Assert.assertEquals("Please enter a valid ODS Code", errorMessage.getText());
		}
	}

	public void displayUserIDErrorMessages() throws Throwable {
		if (driver.findElements(By.xpath(Constant.userIDErrorMessage_PatientOnlinePage)).size() > 0) {
			WebElement errorMessage = driver.findElement(By.xpath(Constant.userIDErrorMessage_PatientOnlinePage));
			Assert.assertEquals("Please enter a valid User ID", errorMessage.getText());
		}
	}

	public void display_nhs_number() throws Throwable {
		Thread.sleep(2000);
		WebElement nhsNumberLabel = driver.findElement(By.xpath(Constant.xpath_PatientOnlinePage_nhsHeader));
		Assert.assertTrue(nhsNumberLabel.isDisplayed());
		assertThat(nhsNumberLabel.getText(), containsString("NHS Number: 943-476-5919"));
		Thread.sleep(1000);
	}

	public void display_patient_online_page() throws Throwable {
		Assert.assertEquals(driver.getTitle(), "NHS - Citizen ID");
		Thread.sleep(1000);
	}

}
