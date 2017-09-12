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

import com.register.config.Constant;

public class RegisterUserTest02 
{
	public WebDriver driver;
	
	  @Test
	  public void userRegistration() throws Exception 
	  {
		//define date format for mail id
			Date date = new Date();
			DateFormat dateFormat_extension = new SimpleDateFormat("yyyyMMddHHmmss");
			//String emailId = "abc"+ dateFormat_extension.format(date)+"@example.com";
			//emailId = "cid.testuser1@gmail.com";
			System.out.println("\nUser emailid: "+ Constant.username_Patient);
					
			driver.get("https://blue.testlab.nhs.uk/cicauth/realms/NHS/account/");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			Thread.sleep(3000);
			
			
			if(driver.getTitle().equalsIgnoreCase("Log in to NHS"))
			{
				System.out.println("\nLogin Page");
			}
			else
			{
				throw new NoSuchElementException("Login url is not working");
			}
			
			
			
			driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div/div[2]/div/a/label")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			Thread.sleep(3000);
			
			

			
			if(driver.getTitle().equalsIgnoreCase("Register with NHS"))
			{
				System.out.println("\nRegister Page");
	
			}
			else
			{
				throw new NoSuchElementException("Register url not working");
			}
			
			driver.findElement(By.xpath(".//*[@id='email']")).sendKeys(Constant.username_Patient);
			driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(Constant.password_Patient);
			driver.findElement(By.xpath(".//*[@id='password-confirm']")).sendKeys(Constant.password_Patient);
	
			Thread.sleep(2000);
	
			driver.findElement(By.xpath(".//*[@id='kc-form-wrapper']/form/div[4]/div[1]/input")).click();
			Thread.sleep(5000);
			
		
			if(driver.getTitle().equalsIgnoreCase("Register with NHS"))
			{
				System.out.println("\nRemain on Register Page");
				String errorMessage = driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div/div[1]/div/span[2]")).getText();
				
				
				if(errorMessage.equalsIgnoreCase("Email already exists.") )
				{
					System.out.println("\nEmail already exists.");
		
				}
				else
				{
					throw new NoSuchElementException("Email already check failed");
				}
			}
			else
			{
				throw new NoSuchElementException("Register url not working");
			}
			//String confirmMailMessage = driver.findElement(By.xpath("html/body/div[1]/div/div[1]/div/div/div/label/label")).getText();
		
			
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
		//System.out.println("main-webdriver.chrome.driver:" + System.getProperty("webdriver.chrome.driver"));
	
		/*ChromeOptions options = new ChromeOptions(); 
		options.addArguments("--incognito"); //passing incognito as arguments
		options.addArguments("start-maximized"); //adding maximise
		DesiredCapabilities capabilities = DesiredCapabilities.chrome(); //Defining capabilities
		capabilities.setCapability(ChromeOptions.CAPABILITY, options); */
		//driver = new ChromeDriver(capabilities);
		
		System.out.println("\nOpening webdriver \n");

		//commented for maven 
		//System.setProperty("webdriver.chrome.driver", "exe/chromedriver.exe"); //chromedriver.exe set property path
		//driver = new ChromeDriver();

		/*
		System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		driver = new FirefoxDriver(capabilities);
		*/
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

}
