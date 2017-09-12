package com.register.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import com.register.config.Constant;

public class VerifyEmailTest 
{
	  public WebDriver driverEmail;

  @Test
  public void verifyEmail() throws Exception 
  {
	  	boolean clickVerifyEmail=false;
		boolean emailSender = false;
		boolean emailReceiver =false;
		boolean emailSubject = false;
		boolean emailConfirmationStatus = false;

		String verifyPageHeader="";
		String verifyPageMessage01="";
		String verifyEmailVerificationLink="";
		String verifyPageMessage02="";
		
	  	
	  	if(Constant.environmentVariable.equalsIgnoreCase("local"))
	  	{
	  		driverEmail.get("http://localhost:9999/");
	  	}
	  	else
	  	{
	  		driverEmail.get("http://172.17.0.1:1080");
	  	}

	  	driverEmail.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  	driverEmail.manage().window().maximize();
	  	Thread.sleep(2000);
		
		
		if(driverEmail.getTitle().matches("MailCatcher(.*)"))
		{
			System.out.println("\nMailCatcher Application open.....");
		}
		else
		{
			throw new NoSuchElementException("MailCatcher application unable to load.....");
		}
		
		//.//*[@id='messages']/table/tbody/tr[1]/td[1]
		
		List<WebElement> rows =   (List<WebElement>) driverEmail.findElements(By.xpath(".//*[@id='messages']/table/tbody/tr"));
		int countRows = rows.size();
		//System.out.println("\nROW COUNT : "+countRows);
		
		List<WebElement> columns = driverEmail.findElements(By.xpath(".//*[@id='messages']/table/tbody/tr[1]/td"));
		int countColumns = columns.size();
		//System.out.println("\nCOL COUNT : "+countColumns);
		
		for (int i=1;i<countRows;i++)
		{
			//int index
			clickVerifyEmail=false;
			emailSender = false;
			emailReceiver =false;
			emailSubject = false;
			for (int j=1;j<=countColumns;j++)
			{
				String xpathVariable =".//*[@id='messages']/table/tbody/tr[" + i + "]/td["+ j +"]";
				String sColumnValue="";
				boolean elementStatus = com.register.utility.CheckElement.existsElement(xpathVariable,driverEmail);
				if(elementStatus)
				{
					sColumnValue= driverEmail.findElement(By.xpath(xpathVariable)).getText();
					//System.out.println("\nColumn value: "+ sColumnValue);
					if(sColumnValue.matches("<citizen.identity1@gmail.com>"))
					{
						//System.out.println("\nEmail sender id: "+ sColumnValue);
						emailSender = true;
					}
					
						
					if(emailSender && sColumnValue.matches("<cid.testuser1@gmail.com>"))
					{
						//System.out.println("\nEmail receipient id: "+ sColumnValue);
						emailReceiver=true;
					    
					}
					if(emailReceiver && sColumnValue.matches("Verify email"))
					{
						//System.out.println("\nSubject: "+ sColumnValue);
						emailSubject =true;
					}
					if(emailSubject)
					{
						driverEmail.findElement(By.xpath(".//*[@id='messages']/table/tbody/tr[" + i + "]")).click();
					  	driverEmail.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

						Thread.sleep(2000);

						clickVerifyEmail = true;
						break;
					}
					
				}
				
			}
			if(clickVerifyEmail)
			{
				break;
			}
			
		}
		
		if(clickVerifyEmail)
		{
			//li[1] for html and li[2] for plain text --- two diff tabs 
			driverEmail.findElement(By.xpath(".//*[@id='message']/header/nav/ul/li[1]/a")).click();
		  	driverEmail.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Thread.sleep(1000);
			
			driverEmail.switchTo().defaultContent();
			driverEmail.switchTo().frame(driverEmail.findElement(By.tagName("iframe")));

			
			//verifyEmailVerificationLink= driverEmail.findElement(By.xpath("xhtml:html/xhtml:body/xhtml:a")).getText();
			//System.out.println("\nVerify Email Link: " + verifyEmailVerificationLink);

			verifyPageMessage01= driverEmail.findElement(By.xpath("html/body/table/tbody/tr/td/div/table/tbody/tr/td/table/tbody/tr/td/span")).getText();
			System.out.println("\n\nVerification email content: \n"+verifyPageMessage01 + "\n");
			
			//now click on verify and navigate to new link
			
			//get current page
			String currentPageHandle = driverEmail.getWindowHandle();
			String pageUrl = driverEmail.getCurrentUrl(); //pageurl
			//click the link to check 
			//driverEmail.findElement(By.xpath("xhtml:html/xhtml:body/xhtml:a")).click();
			driverEmail.findElement(By.xpath("html/body/table/tbody/tr/td/div/table/tbody/tr/td/table/tbody/tr/td/span/a")).click();

			//add wait
			driverEmail.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driverEmail.manage().window().maximize();
			Thread.sleep(2000);
			
			List<String> browserTabs = new ArrayList<String> (driverEmail.getWindowHandles());
			int tabsTotal=browserTabs.size();
			
			for(String eachTabs : browserTabs)
			{
				driverEmail.switchTo().window(eachTabs);
				
				
				//verify page title
				if(driverEmail.getTitle().equalsIgnoreCase("Your email address has been verified."))
				{
					String xpathBackToLogin = ".//*[@id='kc-info-message']/div/div/label/a";
					//verify element is present on page or not
					boolean elementStatus = com.register.utility.CheckElement.existsElement(xpathBackToLogin,driverEmail);
					Thread.sleep(1000);

					if(elementStatus)
					{
						String verificationMessage=driverEmail.findElement(By.xpath("html/body/div[1]/div/div[1]/div/div/div")).getText();
						System.out.println("\n\nSuccessful email verification message: "+verificationMessage);
						Thread.sleep(1000);
						
						//continue to login page 
						driverEmail.findElement(By.xpath(xpathBackToLogin)).click();
						driverEmail.manage().window().maximize();
						Thread.sleep(1000);
						
						//check whether successfully navigated to login page or not
						if(driverEmail.getTitle().equalsIgnoreCase("Log in to NHS"))
						{
							System.out.println("\nBack to application...");

							System.out.println("\nLogin Page");
						}
						else
						{
							throw new NoSuchElementException("\nNavigation back to login page failed");
						}
						
						//closing driver of current tab
						driverEmail.close();
						//switch to old main tab
						driverEmail.switchTo().window(currentPageHandle);
						driverEmail.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						Thread.sleep(1000);
						
						emailConfirmationStatus =true;
						
					}
					else
					{
						//throw new NoSuchElementException("Sorry !!! \n Email verification is unsuccessfull.....");
					}
				}
				

			}
			//String pageTitle = driverTabs.getTitle();  //pagetitle
			
			
			/* verification sucessful elements
			html/body/div[1]/div/div[1]/div message 
			.//*[@id='kc-info-message']/p[1] message 
			.//*[@id='kc-info-message']/p[2]/a back to application 
			*/
			
			/*
			 * verification unsuccessfull or expired email link
			 * html/body/div[1]/div/div[1]/div/div/div/label[1] --error
			 * html/body/div[1]/div/div[1]/div/div/div/label[2] --- we r sorry....
			 * .//*[@id='kc-form-wrapper']/div/div/div/p -- failure message
			 */
			if(!emailConfirmationStatus)
			{
				//call check for sorry page 
			}
		
		}
		
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
		//driverEmail = new ChromeDriver();

		/*
		System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		driverEmail = new FirefoxDriver(capabilities);
		*/
		if(Constant.environmentVariable.equalsIgnoreCase("local"))
	  	{
			System.setProperty("webdriver.chrome.driver", "exe/chromedriver.exe"); //chromedriver.exe set property path
			driverEmail = new ChromeDriver();
	  	}
	  	else
	  	{
	  		System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", true);
			driverEmail = new FirefoxDriver(capabilities);
	  	}
		
		
		
  }

  @AfterMethod
  public void afterMethod() 
  {
	  	System.out.println("\nClosing webdriver......");

	  	driverEmail.get("about:config");
		//driver.quit();
	  	driverEmail.close();
  }

}
