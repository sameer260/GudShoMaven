package Steps.studioend;

import static org.junit.Assert.assertEquals;


import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.frontend.MyProfile_Objects;
import PageObjects.studioend.Catalogmgmt_objects;
import Resources.Base_setup;
import Resources.supportClass;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CatalogManagement extends Base_setup {

	JavascriptExecutor executor = (JavascriptExecutor) driver;
	PageObjects.studioend.Catalogmgmt_objects pom = new Catalogmgmt_objects();
	public static Logger log = Logger.getLogger(CatalogManagement.class.getName());
	WebDriverWait wait = new WebDriverWait(driver, 30);

	@Given("^Navigate to my studio$")
	public void navigate_to_my_studio() throws Throwable {
		Actions actions = new Actions(driver);
		actions.moveToElement(MyProfile_Objects.myProfileElement()).build().perform();
		MyProfile_Objects.myStudio().click();
		log.info("navigated to my studio page");

	}

	@When("^verify header element$")
	public void verify_the_header_element() throws Throwable {
		Catalogmgmt_objects.ctaMgmtElement.isDisplayed();
		log.info("verifing the catalog section heaser");

	}

	@Then("^click on add row button and verify the pop$")
	public void click_on_add_row_button_and_verify_the_pop() throws Throwable {
		try {
			Thread.sleep(500);
			executor.executeScript("arguments[0].click();", Catalogmgmt_objects.addRowCTAButton);

		} catch (Exception NoSuchElementException) {
			Catalogmgmt_objects.addRowButton.click();

		}
		wait.until(ExpectedConditions.visibilityOf(Catalogmgmt_objects.addRowHeaderElement));
		Catalogmgmt_objects.addRowHeaderElement.isDisplayed();
		log.info("add row pop is displayed");
	}

	@And("^Verify the shuffle and add row buttons$")
	public void verify_the_shuffle_and_add_row_buttons() throws Throwable {
		boolean addRowIsEnabled = Catalogmgmt_objects.addRowButton.isEnabled();
		log.info("Is add row button is enabled " + addRowIsEnabled);
		boolean rowSuffleButtonEnabled = Catalogmgmt_objects.rowSuffleButton.isEnabled();
		log.info("Is row suffle button is enabled " + rowSuffleButtonEnabled);
	}

	@And("^verify visibilty of create new row image$")
	public void verify_the_visibilty_of_create_new_row_image() throws Throwable {
		Catalogmgmt_objects.createRowImg.isDisplayed();
		log.info("create row image is displayed");

	}

	@And("^check create new row element$")
	public void check_the_create_new_row_element() throws Throwable {
		Catalogmgmt_objects.createNewRowElement.isDisplayed();
		log.info("create new row element is displayed");
	}

	@Then("^verify pop is closed or not$")
	public void verify_pop_is_closed_or_not() throws Throwable {
		Catalogmgmt_objects.createRowImg.isDisplayed();
		log.info("popup closed");

	}

	@And("^click on save button$")
	public void click_on_save_button() throws Throwable {
		Catalogmgmt_objects.addRowSaveButton.click();
		log.info("clicked on the save button");

	}

	@And("^verify field warning messages$")
	public void verify_the_field_warning_messages() throws Throwable {
		wait.until(ExpectedConditions.visibilityOf(Catalogmgmt_objects.rowNameRequiredWarn));
		assertEquals("Row Name is required", Catalogmgmt_objects.rowNameRequiredWarn.getText());
		assertEquals("Please select Row type", Catalogmgmt_objects.rowTypeRequiredWarn.getText());
		log.info("field warning message verifed");

	}

	@And("^click on cancel button$")
	public void click_on_cancel_button() throws Throwable {
		Catalogmgmt_objects.addRowCancellButton.click();
		log.info("clicked on the canell button");

	}

	@And("^click on the select row type dropdown$")
	public void click_on_the_select_row_type_dropdown() throws Throwable {
		Catalogmgmt_objects.rowTypeDropDown.click();
		log.info("clicked on select row type dropdown");
	}

	@And("^verify options$")
	public void verify_the_options() throws Throwable {
		List<WebElement> allRowTypes = driver.findElements(By.tagName("mat-option"));
		assertEquals("Sho & Series", allRowTypes.get(0).getText());
		assertEquals("Promos", allRowTypes.get(1).getText());
		assertEquals("Audio Tracks", allRowTypes.get(2).getText());
		allRowTypes.get(0).click();
		log.info("verifing the row type dropdown options");

	}

	@And("^click on (.+) option$")
	public void click_on_option(String rowtype) throws Throwable {
		List<WebElement> allRowTypes = driver.findElements(By.tagName("mat-option"));
		if (rowtype.equalsIgnoreCase("Sho & Series")) {
			allRowTypes.get(0).click();
			log.info("selecting :" + allRowTypes.get(0).getText());
		} else if (rowtype.equalsIgnoreCase("Promos")) {
			allRowTypes.get(1).click();
			log.info("selecting :" + allRowTypes.get(1).getText());
		} else if (rowtype.equalsIgnoreCase("Audio Tracks")) {
			allRowTypes.get(2).click();
			log.info("selecting :" + allRowTypes.get(2).getText());
		}

	}

	@And("^Verify the options is selected or not (.+)$")
	public void verify_the_options_is_selected_or_not(String rowtype) throws Throwable {
		if (rowtype.equalsIgnoreCase("Sho & Series")) {
			assertEquals("Sho & Series", Catalogmgmt_objects.rowTypeDropDown.getText());
			log.info(Catalogmgmt_objects.rowTypeDropDown.getText() + " is selected");
		} else if (rowtype.equalsIgnoreCase("Promos")) {
			assertEquals("Promos", Catalogmgmt_objects.rowTypeDropDown.getText());
			log.info(Catalogmgmt_objects.rowTypeDropDown.getText() + " is selected");
		} else if (rowtype.equalsIgnoreCase("Audio Tracks")) {
			assertEquals("Audio Tracks", Catalogmgmt_objects.rowTypeDropDown.getText());
			log.info(Catalogmgmt_objects.rowTypeDropDown.getText() + " is selected");
		}

	}

	@And("^click on promo option$")
	public void click_on_promo_option() throws Throwable {
		List<WebElement> allRowTypes = driver.findElements(By.tagName("mat-option"));
		allRowTypes.get(1).click();
		log.info("selecting :" + allRowTypes.get(1).getText());

	}

	@And("^Verify the options is selected or not promo$")
	public void verify_the_options_is_selected_or_not_promo() throws Throwable {
		wait.until(ExpectedConditions.visibilityOf(Catalogmgmt_objects.rowTypeDropDown));
		assertEquals("Promos", Catalogmgmt_objects.rowTypeDropDown.getText());
		log.info(Catalogmgmt_objects.rowTypeDropDown.getText() + " is selected");

	}

	@And("^click on audio tracks option$")
	public void click_on_audio_tracks_option() throws Throwable {
		List<WebElement> allRowTypes = driver.findElements(By.tagName("mat-option"));
		allRowTypes.get(2).click();
		log.info("selecting :" + allRowTypes.get(2).getText());

	}

	@And("^Verify the options is selected or not audio tracks$")
	public void verify_the_options_is_selected_or_not_audio_tracks() throws Throwable {
		wait.until(ExpectedConditions.visibilityOf(Catalogmgmt_objects.rowTypeDropDown));
		assertEquals("Audio Tracks", Catalogmgmt_objects.rowTypeDropDown.getText());
		log.info(Catalogmgmt_objects.rowTypeDropDown.getText() + " is selected");

	}

	@And("^Enter row name (.+)$")
	public void enter_the_row_name(String rowname) throws Throwable {
		Thread.sleep(500);
		Catalogmgmt_objects.enterRowNameField.clear();
		Catalogmgmt_objects.enterRowNameField.sendKeys(rowname);
		log.info("Entering the row name --- " + rowname);

	}

	@Then("^verify created row (.+)$")
	public void verify_created_row(String rowname) throws Throwable {
		wait.until(ExpectedConditions.visibilityOf(Catalogmgmt_objects.studioToasterMessage));
		assertEquals("Row created successfully", Catalogmgmt_objects.studioToasterMessage.getText());
		Catalogmgmt_objects.toasterCloseButton.click();
		String ignoreCase = Catalogmgmt_objects.createdRowName.getText();
		ignoreCase.equalsIgnoreCase(rowname);
		log.info("row created sucessfully");
	}

	@Then("^delete the created row$")
	public void delete_the_created_row() throws Throwable {
		Actions actions=new Actions(driver);
		actions.moveToElement(Catalogmgmt_objects.rowDeleteButton).click().build().perform();
		Catalogmgmt_objects.YesButton.click();
		Thread.sleep(1000);
		Catalogmgmt_objects.toasterCloseButton.click();
		log.info("row deleted sucessfully");
	}

	@When("^click on add row button and verify the pop second row$")
	public void click_on_add_row_button_and_verify_the_pop_second_row() throws Throwable {
		supportClass.scrollDown();
		Catalogmgmt_objects.addRowButton.click();
		Catalogmgmt_objects.addRowHeaderElement.isDisplayed();
		log.info("add row pop is displayed");

	}

	@Then("^verify toaster for duplicate row$")
	public void verify_toaster_for_duplicate_row() throws Throwable {
		Thread.sleep(2000);
		assertEquals("Name already exist", Catalogmgmt_objects.studioToasterMessage.getText());
		Catalogmgmt_objects.toasterCloseButton.click();
		log.info(Catalogmgmt_objects.studioToasterMessage.getText());
	}

	@And("^Click on insert card for (.+)$")
	public void click_on_insert_card_for(String rowtype) throws Throwable {
		wait.until(ExpectedConditions.visibilityOf(Catalogmgmt_objects.studioToasterMessage));
		assertEquals("Row created successfully", Catalogmgmt_objects.studioToasterMessage.getText());
		Catalogmgmt_objects.toasterCloseButton.click();
		if (rowtype.equalsIgnoreCase("Sho & Series")) {
			executor.executeScript("arguments[0].click();", Catalogmgmt_objects.insertShoSeriesButton);
			log.info("clicked on insert card for sho & series");
		} else if (rowtype.equalsIgnoreCase("Promos")) {
			executor.executeScript("arguments[0].click();", Catalogmgmt_objects.insertPromosButton);
			log.info("clicked on insert card for promos");
		} else if (rowtype.equalsIgnoreCase("Audio Tracks")) {
			executor.executeScript("arguments[0].click();", Catalogmgmt_objects.insertAudioTracksButton);
			log.info("clicked on insert card for Audio Tracks");
		}

	}

	@Then("^Add few cards (.+)$")
	public void add_few_cards(String rowtype) throws Throwable {
		List<WebElement> checkBox = driver
				.findElements(By.xpath("//*[@class='mat-row ng-star-inserted']//child::label"));
		int totalCheck = checkBox.size();
		for (int i = 0; i < totalCheck; i++) {
			if (i % 2 == 0) {
				checkBox.get(i).click();
			}

		}
		executor.executeScript("arguments[0].click();", Catalogmgmt_objects.insertButton);
		Catalogmgmt_objects.YesButton.click();

		if (rowtype.equalsIgnoreCase("Sho & Series")) {
			wait.until(ExpectedConditions.visibilityOf(Catalogmgmt_objects.studioToasterMessage));
			assertEquals("Sho or sho series successfully added in Row",
					Catalogmgmt_objects.studioToasterMessage.getText());
			Catalogmgmt_objects.toasterCloseButton.click();
			log.info("Cards added successuflly for sho & series");
		} else if (rowtype.equalsIgnoreCase("Promos")) {
			wait.until(ExpectedConditions.visibilityOf(Catalogmgmt_objects.studioToasterMessage));
			assertEquals("Promos successfully added in Row", Catalogmgmt_objects.studioToasterMessage.getText());
			Catalogmgmt_objects.toasterCloseButton.click();
			log.info("Cards added successuflly for promos");
		} else if (rowtype.equalsIgnoreCase("Audio Tracks")) {
			wait.until(ExpectedConditions.visibilityOf(Catalogmgmt_objects.studioToasterMessage));
			assertEquals("Audio tracks successfully added in Row", Catalogmgmt_objects.studioToasterMessage.getText());
			Catalogmgmt_objects.toasterCloseButton.click();
			log.info("Cards added successuflly");
		}

	}

	@Then("^Add ten cards in to the row (.+)$")
	public void add_ten_cards_in_to_the_row(String rowtype) throws Throwable {
		Thread.sleep(3000);
		Catalogmgmt_objects.selectFirst10.click();
		executor.executeScript("arguments[0].click();", Catalogmgmt_objects.insertButton);
		wait.until(ExpectedConditions.elementToBeClickable(Catalogmgmt_objects.YesButton));
		Catalogmgmt_objects.YesButton.click();
		if (rowtype.equalsIgnoreCase("Sho & Series")) {
			wait.until(ExpectedConditions.visibilityOf(Catalogmgmt_objects.studioToasterMessage));
			assertEquals("Sho or sho series successfully added in Row",
					Catalogmgmt_objects.studioToasterMessage.getText());
			Catalogmgmt_objects.toasterCloseButton.click();
			log.info("Cards added successuflly");
		} else if (rowtype.equalsIgnoreCase("Promos")) {
			wait.until(ExpectedConditions.visibilityOf(Catalogmgmt_objects.studioToasterMessage));
			assertEquals("Promos successfully added in Row", Catalogmgmt_objects.studioToasterMessage.getText());
			Catalogmgmt_objects.toasterCloseButton.click();
			log.info("Cards added successuflly");
		} else if (rowtype.equalsIgnoreCase("Audio Tracks")) {
			wait.until(ExpectedConditions.visibilityOf(Catalogmgmt_objects.studioToasterMessage));
			assertEquals("Audio tracks successfully added in Row", Catalogmgmt_objects.studioToasterMessage.getText());
			Catalogmgmt_objects.toasterCloseButton.click();
			log.info("Cards added successuflly");
		}

	}

	@And("^verify disable feature$")
	public void verify_the_disable_feature() throws Throwable {
		Actions actions = new Actions(driver);
		Thread.sleep(2000);
		actions.moveToElement(Catalogmgmt_objects.disableRow).click().build().perform();
		Catalogmgmt_objects.YesButton.click();
		log.info("Row disabled");
		wait.until(ExpectedConditions.visibilityOf(Catalogmgmt_objects.studioToasterMessage));
		assertEquals("Row updated successfully", Catalogmgmt_objects.studioToasterMessage.getText());
		Catalogmgmt_objects.toasterCloseButton.click();
		actions.moveToElement(Catalogmgmt_objects.rowDisabledElement).build().perform();
		Catalogmgmt_objects.rowDisabledElement.isDisplayed();
		log.info("Row disabled label is displaying");
	}

	@And("^Click on reorder option$")
	public void click_on_reorder_option() throws Throwable {
		Actions actions = new Actions(driver);
		actions.moveToElement(Catalogmgmt_objects.rowReorderButton).click().build().perform();
		log.info("clicked on reorder option");

	}

	@And("^reorder the cards$")
	public void reorder_the_cards() throws Throwable {
		WebElement firstCard = driver.findElement(By.xpath("//td[text()=' 1 ']//following::a[1]"));
		WebElement thirdCard = driver.findElement(By.xpath("//td[text()=' 1 ']//following::a[3]"));
		WebElement firstCardName = driver.findElement(By.xpath("//td[text()=' 1 ']//following::span[1]"));
		String beforeDrag = firstCardName.getText();
		log.info("First card name before drag :" + beforeDrag);
		Actions actions = new Actions(driver);
		actions.clickAndHold(firstCard).moveToElement(thirdCard).release(thirdCard).build().perform();
		Thread.sleep(2000);
		log.info("drag and drop succeed");
		WebElement thirdCardName = driver.findElement(By.xpath("//td[text()=' 3 ']//following::span[1]"));
		String afterDrag = thirdCardName.getText();
		log.info("Third card name after drag :" + afterDrag);
		Thread.sleep(1000);
		assertEquals(beforeDrag, afterDrag);
		log.info("reorder succeed");
		actions.moveToElement(Catalogmgmt_objects.ctaMgmtElement).click().build().perform();

	}

	@And("^select card check box from home$")
	public void select_card_check_box_from_home() throws Throwable {
		supportClass.scrollDown();
		Actions actions = new Actions(driver);
		actions.moveToElement(Catalogmgmt_objects.shoCardCheckBox).build().perform();
		executor.executeScript("arguments[0].click();", Catalogmgmt_objects.shoCardCheckBox);
		log.info("clicked on check box");
	}

	@And("^delete the selected card$")
	public void delete_the_selected_card() throws Throwable {
		Actions actions = new Actions(driver);
		actions.moveToElement(Catalogmgmt_objects.rowDeleteButton).click().build().perform();
		Catalogmgmt_objects.YesButton.click();
		wait.until(ExpectedConditions.visibilityOf(Catalogmgmt_objects.studioToasterMessage));
		assertEquals("Successfully deleted from Row", Catalogmgmt_objects.studioToasterMessage.getText());
		Catalogmgmt_objects.studioToasterMessage.click();
		log.info("card deleted sucessfully");

	}

	@And("^search name (.+) and add into row (.+) and verify$")
	public void search_name_and_add_into_row_and_verify(String searching, String rowtype) throws Throwable {
		if (rowtype.equalsIgnoreCase("Sho & Series")) {
			Catalogmgmt_objects.searchFieldSho.sendKeys(searching);
			log.info("searching for sho :" + searching);
		} else if (rowtype.equalsIgnoreCase("Promos")) {
			Catalogmgmt_objects.searchFieldPromo.sendKeys(searching);
			log.info("searching for promos :" + searching);
		} else if (rowtype.equalsIgnoreCase("Audio Tracks")) {
			Catalogmgmt_objects.searchFieldAudio.sendKeys(searching);
			log.info("searching for audio :" + searching);
		}
		String resultSho = Catalogmgmt_objects.searchResultFirstSho.getText();
		log.info("search result 1st record :" + resultSho);
		resultSho.contains(searching);
	}

	@And("^select search filter into sho and verify the results$")
	public void select_search_filter_into_sho_and_verify_the_results() throws Throwable {
		Catalogmgmt_objects.filterAll.click();
		wait.until(ExpectedConditions.elementToBeClickable(Catalogmgmt_objects.filterBySho));
		Catalogmgmt_objects.filterBySho.click();
		Thread.sleep(2000);
		List<WebElement> allShoTypeLabel = driver
				.findElements(By.xpath("//*[@class='series-title ng-star-inserted']//child::span"));
		Iterator<WebElement> allshoLabel = allShoTypeLabel.iterator();
		while (allshoLabel.hasNext()) {
			WebElement labels = (WebElement) allshoLabel.next();
			assertEquals("Sho", labels.getText());
			log.info("label verified :" + labels.getText());
		}

	}

	@And("^select search filter into series and verify the results$")
	public void select_search_filter_into_series_and_verify_the_results() throws Throwable {
		Catalogmgmt_objects.filterAll.click();
		wait.until(ExpectedConditions.elementToBeClickable(Catalogmgmt_objects.filterBySeries));
		Catalogmgmt_objects.filterBySeries.click();
		Thread.sleep(2000);
		List<WebElement> allShoTypeLabel = driver
				.findElements(By.xpath("//*[@class='series-title ng-star-inserted']//child::span"));
		Iterator<WebElement> allshoLabel = allShoTypeLabel.iterator();
		while (allshoLabel.hasNext()) {
			WebElement labels = (WebElement) allshoLabel.next();
			assertEquals("Series", labels.getText());
			log.info("label verified :" + labels.getText());
		}
	}

	@And("^select search filter into all type and verify the results$")
	public void select_search_filter_into_all_type_and_verify_the_results() throws Throwable {
		Catalogmgmt_objects.filterAll.click();
		wait.until(ExpectedConditions.elementToBeClickable(Catalogmgmt_objects.filterByAll));
		Catalogmgmt_objects.filterByAll.click();
		Thread.sleep(2000);
		List<WebElement> allShoTypeLabel = driver
				.findElements(By.xpath("//*[@class='series-title ng-star-inserted']//child::span"));
		Iterator<WebElement> allshoLabel = allShoTypeLabel.iterator();
		while (allshoLabel.hasNext()) {
			WebElement labels = (WebElement) allshoLabel.next();
			if (labels.getText().equals("Sho")) {
				assertEquals("Sho", labels.getText());
				log.info("label verified :" + labels.getText());
			} else {
				assertEquals("Series", labels.getText());
				log.info("label verified :" + labels.getText());
			}

		}

	}

	@And("^update row name (.+) and (.+) verify$")
	public void update_row_name_and_verify(String newrowname, String rowtype) throws Throwable {

		if (rowtype.equalsIgnoreCase("Sho & Series")) {
			String currentRowName = Catalogmgmt_objects.getRowNameShoSeries.getText();
			log.info("the current row name is :" + currentRowName);
			Catalogmgmt_objects.rowEditButton.click();
			Catalogmgmt_objects.rowEditField.clear();
			Catalogmgmt_objects.rowEditField.sendKeys(newrowname);
			Catalogmgmt_objects.rowEditTickButton.click();
			String updatedRowName = Catalogmgmt_objects.getRowNameShoSeries.getText();
			updatedRowName.equalsIgnoreCase(newrowname);
			wait.until(ExpectedConditions.visibilityOf(Catalogmgmt_objects.studioToasterMessage));
			assertEquals("Row updated successfully", Catalogmgmt_objects.studioToasterMessage.getText());
			Catalogmgmt_objects.toasterCloseButton.click();
			log.info("row updated successfully for sho and series");

		} else if (rowtype.equalsIgnoreCase("Promos")) {

			String currentRowName = Catalogmgmt_objects.getRowNamePromos.getText();
			log.info("the current row name is :" + currentRowName);
			Catalogmgmt_objects.rowEditButtonPromo.click();
			Catalogmgmt_objects.rowEditField.clear();
			Catalogmgmt_objects.rowEditField.sendKeys(newrowname);
			Catalogmgmt_objects.rowEditTickButton.click();
			String updatedRowName = Catalogmgmt_objects.getRowNamePromos.getText();
			updatedRowName.equalsIgnoreCase(newrowname);
			wait.until(ExpectedConditions.visibilityOf(Catalogmgmt_objects.studioToasterMessage));
			assertEquals("Row updated successfully", Catalogmgmt_objects.studioToasterMessage.getText());
			Catalogmgmt_objects.toasterCloseButton.click();
			log.info("row updated successfully for promos");

		} else if (rowtype.equalsIgnoreCase("Audio Tracks")) {

			String currentRowName = Catalogmgmt_objects.getRowNameAudio.getText();
			log.info("the current row name is :" + currentRowName);
			Catalogmgmt_objects.rowEditButton.click();
			Catalogmgmt_objects.rowEditField.clear();
			Catalogmgmt_objects.rowEditField.sendKeys(newrowname);
			Catalogmgmt_objects.rowEditTickButton.click();
			String updatedRowName = Catalogmgmt_objects.getRowNameAudio.getText();
			updatedRowName.equalsIgnoreCase(newrowname);
			wait.until(ExpectedConditions.visibilityOf(Catalogmgmt_objects.studioToasterMessage));
			assertEquals("Row updated successfully", Catalogmgmt_objects.studioToasterMessage.getText());
			Catalogmgmt_objects.toasterCloseButton.click();
			log.info("row updated successfully for audios");

		}

	}

	@And("^Create 1st row sho series$")
	public void create_1st_row_sho_series() throws Throwable {
		Thread.sleep(1000);
		click_on_add_row_button_and_verify_the_pop();
		Thread.sleep(500);
		Catalogmgmt_objects.enterRowNameField.clear();
		Catalogmgmt_objects.enterRowNameField.sendKeys("1st row");
		log.info("Entering the row name --- " + "1st row");
		click_on_the_select_row_type_dropdown();
		List<WebElement> allRowTypes = driver.findElements(By.tagName("mat-option"));
		allRowTypes.get(0).click();
		log.info("selecting :" + allRowTypes.get(0).getText());
		click_on_save_button();

	}

	@And("^Add ten cards in to the sho row$")
	public void add_ten_cards_in_to_the_sho_row() throws Throwable {
		Catalogmgmt_objects.toasterCloseButton.click();

		executor.executeScript("arguments[0].click();", Catalogmgmt_objects.insertShoSeriesButton);
		log.info("clicked on insert card for sho & series");

		Thread.sleep(3000);
		Catalogmgmt_objects.selectFirst10.click();
		executor.executeScript("arguments[0].click();", Catalogmgmt_objects.insertButton);
		Catalogmgmt_objects.YesButton.click();

	}

	@And("^create 2nd row promo$")
	public void create_2nd_row_promo() throws Throwable {
		Thread.sleep(1000);
		Catalogmgmt_objects.addRowButton.click();
		Thread.sleep(500);
		Catalogmgmt_objects.enterRowNameField.clear();
		Catalogmgmt_objects.enterRowNameField.sendKeys("2st row");
		log.info("Entering the row name --- " + "2st row");
		click_on_the_select_row_type_dropdown();
		List<WebElement> allRowTypes = driver.findElements(By.tagName("mat-option"));
		allRowTypes.get(1).click();
		log.info("selecting :" + allRowTypes.get(1).getText());
		click_on_save_button();

	}

	@And("^Add ten cards in to the promo row$")
	public void add_ten_cards_in_to_the_promo_row() throws Throwable {
		Catalogmgmt_objects.toasterCloseButton.click();
		executor.executeScript("arguments[0].click();", Catalogmgmt_objects.insertPromosButton);
		log.info("clicked on insert card for sho & series");
		Thread.sleep(3000);
		Catalogmgmt_objects.selectFirst10.click();
		executor.executeScript("arguments[0].click();", Catalogmgmt_objects.insertButton);
		Catalogmgmt_objects.YesButton.click();
	}

	@And("^create 3rd row promo$")
	public void create_3rd_row_promo() throws Throwable {
		Thread.sleep(1000);
		Catalogmgmt_objects.addRowButton.click();
		Thread.sleep(500);
		Catalogmgmt_objects.enterRowNameField.clear();
		Catalogmgmt_objects.enterRowNameField.sendKeys("3st row");
		log.info("Entering the row name --- " + "3st row");
		click_on_the_select_row_type_dropdown();
		List<WebElement> allRowTypes = driver.findElements(By.tagName("mat-option"));
		allRowTypes.get(2).click();
		log.info("selecting :" + allRowTypes.get(2).getText());
		click_on_save_button();

	}

	@And("^Add ten cards in to the audio row$")
	public void add_ten_cards_in_to_the_audio_row() throws Throwable {
		Catalogmgmt_objects.toasterCloseButton.click();
		executor.executeScript("arguments[0].click();", Catalogmgmt_objects.insertAudioTracksButton);
		log.info("clicked on insert card for sho & series");
		Thread.sleep(3000);
		Catalogmgmt_objects.selectFirst10.click();
		executor.executeScript("arguments[0].click();", Catalogmgmt_objects.insertButton);
		Catalogmgmt_objects.YesButton.click();
		Thread.sleep(2000);

	}

	@Then("^Reorder the rows and verify$")
	public void reorder_the_rows_and_verify() throws Throwable {
		log.info("clicking on the shuffle row button");
		Catalogmgmt_objects.shuffleRows.click();
		Thread.sleep(1000);
		WebElement get1rdRowName = driver.findElement(By.xpath("//*[@cdkdroplistorientation='vertical']//div[2]"));
		log.info("The first row name is "+get1rdRowName.getText());
		WebElement firstRow = driver.findElement(By.xpath("//*[@cdkdroplistorientation='vertical']//following::span[2]"));
		WebElement lastRow = driver.findElement(By.xpath("//*[@cdkdroplistorientation='vertical']//following::span[4]"));
		Actions actions = new Actions(driver);
		actions.clickAndHold(firstRow).moveToElement(lastRow).release(lastRow).build().perform();
		log.info("reorder succsseed");
		Thread.sleep(2000);
		WebElement get3rdRowNameBefore = driver.findElement(By.xpath("//*[@cdkdroplistorientation='vertical']//div[4]"));
		log.info("The first row name is "+get3rdRowNameBefore.getText());
		assertEquals(get1rdRowName.getText(), get3rdRowNameBefore.getText());
		
		
		
		
	}
	
	 @Then("^delete the created rows$")
	    public void delete_the_created_rows() throws Throwable {
		 Actions actions = new Actions(driver);
		 actions.moveToElement(Catalogmgmt_objects.ctaMgmtElement).click().build().perform();
		 Thread.sleep(500);
		 for(int i=0 ; i<=2 ; i++) {
			 actions.moveToElement(Catalogmgmt_objects.rowDeleteButton).click().build().perform();
			 Catalogmgmt_objects.YesButton.click();
			 Thread.sleep(2000);
		 }
	 }
	 
	 @When("^click add banner button from center$")
		public void click_add_banner_button_from_center() throws Throwable {
			Catalogmgmt_objects.addNewBannerButtoncenter.click();
		}

		@Then("^click save and verify$")
		public void click_save_and_verify() throws Throwable {
			Catalogmgmt_objects.saveButtonBanner.click();
			Thread.sleep(2000);
			Catalogmgmt_objects.deleteBanbersingle.isDisplayed();

		}

		@And("^select five banners$")
		public void select_five_banners() throws Throwable {
			List<WebElement> alltitles = driver
					.findElements(By.xpath("//*[@class='mat-card-actions']//child::mat-checkbox"));
			for (int i = 1; i < 5; i++) {
				alltitles.get(i).click();
			}

		}

		@Then("^delete all banner$")
		public void delete_all_banner() throws Throwable {
			Catalogmgmt_objects.checkAll.click();
			Catalogmgmt_objects.deleteAllBanner.click();
			Catalogmgmt_objects.YesButton.click();
		}

		@When("^Delete singl banner$")
		public void delete_singl_banner() throws Throwable {
			Catalogmgmt_objects.deleteBanbersingle.click();
			Catalogmgmt_objects.YesButton.click();
		}

		@Then("^verify toaster$")
		public void verify_the_toaster() throws Throwable {
			Thread.sleep(3000);
			assertEquals("Banner has been deleted successfully", Catalogmgmt_objects.studioToasterMessage.getText());

		}

}
