package com.cucumber.stepdefinitions;

import com.cucumber.pageobjects.PatientOnlinePage;
import com.cucumber.config.Constant;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Parameters;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PatientOnlineSmokeTest {
	public WebDriver driver;
/*
	@Before
	public void before() {
		System.out.println("\nOpening webdriver \n");

		System.setProperty("webdriver.chrome.driver", "exe/chromedriver.exe"); //chromedriver.exe set property path
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
		driver.get(Constant.urlPatientOnlinePage);
	}

	@After
	public void after() {
		System.out.println("\nClosing webdriver......");
		driver.get("about:config");
		//driver.quit();
		driver.close();
	}
	*/
	
	@Before
	@Parameters("browser")
	public void beforeScenario() throws Exception 
	{
	 driver = new DriverFactory().getDriver();
	 System.out.println("Openning a new web-browser and session.");
	}
	
	@After
	public void afterScenario() throws Exception 
	{
	new DriverFactory().destroyDriver();
	System.out.println("Closing the web-browser and session ");
	}
	

	// valid entries Scenario
	@Given("^the user is on the patient online Page$")
	public void the_user_is_on_the_patient_online_Page() throws Throwable {
		driver.get(Constant.urlPatientOnlinePage);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		Thread.sleep(1000);
	}

	// valid entries Scenario
	@When("^user enters \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" valid entries in the text boxes provided$")
	public void user_enters_valid_entries_in_the_text_boxes_provided(String linkageKey, String odsCode, String userID)
			throws Throwable {
		new PatientOnlinePage(driver).user_provides_input_data(linkageKey, odsCode, userID);
		Thread.sleep(10000);
	}

	@Then("^navigate to the nhs-number page display page$")
	public void navigate_to_the_nhs_number_page_display_page() throws Throwable {
		new PatientOnlinePage(driver).display_nhs_number();
		Thread.sleep(1000);
	}

	// Invalid entries Scenario
	@When("^user enters \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" invalid entries in the text boxes$")
	public void user_enters_invalid_entries_in_the_text_boxes(String linkageKey, String odsCode, String userID)
			throws Throwable {
		new PatientOnlinePage(driver).user_provides_input_data(linkageKey, odsCode, userID);
	}

	@When("^presses continue button$")
	public void presses_continue_button() throws Throwable {
		new PatientOnlinePage(driver).user_clicks_continue_button();
	}

	@Then("^error messages shown to enter valid values$")
	public void error_messages_shown_to_enter_valid_values() throws Throwable {

		new PatientOnlinePage(driver).displayLinkageKeyErrorMessages();
		new PatientOnlinePage(driver).displayOdsCodeErrorMessages();
		new PatientOnlinePage(driver).displayUserIDErrorMessages();
		Thread.sleep(2000);
	}

	public void display() throws Throwable {
		Assert.assertEquals(driver.getTitle(), "NHS - Citizen ID");
		Thread.sleep(1000);
	}

}