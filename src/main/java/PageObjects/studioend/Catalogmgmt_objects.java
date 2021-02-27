package PageObjects.studioend;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Resources.Base_setup;


public class Catalogmgmt_objects extends Base_setup {

	public Catalogmgmt_objects() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class='create-studio']")
	public WebElement CreateStudioButton;

	@FindBy(xpath = "//*[text()='Catalog and Row Management']")
	public static WebElement ctaMgmtElement;

	@FindBy(xpath = "//*[@class='flex align-items-center justify-content-center cursor']//self::span[text()='promos']")
	public static WebElement insertPromosButton;

	@FindBy(xpath = "//*[@class='flex align-items-center justify-content-center cursor']//self::span[text()=' audio tracks']")
	public static WebElement insertAudioTracksButton;

	@FindBy(xpath = "//*[@class='flex align-items-center justify-content-center cursor']//self::span[text()=' sho or series']")
	public static WebElement insertShoSeriesButton;

	@FindBy(xpath = "//div[@class='setting-btns flex']//child::button[2]")
	public static WebElement addRowButton;

	@FindBy(xpath = "//*[text()=' Shuffle Rows ']")
	public static WebElement shuffleRows;

	@FindBy(xpath = "//*[text()='delete']")
	public static WebElement rowDeleteButton;
	
	@FindBy(xpath = "//div[@id='toast-container']//div//button")
	public static WebElement toasterCloseButton;

	@FindBy(xpath = "//div[@class='setting-btns flex']//child::button[1]")
	public static WebElement rowSuffleButton;

	@FindBy(xpath = "//mat-icon[text()='shuffle']")
	public static WebElement rowReorderButton;
	
	@FindBy(xpath = "//*[text()='visibility_off']")
	public static WebElement disableRow;
	
	@FindBy(xpath = "//*[text()=' Row disabled ']")
	public static WebElement rowDisabledElement;
	
	@FindBy(xpath = "//*[@class='check cursor']")
	public static WebElement shoCardCheckBox;

	@FindBy(xpath = "//*[@class='see-all ng-star-inserted']")
	public static WebElement seeAllHyperLink;

	@FindBy(xpath = "//*[@class='mat-select-arrow']")
	public static WebElement filterAll;

	@FindBy(xpath = "//*[@class='mat-option-text']//following::span[1]")
	public static WebElement filterBySho;

	@FindBy(xpath = "//*[@class='mat-option-text']//following::span[2]")
	public static WebElement filterBySeries;
	
	@FindBy(xpath = "//*[@class='mat-option-text']")
	public static WebElement filterByAll;
	
	@FindBy(xpath = "//input[@placeholder='Sho or Series']")
	public static WebElement searchFieldSho;
	
	@FindBy(xpath = "//input[@placeholder='Audio Tracks']")
	public static WebElement searchFieldAudio;
	
	@FindBy(xpath = "//input[@placeholder='Promos']")
	public static WebElement searchFieldPromo;

	@FindBy(xpath = "//*[text()='Add Row']")
	public static WebElement addRowCTAButton;

	@FindBy(xpath = "//*[text()='Create New Row']")
	public static WebElement createNewRowElement;

	@FindBy(xpath = "//h5[@class='mat-dialog-title']")
	public static WebElement addRowHeaderElement;

	@FindBy(xpath = "//input[@placeholder='Enter Row Name']")
	public static WebElement enterRowNameField;

	@FindBy(xpath = "//div[@class='mat-select-value']")
	public static WebElement rowTypeDropDown;

	@FindBy(xpath = "//*[text()='Row Name is required']")
	public static WebElement rowNameRequiredWarn;

	@FindBy(xpath = "//*[text()='Please select Row type']")
	public static WebElement rowTypeRequiredWarn;

	@FindBy(xpath = "//*[text()='Save']")
	public static WebElement addRowSaveButton;

	@FindBy(xpath = "//*[text()='Save']//following::span")
	public static WebElement addRowCancellButton;

	@FindBy(xpath = "//img[@alt='Create Row']")
	public static WebElement createRowImg;

	@FindBy(xpath = "//*[@class='row-header flex align-items-center justify-content-between']")
	public static WebElement createdRowName;

	@FindBy(xpath = "//div[@id='toast-container']//div//div")
	public static WebElement studioToasterMessage;

	@FindBy(xpath = "//*[text()=' Yes ']")
	public static WebElement YesButton;

	@FindBy(xpath = "//*[text()=' No ']")
	public static WebElement NoButton;

	@FindBy(xpath = "//*[@aria-describedby='Playlist Table']//child::mat-checkbox")
	public static WebElement selectFirst10;

	@FindBy(xpath = "//*[@class='playlist-save flex']//child::span[text()='Insert ']")
	public static WebElement insertButton;

	@FindBy(xpath = "//*[text()='Insert ']//following::span")
	public static WebElement cancell;
	
	@FindBy(xpath = "//h5[@class='series-title ng-star-inserted']")
	public static WebElement searchResultFirstSho;
	
	@FindBy(xpath = "//span[@class='edit-name cursor']")
	public static WebElement rowEditButton;
	
	@FindBy(xpath = "//span[@class='edit-name cursor type-2']")
	public static WebElement rowEditButtonPromo;
	
	@FindBy(xpath = "//button[@type='submit']")
	public static WebElement rowEditTickButton;
	
	@FindBy(xpath = "//input[@formcontrolname='editCategoryName']")
	public static WebElement rowEditField;
	
	@FindBy(xpath = "//h3[@class='playlist-title type-1 ng-star-inserted']")
	public static WebElement getRowNameShoSeries;
	
	@FindBy(xpath = "//h3[@class='playlist-title type-2 ng-star-inserted']")
	public static WebElement getRowNamePromos;
	
	@FindBy(xpath = "//h3[@class='playlist-title ng-star-inserted']")
	public static WebElement getRowNameAudio;
	
	@FindBy(xpath = "//*[text()='Add New Banner']")
	public static WebElement addNewBannerButtoncenter;
	
	@FindBy(xpath = "//*[text()='Add New Banner ']")
	public static WebElement addNewBannerButtontop;
	
	@FindBy(xpath = "//*[text()='delete ']")
	public static WebElement deleteBanbersingle;
	
	@FindBy(xpath = "//*[text()=' Save ']")
	public static WebElement saveButtonBanner;
	
	@FindBy(xpath = "//*[text()=' Cancel ']")
	public static WebElement cancelButtonBanner;
	
	@FindBy(xpath = "//*[@class='mat-checkbox-layout']")
	public static WebElement checkAll;
	
	@FindBy(xpath = "//*[text()='Delete']")
	public static WebElement deleteAllBanner;

}
