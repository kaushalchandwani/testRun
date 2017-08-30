package executionEngine;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import actionKeywords.DeleteUsers;
import actionKeywords.VerifyEmail;
import config.constants;
import testReport.DisplayOrder;
import testReport.LogStatus;
import testReport.TestReports;
import utilities.CreateDirectory;

public class DriverScript 
{
	private static WebDriver driver = null;
	public static final TestReports executionReport = TestReports.get(DriverScript.class);

	public static void main(String[] args)
	{
		try
		{	
			 boolean userDeleted =false;
			
			//define variables
			String loginStatus = "";
        	//tabsFunctions.AccessPatientRecords.accessRecords(constants.URL_PATIENT_RECORDS);
			/*
			//define date format for test report folder and filename
			Date date = new Date();
			DateFormat dateFormat_report = new SimpleDateFormat("yyyyMMdd_HH_mm_ss");
			DateFormat dateFormat_folder = new SimpleDateFormat("yyyyMMdd");
			
			//define test report path and create test report folder 
			String ReportPath = constants.Path_Execution_Report + "TestExecutionReport_" + dateFormat_folder.format(date);
			CreateDirectory.createFolder(constants.Path_Execution_Report,"TestExecutionReport_" + dateFormat_folder.format(date)); //test report folder with date
			String testExecutionReport = "TestExecutionReport_" + dateFormat_report.format(date); //test report name with time stamp
			extent.init(ReportPath + "//" + testExecutionReport + ".html", true, DisplayOrder.BY_OLDEST_TO_LATEST);
			    */
			/*String host = "imap.gmail.com";
		    String mailStoreType = "imap";
		    String username = constants.Patient_email_id;
		    String password = constants.Patient_password;

		    AccessEmail.check(host, mailStoreType, username, password);*/
			
			String pathReport = "/report/report.html";
			executionReport.init("pathReport",true, DisplayOrder.BY_OLDEST_TO_LATEST);
			executionReport.startTest("TestCase 1: ","This is the test case to delete the user if it already exists");
			userDeleted = DeleteUsers.deleteUsersProfile();
			executionReport.endTest();
			
			if(userDeleted)
			{
				System.out.println("\nExisting user deleted succesfully");
			}
			else
			{
				System.out.println("\nuser not present");
			}
			
			boolean status = true;
	        if(status)
	        {
	        	/*
	        	 * //System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe"); //chromedriver.exe set property path
	        	 
	        	System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
	    		System.out.println("main-webdriver.chrome.driver:" + System.getProperty("webdriver.chrome.driver"));

				ChromeOptions options = new ChromeOptions(); 
				options.addArguments("--incognito"); //passing incognito as arguments
				options.addArguments("start-maximized"); //adding maximise
				DesiredCapabilities capabilities = DesiredCapabilities.chrome(); //Defining capabilities
				capabilities.setCapability(ChromeOptions.CAPABILITY, options); 
				
				//initialize chromedriver as webdriver
		        driver = new ChromeDriver(capabilities);
		        
		        */		        
	        	
	        	DesiredCapabilities firefoxCaps = new DesiredCapabilities().firefox();
	    		firefoxCaps.setJavascriptEnabled(true);
	    		WebDriver driver = new FirefoxDriver(firefoxCaps);
		        
		        driver.get(constants.URL_ADMIN);
		        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(By.xpath("html/body/div[1]/div/h3/a")).click();
		        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		        
			    		    
				driver.findElement(By.xpath(".//*[@id='username']")).sendKeys(constants.UserName_admin);
				driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(constants.Password_admin);	
				Thread.sleep(2000);
				driver.findElement(By.xpath(".//*[@id='kc-login']")).click();
			    Thread.sleep(2000);

				//NHS Digital page title
				//adminuser tab
				driver.findElement(By.xpath(".//*[@id='navbar']/ul[2]/li[1]/a")).click();
			    Thread.sleep(2000);
			    //profile tab
				driver.findElement(By.xpath(".//*[@id='navbar']/ul[2]/li[1]/ul/li/a")).click();
		        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			    Thread.sleep(2000);

		        //users bar click
				driver.findElement(By.xpath(".//*[@id='navbar']/ul[1]/li[1]/a")).click();
		        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			    Thread.sleep(2000);
		        
			    
			    //create user first page no-->continue--close --create user page 
		        driver.findElement(By.xpath("html/body/div[1]/table[1]/tbody/tr/td/a")).click();
		        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			    Thread.sleep(2000);
				//no 
		        driver.findElement(By.xpath(".//*[@id='accept2']")).click();
			    Thread.sleep(1000);
			    //continue
			    driver.findElement(By.xpath("html/body/form/div/div[3]/input")).click();
		        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			    Thread.sleep(2000);
			    //close button page
			    driver.findElement(By.xpath("html/body/div[1]/form/div/input")).click();
		        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			    Thread.sleep(2000);
			    
			    
			    //create user --first page yes--continue--second page no ---close button --create user page
			    driver.findElement(By.xpath("html/body/div[1]/table[1]/tbody/tr/td/a")).click();
		        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			    Thread.sleep(2000);
				//no
		        driver.findElement(By.xpath(".//*[@id='accept2']")).click();
			    Thread.sleep(1000);
			    //yes
		        driver.findElement(By.xpath(".//*[@id='accept1']")).click();
			    Thread.sleep(1000);
		        //continue
			    driver.findElement(By.xpath("html/body/form/div/div[3]/input")).click();
		        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			    Thread.sleep(2000);
			    //no
			    driver.findElement(By.xpath(".//*[@id='accept2']")).click();
			    Thread.sleep(1000);
			    //continue 
			    driver.findElement(By.xpath("html/body/form/div/div[2]/input")).click();
		        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			    Thread.sleep(2000);
			    //close button page
			    driver.findElement(By.xpath("html/body/div[1]/form/div/input")).click();
		        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			    Thread.sleep(2000);
			    

				//create user till end 
		        driver.findElement(By.xpath("html/body/div[1]/table[1]/tbody/tr/td/a")).click();
		        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			    Thread.sleep(2000);
				//no
		        driver.findElement(By.xpath(".//*[@id='accept2']")).click();
			    Thread.sleep(1000);
			    //yes
		        driver.findElement(By.xpath(".//*[@id='accept1']")).click();
			    Thread.sleep(1000);
		        //continue
			    driver.findElement(By.xpath("html/body/form/div/div[3]/input")).click();
		        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			    Thread.sleep(2000);
		        // no 
			    driver.findElement(By.xpath(".//*[@id='accept2']")).click();
			    Thread.sleep(1000);
			    //yes
			    driver.findElement(By.xpath(".//*[@id='accept1']")).click();
			    Thread.sleep(1000);
		        //continue 
			    driver.findElement(By.xpath("html/body/form/div/div[2]/input")).click();
		        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			    Thread.sleep(2000);
		        //back --> html/body/form/div/div[2]/button 
			    
			    //if yes and page of patient details
			    
			    //clear email and nhs no fields 
			    driver.findElement(By.xpath(".//*[@id='email']")).clear();
			    driver.findElement(By.xpath(".//*[@id='nhsNumber']")).clear();
				Thread.sleep(1000);

			    driver.findElement(By.xpath(".//*[@id='email']")).sendKeys(constants.Patient_email_id);
				Thread.sleep(1000);

				driver.findElement(By.xpath(".//*[@id='nhsNumber']")).sendKeys(constants.Patient_nhs_number);	
				Thread.sleep(2000);
				//reset 
			    // html/body/div[1]/form/input[2]
				driver.findElement(By.xpath("html/body/div[1]/form/input[2]")).click();
				Thread.sleep(2000);
				//again re enter
				driver.findElement(By.xpath(".//*[@id='email']")).clear();
			    driver.findElement(By.xpath(".//*[@id='nhsNumber']")).clear();
				Thread.sleep(1000);

				driver.findElement(By.xpath(".//*[@id='email']")).sendKeys(constants.Patient_email_id);
				Thread.sleep(1000);

				driver.findElement(By.xpath(".//*[@id='nhsNumber']")).sendKeys(constants.Patient_nhs_number);	
				Thread.sleep(2000);
			    //submit
			    //html/body/div[1]/form/input[1]
				driver.findElement(By.xpath("html/body/div[1]/form/input[1]")).click();
				//navigated to all user page
		        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		        System.out.println("\nNew User: "+constants.Patient_email_id + " created successfully\n");
			    Thread.sleep(3000);
			    
		        //logout // 
		        driver.findElement(By.xpath(".//*[@id='navbar']/ul[2]/li[2]/a")).click();
		        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			    Thread.sleep(2000);
			    //webdriver close and exit
				driver.close();
				driver.quit();
						
	        }
	        
	        String verifyLink = VerifyEmail.accessEmail();
	        if(verifyLink.isEmpty())
	        {
	        	
	        }
	        else
	        {
	        	tabsFunctions.AccountVerify.verifyUserAccount(verifyLink);
	        	tabsFunctions.AccessPatientRecords.accessRecords(constants.URL_PATIENT_RECORDS);
	        }
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			//webdriver close and exit
			driver.close();
			driver.quit();
					
		}
		


	}

}
