package Steps.frontend;

import static org.junit.Assert.assertEquals;




import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

import PageObjects.frontend.Accountandsettings;
import PageObjects.frontend.Toastanderrormessages;
import Resources.Base_setup;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Accountandsettingssteps extends Base_setup
{
	public static Logger log=Logger.getLogger(Accountandsettingssteps.class.getName());
	Loginandsignupsteps ls=new Loginandsignupsteps();
	
	
	@Given("^Mouse hover on the profile icon lefside of the page$")
    public void mouse_hover_on_the_profile_icon_lefside_of_the_page() throws Throwable {
		Actions a=new Actions(driver);
        a.moveToElement(Accountandsettings.mousehoveronprofilem()).build().perform();
        log.info("Mouser hovered on profile");
    }
    @When("^Click on Account & Settings tab$")
    public void click_on_account_settings_tab() throws Throwable {
    	Accountandsettings.accountandsettingslinkm().click();
        log.info("Clicked on Account and Settings Link");
    }
    @Then("^Verify My profile is displaying$")
    public void verify_my_profile_is_displaying() throws Throwable {
        assertTrue(Accountandsettings.myprofiletabm().isDisplayed());
        log.info("My profile Tab is displayed");
        Thread.sleep(1000);
    }
    @Given("^invalid input in the name field as (.+)$")
    public void invalid_input_in_the_name_field_as(String name) throws Throwable {
    	Accountandsettings.firstnamem().clear();
    	Accountandsettings.firstnamem().sendKeys(name);
        log.info("Name entered in the field :" + name);
    }
    @When("^save the profile clicking on save button$")
    public void save_the_profile_clicking_on_save_button() throws Throwable {
    	Accountandsettings.savebuttonm().click();
        log.info("Clicked on save button");
        Thread.sleep(1500);
    }
    @Given("^invalid email in the email field as (.+)$")
    public void invalid_email_in_the_email_field_as(String emailid) throws Throwable {
    	Accountandsettings.emailidm().clear();
    	Accountandsettings.emailidm().sendKeys(emailid);
        log.info("Entered the Email ID in the Email field as:" + emailid);
    }
    @Given("^Give empty DOB in the field$")
    public void give_empty_dob_in_the_field() throws Throwable {
    	Accountandsettings.DOBfieldm().clear();
    	Accountandsettings.DOBfieldm().sendKeys(" ");
        log.info("Empty space entered in DOB field");
    }
    @Then("^date of birth (.+) will display$")
    public void date_of_birth_will_display(String errormessage) throws Throwable {
       String Actual= Toastanderrormessages.doberrormessagem().getText();
       log.info("The Errormessage is dispalyed in DOB field as:" + errormessage);
       assertEquals(Actual,errormessage);
    }
    @Then("^the name field should show (.+)$")
    public void the_name_field_should_show(String errormessage) throws Throwable {
        String Actual=Toastanderrormessages.namefiederrormsgm().getText();
        log.info("The error message show when enter wrong input in name field is:" + errormessage);
        assertEquals(Actual,errormessage);
    }
    @Then("^Set DOB using calendor icon as (.+) and (.+) and (.+)$")
    public void set_dob_using_calendor_icon_as_and_and(int year, String month, int date) throws Throwable {
    	Accountandsettings.calendericonm().click();
    	Accountandsettings.yearbuttonm().click();
    	Accountandsettings.prevoiusbuttonm().click();
    	Accountandsettings.selectcalenderm(year, month, date);
        log.info("Selected date of birth from calender icon:"+ date + month + year);
    }
    @Given("^Upload the profile picture which is having (.+)$")
    public void upload_the_profile_picture_which_is_having(String filename) throws Throwable {
    	Actions a=new Actions(driver);
    	a.moveToElement(Accountandsettings.uploadphotoiconm()).click().build().perform();
    	Thread.sleep(1000);
    	Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\Autoit\\"+filename+".exe");	
    	
    }
    @When("^Upload the image by clicking on submit button$")
    public void upload_the_image_by_clicking_on_submit_button() throws Throwable {
    	Accountandsettings.uploadsubmitm().click();
        log.info("Cliked on submit button while uploading image");
    }
    @When("^Upload the image by clicking on cancel button$")
    public void upload_the_image_by_clicking_on_cancel_button() throws Throwable {
    	Accountandsettings.uploadcancel().click();
    	assertTrue(Accountandsettings.myprofiletabm().isDisplayed());
    }
    @And("^complete the profile with (.+)and (.+) and (.+) and (.+)$")
    public void complete_the_profile_with_and_and_and(String name, String gender, String dob, String emailid) throws Throwable {
     	Accountandsettings.firstnamem().clear();
    	Accountandsettings.firstnamem().sendKeys(name);
    	log.info("Name as:" + name);
    	Accountandsettings.emailidm().clear();
    	Accountandsettings.emailidm().sendKeys(emailid);
        log.info("Email id as:" + name);
        Accountandsettings.DOBfieldm().clear();
        Accountandsettings.DOBfieldm().sendKeys(dob);
        log.info("DOB as:" + name);
        int size=Accountandsettings.genderm().size();
        for(int i=0;i<size;i++)
        {
        	String str=Accountandsettings.genderm().get(i).getText();
        	if(str.equalsIgnoreCase(gender))
        	{
        		JavascriptExecutor js=(JavascriptExecutor)driver;
        		js.executeScript("arguments[0].click();",Accountandsettings.genderradiom().get(i));
        		log.info("Clicked on gender radio button on "  +  gender);
        		break;
        	}
        }
        Accountandsettings.savebuttonm().click();
        
    }
    @Given("^Click on change password link$")
    public void click_on_change_password_link() throws Throwable {
    	Accountandsettings.changepasswordtabm().click();
        log.info("Cliked on Change password link");
        Thread.sleep(1500);
    }
    @When("^Enter old password as (.+)$")
    public void enter_old_password_as(String inputoldpassword) throws Throwable {
    	Accountandsettings.oldpasswordm().sendKeys(inputoldpassword);
        log.info("Entered password in oldpassword field as:" + inputoldpassword);
    }
    @Then("^Save the password$")
    public void save_the_password() throws Throwable {
    	Accountandsettings.savebuttonm().click();
        log.info("Cliked on save button");
        Thread.sleep(1500);
    }
    @And("^input (.+) and (.+)$")
    public void input_and(String inputnewpassword, String inputconfirmpassword) throws Throwable {
    	Accountandsettings.newpasswordm().sendKeys(inputnewpassword);
        log.info("Entered new password as :" + inputnewpassword);
        Accountandsettings.confirmpasswordm().sendKeys(inputconfirmpassword);
        log.info("Entered confirm password as :" + inputconfirmpassword);
        Thread.sleep(1000);
    }
    @When("^Check the all fields placeholders$")
    public void check_the_all_fields_placeholders() throws Throwable {
       int size=Accountandsettings.placeholdersinchangepassword().size();
       for(int i=0;i<size;i++)
       {
    	   String Actual=Accountandsettings.placeholdersinchangepassword().get(i).getText();
    	   log.info("The placeholder text in all place holders:" + Actual);
       }
    }
    
    
}
