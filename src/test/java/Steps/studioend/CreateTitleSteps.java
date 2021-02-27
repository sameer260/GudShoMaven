package Steps.studioend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.Streams;

import PageObjects.frontend.Toastanderrormessages;
import PageObjects.studioend.CreateTitle;
import Resources.Base_setup;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.tlh.ach;
import junit.framework.Assert;

public class CreateTitleSteps extends Base_setup
{
	   public static Logger log=Logger.getLogger(CreateTitleSteps.class.getName()); 
	   CreateTitle ct=new CreateTitle();
	   WebDriverWait wait=new WebDriverWait(driver,20);
	   JavascriptExecutor js=(JavascriptExecutor)driver;
	   
	   @Given("^Check Create Title button is available and Enabled$")
	    public void check_create_title_button_is_available_and_enabled() throws Throwable {
	        assertTrue(CreateTitle.CreateTitleButton.isDisplayed());
	        assertTrue(CreateTitle.CreateTitleButton.isEnabled());
	    }

	    @When("^Mouse hover on Create Title button$")
	    public void mouse_hover_on_create_title_button() throws Throwable {
	       Actions a=new Actions(driver);
	       a.moveToElement(CreateTitle.CreateTitleButton).build().perform();
	    }

	    @Then("^Capture all buttons and verify its displaying correctly$")
	    public void capture_all_buttons_and_verify_its_displaying_correctly() throws Throwable {
	        String CreateShoText=CreateTitle.ListDropDown.get(0).getText();
	        log.info(CreateShoText);
	        assertEquals(CreateShoText, "Create Sho");
	        String ScheduleShoText= CreateTitle.ListDropDown.get(1).getText();
	        log.info(ScheduleShoText);
	        assertEquals(ScheduleShoText, "Create Series");
	        String CreateSeriesText=CreateTitle.ListDropDown.get(2).getText();
	        log.info(CreateSeriesText);
	        assertEquals(CreateSeriesText, "Schedule Sho");
	        String ScheduleSeriesText= CreateTitle.ListDropDown.get(3).getText();
	        log.info(ScheduleSeriesText);
	        assertEquals(ScheduleSeriesText, "Schedule Series");        
	    }
	   
	    @When("^Click on (.+) to create title$")
	    public void click_on_to_create_title(String shotype) throws Throwable {
	        for(int i=0;i<CreateTitle.ListDropDown.size();i++)
	        {
	        	if(CreateTitle.ListDropDown.get(i).getText().equalsIgnoreCase(shotype))
	        	{
	        		CreateTitle.ListDropDown.get(i).click();
	        	}
	        }
	    }
	    @Then("^Check redirection will be (.+)$")
	    public void check_redirection_will_be(String headers) throws Throwable {
	    	wait.until(ExpectedConditions.visibilityOf(CreateTitle.Insidetheheadder));
	    	Thread.sleep(1000);
	        String Header=CreateTitle.Insidetheheadder.getText();
	        log.info(Header);
	        assertEquals(Header,headers);
	    }

	    @And("^Description should be (.+)$")
	    public void description_should_be(String description) throws Throwable {
	    	 String Description=CreateTitle.Description.getText();
		        log.info(Description);
		        assertEquals(Description,description);
	    }
	    @Then("^Should display all the fields$")
	    public void should_display_all_the_fields() throws Throwable {
	        for(int i=0;i<CreateTitle.AllSectionsInCreateSho.size();i++)
	        {
	        	assertTrue(CreateTitle.AllSectionsInCreateSho.get(i).isDisplayed());
	        	log.info(CreateTitle.AllSectionsInCreateSho.get(i).getText());
	        }
	    }
	    @And("^first section name is \"([^\"]*)\" and (.+)$")
	    public void first_section_name_is_something_and(String shoorseries, String sectionanemexp) throws Throwable {
	    	String sectionname=CreateTitle.AllSectionsInCreateSho.get(0).getText();
	    	log.info(sectionname);
	    	log.info(shoorseries+sectionanemexp);
	    	assertEquals(sectionname, shoorseries+sectionanemexp);
	    	
	    }

	    @And("^second section name is \"([^\"]*)\" and (.+)$")
	    public void second_section_name_is_something_and(String shoorseries, String sectionanemexp) throws Throwable {
	    	String sectionname=CreateTitle.AllSectionsInCreateSho.get(1).getText();
	    	log.info(sectionname);
	    	log.info(shoorseries+sectionanemexp);
	    	assertEquals(sectionname, shoorseries+sectionanemexp);
	    }

	    @And("^third section name is \"([^\"]*)\" and (.+)$")
	    public void third_section_name_is_something_and(String shoorseries, String sectionanemexp) throws Throwable {
	    	String sectionname=CreateTitle.AllSectionsInCreateSho.get(2).getText();
	    	log.info(sectionname);
	    	log.info(shoorseries+sectionanemexp);
	    	assertEquals(sectionname, shoorseries+sectionanemexp);
	    }

	    @And("^fourth section name is \"([^\"]*)\" and (.+)$")
	    public void fourth_section_name_is_something_and(String shoorseries, String sectionanemexp) throws Throwable {
	    	String sectionname=CreateTitle.AllSectionsInCreateSho.get(3).getText();
	    	log.info(sectionname);
	    	log.info(shoorseries+sectionanemexp);
	    	assertEquals(sectionname, shoorseries+sectionanemexp);
	    }

	    @And("^fivth section name is \"([^\"]*)\" and (.+)$")
	    public void fivth_section_name_is_something_and(String shoorseries, String sectionanemexp) throws Throwable {
	    	String sectionname=CreateTitle.AllSectionsInCreateSho.get(4).getText();
	    	log.info(sectionname);
	    	log.info(shoorseries+sectionanemexp);
	    	assertEquals(sectionname, shoorseries+sectionanemexp);
	    }

	    @And("^sixth section name is \"([^\"]*)\" and (.+)$")
	    public void sixth_section_name_is_something_and(String shoorseries, String sectionanemexp) throws Throwable {
	    	String sectionname=CreateTitle.AllSectionsInCreateSho.get(5).getText();
	    	log.info(sectionname);
	    	log.info(shoorseries+sectionanemexp);
	    	assertEquals(sectionname, shoorseries+sectionanemexp);
	    }

	    @And("^seventh section name is \"([^\"]*)\"$")
	    public void seventh_section_name_is_something(String expectedtext) throws Throwable {
	    	String sectionname=CreateTitle.AllSectionsInCreateSho.get(6).getText();
	    	log.info(sectionname);
	    	assertEquals(sectionname,expectedtext);
	    }

	    @And("^eight section name is \"([^\"]*)\"$")
	    public void eight_section_name_is_something(String expectedtext) throws Throwable {
	    	String sectionname=CreateTitle.AllSectionsInCreateSho.get(7).getText();
	    	log.info(sectionname);
	    	assertEquals(sectionname, expectedtext);
	    	
	    }
	    @When("^Click on First section$")
	    public void click_on_first_section() throws Throwable {
	    	CreateTitle.AllSectionsInCreateSho.get(0).click();
	    	wait.until(ExpectedConditions.visibilityOf(CreateTitle.FieldNamesInNameYourShoSection().get(0)));
	    }

	    @Then("^Verify first fieldname should be (.+) and \"([^\"]*)\"$")
	    public void verify_first_fieldname_should_be_and_something(String type, String expectedtext) throws Throwable {
	    	String actual=CreateTitle.FieldNamesInNameYourShoSection().get(0).getText();
	    	String expected=type+" "+expectedtext;
	    	log.info(expected);
	    	assertEquals(actual,expected);
	    }

	    @Then("^Verify second fieldname should be (.+) and \"([^\"]*)\"$")
	    public void verify_second_fieldname_should_be_and_something(String type, String expectedtext) throws Throwable {
	    	String actual=CreateTitle.FieldNamesInNameYourShoSection().get(1).getText();
	    	String expected=type+" "+expectedtext;
	    	log.info(expected);
	    	assertEquals(actual,expected);
	    }
	    

	    @And("^verify first field Description should be \"([^\"]*)\"$")
	    public void verify_first_field_description_should_be_something(String expectedtext) throws Throwable {
	        String actual=CreateTitle.FieldDescriptionsInNameYourShoSection().get(0).getText();
	        log.info(actual);
	        assertEquals(actual, expectedtext);
	    }

	    @And("^Check first field placeholder should be \"([^\"]*)\"$")
	    public void check_first_field_placeholder_should_be_something(String expected) throws Throwable {
	    	String text=CreateTitle.NameYourShoorSeriesField.getAttribute("placeholder");
	    	assertEquals(text, expected);
	    	
	    }

	    @And("^Verify second field Description should be \"([^\"]*)\"$")
	    public void verify_second_field_description_should_be_something(String expected) throws Throwable {
	    	String actual=CreateTitle.FieldDescriptionsInNameYourShoSection().get(1).getText();
	    	assertEquals(expected, actual);
	    }

	    @And("^Upload Png button placeholder with supported text should be (.+)$")
	    public void upload_png_button_placeholder_with_supported_text_should_be(String supportedtext) throws Throwable {
	        String actual=CreateTitle.UploadPngSupportText().getText();
	        assertEquals(supportedtext, actual);
	    }
	    @Then("^Check with out shoname and (.+)$")
	    public void check_with_out_shoname_and(String fielderrormessage) throws Throwable {
	        CreateTitle.AllSectionsInCreateSho.get(1).click();
	        Thread.sleep(1000);
	        CreateTitle.AllSectionsInCreateSho.get(0).click();
	        wait.until(ExpectedConditions.visibilityOf(CreateTitle.Errormessage()));
	        String Actual=CreateTitle.Errormessage().getText();
	        log.info(Actual);
	        assertEquals(Actual, fielderrormessage);
	        
	    }

	    @Then("^enter shoname more than three chracters and check the charactercount$")
	    public void enter_shoname_more_than_three_chracters_and_check_the_charactercount() throws Throwable {
	    	CreateTitle.NameYourShoorSeriesField.sendKeys("New Sho");
	    	assertTrue(CreateTitle.Chractercount().isDisplayed());
	    	log.info(CreateTitle.Chractercount().getText());
	    }

	    @And("^Enter (.+) in to the field$")
	    public void enter_in_to_the_field(String shoname) throws Throwable {
	    	CreateTitle.NameYourShoorSeriesField.sendKeys(shoname);
	    }

	    @And("^Validation check (.+)$")
	    public void Validation_check(String validationerrormessage) throws Throwable {
	        String Actual=CreateTitle.Errormessage().getText();
	        log.info(Actual);
	        assertEquals(Actual,validationerrormessage);
	    }
	    @Then("^Upload inavlid (.+)$")
	    public void upload_inavlid(String invalidtitlepng) throws Throwable {
	    	CreateTitle.UploadPng().click();
	    	Thread.sleep(1500);
	    	Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\Autoit\\"+invalidtitlepng+".exe");
	    }

	    @Then("^click on second section check first section havenot have any error$")
	    public void click_on_second_section_check_first_section_havenot_have_any_error() throws Throwable {
	    	CreateTitle.AllSectionsInCreateSho.get(1).click();
	    	
	    }

	    @And("^Check toaster (.+)$")
	    public void check_toaster(String invaliderrormessage) throws Throwable {
	    	String Actual=Toastanderrormessages.toastmessagem().getText();
	    	log.info(Actual);
	        assertEquals(Actual, invaliderrormessage);
	    }
	    @Then("^Upload valid (.+)$")
	    public void upload_valid(String validtitlepng) throws Throwable {
	    	CreateTitle.UploadPng().click();
	    	Thread.sleep(1500);
	    	Runtime.getRuntime().exec(System.getProperty("user.dir")+"//Autoit//"+validtitlepng+".exe");
	    	wait.until(ExpectedConditions.visibilityOf(CreateTitle.CancelPngPopupButton));
	    	CreateTitle.CancelPngPopupButton.click();
	    	CreateTitle.UploadPng().click();
	    	Thread.sleep(1500);
	    	Runtime.getRuntime().exec(System.getProperty("user.dir")+"//Autoit//"+validtitlepng+".exe");
	    	wait.until(ExpectedConditions.visibilityOf(CreateTitle.CancelPngPopupButton));
	    	CreateTitle.SavePngPopupButton.click();
	    }
	    @And("^Upload other format (.+)$")
	    public void upload_other_format(String image) throws Throwable {
	    	CreateTitle.UploadPng().click();
	    	Thread.sleep(1500);
	    	Runtime.getRuntime().exec(System.getProperty("user.dir")+"//Autoit//"+image+".exe");
	    }
	    @Then("^System will throw (.+)$")
	    public void system_will_throw(String toaster) throws Throwable {
	    	String Actual=Toastanderrormessages.toastmessagem().getText();
	        assertEquals(Actual, toaster);
	    }
	    @Then("^Delete uploaded png$")
	    public void delete_uploaded_png() throws Throwable {
	    	Actions a=new Actions(driver);
	    	a.moveToElement(CreateTitle.UploadPng()).build().perform();
	    	CreateTitle.DeleteIconPng().click();
	    	wait.until(ExpectedConditions.visibilityOf(CreateTitle.CancelButton));
	    	CreateTitle.CancelButton.click();
	    	a.moveToElement(CreateTitle.UploadPng()).build().perform();
	    	CreateTitle.DeleteIconPng().click();
	    	wait.until(ExpectedConditions.visibilityOf(CreateTitle.CancelButton));
	    	CreateTitle.DeleteButton.click();
	    	String text=Toastanderrormessages.toastmessagem().getText();
	    	log.info(text);
	    	assertEquals(text, "Image Deleted successfully");
	    }

	    @And("^Edit already uploaded png with (.+)$")
	    public void edit_already_uploaded_png_with(String validtitlepng) throws Throwable {
	        Actions a=new Actions(driver);
	    	a.moveToElement(CreateTitle.UploadPng()).build().perform();
	    	CreateTitle.EditIconPng().click();
	    	Runtime.getRuntime().exec(System.getProperty("user.dir")+"//Autoit//"+validtitlepng+".exe");
	    }
	    
	    @When("^Click on Manage detail sho section$")
	    public void click_on_manage_detail_sho_section() throws Throwable {
	        CreateTitle.AllSectionsInCreateSho.get(4).click();
	    }

	    @Then("^Upload invalid cover image with (.+)$")
	    public void upload_invalid_cover_image_with(String invalidsize) throws Throwable {
	    	CreateTitle.CoverImageUpload.click();
	    	Thread.sleep(1000);
	    	Runtime.getRuntime().exec(System.getProperty("user.dir")+"//Autoit//"+invalidsize+".exe");
	    }
	    
	    @Then("^Upload cover Image with valid (.+)$")
	    public void upload_cover_image_with_valid(String validsize) throws Throwable {
	    	CreateTitle.CoverImageUpload.click();
	    	Thread.sleep(1000);
	    	Runtime.getRuntime().exec(System.getProperty("user.dir")+"//Autoit//"+validsize+".exe");
	    	CreateTitle.SavePngPopupButton.click();
	    }

	    @Then("^delete uploaded cover image$")
	    public void delete_uploaded_cover_image() throws Throwable {
	    	Actions a=new Actions(driver);
	    	a.moveToElement(CreateTitle.CoverImageUpload).build().perform();
	    	CreateTitle.DeleteIconPng().click();
	    	wait.until(ExpectedConditions.visibilityOf(CreateTitle.CancelButton));
	    	CreateTitle.CancelButton.click();
	    	a.moveToElement(CreateTitle.CoverImageUpload).build().perform();
	    	CreateTitle.DeleteIconPng().click();
	    	wait.until(ExpectedConditions.visibilityOf(CreateTitle.CancelButton));
	    	CreateTitle.DeleteButton.click();
	    	String text=Toastanderrormessages.toastmessagem().getText();
	    	log.info(text);
	    	assertEquals(text, "Image Deleted successfully");
	    }

	    @And("^Edit uploaded cover image with (.+)$")
	    public void edit_uploaded_cover_image_with(String validsize) throws Throwable {
	    	Actions a=new Actions(driver);
	    	a.moveToElement(CreateTitle.CoverImageUpload).build().perform();
	    	CreateTitle.EditIconPngInMangaeDetail().click();
	    	Thread.sleep(1000);
	    	Runtime.getRuntime().exec(System.getProperty("user.dir")+"//Autoit//"+validsize+".exe");
	    	CreateTitle.SavePngPopupButton.click();
	    }
	    @Then("^Check all the field names$")
	    public void check_all_the_field_names() throws Throwable {
            Thread.sleep(2000);
	    	String Coverimagetext=CreateTitle.FieldsNamesInManageDetailofYourShoSectionSection.get(0).getText();
	        log.info(Coverimagetext);
	        assertEquals(Coverimagetext, "Cover Image*");
	        String Thumbnailtext=CreateTitle.FieldsNamesInManageDetailofYourShoSectionSection.get(1).getText();
	        log.info(Thumbnailtext);
	        assertEquals(Thumbnailtext, "Upload Display Image *");
	        String TagsandKeywordstext=CreateTitle.FieldsNamesInManageDetailofYourShoSectionSection.get(2).getText();
	        log.info(TagsandKeywordstext);
	        assertEquals(TagsandKeywordstext, "Tags & keywords*");
	        String Primarygeneretext=CreateTitle.FieldsNamesInManageDetailofYourShoSectionSection.get(3).getText();
	        log.info(Primarygeneretext);
	        assertEquals(Primarygeneretext, "Primary Genre*");
	        String Secondarygeneretext=CreateTitle.FieldsNamesInManageDetailofYourShoSectionSection.get(4).getText();
	        log.info(Secondarygeneretext);
	        assertEquals(Secondarygeneretext, "Secondary Genres*");
	        String Maturityratingtext=CreateTitle.FieldsNamesInManageDetailofYourShoSectionSection.get(5).getText();
	        log.info(Maturityratingtext);
	        assertEquals(Maturityratingtext, "Maturity Rating*");
	        String Intialreleasetext=CreateTitle.FieldsNamesInManageDetailofYourShoSectionSection.get(6).getText();
	        log.info(Intialreleasetext);
	        assertEquals(Intialreleasetext, "Initial Release date *");
	        String Shodescriptiontext=CreateTitle.FieldsNamesInManageDetailofYourShoSectionSection.get(7).getText();
	        log.info(Shodescriptiontext);
	        assertEquals(Shodescriptiontext, "Sho Description*");
	        String CrewDetailstext=CreateTitle.FieldsNamesInManageDetailofYourShoSectionSection.get(8).getText();
	        log.info(CrewDetailstext);
	        assertEquals(CrewDetailstext, "Crew Details *");
	        String Castdetailstext=CreateTitle.FieldsNamesInManageDetailofYourShoSectionSection.get(9).getText();
	        log.info(Castdetailstext);
	        assertEquals(Castdetailstext, "Cast Details *");
	    }

	    @And("^Check all the description of field names$")
	    public void check_all_the_description_of_field_names() throws Throwable {
	    	String Coverimagetext=CreateTitle.FieldsDesriptionInManageDetailofYourShoSectionSection.get(0).getText();
	        log.info(Coverimagetext);
	        assertEquals(Coverimagetext, "Give us a cover image for your sho Recommended size 1900x768px, in jpg or png");
	        String Thumbnailtext=CreateTitle.FieldsDesriptionInManageDetailofYourShoSectionSection.get(1).getText();
	        log.info(Thumbnailtext);
	        assertEquals(Thumbnailtext, "Give us a cover image for your sho Recommended size 350x550px, in jpg or png");
	        String TagsandKeywordstext=CreateTitle.FieldsDesriptionInManageDetailofYourShoSectionSection.get(2).getText();
	        log.info(TagsandKeywordstext);
	        assertEquals(TagsandKeywordstext, "Relevant keywords that would best describe your sho. You can add upto 3 keywords");
	        String Primarygeneretext=CreateTitle.FieldsDesriptionInManageDetailofYourShoSectionSection.get(3).getText();
	        log.info(Primarygeneretext);
	        assertEquals(Primarygeneretext, "Genre that would best describe your sho");
	        String Secondarygeneretext=CreateTitle.FieldsDesriptionInManageDetailofYourShoSectionSection.get(4).getText();
	        log.info(Secondarygeneretext);
	        assertEquals(Secondarygeneretext, "Additional genres that would describe your sho. You can add upto 3 genres");
	        String Maturityratingtext=CreateTitle.FieldsDesriptionInManageDetailofYourShoSectionSection.get(5).getText();
	        log.info(Maturityratingtext);
	        assertEquals(Maturityratingtext, "Content rating that rates the suitability of this content to its audiences");
	        String Intialreleasetext=CreateTitle.FieldsDesriptionInManageDetailofYourShoSectionSection.get(6).getText();
	        log.info(Intialreleasetext);
	        assertEquals(Intialreleasetext, "Actual date of this film screened to general audience");
	        String Shodescriptiontext=CreateTitle.FieldsDesriptionInManageDetailofYourShoSectionSection.get(7).getText();
	        log.info(Shodescriptiontext);
	        assertEquals(Shodescriptiontext, "Brief overview that will describe your sho.");
	        String CrewDetailstext=CreateTitle.FieldsDesriptionInManageDetailofYourShoSectionSection.get(8).getText();
	        log.info(CrewDetailstext);
	        assertEquals(CrewDetailstext, "Add details of the film crew. You can add upto 6 crew member details");
	        String Castdetailstext=CreateTitle.FieldsDesriptionInManageDetailofYourShoSectionSection.get(9).getText();
	        log.info(Castdetailstext);
	        assertEquals(Castdetailstext, "Add casting details of this sho.");
	    }
	    @Then("^upload inavlid thumb nail image with (.+)$")
	    public void upload_inavlid_thumb_nail_image_with(String invalidsize) throws Throwable {
	        CreateTitle.ThumbnailImageUpload.click();
	        Thread.sleep(1000);
	        Runtime.getRuntime().exec(System.getProperty("user.dir")+"//Autoit//"+invalidsize+".exe");
	        
	    }

	    @Then("^Upload thubnail image with valid (.+)$")
	    public void upload_thubnail_image_with_valid(String validsize) throws Throwable {
	    	CreateTitle.ThumbnailImageUpload.click();
	        Thread.sleep(1000);
	        Runtime.getRuntime().exec(System.getProperty("user.dir")+"//Autoit//"+validsize+".exe");
	        CreateTitle.ThumbnialUpoadSaveButton.click();
	        
	    }

	    @Then("^delete uploaded thumbnail image$")
	    public void delete_uploaded_thumbnail_image() throws Throwable {
	    	Actions a=new Actions(driver);
	    	a.moveToElement(CreateTitle.ThumbnailImageUpload).build().perform();
	    	CreateTitle.DeleteIconPng().click();
	    	wait.until(ExpectedConditions.visibilityOf(CreateTitle.CancelButton));
	    	CreateTitle.CancelButton.click();
	    	a.moveToElement(CreateTitle.ThumbnailImageUpload).build().perform();
	    	CreateTitle.DeleteIconPng().click();
	    	wait.until(ExpectedConditions.visibilityOf(CreateTitle.CancelButton));
	    	CreateTitle.DeleteButton.click();
	    	String text=Toastanderrormessages.toastmessagem().getText();
	    	log.info(text);
	    	assertEquals(text, "Image Deleted successfully");
	    }

	    @And("^The popup should show (.+)$")
	    public void the_popup_should_show(String invaliderrormessage) throws Throwable {
	    	String Actual=CreateTitle.ErrormessageInPopupThumbnail.getText();
	    	log.info(Actual);
	    	assertEquals(Actual, invaliderrormessage);
	    	CreateTitle.ThumbnialUpoadCancelButton.click();
	    }

	    @And("^Edit the uploaded thumbnail image with (.+)$")
	    public void edit_the_uploaded_thumbnail_image_with(String validsize) throws Throwable {
	    	Actions a=new Actions(driver);
	    	a.moveToElement(CreateTitle.ThumbnailImageUpload).build().perform();
	    	CreateTitle.EditIconPngInMangaeDetail().click();
	    	Thread.sleep(1000);
	    	Runtime.getRuntime().exec(System.getProperty("user.dir")+"//Autoit//"+validsize+".exe");
	    	CreateTitle.ThumbnialUpoadSaveButton.click();
	    }
	    @Then("^Check placehoder values should match \"([^\"]*)\"$")
	    public void check_placehoder_values_should_match_something(String Expected) throws Throwable {
	    	assertTrue(CreateTitle.TagsCharCount.isDisplayed());
	        String Actual=CreateTitle.TagsAndKeywords.getAttribute("placeholder");
	        log.info(Actual);
	        assertEquals(Actual,Expected);
	    }

	    @And("^Enter keywords and tags one by one check character count$")
	    public void enter_keywords_and_tags_one_by_one_check_character_count() throws Throwable {
	    	CreateTitle.TagsAndKeywords.sendKeys("action");
	    	Actions a=new Actions(driver);
	    	a.sendKeys(Keys.ENTER).build().perform();
	    	String charccountforfirstinput1=CreateTitle.TagsCharCount.getText();
	    	log.info(charccountforfirstinput1);
	    	assertEquals(charccountforfirstinput1, 1+"/3");
	    	CreateTitle.TagsAndKeywords.sendKeys("drama");
	    	a.sendKeys(Keys.ENTER).build().perform();
	    	String charccountforfirstinput2=CreateTitle.TagsCharCount.getText();
	    	log.info(charccountforfirstinput2);
	    	assertEquals(charccountforfirstinput2, 2+"/3");
	    	CreateTitle.TagsAndKeywords.sendKeys("Adventure");
	    	a.sendKeys(Keys.ENTER).build().perform();
	    	String charccountforfirstinput3=CreateTitle.TagsCharCount.getText();
	    	log.info(charccountforfirstinput3);
	    	assertEquals(charccountforfirstinput3, 3+"/3");
	    	
	    }
	    @Then("^Enter more than three keywords$")
	    public void enter_more_than_three_keywords() throws Throwable {
	    	CreateTitle.TagsAndKeywords.sendKeys("Historic");
	    	Actions a=new Actions(driver);
	    	a.sendKeys(Keys.ENTER).build().perform();
	    }
	    @Then("^Remove tag by tag and check the chracter count$")
	    public void remove_tag_by_tag_and_check_the_chracter_count() throws Throwable {
	    	CreateTitle.RemoveTagsIcon.click();
	    	String charccountforfirstinput1=CreateTitle.TagsCharCount.getText();
	    	log.info(charccountforfirstinput1);
	    	assertEquals(charccountforfirstinput1, 2+"/3");
	    	CreateTitle.RemoveTagsIcon.click();
	    	String charccountforfirstinput2=CreateTitle.TagsCharCount.getText();
	    	log.info(charccountforfirstinput2);
	    	assertEquals(charccountforfirstinput2, 1+"/3");
	    	CreateTitle.RemoveTagsIcon.click();
	    	String charccountforfirstinput3=CreateTitle.TagsCharCount.getText();
	    	log.info(charccountforfirstinput3);
	    	assertEquals(charccountforfirstinput3, 0+"/3");
	    }

	    @Then("^Select any one (.+) from the dropdown$")
	    public void select_the_any_one_from_the_dropdown(String primarygenre) throws Throwable {
	    	Thread.sleep(1000);
	    	Actions a =new Actions(driver);
	    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    	js.executeScript("arguments[0].scrollIntoView();", CreateTitle.TagsAndKeywords);
	    	Thread.sleep(500);
	    	CreateTitle.PrimaryGenere.click();
	    	log.info(CreateTitle.DropdownforPrimaryGenre.size());
	    	for(int i=0;i<CreateTitle.DropdownforPrimaryGenre.size();i++)
	    	{
	    		log.info(CreateTitle.DropdownforPrimaryGenre.get(i).getText());
	    		if(CreateTitle.DropdownforPrimaryGenre.get(i).getText().equalsIgnoreCase(primarygenre))
	    		{
	    			a.moveToElement(CreateTitle.DropdownforPrimaryGenre.get(i)).build().perform();
	    			a.click(CreateTitle.DropdownforPrimaryGenre.get(i)).build().perform();
	    			break;
	    		}
	    	}
	    	Thread.sleep(1000);
	    	String text=CreateTitle.PrimaryGenere.getText();
	    	log.info(text);
	    	assertEquals(text, primarygenre);
	    }
	    @And("^Placeholder of secondary genere$")
	    public void placeholder_of_secondary_genere() throws Throwable {
	       String text= CreateTitle.SecondaryGenere.getAttribute("placeholder");
	       log.info(text);
	       assertEquals("(ex: action, horror)", text);
	        
	    }

	    @Then("^Enter secondary genre more than three chracters$")
	    public void enter_secondary_genre_more_than_three_chracters() throws Throwable {
	    	Actions a=new Actions(driver);
	    	CreateTitle.SecondaryGenere.sendKeys("Comedy");
	    	a.sendKeys(Keys.ARROW_DOWN).build().perform();
	    	a.sendKeys(Keys.ENTER).build().perform();
	    }

	    @And("^Select secondary one by one check character count$")
	    public void select_secondary_obe_by_one_check_character_count() throws Throwable {
	    	Actions a =new Actions(driver);
	    	CreateTitle.SecondaryGenere.sendKeys("Action");
	    	a.sendKeys(Keys.ARROW_DOWN).build().perform();
	    	a.sendKeys(Keys.ENTER).build().perform();
	    	String charccountforfirstinput1=CreateTitle.SecondarygenreChracCount.getText();
	    	log.info(charccountforfirstinput1);
	    	assertEquals(charccountforfirstinput1, 1+"/3");
	    	CreateTitle.SecondaryGenere.sendKeys("Drama");
	    	a.sendKeys(Keys.ARROW_DOWN).build().perform();
	    	a.sendKeys(Keys.ENTER).build().perform();
	    	String charccountforfirstinput2=CreateTitle.SecondarygenreChracCount.getText();
	    	log.info(charccountforfirstinput2);
	    	assertEquals(charccountforfirstinput2, 2+"/3");
	    	CreateTitle.SecondaryGenere.sendKeys("Crime");
	    	a.sendKeys(Keys.ARROW_DOWN).build().perform();
	    	a.sendKeys(Keys.ENTER).build().perform();
	    	//String charccountforfirstinput3=CreateTitle.SecondarygenreChracCount.getText();
	    	//log.info(charccountforfirstinput3);
	    	//assertEquals(charccountforfirstinput3, 3+"/3");
	    	
	    }
	    @And("^Remove the secondary genre and check chracter count$")
	    public void remove_the_secondary_genre_and_check_chracter_count() throws Throwable {
	    	CreateTitle.RemoveTagsIcon.click();
	    	String charccountforfirstinput1=CreateTitle.SecondarygenreChracCount.getText();
	    	log.info(charccountforfirstinput1);
	    	assertEquals(charccountforfirstinput1, 2+"/3");
	    	CreateTitle.RemoveTagsIcon.click();
	    	String charccountforfirstinput2=CreateTitle.SecondarygenreChracCount.getText();
	    	log.info(charccountforfirstinput2);
	    	assertEquals(charccountforfirstinput2, 1+"/3");
	    	CreateTitle.RemoveTagsIcon.click();
	    	String charccountforfirstinput3=CreateTitle.SecondarygenreChracCount.getText();
	    	log.info(charccountforfirstinput3);
	    	assertEquals(charccountforfirstinput3, 0+"/3");
	    }
	   
	    @Then("^Check all label and maturity ratings text$")
	    public void check_all_label_and_maturity_ratings_text() throws Throwable {
	    	Thread.sleep(1000);
	    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    	js.executeScript("arguments[0].scrollIntoView();", CreateTitle.SecondaryGenere);
	        String firstrating=CreateTitle.Rating.get(0).getText();
	        log.info(firstrating);
	        assertEquals(firstrating, "ALL");
	        String secondrating=CreateTitle.Rating.get(1).getText();
	        log.info(secondrating);
	        assertEquals(secondrating, "7+");
	        String thirdrating=CreateTitle.Rating.get(2).getText();
	        log.info(thirdrating);
	        assertEquals(thirdrating, "13+");
	        String fourthrating=CreateTitle.Rating.get(3).getText();
	        log.info(fourthrating);
	        assertEquals(fourthrating, "18+");
	        String firstratingtext=CreateTitle.RatingLabel.get(0).getText();
	        log.info(firstratingtext);
	        assertEquals(firstratingtext, "For all age groups");
	        String secondratingtext=CreateTitle.RatingLabel.get(1).getText();
	        log.info(secondratingtext);
	        assertEquals(secondratingtext, "Strongly for Kids");
	        String thirdratingtext=CreateTitle.RatingLabel.get(2).getText();
	        log.info(thirdratingtext);
	        assertEquals(thirdratingtext, "parents strongly cautioned");
	        String fourthratingtext=CreateTitle.RatingLabel.get(3).getText();
	        log.info(fourthratingtext);
	        assertEquals(fourthratingtext, "restrict my video to viewers below 18");
	    }
	    @And("^maturity rating as (.+)$")
	    public void maturity_rating_as(String maturityrating) throws Throwable {
	    	log.info(CreateTitle.Rating.size());
	        for(int i=0;i<CreateTitle.Rating.size();i++)
	        {
	        	log.info(CreateTitle.Rating.get(i).getText());
	        	if(CreateTitle.RatingLabel.get(i).getText().equalsIgnoreCase(maturityrating))
	        	{
	        		JavascriptExecutor js = (JavascriptExecutor) driver;
	    	    	js.executeScript("arguments[0].click();",CreateTitle.Rating.get(i));
	    	    	log.info("askdakdjsakdjaksjahdajhajsh");
	        		Thread.sleep(10000);
	        		break;
	        		
	        	}
	        }
	    }
	   
	   
	   
}
