/**
 * @author Kaushal Chandwani
 *
 */
package com.cucumber.helper;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cucumber.config.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteUsersTest 
{
	  public static WebDriver driverUsers;

		 
	    @Test
		public static WebDriver deleteUsersProfile(WebDriver driver, String useremail) throws Exception
		{
		
	    	driverUsers = driver;		
			//String url_admin_console ="https://blue.testlab.nhs.uk/cicauth/admin/NHS/console";
			//String UserName_realm_admin="realmadmin";
			//String Password_realm_admin ="Welcome123";
			//String Patient_email_id="cid.testuser1@gmail.com";
			boolean deleteUserStatus = false;	
			
				
				
				
				//driverUsers.get(Constant.url_nhsAccountRealmAdmin);
				//driverUsers.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				//driverUsers.manage().window().maximize();

			
			    //user tab on left
				driverUsers.findElement(By.xpath(".//*[@id='view']/div[2]/div[3]/ul/li[2]/a")).click();
				driverUsers.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			    Thread.sleep(1000);
			    //view all user link
			    driverUsers.findElement(By.xpath(".//*[@id='viewAllUsers']")).click();
				driverUsers.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			    Thread.sleep(1000);
			    

			  //driverUsers.navigate().refresh();
				driverUsers.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Thread.sleep(1000);
			    driverUsers.findElement(By.xpath(".//*[@id='user-table']/thead/tr[1]/th/div/div[1]/div/input")).sendKeys(useremail);
			    //click on search button
				driverUsers.findElement(By.xpath(".//*[@id='user-table']/thead/tr[1]/th/div/div[1]/div/div")).click();
				driverUsers.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Thread.sleep(2000);
				//check if no results is there in search
				//boolean elementVariable = utilities.CheckElement.existsElement(".//*[@id='user-table']/tbody/tr/td[2]",driverUsers);
				String noResultVariable = driverUsers.findElement(By.xpath(".//*[@id='user-table']/tbody/tr/td[2]")).getText();
				
				if(noResultVariable.equalsIgnoreCase("No results"))
				{
					
					System.out.println("User already deleted or not present");
					Reporter.log("User already deleted or not present",true);
				}
				else if(noResultVariable.equalsIgnoreCase(useremail))
				{
					Thread.sleep(2000);
					deleteUserStatus=false;
					List<WebElement> rows =   (List<WebElement>) driverUsers.findElements(By.xpath(".//*[@id='view']/div[1]/table/tbody/tr"));
					int countRows = rows.size();
					System.out.println("ROW COUNT : "+countRows);
					
					List<WebElement> columns = driverUsers.findElements(By.xpath(".//*[@id='view']/div[1]/table/tbody/tr[1]/td"));
					int countColumns = columns.size();
					System.out.println("Column COUNT : "+countColumns);
					
					for (int i=1;i<countRows;i++)
					{
						boolean deleteVariable=false;
						for (int j=1;j<=countColumns;j++)
						{
							String xpathVariable =".//*[@id='view']/div[1]/table/tbody/tr[" + i + "]/td["+ j +"]";
							String sColumnValue="";
							boolean elementStatus = com.cucumber.utility.CheckElement.existsElement(xpathVariable,driverUsers);
							if(elementStatus)
							{
								sColumnValue= driverUsers.findElement(By.xpath(xpathVariable)).getText();
								//System.out.println("Column value: "+ sColumnValue);
								if(sColumnValue.equalsIgnoreCase(useremail))
								{
									deleteVariable = true;
								}
								if(deleteVariable && sColumnValue.equalsIgnoreCase("Delete"))
								{	
									WebDriverWait wait = new WebDriverWait(driverUsers, 15);
									  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathVariable)));
									  
								    driverUsers.findElement(By.xpath(xpathVariable)).click();
									driverUsers.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

									Thread.sleep(2000);
		
								    
									WebDriverWait wait1 = new WebDriverWait(driverUsers, 15);
									  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[5]/div/div/div[1]")));
									  
								    String deletePopup = driverUsers.findElement(By.xpath("html/body/div[5]/div/div/div[1]")).getText();
									Thread.sleep(2000);

								    if(deletePopup.equalsIgnoreCase("Delete User"))
								    {
								    	WebDriverWait wait2 = new WebDriverWait(driverUsers, 15);
										  wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[5]/div/div/div[3]/button[2]")));
										  
									    driverUsers.findElement(By.xpath("html/body/div[5]/div/div/div[3]/button[2]")).click();
										driverUsers.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

									    deleteUserStatus = true;
										Thread.sleep(4000);
		
									    break;
								    }
								    
								}
								//summaryDescription = summaryDescription + "  " + sColumnValue;
								
							}
							if(deleteUserStatus)
							{
								break;
							}
						}
						
					}
					
					if(!deleteUserStatus)
					{
						Thread.sleep(2000);

						System.out.println("User already deleted or not present");
						Reporter.log("User already deleted or not present",true);

					}
					else
					{
						System.out.println("\n"+ useremail + " is successfully deleted");
						Reporter.log("\n"+ useremail + " is successfully deleted",true);

					}
				}
				else
				{
					System.out.println("User already deleted or not present");
					Reporter.log("User already deleted or not present",true);
				}
				
				//users profile tab
				driverUsers.findElement(By.xpath("html/body/nav/div[2]/ul/li/a")).click();
				Thread.sleep(3000);
				//logout
				driverUsers.findElement(By.xpath("html/body/nav/div[2]/ul/li/ul/li[4]/a")).click();
				Thread.sleep(3000);
			
				return driverUsers;
		
			
		    
		}
		

		  
		
}
