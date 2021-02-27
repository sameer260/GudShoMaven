package Resources;

import java.text.ParseException;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import PageObjects.frontend.PayWall_Objects;


public class supportClass extends Base_setup {

	public static void elasticSearch(String searchName) throws Throwable {
		//PayWall_Objects.searchIcon().click();
		//PayWall_Objects.searchField().sendKeys(searchName);
		PayWall_Objects.newSearchField().sendKeys(searchName);
		Thread.sleep(2000);
		List<WebElement> listOptions = driver.findElements(By.tagName("mat-option"));
		for (WebElement searchFor : listOptions) {
			Thread.sleep(1000);
			searchFor.click();
			break;

		}

	}

	public static void playThisPromo(String promoName) throws Throwable {

		List<WebElement> allText = driver.findElements(By.tagName("h4"));
		for (WebElement itterateElements : allText) {

			if (itterateElements.getText().equalsIgnoreCase(promoName)) {
				System.out.println(itterateElements.getText());
				Actions actions = new Actions(driver);
				Thread.sleep(1000);
				actions.moveToElement(itterateElements).click().build().perform();
				break;
			}

		}

	}

	public static void scrollToButtom() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			Object lastHeight = js.executeScript("return document.body.scrollHeight");
			while (true) {
				js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
				Thread.sleep(2000);
				Object newHeight = js.executeScript("return document.body.scrollHeight");
				if (newHeight.equals(lastHeight)) {
					break;
				}
				lastHeight = newHeight;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void scrollDown() {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,300)");

	}

	public static void dragToEnd() throws InterruptedException {
		Thread.sleep(3000);
		Actions actions = new Actions(driver);
		actions.moveToElement(PayWall_Objects.playButton()).build().perform();
		Thread.sleep(1000);
		String totalSeconds = PayWall_Objects.getDuration().getText();
		String[] parts = totalSeconds.split(":");
		String part1 = parts[0];
		String part2 = parts[1];
		long totalMinutes = Long.parseLong(part1);
		long remainingSeconds = Long.parseLong(part2);
		long minToSeconds = TimeUnit.MINUTES.toSeconds(totalMinutes);
		long totalSeconds1 = minToSeconds + remainingSeconds;
		double finalSeconds = (double) totalSeconds1 / 10;
		int totalClick = (int) Math.round(finalSeconds);

		for (int i = 1; i <= totalClick; i++) {
			
			PayWall_Objects.playerForwardButton().click();
			
			

		}
	

	}
	
	public static void dragToEnd1() throws InterruptedException {
		String totalSeconds = PayWall_Objects.getDuration().getText();
		String currentdura = null;
		while(!totalSeconds.equals(currentdura))
		{
			try {
			PayWall_Objects.playerForwardButton().click();
			currentdura=driver.findElement(By.xpath("//div[@aria-label='Current time']")).getText();
			}
			catch(Exception e)
			{
				break;
			}
			
		}
	
	}
	public static String dateConversion(String inputPatter, String outPutPattern, String givenDate) throws ParseException {
		SimpleDateFormat inputFormat = new SimpleDateFormat(inputPatter);
		SimpleDateFormat outputFormat = new SimpleDateFormat(outPutPattern);
		
		Date date = null;
		String requiredDate = null;
		
		date = inputFormat.parse(givenDate);
		requiredDate = outputFormat.format(date);
		return requiredDate;

	}
	
	
	
	
	


}
