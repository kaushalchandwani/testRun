package TestPackage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;



public class TestingJobs 
{
	@Test
	public static void testJenkins() throws Exception
	{
		System.out.println("Welcome to jenkins World");
		/*
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setJavascriptEnabled(true);
		caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "D:\\Softwares\\Webdriver Phantom JS and ghostdriver\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
		
		WebDriver driver = new PhantomJSDriver(caps);
		*/
		WebDriver driver = null;
		//System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe"); //chromedriver.exe set property path
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver"); //chromedriver.exe set property path

		
		driver = new ChromeDriver();
		
		driver.get("https://google.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		System.out.println("Title: "+ driver.getTitle());
		Thread.sleep(1000);
		
		ScreenShots.createScreenshot(driver, "evidence");
		Thread.sleep(1000);

		List<WebElement> allLinks  = driver.findElements(By.tagName("a"));
		for(WebElement links: allLinks)
		{
			System.out.println("Link text: "+links.getText());
		}
		driver.manage().deleteAllCookies();
		driver.close();
		driver.quit();
		
	}

}
