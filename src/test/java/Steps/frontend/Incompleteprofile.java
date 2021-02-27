package Steps.frontend;

import static org.junit.Assert.assertEquals;


import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.frontend.Shoorseriesdetailpage;
import PageObjects.frontend.Studioprofile;
import PageObjects.frontend.Toastanderrormessages;
import PageObjects.frontend.videoandaudioPlayer;
import Resources.Base_setup;
import cucumber.api.java.en.Then;

public class Incompleteprofile extends Base_setup
{
	WebDriverWait wait=new WebDriverWait(driver,20);
	 @Then("^Try to buy a sho or series and it will ask to complete the profile$")
	 public void try_to_buy_a_sho_or_series_and_it_will_ask_to_complete_the_profile() throws Throwable {
	        Shoorseriesdetailpage.playorbuybuttonm().click();
	        wait.until(ExpectedConditions.visibilityOf(Toastanderrormessages.toastmessagem()));
	        assertEquals(Toastanderrormessages.toastmessagem().getText(),"Please complete your profile to continue..");
	        System.out.println(Toastanderrormessages.toastmessagem().getText());
	        driver.navigate().back();
	        Studioprofile.scrolldownm();
	        Shoorseriesdetailpage.playorbuybuttonsmallm().click();
	        wait.until(ExpectedConditions.visibilityOf(Toastanderrormessages.toastmessagem()));
	        assertEquals(Toastanderrormessages.toastmessagem().getText(),"Please complete your profile to continue..");
	        driver.navigate().back();
	        Shoorseriesdetailpage.promocardsm().get(0).click();
	        videoandaudioPlayer.mousehoveronplayerm();
	        videoandaudioPlayer.promoswitching1();
	        videoandaudioPlayer.buyorplaybuttononminititle().click();
	        wait.until(ExpectedConditions.visibilityOf(Toastanderrormessages.toastmessagem()));
	        assertEquals(Toastanderrormessages.toastmessagem().getText(),"Please complete your profile to continue..");
	        driver.navigate().back();
	        videoandaudioPlayer.mousehoveronplayerm();
	        videoandaudioPlayer.closeplayerm().click();
	        Thread.sleep(2000);
	        //Studioprofile.scrolldownm();
	       // Actions a =new Actions(driver);
	        //a.moveToElement(Shoorseriesdetailpage.mousehoveronepisodecardsm().get(0)).click().build().perform();
	        Shoorseriesdetailpage.mousehoveronepisodecardsm().get(0).click();
	        wait.until(ExpectedConditions.visibilityOf(Toastanderrormessages.toastmessagem()));
	        assertEquals(Toastanderrormessages.toastmessagem().getText(),"Please complete your profile to continue..");
	        Thread.sleep(2000);
	        driver.navigate().back();
	       // Studioprofile.scrolldownm();
	        Thread.sleep(2000);
	        Shoorseriesdetailpage.episodespagelinkm().click();
	        wait.until(ExpectedConditions.visibilityOf(Shoorseriesdetailpage.backiconfromepisodepagem()));
	        Shoorseriesdetailpage.episodesnamesinepisodespagem().get(0).click();
	        wait.until(ExpectedConditions.visibilityOf(Toastanderrormessages.toastmessagem()));
	        assertEquals(Toastanderrormessages.toastmessagem().getText(),"Please complete your profile to continue..");
             
	    }
	
}
