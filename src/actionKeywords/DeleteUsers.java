package actionKeywords;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import config.constants;

public class DeleteUsers 
{
	public static boolean deleteUsersProfile() throws Exception
	{
	
		DesiredCapabilities firefoxCaps = new DesiredCapabilities().firefox();
		firefoxCaps.setJavascriptEnabled(true);
		WebDriver driverUsers = new FirefoxDriver(firefoxCaps);
		
		boolean deleteUserStatus =false;
		
		
		
		try
		{
			
			
			
			driverUsers.get(constants.URL_REALM_ADMIN);
			driverUsers.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			driverUsers.findElement(By.xpath(".//*[@id='username']")).sendKeys(constants.UserName_realm_admin);
			driverUsers.findElement(By.xpath(".//*[@id='password']")).sendKeys(constants.Password_realm_admin);	
			Thread.sleep(2000);
			driverUsers.findElement(By.xpath(".//*[@id='kc-login']")).click();
			driverUsers.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    Thread.sleep(2000);

			driverUsers.findElement(By.xpath(".//*[@id='view']/div[2]/div[3]/ul/li[2]/a")).click();
			driverUsers.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    Thread.sleep(1000);

		    driverUsers.findElement(By.xpath(".//*[@id='viewAllUsers']")).click();
			driverUsers.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    Thread.sleep(1000);
		    
		    //---> .//*[@id='view']/div[1]/table/tbody/tr[1]/td[1]
		    
			List<WebElement> rows =   (List<WebElement>) driverUsers.findElements(By.xpath(".//*[@id='view']/div[1]/table/tbody/tr"));
			int countRows = rows.size();
			//System.out.println("ROW COUNT : "+countRows);
			
			List<WebElement> columns = driverUsers.findElements(By.xpath(".//*[@id='view']/div[1]/table/tbody/tr[2]/td"));
			int countColumns = columns.size();
			//System.out.println("ROW COUNT : "+countColumns);
			
			for (int i=1;i<countRows;i++)
			{
				boolean deleteVariable=false;
				for (int j=1;j<=countColumns;j++)
				{
					String xpathVariable =".//*[@id='view']/div[1]/table/tbody/tr[" + i + "]/td["+ j +"]";
					String sColumnValue="";
					boolean elementStatus = utilities.CheckElement.existsElement(xpathVariable,driverUsers);
					if(elementStatus)
					{
						sColumnValue= driverUsers.findElement(By.xpath(xpathVariable)).getText();
						//System.out.println("Column value: "+ sColumnValue);
						if(sColumnValue.equalsIgnoreCase(constants.Patient_email_id))
						{
							deleteVariable = true;
						}
						if(deleteVariable && sColumnValue.equalsIgnoreCase("Delete"))
						{
						    driverUsers.findElement(By.xpath(xpathVariable)).click();
							Thread.sleep(1000);

						    //html/body/div[5]/div/div/div[3]/button[2] delete button 
						    //html/body/div[5]/div/div/div[2] delete message
						    //html/body/div[5]/div/div/div[3]/button[1] cancel button
						    //html/body/div[5]/div/div/div[1] delete user label
						    String deletePopup = driverUsers.findElement(By.xpath("html/body/div[5]/div/div/div[1]")).getText();
						    if(deletePopup.equalsIgnoreCase("Delete User"))
						    {
							    driverUsers.findElement(By.xpath("html/body/div[5]/div/div/div[3]/button[2]")).click();
							    deleteUserStatus = true;
								Thread.sleep(1000);

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
			//users profile tab
			driverUsers.findElement(By.xpath("html/body/nav/div[2]/ul/li/a")).click();
			Thread.sleep(3000);
			//logout
			driverUsers.findElement(By.xpath("html/body/nav/div[2]/ul/li/ul/li[4]/a")).click();
			Thread.sleep(3000);

			
			
			driverUsers.close();
			driverUsers.quit();
			return deleteUserStatus;
		
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			//webdriver close and exit
			driverUsers.close();
			driverUsers.quit();
			return deleteUserStatus;
					
		}
		
		
		
		
	    
	    
	    
	}
}
