package Steps.studioend;




import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.frontend.Accountandsettings;
import PageObjects.frontend.Studioprofile;
import PageObjects.frontend.Toastanderrormessages;
import PageObjects.frontend.socialpageandsearch;
import PageObjects.studioend.CreateStudioandsettings;
import Resources.Base_setup;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class CreateStudioSteps extends Base_setup {

	   public static Logger log=Logger.getLogger(CreateStudioSteps.class.getName()); 
	   CreateStudioandsettings cs=new CreateStudioandsettings();
	   WebDriverWait wait=new WebDriverWait(driver,20);
	   JavascriptExecutor js=(JavascriptExecutor)driver;
	   
	   @Given("^Go to create Studio Page tab from profile$")
	   public void go_to_create_studio_page_tab_from_profile() throws Throwable {
	       Actions a=new Actions(driver);
	       a.moveToElement(Accountandsettings.mousehoveronprofilem()).build().perform();
	       CreateStudioandsettings.CreateStudioButton.click();
	       wait.until(ExpectedConditions.visibilityOf(CreateStudioandsettings.CreateStudioPageHeading));
	       String Heading=CreateStudioandsettings.CreateStudioPageHeading.getText();
	       log.info(Heading);
	       assertEquals(Heading, "Create Studio Page");
	       String description=CreateStudioandsettings.CreateStudioPageDescription.getText();
	       log.info(description);
	       assertEquals(description, "Get started by giving few details about your studio"); 
	       
	    }

	    @When("^Click on close icon$")
	    public void click_on_close_icon() throws Throwable {
	    	CreateStudioandsettings.CreateStudioPageCloseIcon.click();
	    }

	    @Then("^It should redirect to home page$")
	    public void it_should_redirect_to_home_page() throws Throwable {
	       assertTrue(socialpageandsearch.logoheaderm().isDisplayed());
	       assertTrue(socialpageandsearch.homepagesearch().isDisplayed());
	    }
	    @Then("^Click cancel button$")
	    public void click_cancel_button() throws Throwable {
	    	CreateStudioandsettings.CreateStudioCancelButton.click();
	    }
	    @When("^Check first tab is displaying with \"([^\"]*)\"$")
	    public void check_first_tab_is_displaying_with_something(String strArg1) throws Throwable {
	    	String firsttabheading=CreateStudioandsettings.CreateStudioMiniTabTitle.get(0).getText();
	    	log.info(firsttabheading);
	    	assertEquals(strArg1, firsttabheading);
	    }

	    @Then("^Check second tab is diaplaying with \"([^\"]*)\"$")
	    public void check_second_tab_is_diaplaying_with_something(String strArg1) throws Throwable {
	    	String secondtabheading=CreateStudioandsettings.CreateStudioMiniTabTitle.get(1).getText();
	    	log.info(secondtabheading);
	    	assertEquals(strArg1, secondtabheading);
	    }
	    @And("^Check third tab is dispaying with \"([^\"]*)\"$")
	    public void check_third_tab_is_dispaying_with_something(String strArg1) throws Throwable {
	    	String Thirdtabheading=CreateStudioandsettings.CreateStudioMiniTabTitle.get(2).getText();
	    	log.info(Thirdtabheading);
	    	assertEquals(strArg1, Thirdtabheading);
	    }
	    @When("^Check the place holder is displaying as \"([^\"]*)\"$")
	    public void check_the_place_holder_is_displaying_as_something(String placeholder) throws Throwable {
	    	String Actualplaceholder=CreateStudioandsettings.StudioNameField.getAttribute("placeholder");
	    	log.info(Actualplaceholder);
	    	assertEquals(placeholder,Actualplaceholder);
	    }
	    @Then("^Check description \"([^\"]*)\"$")
	    public void check_description_something(String description) throws Throwable {
	        String Actualdescription=CreateStudioandsettings.StudioNameDescription.getText();
	        log.info(Actualdescription);
	        assertEquals(Actualdescription, description);
	    }
	    @When("^Input the field with null values$")
	    public void input_the_field_with_null_values() throws Throwable {
	    	CreateStudioandsettings.StudioNameField.sendKeys(Keys.SPACE);
	    	CreateStudioandsettings.StudioNameField.sendKeys(Keys.SPACE);
	    	CreateStudioandsettings.StudioNameField.sendKeys(Keys.SPACE);
	    }
	    @Then("^The errormessage should show \"([^\"]*)\"$")
	    public void the_errormessage_should_show_something(String errormessage) throws Throwable {
	    	String Actualerrormessage=CreateStudioandsettings.ErrorMessages.getText();
	    	log.info(Actualerrormessage);
	    	assertEquals(Actualerrormessage, errormessage);
	    }
	    @And("^Enter \"([^\"]*)\" in the field and errormessage should show \"([^\"]*)\"$")
	    public void enter_something_in_the_field_and_errormessage_should_show_something(String input, String errormessage) throws Throwable {
	    	CreateStudioandsettings.StudioNameField.clear();
	    	CreateStudioandsettings.StudioNameField.sendKeys(input);
	    	CreateStudioandsettings.CreateStudioPageButton.click();
	    	String Actualerrormessage=CreateStudioandsettings.ErrorMessages.getText();
	    	log.info(Actualerrormessage);
	    	assertEquals(Actualerrormessage, errormessage);
	    }
	    @Then("^Without studio name the errormessage should show \"([^\"]*)\"$")
	    public void without_studio_name_the_errormessage_should_show_something(String errormessage) throws Throwable {
	    	CreateStudioandsettings.StudioNameField.sendKeys(Keys.BACK_SPACE);
	    	CreateStudioandsettings.CreateStudioPageButton.click();
	    	String Actualerrormessage=CreateStudioandsettings.ErrorMessages.getText();
	    	log.info(Actualerrormessage);
	    	assertEquals(Actualerrormessage, errormessage);	
	    }
	    @And("^Header error message should show \"([^\"]*)\"$")
	    public void header_error_message_should_show_something(String errormessage) throws Throwable {
	    	String Actualerrormessage=CreateStudioandsettings.HeadderErrorMessage.getText();
	    	log.info(Actualerrormessage);
	    	assertEquals(Actualerrormessage, errormessage);
	    }
	    @When("^Input the (.+) in to the field$")
	    public void input_the_in_to_the_field(String studioname) throws Throwable {
	    	CreateStudioandsettings.StudioNameField.sendKeys(studioname);
	    	Thread.sleep(2000);
	    	String Studionameonprofilepreview=CreateStudioandsettings.StudioNameinStudioProfilepreview.getText();
	    	log.info(Studionameonprofilepreview);
	    	assertEquals(Studionameonprofilepreview, studioname);
	    }
	    @Then("^Give (.+) and available text should show \"([^\"]*)\"$")
	    public void give_and_available_text_should_show_something(String validstudioname, String availablemessage) throws Throwable {
	    	CreateStudioandsettings.StudioNameField.clear();
	    	CreateStudioandsettings.StudioNameField.sendKeys(validstudioname);
	    	String str=CreateStudioandsettings.AvailableTextInField.getText();
	    	String str1=str.replace("\n", " ");
	    	String avilabletextinfield=str1.substring(0,str1.lastIndexOf(" "));
	    	log.info(avilabletextinfield);
	    	assertEquals(avilabletextinfield, availablemessage);	
	    	String Studionameonprofilepreview=CreateStudioandsettings.StudioNameinStudioProfilepreview.getText();
	    	log.info(Studionameonprofilepreview);
	    	assertEquals(Studionameonprofilepreview, validstudioname);
	    }

	    @And("^The errormessage as \"([^\"]*)\"$")
	    public void the_errormessage_as_something(String errormessage) throws Throwable {
	    	String Actualerrormessage=CreateStudioandsettings.ErrorMessages.getText();
	    	log.info(Actualerrormessage);
	    	assertEquals(Actualerrormessage, errormessage);
	    }
	    @Given("^check \"([^\"]*)\" is displaying$")
	    public void check_something_is_displaying(String studioprofilefieldname) throws Throwable {
	    	Thread.sleep(2000);
	    	CreateStudioandsettings.CreateStudioMiniTabTitle.get(1).click();
	    	Thread.sleep(1500);
	    	String Studioprofilefieldname=CreateStudioandsettings.FieldNames.get(0).getText();
	    	log.info(Studioprofilefieldname);
	    	assertEquals(Studioprofilefieldname,studioprofilefieldname);
	    }

	    @Then("^The thumbnail image icon and the \"([^\"]*)\" and \"([^\"]*)\" text is displaying$")
	    public void the_thumbnail_image_icon_and_the_something_and_something_text_is_displaying(String thumbnailtext1, String thumbnailtext2) throws Throwable {
	    	String thumnailtext1=CreateStudioandsettings.TextInsideTumbnailIcon.get(0).getText();
	    	log.info(thumnailtext1);
	        assertEquals(thumnailtext1, thumbnailtext1);
	        String thumnailtext2=CreateStudioandsettings.TextInsideTumbnailIcon.get(1).getText();
	        log.info(thumnailtext2);
	        assertEquals(thumnailtext2, thumbnailtext2);
	    }

	    @Then("^upload the (.+)$")
	    public void upload_the(String thumbnailimage) throws Throwable {
	    	Thread.sleep(2000);
	    	CreateStudioandsettings.CreateStudioMiniTabTitle.get(1).click();
	    	CreateStudioandsettings.AddThumbnailField.click();
	    	Thread.sleep(1000);
	    	Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\Autoit\\"+thumbnailimage+".exe");
	    }
	    @When("^upload image$")
	    public void upload_image() throws Throwable {
	    	CreateStudioandsettings.ThumbnailSavebutton.click();
	    }

	    @And("^Check description of filed name is \"([^\"]*)\" displaying$")
	    public void check_the_description_of_filed_name_is_something_displaying(String studioprofiledescription) throws Throwable {
	    	String studioprofiledescriptiont=CreateStudioandsettings.FieldNameDescriptions.get(0).getText();
	    	log.info(studioprofiledescriptiont);
	    	assertEquals(studioprofiledescriptiont, studioprofiledescription);
	    }
	    @Then("^Uploaded image has been displayed in studio preview$")
	    public void uploaded_image_has_been_displayed_in_studio_preview() throws Throwable {
	    	assertTrue(CreateStudioandsettings.StudioImageInProfilePreview.isDisplayed());
	    }

	    @And("^The file supported text is displaying$")
	    public void the_file_supported_text_is_displaying() throws Throwable {
	    	String str=CreateStudioandsettings.ThumbnailFileSupportsText.getText();
	    	String thumbnailsupporttext=str.replace("\n", " ");
	    	log.info(thumbnailsupporttext);
	    	assertEquals("Recommended height 200px JPEGs, and PNGs supported.", thumbnailsupporttext);
	    }
	    @Then("^the error toast message is (.+)$")
	    public void the_error_toast_message_is(String toastmessage) throws Throwable {
	        
	        	Thread.sleep(1000);
	        	String actualtoastmessage=Toastanderrormessages.alerdailogm().getText();
	        	log.info(actualtoastmessage);
	        	assertEquals(actualtoastmessage, toastmessage);
	    }
	    @And("^Change the (.+)$")
	    public void change_the(String thumbnailimage) throws Throwable {
	        CreateStudioandsettings.StudioThumbnailediticon.click();
	        Thread.sleep(1500);
	    	Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\Autoit\\"+thumbnailimage+".exe");
	    }
	    @And("^Delete the uploaded profile pic and the errormessage should show \"([^\"]*)\"$")
	    public void delete_the_uploaded_profile_pic_and_the_errormessage_should_show_something(String fielderrormessage) throws Throwable {
	    	Actions a=new Actions(driver);
	        a.moveToElement(CreateStudioandsettings.StudioThumbnailafteruploadimage).build().perform();
	        CreateStudioandsettings.StudioThumbnailDeleteIcon.click();
	        Thread.sleep(1000);
	        String errormessage=CreateStudioandsettings.ErrorMessages.getText();
	        log.info(errormessage);
	        assertEquals(errormessage, fielderrormessage);
	    }
	    @Then("^About studio field name should display \"([^\"]*)\"$")
	    public void about_studio_field_name_should_display_something(String aboutstudiofield) throws Throwable {
	    	Thread.sleep(2000);
	    	CreateStudioandsettings.CreateStudioMiniTabTitle.get(1).click();
	    	Thread.sleep(1500);
	    	String aboutstudiofieldactual=CreateStudioandsettings.FieldNames.get(1).getText();
	    	log.info(aboutstudiofieldactual);
	    	assertEquals(aboutstudiofield, aboutstudiofieldactual);
	    	
	    }

	    @Then("^Give Description in to the field as \"([^\"]*)\"$")
	    public void give_description_in_to_the_field_as_something(String studiodescription) throws Throwable {
	        CreateStudioandsettings.StudioDescription.sendKeys(studiodescription);
	        String description=CreateStudioandsettings.StudioDescriptionInProfilePreview.getText();
	        log.info(description);
	        assertEquals(description, studiodescription);
	        
	    }

	    @And("^About studio field description should display \"([^\"]*)\"$")
	    public void about_studio_field_description_should_display_something(String aboutstudiofielddesc) throws Throwable {
	    	String aboutstudiodescactual=CreateStudioandsettings.FieldNameDescriptions.get(1).getText();
	    	log.info(aboutstudiodescactual);
	    	assertEquals(aboutstudiodescactual, aboutstudiofielddesc);
	    }

	    @And("^The description place holder should display \"([^\"]*)\"$")
	    public void the_description_place_holder_should_display_something(String descplaceholder) throws Throwable {
	    	String Placeholder=CreateStudioandsettings.StudioDescription.getAttribute("placeholder");
	    	log.info(Placeholder);
	    	assertEquals(Placeholder, descplaceholder);
	    	
	    }

	    @And("^The Description chracter count$")
	    public void the_description_chracter_count() throws Throwable {
	        assertTrue(CreateStudioandsettings.StuioDescriptionChractersCount.isDisplayed());
	        log.info(CreateStudioandsettings.StuioDescriptionChractersCount.getText());
	    }
	    @When("^Studio visibility field name \"([^\"]*)\"$")
	    public void studio_visibility_field_name_something(String studiovisibilityname) throws Throwable {
	    	CreateStudioandsettings.CreateStudioMiniTabTitle.get(1).click();
	    	wait.until(ExpectedConditions.visibilityOf(CreateStudioandsettings.FieldNames.get(2)));
	    	String Studiovisibilityfieldname=CreateStudioandsettings.FieldNames.get(2).getText();
	    	log.info(Studiovisibilityfieldname);
	    	assertEquals(Studiovisibilityfieldname, studiovisibilityname);
	    }

	    @Then("^Studio visibility description \"([^\"]*)\"$")
	    public void studio_visibility_description_something(String visbilitydesc) throws Throwable {
	    	String studiovisibilitydesc=CreateStudioandsettings.FieldNameDescriptions.get(2).getText();
	    	log.info(studiovisibilitydesc);
	    	assertEquals(studiovisibilitydesc, visbilitydesc);
	    }

	    @And("^Studio visibility options$")
	    public void studio_visibility_options() throws Throwable {
	    	String publicvisiblity=CreateStudioandsettings.StudioVisiblity.get(0).getText();
	    	log.info(publicvisiblity);
	    	assertEquals(publicvisiblity, "Public Studio");
	    	String privatevisibility=CreateStudioandsettings.StudioVisiblity.get(1).getText();
	    	log.info(privatevisibility);
	    	assertEquals(privatevisibility, "Private Studio");
	    }
	    @And("^Click visibility (.+)$")
	    public void click_visibility(String visibility) throws Throwable {
	    	for(int i=0;i<CreateStudioandsettings.StudioVisiblity.size();i++)
	    	{
	    		if(CreateStudioandsettings.StudioVisiblity.get(i).getText().equalsIgnoreCase(visibility))
	    		{
	    			CreateStudioandsettings.StudioVisiblity.get(i).click();
	    			break;
	    		}
	    	}
	    }
	    @When("^Check all the social icon field names$")
	    public void check_all_the_social_icon_field_names() throws Throwable {
	    	Thread.sleep(2000);
	    	CreateStudioandsettings.CreateStudioMiniTabTitle.get(1).click();
	    	wait.until(ExpectedConditions.visibilityOf(CreateStudioandsettings.FieldNames.get(3)));
	    	assertEquals(CreateStudioandsettings.FieldNames.get(3).getText(), "Facebook");
	    	assertEquals(CreateStudioandsettings.FieldNames.get(4).getText(), "Twitter");
	    	assertEquals(CreateStudioandsettings.FieldNames.get(5).getText(), "Linkedin");
	    	assertEquals(CreateStudioandsettings.FieldNames.get(6).getText(), "Instagram");
	    	assertEquals(CreateStudioandsettings.FieldNames.get(7).getText(), "Website");
	    	
	    }

	    @Then("^Check all the placeholders of the social icon fields$")
	    public void check_all_the_placeholders_of_the_social_icon_fields() throws Throwable {
	    	assertEquals(CreateStudioandsettings.FacebookField.getAttribute("placeholder"), "https://www.facebook.com/YourStudioLink");
	    	assertEquals(CreateStudioandsettings.TwitterField.getAttribute("placeholder"), "https://www.twitter.com/YourStudioLink");
	    	assertEquals(CreateStudioandsettings.LinkedinField.getAttribute("placeholder"), "https://www.linkedin.com/yourstudiolink");
	    	assertEquals(CreateStudioandsettings.InstagramField.getAttribute("placeholder"), "https://www.instagram.com/yourstudiolink");
	    	assertEquals(CreateStudioandsettings.WebSiteField.getAttribute("placeholder"), "https://www.yourwebsite.com");
	    }
	    @Given("^To check all the field error messages$")
	    public void to_check_all_the_field_error_messages() throws Throwable {
	    	CreateStudioandsettings.StudioNameField.sendKeys("hjdhsjdhs");
	    	Thread.sleep(1500);
	    	CreateStudioandsettings.CreateStudioMiniTabTitle.get(1).click();
	    	Thread.sleep(2000);
	    	CreateStudioandsettings.StudioDescription.sendKeys("Sameer Studio");
	    	CreateStudioandsettings.StudioVisiblity.get(0).click();
	    	CreateStudioandsettings.CreateStudioPageButton.click();
	    	log.info(CreateStudioandsettings.ErrorMessages.getText());
	    	assertEquals(CreateStudioandsettings.ErrorMessages.getText(), "Please upload image");
	    	log.info(CreateStudioandsettings.HeadderErrorMessage.getText());
	    	assertEquals(CreateStudioandsettings.HeadderErrorMessage.getText(), "Sorry! Please continue filling all the mandatory fields.");
	    	
	    	driver.navigate().refresh();
	    	Thread.sleep(3000);
	    	
	    	CreateStudioandsettings.StudioNameField.sendKeys("hjdhsjdhs");
	    	Thread.sleep(1500);
	    	CreateStudioandsettings.CreateStudioMiniTabTitle.get(1).click();
	    	Thread.sleep(2000);
	    	CreateStudioandsettings.AddThumbnailField.click();
	    	Thread.sleep(1000);
	    	Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\Autoit\\Studioprofile.exe");
	    	CreateStudioandsettings.ThumbnailSavebutton.click();
	    	CreateStudioandsettings.StudioVisiblity.get(0).click();
	    	CreateStudioandsettings.CreateStudioPageButton.click();
	    	log.info(CreateStudioandsettings.ErrorMessages.getText());
	    	assertEquals(CreateStudioandsettings.ErrorMessages.getText(), "Please fill the description");
	    	log.info(CreateStudioandsettings.HeadderErrorMessage.getText());
	    	assertEquals(CreateStudioandsettings.HeadderErrorMessage.getText(), "Sorry! Please continue filling all the mandatory fields.");
	    	
	    	driver.navigate().refresh();
	    	Thread.sleep(3000);
	    	
	    	CreateStudioandsettings.StudioNameField.sendKeys("hjdhsjdhs");
	    	Thread.sleep(1500);
	    	CreateStudioandsettings.CreateStudioMiniTabTitle.get(1).click();
	    	Thread.sleep(2000);
	    	CreateStudioandsettings.AddThumbnailField.click();
	    	Thread.sleep(1000);
	    	Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\Autoit\\Studioprofile.exe");
	    	CreateStudioandsettings.ThumbnailSavebutton.click();
	    	CreateStudioandsettings.StudioDescription.sendKeys("Sameer Studio");
	    	CreateStudioandsettings.CreateStudioPageButton.click();
	    	log.info(CreateStudioandsettings.ErrorMessages.getText());
	    	assertEquals(CreateStudioandsettings.ErrorMessages.getText(), "Please choose the status");
	    	log.info(CreateStudioandsettings.HeadderErrorMessage.getText());
	    	assertEquals(CreateStudioandsettings.HeadderErrorMessage.getText(), "Sorry! Please continue filling all the mandatory fields.");
	    	
	    }
	    @And("^Check the invalid urls$")
	    public void check_the_invalid_urls() throws Throwable {
	    	CreateStudioandsettings.FacebookField.sendKeys("http");
	    	String invalidurlforfacebook1=CreateStudioandsettings.ErrorMessages.getText();
	    	log.info(invalidurlforfacebook1);
	    	assertEquals(invalidurlforfacebook1, "Only URL allowed");
	    	CreateStudioandsettings.FacebookField.clear();
	    	CreateStudioandsettings.FacebookField.sendKeys("https://facebook.com");
	    	assertTrue(CreateStudioandsettings.SocilaIconsInStudioPreview.get(0).isEnabled());
	    	CreateStudioandsettings.SocilaIconsInStudioPreview.get(0).click();
	    	CreateStudioandsettings.windowhandle();
	    	
	    	CreateStudioandsettings.TwitterField.sendKeys("http");
	    	String invalidtwitter=CreateStudioandsettings.ErrorMessages.getText();
	    	log.info(invalidtwitter);
	    	assertEquals(invalidtwitter, "Only URL allowed");
	    	CreateStudioandsettings.TwitterField.clear();
	    	CreateStudioandsettings.TwitterField.sendKeys("https://twitter.com");
	    	assertTrue(CreateStudioandsettings.SocilaIconsInStudioPreview.get(1).isEnabled());
	    	CreateStudioandsettings.SocilaIconsInStudioPreview.get(1).click();
	    	CreateStudioandsettings.windowhandle();
	    	
	    	CreateStudioandsettings.LinkedinField.sendKeys("http");
	    	String invalidlinkedin=CreateStudioandsettings.ErrorMessages.getText();
	    	log.info(invalidlinkedin);
	    	assertEquals(invalidlinkedin, "Only URL allowed");
	    	CreateStudioandsettings.LinkedinField.clear();
	    	CreateStudioandsettings.LinkedinField.sendKeys("https://linkedin.com");
	    	assertTrue(CreateStudioandsettings.SocilaIconsInStudioPreview.get(2).isEnabled());
	    	CreateStudioandsettings.SocilaIconsInStudioPreview.get(2).click();
	    	CreateStudioandsettings.windowhandle();
	    	
	    	CreateStudioandsettings. InstagramField.sendKeys("http");
	    	String invalidinstagram=CreateStudioandsettings.ErrorMessages.getText();
	    	log.info(invalidinstagram);
	    	assertEquals(invalidinstagram, "Only URL allowed");
	    	CreateStudioandsettings.InstagramField.clear();
	    	CreateStudioandsettings.InstagramField.sendKeys("https://instagram.com");
	    	assertTrue(CreateStudioandsettings.SocilaIconsInStudioPreview.get(3).isEnabled());
	    	CreateStudioandsettings.SocilaIconsInStudioPreview.get(3).click();
	    	CreateStudioandsettings.windowhandle();
	    	
	    	CreateStudioandsettings. WebSiteField.sendKeys("http");
	    	String invalidwebsite=CreateStudioandsettings.ErrorMessages.getText();
	    	log.info(invalidwebsite);
	    	assertEquals(invalidwebsite, "Only URL allowed");
	    	CreateStudioandsettings.WebSiteField.clear();
	    	CreateStudioandsettings.WebSiteField.sendKeys("https://gudsho.com");
	    	assertTrue(CreateStudioandsettings.SocilaIconsInStudioPreview.get(4).isEnabled());
	    	CreateStudioandsettings.SocilaIconsInStudioPreview.get(4).click();
	    	CreateStudioandsettings.windowhandle();
	    	
	    }
	    @Given("^Click on Contact info mini tiltle tab$")
	    public void click_on_contact_info_mini_tiltle_tab() throws Throwable {
	    	Thread.sleep(2000);
	    	CreateStudioandsettings.CreateStudioMiniTabTitle.get(2).click();
	    }

	    @When("^The Studio name field name is \"([^\"]*)\"$")
	    public void the_studio_name_field_name_is_something(String studioownername) throws Throwable {
	    	String Studioownername=CreateStudioandsettings.FieldNames.get(8).getText();
	    	log.info(Studioownername);
	    	assertEquals(Studioownername, studioownername);
	    	String placeholder=CreateStudioandsettings.StudioOwnerName.getAttribute("placeholder");
	    	log.info(placeholder);
	    	assertEquals("Enter your Name", placeholder);
	    }

	    @Then("^The Email Address field name is \"([^\"]*)\"$")
	    public void the_email_address_field_name_is_something(String Fieldname) throws Throwable {
	    	String Emailfieldname=CreateStudioandsettings.FieldNames.get(9).getText();
	    	log.info(Emailfieldname);
	    	assertEquals(Emailfieldname, Fieldname);
	    	CreateStudioandsettings.EmailEditbutton.click();
	    	CreateStudioandsettings.StudioOwnerEmail.clear();
	    	String placeholder=CreateStudioandsettings.StudioOwnerEmail.getAttribute("placeholder");
	    	log.info(placeholder);
	    	assertEquals("Enter Mail Id", placeholder);
	    }

	    @Then("^The Phone Number field name is \"([^\"]*)\"$")
	    public void the_phone_number_field_name_is_something(String Fieldname) throws Throwable {
	    	String phonenumberfield=CreateStudioandsettings.FieldNames.get(10).getText();
	    	log.info(phonenumberfield);
	    	assertEquals(phonenumberfield, Fieldname);
	    	
	    }

	    @And("^The Studio name description is \"([^\"]*)\"$")
	    public void the_studio_name_description_is_something(String description) throws Throwable {
	        String studioownerdesc=CreateStudioandsettings.FieldNameDescriptions.get(3).getText();
	        log.info(studioownerdesc);
	        assertEquals(studioownerdesc, description);
	    }

	    @And("^The Email Address field description is \"([^\"]*)\"$")
	    public void the_email_address_field_description_is_something(String description) throws Throwable {
	    	String emaildesc=CreateStudioandsettings.FieldNameDescriptions.get(4).getText();
	        log.info(emaildesc);
	        assertEquals(emaildesc, description);
	    }

	    @And("^The Phone Number field escription is \"([^\"]*)\"$")
	    public void the_phone_number_field_escription_is_something(String description) throws Throwable {
	    	String phonenumberdesc=CreateStudioandsettings.FieldNameDescriptions.get(5).getText();
	        log.info(phonenumberdesc);
	        assertEquals(phonenumberdesc, description);
	    }
	    @Given("^Give Studio owner name as (.+)$")
	    public void give_studio_owner_name_as(String ownername) throws Throwable {
	    	CreateStudioandsettings.StudioNameField.sendKeys("kjkjkjakj");
	    	Thread.sleep(2000);
	    	CreateStudioandsettings.CreateStudioMiniTabTitle.get(2).click();
	    	Thread.sleep(1000);
	    	
	    	CreateStudioandsettings.CreateStudioPageButton.click();
	    	String errormessage1=CreateStudioandsettings.AllErrorMessages.get(3).getText();
	    	log.info(errormessage1);
	    	assertEquals(errormessage1,"Studio Owner Name is required");
	    	CreateStudioandsettings.StudioOwnerName.sendKeys(ownername);
	    	String errormessage2=CreateStudioandsettings.AllErrorMessages.get(3).getText();
	    	log.info(errormessage2);
	    	assertEquals(errormessage2, "Minimum 3 characters allowed");
	    	
	    	
	    }
	    @Then("^Edit the Email field and give inavlid Email id$")
	    public void edit_the_email_field_and_give_inavlid_email_id() throws Throwable {
	    	CreateStudioandsettings.EmailEditbutton.click();
	    	CreateStudioandsettings.StudioOwnerEmail.clear();
	    	/*Thread.sleep(1000);
	    	String errormessage=CreateStudioandsettings.EmailErrormessage.getText();
	    	log.info(errormessage);
	    	assertEquals(errormessage, "Email Address is required");*/
	    	CreateStudioandsettings.StudioOwnerEmail.sendKeys("ajhajsha");
	    	String errormessage1=CreateStudioandsettings.EmailErrormessage.getText();
	    	log.info(errormessage1);
	    	assertEquals(errormessage1, "Email must be a valid email address");
	    	
	    }
	    @And("^Edit the Phone number field and check request otp button is disabled$")
	    public void edit_the_phone_number_field_and_check_request_otp_button_is_disabled() throws Throwable {
	    	Thread.sleep(2000);
	    	CreateStudioandsettings.CreateStudioMiniTabTitle.get(2).click();
	    	Thread.sleep(1000);
	    	CreateStudioandsettings.PhoneNumberEdit.click();
	    	Thread.sleep(2000);
	    	assertTrue(CreateStudioandsettings.OTPPopupWindowtext.isDisplayed());
	    	log.info(CreateStudioandsettings.OTPPopupWindowtext.getText());
	    	assertEquals(CreateStudioandsettings.OTPPopupWindowtext.getText(), "Verify your phone");
	    	CreateStudioandsettings.PhoneNumberFieldinPopup.click();
	    	Thread.sleep(1500);
	    	CreateStudioandsettings.PhoneNumberFieldinPopup.clear();
	    	CreateStudioandsettings.PhoneNumberFieldinPopup.sendKeys("8575757");
	    	Thread.sleep(1500);
	    	String errormessage1=CreateStudioandsettings.ErrorMessages.getText();
	    	log.info(errormessage1);
	    	assertEquals("Please enter valid mobile number", errormessage1);
	    	CreateStudioandsettings.PhoneNumberFieldinPopup.clear();
	    	CreateStudioandsettings.PhoneNumberFieldinPopup.sendKeys("85757576746547654");
	    	Thread.sleep(1500);
	    	String errormessage2=CreateStudioandsettings.ErrorMessages.getText();
	    	log.info(errormessage2);
	    	assertEquals("Please enter valid mobile number", errormessage2);
	    	CreateStudioandsettings.PhoneNumberFieldinPopup.clear();
	    	CreateStudioandsettings.PhoneNumberFieldinPopup.sendKeys("9542840307");
	    	assertTrue(CreateStudioandsettings.RequestOTPButton.isEnabled());
	    	Thread.sleep(500);
	    	/*Actions a=new Actions(driver);
	    	a.moveToElement(CreateStudioandsettings.OTPPopupCloseIcon).click().build().perform();*/
	    	
	    	js.executeScript("arguments[0].click();", CreateStudioandsettings.OTPPopupCloseIcon);
	    	
	    }
	    @Given("^The Studio Address field name is \"([^\"]*)\"$")
	    public void the_studio_address_field_name_is_something(String FieldName) throws Throwable {
	    	String StudioAddressFiledName=CreateStudioandsettings.StudioAddressFieldName.getText();
	    	log.info(StudioAddressFiledName);
	    	assertEquals(FieldName, StudioAddressFiledName);
	    }

	    @Then("^Enter Studio Address in to the field$")
	    public void enter_studio_address_in_to_the_field() throws Throwable {
	    	CreateStudioandsettings.StudioAddressField.sendKeys("Guindy");
	    	Thread.sleep(2000);
	    	Actions a=new Actions(driver);
	    	a.sendKeys(Keys.ARROW_DOWN).build().perform();
			a.sendKeys(Keys.ENTER).build().perform();
	    }
	    @When("^Check all the Placeholders$")
	    public void check_all_the_placeholders() throws Throwable {
	    	String Placeholder1=CreateStudioandsettings.StudioAddressField.getAttribute("placeholder");
	    	log.info(Placeholder1);
	    	assertEquals(Placeholder1, "Enter your Address");
	    	String Placeholder2=CreateStudioandsettings.StudioCity.getAttribute("placeholder");
	    	log.info(Placeholder2);
	    	assertEquals(Placeholder2, "City");
	    	String Placeholder3=CreateStudioandsettings.StudioState.getAttribute("placeholder");
	    	log.info(Placeholder3);
	    	assertEquals(Placeholder3, "State");
	    	String Placeholder4=CreateStudioandsettings.StudioCountry.getAttribute("placeholder");
	    	log.info(Placeholder4);
	    	assertEquals(Placeholder4, "Country");
	    	String Placeholder5=CreateStudioandsettings.StudioPinCode.getAttribute("placeholder");
	    	log.info(Placeholder5);
	    	assertEquals(Placeholder5, "Pincode");
	    }

	    @And("^The Studio Address field description is \"([^\"]*)\"$")
	    public void the_studio_address_field_description_is_something(String Fileddesc) throws Throwable {
	    	String Description=CreateStudioandsettings.StudioAddressFieldDescription.getText();
	    	log.info(Description);
	    	assertEquals(Fileddesc, Description);
	    }
	    @Given("^Fill all the details except the studio address$")
	    public void fill_all_the_details_except_the_studio_address() throws Throwable {
	    	String studioname=CreateStudioandsettings.random();
	    	CreateStudioandsettings.StudioNameField.sendKeys(studioname);
	    	CreateStudioandsettings.CreateStudioMiniTabTitle.get(1).click();
	    	Thread.sleep(1500);
	    	CreateStudioandsettings.AddThumbnailField.click();
	    	Thread.sleep(1000);
	    	Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\Autoit\\Studioprofile.exe");
	    	CreateStudioandsettings.ThumbnailSavebutton.click();
	    	CreateStudioandsettings.StudioDescription.sendKeys("Sameer studios");
	    	CreateStudioandsettings.StudioVisiblity.get(0).click();
	    	CreateStudioandsettings.CreateStudioMiniTabTitle.get(2).click();
	    	Thread.sleep(1500);
	    	CreateStudioandsettings.StudioOwnerName.sendKeys("Sameer");
	    	CreateStudioandsettings.CheckBox.click();
	    	CreateStudioandsettings.CreateStudioPageButton.click();
	    	
	    }

	    @Then("^Check the errormessage$")
	    public void check_the_errormessage() throws Throwable {
	    	wait.until(ExpectedConditions.visibilityOf(CreateStudioandsettings.ErrorMessages));
	    	String Errormessage=CreateStudioandsettings.ErrorMessages.getText();
	    	log.info(Errormessage);
	    	assertEquals(Errormessage, "Studio Address is required");
	    	
	    }
	    @Given("^the footer text should match and check box should select$")
	    public void the_footer_text_should_match_and_check_box_should_select() throws Throwable {
	    	String studioname=CreateStudioandsettings.random();
	    	CreateStudioandsettings.StudioNameField.sendKeys(studioname);
	    	String text=CreateStudioandsettings.CheckboxVerifyText.getText();
	    	log.info(text);
	    	assertEquals(text, "I verify that I'am an authorized representative "
	    			+ "of this organization and have the right to act on it's in the creation "
	    			+ "and management of this page. The organization and I agree to the additional "
	    			+ "terms for pages.");
	    	CreateStudioandsettings.CheckBox.click();
	    	wait.until(ExpectedConditions.attributeToBe(CreateStudioandsettings.CheckBoxAttribute, "aria-checked", "true"));
	    	String checkboxaatribute1=CreateStudioandsettings.CheckBoxAttribute.getAttribute("aria-checked");
	    	assertEquals(checkboxaatribute1, "true");
	    	CreateStudioandsettings.CheckBox.click();
	    	String checkboxaatribute2=CreateStudioandsettings.CheckBoxAttribute.getAttribute("aria-checked");
	    	assertEquals(checkboxaatribute2, "false");
	    	
	    }

	    @When("^After filling all details do (.+)$")
	    public void after_filling_all_details_do(String action) throws Throwable {
	    	CreateStudioandsettings.StudioNameField.clear();
	    	String studioname=CreateStudioandsettings.random();
	    	CreateStudioandsettings.StudioNameField.sendKeys(studioname);
	    	log.info(studioname);
	    	//log.info(CreateStudioandsettings.StudioNameField.getText());
	    	CreateStudioandsettings.CreateStudioMiniTabTitle.get(1).click();
	    	Thread.sleep(1500);
	    	CreateStudioandsettings.AddThumbnailField.click();
	    	Thread.sleep(1000);
	    	Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\Autoit\\Studioprofile.exe");
	    	CreateStudioandsettings.ThumbnailSavebutton.click();
	    	CreateStudioandsettings.StudioDescription.sendKeys("Sameer studios");
	    	CreateStudioandsettings.StudioVisiblity.get(0).click();
	    	CreateStudioandsettings.CreateStudioMiniTabTitle.get(2).click();
	    	Thread.sleep(1500);
	    	CreateStudioandsettings.StudioOwnerName.sendKeys("Sameer");
	    	CreateStudioandsettings.StudioAddressField.sendKeys("Guindy");
	    	Thread.sleep(1500);
	    	Actions a=new Actions(driver);
	    	a.sendKeys(Keys.ARROW_DOWN).build().perform();
			a.sendKeys(Keys.ENTER).build().perform();
			CreateStudioandsettings.StudioPinCode.sendKeys("600006");
			CreateStudioandsettings.CheckBox.click();
			Thread.sleep(3000);
			if(action.equalsIgnoreCase("cancelbutton"))
			{
				CreateStudioandsettings.CreateStudioCancelButton.click();
				Thread.sleep(1000);
				assertTrue(socialpageandsearch.logoheaderm().isDisplayed());
			}
			else if(action.equalsIgnoreCase("cancelpage"))
			{
				CreateStudioandsettings.CreateStudioPageCloseIcon.click();
				Thread.sleep(1000);
				assertTrue(socialpageandsearch.logoheaderm().isDisplayed());
			}
			else if(action.equalsIgnoreCase("createstudio"))
			{
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("arguments[0].click();", CreateStudioandsettings.CreateStudioPageButton);
				wait.until(ExpectedConditions.visibilityOf(CreateStudioandsettings.PublishButton));
				assertTrue(CreateStudioandsettings.StudioImageInProfilePreview.isDisplayed());
				assertTrue(CreateStudioandsettings.StudioVisiblity.get(0).isDisplayed());
				wait.until(ExpectedConditions.textToBePresentInElement(CreateStudioandsettings.SavedText, "Saved"));
				assertEquals(CreateStudioandsettings.SavedText.getText(), "Saved");
				assertTrue(CreateStudioandsettings.SavedText.isDisplayed());
				assertTrue(CreateStudioandsettings.PublishButton.isDisplayed());
				assertTrue(CreateStudioandsettings.StudioSettingsbutton.isDisplayed());
				assertEquals(CreateStudioandsettings.Studionameaftercreatestudio.getText(), studioname);
				CreateStudioandsettings.PublishButton.click();
				String toastmessage=Toastanderrormessages.toastmessagem().getText();
				assertEquals(toastmessage, "Your Studio has been published successfully");	
			}
	    }
	    @Given("^Gather all studio Info in My studio page and check the same in Studio Preview page$")
	    public void gather_all_studio_info_in_my_studio_page_and_check_the_same_in_studio_preview_page() throws Throwable {
	    	String StudioNameinMyStudio=CreateStudioandsettings.Studionameaftercreatestudio.getText();
	    	log.info(StudioNameinMyStudio);
	    	String StudioDescriptioninMyStudio=CreateStudioandsettings.Studiodescriptionaftercreatestudio.getText();
	    	log.info(StudioDescriptioninMyStudio);
	    	CreateStudioandsettings.PreviewButton.click();
	    	String MainWindow=driver.getWindowHandle();				
	        Set<String> s1=driver.getWindowHandles();		
	        Iterator<String> i1=s1.iterator();			
	        while(i1.hasNext())			
	        {		
	         String ChildWindow=i1.next();		
	        		
	         if(!MainWindow.equalsIgnoreCase(ChildWindow))			
	         {    	
	         	driver.switchTo().window(ChildWindow);
	         	wait.until(ExpectedConditions.visibilityOf(CreateStudioandsettings.StudioNameinPreviewPage));
	         	String Studionameinpreviewpage=CreateStudioandsettings.StudioNameinPreviewPage.getText();
	         	log.info(Studionameinpreviewpage);
	         	assertEquals(Studionameinpreviewpage, Studionameinpreviewpage);
	         	assertTrue(CreateStudioandsettings.StudioImageinPreviewPage.isDisplayed());
	         	assertTrue(CreateStudioandsettings.FollowButtoninPreviewPage.isDisplayed());
	         	assertTrue(CreateStudioandsettings.InfoButtoninPreviewPage.isDisplayed());
	         	assertTrue(CreateStudioandsettings.SocialShareButtons.isDisplayed());
	         	CreateStudioandsettings.InfoButtoninPreviewPage.click();
	         	assertTrue(CreateStudioandsettings.FollowUsOnButton.isDisplayed());
	         	assertTrue(CreateStudioandsettings.DescriptioninPrviewPage.isDisplayed());
	            driver.close();
	         		
	         }		
	            driver.switchTo().window(MainWindow);
	            
	         }
	    
         }
	    
	    @Given("^Click on profile and click on My Studio$")
        public void click_on_profile_and_click_on_my_studio() throws Throwable {
	    	Actions a=new Actions(driver);
		       a.moveToElement(Accountandsettings.mousehoveronprofilem()).build().perform();
		       CreateStudioandsettings.CreateStudioButton.click();
		       wait.until(ExpectedConditions.visibilityOf(CreateStudioandsettings.Studionameaftercreatestudio));
		       Thread.sleep(2000);
		       
		       
        }
	    
	    @Given("^visibility of studio to (.+)$")
	    public void visibility_of_studio_to(String visibility) throws Throwable {
	    	for(int i=0;i<CreateStudioandsettings.StudioVisiblity.size();i++)
	    	{
	    		String str=CreateStudioandsettings.StudioVisiblity.get(i).getText();
	    		String str1=str.replace("\n", " ");
	    		String visibilitytext=str1.substring(0,str1.lastIndexOf(" "));
	    		log.info(visibilitytext);
	    		if(visibilitytext.equalsIgnoreCase(visibility))
	    		{
	    			js.executeScript("arguments[0].click();", CreateStudioandsettings.StudioVisiblity.get(i));
	    			
	    		}
	    	}

	    }

	    @When("^Go to frontend and search the studio$")
	    public void go_to_frontend_and_search_the_studio() throws Throwable {
	    	String StudioName=CreateStudioandsettings.Studionameaftercreatestudio.getText();
	    	log.info(StudioName);
	    	CreateStudioandsettings.StudioLogoHeadder.click();
	        Thread.sleep(2000);
	        socialpageandsearch.homepagesearch().sendKeys(StudioName);
	        Actions a=new Actions(driver);
	   	   Thread.sleep(500);
	   	   for(int i=0;i<CreateStudioandsettings.AutodropdownInSearch.size();i++)
	   	   {
	   		  
	   		   if(CreateStudioandsettings.AutodropdownInSearch.get(i).getText().equalsIgnoreCase(StudioName))
	   		   {
	   			   a.moveToElement(CreateStudioandsettings.AutodropdownInSearch.get(i)).click().build().perform();
	   			   break;
	   		   }
	   	   }
	        try {
	        	Thread.sleep(1000);
		        String str=Studioprofile.studionameonstudiopagem().getText();
	        	assertTrue(str.equalsIgnoreCase(StudioName));
	        }
	        catch(Exception e)
	        {
	        	assertTrue(socialpageandsearch.nosearchfoundtext().isDisplayed());
	        	assertEquals(socialpageandsearch.nosearchfoundtext().getText(),"No Search Results Found");
	        	
	        }
	        
	    }
	    @Given("^Check the studio settings slide bar is opened$")
	    public void check_the_studio_settings_slide_bar_is_opened() throws Throwable {
	    	CreateStudioandsettings.StudioSettingsbutton.click();
	    	wait.until(ExpectedConditions.textToBePresentInElement(CreateStudioandsettings.StudioSettingText, "Studio Settings"));
	    	String StudioSettingstext=CreateStudioandsettings.StudioSettingText.getText();
	    	log.info(StudioSettingstext);
	    	assertEquals(StudioSettingstext, "Studio Settings");
	    	String StuidoProfileIdentityText=CreateStudioandsettings.StudioIdentityText.getText();
	    	log.info(StuidoProfileIdentityText);
	    	assertEquals(StuidoProfileIdentityText, "Studio Profile Identity");
	    	String ContactInfoText=CreateStudioandsettings.ContactInfoText.getText();
	    	log.info(ContactInfoText);
	    	assertEquals(ContactInfoText, "Contact Info");
	    	
	    }

	    @Then("^Check all the field Names are displaying$")
	    public void check_all_the_field_names_are_displaying() throws Throwable {
	    	log.info(CreateStudioandsettings.StudioFieldNames.get(0).getText());
	    	assertEquals(CreateStudioandsettings.StudioFieldNames.get(0).getText(), "Studio Picture *");
	    	log.info(CreateStudioandsettings.StudioFieldNames.get(1).getText());
	    	assertEquals(CreateStudioandsettings.StudioFieldNames.get(1).getText(), "About Studio*");
	    	log.info(CreateStudioandsettings.StudioFieldNames.get(2).getText());
	    	assertEquals(CreateStudioandsettings.StudioFieldNames.get(2).getText(), "Studio Visibility*");
	    	log.info(CreateStudioandsettings.StudioFieldNames.get(3).getText());
	    	assertEquals(CreateStudioandsettings.StudioFieldNames.get(3).getText(), "Facebook");
	    	log.info(CreateStudioandsettings.StudioFieldNames.get(4).getText());
	    	assertEquals(CreateStudioandsettings.StudioFieldNames.get(4).getText(), "Twitter");
	    	log.info(CreateStudioandsettings.StudioFieldNames.get(5).getText());
	    	assertEquals(CreateStudioandsettings.StudioFieldNames.get(5).getText(), "Linkedin");
	    	log.info(CreateStudioandsettings.StudioFieldNames.get(6).getText());
	    	assertEquals(CreateStudioandsettings.StudioFieldNames.get(6).getText(), "Instagram");
	    	log.info(CreateStudioandsettings.StudioFieldNames.get(7).getText());
	    	assertEquals(CreateStudioandsettings.StudioFieldNames.get(7).getText(), "Website");
	    	log.info(CreateStudioandsettings.StudioFieldNames.get(8).getText());
	    	assertEquals(CreateStudioandsettings.StudioFieldNames.get(8).getText(), "Studio Owner Name*");
	    	log.info(CreateStudioandsettings.StudioFieldNames.get(9).getText());
	    	assertEquals(CreateStudioandsettings.StudioFieldNames.get(9).getText(), "Email Address*");
	    	log.info(CreateStudioandsettings.StudioFieldNames.get(10).getText());
	    	assertEquals(CreateStudioandsettings.StudioFieldNames.get(10).getText(), "Phone Number*");
	    	log.info(CreateStudioandsettings.StudioAddressFieldinStudioSettings.getText());
	    	assertEquals(CreateStudioandsettings.StudioAddressFieldinStudioSettings.getText(), "Studio Address*");	
	    }
	    @When("^The File Supported text is showing$")
	    public void the_file_supported_text_is_showing() throws Throwable {
	    	String str=CreateStudioandsettings.ThumbnailSupportedText.getText();
	    	String str1=str.replace("\n", " ");
	    	log.info(str1);
	    	assertEquals("Recommended height 200px JPEGs, and PNGs supported.", str1);
	    	
	    }
	    @And("^Edit the Studio Profile image$")
	    public void edit_the_studio_profile_image() throws Throwable {
	    	CreateStudioandsettings.ThumbnailEditIcon.click();
	    	Thread.sleep(1000);
	    	Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\Autoit\\Studioprofileinvalid.exe");
	    	wait.until(ExpectedConditions.visibilityOf(Toastanderrormessages.alerdailogm()));
        	String actualtoastmessage=Toastanderrormessages.alerdailogm().getText();
        	log.info(actualtoastmessage);
        	assertEquals(actualtoastmessage, "Recommended height 200px");
        	Toastanderrormessages.toastmessageclosem().click();
        	CreateStudioandsettings.ThumbnailEditIcon.click();
        	Thread.sleep(1500);
	    	Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\Autoit\\Studioprofile.exe");
	    	Thread.sleep(1000);
	    	CreateStudioandsettings.ThumbnailSavebutton.click();
	    	assertTrue(CreateStudioandsettings.SaveButtoninSettings.isEnabled());
	    	CreateStudioandsettings.SaveButtoninSettings.click();
	    	wait.until(ExpectedConditions.visibilityOf(Toastanderrormessages.toastmessagem()));
	    	String actualtoast1=Toastanderrormessages.toastmessagem().getText();
	    	log.info(actualtoast1);
	    	assertEquals("Studio details has been saved successfully", actualtoast1);
	    
	    }

	    @Given("^Enter more description and check the chracters count are showing$")
	    public void enter_more_description_and_check_the_chracters_count_are_showing() throws Throwable {
	    	CreateStudioandsettings.StudioSettingsbutton.click();
	    	wait.until(ExpectedConditions.visibilityOf(CreateStudioandsettings.StudioSettingText));
	    	CreateStudioandsettings.StudioDescription.sendKeys("sameerrrrrrr");
	    	assertTrue(CreateStudioandsettings.StuioDescriptionChractersCount.isDisplayed());
	    	CreateStudioandsettings.SaveButtoninSettings.click();
	    	wait.until(ExpectedConditions.visibilityOf(Toastanderrormessages.toastmessagem()));
	    	String actualtoast1=Toastanderrormessages.toastmessagem().getText();
	    	log.info(actualtoast1);
	    	assertEquals("Studio details has been saved successfully", actualtoast1);
	    	CreateStudioandsettings.StudioSettingsbutton.click();
	    	/*CreateStudioandsettings.StudioDescription.clear();
	    	String placeholder=CreateStudioandsettings.StudioDescription.getAttribute("placeholder");
	    	assertEquals("Description", placeholder);
	    	String Actualerror=CreateStudioandsettings.ErrorMessagesinStudioSettings.getText();
	    	log.info(Actualerror);
	    	assertEquals("Actualerror", "Please fill the description");*/
	    	
	    	
	    }
	    @And("^Check the error messages with (.+)$")
	    public void check_the_error_messages_with(String invalidurls) throws Throwable {
	    	CreateStudioandsettings.FacebookField.clear();
	    	CreateStudioandsettings.FacebookField.sendKeys(invalidurls);
	    	String invalidurlforfacebook1=CreateStudioandsettings.ErrorMessagesinStudioSettings.getText();
	    	log.info(invalidurlforfacebook1);
	    	assertEquals(invalidurlforfacebook1, "Only URL allowed");
	    	CreateStudioandsettings.FacebookField.clear();
	    	CreateStudioandsettings.FacebookField.sendKeys("https://facebook.com");
	    	
	    	CreateStudioandsettings.TwitterField.clear();
	    	CreateStudioandsettings.TwitterField.sendKeys(invalidurls);
	    	String invalidtwitter=CreateStudioandsettings.ErrorMessagesinStudioSettings.getText();
	    	log.info(invalidtwitter);
	    	assertEquals(invalidtwitter, "Only URL allowed");
	    	CreateStudioandsettings.TwitterField.clear();
	    	CreateStudioandsettings.TwitterField.sendKeys("https://twitter.com");
	    	
	    	CreateStudioandsettings.LinkedinField.clear();
	    	CreateStudioandsettings.LinkedinField.sendKeys(invalidurls);
	    	String invalidlinkedin=CreateStudioandsettings.ErrorMessagesinStudioSettings.getText();
	    	log.info(invalidlinkedin);
	    	assertEquals(invalidlinkedin, "Only URL allowed");
	    	CreateStudioandsettings.LinkedinField.clear();
	    	CreateStudioandsettings.LinkedinField.sendKeys("https://linkedin.com");
	    	
	    	CreateStudioandsettings.InstagramField.clear();
	    	CreateStudioandsettings. InstagramField.sendKeys(invalidurls);
	    	String invalidinstagram=CreateStudioandsettings.ErrorMessagesinStudioSettings.getText();
	    	log.info(invalidinstagram);
	    	assertEquals(invalidinstagram, "Only URL allowed");
	    	CreateStudioandsettings.InstagramField.clear();
	    	CreateStudioandsettings.InstagramField.sendKeys("https://instagram.com");
	    	
	    	CreateStudioandsettings.WebSiteField.clear();
	    	CreateStudioandsettings. WebSiteField.sendKeys(invalidurls);
	    	String invalidwebsite=CreateStudioandsettings.ErrorMessagesinStudioSettings.getText();
	    	log.info(invalidwebsite);
	    	assertEquals(invalidwebsite, "Only URL allowed");
	    	CreateStudioandsettings.WebSiteField.clear();
	    	CreateStudioandsettings.WebSiteField.sendKeys("https://gudsho.com");
	    	
	    	CreateStudioandsettings.SaveButtoninSettings.click();
	    	wait.until(ExpectedConditions.visibilityOf(Toastanderrormessages.toastmessagem()));
	    	String actualtoast1=Toastanderrormessages.toastmessagem().getText();
	    	log.info(actualtoast1);
	    	assertEquals("Studio details has been saved successfully", actualtoast1);
	    }


	    @Given("^Open the Studio Settings$")
	    public void open_the_studio_settings() throws Throwable {
	    	CreateStudioandsettings.StudioSettingsbutton.click();
	    	wait.until(ExpectedConditions.visibilityOf(CreateStudioandsettings.StudioSettingText));
	    }
	    @And("^Save the profile$")
	    public void save_the_profile() throws Throwable {
	    	CreateStudioandsettings.SaveButtoninSettings.click();
	    	wait.until(ExpectedConditions.visibilityOf(Toastanderrormessages.toastmessagem()));
	    	String actualtoast1=Toastanderrormessages.toastmessagem().getText();
	    	log.info(actualtoast1);
	    	assertEquals("Studio details has been saved successfully", actualtoast1);
	    	Toastanderrormessages.toastmessageclosem().click();
	    }
	    
        //***************************************************************************//
	    
	    @When("^clear the studio owner name and check the error message as \"([^\"]*)\"$")
	    public void clear_the_studio_owner_name_and_check_the_error_message_as_something(String errormessage) throws Throwable {
	    	CreateStudioandsettings.StudioOwnerName.clear();
	    	Actions a=new Actions(driver);
	    	a.moveToElement(CreateStudioandsettings.StudioOwnerName).click().sendKeys(Keys.SPACE).build().perform();
	    	a.moveToElement(CreateStudioandsettings.StudioOwnerName).click().sendKeys(Keys.BACK_SPACE).build().perform();
	    	CreateStudioandsettings.SaveButtoninSettings.click();
	    	String actualerror=CreateStudioandsettings.ErrorMessagesinStudioSettings.getText();
	    	assertEquals(actualerror,errormessage);
	    }
	    @And("^The Studio owner name field name as \"([^\"]*)\"$")
	    public void the_studio_owner_name_field_name_as_something(String studioownerfiledname) throws Throwable {
	    	String expectedname=CreateStudioandsettings.StudioFieldNames.get(8).getText();
	    	assertEquals(expectedname, studioownerfiledname);
	    }

	    @Then("^Enter invalid (.+)$")
	    public void Enter_invalid(String studioownername) throws Throwable {
	    	CreateStudioandsettings.StudioOwnerName.sendKeys(studioownername);
	    	
	    }

	    @And("^Check the studio owner name placeholder$")
	    public void check_the_studio_owner_name_placeholder() throws Throwable {
	    	String actualplaceholder=CreateStudioandsettings.StudioOwnerName.getAttribute("placeholder");
	    	assertEquals(actualplaceholder, "Enter your Name");
	    }
	    @Then("^Enter space in the filed and check the (.+)$")
	    public void enter_space_in_the_filed_and_check_the(String errormessage) throws Throwable {
	    	CreateStudioandsettings.StudioOwnerName.clear();
	    	Actions a=new Actions(driver);
	    	a.moveToElement(CreateStudioandsettings.StudioOwnerName).click().sendKeys(Keys.SPACE).build().perform();
	    	String actual=CreateStudioandsettings.ErrorMessagesinStudioSettings.getText();
	    	assertEquals(actual, errormessage);
	    }

	    @And("^Enter single digit and check the (.+)$")
	    public void enter_single_digit_and_check_the(String errormessage) throws Throwable {
	    	CreateStudioandsettings.StudioOwnerName.clear();
	    	CreateStudioandsettings.StudioOwnerName.sendKeys("a");
	    	String actual=CreateStudioandsettings.ErrorMessagesinStudioSettings.getText();
	    	assertEquals(actual, errormessage);
	    	
	    }
	    @Then("^Enter valid Studio owner name as \"([^\"]*)\"$")
	    public void enter_valid_studio_owner_name_as_something(String studioownername) throws Throwable {
	    	CreateStudioandsettings.StudioOwnerName.clear();
	    	CreateStudioandsettings.StudioOwnerName.sendKeys(studioownername);
	    }

	    @And("^check the (.+)$")
	    public void check_the(String invaliderrormessage) throws Throwable {
	    	String expectederror=CreateStudioandsettings.EmailInvalidAddressErrorMessage.getText();
	    	assertEquals(expectederror, invaliderrormessage);
	    }
	    @When("^Clear the Email field and check the errormessage as \"([^\"]*)\"$")
	    public void clear_the_email_field_and_check_the_errormessage_as_something(String actual) throws Throwable {
	    	//CreateStudioandsettings.EmailEditButtonInStudioSettings.click();
	    	CreateStudioandsettings.StudioOwnerEmail.clear();
	    	CreateStudioandsettings.StudioOwnerEmail.sendKeys("a");
	    	CreateStudioandsettings.StudioOwnerEmail.clear();
	    	CreateStudioandsettings.SaveButtoninSettings.click();
	    	Thread.sleep(500);
	    	String expected=CreateStudioandsettings.EmailInvalidAddressErrorMessage.getText();
	    	assertEquals(expected, actual);
	    }

	    @Then("^The field name should be display as \"([^\"]*)\"$")
	    public void the_field_name_should_be_display_as_something(String expecetd) throws Throwable {
	    	String actual=CreateStudioandsettings.StudioFieldNames.get(9).getText();
	    	assertEquals(actual, expecetd);
	    }

	    @Then("^Edit the Email address and give (.+)$")
	    public void edit_the_email_address_and_give(String invalidemail) throws Throwable {
	    	CreateStudioandsettings.StudioOwnerEmail.sendKeys(invalidemail);
	    }

	    @And("^Check the Email id placeholder$")
	    public void check_the_email_id_placeholder() throws Throwable {
	    	String expected=CreateStudioandsettings.StudioOwnerEmail.getAttribute("placeholder");
	    	assertEquals(expected, "Enter Mail Id");
	    }
	    @Then("^Give valid Email id as \"([^\"]*)\"$")
	    public void give_valid_email_id_as_something(String Studioemailid) throws Throwable {
	    	CreateStudioandsettings.StudioOwnerEmail.clear();
	    	CreateStudioandsettings.StudioOwnerEmail.sendKeys(Studioemailid);
	    }
	    @When("^The Studio Email id Field name should be display as \"([^\"]*)\"$")
	    public void the_studio_email_id_field_name_should_be_display_as_something(String expected) throws Throwable {
	    	String actual=CreateStudioandsettings.StudioFieldNames.get(10).getText();
	    	assertEquals(actual, expected);
	    }

	    @When("^Check Studio phone number field should diaplay as \"([^\"]*)\"$")
	    public void check_studio_phone_number_field_should_diaplay_as_something(String expected) throws Throwable {
	    	String actual=CreateStudioandsettings.StudioFieldNames.get(10).getText();
	    	assertEquals(actual, expected);
	    }

	    @Then("^Edit the phone number field$")
	    public void edit_the_phone_number_field() throws Throwable {
	    	Actions a=new Actions(driver);
	    	a.moveToElement(CreateStudioandsettings.PhoneNumberEditInStudioSettings).click().build().perform();
	    	
	    	Thread.sleep(2000);
	    }

	    @And("^check request otp button is disabled$")
	    public void check_request_otp_button_is_disabled() throws Throwable {
	    	assertTrue(CreateStudioandsettings.OTPPopupWindowtext.isDisplayed());
	    	log.info(CreateStudioandsettings.OTPPopupWindowtext.getText());
	    	assertEquals(CreateStudioandsettings.OTPPopupWindowtext.getText(), "Verify your phone");
	    	CreateStudioandsettings.PhoneNumberFieldinPopup.click();
	    	Thread.sleep(1500);
	    	CreateStudioandsettings.PhoneNumberFieldinPopup.clear();
	    	CreateStudioandsettings.PhoneNumberFieldinPopup.sendKeys("8575757");
	    	Thread.sleep(1500);
	    	String errormessage1=CreateStudioandsettings.ErrorMessages.getText();
	    	log.info(errormessage1);
	    	assertEquals("Please enter valid mobile number", errormessage1);
	    	CreateStudioandsettings.PhoneNumberFieldinPopup.clear();
	    	CreateStudioandsettings.PhoneNumberFieldinPopup.sendKeys("85757576746547654");
	    	Thread.sleep(1500);
	    	String errormessage2=CreateStudioandsettings.ErrorMessages.getText();
	    	log.info(errormessage2);
	    	assertEquals("Please enter valid mobile number", errormessage2);
	    	CreateStudioandsettings.PhoneNumberFieldinPopup.clear();
	    	CreateStudioandsettings.PhoneNumberFieldinPopup.sendKeys("9542840307");
	    	assertTrue(CreateStudioandsettings.RequestOTPButton.isEnabled());
	    	Thread.sleep(500);
	    	js.executeScript("arguments[0].click();", CreateStudioandsettings.OTPPopupCloseIcon);
	    }
	    @When("^Check the Studio Address Field should display as \"([^\"]*)\"$")
	    public void check_the_studio_address_field_should_display_as_something(String expected) throws Throwable {
	    	String actual=CreateStudioandsettings.StudioAddressFieldinStudioSettings.getText();
	    	log.info(actual);
	    	assertEquals(actual, expected);
	    }
	    @Then("^Clear the field and check the placeholder$")
	    public void clear_the_field_and_check_the_placeholder() throws Throwable {
	    	CreateStudioandsettings.StudioAddressField.clear();
	    	String actual=CreateStudioandsettings.StudioAddressField.getAttribute("placeholder");
	    	log.info(actual);
	    	assertEquals(actual, "Enter your Address");
	    	Thread.sleep(20000);
	    }
	 
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    @Given("^Go to Studio End by clicking on My studio or create studio$")
	    public void go_to_studio_end_by_clicking_on_my_studio_or_create_studio() throws Throwable {
	    	Actions a=new Actions(driver);
		       a.moveToElement(Accountandsettings.mousehoveronprofilem()).build().perform();
		       CreateStudioandsettings.CreateStudioButton.click();
	        try {
	        	 wait.until(ExpectedConditions.visibilityOf(CreateStudioandsettings.CreateStudioPageHeading));
	  	       String Heading=CreateStudioandsettings.CreateStudioPageHeading.getText();
	  	       log.info(Heading);
	  	       assertEquals(Heading, "Create Studio Page");
	  	       String description=CreateStudioandsettings.CreateStudioPageDescription.getText();
	  	       log.info(description);
	  	       assertEquals(description, "Get started by giving few details about your studio"); 
	          }
	        catch(Exception e)
	        {
	        	wait.until(ExpectedConditions.visibilityOf(CreateStudioandsettings.Studionameaftercreatestudio));
			       Thread.sleep(2000);
	        }
	    }


}
