/**
 * @author Kaushal Chandwani
 *
 */
package com.cucumber.helper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cucumber.config.Constant;

public class UnValidatedAccountLoginTest 
{
	  public WebDriver driver;
	  @BeforeMethod
	  public void beforeMethod() 
	  {
		
				
		System.out.println("\nOpening webdriver \n");
		
		if(Constant.environmentVariable.equalsIgnoreCase("local"))
	  	{
			System.setProperty("webdriver.chrome.driver", "exe/chromedriver.exe"); //chromedriver.exe set property path
			driver = new ChromeDriver();
	  	}
	  	else
	  	{
	  		System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", true);
			driver = new FirefoxDriver(capabilities);
	  	}
		
	  }
	
	  
	  @AfterMethod
	  public void afterMethod() 
	  {
		System.out.println("\nClosing webdriver......");
		driver.get("about:config");
		//driver.quit();
		driver.close();
	  }
	  
	  @Test
	  public void userUnvalidatedLogin() throws Exception 
	  {
		
			System.out.println("\nUser emailid: "+ Constant.username_Patient);
					
			driver.get(Constant.url_nhsAccountCreation);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			Thread.sleep(1000);
			Reporter.log( "Opening url: "+ Constant.url_nhsAccountCreation, true );

			
			
			if(driver.getTitle().equalsIgnoreCase("Log in to NHS"))
			{
				System.out.println("\nLogin Page");
				Reporter.log( "Navigated to login Page", true );

			}
			else
			{
				throw new NoSuchElementException("Login url is not working");
			}
			
			driver.findElement(By.xpath(Constant.xpath_loginPage_EmailInputBox)).clear();
			driver.findElement(By.xpath(Constant.xpath_loginPage_PasswordInputBox)).clear();
			
			driver.findElement(By.xpath(Constant.xpath_loginPage_EmailInputBox)).sendKeys(Constant.username_Patient);
			driver.findElement(By.xpath(Constant.xpath_loginPage_PasswordInputBox)).sendKeys(Constant.password_Patient);
			driver.findElement(By.xpath(Constant.xpath_loginPage_loginButton)).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			Reporter.log( "User Credentials for login:- \nemail: "+Constant.username_Patient+"\npassword: "+Constant.password_Patient, true );

			
			Thread.sleep(2000);
			if(driver.getTitle().equalsIgnoreCase("Validate your email"))
			{
				System.out.println("\nValidate email Page");
				Reporter.log( "Navigated to Validate email Page", true );
				boolean elementStatusOtherAttempt = com.cucumber.utility.CheckElement.existsElement(Constant.xpath_confirmEmailPage_messageHeader,driver);
				boolean elementStatus3rdAttempt = com.cucumber.utility.CheckElement.existsElement(Constant.xpath_validateEmailPage3rdAttempt_messageHeader,driver);

				if(elementStatusOtherAttempt)
				{
					String confirmMailMessage = driver.findElement(By.xpath(Constant.xpath_confirmEmailPage_messageBanner)).getText();
					String confirmMessage = driver.findElement(By.xpath(Constant.xpath_confirmEmailPage_messageHeader)).getText();
					if(confirmMessage.equalsIgnoreCase("Validate your email") && confirmMailMessage.equalsIgnoreCase("You need to validate your email address before you can log in. Please check your email."))
					{
						System.out.println("\nValidate email Message displayed");
						Reporter.log( "Verification email sent to user", true );
						//driver.findElement(By.xpath(Constant.xpath_confirmEmailPage_resendEmailLink)).click();
						userUnvalidatedLogin();

					}
					else
					{
						throw new NoSuchElementException("Validate email not send");
					}
				}
				
				if(elementStatus3rdAttempt)
				{
					String confirmMailMessage = driver.findElement(By.xpath(Constant.xpath_validateEmailPage3rdAttempt_messageBanner)).getText();
					String confirmMessage = driver.findElement(By.xpath(Constant.xpath_validateEmailPage3rdAttempt_messageHeader)).getText();
					if(confirmMessage.equalsIgnoreCase("This is your 3rd attempt") && confirmMailMessage.equalsIgnoreCase("If you still havent received an email from us please can you email Michael.Tattersall@nhs.net or call 07402 833373."))
					{
						System.out.println("\nThis is your 3rd attempt");
						Reporter.log( "This is your 3rd attempt message displayed", true );
						driver.findElement(By.xpath(Constant.xpath_validateEmailPage3rdAttempt_loginLink)).click();
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						Thread.sleep(1000);
						
						if(driver.getTitle().equalsIgnoreCase("Log in to NHS"))
						{
							System.out.println("\nLogin Page");
							Reporter.log( "Navigated to login Page", true );

						}
						else
						{
							throw new NoSuchElementException("Login url is not working");
						}
						
					}
					else
					{
						throw new NoSuchElementException("Third attempt page not displayed");
					}
				}

				
			}
			else
			{
				throw new NoSuchElementException("Validate email not working");
			}
	  }
}
