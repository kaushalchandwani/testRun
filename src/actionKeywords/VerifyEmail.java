package actionKeywords;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import config.constants;

public class VerifyEmail 

{
	public static String accessEmail() throws Exception
	{
		/*
		.//*[@id='identifierId']
		.//*[@id='identifierNext']/div[2]
		.//*[@id='password']/div[1]/div/div[1]/input
		.//*[@id='passwordNext']/div[2]
		
		.//*[@id=':5d']/span[1]  --> more
		.//*[@id=':5m']/div/div[2]/span/a --all mail
		*/
		String link ="";
		
		
		DesiredCapabilities firefoxCaps = new DesiredCapabilities().firefox();
		firefoxCaps.setJavascriptEnabled(true);
		WebDriver driverUsers = new FirefoxDriver(firefoxCaps);
		

		driverUsers.get("https://mail.google.com");
		driverUsers.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

		// gmail login
		driverUsers.findElement(By.xpath(".//*[@id='identifierId']")).sendKeys(constants.Patient_email_id);
		Thread.sleep(2000);

		driverUsers.findElement(By.xpath(".//*[@id='identifierNext']/content/span")).click();

		driverUsers.findElement(By.xpath(".//*[@id='password']/div[1]/div/div[1]/input")).sendKeys(constants.Patient_gmail_password);	
		Thread.sleep(2000);
		driverUsers.findElement(By.xpath(".//*[@id='passwordNext']/content/span")).click();
		driverUsers.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		Thread.sleep(5000);

		driverUsers.findElement(By.xpath("//*[@class='ait']")).click();
		Thread.sleep(2000);
 
		List<WebElement> elementsAll = driverUsers.findElements(By.xpath("//*[@class='nU ']"));
		for(int j=0;j<elementsAll.size();j++)
		{
			 //System.out.println(elementsAll.get(j).getText());
	            if(elementsAll.get(j).getText().equals("All Mail"))
	            {  // if u want to click on the specific mail then here u can pass it
	            	elementsAll.get(j).click();
	            	break;
	            }	
		}
		Thread.sleep(2000);

		driverUsers.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    Thread.sleep(2000);

		// now talking un-read email form inbox into a list
		List<WebElement> readEmail = driverUsers.findElements(By.xpath("//*[@class='xY a4W']"));
		List<WebElement> senderEmail = driverUsers.findElements(By.xpath("//*[@class='yX xY ']"));
		//System.out.println(readEmail.size());
        for(int i=0;i<readEmail.size();i++){
        	 
             //System.out.println("\nEmail details: " + readEmail.get(i).getText());

            if(senderEmail.get(i).getText().matches("citizen.identity1(.*)"))
            {  // if u want to click on the specific mail then here u can pass it
            	System.out.println("\nSender of email: "+ senderEmail.get(i).getText());
            	
            	
            	readEmail.get(i).click();
        		List<WebElement> messages = driverUsers.findElements(By.xpath("//*[@class='gs']"));
        		for(int k=0;k<messages.size();k++)
        		{
        			 //System.out.println(messages.get(k).getText());
        			 Pattern linkPattern = Pattern.compile("https:\\/\\/blue\\.testlab\\.nhs\\.uk\\/auth\\/realms\\/Test\\/login-actions\\/execute-actions\\?key=(.+)");
                     Matcher pageMatcher = linkPattern.matcher(messages.get(k).getText());

                     while(pageMatcher.find())
                     {
                    	 link=pageMatcher.group();
                    	 System.out.println("Email details: " + messages.get(k).getText());
                     } 
                     /*
        	            if(messages.get(k).getText().matches("https:\\/\\/blue\\.testlab\\.nhs\\.uk\\/auth\\/realms\\/Test\\/login-actions\\/execute-actions\\?key=(.+)"))
        	            {  // if u want to click on the specific mail then here u can pass it
        	            	//elementsAll.get(k).click();
        	            	String linkArray[] = messages.get(k).getText().split("this process.");
        	            	link = linkArray[1];
        	            	break;
        	            }	*/
        		}
            	break;
            }
        }
        //account section of user 
    	driverUsers.findElement(By.xpath(".//*[@id='gb']/div[1]/div[1]/div[2]/div[5]/div[1]/a/span")).click();
		Thread.sleep(2000);
        
        //select sign out
        driverUsers.findElement(By.xpath(".//*[@id='gb']/div[1]/div[1]/div[2]/div[5]/div[2]/div[3]/div[2]")).click();
		Thread.sleep(3000);
		driverUsers.close();
		driverUsers.quit();
		return link;
	}
}
