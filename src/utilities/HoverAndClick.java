package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HoverAndClick 
{
	public static void hoverObject(WebDriver driverObject,String hoverlinkPath, String selectlinkPath)
	
	{
		Actions builder = new Actions(driverObject);
		builder.moveToElement(driverObject.findElement(By.xpath(".//*[@id='LinkSettings']"))).moveToElement(driverObject.findElement(By.xpath(".//*[@id='navigation']/nav/ul/li[4]/ul/li[2]/a"))).click().perform();
		
		//return driverObject;
		
	}
}
