/**
 * @author Kaushal Chandwani
 *
 */
package com.cucumber.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cucumber.config.Constant;
import com.cucumber.utility.MessageBox;
public class DelayTest 
{


	  public WebDriver driver;
	
	  
	  public void delayMailExpiry() throws Exception 
	  {
		
		  MessageBox.printMessage("Wait time of 1 min to expire validate email.....",7000);
	  }
	  
	  

}
