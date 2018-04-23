package com.cucumber.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.cucumber.config.Constant;

public class ResetPasswordEmail 
{
	public static WebDriver driverEmail;
	
	public static WebDriver resetPasswordLink(WebDriver driver, String recipient) throws Exception 
	  {
		
		driverEmail = driver;
		recipient = "<" + recipient + ">";
		boolean clickVerifyEmail=false;
		boolean emailSender = false;
		boolean emailReceiver =false;
		boolean emailSubject = false;
		boolean emailConfirmationStatus = false;

		String resetPasswordMessage01="";
		
		Assert.assertTrue(driverEmail.getTitle().matches("MailCatcher(.*)"));
	   
		
		//.//*[@id='messages']/table/tbody/tr[1]/td[1]
		
		List<WebElement> rows =   (List<WebElement>) driverEmail.findElements(By.xpath(Constant.xpath_mailcatcherTable + "/tr"));
		int countRows = rows.size();
		//System.out.println("\nROW COUNT : "+countRows);
		
		List<WebElement> columns = driverEmail.findElements(By.xpath(Constant.xpath_mailcatcherTable + "/tr[1]/td"));
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
				String xpathVariable = Constant.xpath_mailcatcherTable + "/tr[" + i + "]/td["+ j +"]";
				String sColumnValue="";
				boolean elementStatus = com.cucumber.utility.CheckElement.existsElement(xpathVariable,driverEmail);
				if(elementStatus)
				{
					sColumnValue= driverEmail.findElement(By.xpath(xpathVariable)).getText();
					//System.out.println("\nColumn value: "+ sColumnValue);
					if(sColumnValue.matches("<citizen.identity1@gmail.com>"))
					{
						//System.out.println("\nEmail sender id: "+ sColumnValue);
						emailSender = true;
					}
					
					if(emailSender && sColumnValue.equalsIgnoreCase(recipient))
					{
						//System.out.println("\nEmail recipient id: "+ sColumnValue);
						emailReceiver=true;
					    
					}
					if(emailReceiver && sColumnValue.matches("Reset password"))
					{
						//System.out.println("\nSubject: "+ sColumnValue);
						emailSubject =true;
					}
					if(emailSubject)
					{
						driverEmail.findElement(By.xpath(Constant.xpath_mailcatcherTable + "/tr[" + i + "]")).click();
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
			driverEmail.findElement(By.xpath(Constant.xpath_mailcatcherEmailHtmlTab)).click();
			driverEmail.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Thread.sleep(1000);
			
			driverEmail.switchTo().defaultContent();
			driverEmail.switchTo().frame(driverEmail.findElement(By.tagName(Constant.xpath_mailcatcheriframe)));

			resetPasswordMessage01= driverEmail.findElement(By.xpath(Constant.xpath_mailcatcherEmailContent)).getText();
			Reporter.log( "Reset password email content: "+resetPasswordMessage01, true );

			//now click on verify button  and navigate to new link
			
			//get current page
			String currentPageHandle = driverEmail.getWindowHandle();
			String pageHandleNew = "";
			//String pageUrl = driverEmail.getCurrentUrl(); //pageurl
			//click the link to check 
			//driverEmail.findElement(By.xpath("xhtml:html/xhtml:body/xhtml:a")).click();
			driverEmail.findElement(By.xpath(Constant.xpath_mailcatcherVerifyButton)).click();

			//add wait
			driverEmail.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Thread.sleep(1000);
			
			List<String> browserTabs = new ArrayList<String> (driverEmail.getWindowHandles());
			//int tabsTotal=browserTabs.size();
			
			for(String eachTabs : browserTabs)
			{
				driverEmail.switchTo().window(eachTabs);
				
				String pageTitle = driverEmail.getTitle().toLowerCase();
				//verify page title
				if(pageTitle.contains(("Reset password").toLowerCase()))
				{
					
					//closing driver of current tab
					pageHandleNew = driverEmail.getWindowHandle();
					
					//changes --> driverEmail.close();
					//switch to old main tab
					driverEmail.switchTo().window(currentPageHandle);
					driverEmail.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					Thread.sleep(1000);
					//driver.get(url_mailcatcher);
					driverEmail.close();
					driverEmail.switchTo().window(pageHandleNew);
					emailConfirmationStatus =true;
					Thread.sleep(1000);

				}
				else
				{
					
				}
				

				if(emailConfirmationStatus)
				{
					System.out.println("\n Additional browser tabs closed successfully");
					
				}
				
				

			}
			
		
		}
		return driverEmail;
	  
	  }
}
