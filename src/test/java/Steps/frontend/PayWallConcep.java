package Steps.frontend;

import static org.junit.Assert.assertEquals;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.frontend.PayWall_Objects;
import PageObjects.frontend.videoandaudioPlayer;
import Resources.Base_setup;
import Resources.supportClass;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PayWallConcep extends Base_setup {
	

	WebDriverWait wait=new WebDriverWait(driver,20);
	
	@Given("^Open the browser$")
    public void open_the_browser() throws Throwable {
        Base_setup.intiliazedriver();
        
    }
	
	
	
	
	@When("^click on add to watchlist from flick page$")
	public void click_on_add_to_watchlist_from_flick_page() throws Throwable {
		supportClass.scrollToButtom();
		Thread.sleep(1000);
		Actions actions = new Actions(driver);
		Thread.sleep(1000);
		actions.moveToElement(PayWall_Objects.shoCard()).build().perform();
		actions.click(PayWall_Objects.hoverAndClickOnAddToWatchlist()).build().perform();
	}

	@Then("^Verify the add to watchlist mini pop elements$")
	public void verify_the_add_to_watchlist_mini_pop_elements() throws Throwable {
		Thread.sleep(2000);
		assertEquals("Want to save & watch later?", PayWall_Objects.miniWatchLaterElement1().getText());
		assertEquals("Sign In to save this video & watch again later",
				PayWall_Objects.miniWatchLaterElement2().getText());
	}

	@And("^click on later button$")
	public void click_on_later_button() throws Throwable {
		Thread.sleep(2000);
		PayWall_Objects.miniLaterButton().click();
	}

	@And("^click on signin button$")
	public void click_on_signin_button() throws Throwable {
		Thread.sleep(500);
		PayWall_Objects.miniSignInButton().click();
	}

	@And("^verify that system is redirecting login page$")
	public void verify_that_system_is_redirecting_login_page() throws Throwable {
		Thread.sleep(2000);
		assertEquals("Hello there!", PayWall_Objects.signInPageElement1().getText());

	}

	@When("^search (.+) sho or series or studio$")
	public void search_sho_or_series_or_studio(String searchname) throws Throwable {
		supportClass.elasticSearch(searchname);
	}

	@Then("^click on add to watchlist button from sho detail page$")
	public void click_on_add_to_watchlist_button_from_sho_detail_page() throws Throwable {
		Thread.sleep(2000);
		PayWall_Objects.addToWatchlistButton().click();
	}

	@And("^Navigate back from login page$")
	public void navigate_back_from_login_page() throws Throwable {
		PayWall_Objects.signPageBackButton().click();
	}

	@Then("^scroll and click on the add to watchlist button$")
	public void scroll_and_click_on_the_add_to_watchlist_button() throws Throwable {
		supportClass.scrollToButtom();
		Actions actions = new Actions(driver);
		Thread.sleep(2000);
		actions.moveToElement(PayWall_Objects.scrollAddToWatchList()).click().build().perform();

	}

	@Then("^click on buy button$")
	public void click_on_buy_button() throws Throwable {
		wait.until(ExpectedConditions.elementToBeClickable(PayWall_Objects.buyButton()));
		//wait.until(ExpectedConditions.elementToBeClickable(PayWall_Objects.buyButton()));
		PayWall_Objects.buyButton().click();
	}

	@And("^Scroll and click on the buy button$")
	public void scroll_and_click_on_the_buy_button() throws Throwable {
		supportClass.scrollToButtom();
		Actions actions = new Actions(driver);
		Thread.sleep(3000);
		actions.moveToElement(PayWall_Objects.scrollAndBuy()).click().build().perform();

	}

	@Then("^scroll down and click on first episode$")
	public void scroll_down_and_click_on_first_episode() throws Throwable {
		supportClass.scrollToButtom();
		Thread.sleep(1000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", PayWall_Objects.firstEpisodeDetailPage());

	}

	@And("^Scroll down and click on episode hyper link$")
	public void scroll_down_and_click_on_episode_hyper_link() throws Throwable {
		supportClass.scrollToButtom();
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.moveToElement(PayWall_Objects.episodesHyperLink()).click().build().perform();

	}

	@And("^play the first episode$")
	public void play_the_first_episode() throws Throwable {
		Thread.sleep(2000);
		PayWall_Objects.episodesCard().click();
	}

	@When("^Scroll to bottom and play any promo$")
	public void scroll_to_bottom_and_play_any_promo() throws Throwable {
		supportClass.scrollToButtom();
		Actions actions = new Actions(driver);
		actions.moveToElement(PayWall_Objects.promoCard()).build().perform();
		actions.click(PayWall_Objects.promoCard()).build().perform();
		Thread.sleep(2000);
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();", PayWall_Objects.promoCard());
		Thread.sleep(3000);
	}

	@Then("^click on create gud button$")
	public void click_on_create_gud_button() throws Throwable {
		//videoandaudioPlayer.mousehoveronplayerm();
		//wait.until(ExpectedConditions.visibilityOf(PayWall_Objects.gudButton()));
		Actions actions = new Actions(driver);
		actions.moveToElement(PayWall_Objects.gudButton()).build().perform();
		actions.click(PayWall_Objects.gudButton()).build().perform();

	}

	@And("^verify mini popup elements of create gud$")
	public void verify_mini_popup_elements_of_create_gud() throws Throwable {
		Thread.sleep(2000);
		assertEquals("Rating 'Gud' for this promo?", PayWall_Objects.promoMiniElement1().getText());
		assertEquals("Sign In to register your feeling 'Gud' for this promo",
				PayWall_Objects.promoMiniElement2().getText());

	}

	@And("^play promo in fullscreen$")
	public void play_promo_in_fullscreen() throws Throwable {
		Actions actions = new Actions(driver);
		actions.moveToElement(PayWall_Objects.gudButton()).build().perform();
		Thread.sleep(500);
		actions.moveToElement(PayWall_Objects.fullscreenButton()).click().build().perform();
	}

	@When("^Scroll to bottom and follow any studio$")
	public void scroll_to_bottom_and_follow_any_studio() throws Throwable {
		PayWall_Objects.streamingButton().click();
		supportClass.scrollToButtom();
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.moveToElement(PayWall_Objects.followButton()).click().build().perform();
	}

	@Then("^verify mini popup elements of follow$")
	public void verify_mini_popup_elements_of_follow() throws Throwable {
		Thread.sleep(2000);
		assertEquals("Want to follow this studio?", PayWall_Objects.miniFolloElement1().getText());
		assertEquals("Sign In to Follow this Studio & stay updated", PayWall_Objects.miniFolloElement2().getText());
	}

	@Then("^follow any studio$")
	public void follow_any_studio() throws Throwable {
		PayWall_Objects.followButton().click();
	}

	@When("^click on shocial and click on explore studio card$")
	public void click_on_shocial_and_click_on_explore_studio_card() throws Throwable {
		PayWall_Objects.shocialButton().click();
		PayWall_Objects.exploreButton().click();
	}

	@Then("^click on follow button from studio detail page$")
	public void click_on_follow_button_from_studio_detail_page() throws Throwable {
		PayWall_Objects.studioFollowButton().click();
	}

	@When("^scroll to bottom and play any audio$")
	public void scroll_to_bottom_and_play_any_audio() throws Throwable {
		Thread.sleep(500);
		supportClass.scrollToButtom();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", PayWall_Objects.audioCard());
		//PayWall_Objects.audioCard().click();
		//Actions actions = new Actions(driver);
		Thread.sleep(1000);
		/*actions.moveToElement(PayWall_Objects.audioCard()).build().perform();
		Thread.sleep(1000);
		actions.click(PayWall_Objects.audioCard()).click().build().perform();*/
	}

	@Then("^verify audio player$")
	public void verify_audio_player() throws Throwable {
		PayWall_Objects.audioPlayerminicard().isDisplayed();
	}

	@And("^click on the fav button from player$")
	public void click_on_the_fav_button_from_player() throws Throwable {
		PayWall_Objects.audioFav().click();
	}

	@Then("^verify mini popup elements of favorite$")
	public void verify_mini_popup_elements_of_favorite() throws Throwable {
		Thread.sleep(2000);
		assertEquals("Liking this audio?", PayWall_Objects.miniAudioElement1().getText());
		assertEquals("Sign in to make this audio as your favourite", PayWall_Objects.miniAudioElement2().getText());
	}

	@Then("^scroll to bottom and click on play all button$")
	public void scroll_to_bottom_and_click_on_play_all_button() throws Throwable {
		Thread.sleep(500);
		supportClass.scrollToButtom();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", PayWall_Objects.audioPlayAllButton());
	}

	@And("^Click on add to watchlist button from minititle$")
	public void click_on_add_to_watchlist_button_from_minititle() throws Throwable {
		Thread.sleep(1500);
		PayWall_Objects.addToWatchlistButton().click();
	}

	@And("^forward to the end$")
	public void forward_to_the_end() throws Throwable {
		Thread.sleep(3000);
		videoandaudioPlayer.mousehoveronplayerm();
		videoandaudioPlayer.promoswitching1();
		try {
		driver.findElement(By.xpath("//*[text()=' Cancel ']")).click();
		}
		catch(Exception e)
		{
		    System.out.println("Not clicked");
		}
		Thread.sleep(3000);

	}

	@Then("^play the promo$")
	public void play_the_promo() throws Throwable {
		supportClass.scrollToButtom();
		Actions actions = new Actions(driver);
		Thread.sleep(2000);
		actions.moveToElement(PayWall_Objects.promoCard()).click().build().perform();

	}

	@And("^Click on buy button from minititle$")
	public void click_on_buy_button_from_minititle() throws Throwable {
		PayWall_Objects.buyButton().click();
	}

	@And("^click on the watch free button$")
	public void click_on_the_watch_free_button() throws Throwable {
		PayWall_Objects.watchFreeButton().click();

	}

	@And("^Verify the coming soon button$")
	public void verify_the_coming_soon_button() throws Throwable {
		Thread.sleep(500);
		PayWall_Objects.comingSoonButton().isDisplayed();

	}

	@And("^create gud and verify the gud count$")
	public void create_gud_and_verify_the_gud_count() throws Throwable {
		Thread.sleep(3000);
		Actions actions = new Actions(driver);
		actions.moveToElement(PayWall_Objects.gudButton()).build().perform();
		String currentGudCount = PayWall_Objects.getGudCount().getText();
		actions.moveToElement(PayWall_Objects.gudButton()).build().perform();
		actions.click(PayWall_Objects.gudButton()).build().perform();
		PayWall_Objects.miniLaterButton().click();
		actions.moveToElement(PayWall_Objects.gudButton()).build().perform();
		String newGudCount = PayWall_Objects.getGudCount().getText();
		assertEquals(currentGudCount, newGudCount);

	}

	@Then("^close the browser$")
	public void close_the_browser() throws Throwable {
		driver.close();
	}

	@And("^close player$")
	public void close_player() throws Throwable {
		Actions actions = new Actions(driver);
		actions.moveToElement(PayWall_Objects.gudButton()).build().perform();
		actions.moveToElement(PayWall_Objects.playerCloseButton()).click().build().perform();
	}
}