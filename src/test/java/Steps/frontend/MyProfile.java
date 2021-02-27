package Steps.frontend;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.frontend.MyProfile_Objects;
import Resources.Base_setup;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;


public class MyProfile extends Base_setup {
	
	public static Logger log = Logger.getLogger(MyProfile.class.getName());
	WebDriverWait wait = new WebDriverWait(driver, 30);

	String profName;
	String mobNum;

	

	@Then("^hover on my profile$")
	public void hover_on_my_profile() throws Throwable {
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.moveToElement(MyProfile_Objects.myProfileElement()).build().perform();
		log.info("hovering on my profile");

	}

	@And("^Navigate to my accounts and get profName and mobile number$")
	public void navigate_to_my_accounts_and_get_profname_and_mobile_number() throws Throwable {
		
		Actions actions = new Actions(driver);
		actions.moveToElement(MyProfile_Objects.myProfileElement()).build().perform();
		MyProfile_Objects.accountsAndSettingsElement().click();
		log.info("landed on accounts and settings");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		profName = (String) js.executeScript("return arguments[0].value;", MyProfile_Objects.getProfileName());
		log.info("The user profile name is :" +profName);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		mobNum = (String) js1.executeScript("return arguments[0].value;", MyProfile_Objects.getMobileNumber());
		log.info("The user mobile number is :" +mobNum);
		driver.navigate().back();
		log.info("navigating back");

	}

	@And("^Validate my prof username and mobile number element$")
	public void validate_my_prof_username_and_mobile_number_element() throws Throwable {
		wait.until(ExpectedConditions.visibilityOf(MyProfile_Objects.userNameElement()));
		assertTrue(profName.equalsIgnoreCase(MyProfile_Objects.userNameElement().getText()));
		log.info("asserting profile name" +profName+" == "+MyProfile_Objects.userNameElement().getText());
		wait.until(ExpectedConditions.visibilityOf(MyProfile_Objects.userNumberElement()));
		assertEquals(mobNum, MyProfile_Objects.userNumberElement().getText());
		log.info("asserting mobile number" +mobNum+" == "+MyProfile_Objects.userNumberElement().getText());
	}

	@And("^Validate dark them check box$")
	public void validate_dark_them_check_box() throws Throwable {
		Thread.sleep(1000);
		assertEquals("Light Mode", MyProfile_Objects.darkModeElement().getText());
		log.info("Asserting drak theme element " +MyProfile_Objects.darkModeElement().getText());
		MyProfile_Objects.darkModeCheckBox().click();
		boolean darkModeStatus = MyProfile_Objects.darkModeCheckBox().isEnabled();
		log.info("status of drak mode radio button: "+darkModeStatus);

	}

	@And("^Validate Account and setting, help, signOut and my studio$")
	public void validate_account_and_setting_help_signout_and_my_studio() throws Throwable {
		Thread.sleep(1000);
		assertEquals("Account & Settings", MyProfile_Objects.accountsAndSettingsElement().getText());
		log.info("asserting my profile elemets one by one");
		assertEquals("Help", MyProfile_Objects.helpElement().getText());
		assertEquals("Sign out", MyProfile_Objects.signOutElement().getText());
		

	}


	@And("^click on accounts and settings and verify page redirection$")
	public void click_on_accounts_and_settings_and_verify_page_redirection() throws Throwable {
		wait.until(ExpectedConditions.visibilityOf(MyProfile_Objects.accountsAndSettingsElement()));
		MyProfile_Objects.accountsAndSettingsElement().click();
		wait.until(ExpectedConditions.visibilityOf(MyProfile_Objects.myProfileElementAssert()));
		assertEquals("My Profile", MyProfile_Objects.myProfileElementAssert().getText());
		log.info("navigated to accounts and settings page");

	}

	@And("^Navigate back$")
	public void navigate_back() throws Throwable {
		driver.navigate().back();
		log.info("Navigated back");

	}

	@And("^Verify system should redirect home page$")
	public void verify_system_should_redirect_home_page() throws Throwable {
		Thread.sleep(1000);
		assertEquals("All In One Place", MyProfile_Objects.homePageAssert().getText());
		log.info("verifying the redirection");

	}

	@And("^click on help and verify page redirection$")
	public void click_on_help_and_verify_page_redirection() throws Throwable {
		wait.until(ExpectedConditions.visibilityOf(MyProfile_Objects.helpElement()));
		MyProfile_Objects.helpElement().click();
		wait.until(ExpectedConditions.visibilityOf(MyProfile_Objects.helpPageAssert()));
		assertEquals("Want to learn more about the benefits & features of GudSho? Contact our team.",
				MyProfile_Objects.helpPageAssert().getText());
		log.info("redirected to help page");
	}

	@And("^Verify system should redirect sho detail page$")
	public void verify_system_should_redirect_sho_detail_page() throws Throwable {
		Thread.sleep(500);
		MyProfile_Objects.shoDetailPageAssert().isDisplayed();
		log.info("redirected to sho detail page");

	}

	@And("^Verify system should redirect studio detail page$")
	public void verify_system_should_redirect_studio_detail_page() throws Throwable {
		Thread.sleep(500);
		MyProfile_Objects.studioDetailAssert().isDisplayed();
		log.info("redirected to studio detail page");
	}

	@Then("^Navigate to accounts and settings$")
	public void navigate_to_accounts_and_settings() throws Throwable {
		Actions actions = new Actions(driver);
		actions.moveToElement(MyProfile_Objects.myProfileElement()).build().perform();
		MyProfile_Objects.accountsAndSettingsElement().click();
		actions.moveToElement(MyProfile_Objects.myProfileElementAssert()).build().perform();
		log.info("Navigated to accounts and settings");
	}

	@And("^Verify system should redirect accounts and settings page$")
	public void verify_system_should_redirect_accounts_and_settings_page() throws Throwable {
		Thread.sleep(500);
		MyProfile_Objects.myProfileElementAssert().isDisplayed();
		log.info("redirected to accounts and settings");
	}

	@Then("^Navigate to help page$")
	public void navigate_to_help_page() throws Throwable {
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.moveToElement(MyProfile_Objects.myProfileElement()).build().perform();
		MyProfile_Objects.helpElement().click();
		actions.moveToElement(MyProfile_Objects.helpPageAssert()).build().perform();
		log.info("navigated to help page");
	}

	@And("^Verify system should redirect help page$")
	public void verify_system_should_redirect_help_page() throws Throwable {
		Thread.sleep(500);
		MyProfile_Objects.helpPageAssert().isDisplayed();
		log.info("redirected to the help pages");
	}
	@Then("^Click on buy button$")
    public void click_on_buy_button() throws Throwable {
		Thread.sleep(1000);
		MyProfile_Objects.buyButton().click();
		log.info("clicked on buy button");
		
	}
	@And("^Verify system should redirect payment page$")
    public void verify_system_should_redirect_payment_page() throws Throwable {
		Thread.sleep(500);
		MyProfile_Objects.selectPaymentMethodElement().isDisplayed();
	}

}
