package Steps.frontend;

import static org.junit.Assert.assertEquals;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.frontend.MyProfile_Objects;
import PageObjects.frontend.MyWatchHistoryObjects;
import PageObjects.frontend.PayWall_Objects;
import Resources.Base_setup;
import Resources.supportClass;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class WatchHistory extends Base_setup {

	public static Logger log = Logger.getLogger(WatchHistory.class.getName());
	WebDriverWait wait = new WebDriverWait(driver, 30);

	public String playerShoName;
	public String plainPlayerShoName;
	public String watchHistoryDate;
	public String plainwatchHistoryDate;
	public String watchHistoryShoName;
	public String PlainWatchHistoryShoName;
	public String shoTypeLabelDetailPage;
	public String shoTypeLabelwatchHistory;

	@When("^click on watch free button$")
	public void click_on_watch_free_button() throws Throwable {
		Thread.sleep(5000);
		shoTypeLabelDetailPage = MyWatchHistoryObjects.DetailPageShoTypeLabel().getText();
		log.info("The sho type label is :" + shoTypeLabelDetailPage);
		PayWall_Objects.watchFreeButton().click();
		log.info("Clicked on watch free button");

	}

	@Then("^verify played sho availability$")
	public void verify_played_sho_availability() throws Throwable {
		assertEquals(plainPlayerShoName, PlainWatchHistoryShoName);
		log.info("asserting player sho name with watch history sho name" + plainPlayerShoName + " | "
				+ plainPlayerShoName);
		DateFormat dateFormat = new SimpleDateFormat("ddMMMyyyy");
		Date date = new Date();
		String currentSytemDate = dateFormat.format(date);
		log.info("Getting current system date : " + currentSytemDate);
		assertEquals(plainwatchHistoryDate, currentSytemDate);
		log.info(
				"asserting watch history date with system date----" + plainwatchHistoryDate + " | " + currentSytemDate);
		assertEquals(shoTypeLabelDetailPage, shoTypeLabelwatchHistory);
		log.info("asserting detail page sho type label with watch history label ----" + shoTypeLabelDetailPage + " | "
				+ shoTypeLabelwatchHistory);
	}

	@And("^play for a while and close the player$")
	public void play_for_a_while_and_close_the_player() throws Throwable {
		Thread.sleep(10000);
		log.info("sho is playing for 10 seconds");
		Actions actions = new Actions(driver);
		actions.moveToElement(PayWall_Objects.playButton()).build().perform();
		playerShoName = PayWall_Objects.getPlayingshoName().getText();
		log.info("This sho: " + playerShoName + " is playing");
		plainPlayerShoName = playerShoName.replaceAll("[^a-zA-Z0-9]", "");
		actions.moveToElement(PayWall_Objects.playButton()).build().perform();
		PayWall_Objects.playerCloseButton().click();
		log.info("player closed");

	}

	@And("^navigate to my watch history$")
	public void navigate_to_my_watch_history() throws Throwable {
		Actions actions = new Actions(driver);
		actions.moveToElement(MyProfile_Objects.myProfileElement()).build().perform();
		log.info("Hovering on my profile");
		MyProfile_Objects.accountsAndSettingsElement().click();
		log.info("clicked the accounts and setting");
		MyProfile_Objects.myWatchHistory().click();
		log.info("clicking on the my watch history");
		wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//ul[@class='history-contene']//self::p"))));
		List<WebElement> allDates = driver.findElements(By.xpath("//ul[@class='history-contene']//self::p"));
		watchHistoryDate = allDates.get(0).getText();
		log.info("Getting the date of recently play sho " + watchHistoryDate);
		plainwatchHistoryDate = watchHistoryDate.replaceAll("[^a-zA-Z0-9]", "");
		List<WebElement> allshos = driver.findElements(By.xpath("//ul[@class='history-contene']//self::a"));
		watchHistoryShoName = allshos.get(0).getText();
		log.info("Getting the sho name of recently play sho " + watchHistoryShoName);
		PlainWatchHistoryShoName = watchHistoryShoName.replaceAll("[^a-zA-Z0-9]", "");

		shoTypeLabelwatchHistory = MyWatchHistoryObjects.watchHistoryShoTypeLabel().getText();
		log.info(shoTypeLabelwatchHistory);
	}

	@Then("^click on delete icon for the played sho$")
	public void click_on_delete_icon_for_the_played_sho() throws Throwable {
		List<WebElement> allDeleteIcons = driver
				.findElements(By.xpath("//ul[@class='history-contene']//self::mat-icon"));
		allDeleteIcons.get(0).click();
		log.info("clicked on the delete icon of recently played sho");
		Thread.sleep(500);

	}

	@And("^click on clear all button and verify the elements$")
	public void click_on_clear_all_button_and_verify_the_elements() throws Throwable {
		MyWatchHistoryObjects.clearAllButton().isDisplayed();
		log.info("clear all button is displaying");
		MyWatchHistoryObjects.clearAllButton().click();
		log.info("clicking on the clear all button");
		MyWatchHistoryObjects.clearAllButtonElements1().isDisplayed();
		log.info("Element 1 is present");
		MyWatchHistoryObjects.clearAllButtonElements2().isDisplayed();
		log.info("Element 2 is present");
		MyWatchHistoryObjects.clearAllYesButton().isDisplayed();
		log.info("Yes button is present");
		MyWatchHistoryObjects.clearAllNoButton().isDisplayed();
		log.info("No button is present");

	}

	@And("^click on no button and verify the sho availabilty$")
	public void click_on_no_button_and_verify_the_sho_availabilty() throws Throwable {
		Thread.sleep(1000);
		MyWatchHistoryObjects.clearAllNoButton().click();
		log.info("Clicked on the no button from the clear all popup");
		List<WebElement> allshos = driver.findElements(By.xpath("//ul[@class='history-contene']//self::a"));
		watchHistoryShoName = allshos.get(0).getText();
		PlainWatchHistoryShoName = watchHistoryShoName.replaceAll("[^a-zA-Z0-9]", "");
		log.info("Asserting the sho name");
		assertEquals(PlainWatchHistoryShoName, plainPlayerShoName);

	}

	@And("^click on yes and verify the CTA$")
	public void click_on_yes_and_verify_the_cta() throws Throwable {
		wait.until(ExpectedConditions.elementToBeClickable(MyWatchHistoryObjects.clearAllButton()));
		MyWatchHistoryObjects.clearAllButton().isDisplayed();
		MyWatchHistoryObjects.clearAllButton().click();
		log.info("clicking on the clear all button");
		MyWatchHistoryObjects.clearAllYesButton().click();
		Thread.sleep(2000);
		MyWatchHistoryObjects.watchHistoryElement1().isDisplayed();
		MyWatchHistoryObjects.watchHistoryElement2().isDisplayed();
		MyWatchHistoryObjects.watchHistoryElement3().isDisplayed();
		MyWatchHistoryObjects.startWatchButton().isDisplayed();

	}

	@Then("^the system should redirect the user to home page$")
	public void the_system_should_redirect_the_user_to_home_page() throws Throwable {
		Thread.sleep(2000);
		String homeUrl = driver.getCurrentUrl();
		assertEquals(homeUrl, "https://qa.gudsho.com/home");

	}

	@And("^click on the start watch button$")
	public void click_on_the_start_watch_button() throws Throwable {
		MyWatchHistoryObjects.startWatchButton().click();
	}

	@Then("^verify that respective sho is playing or not$")
	public void verify_that_respective_sho_is_playing_or_not() throws Throwable {

		Actions actions = new Actions(driver);
		actions.moveToElement(PayWall_Objects.playButton()).build().perform();
		playerShoName = PayWall_Objects.getPlayingshoName().getText();
		plainPlayerShoName = playerShoName.replaceAll("[^a-zA-Z0-9]", "");
		actions.moveToElement(PayWall_Objects.playButton()).build().perform();
		PayWall_Objects.playerCloseButton().click();
		assertEquals(PlainWatchHistoryShoName, plainPlayerShoName);

	}

	@And("^Click on the first hyperlink$")
	public void click_on_the_first_hyperlink() throws Throwable {
		List<WebElement> allshos = driver.findElements(By.xpath("//ul[@class='history-contene']//self::a"));
		watchHistoryShoName = allshos.get(0).getText();
		PlainWatchHistoryShoName = watchHistoryShoName.replaceAll("[^a-zA-Z0-9]", "");
		allshos.get(0).click();
		Thread.sleep(10000);

	}

	@When("^Scroll to buttom and play first episode$")
	public void scroll_to_buttom_and_play_first_episode() throws Throwable {
		Thread.sleep(2000);
		shoTypeLabelDetailPage = MyWatchHistoryObjects.DetailPageShoTypeLabel().getText();
		supportClass.scrollToButtom();
		Actions actions = new Actions(driver);
		actions.moveToElement(PayWall_Objects.firstEpisodeDetailPage()).click().build().perform();
	}

	@When("^Scroll to buttom and click on episodes hyperlink$")
	public void scroll_to_buttom_and_click_on_episodes_hyperlink() throws Throwable {
		Thread.sleep(2000);
		shoTypeLabelDetailPage = MyWatchHistoryObjects.DetailPageShoTypeLabel().getText();
		supportClass.scrollToButtom();
		Actions actions = new Actions(driver);
		actions.moveToElement(PayWall_Objects.episodesHyperLink()).click().build().perform();
	}

	@And("^Play for a while and click on next episode button$")
	public void play_for_a_while_and_click_on_next_episode_button() throws Throwable {
		Thread.sleep(10000);
		Actions actions = new Actions(driver);
		actions.moveToElement(PayWall_Objects.nextEpisodes()).click().build().perform();
	}

	@Then("^verify toaster message of delete sho$")
	public void verify_the_toaster_message_of_delete_sho() throws Throwable {

		String watchHistoryDeleteToastSho = playerShoName + " has been removed from Watch History";
		assertEquals(PayWall_Objects.toasterMessage().getText(), watchHistoryDeleteToastSho);

	}

	@Then("^verify toaster message of delete series$")
	public void verify_the_toaster_message_of_delete_series() throws Throwable {
		String episodeNamewatchHistory = watchHistoryShoName;
		String[] watchHistoryparts = episodeNamewatchHistory.split(":");
		String part1 = watchHistoryparts[0];
		log.info("split part 1: "+part1);
		String part2 = watchHistoryparts[1];
		log.info("split part 2: "+part2);
		String part3 = watchHistoryparts[2];
		log.info("split part 3: "+part3);
		String conCatNames = watchHistoryparts[1] + watchHistoryparts[2];
		String conCatNamesPlane = conCatNames.replaceAll("[^a-zA-Z0-9]", "");
		String toast = PayWall_Objects.toasterMessage().getText();
		String tostPlane = toast.replaceAll("[^a-zA-Z0-9]", "");
		System.out.println("print the plane episode name" + conCatNamesPlane);
		System.out.println("print the plane toster episode name" + tostPlane);
		assertEquals(conCatNamesPlane + "hasbeenremovedfromWatchHistory", tostPlane);
		System.out.println("print the watch history name:" + watchHistoryShoName);
		System.out.println("print the toast message name:" + PayWall_Objects.toasterMessage().getText());

	}

	@When("^Scroll to buttom and collect all episodes$")
	public void scroll_to_buttom_and_collect_all_episodes() throws Throwable {
		supportClass.scrollToButtom();

		List<WebElement> allEpisodes = driver.findElements(By.xpath("//*[@class='swiper-wrapper episode-wrapper']"));
		for (int i = 0; i < allEpisodes.size(); i++) {
			allEpisodes.get(i).click();
			Thread.sleep(5000);
			Actions actions = new Actions(driver);
			actions.moveToElement(PayWall_Objects.playerCloseButton()).click().build().perform();
		}
		
	}
	
	 @And("^forward to the end for sho$")
	    public void forward_to_the_end_for_sho() throws Throwable {
		 Thread.sleep(2000);
		 supportClass.dragToEnd();
	 }

}
