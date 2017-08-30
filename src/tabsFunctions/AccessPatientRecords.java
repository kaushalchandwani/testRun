package tabsFunctions;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import config.constants;

public class AccessPatientRecords 
{
	public static void accessRecords(String patientRecordsLink) throws Exception
	{
		
		
		DesiredCapabilities firefoxCaps = new DesiredCapabilities().firefox();
		firefoxCaps.setJavascriptEnabled(true);
		WebDriver driverRecords = new FirefoxDriver(firefoxCaps);
		
		driverRecords.get(patientRecordsLink);
		driverRecords.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);
		
		
		driverRecords.findElement(By.xpath(".//*[@id='username']")).sendKeys(constants.Patient_email_id);
		Thread.sleep(2000);

		driverRecords.findElement(By.xpath(".//*[@id='password']")).sendKeys(constants.Patient_password);	
		Thread.sleep(2000);
		
		driverRecords.findElement(By.xpath(".//*[@id='kc-login']")).click();
		driverRecords.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);
		//navigation bar
		driverRecords.findElement(By.xpath(".//*[@id='navbar']/ul[2]/li/a")).click();
		Thread.sleep(2000);
		//profile
		driverRecords.findElement(By.xpath(".//*[@id='navbar']/ul[2]/li/ul/li[1]/a")).click();
		Thread.sleep(2000);
		//back 
		driverRecords.findElement(By.xpath("html/body/div[1]/button")).click();
		Thread.sleep(2000);
		//navigation bar
		driverRecords.findElement(By.xpath(".//*[@id='navbar']/ul[2]/li/a")).click();
		Thread.sleep(2000);
		//logout
		driverRecords.findElement(By.xpath(".//*[@id='navbar']/ul[2]/li/ul/li[2]/a")).click();
		Thread.sleep(3000);
		
		System.out.println("\n\nUser successfully logged to NHS portal with verified credentials");

		driverRecords.close();
		driverRecords.quit();
		
	}
	
	
}
