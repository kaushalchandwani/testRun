package TestPackage;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;


import java.io.File;


public class ScreenShots 
{

	public static void createScreenshot(WebDriver driver,String ScreenShotName) throws Exception 
	{
	 
		String Path_ScreenShots = "D://Selenium & Java Workspace//JenkinsIntegration//src//screenshots//";
	    // generate screenshot as a file object
	    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    try 
	    {	
	    	// copy file object to designated location
			FileUtils.copyFile(scrFile, new File(Path_ScreenShots + ScreenShotName + ".png"));
			
	    } 
	    catch (Exception e) 
	    {
	        System.out.println("Error while generating screenshot");
	        throw (e);
	    }
	    
	}

}
