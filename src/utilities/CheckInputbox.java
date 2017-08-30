package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckInputbox 
{
	public static String validateInputbox(WebDriver driverCheckbox, String xpath)
	{	
		String textboxStatus = null;
		boolean elementStatus = utilities.CheckElement.existsElement(xpath,driverCheckbox);
		if(elementStatus)
		{
			WebElement inputBox = driverCheckbox.findElement(By.xpath(xpath));
			String textInsideInputBox = inputBox.getAttribute("placeholder");
			if(!textInsideInputBox.isEmpty())
			{
				textboxStatus = textInsideInputBox;
			}
			else
			{
				textboxStatus ="blank";

			}
			return textboxStatus;
		}
		else
		{
			return textboxStatus;
		}

	}
}
