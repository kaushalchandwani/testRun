package com.register.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class RegisterUserTest 
{
	  public WebDriver driver;
	
	  @Test
	  public void userRegistration() throws Exception 
	  {
		//define date format for mail id
			Date date = new Date();
			DateFormat dateFormat_extension = new SimpleDateFormat("yyyyMMddHHmmss");
			String emailId = "abc"+ dateFormat_extension.format(date)+"@example.com";
			System.out.println("emailid:"+ emailId);
					
			driver.get("https://blue.testlab.nhs.uk/cicauth/realms/NHS/account/");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			Thread.sleep(2000);
			
			if(driver.getTitle().equalsIgnoreCase("Log in to NHS"))
			{
				System.out.println("Login Page");
			}
			else
			{
				throw new NoSuchElementException("Register url not working");
			}
			
			driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div/div[2]/div/a/label")).click();
			
			if(driver.getTitle().equalsIgnoreCase("Register with NHS"))
			{
				System.out.println("Register Page");
	
			}
			else
			{
				throw new NoSuchElementException("Register url not working");
			}
			driver.findElement(By.xpath(".//*[@id='email']")).sendKeys(emailId);
			driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("Welcome123#");
			driver.findElement(By.xpath(".//*[@id='password-confirm']")).sendKeys("Welcome123#");
	
			Thread.sleep(2000);
	
			driver.findElement(By.xpath(".//*[@id='kc-form-wrapper']/form/div[4]/div[2]/input")).click();
			Thread.sleep(5000);
			String confirmMailMessage = driver.findElement(By.xpath("html/body/div[1]/div/div[1]/div/div/div/label/label")).getText();
			String confirmMessage = driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div/div[1]/div/span[2]")).getText();
	
			
			if(confirmMailMessage.equalsIgnoreCase("Confirm your email") && confirmMessage.equalsIgnoreCase("We need to verify your email address. Please check your email."))
			{
				System.out.println("Confirm email Page");
	
			}
			else
			{
				throw new NoSuchElementException("Confirm email not send");
			}
			
		/*
				 html/body/div[1]/div/div[1]/div/div/div --> create nhs account 
				 .//*[@id='kc-form-wrapper']/form/div[1]/label --> email add label 
				 .//*[@id='kc-form-wrapper']/form/div[2]/label --> password label 
				 .//*[@id='email']
				 .//*[@id='password']
				 .//*[@id='kc-form-wrapper']/form/div[4]/div[2]/input --register
				 
				 */
	  }
	  
	  @BeforeMethod
	  public void beforeMethod() 
	  {
		
		//System.setProperty("webdriver.gecko.driver", "/usr/bin/chromedriver");
		System.out.println("\n Defining webdriver \n");
		//System.out.println("main-webdriver.chrome.driver:" + System.getProperty("webdriver.chrome.driver"));
	
		/*ChromeOptions options = new ChromeOptions(); 
		options.addArguments("--incognito"); //passing incognito as arguments
		options.addArguments("start-maximized"); //adding maximise
		DesiredCapabilities capabilities = DesiredCapabilities.chrome(); //Defining capabilities
		capabilities.setCapability(ChromeOptions.CAPABILITY, options); */
		//driver = new ChromeDriver(capabilities);
		
		//commented for maven 
		//driver = new ChromeDriver();
		//System.setProperty("webdriver.chrome.driver", "exe/chromedriver.exe"); //chromedriver.exe set property path
		System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");
		//DesiredCapabilities firefoxCaps = new DesiredCapabilities().firefox();
		//firefoxCaps.setJavascriptEnabled(true);
		//driver = new FirefoxDriver(firefoxCaps);
		driver = new FirefoxDriver();
	  }
	
	  @AfterMethod
	  public void afterMethod() 
	  {
		driver.quit();
		//driver.close();
	  }

}
