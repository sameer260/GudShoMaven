package PageObjects.studioend;

import java.util.Iterator;

import java.util.List;
import java.util.Random;
import java.util.Set;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Resources.Base_setup;



public class CreateStudioandsettings extends Base_setup
{
	
	public CreateStudioandsettings()
	{
	   PageFactory.initElements(driver,this);
	}
	
   @FindBy(xpath="//span[@class='create-studio']/a/button")
   public static WebElement CreateStudioButton;
   
   @FindBy(xpath="//div[@class='studio-container']/h3")
   public static WebElement CreateStudioPageHeading;
   
   @FindBy(xpath="//div[@class='studio-container']/p")
   public static WebElement CreateStudioPageDescription;
   
   @FindBy(xpath="//div[@class='close cursor']")
   public static WebElement CreateStudioPageCloseIcon;
   
   @FindBy(xpath="//div[@class='final-submit']/button[1]")
   public static WebElement CreateStudioPageButton;
   
   @FindBy(xpath="//div[@class='final-submit']/button[2]")
   public static WebElement CreateStudioCancelButton;
   
   @FindBy(xpath="//span[@class='mat-content']")
   public static List<WebElement> CreateStudioMiniTabTitle;
   
   @FindBy(id="studioName")
   public static WebElement StudioNameField;
   
   @FindBy(xpath="//div[@class='studio-name-field']/p")
   public static WebElement StudioNameDescription;
   
   @FindBy(xpath="//div[@class='mat-form-field-infix']/label")
   public static WebElement AvailableTextInField;
   
   @FindBy(xpath="//div[@class='form-group']/div/h4")
   public static List<WebElement> FieldNames;
   
   @FindBy(xpath="//div[@class='form-group']/div/p")
   public static List<WebElement> FieldNameDescriptions;
   
   @FindBy(xpath="//span[@class='error-text show-error-text ng-star-inserted']")
   public static WebElement ErrorMessages;
   
   @FindBy(xpath="//span[@class='error-text show-error-text ng-star-inserted']")
   public static List<WebElement> AllErrorMessages;
   
   @FindBy(xpath="//div[@class='form-error ng-star-inserted']")
   public static WebElement HeadderErrorMessage;
   
   @FindBy(xpath="//div[@class='add-thumb-image']")
   public static WebElement AddThumbnailField;
   
   @FindBy(xpath="//div[@class='crop-footer studioCalss']/div/button[2]")
   public static WebElement ThumbnailSavebutton;
   
   @FindBy(xpath="//div[@class='add-thumb-image']/div/span/p")
   public static List<WebElement> TextInsideTumbnailIcon;
   
   @FindBy(xpath="//span[@class='file-type ng-star-inserted']")
   public static WebElement ThumbnailFileSupportsText;
   
   @FindBy(id="studioDescription")
   public static WebElement StudioDescription;
   
   @FindBy(xpath="//div[@class='mat-radio-label-content']")
   public static List<WebElement> StudioVisiblity;
   
   @FindBy(id="studioFB")
   public static WebElement FacebookField;
   
   @FindBy(id="studioTwit")
   public static WebElement TwitterField;
   
   @FindBy(id="studioWhats")
   public static WebElement LinkedinField;
   
   @FindBy(id="studioInsta")
   public static WebElement InstagramField;
   
   @FindBy(id="studioWeb")
   public static WebElement WebSiteField;
   
   @FindBy(xpath="//div[@class='form-group table']/div/h4")
   public static WebElement StudioAddressFieldName;
   
   @FindBy(xpath="//div[@class='form-group table']/div/p")
   public static WebElement StudioAddressFieldDescription;
   
   @FindBy(id="studioAddress")
   public static WebElement StudioAddressField;
   
   @FindBy(id="studioCity")
   public static WebElement StudioCity;
   
   @FindBy(id="studioState")
   public static WebElement StudioState;
   
   @FindBy(id="studioCountry")
   public static WebElement StudioCountry;
   
   @FindBy(id="studioPinCode")
   public static WebElement StudioPinCode;
   
   @FindBy(xpath="//div[@class='confirmation-verify']/mat-checkbox")
   public static WebElement CheckBox;
   
   @FindBy(xpath="//div[@class='confirmation-verify']")
   public static WebElement CheckboxVerifyText;
   
   @FindBy(xpath="//input[@class='mat-checkbox-input cdk-visually-hidden']")
   public static WebElement CheckBoxAttribute;
   
   @FindBy(xpath="//div[@class='upload-profile studio-form']/h2")
   public static WebElement StudioProilePreviewText;
		
   @FindBy(xpath="//div[@class='studio-title']/div/h2")
   public static WebElement StudioNameinStudioProfilepreview;
   
   @FindBy(xpath="//div[@class='upload-profile studio-form']/p")
   public static WebElement StudioDescriptionInProfilePreview;
   
   @FindBy(xpath="//div[@class='studio-profile']/div[1]")
   public static WebElement StudioImageInProfilePreview;
   
   @FindBy(xpath="//span[@class='cover-icon']/mat-icon[1]")
   public static WebElement StudioThumbnailediticon;
   
   @FindBy(xpath="//span[@class='cover-icon']/mat-icon[2]")
   public static WebElement StudioThumbnailDeleteIcon;
   
   @FindBy(xpath="//span[@class='d']")
   public static WebElement StudioThumbnailafteruploadimage;
   
   @FindBy(xpath="//div[@class='count-chars']")
   public static WebElement StuioDescriptionChractersCount;
   
   @FindBy(xpath="//mat-accordion[@class='mat-accordion']/mat-expansion-panel/mat-expansion-panel-header/span[2]")
   public static List<WebElement> MiniTitleExpansion;
   
   @FindBy(xpath="//ul[@class='shocial-links']/li")
   public static List<WebElement> SocilaIconsInStudioPreview;
   
   @FindBy(id="studioOwnerName")
   public static WebElement StudioOwnerName;
   
   @FindBy(id="email")
   public static WebElement StudioOwnerEmail;
   
   @FindBy(xpath="//span[@class='addon-group']")
   public static WebElement EmailEditbutton;
   
   @FindBy(xpath="//span[@class='error-text show-error-text contact-info-field ng-star-inserted']")
   public static WebElement EmailErrormessage;
   
   @FindBy(xpath="//strong[@class='orange clickable']")
   public static WebElement PhoneNumberEdit;
   
   @FindBy(xpath="//div[@class='mat-dialog-header']/h5")
   public static WebElement OTPPopupWindowtext;
   
   @FindBy(xpath="//input[@type='tel']")
   public static WebElement PhoneNumberFieldinPopup;
   
   @FindBy(xpath="//div[@class='phone-number-popup']/div[1]/div/mat-icon")
   public static WebElement OTPPopupCloseIcon;
   
   @FindBy(xpath="//mat-dialog-actions[@class='text-center mat-dialog-actions']/button")
   public static WebElement RequestOTPButton;
   
   //After Create Studio
   @FindBy(xpath="//div[@class='studio-details']/h3")
   public static WebElement Studionameaftercreatestudio;
   
   @FindBy(xpath="//div[@class='studio-details']/p")
   public static WebElement Studiodescriptionaftercreatestudio;
   
   @FindBy(xpath="//div[@class='stepper-right flex align-items-center justify-content-end']/p")
   public static WebElement SavedText;
   
   @FindBy(xpath="//div[@class='stepper-right flex align-items-center justify-content-end']/button[1]")
   public static WebElement PreviewButton;
   
   @FindBy(xpath="//div[@class='stepper-right flex align-items-center justify-content-end']/button[2]")
   public static WebElement PublishButton;
   
   @FindBy(xpath="//div[@mattooltip='Studio settings']")
   public static WebElement StudioSettingsbutton;
   
   ///Studio Preview
   @FindBy(xpath="//div[@class='studio-profile']/div[1]")
   public static WebElement StudioImageinPreviewPage;
   
   @FindBy(xpath="//div[@class='edit-title']/h4")
   public static WebElement StudioNameinPreviewPage;
   
   @FindBy(xpath="//div[@class='follow-btn']/button")
   public static WebElement FollowButtoninPreviewPage;
   
   @FindBy(xpath="//div[@class='counts-list info-hvr cursor']")
   public static WebElement InfoButtoninPreviewPage;
   
   @FindBy(xpath="//div[@class='shocial-media flex align-items-center justify-content-between ng-star-inserted']")
   public static WebElement SocialShareButtons;
   
   @FindBy(xpath="//div[@class='simplebar-mask']")
   public static WebElement DescriptioninPrviewPage;
   
   @FindBy(xpath="//ul[@class='shocial-links follow-link-list']")
   public static WebElement FollowUsOnButton;
   
   @FindBy(xpath="//div[@class='studio-logo-header cursor']")
   public static WebElement StudioLogoHeadder;
   
   @FindBy(xpath="//mat-option[@role='option']//span//span")
   public static List<WebElement> AutodropdownInSearch;
   
   
   //Studio Settings Module
   @FindBy(xpath="//div[@class='close ng-star-inserted']/h2")
   public static WebElement StudioSettingText;
   
   @FindBy(xpath="//div[@class='studio-step-head mystudiosetting profile-identity']/h4")
   public static WebElement StudioIdentityText;
   
   @FindBy(xpath="//div[@class='form-group mystudiosetting']/div/h4")
   public static List<WebElement> StudioFieldNames;
   
   @FindBy(xpath="//span[@class='file-type MyStudioSetting']")
   public static WebElement ThumbnailSupportText;
   
   @FindBy(xpath="//span[@class='k']")
   public static WebElement Thumbnailimage;
   
   @FindBy(xpath="//span[@class='edit ng-star-inserted']")
   public static WebElement ThumbnailEditIcon;
   
   @FindBy(xpath="//div[@class='studio-step-head mystudiosetting']/h4")
   public static WebElement ContactInfoText;
   
   @FindBy(xpath="//h4[text()=' Studio Address* ']")
   public static WebElement StudioAddressFieldinStudioSettings;
   
   @FindBy(xpath="//div[@class='custom-uploader mystudiosetting']/span")
   public static WebElement ThumbnailSupportedText;
   
   @FindBy(xpath="//div[@class='stepper-right']/button[1]")
   public static WebElement SaveButtoninSettings;
   
   @FindBy(xpath="//div[@class='stepper-right']/button[1]")
   public static WebElement CancelButtonInSettings;
   
   @FindBy(xpath="//span[@class='error-text show-error-text mystudiosetting ng-star-inserted']")
   public static WebElement ErrorMessagesinStudioSettings;
   
   @FindBy(xpath="//span[@class='error-text show-error-text ng-star-inserted']")
   public static WebElement EmailInvalidAddressErrorMessage;
   
   @FindBy(xpath="//span[@class='addon-group mystudiosetting']")
   public static WebElement EmailEditButtonInStudioSettings;
   
   @FindBy(xpath="//strong[@class='orange clickable mystudiosetting']")
   public static WebElement PhoneNumberEditInStudioSettings;
   
  @FindBy(xpath="//div[@class='address-fields flex mystudiosetting']/div")
  public static List<WebElement> addressfields;
   
   
   
   
   public static void windowhandle()
   {
	   String MainWindow=driver.getWindowHandle();				
       Set<String> s1=driver.getWindowHandles();		
       Iterator<String> i1=s1.iterator();			
       while(i1.hasNext())			
       {		
        String ChildWindow=i1.next();		
       		
        if(!MainWindow.equalsIgnoreCase(ChildWindow))			
        {    	
        	 driver.switchTo().window(ChildWindow);
        		driver.close();
        		
        }		
           driver.switchTo().window(MainWindow);
           
        }
   	
   	
   }
   
   public static String random()
   {
	
			String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		    String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
		    String numbers = "0123456789";

		    
		    String alphaNumeric = upperAlphabet + lowerAlphabet + numbers;
		    StringBuilder sb = new StringBuilder();
		    Random random = new Random();
		    int length = 6;

		    for(int i = 0; i < length; i++) {
		      int index = random.nextInt(alphaNumeric.length());
		      char randomChar = alphaNumeric.charAt(index);
		      sb.append(randomChar);
		    }

		    String randomString = sb.toString();
			return randomString;
		    

   }
}
