package PageObjects.frontend;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import Resources.Base_setup;



public class MyWatchHistoryObjects extends Base_setup{
	
	static By DetailPageShoTypeLabel = By.xpath("//*[@class='clearfix']//self::span");
	static By watchHistoryShoTypeLabel = By.xpath("//ul[@class='history-contene']//self::span");
	static By clearAllButton = By.xpath("//*[text()='Clear All']");
	static By clearAllButtonElements1 = By.xpath("//*[text()=' Confirmation']");
	static By clearAllButtonElements2 = By.xpath("//*[text()='Are you sure want to clear watch history?']");
	static By clearAllNoButton = By.xpath("//*[text()=' No ']");
	static By clearAllYesButton = By.xpath("//*[text()=' Yes ']");
	static By watchHistoryElement1 = By.xpath("//*[text()='My Watch History']//following::h4");
	static By watchHistoryElement2 = By.xpath("//*[text()='Huh, its likely that you havent watched anything yet!']");
	static By watchHistoryElement3 = By.xpath("//*[text()='Go ahead and start watching and let us show you your viewing history here']");
	static By startWatchButton = By.xpath("//span[text()='Start Watch']");
	
	public static WebElement watchHistoryElement1() {
		return driver.findElement(watchHistoryElement1);

	}
	
	public static WebElement watchHistoryElement2() {
		return driver.findElement(watchHistoryElement2);

	}
	
	public static WebElement watchHistoryElement3() {
		return driver.findElement(watchHistoryElement3);

	}
	
	public static WebElement startWatchButton() {
		return driver.findElement(startWatchButton);

	}
	
	
	
	public static WebElement clearAllButton() {
		return driver.findElement(clearAllButton);

	}
	public static WebElement clearAllButtonElements1() {
		return driver.findElement(clearAllButtonElements1);

	}
	public static WebElement clearAllButtonElements2() {
		return driver.findElement(clearAllButtonElements2);

	}
	public static WebElement clearAllNoButton() {
		return driver.findElement(clearAllNoButton);

	}public static WebElement clearAllYesButton() {
		return driver.findElement(clearAllYesButton);

	}
	public static WebElement DetailPageShoTypeLabel() {
		return driver.findElement(DetailPageShoTypeLabel);

	}
	
	public static WebElement watchHistoryShoTypeLabel() {
		return driver.findElement(watchHistoryShoTypeLabel);

	}
	

}
