package utilities;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FetchTable 
{
	public static void fetchWebtableRecords(WebDriver driverRecords, String xpath)
	{

		List<WebElement> rows =   (List<WebElement>) driverRecords.findElements(By.xpath(".//*[@id='record-view']/table/tbody/tr"));
		int countRows = rows.size();
		System.out.println("ROW COUNT : "+countRows);
		
		List<WebElement> columns = driverRecords.findElements(By.xpath(".//*[@id='record-view']/table/tbody/tr[2]/td"));
		int countColumns = columns.size();
		System.out.println("ROW COUNT : "+countColumns);

		
		String sRowValue = "Allergies";
		String sColumnValue ="";
		int k=1;
		for (int i=1;i<=countRows;i++)
		{
			//String sValue = null;
			//sValue = driverRecords.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[" + i + "]/th")).getText();
				//if(sValue.equalsIgnoreCase(sRowValue))
				//{
					// If the sValue match with the description, it will initiate one more inner loop for all the columns of 'i' row 
				driverRecords.navigate().refresh();
				driverRecords.findElement(By.xpath(xpath)).click();
				
				driverRecords.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				List<WebElement> columnTable = driverRecords.findElements(By.xpath(".//*[@id='record-view']/table/tbody/tr[" + i + "]/td"));
				int countColumns1 = columns.size();
				String columnTagName = "td";
				/*if(countColumns1==0)
				{
					List<WebElement> columnHeader = driverRecords.findElements(By.xpath(".//*[@id='record-view']/table/tbody/tr[" + i + "]/th"));
					countColumns1 = columnHeader.size();
					columnTagName = "th";
				}*/
				//System.out.println("ROW COUNT : "+countColumns1);
				String summaryDescription = "";
				//handeling alerts---popup xpath for logout 
				//.//*[@id='ButtonTimeoutStay']
				//.//*[@id='ButtonTimeoutLogout']
				
				//((JavascriptExecutor)driverRecords).executeScript("window.confirm = function(msg){return false;};");
				
					for (int j=1;j<=countColumns1;j++)
					{
						
						
						String xpathVariable =".//*[@id='record-view']/table/tbody/tr[" + i + "]/td["+ j +"]";
						boolean elementStatus = utilities.CheckElement.existsElement(xpathVariable,driverRecords);
						if(elementStatus)
						{
							sColumnValue= driverRecords.findElement(By.xpath(xpathVariable)).getText();
							
							summaryDescription = summaryDescription + "  " + sColumnValue;
							
						}
						else
						{
							xpathVariable =".//*[@id='record-view']/table/tbody/tr[" + i + "]/th";
							elementStatus = utilities.CheckElement.existsElement(xpathVariable,driverRecords);
							if(elementStatus)
							{
								sColumnValue= driverRecords.findElement(By.xpath(xpathVariable)).getText();
								System.out.println(k+"). "+sColumnValue+":");
								k++;
								break;
							}
							else
							{
								/*xpathVariable =".//*[@id='record-view']/table/tbody/tr[" + i + "]/td";
								elementStatus = utilities.CheckElement.existsElement(xpathVariable,driverRecords);
								if(elementStatus)
								{
									sColumnValue= driverRecords.findElement(By.xpath(xpathVariable)).getText();
									System.out.println(sColumnValue);
									break;
								}
								else
								{
									System.out.println("No data found !");
								}*/
								//System.out.println("-------");
							}
						}
						
						
						
					}
					System.out.println(summaryDescription);
				//break;
				//}
			}
	}

}
