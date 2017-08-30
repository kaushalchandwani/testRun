package tabsFunctions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import config.constants;

public class AccountVerify 
{
	public static void verifyUserAccount(String verifyEmailLink) throws Exception
	{
		
		
		DesiredCapabilities firefoxCaps = new DesiredCapabilities().firefox();
		firefoxCaps.setJavascriptEnabled(true);
		WebDriver driverUsers = new FirefoxDriver(firefoxCaps);
		
		
		driverUsers.get(verifyEmailLink);
		driverUsers.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);

		
		System.out.println("\n\nEmail Verification Message : " + driverUsers.findElement(By.xpath(".//*[@id='kc-header-wrapper']")).getText());
		driverUsers.findElement(By.xpath(".//*[@id='kc-info-message']/p[2]/a")).click();

		driverUsers.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);
		
		driverUsers.findElement(By.xpath(".//*[@id='username']")).sendKeys(constants.Patient_email_id);
		Thread.sleep(2000);

		driverUsers.findElement(By.xpath(".//*[@id='password']")).sendKeys(constants.Patient_password);	
		Thread.sleep(2000);
		
		driverUsers.findElement(By.xpath(".//*[@id='kc-login']")).click();
		driverUsers.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);
		
		String verifyPage = driverUsers.findElement(By.xpath("html/body/div[1]/h1")).getText();
		driverUsers.findElement(By.xpath("html/body/div[1]/input")).click();
		Thread.sleep(3000);
		
		String verifySuccessMessage = driverUsers.findElement(By.xpath("html/body/div[1]/h1")).getText();
		
		driverUsers.findElement(By.xpath(".//*[@id='navbar']/ul/li[2]/a")).click();
		System.out.println("\n\nAccount Verified with message: "+ verifySuccessMessage);
		//System.out.println("\nVerification Message: " + verifySuccessMessage);
		
		Thread.sleep(3000);

		
		
		
		
		driverUsers.close();
		driverUsers.quit();
		
	}
}
