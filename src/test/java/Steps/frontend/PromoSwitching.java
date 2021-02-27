package Steps.frontend;

import static org.junit.Assert.assertEquals;


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.frontend.PayWall_Objects;
import PageObjects.frontend.Shoorseriesdetailpage;
import PageObjects.frontend.videoandaudioPlayer;
import Resources.Base_setup;
import Resources.supportClass;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PromoSwitching extends Base_setup {
	
	@Given("^Launch the browser and naviagate to home page$")
	public void launch_the_browser_and_naviagate_to_home_page() throws Throwable {
		intiliazedriver();

	}

	@When("^search sho name (.+) for promo switching$")
	public void search_sho_name_for_promo_switching(String shoname) throws Throwable {
		supportClass.elasticSearch(shoname);

	}

	@And("^Play the first promo$")
	public void play_the_first_promo() throws Throwable {
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(Shoorseriesdetailpage.promosheadingm()));
		Actions a =new Actions(driver);
		a.moveToElement(PayWall_Objects.promoCard()).click().build().perform();
		

	}

	@And("^Drag to the end$")
	public void drag_to_the_end() throws Throwable {
		//supportClass.dragToEnd1();
		Thread.sleep(3000);
		videoandaudioPlayer.mousehoveronplayerm();
		videoandaudioPlayer.promoswitching1();

	}

	@And("^click on the next expisode button$")
	public void click_on_the_next_expisode_button() throws Throwable {
		Thread.sleep(1000);
		PayWall_Objects.nextPromoButton().click();

	}

	@Then("^verify promo is play the next$")
	public void verify_the_promo_is_play_the_next() throws Throwable {
		List<WebElement> allPromo = driver.findElements(By.tagName("h4"));
		String panelPromoName = allPromo.get(1).getText();
		Thread.sleep(5000);
		Actions actions = new Actions(driver);
		actions.moveToElement(PayWall_Objects.playButton()).click().build().perform();
		String playerPromoName = PayWall_Objects.getPromoNameFromPlayer().getText();
		assertEquals(playerPromoName, panelPromoName);

	}

	@And("^wait for ten seconds$")
	public void wait_for_ten_seconds() throws Throwable {
		Thread.sleep(12000);
	}

	@And("^click on fullscreen button$")
	public void click_on_fullscreen_button() throws Throwable {
		Actions actions = new Actions(driver);
		actions.moveToElement(PayWall_Objects.gudButton()).build().perform();
		Thread.sleep(500);
		actions.moveToElement(PayWall_Objects.fullscreenButton()).click().build().perform();
	}

}
