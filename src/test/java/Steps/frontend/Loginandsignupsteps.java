package Steps.frontend;


import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Scanner;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;

import PageObjects.frontend.Loginandsignup;
import PageObjects.frontend.Toastanderrormessages;
import Resources.Base_setup;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class Loginandsignupsteps extends Base_setup
{
	 public static Logger log=Logger.getLogger(Loginandsignupsteps.class.getName());
	 Loginandsignup ls=new Loginandsignup();
	 Toastanderrormessages tm=new Toastanderrormessages();
	 Base_setup b=new Base_setup();
	 
	 
	 @When("^Login into the application with (.+) and (.+)$")
	    public void login_into_the_application_with_and(String phonenumber, String password) throws Throwable {
		 ls.phoneemailfieldm().sendKeys(phonenumber);
		 ls.passwordfieldm().sendKeys(password);
	    }

	    @Then("^Click on loginbutton$")
	    public void click_on_loginbutton() throws Throwable {
	    	ls.signinutton().click();
			 tm.toastmessageclosem().click();
	    }
	 
	 
	 
	 
	 
	    @Given("^Launch the browser and go to login page$")
	    public void launch_the_browser_and_go_to_login_page() throws Throwable {
	    	    b.intiliazedriver();
	    	    log.info("Driver intialised");
			    ls.signinlinkm().click();
			    log.info("Cliked on Sign in Link");
	    }
	@Given("^enter the (.+) and (.+) in the fields$")
    public void enter_the_and_in_the_fields(String phonenumber, String password) throws Throwable {
		ls.phoneemailfieldm().sendKeys(phonenumber);
		log.info("Username Entered in username field:" + phonenumber);
		ls.passwordfieldm().sendKeys(password);
		log.info("Username Entered in password field:" + password);
    }
	@When("^click on submit button$")
    public void click_on_submit_button() throws Throwable {
        ls.signinutton().click();
        log.info("Clicked on Signin/Submit button to Login into the application");
        Thread.sleep(2000);
    }
	@Then("^The Signin button and requestotp button should be displayed$")
    public void the_signin_button_and_requestotp_button_should_be_displayed() throws Throwable {
        Assert.assertTrue(ls.signinutton().isDisplayed());
        log.info("The Sign in button displayed");
        Assert.assertTrue(ls.requestOTPbuttonm().isDisplayed());
        log.info("The requestOTP button dispalyed");
    }
	@Then("^in email field verify the placeholder$")
    public void in_email_field_verify_the_placeholder() throws Throwable {
        String Actual=ls.placeholderofphemailm().getText();
        log.info("Email field placeholder:" + Actual);
        Assert.assertEquals(Actual,"Email ID/Mobile number");
    }
    @Then("^in password field verify the placeholder$")
    public void in_password_field_verify_the_placeholder() throws Throwable {
        String Actual=ls.placeholderofpasswordm().getText();
        log.info("password field placeholder:" + Actual);
        Assert.assertEquals(Actual,"Password");
    }
    @Then("^the forgotpassword link will display$")
    public void the_forgotpassword_link_will_display() throws Throwable {
        Assert.assertTrue(ls.forgotpasswordlinkm().isDisplayed());
        String Actual=ls.forgotpasswordlinkm().getText();
        log.info("Forgot password text is:" + Actual);
        Assert.assertEquals(Actual,"Forgot?");
    }
    @Then("^the Signup label or link should be display$")
    public void the_signup_label_or_link_should_be_display() throws Throwable {
       Assert.assertTrue(ls.signuplinkm().isDisplayed());
       String Actual=ls.signuplinkm().getText();
       log.info("Signup link text is displayed as:" + Actual);
       Assert.assertEquals(Actual, "SIGN UP");
    }
    @Then("^the facebook and gmail login should be display$")
    public void the_facebook_and_gmail_login_should_be_display() throws Throwable {
    	Assert.assertTrue(ls.facebookloginm().isDisplayed());
    	log.info("The facebook button is displayed");
    	Assert.assertTrue(ls.gmailloginm().isDisplayed());
    	log.info("The gnail button is displayed");
    }
    @Then("^the Signin and request otp buttons should be disabled before input$")
    public void the_signin_and_request_otp_buttons_should_be_disabled_before_input() throws Throwable {
        assertFalse(ls.signinutton().isEnabled());
        assertFalse(ls.requestOTPbuttonm().isEnabled());
    }
    @Given("^enter the (.+) in the emailfield$")
    public void enter_the_in_the_emailfield(String phonenumber) throws Throwable {
        ls.phoneemailfieldm().sendKeys(phonenumber);
        log.info("Username entered in :" + phonenumber);
    }

    @When("^press or remove the one letter or number$")
    public void press_or_remove_the_one_letter_or_number() throws Throwable {
        ls.phoneemailfieldm().sendKeys(Keys.BACK_SPACE);
        log.info("Backspace clicked");
        
    }
    @Given("^give space in the mail field$")
    public void give_space_in_the_mail_field() throws Throwable {
       ls.phoneemailfieldm().sendKeys(Keys.SPACE);
       log.info("Given Space as input");
    }
    @Given("^give (.+) in the mobile field$")
    public void give_in_the_mobile_field(String phonenumber) throws Throwable {
        ls.phoneemailfieldm().sendKeys(phonenumber);
        log.info("Phone number given as:" + phonenumber);
    }
    @When("^give backspace in both email and paswword$")
    public void give_backspace_in_both_email_and_paswword() throws Throwable {
        ls.passwordfieldm().sendKeys(Keys.BACK_SPACE);
        log.info("Backspace clicked");
    }
    @Then("^the sigin and requestotps buttons showuld be enable$")
    public void the_sigin_and_requestotps_buttons_showuld_be_enable() throws Throwable {
        assertTrue(ls.signinutton().isEnabled());
        assertTrue(ls.requestOTPbuttonm().isEnabled());
    }
    @When("^Clear the fields$")
    public void clear_the_fields() throws Throwable {
       ls.phoneemailfieldm().clear();
       ls.passwordfieldm().clear();
    }
    @Then("^The eye icon should be displayed$")
    public void the_eye_icon_should_be_displayed() throws Throwable {
        assertTrue(ls.eyeicondisplaym().isDisplayed());
    }
    @And("^Click on the eye icon$")
    public void click_on_the_eye_icon() throws Throwable {
        ls.eyeicondisplaym().click();
        String Actual=ls.eyeicondisplaym().getAttribute("style");
        assertEquals(Actual,"display: none;");
        ls.eyeiconblockm().click();
        String expected=ls.eyeicondisplaym().getAttribute("style");
        assertEquals(expected,"display: block;");
    }
    @Then("^it will redirect tologin page there should display text and ph number field$")
    public void it_will_redirect_tologin_page_there_should_display_text_and_ph_number_field() throws Throwable {
        assertTrue(ls.firsttimeloginm().isDisplayed());
        String Actual=ls.firsttimeloginm().getText();
        assertEquals(Actual,"We haven't met yet!");
        log.info("The heading is dispalyed as:" + Actual);
        assertTrue(ls.signinlinkinsignupm().isDisplayed());
        assertTrue(ls.getotpbuttoninsignupm().isDisplayed()); 
    }
    @And("^Click on sigin link it should redirect again to back$")
    public void click_on_sigin_link_it_should_redirect_again_to_back() throws Throwable {
        ls.signinlinkinsignupm().click();
        log.info("Clicked on signin link");
        assertTrue(ls.phoneemailfieldm().isDisplayed());
    }
    @When("^click on request otp$")
    public void click_on_request_otp() throws Throwable {
        ls.requestOTPbuttonm().click();
        log.info("Cliked on request OTP button");
    }
    @Then("^enter otp in the otp field$")
    public void enter_otp_in_the_otp_field() throws Throwable {
        Scanner sc1=new Scanner(System.in);
        log.info("Enter the OTP");
		String input = sc1.nextLine();
		ls.OTPinputm().sendKeys(input);
		log.info("OTP given as :" + input);
    }
    @When("^click on forgot link$")
    public void click_on_forgot_link() throws Throwable {
        ls.forgotpasswordlinkm().click();
        log.info("Cliked on forgot password link");
    }
    @And("^check the (.+) is displaying correctly and click on otp button$")
    public void check_the_is_displaying_correctly_and_click_on_otp_button(String phonenumber) throws Throwable {
        ls.Phonenumberinsignupm().getText();
        log.info("Phone number displaying :" + phonenumber);
    }
    @And("^Cick on getotp button$")
    public void cick_on_getotp_button() throws Throwable {
        ls.getotpbuttoninsignupm().click();
        log.info("Cliked on getotp button");
        Thread.sleep(3000);
    }
    @Given("^click on sign up link$")
    public void click_on_sign_up_link() throws Throwable {
        ls.signuplinkm().click();
        log.info("Cliked on Signu link");
        Thread.sleep(2000);
    }
    @Then("^Enter the (.+)$")
    public void enter_the(String phonenumber) throws Throwable {
       ls.phonenumberfieldinsignuppagem().sendKeys(phonenumber);
       log.info("Entered the phone number as:" + phonenumber);
    }
    @Given("^Click on geo location$")
    public void click_on_geo_location() throws Throwable {
       ls.geolocationbuttonm().click();
       log.info("Clicked on GEO location");
    }
    @Then("^enter the (.+) in search field$")
    public void enter_the_in_search_field(String countryname) throws Throwable {
        ls.searchingeolocationm().sendKeys(countryname);
        log.info("Searched the country name as:" + countryname);
    }
    @Then("^check the oldpassword is working or not$")
    public void check_the_oldpassword_is_working_or_not() throws Throwable {
    	ls.signinlinkm().click();
	    log.info("Cliked on Sign in Link");
    }


    
    
    
    
    
    
  
	

	

	

	@Then("^verify all login page elements$")
	public void verify_all_login_page_elements() throws Throwable {
		//b.pom();
		
		//Loginandsignup.flickSignIn.click();
		
		assertEquals("Hello there!", Loginandsignup.helloThere.getText());
		assertEquals("Nice to see you! Sign in now & lets get started.", Loginandsignup.niceTosee.getText());
		assertEquals("Email ID/Mobile number", Loginandsignup.mobileNumber.getText());
		assertEquals("Password", Loginandsignup.password.getText());
		assertEquals("Forgot?", Loginandsignup.forgot.getText());
		assertEquals("OR SIGNIN USING", Loginandsignup.signinUsing.getText());
		assertEquals("Facebook", Loginandsignup.faceBook.getText());
		assertEquals("Google", Loginandsignup.google.getText());
		assertEquals("New to GudSho?", Loginandsignup.newToGudsho.getText());
		assertEquals("SIGN UP", Loginandsignup.signUp.getText());

	}

	@Then("^verify all login page buttons$")
	public void verify_all_login_page_buttons() throws Throwable {

		assertEquals("Sign In", Loginandsignup.SignInButton.getText());
		assertEquals("Request OTP", Loginandsignup.requestOTP.getText());
		driver.close();
	}

	@When("^Verify all screen elemets$")
	public void verify_all_screen_elemets() throws Throwable {
		
		//b.pom();
		//Loginandsignup.flickSignIn.click();
		Thread.sleep(3000);
		Loginandsignup.signUp.click();
		assertEquals("Create your account", Loginandsignup.createElement.getText());
		assertEquals("Sign up for free & get wrapped with multiple engagement factors of GudSho!",
				Loginandsignup.singupElement.getText());
		assertEquals("Mobile number", Loginandsignup.mobileNumberSignupElement.getText());
		assertEquals("Get OTP", Loginandsignup.getOTPbutton1.getText());
		assertEquals("Already on GudSho?", Loginandsignup.alreadyElement.getText());
		assertEquals("SIGN IN", Loginandsignup.signInElement.getText());
		driver.close();
	


	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@When("^Sign in button$")
    public void sign_in_button() throws Throwable {
		Loginandsignup ls=new Loginandsignup();
		ls.signinlinkm().click();
    }

    @Then("^username and password and login$")
    public void username_and_password_and_login() throws Throwable {
    	Loginandsignup ls=new Loginandsignup();
    	ls.phoneemailfieldm().sendKeys("9677225941");
		 ls.passwordfieldm().sendKeys("pass@123");
		 ls.signinutton().click();
		 Toastanderrormessages.toastmessageclosem().click();
    }
}
