/**
 * @author Kaushal Chandwani
 *
 */
package com.cucumber.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.cucumber.config.Constant;
import com.cucumber.utility.PropertyReader;


public class DriverFactory 
{
	protected static WebDriver driver;
	
	
	public DriverFactory() throws Exception {
        initialize();
    }

    public void initialize() throws Exception {
        if (driver == null)
            createNewDriverInstance();
    }

    private void createNewDriverInstance() throws Exception 
    {
    	
    	String browser = new PropertyReader().readProperty("browser");
    	if (browser.equals("chrome")) 
    	{
    		System.setProperty("webdriver.chrome.driver", "exe/chromedriver.exe"); //chromedriver.exe set property path
    		ChromeOptions options = new ChromeOptions();
    		options.addArguments("--start-maximized");
    		driver = new ChromeDriver(options);
            System.out.println("Chrome browser");

        } 
    	else if(browser.equals("internetexplorer"))  
    	{
    		System.setProperty("webdriver.ie.driver","exe/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
            driver.manage().window().maximize();
            System.out.println("Internet Explorer browser");

        }
    	
    	else if(browser.equals("internetexplorer"))  
    	{
    		System.setProperty("webdriver.ie.driver","exe/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
            driver.manage().window().maximize();
            System.out.println("Internet Explorer browser");

        }
    	else if(browser.equals("firefox")) 
      	{
      		System.setProperty("webdriver.gecko.driver", "exe/geckodriver.exe");
    		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
    		capabilities.setCapability("marionette", true);
    		driver = new FirefoxDriver(capabilities);
      		driver = new FirefoxDriver();
    		System.out.println("Mozilla Firefox browser");
    		driver.get("www.google.com");
    		
      	}
    	else 
    	{
    		 System.out.println("Can't read the browser");
    		 throw new Exception("Can't read the browser");
      	}
    	/*if(Constant.environmentVariable.equalsIgnoreCase("local"))
      	{
    		System.setProperty("webdriver.chrome.driver", "exe/chromedriver.exe"); //chromedriver.exe set property path
    		ChromeOptions options = new ChromeOptions();
    		options.addArguments("--start-maximized");
    		driver = new ChromeDriver(options);
    		
    	
    		
    		
      	}
      	else
      	{
      		System.setProperty("webdriver.gecko.driver", "exe/geckodriver.exe");
    		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
    		capabilities.setCapability("marionette", true);
    		driver = new FirefoxDriver(capabilities);
      	}
      	*/
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void destroyDriver() {
        driver.quit();
        driver = null;
    }
}
