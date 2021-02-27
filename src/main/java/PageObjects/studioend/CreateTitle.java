package PageObjects.studioend;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Resources.Base_setup;

public class CreateTitle extends Base_setup {
	
	public CreateTitle()
	{
	   PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//div[@class='create-studio-btn']")
	public static WebElement CreateTitleButton;
	
	@FindBy(xpath="//div[@class='hamburger-menu']/ul/li")
	public static List<WebElement> ListDropDown;
	
	@FindBy(xpath="//div[@class='stepper-container']/h4")
	public static WebElement Insidetheheadder;
	
	@FindBy(xpath="//div[@class='stepper-container']/p")
	public static WebElement Description;
	
	@FindBy(xpath="//span[@class='mat-content']/mat-panel-title/h3")
	public static List<WebElement> AllSectionsInCreateSho;
	
	
	
	//First Section "NAME YOUR SHO OR SERIES"
	
	@FindBy(id="id-0")
	public static WebElement NameYourShoSection;
	
	@FindBy(xpath="//input[@placeholder='Name']")
	public static WebElement NameYourShoorSeriesField;
	
	@FindBy(xpath="//div[@class='clearfix']/mat-dialog-actions/button[1]")
	public static WebElement DeleteButton;
	
	@FindBy(xpath="//div[@class='clearfix']/mat-dialog-actions/button[2]")
	public static WebElement CancelButton;
	
	@FindBy(xpath="//div[@class='crop-btnset']/button[2]")
	public static WebElement SavePngPopupButton;
	
	@FindBy(xpath="//div[@class='crop-btnset']/button[1]")
	public static WebElement CancelPngPopupButton;
	
	public static List<WebElement> FieldNamesInNameYourShoSection()
	{
		return NameYourShoSection.findElements(By.xpath("//div[@class='field-left']/h4"));
	}
	public static List<WebElement> FieldDescriptionsInNameYourShoSection()
	{
		return NameYourShoSection.findElements(By.xpath("//div[@class='field-left']/p"));
	}
	public static WebElement UploadPng()
	{
		return NameYourShoSection.findElement(By.xpath("//div[@class='add-thumb-image cursor']"));
	}
	public static WebElement UploadPngSupportText()
	{
		return NameYourShoSection.findElement(By.xpath("//div[@class='field-right']/p"));
	}
	public static WebElement Errormessage()
	{
		return NameYourShoSection.findElement(By.xpath("//span[@class='error-text show-error-text ng-star-inserted']"));
	}
	public static WebElement Chractercount()
	{
		return NameYourShoSection.findElement(By.xpath("//div[@class='count-chars']"));
	}
	public static WebElement EditIconPng()
	{
		return NameYourShoSection.findElement(By.xpath("//span[@class='cover-icon']/mat-icon[1]"));
	}
	public static WebElement DeleteIconPng()
	{
		return NameYourShoSection.findElement(By.xpath("//span[@class='cover-icon']/mat-icon[2]"));
	}
	
	
	//Fifth Section-"Manage Detail of your Sho /Series"
	
	//Cover Image and Thumbnail Image
	
	@FindBy(id="id-4")
	public static WebElement ManageDetailofYourShoSectionSection;
	
	@FindBy(xpath="//div[@class='full-fields manage-detail']/form/div[1]/div[2]/div")
	public static WebElement CoverImageUpload;
	
	@FindBy(xpath="//div[@class='full-fields manage-detail']/form/div[2]/div[2]/div")
	public static WebElement ThumbnailImageUpload;
	
	public static WebElement CoverImage()
	{
		return ManageDetailofYourShoSectionSection.findElement(By.xpath("//div[@class='add-thumb-image cursor']"));
	}
	public static WebElement EditIconPngInMangaeDetail()
	{
		return ManageDetailofYourShoSectionSection.findElement(By.xpath("//span[@class='cover-icon']/mat-icon[1]"));
	}
	public static WebElement DeleteIconPngInMangaeDetail()
	{
		return ManageDetailofYourShoSectionSection.findElement(By.xpath("//span[@class='cover-icon']/mat-icon[2]"));
	}
	
	//Tags And Keywords
	
	@FindBy(xpath="//input[@class='mat-chip-input mat-input-element']")
	public static WebElement TagsAndKeywords;
	
	@FindBy(xpath="//div[@class='tag-count flex align-items-center justify-content-end ']")
	public static WebElement TagsCharCount;
	
	@FindBy(xpath="//div[@class='mat-chip-list-wrapper']/mat-chip/mat-icon")
	public static WebElement RemoveTagsIcon;
	
	//Primary Genere field
	
	@FindBy(xpath="//div[@class='select-custom-type']/mat-form-field")
	public static WebElement PrimaryGenere;
	
	@FindBy(xpath="//mat-option[@role='option']")
	public static List<WebElement> DropdownforPrimaryGenre;
	
	//secondary Genre
	
	@FindBy(xpath="//input[@role='combobox']")
	public static WebElement SecondaryGenere;
	
	@FindBy(xpath="//div[@class='tag-count flex align-items-center justify-content-end cursor ng-star-inserted']")
	public static WebElement SecondarygenreChracCount;
	
	//Maturity Rating
	
	@FindBy(xpath="//mat-radio-group[@role='radiogroup']/mat-radio-button")
	public static List<WebElement> MaturityRatingSection;
	
	@FindBy(xpath="//label[@class='mat-radio-label']/div[2]/h4")
	public static List<WebElement> Rating;
	
	@FindBy(xpath="//label[@class='mat-radio-label']/div[2]/p")
	public static List<WebElement> RatingLabel;
	
	@FindBy(xpath="//div[@class='mat-radio-container']/div[1]")
	public static List<WebElement> RadioCircle;
	
	
	
	
	
	@FindBy(xpath="//textarea[@placeholder='About this sho']")
	public static WebElement ShoDescriptionField;
	
	@FindBy(xpath="//div[@class='full-fields manage-detail']/form/div[7]/div[2]/div")
	public static WebElement IntialReleaseDate;
	
	@FindBy(xpath="//div[@class='full-fields manage-detail']/form/div/div[1]/h4")
	public static List<WebElement> FieldsNamesInManageDetailofYourShoSectionSection;
	
	@FindBy(xpath="//div[@class='full-fields manage-detail']/form/div/div[1]/p")
	public static List<WebElement> FieldsDesriptionInManageDetailofYourShoSectionSection;
	
	@FindBy(xpath="//div[@class='popup-loader flex align-items-center justify-content-center error-resolution ng-star-inserted']")
	public static WebElement ErrormessageInPopupThumbnail;
	
	@FindBy(xpath="//div[@class='crop-btnset thumb']/button[1]")
	public static WebElement ThumbnialUpoadCancelButton;
	
	@FindBy(xpath="//div[@class='crop-btnset thumb']/button[2]")
	public static WebElement ThumbnialUpoadSaveButton;
	
	
	
	
	
	
	/*@FindBy()
	public static
	
	@FindBy()
	public static
	
	@FindBy()
	public static
	
	@FindBy()
	public static
	
	@FindBy()
	public static
	
	@FindBy()
	public static
	
	@FindBy()
	public static
	
	@FindBy()
	public static
	
	@FindBy()
	public static
	
	@FindBy()
	public static
	
	@FindBy()
	public static
	
	@FindBy()
	public static
	
	@FindBy()
	public static
	
	@FindBy()
	public static
	
	@FindBy()
	public static
	
	@FindBy()
	public static
	
	@FindBy()
	public static
	
	@FindBy()
	public static
	
	@FindBy()
	public static
	
	@FindBy()
	public static
	
	@FindBy()
	public static
	
	@FindBy()
	public static
	
	@FindBy()
	public static
	
	
	@FindBy()
	public static
	
	@FindBy()
	public static
	
	@FindBy()
	public static
	*/

}
