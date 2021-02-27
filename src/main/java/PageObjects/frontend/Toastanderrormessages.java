package PageObjects.frontend;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Resources.Base_setup;

public class Toastanderrormessages extends Base_setup {

	
	private static By toastmessage=By.xpath("//div[@id='toast-container']//div//div");
	private static By alertdailog=By.xpath("//div[@role='alertdialog']");
	private static By erroralert=By.xpath("//div[@id='toast-container']/div/div");
	private static By errormessage=By.xpath("//div[@class='error ng-star-inserted']");
	private static By doberrormessage=By.xpath("//div[@class='error profile-dob ng-star-inserted']");
	private static By namefiederrormsg=By.xpath("//div[@class='error ng-star-inserted'][2]");
	private static By toastmessageclose=By.xpath("//div[@id='toast-container']//div//button");
	
	public static WebElement toastmessagem() throws InterruptedException
	{
		Thread.sleep(1200);
	 return driver.findElement(toastmessage);
	 
	}
	public static WebElement toastmessageclosem()
	{
		return driver.findElement(toastmessageclose);
	}
	public static WebElement alerdailogm()
	{
    return driver.findElement(alertdailog);
	}
	public static WebElement erralerdailogm()
	{
	  return driver.findElement(erroralert);
	}
	public static WebElement errormessagem()
    {
    	return driver.findElement(errormessage);
    }
	public static WebElement doberrormessagem()
	{
		return driver.findElement(doberrormessage);
	}
	public static WebElement namefiederrormsgm()
	{
		return driver.findElement(namefiederrormsg);
	}
}
