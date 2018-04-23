/**
 * @author Kaushal Chandwani
 *
 */
package com.cucumber.stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;




import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;

import com.cucumber.config.Constant;
import com.cucumber.helper.DeleteUsersTest;
import com.cucumber.helper.ResetPasswordEmail;
import com.cucumber.helper.VerifyEmail;
import com.cucumber.helper.VerifyOTPCode;
import com.cucumber.pageobjects.AccountInfoPage;
import com.cucumber.pageobjects.CreateAccountPage;
import com.cucumber.pageobjects.ForgotPasswordPage;
import com.cucumber.pageobjects.PhoneNoPage;
import com.cucumber.pageobjects.ResetPasswordPage;
import com.cucumber.pageobjects.SecurityCodePage;
import com.cucumber.pageobjects.SigninPage;
import com.cucumber.pageobjects.UserAccountPage;
import com.cucumber.pageobjects.VerifyEmailPage;
import com.cucumber.pageobjects.VerifyEmailPageThreeAttempt;
import com.cucumber.utility.MessageBox;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterUserTest 
{
	private WebDriver driver;
	/*public WebDriver driver;
	@Before
	public void before() 
	{
		System.out.println("\nOpening webdriver \n");
		
		if(Constant.environmentVariable.equalsIgnoreCase("local"))
	  	{
			System.setProperty("webdriver.chrome.driver", "exe/chromedriver.exe"); //chromedriver.exe set property path
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			driver = new ChromeDriver(options);
			//driver = new ChromeDriver();
	  	}
	  	else
	  	{
	  		System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", true);
			driver = new FirefoxDriver(capabilities);
	  	}    
	}
	 
	@After
	public void after() 
	{
		System.out.println("\nClosing webdriver......");
		driver.get("about:config");
		//driver.quit();
		driver.close();
	}
	    
	*/
	
//	@Before
//	//@Parameters("browser")
//    public void beforeScenario() throws Exception 
//	{
//        driver = new DriverFactory().getDriver();
//        System.out.println("Openning a new web-browser and session.");
//    }
//
//    @After
//    public void afterScenario() throws Exception 
//    {
//        new DriverFactory().destroyDriver();
//        System.out.println("Closing the web-browser and session ");
//    }

	@When("^he click on register link for registration page navigation$")
	public void he_click_on_register_link_for_registration_page_navigation() throws Throwable 
	{
		//click on new user link 
		new SigninPage(driver).user_create_nhs_account();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(1000);
		//verify create an nhs account page
		new CreateAccountPage(driver).create_nhs_account_page_validation();
		Reporter.log( "Navigated to Create an NHS account Page", true );

		
	}


	@When("^he provides the valid emailaddress as \"([^\"]*)\"$")
	public void he_provides_the_valid_emailaddress_as(String arg1) throws Throwable 
	{
	    
		//changes to use page object model for CreateAccountPage class
		new CreateAccountPage(driver).user_provides_the_email_as(arg1);
		Reporter.log( "User Credentials for registration:- \nemail: "+arg1);
		Thread.sleep(1000);
				
	}

	@When("^he provides the valid password as  \"([^\"]*)\"$")
	public void he_provides_the_valid_password_as(String arg1) throws Throwable 
	{
		new CreateAccountPage(driver).user_provides_the_password_as(arg1);
		Reporter.log( "\n Password: "+arg1, true );
		Thread.sleep(1000);
	}

	
	@When("^he provides the valid confirm password again as \"([^\"]*)\"$")
	public void he_provides_the_valid_confirm_password_again_as(String arg1) throws Throwable 
	{
		new CreateAccountPage(driver).user_provides_the_confirm_password_again_as(arg1);		
		Reporter.log( "\nConfirm Password: "+arg1, true );
		Thread.sleep(1000);
	}

	@When("^he submit register button$")
	public void he_submit_register_button() throws Throwable 
	{
		new CreateAccountPage(driver).user_register();
		Reporter.log( "\nClicked on Register button ", true );
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
	}

	@Then("^he should be navigated to Validate Email page$")
	public void he_should_be_navigated_to_Validate_Email_page() throws Throwable 
	{
	    
		Assert.assertEquals(driver.getTitle(),"Validate your email");
		new VerifyEmailPage(driver).verify_Email_Page_Validation();
		Reporter.log( "Navigated to Validate email Page", true );
	}

		
	
	
	@Given("^the user is login to his mail account to verify NHS account$")
	public void the_user_is_login_to_his_mail_account_to_verify_NHS_account() throws Throwable 
	{	
		Reporter.log("---- Scenario ----------------", true );
		driver.get(Constant.url__mailCatcher_local);
	  	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  	Thread.sleep(1000);
	  	Assert.assertTrue(driver.getTitle().matches("MailCatcher(.*)"));
		Reporter.log("MailCatcher application open.....", true );
	}


	
	@When("^he click on verify email link to verify NHS account with valid emailaddress as \"([^\"]*)\"$")
	public void he_click_on_verify_email_link_to_verify_NHS_account_with_valid_emailaddress_as(String arg1) throws Throwable 
	{
		driver = VerifyEmail.verifyEmailLink(driver,arg1);
		Reporter.log( "Verify email link clicked to verify account", true );
	}

	@Then("^he should be navigated to Account verified page$")
	public void he_should_be_navigated_to_Account_verified_page() throws Throwable 
	{
	    Assert.assertEquals(driver.getTitle(),"Sign in to your NHS Account");
	    new SigninPage(driver).verify_email_address_message();
		Reporter.log( "Email address has been verified.", true );
	}
	
	//----------------------------
	@Given("^the user is on login page of a NHS account$")
	public void the_user_is_on_login_page_of_a_NHS_account() throws Throwable 
	{
		Reporter.log("---- Scenario ----------------", true );
		Reporter.log("\nOpening url: "+ Constant.url_nhsAccountCreation, true );
		driver.get(Constant.url_nhsAccountCreation);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertEquals(driver.getTitle(),"Sign in to your NHS Account");
		Thread.sleep(1000);
		Reporter.log( "Navigated to Sign in Page: Sign in to your NHS Account", true );
	}
	
	@When("^he provides the valid emailaddress on login page as \"([^\"]*)\"$")
	public void he_provides_the_valid_emailaddress_on_login_page_as(String arg1) throws Throwable 
	{
		new SigninPage(driver).user_provides_the_email_as(arg1);
		Reporter.log( "User Credentials for login: email address - " + arg1, true );
	}

	@When("^he provides the valid password on login page as \"([^\"]*)\"$")
	public void he_provides_the_valid_password_on_login_page_as(String arg1) throws Throwable 
	{
		new SigninPage(driver).user_provides_the_password_as(arg1);
		Reporter.log( "password - " + arg1, true );
	}

	@When("^he submit login button$")
	public void he_submit_login_button() throws Throwable 
	{
		new SigninPage(driver).user_signin();
		Reporter.log( "Clicked on signin button", true );
	}

	
	@When("^he is navigated to twoFA page to input phoneno as \"([^\"]*)\"$")
	public void he_is_navigated_to_twoFA_page_to_input_phoneno_as(String arg1) throws Throwable   
	{
		Thread.sleep(1000);
	    Assert.assertEquals(driver.getTitle(),"Security code");
		new PhoneNoPage(driver).verify_phoneno_page();
		new PhoneNoPage(driver).user_provides_phone_no(arg1);
		new PhoneNoPage(driver).user_submit_phone_no();
		//new PhoneNoPage(driver).valid_phone_no_check();
		Reporter.log( "User enter phone no: "+arg1 , true );

		
	}



	@When("^he is navigated to twoFA page to input security code for phoneno as \"([^\"]*)\"$")
	public void he_is_navigated_to_twoFA_page_to_input_security_code_for_phoneno_as(String arg1) throws Throwable 
	{
		Thread.sleep(1000);
	    Assert.assertEquals(driver.getTitle(),"Security code");
	    new SecurityCodePage(driver).verify_security_code_page();
	    new SecurityCodePage(driver).user_provides_security_code(arg1);
	    new SecurityCodePage(driver).user_submit_security_code();
	    //new SecurityCodePage(driver).valid_security_code_check();
	}
	
	
	@When("^he is navigated to twoFA page to input resend security code for phoneno as \"([^\"]*)\"$")
	public void he_is_navigated_to_twoFA_page_to_input_resend_security_code_for_phoneno_as(String arg1) throws Throwable 
	{
	    // Write code here that turns the phrase above into concrete actions
		Thread.sleep(1000);
		new SecurityCodePage(driver).verify_security_code_page();
		MessageBox.printMessage("Resend seucrity code \n Waittime for 2 minutes ", 120001);
		new SecurityCodePage(driver).security_code_resend();
		new SecurityCodePage(driver).user_provides_security_code(arg1);
		new SecurityCodePage(driver).user_submit_security_code();
		
	}
	
	@Then("^he should be navigated to account dashboard page$")
	public void he_should_be_navigated_to_account_dashboard_page() throws Throwable 
	{
		Thread.sleep(1000);
	    Assert.assertEquals( driver.getTitle(),"NHS Account Management");
	    new UserAccountPage(driver).verify_user_account_page();
		Reporter.log( "Logged in successfully to NHS account page" , true );

	    new UserAccountPage(driver).user_logout();
		Reporter.log( "Logged out successfully" , true );


	}	
	@When("^he click on the forgotton your password link$")
	public void he_click_on_the_forgotton_your_password_link() throws Throwable 
	{
		Thread.sleep(1000);
		new SigninPage(driver).user_forgotPassword();
	    Assert.assertEquals( driver.getTitle(),"Please specify your email address");
	
	}

	@When("^he is navigated to forgot password page to specify email address as \"([^\"]*)\" to reset password$")
	public void he_is_navigated_to_forgot_password_page_to_specify_email_address_as_to_reset_password(String arg1) throws Throwable 
	{
		new ForgotPasswordPage(driver).verify_ForgotPasswordPage_message();
		new ForgotPasswordPage(driver).user_provides_the_email_as(arg1);
	}

	@When("^he clicked on submit button$")
	public void he_clicked_on_submit_button() throws Throwable 
	{
		new ForgotPasswordPage(driver).user_click_submit_button();
	
	}

	@Then("^he should be navigated to successful password reset email sent page$")
	public void he_should_be_navigated_to_successful_password_reset_email_sent_page() throws Throwable 
	{
		Assert.assertEquals( driver.getTitle(),"Sign in to your NHS Account");
		/*String resetPasswordBanner = driver.findElement(By.xpath(Constant.xpath_loginPage_resetPasswordLinkBanner)).getText();
		String forgotPasswordBanner = driver.findElement(By.xpath(Constant.xpath_loginPage_fogottenPasswordHeader)).getText();
		String checkEmailBanner = driver.findElement(By.xpath(Constant.xpath_loginPage_checkEmailBanner)).getText();
		
		Assert.assertEquals( resetPasswordBanner,"We have sent you instructions on how to reset your password to your email.\n\nYou have 48 hours to reset your password before the link is deactivated.");
		Assert.assertEquals( forgotPasswordBanner,"Forgotten password");
		Assert.assertEquals( checkEmailBanner,"Check your email");*/
		
	}

	@Given("^the user is login to his mail account to reset password$")
	public void the_user_is_login_to_his_mail_account_to_reset_password() throws Throwable 
	{
		driver.get(Constant.url__mailCatcher_local);
	  	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  	Thread.sleep(1000);
	  	System.out.println(driver.getTitle());
	  	Assert.assertTrue(driver.getTitle().matches("MailCatcher(.*)"));
		Reporter.log("MailCatcher application open.....", true );
	}

	@When("^he click on reset password link to reset password for NHS account with valid emailaddress as \"([^\"]*)\"$")
	public void he_click_on_reset_password_link_to_reset_password_for_NHS_account_with_valid_emailaddress_as(String arg1) throws Throwable 
	{
	  	Assert.assertTrue(driver.getTitle().matches("MailCatcher(.*)"));
		driver = ResetPasswordEmail.resetPasswordLink(driver, arg1);
		Reporter.log( "Reset password link clicked to reset user password ", true );

	}

	@When("^he should be navigated to password reset page$")
	public void he_should_be_navigated_to_password_reset_page() throws Throwable 
	{
	    new ResetPasswordPage(driver).verify_ResetPasswordPage_message();

	}

	@When("^he enters new password with confirm password as \"([^\"]*)\"$")
	public void he_enters_new_password_with_confirm_password_as(String arg1) throws Throwable 
	{
		new ResetPasswordPage(driver).user_provides_the_password_as(arg1);

	}
	
	@When("^he click on continue button on password reset page$")
	public void he_click_on_continue_button_on_password_reset_page() throws Throwable 
	{
		new ResetPasswordPage(driver).user_click_continue_button();
		

	}
	
	@Then("^he should be navigated to info page$")
	public void he_should_be_navigated_to_info_page() throws Throwable 
	{
		new SigninPage(driver).successful_password_reset_message();
		//new AccountInfoPage(driver).verify_back_to_application_link();
	    Assert.assertEquals(driver.getTitle(),"Sign in to your NHS Account");

	}
	

	@Given("^the user is logged in admin page$")
	public void the_user_is_logged_in_admin_page() throws Throwable 
	{
		
		driver.get(Constant.url_nhsAccountRealmAdmin);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
		Assert.assertEquals(driver.getTitle(),"Sign in to your NHS Account");
		
		

	}
	


	@When("^he is navigated to admin console for deletion of user account with username as \"([^\"]*)\"$")
	public void he_is_navigated_to_admin_console_for_deletion_of_user_account_with_username_as(String arg1) throws Throwable 
	{
		driver = DeleteUsersTest.deleteUsersProfile(driver, arg1);
	}

	
	
	@Then("^the user should be successfully deleted$")
	public void the_user_should_be_successfully_deleted() throws Throwable 
	{
		Assert.assertEquals(driver.getTitle(),"Sign in to your NHS Account");
		Thread.sleep(2000);

	}

	@Given("^when he click to back to sign in link$")
	public void when_he_click_to_back_to_sign_in_link() throws Throwable 
	{
		new VerifyEmailPage(driver).user_back_to_signIn_Link_from_verify_page();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Then("^he should be navigated to validate email page with message of three attempts$")
	public void he_should_be_navigated_to_validate_email_page_with_message_of_three_attempts() throws Throwable 
	{
		new VerifyEmailPageThreeAttempt(driver).verify_Email_3rd_Attempt_Page_Validation();
	}

	
	
}
