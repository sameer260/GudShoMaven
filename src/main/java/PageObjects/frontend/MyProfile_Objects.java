package PageObjects.frontend;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import Resources.Base_setup;



public class MyProfile_Objects extends Base_setup {

	static By myProfileElement = By.xpath("//span[@class='username-open text-control']");
	static By getProfileName = By.xpath("//input[@id='profile-firstname']");
	static By getMobileNumber = By.xpath("//input[@id='phoneNumber']");
	static By userNameElement = By.xpath("//span[@class='username']");
	static By userNumberElement = By.xpath("//div[@class='user-no']");
	static By darkModeElement = By.xpath("//span[@class='mat-slide-toggle-content']");
	static By darkModeCheckBox = By.xpath("//div[@class='mat-slide-toggle-thumb']");
	static By accountsAndSettingsElement = By.xpath("//*[text()='Account & Settings']");
	static By helpElement = By.xpath("//*[text()='Help']");
	static By signOutElement = By.xpath("//*[text()='Sign out']");
	static By myStudio = By.xpath("//*[text()='My studio']");
	static By myProfileElementAssert = By.xpath("//*[text()='My Profile']");
	static By homePageAssert = By.xpath("//*[text()='All In One Place']");
	static By helpPageAssert = By
			.xpath("//*[text()='Want to learn more about the benefits & features of GudSho? Contact our team. ']");
	static By shoDetailPageAssert = By.xpath("//*[text()='... More']");
	static By studioDetailAssert = By.xpath("//*[text()='Share Via ']");
	static By myWatchHistory = By.xpath("//div[text()='My Watch History']");
	static By buyButton = By.xpath("//*[text()=' Buy ']");
	static By selectPaymentMethodElement = By.xpath("//*[text()='Select Payment Methods']");

	public static WebElement selectPaymentMethodElement() {
		return driver.findElement(selectPaymentMethodElement);

	}

	public static WebElement buyButton() {
		return driver.findElement(buyButton);

	}

	public static WebElement myWatchHistory() {
		return driver.findElement(myWatchHistory);

	}

	public static WebElement getMobileNumber() {
		return driver.findElement(getMobileNumber);

	}

	public static WebElement getProfileName() {
		return driver.findElement(getProfileName);

	}

	public static WebElement myProfileElement() {
		return driver.findElement(myProfileElement);

	}

	public static WebElement userNameElement() {
		return driver.findElement(userNameElement);

	}

	public static WebElement userNumberElement() {
		return driver.findElement(userNumberElement);

	}

	public static WebElement darkModeElement() {
		return driver.findElement(darkModeElement);

	}

	public static WebElement darkModeCheckBox() {
		return driver.findElement(darkModeCheckBox);

	}

	public static WebElement accountsAndSettingsElement() {
		return driver.findElement(accountsAndSettingsElement);

	}

	public static WebElement helpElement() {
		return driver.findElement(helpElement);

	}

	public static WebElement signOutElement() {
		return driver.findElement(signOutElement);

	}

	public static WebElement myStudio() {
		return driver.findElement(myStudio);

	}

	public static WebElement myProfileElementAssert() {
		return driver.findElement(myProfileElementAssert);

	}

	public static WebElement homePageAssert() {
		return driver.findElement(homePageAssert);

	}

	public static WebElement helpPageAssert() {
		return driver.findElement(helpPageAssert);

	}

	public static WebElement shoDetailPageAssert() {
		return driver.findElement(shoDetailPageAssert);

	}

	public static WebElement studioDetailAssert() {
		return driver.findElement(studioDetailAssert);

	}

}
