package Steps.frontend;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.frontend.Paymentpage;
import PageObjects.frontend.Shareandfollow;
import PageObjects.frontend.Shoorseriesdetailpage;
import PageObjects.frontend.Studioprofile;
import PageObjects.frontend.Toastanderrormessages;
import PageObjects.frontend.videoandaudioPlayer;
import Resources.Base_setup;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Shoorseriesdetailpagesteps extends Base_setup
{
	public static Logger log=Logger.getLogger(Shoorseriesdetailpagesteps.class.getName());
	Actions a=new Actions(driver);
	WebDriverWait wait=new WebDriverWait(driver,30);
	
	 @Then("^scroll down the page and click on watchlist button$")
	    public void scroll_down_the_page_and_click_on_watchlist_button() throws Throwable {
	        Studioprofile.scrolldownm();
	        Shoorseriesdetailpage.headerwatchlistbuttonm().click();
	    }
	
	@Then("^Check the page title and (.+)is showing on page$")
    public void check_the_page_title_and_is_showing_on_page(String shoseriesorstudioname) throws Throwable {
		
		//wait.until(ExpectedConditions.titleContains(shoseriesorstudioname));
		wait.until(ExpectedConditions.visibilityOf(Shoorseriesdetailpage.playorbuybuttonm()));
		Thread.sleep(1000);
       String Actual= driver.getTitle();
       log.info("Actual title is:" + Actual);
       assertTrue(Actual.equalsIgnoreCase("GudSho | " + shoseriesorstudioname));
    }
	@Then("^Scrolldown and check the watchlist is showing (.+)$")
    public void scrolldown_and_check_the_watchlist_is_showing(String shoseriesorstudioname) throws Throwable {
        Studioprofile.scrolldownm();
       assertTrue(Shoorseriesdetailpage.shoorseriesnameonheader().isDisplayed());
       log.info(Shoorseriesdetailpage.shoorseriesnameonheader().getText());
       assertEquals(shoseriesorstudioname,Shoorseriesdetailpage.shoorseriesnameonheader().getText());
        assertTrue(Shoorseriesdetailpage.headerwatchlistbuttonm().isDisplayed());
        log.info("Step Passed");
    }
	@And("^check (.+) and watch list button is dsiplaying$")
    public void check_and_watch_list_button_is_dsiplaying(String shoseriesorstudioname) throws Throwable {
		String Actual=Shoorseriesdetailpage.shonameinshodetailspage().getText();
		log.info("Actual Sho or series name displayed in sho detail page is:" + Actual);
		log.info("Expected Sho or series name is:" + shoseriesorstudioname);
		assertEquals(Actual,shoseriesorstudioname);
		assertTrue(Shoorseriesdetailpage.watchlistnuttonm().isDisplayed());
		
    }
	@Then("^check studioname is displayed and studioname should matches with (.+)$")
    public void check_studioname_is_displayed_and_studioname_should_matches_with(String studioname) throws Throwable {
		assertTrue(Shoorseriesdetailpage.studionameonshodetailpagem().isDisplayed());
		String Actual=Shoorseriesdetailpage.studionameonshodetailpagem().getText();
		log.info("Actual studio name displayed in Shodetail page:" + Actual);
		log.info("Expected Studio name is:" + studioname);
		assertEquals(Actual,studioname);
		log.info("Step Passed");
    }
	@And("^Click on (.+) and check the redirection of the page$")
    public void click_on_and_check_the_redirection_of_the_page(String studioname) throws Throwable {
		wait.until(ExpectedConditions.elementToBeClickable(Shoorseriesdetailpage.studionameonshodetailpagem()));
		Thread.sleep(500);
		Shoorseriesdetailpage.studionameonshodetailpagem().click();
        wait.until(ExpectedConditions.visibilityOf(Studioprofile.studionameonstudiopagem()));
        String Actual=Studioprofile.studionameonstudiopagem().getText();
        log.info("Actual studioname is displayed ain Studio detail page :" + Actual);
        log.info("Expected studio name is:" + studioname);
        log.info("Step passed"); 
        assertEquals(Actual+"'s",studioname);
    }
	 @Then("^The sho type is (.+)$")
	    public void the_sho_type_is(String shoorseries) throws Throwable {
		 String Actual=Shoorseriesdetailpage.shoorseriestagm().getText();
		 log.info("Actual tag for the sho is :" + Actual);
		 log.info("Expected tag for sho is :" + shoorseries);
		 assertEquals(Actual,shoorseries);
		 log.info("Step is passed");
	    }

	    @And("^The season counts should be (.+)$")
	    public void the_season_counts_should_be(String totalseason) throws Throwable {
	    	String Actual=Shoorseriesdetailpage.seasonscountm().getText();
			 log.info("Actual tag for the season count is :" + Actual);
			 log.info("Expected tag for season count is :" + totalseason);
			 assertEquals(Actual,totalseason);
			 log.info("Step is passed");
	    }

	    @And("^The maturity rating is (.+)$")
	    public void the_maturity_rating_is(String rating) throws Throwable {
	    	String Actual=Shoorseriesdetailpage.maturityratingm().getText();
			 log.info("Actual tag for the maturity rating is :" + Actual);
			 log.info("Expected tag for maturity rating is :" + rating);
			 assertEquals(Actual,rating);
			 log.info("Step is passed");
	    }

	    @And("^The default genere is (.+)$")
	    public void the_default_genere_is(String genere) throws Throwable {
	    	String Actual=Shoorseriesdetailpage.defaultgenerenamem().getText();
			 log.info("Actual tag for the default genere is :" + Actual);
			 log.info("Expected tag for default genere is :" + genere);
			 assertEquals(Actual,genere);
			 log.info("Step is passed");
	    }

	    @And("^The languages showing (.+)$")
	    public void the_languages_showing(String language) throws Throwable {
	    	String Actual=Shoorseriesdetailpage.languagestagm().getText();
			 log.info("Actual tag for the languages is :" + Actual);
			 log.info("Expected tag for languages is :" + language);
			 assertEquals(Actual,language);
			 
	    }
	    @And("^The screensdate should be (.+)$")
	    public void the_screensdate_should_be(String screeneddate) throws Throwable {
	    	String Actual=Shoorseriesdetailpage.screeneddateforseries().getText();
			 log.info("Actual tag for the languages is :" + Actual);
			 log.info("Expected tag for languages is :" + screeneddate);
			 assertEquals(Actual,screeneddate);
	    }
	    @Then("^check sho or series description is displaying$")
	    public void check_sho_or_series_description_is_displaying() throws Throwable {
	    	assertTrue(Shoorseriesdetailpage.shoorseriesdescriptionm().isDisplayed());
	    	log.info(Shoorseriesdetailpage.shoorseriesdescriptionm().getText());
	    	log.info("Step is passed");
	    }
	    @And("^The main heading of sho or series detail is showing$")
	    public void the_main_heading_of_sho_or_series_detail_is_showing() throws Throwable {
	    	String str=Shoorseriesdetailpage.aboutshoorseriesheadingm().getText();
	       assertTrue(Shoorseriesdetailpage.aboutshoorseriesheadingm().isDisplayed());
	       log.info(Shoorseriesdetailpage.aboutshoorseriesheadingm().getText());
	       assertEquals("About"+" "+Shoorseriesdetailpage.shonameinshodetailspage().getText(),str);
	    }
	    @Then("^Check the readmore link is showing and click on it$")
	    public void check_the_readmore_link_is_showing_and_click_on_it() throws Throwable {
	    	try {
	    	Shoorseriesdetailpage.shoorseriesdescreadmorelinkm().isDisplayed();
	    	assertTrue(Shoorseriesdetailpage.shoorseriesdescreadmorelinkm().isDisplayed());
	    	Shoorseriesdetailpage.shoorseriesdescreadmorelinkm().click();
	    	assertTrue(Shoorseriesdetailpage.shoorseriesdescinsynposism().isDisplayed());
	    	log.info(Shoorseriesdetailpage.shoorseriesdescinsynposism().getText());
	    	
	    	}
	    	catch(Exception e)
	    	{
	    		log.info("No read More link");
	    	}
	    	log.info("step is passed");
	    }
	    @Then("^click on watchlist button from sho detail page$")
	    public void click_on_watchlist_button_from_sho_detail_page() throws Throwable {
	    	wait.until(ExpectedConditions.elementToBeClickable(Shoorseriesdetailpage.watchlistnuttonm()));
	    	Thread.sleep(500);
	    	//JavascriptExecutor js=(JavascriptExecutor)driver;
	    	
	    	//a.click(Shoorseriesdetailpage.watchlistnuttonm()).build().perform();
	    	Shoorseriesdetailpage.watchlistnuttonm().click();
	    	//a.moveToElement(Shoorseriesdetailpage.watchlistnuttonm()).build().perform();
	    	//js.executeScript("arguments[0].click();",Shoorseriesdetailpage.watchlistnuttonm());
	    	//a.click(Shoorseriesdetailpage.watchlistnuttonm()).build().perform();
	    	wait.until(ExpectedConditions.visibilityOf(Toastanderrormessages.toastmessagem()));
	    	
	    }
	    @And("^Check share button is visible and share with facebook$")
	    public void check_share_button_is_visible_and_share_with_facebook() throws Throwable {
	    	wait.until(ExpectedConditions.visibilityOf(Shoorseriesdetailpage.sharebuttonm()));
	        assertTrue(Shoorseriesdetailpage.sharebuttonm().isDisplayed());
	       wait.until(ExpectedConditions.elementToBeClickable(Shoorseriesdetailpage.sharebuttonm()));
	        Shoorseriesdetailpage.sharebuttonm().click();
	        wait.until(ExpectedConditions.visibilityOf(Shareandfollow.sharepopup()));
	        Shareandfollow.facebooksharem();
	        Shareandfollow.facebookwindowhandle();
	        
	    }
	    @Then("^check share button is visble and share with twitter$")
	    public void check_share_button_is_visble_and_share_with_twitter() throws Throwable {
	    	assertTrue(Shoorseriesdetailpage.sharebuttonm().isDisplayed());
	        Shareandfollow.twittersharem();
	        Shareandfollow.twitterwindowhandle();
	        
	    }
	    @Then("^check share button is visble and share with watsapp share$")
	    public void check_share_button_is_visble_and_share_with_watsapp_share() throws Throwable {
	    	assertTrue(Shoorseriesdetailpage.sharebuttonm().isDisplayed());
	        Shareandfollow.whatsappsharem();
	        Thread.sleep(2000);
	        Shareandfollow.whatsappswindowhandle();
	        
	    }
	    @Then("^Feelers is visible and check all the feelers titles$")
	    public void feelers_is_visible_and_check_all_the_feelers_titles() throws Throwable {
	    	assertTrue(Shoorseriesdetailpage.feelersheadinginshodetailpagem().isDisplayed());
	    	int size=Shoorseriesdetailpage.feelerssmilesinshodetailpagem().size();
	    	for(int i=0;i<size;i++)
	    	{
	    		String text=Shoorseriesdetailpage.feelerssmilesinshodetailpagem().get(i).getText();
	    		assertTrue(Shoorseriesdetailpage.feelerssmilesinshodetailpagem().get(i).isDisplayed());
	    		assertTrue(Shoorseriesdetailpage.feelerspercentagem().get(i).isDisplayed());
	    		log.info("Feelers smiles title:" + text);
	    		log.info(text +" feeler percentage is:" + Shoorseriesdetailpage.feelerspercentagem().get(i).getText());
	    	}
	    }
	    @Then("^Check whether the sho or series have promos and extras section$")
	    public void check_whether_the_sho_or_series_have_promos_and_extras_section() throws Throwable {
	    	try {
	        assertTrue(Shoorseriesdetailpage.promosheadingm().isDisplayed());
	        assertEquals(Shoorseriesdetailpage.promosheadingm().getText(),"Promos & Extras");
	        log.info("Promos Heading is :" + Shoorseriesdetailpage.promosheadingm().getText());
	    	}
	    	catch(Exception e)
	    	{
	    		log.info("No promos available for this sho or series");
	    	}
	        
	    }
	    @Then("^Play the (.+) from sho detail page$")
	    public void play_the_from_sho_detail_page(String promoname) throws Throwable {
	    	int Actual=Shoorseriesdetailpage.viewcountonshodetailpagem(promoname);
	    	log.info(Actual);
	    	int Actual1=Shoorseriesdetailpage.gudcountonshodetailpagem(promoname);
	    	log.info(Actual1);
	    	Shoorseriesdetailpage.promoorepisodenamesonshodetailpagem(promoname);
	    	//Thread.sleep(1000);
	    	
	    }
	    @Then("^Play (.+) from sho detail page and check the view and gud count incremented by one$")
	    public void play_from_sho_detail_page_and_check_the_view_and_gud_count_incremented_by_one(String promoname) throws Throwable {
	        int beforeviewcount=Shoorseriesdetailpage.viewcountonshodetailpagem(promoname);
	    	log.info("Promo view count before playing promo:" + beforeviewcount);
	    	int gudcountbefore=Shoorseriesdetailpage.gudcountonshodetailpagem(promoname);
	    	log.info("Promo gud count before playing promo:" + gudcountbefore);
	    	Shoorseriesdetailpage.promoorepisodenamesonshodetailpagem(promoname);
	    	Thread.sleep(3000);
	    	videoandaudioPlayer.mousehoveronplayerm();
	    	int gudcountbeforeonplayer=videoandaudioPlayer.gudcountonplayer();
	    	assertEquals(gudcountbefore,gudcountbeforeonplayer);
	    	videoandaudioPlayer.clapsymbolinplayerm().click();
	    	wait.until(ExpectedConditions.visibilityOf(Toastanderrormessages.toastmessagem()));
	    	Toastanderrormessages.toastmessageclosem().click();
	    	videoandaudioPlayer.mousehoveronplayerm();
	    	int gudcountafteronplayer=videoandaudioPlayer.gudcountonplayer();
	    	videoandaudioPlayer.closeplayerm().click();
	        wait.until(ExpectedConditions.visibilityOf(Shoorseriesdetailpage.shonameinshodetailspage()));
	        int afterviewcount=Shoorseriesdetailpage.viewcountonshodetailpagem(promoname);
	    	log.info("Promo view count after playing promo:" + afterviewcount);
	    	int gudcountafter=Shoorseriesdetailpage.gudcountonshodetailpagem(promoname);
	    	log.info("Promo gud count after playing promo:" + gudcountafter);
	    	assertEquals(gudcountafteronplayer,gudcountafter);
	    	assertEquals(beforeviewcount+1,afterviewcount);
	    	assertEquals(gudcountbefore+1,gudcountafter);
	    }
	    @Then("^Play (.+) from sho detail page and check the view and gud count decremented by one$")
	    public void play_from_sho_detail_page_and_check_the_view_and_gud_count_decremented_by_one(String promoname) throws Throwable {
	    	int beforeviewcount=Shoorseriesdetailpage.viewcountonshodetailpagem(promoname);
	    	log.info("Promo view count before playing promo:" + beforeviewcount);
	    	int gudcountbefore=Shoorseriesdetailpage.gudcountonshodetailpagem(promoname);
	    	log.info("Promo gud count before playing promo:" + gudcountbefore);
	    	Shoorseriesdetailpage.promoorepisodenamesonshodetailpagem(promoname);
	    	Thread.sleep(3000);
	    	videoandaudioPlayer.mousehoveronplayerm();
	    	int gudcountbeforeonplayer=videoandaudioPlayer.gudcountonplayer();
	    	assertEquals(gudcountbefore,gudcountbeforeonplayer);
	    	videoandaudioPlayer.clapsymbolinplayerm().click();
	    	wait.until(ExpectedConditions.visibilityOf(Toastanderrormessages.toastmessagem()));
	    	Toastanderrormessages.toastmessageclosem().click();
	    	videoandaudioPlayer.mousehoveronplayerm();
	    	int gudcountafteronplayer=videoandaudioPlayer.gudcountonplayer();
	    	videoandaudioPlayer.closeplayerm().click();
	    	wait.until(ExpectedConditions.visibilityOf(Shoorseriesdetailpage.shonameinshodetailspage()));
	        int afterviewcount=Shoorseriesdetailpage.viewcountonshodetailpagem(promoname);
	    	log.info("Promo view count after playing promo:" + afterviewcount);
	    	int gudcountafter=Shoorseriesdetailpage.gudcountonshodetailpagem(promoname);
	    	log.info("Promo gud count after playing promo:" + gudcountafter);
	    	assertEquals(gudcountafteronplayer,gudcountafter);
	    	assertEquals(beforeviewcount+1,afterviewcount);
	    	assertEquals(gudcountbefore-1,gudcountafter);
	    }
	    
	    @Then("^check musical tracks title is displaying$")
	    public void check_musical_tracks_title_is_displaying() throws Throwable {
	    	try {
	    		wait.until(ExpectedConditions.visibilityOf(Shoorseriesdetailpage.Musicaltrackstitlem()));
	        assertTrue(Shoorseriesdetailpage.Musicaltrackstitlem().isDisplayed());
	        String Musicaltracktitile=Shoorseriesdetailpage.Musicaltrackstitlem().getText();
	        log.info("The musical track title showing as:" + Musicaltracktitile);
	        assertEquals(Musicaltracktitile,"Musical Tracks");
	    	}
	    	catch (Exception e)
	    	{
	    		log.info("No Musical tracks available for this sho or series");
	    	}
	        
	    }
	    @Then("^Check (.+) and total (.+) and (.+) and play all button is displayed$")
	    public void check_and_total_and_and_play_all_button_is_displayed(String name, String nooftracks, String duration) throws Throwable {
	       try {
	    	   Shoorseriesdetailpage.musicaltrackimagem().isDisplayed();
	    	   Shoorseriesdetailpage.commonnameofalltracksm().isDisplayed();
	        String Trackssname=Shoorseriesdetailpage.commonnameofalltracksm().getText();
	        assertTrue(name.equalsIgnoreCase(Trackssname));
	        assertTrue(Shoorseriesdetailpage.copyrightstatementm().isDisplayed());
	        log.info(Shoorseriesdetailpage.copyrightstatementm().getText());
	        assertTrue(Shoorseriesdetailpage.playallbuttonm().isDisplayed());
	        assertTrue(Shoorseriesdetailpage.totaldurationm().isDisplayed());
	        String totoalduration=Shoorseriesdetailpage.totaldurationm().getText();
	        log.info("Total duration of the all tracks:" + totoalduration);
	        String trackscount=Shoorseriesdetailpage.trackscountm().getText();
	        log.info("Total no of tracks:" + trackscount);
	        assertTrue(Shoorseriesdetailpage.trackscountm().isDisplayed()); 
	        assertEquals(totoalduration,duration);
	        assertEquals(nooftracks,trackscount);
	       }
	       catch (Exception e)
	       {
	    	   log.info("No Musical Tracks for this Sho or series");
	       }
	    }
	    @Then("^check all the titles are displaying$")
	    public void check_all_the_titles_are_displaying() throws Throwable {
	    	try {
	    	assertTrue(Shoorseriesdetailpage.headersofplaylisttitlem().isDisplayed());
	        String title= Shoorseriesdetailpage.headersofplaylisttitlem().getText();
	        log.info(title);
	        assertEquals(title,"TITLE");
	        assertTrue(Shoorseriesdetailpage.headersofplaylistcomposerm().isDisplayed());
	        String composertitile=Shoorseriesdetailpage.headersofplaylistcomposerm().getText();
	        log.info(composertitile);
	        assertEquals(composertitile,"COMPOSER");
	        assertTrue(Shoorseriesdetailpage.headerofplaylistartistm().isDisplayed());
	        String artisttitle=Shoorseriesdetailpage.headerofplaylistartistm().getText();
	        log.info(artisttitle);
	        assertEquals(artisttitle,"ARTIST");
	        assertTrue(Shoorseriesdetailpage.headerofplaylistdurationm().isDisplayed());
	        String durationtitle=Shoorseriesdetailpage.headerofplaylistdurationm().getText();
	        log.info(durationtitle);
	        assertEquals(durationtitle,"DURATION");
	        
	    }
	        catch (Exception e)
	        {
	    	    log.info("No Musical Tracks for this Sho or series");
	        }

	    }
	    @Then("^Click on Playall button and check the audio player is opened and playing first song$")
	    public void click_on_playall_button_and_check_the_audio_player_is_opened_and_playing_first_song() throws Throwable {
	    	Shoorseriesdetailpage.playallbuttonm().click();
	        wait.until(ExpectedConditions.visibilityOf(videoandaudioPlayer.gudshoiconinaudioplayerm()));
	        assertTrue(videoandaudioPlayer.gudshoiconinaudioplayerm().isDisplayed());
	        String Actual=videoandaudioPlayer.audionameonplayerm().getText();
	        log.info(Actual);
	        String expected=Shoorseriesdetailpage.audioname().getText();
	        log.info(expected);
	        assertTrue(Actual.equalsIgnoreCase(expected));
	    }
	    @Then("^Play (.+) from the player section$")
	    public void play_from_the_player_section(String audioname) throws Throwable {
	    	
	    	Shoorseriesdetailpage.audionamesinshodetailpagem(audioname);
	    	Shoorseriesdetailpage.audiodurationsm(audioname);
	        assertEquals(Shoorseriesdetailpage.audioduration,"02:53");
	        Shoorseriesdetailpage.audiodurationsm(audioname);
	        wait.until(ExpectedConditions.visibilityOf(videoandaudioPlayer.audionameonplayerm()));
	        String Actual=videoandaudioPlayer.audionameonplayerm().getText();
	        log.info(Actual);
	        Thread.sleep(500);
	        assertTrue(Actual.equalsIgnoreCase(audioname));
	        assertTrue(videoandaudioPlayer.gudshoiconinaudioplayerm().isDisplayed());
	    }
	    @Then("^The Specifics heading and the Specifics details$")
	    public void the_specifics_heading_and_the_specifics_details() throws Throwable {
	       int size=Shoorseriesdetailpage.Specificsm().size();
	       for(int i=0;i<size;i++)
	       {
	    	   assertTrue(Shoorseriesdetailpage.Specificsm().get(i).isDisplayed());
	    	   String heading=Shoorseriesdetailpage.Specificsm().get(i).getText();
	    	   String text=Shoorseriesdetailpage.synopsisheadingcontentm().get(i).getText();
	    	   log.info(heading + " is :"  + text);
	       }
	       assertEquals(Shoorseriesdetailpage.Specificsm().get(0).getText(),"Sho ID");
	       assertEquals(Shoorseriesdetailpage.Specificsm().get(1).getText(),"Tags");
	       assertEquals(Shoorseriesdetailpage.Specificsm().get(2).getText(),"Initial Released Date");
	       assertEquals(Shoorseriesdetailpage.Specificsm().get(3).getText(),"Audio language");
	       assertEquals(Shoorseriesdetailpage.Specificsm().get(4).getText(),"Subtitles");
	       
	       
	    }
	    @Then("^The cast details heading and the cast details$")
	    public void the_cast_details_heading_and_the_cast_details() throws Throwable {
	        int size=Shoorseriesdetailpage.castdetailsheadingsm().size();
	        for(int i=0;i<size;i++)
	        {
	        	   assertTrue(Shoorseriesdetailpage.castdetailsheadingsm().get(i).isDisplayed());
		    	   String heading=Shoorseriesdetailpage.castdetailsheadingsm().get(i).getText();
		    	   assertTrue(Shoorseriesdetailpage.castdetailsheadcontentm().get(i).isDisplayed());
		    	   String text=Shoorseriesdetailpage.castdetailsheadcontentm().get(i).getText();
		    	   log.info(heading + " is :"  + text);
	        }
	        assertEquals(Shoorseriesdetailpage.castdetailsheadingsm().get(0).getText(),"Directed By");
	        assertEquals(Shoorseriesdetailpage.castdetailsheadingsm().get(1).getText(),"Produced By");
	        assertEquals(Shoorseriesdetailpage.castdetailsheadingsm().get(2).getText(),"Writing Credits");
	        assertEquals(Shoorseriesdetailpage.castdetailsheadingsm().get(3).getText(),"Music by");
	        assertEquals(Shoorseriesdetailpage.castdetailsheadingsm().get(4).getText(),"Cinematography By");
	        assertEquals(Shoorseriesdetailpage.castdetailsheadingsm().get(5).getText(),"Edited By");
	    }
	    @Then("^The crew details heading and the crew details$")
	    public void the_crew_details_heading_and_the_crew_details() throws Throwable {
	        int size=Shoorseriesdetailpage.crewdetailsm().size();
	        for(int i=0;i<size;i++)
	        {
	        	   assertTrue(Shoorseriesdetailpage.crewdetailsm().get(i).isDisplayed());
		    	   String heading=Shoorseriesdetailpage.crewdetailsm().get(i).getText();
		    	   String content=Shoorseriesdetailpage.crewdetailsm().get(i).getText();
		    	   log.info(heading+" is :" + content);
	        }
	    }
	    @And("^Click on next song and verify its switched right song$")
	    public void click_on_next_song_and_verify_its_switched_right_song() throws Throwable {
	    	videoandaudioPlayer.nexticononplayerm().click();
	    	String Actual=videoandaudioPlayer.audionameonplayerm().getText();
	    	log.info(Actual);
	    	String str=Shoorseriesdetailpage.audionamesinshodetailpagem().get(1).getText();
	    	log.info(str);
	    	assertTrue(Actual.equalsIgnoreCase(str));
	    }

	    @And("^click on previous song and verify its switched previous song$")
	    public void click_on_previous_song_and_verify_its_switched_previous_song() throws Throwable {
	    	videoandaudioPlayer.previousicononplayerm().click();
	    	String Actual=videoandaudioPlayer.audionameonplayerm().getText();
	    	log.info(Actual);
	    	String str=Shoorseriesdetailpage.audionamesinshodetailpagem().get(0).getText();
	    	log.info(str);
	    	assertTrue(Actual.equalsIgnoreCase(str));
	    }
	    @Then("^check copylink button is visble and share with copylink share$")
	    public void check_copylink_button_is_visble_and_share_with_copylink_share() throws Throwable {
	    	Shareandfollow.copylinksharem();
	        /*String Actual=Toastanderrormessages.toastmessagem().getText();
	        log.info("Toastmessage shown :" + Actual);
	        assertEquals(Actual,"Link Copied!");*/
	    }
	    @Then("^Share (.+) via facebook$")
	    public void share_via_facebook(String promoname) throws Throwable {
	        Shoorseriesdetailpage.promoorepisodenamesonshare(promoname);
	        Shareandfollow.promofacebooksharem();
	        Shareandfollow.facebookwindowhandle();
	        Shareandfollow.closesharepopupm();
	        
	    }
	    @Then("^Share (.+) via twitter$")
	    public void share_via_twitter(String promoname) throws Throwable {
	    	    Shoorseriesdetailpage.promoorepisodenamesonshare(promoname);
	    	    Shareandfollow.promotwittersharem();
	    	    Shareandfollow.twitterwindowhandle();
	    	    Shareandfollow.closesharepopupm();
	    }

	    @Then("^Share (.+) via whatsapp$")
	    public void share_via_whatsapp(String promoname) throws Throwable {
	    	Shoorseriesdetailpage.promoorepisodenamesonshare(promoname);
	    	Shareandfollow.promowhatsappsharem();
	    	Shareandfollow.whatsappswindowhandle();
	    	Shareandfollow.closesharepopupm(); 
	    }
	    @Then("^Share (.+) via copy link$")
	    public void share_via_copy_link(String promoname) throws Throwable {
	    	Shoorseriesdetailpage.promoorepisodenamesonshare(promoname);
	    	Shareandfollow.promocopylinksharem();
	        String Actual=Toastanderrormessages.toastmessagem().getText();
	        log.info("Toastmessage shown :" + Actual);
	        assertEquals(Actual,"Link Copied!");
	        Shareandfollow.closesharepopupm();
	    }
	    @Then("^Check the back button and series link is working as expected in episode detail page$")
	    public void check_the_back_button_and_series_link_is_working_as_expected_in_episode_detail_page() throws Throwable {
	    	Shoorseriesdetailpage.episodespagelinkm().click();
	    	log.info("Clicked on Episodes link and redirected to episode page");
	        Shoorseriesdetailpage.backiconfromepisodepagem().click();
	        log.info("Clicked on back arrow button");
	        assertTrue(Shoorseriesdetailpage.studionameonshodetailpagem().isDisplayed());
	        log.info("Displayed the studio name");
	        Shoorseriesdetailpage.episodespagelinkm().click();
	        log.info("Clicked on Episodes link and redirected to episode page");
	        Shoorseriesdetailpage.seriesnameinepisodepagem().click();
	        log.info("Clicked on series name link");
	        assertTrue(Shoorseriesdetailpage.studionameonshodetailpagem().isDisplayed());
	        log.info("Displayed the studio name");
	    }
	    @Then("^check season dropdown and episodes are displaying and verify the episode count is showing correctly$")
	    public void check_season_dropdown_and_episodes_are_displaying_and_verify_the_episode_count_is_showing_correctly() throws Throwable {
	    	try {
            wait.until(ExpectedConditions.visibilityOf(Shoorseriesdetailpage.episodespagelinkm()));
	    	assertTrue(Shoorseriesdetailpage.episodespagelinkm().isDisplayed());
	    	assertTrue(Shoorseriesdetailpage.seasondropdownboxm().isDisplayed());
	    	Shoorseriesdetailpage.seasondropdownboxm().click();
	    	Thread.sleep(1000);
	      for(int i=0;i<Shoorseriesdetailpage.seasonsindropdownm().size();i++)
	      {
	      String seasonname=Shoorseriesdetailpage.seasonsindropdownm().get(i).getText();
	      log.info("Season name in season dropdown:" + seasonname);
	      Shoorseriesdetailpage.seasonsindropdownm().get(i).click();
	      Thread.sleep(2000);
	      int b=Shoorseriesdetailpage.episodescardsm().size();
	      String episodecardcount=Integer.toString(b);
	      log.info("Episode cards count:" + episodecardcount);
	      String episodetitle=Shoorseriesdetailpage.episodespagelinkm().getText();
	      log.info("Full Episode title:" + episodetitle);
	      String str=Shoorseriesdetailpage.episodecountm().getText();
	      log.info(str);
	      assertEquals("("+episodecardcount+")",str);
	      Shoorseriesdetailpage.seasondropdownboxm().click();
	      
	      }
	    	}catch(Exception e)
	    	{
	    		log.info("No Episodes found");
	    	}
	    }
	    @Then("^Season dropdown is displaying and corresponsing episodes$")
	    public void season_dropdown_is_displaying_and_corresponsing_episodes() throws Throwable {
	    	Shoorseriesdetailpage.episodespagelinkm().click();
	    	wait.until(ExpectedConditions.visibilityOf(Shoorseriesdetailpage.dropdownboxinsideepisodespagem()));
	       assertTrue(Shoorseriesdetailpage.dropdownboxinsideepisodespagem().isDisplayed());
	       log.info("Season dropdwon is displayed");
	       Shoorseriesdetailpage.seasondropdowninepisodeagem().click();
	       Thread.sleep(1000);
	       for(int i=0;i<Shoorseriesdetailpage.seasonsindropdownm().size();i++)
		      {
		      String seasonname=Shoorseriesdetailpage.seasonsindropdownm().get(i).getText();
		      log.info("Season name in season dropdown:" + seasonname);
		      Shoorseriesdetailpage.seasonsindropdownm().get(i).click();
		      Thread.sleep(1000);
		      int b=Shoorseriesdetailpage.episodesnamesinepisodespagem().size();
		      String episodecardcount=Integer.toString(b);
		      for(int j=0;j<b;j++)
		      {
		    	  String episodename=Shoorseriesdetailpage.episodesnamesinepisodespagem().get(j).getText();
			      log.info("Episode name in"+ seasonname + episodename);
		      }
		      log.info("Episode cards count:" + episodecardcount);
		      Shoorseriesdetailpage.seasondropdowninepisodeagem().click();
		      
		      }
	    }
	    @Then("^verify same episodes names is displaying in episode page and shodetail page with (.+)$")
	    public void verify_same_episodes_names_is_displaying_in_episode_page_and_shodetail_page_with(String seasonname) throws Throwable {
	    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    	js.executeScript("arguments[0].scrollIntoView();",Shoorseriesdetailpage.playallbuttonm());
	    	Thread.sleep(1000);
	    	Shoorseriesdetailpage.seasondropdownboxm().click();
	    	Thread.sleep(1000);
	      for(int i=0;i<Shoorseriesdetailpage.seasonsindropdownm().size();i++)
	      {
	    	  if(Shoorseriesdetailpage.seasonsindropdownm().get(i).getText().equalsIgnoreCase(seasonname))
	    	  {
	    		  Shoorseriesdetailpage.seasonsindropdownm().get(i).click();
	    		  a.moveToElement(Shoorseriesdetailpage.episodespagelinkm()).build().perform();
	    		  if(Shoorseriesdetailpage.nextarrowm().getAttribute("aria-disabled").equalsIgnoreCase("false"))
	    		  {
	    		  Shoorseriesdetailpage.nextarrowm().click();
	    		  }
	    		  for(int j=0;j<Shoorseriesdetailpage.episodenameinshodetailpagem().size();j++)
	    		  {
	    			  String epiosdenameinshodetalpage=Shoorseriesdetailpage.episodenameinshodetailpagem().get(j).getText();
	    			  log.info(epiosdenameinshodetalpage);
	    		      Shoorseriesdetailpage.episodespagelinkm().click();
	    		      Shoorseriesdetailpage.seasondropdowninepisodeagem().click();
	    		      Shoorseriesdetailpage.seasonsindropdownm().get(i).click();
	    			  String episodenameinepisodepage=Shoorseriesdetailpage.episodesnamesinepisodespagem().get(j).getText();
	    			  log.info(episodenameinepisodepage);
	    			  assertEquals(epiosdenameinshodetalpage,j+1+". "+episodenameinepisodepage);
	    			  Shoorseriesdetailpage.backiconfromepisodepagem().click();
	    				wait.until(ExpectedConditions.visibilityOf(Shoorseriesdetailpage.seasondropdownboxm()));
	    			  if(j>=5)
	    			  {
	    			  a.moveToElement(Shoorseriesdetailpage.episodespagelinkm()).build().perform();
		    		  Shoorseriesdetailpage.nextarrowm().click();
		    		  Thread.sleep(1000);
	    			  }
		    		  
	    		  }   
	    		  break;
	    	  }
	      }
	    }
	    
	    @Then("^should display description and time and (.+)$")
	    public void should_display_description_and_time_and(String maturityrating) throws Throwable {
	    	Shoorseriesdetailpage.episodespagelinkm().click();
	    	Thread.sleep(1500);
	    	for(int i=0;i<Shoorseriesdetailpage.episodecardsinepisodepagem().size();i++)
	    	{
	    		log.info(Shoorseriesdetailpage.episodedescriptioninepisodepagem().get(i).getText());
	    		assertTrue(Shoorseriesdetailpage.episodedurationm().get(i).isDisplayed());
	    		log.info(Shoorseriesdetailpage.episodedurationm().get(i).getText());
	    		assertTrue(Shoorseriesdetailpage.maturityratinginepisodepagem().get(i).isDisplayed());
	    		log.info(Shoorseriesdetailpage.maturityratinginepisodepagem().get(i).getText());
	    		assertEquals(Shoorseriesdetailpage.maturityratinginepisodepagem().get(i).getText(),maturityrating);
	    	}
	    }
	    @Then("^play any episode from (.+)$")
	    public void play_any_episode_from(String seasonname) throws Throwable {
	       wait.until(ExpectedConditions.visibilityOf(Shoorseriesdetailpage.seasondropdownboxm()));
	       Shoorseriesdetailpage.seasondropdownboxm().click();
	       wait.until(ExpectedConditions.visibilityOfAllElements(Shoorseriesdetailpage.seasonsindropdownm()));
	       for(int i=0;i<Shoorseriesdetailpage.seasonsindropdownm().size();i++)
		      {
		    	  if(Shoorseriesdetailpage.seasonsindropdownm().get(i).getText().equalsIgnoreCase(seasonname))
		    	  {
		    		 log.info("Season name selected:" + Shoorseriesdetailpage.seasonsindropdownm().get(i).getText());
		    		 Shoorseriesdetailpage.seasonsindropdownm().get(i).click();
		    		 Thread.sleep(1000);
		    		 for(int j=0;j<Shoorseriesdetailpage.episodescardsm().size();j++)
		    		 {
		    			 if(j>=5)
		    			 {
		    				  a.moveToElement(Shoorseriesdetailpage.episodespagelinkm()).build().perform();
				    		  Shoorseriesdetailpage.nextarrowm().click();
				    		  Thread.sleep(1000);  
				    		  break;
		    			 }
		    			 log.info("Cliked on episode name:" + Shoorseriesdetailpage.episodenameinshodetailpagem().get(j).getText());
		    			 a.moveToElement(Shoorseriesdetailpage.episodescardsm().get(j)).click().build().perform();
		    			 Thread.sleep(2000);
		    			 assertTrue(Paymentpage.paymentsectionm().isDisplayed());
		    			 Paymentpage.backiconm().click();
		    			 Thread.sleep(1000);
		    			 break;
		    		 }
		    		 break;
		    	  }
	        }
	    }  
	    @Then("^From episode page play any episode from (.+)$")
	    public void from_episode_page_play_any_episode_from(String seasonname) throws Throwable {
	    	Shoorseriesdetailpage.episodespagelinkm().click();
	    	Shoorseriesdetailpage.seasondropdowninepisodeagem().click();
	    	for(int i=0;i<Shoorseriesdetailpage.seasonsindropdownm().size();i++)
	    	{
	    		if(Shoorseriesdetailpage.seasonsindropdownm().get(i).getText().equalsIgnoreCase(seasonname))
		    	  {
		    		 log.info("Season name selected:" + Shoorseriesdetailpage.seasonsindropdownm().get(i).getText());
		    		 Shoorseriesdetailpage.seasonsindropdownm().get(i).click();
		    		 Thread.sleep(1000);
		    		 for(int j=0;j<Shoorseriesdetailpage.episodesnamesinepisodespagem().size();j++)
		    		 {
		    			 log.info("episode name in eposodes page:" + Shoorseriesdetailpage.episodesnamesinepisodespagem().get(j).getText());
		    			 Shoorseriesdetailpage.episodesnamesinepisodespagem().get(j).click();
		    			 Thread.sleep(500);

		    			 assertTrue(Paymentpage.paymentsectionm().isDisplayed());
		    			 Paymentpage.backiconm().click();
		    			 Shoorseriesdetailpage.episodespagelinkm().click();
		    			 Thread.sleep(1000);
		    		 }
		    		 break;
		    	  }	 
	    	}
	    }
	    
	    @Then("^Play any episode from (.+) in shodetailpage which already bought$")
	    public void play_any_episode_from_in_shodetailpage_which_already_bought(String seasonname) throws Throwable {
	    	Thread.sleep(1000);
	        Shoorseriesdetailpage.seasondropdownboxm().click();
	        Thread.sleep(500);
	        for(int i=0;i<Shoorseriesdetailpage.seasonsindropdownm().size();i++)
	    	{
	    		if(Shoorseriesdetailpage.seasonsindropdownm().get(i).getText().equalsIgnoreCase(seasonname))
		    	  {
	    			Shoorseriesdetailpage.seasonsindropdownm().get(i).click();
	    			String seasonnameinshodetailpage=Shoorseriesdetailpage.seasonsindropdownm().get(i).getText();
	    			log.info(seasonnameinshodetailpage);
	    			Thread.sleep(500);
	    			String str=Shoorseriesdetailpage.episodenameinshodetailpagem().get(i).getText();
	    			Shoorseriesdetailpage.mousehoveronepisodecardsm().get(i).click();
	    			String episodenameinshodetailpage=str.substring(2);
	    			log.info(episodenameinshodetailpage);
	    			Thread.sleep(3000);
	    			videoandaudioPlayer.mousehoveronplayerm();
	    			String seasonandepiosodenameonplayer=videoandaudioPlayer.promonameonplayerm().getText();
	    			log.info("On Player:" + seasonandepiosodenameonplayer);
	    			String finaltext=seasonnameinshodetailpage.concat(",").concat(episodenameinshodetailpage);
	    			log.info("On shodetail page:" + finaltext);
	    			assertEquals(finaltext,seasonandepiosodenameonplayer);
	    			videoandaudioPlayer.closeplayerm();
		    	  }
	    		break;
	    	}	
	    }
	    
	    @Then("^Play episode from (.+) in episode detailpage which already bought$")
	    public void play_episode_from_in_episode_detailpage_which_already_bought(String seasonname) throws Throwable {
	    	Thread.sleep(1000);
	        Shoorseriesdetailpage.episodespagelinkm().click();
	        Shoorseriesdetailpage.seasondropdowninepisodeagem().click();
	        for(int i=0;i<Shoorseriesdetailpage.seasonsindropdownm().size();i++)
	        {
	        	Shoorseriesdetailpage.seasonsindropdownm().get(i).click();
    			String seasonnameinshodetailpage=Shoorseriesdetailpage.seasonsindropdownm().get(i).getText();
    			log.info(seasonnameinshodetailpage);
    			Thread.sleep(500);
    			String episodenameinshodetailpage=Shoorseriesdetailpage.episodesnamesinepisodespagem().get(i).getText();
    			log.info(episodenameinshodetailpage);
    			Shoorseriesdetailpage.episodesnamesinepisodespagem().get(i).click();
    			Thread.sleep(3000);
    			videoandaudioPlayer.mousehoveronplayerm();
    			String seasonandepiosodenameonplayer=videoandaudioPlayer.promonameonplayerm().getText();
    			log.info("On Player:" + seasonandepiosodenameonplayer);
    			String finaltext=seasonnameinshodetailpage.concat(", ").concat(episodenameinshodetailpage);
    			log.info("On shodetail page:" + finaltext);
    			assertEquals(finaltext,seasonandepiosodenameonplayer);
    			videoandaudioPlayer.closeplayerm();
	        }
	    }
	    
	    @Then("^Buy or play the sho or series with (.+) and check the (.+) is playing$")
	    public void buy_or_play_the_sho_or_series_with_and_check_the_is_playing(String paymentmethod, String shoseriesorstudioname) throws Throwable {
	    	Shoorseriesdetailpage.playorbuybuttonm().click();
	    	Thread.sleep(500);
	        try {
	    		for(int i=0;i<Paymentpage.paymentsmethodsm().size();i++)
	    		{
	    			if(Paymentpage.paymentsmethodsm().get(i).getText().equalsIgnoreCase(paymentmethod))
	    			{
	    				Paymentpage.paymentsmethodsm().get(i).click();
	    				break;
	    			}
	    		}
	    		   Paymentpage.carddetails();
	    		   Thread.sleep(1000);
		    	   Paymentpage.paybuttonm();
		    	   Thread.sleep(1000);
		    	   Paymentpage.successwindowhandle();
		    	   Thread.sleep(500);
		    	   Paymentpage.playbuttonafterbuym().click();
		    	   Thread.sleep(3000);
		    	   videoandaudioPlayer.mousehoveronplayerm();
		    	   Thread.sleep(1000);
		    	   String str=videoandaudioPlayer.shoseriesnameonplayerm().getText();
		    	   log.info(str);
		    	   assertEquals(str,shoseriesorstudioname);
		    	   videoandaudioPlayer.closeplayerm().click();
	    	   
	        }
	        catch(Exception e)
	        {
	        	log.info("Already bought video is playing");
	        	videoandaudioPlayer.mousehoveronplayerm();
	        	videoandaudioPlayer.closeplayerm().click();
	        }
	          
	    }
	    
	    @And("^Share audio with facebook$")
	    public void share_audio_with_facebook() throws Throwable {
	    	Shareandfollow.audiosharem();
	    	Shareandfollow.promofacebooksharem();
	    	Shareandfollow.facebookwindowhandle();
	    }
	    @And("^Share audio with twitter$")
	    public void share_audio_with_twitter() throws Throwable {

	    	Shareandfollow.promotwittersharem();
	    	Shareandfollow.twitterwindowhandle();
	    }
	    @And("^Share audio with watsapp$")
	    public void share_audio_with_watsapp() throws Throwable {
	    	
	    	Shareandfollow.promowhatsappsharem();
	    	Shareandfollow.whatsappswindowhandle();
	    }
	    @And("^Share audio with copylink$")
	    public void share_audio_with_copylink() throws Throwable {
	    	
	    	Shareandfollow.promocopylinksharem();
	    	String Actual=Toastanderrormessages.toastmessagem().getText();
	        log.info("Toastmessage shown :" + Actual);
	        assertEquals(Actual,"Link Copied!");
	        Shareandfollow.closesharepopupm();
	    }
	    @Then("^Scrolldown the page for header share button$")
	    public void scrolldown_the_page_for_header_share_button() throws Throwable {
	        Studioprofile.scrolldownm();
	        assertTrue(Shoorseriesdetailpage.headersharem().isDisplayed());
	        Shoorseriesdetailpage.headersharem().click();
	        Shareandfollow.facebooksharem();
	        Shareandfollow.facebookwindowhandle();
	        Shareandfollow.twittersharem();
	        Shareandfollow.twitterwindowhandle();
	        Shareandfollow.whatsappsharem();
	        Shareandfollow.whatsappswindowhandle();
	        Shareandfollow.copylinksharem();
            Shareandfollow.closesharepopupm();
	        
	    }
	    
	    @Then("^Check all lined details headings are showing and correct$")
	    public void check_all_lined_details_headings_are_showing_and_correct() throws Throwable {
	      for(int i=0;i<Shoorseriesdetailpage.linedtitlesm().size();i++)
	    	{
	       assertTrue(Shoorseriesdetailpage.linedtitlesm().get(i).isDisplayed());
	       log.info(Shoorseriesdetailpage.linedtitlesm().get(i).getText());
	        }
	      assertEquals(Shoorseriesdetailpage.linedtitlesm().get(0).getText(),"Synopsis");
	      assertEquals(Shoorseriesdetailpage.linedtitlesm().get(1).getText(),"Specifics");
	      assertEquals(Shoorseriesdetailpage.linedtitlesm().get(2).getText(),"Cast details");
	      assertEquals(Shoorseriesdetailpage.linedtitlesm().get(3).getText(),"Crew details");
	    }
	    @Then("^Scroll down the page and play or buy (.+)  with (.+)$")
	    public void scroll_down_the_page_and_play_or_buy_with(String shoseriesorstudioname, String paymentmethod) throws Throwable {
	      	
	      Studioprofile.scrolldownm();
	      Shoorseriesdetailpage.playorbuybuttonsmallm().click();
	    	Thread.sleep(500);
	        try {
	    		for(int i=0;i<Paymentpage.paymentsmethodsm().size();i++)
	    		{
	    			if(Paymentpage.paymentsmethodsm().get(i).getText().equalsIgnoreCase(paymentmethod))
	    			{
	    				Paymentpage.paymentsmethodsm().get(i).click();
	    				break;
	    			}
	    		}
	    		   Paymentpage.carddetails();
		    	   Paymentpage.paybuttonm();
		    	   Thread.sleep(1000);
		    	   Paymentpage.successwindowhandle();
		    	   Thread.sleep(500);
		    	   Paymentpage.playbuttonafterbuym().click();
		    	   Thread.sleep(3000);
		    	   videoandaudioPlayer.mousehoveronplayerm();
		    	   String str=videoandaudioPlayer.shoseriesnameonplayerm().getText();
		    	   log.info(str);
		    	   assertEquals(str,shoseriesorstudioname);
		    	   videoandaudioPlayer.closeplayerm().click();
	    	   
	        }
	        catch(Exception e)
	        {
	        	log.info("Already bought video is playing");
	        	videoandaudioPlayer.mousehoveronplayerm();
	        	videoandaudioPlayer.closeplayerm().click();
	        }
	       
	    }
	    @Then("^Play promo and while switching promo check the details of mini title$")
	    public void play_promo_and_while_switching_promo_check_the_details_of_mini_title() throws Throwable {
	        String studionameonshodetailpage=Shoorseriesdetailpage.studionameonshodetailpagem().getText();
	        String Shoorseriesnameonshodetail=Shoorseriesdetailpage.shonameinshodetailspage().getText();
	        String shoorserieslabel=Shoorseriesdetailpage.shoorseriestagm().getText();
	        String generename=Shoorseriesdetailpage.defaultgenerenamem().getText();
	        String maturityrating=Shoorseriesdetailpage.maturityratingm().getText();
	        String language=Shoorseriesdetailpage.languagestagm().getText();
	        String screeneddate=Shoorseriesdetailpage.screeneddateforseries().getText();
	        String seasonscount=Shoorseriesdetailpage.seasonscountm().getText();
	        String description=Shoorseriesdetailpage.shoorseriesdescinsynposism().getText();
	        a.moveToElement(Shoorseriesdetailpage.promocardsm().get(0)).click().build().perform();
	        videoandaudioPlayer.mousehoveronplayerm();
	        videoandaudioPlayer.promoswitching1();
	        wait.until(ExpectedConditions.visibilityOf(videoandaudioPlayer.studionameonminititle()));
	        String studionameonminititle=videoandaudioPlayer.studionameonminititle().getText();
	        log.info(studionameonminititle);
	        assertEquals(studionameonminititle,studionameonshodetailpage);
	        String shoorseriesnameonminititle=videoandaudioPlayer.shoorseriesnameinminititle().getText();
	        log.info(shoorseriesnameonminititle);
	        assertEquals(Shoorseriesnameonshodetail,shoorseriesnameonminititle);
	        String shoorserieslabelonminititle=videoandaudioPlayer.labelsonminititle().get(0).getText();
	        log.info(shoorserieslabelonminititle);
	        assertEquals(shoorserieslabel,shoorserieslabelonminititle);
	        	String seasonscountonminitile=videoandaudioPlayer.labelsonminititle().get(1).getText();
	        	log.info(seasonscountonminitile);
	        	assertEquals(seasonscount,seasonscountonminitile);
	        	String genernameonminititle=videoandaudioPlayer.labelsonminititle().get(2).getText();
	        	log.info(genernameonminititle);
		        assertEquals(genernameonminititle,generename);
	        	String maturityratingonminititle=videoandaudioPlayer.labelsonminititle().get(3).getText();
	        	log.info(maturityratingonminititle);
		        assertEquals(maturityratingonminititle,maturityrating);
		        String languageonminititle=videoandaudioPlayer.labelsonminititle().get(4).getText();
		        log.info(languageonminititle);
		        assertEquals(languageonminititle,language);
		        String screenddateonminititle=videoandaudioPlayer.labelsonminititle().get(5).getText();
		        log.info(screenddateonminititle);
		        assertEquals(screeneddate,screenddateonminititle);
		        String descriptioninminititle=videoandaudioPlayer.descrtioninminititle().getText();
		        assertTrue(descriptioninminititle.equalsIgnoreCase(description));
		        videoandaudioPlayer.watchlistbuttononminititle().click();
		        assertEquals(Toastanderrormessages.toastmessagem().getText(),shoorseriesnameonminititle+" has been added to watchlist");
	        	
	        	Toastanderrormessages.toastmessageclosem().click();
	        	videoandaudioPlayer.watchlistbuttononminititle().click();
	        	assertEquals(Toastanderrormessages.toastmessagem().getText(),shoorseriesnameonminititle+" has been removed from watchlist");
	        	
	        	Toastanderrormessages.toastmessageclosem().click();
	        	videoandaudioPlayer.buyorplaybuttononminititle().click();
	        	try {
	        		videoandaudioPlayer.mousehoveronplayerm();
	        		assertEquals(videoandaudioPlayer.shoseriesnameonplayerm().getText(),shoorseriesnameonminititle);
	        		videoandaudioPlayer.closeplayerm().click();
	        	}catch(Exception e)
	        	{
	        		Paymentpage.carddetails();
	        		Paymentpage.paybuttonm();
	        		Thread.sleep(1000);
	        		Paymentpage.successwindowhandle();
	        		wait.until(ExpectedConditions.visibilityOf(Paymentpage.playbuttonafterbuym()));
	        		Paymentpage.playbuttonafterbuym().click();
	        		Thread.sleep(3000);
	        		videoandaudioPlayer.mousehoveronplayerm();
	        		log.info(videoandaudioPlayer.shoseriesnameonplayerm().getText());
	        		assertEquals(videoandaudioPlayer.shoseriesnameonplayerm().getText(),shoorseriesnameonminititle);
	        		videoandaudioPlayer.closeplayerm().click();
	        	} 
	    }
	    @Then("^Buy the sho or series from minititle and verify the details$")
	    public void buy_the_sho_or_series_from_minititle_and_verify_the_details() throws Throwable {
	    	String studionameonshodetailpage=Shoorseriesdetailpage.studionameonshodetailpagem().getText();
	        String Shoorseriesnameonshodetail=Shoorseriesdetailpage.shonameinshodetailspage().getText();
	        String shoorserieslabel=Shoorseriesdetailpage.shoorseriestagm().getText();
	        String generename=Shoorseriesdetailpage.defaultgenerforsho().getText();
	        String maturityrating=Shoorseriesdetailpage.maturitytagforsho().getText();
	        String language=Shoorseriesdetailpage.languagetagforsho().getText();
	        String screeneddate=Shoorseriesdetailpage.screeneddate().getText();
	        String description=Shoorseriesdetailpage.shoorseriesdescinsynposism().getText();
	        a.moveToElement(Shoorseriesdetailpage.promocardsm().get(2)).click().build().perform();
	        videoandaudioPlayer.mousehoveronplayerm();
	        videoandaudioPlayer.promoswitching1();
	        wait.until(ExpectedConditions.visibilityOf(videoandaudioPlayer.studionameonminititle()));
	        String studionameonminititle=videoandaudioPlayer.studionameonminititle().getText();
	        log.info(studionameonminititle);
	        assertEquals(studionameonminititle,studionameonshodetailpage);
	        String shoorseriesnameonminititle=videoandaudioPlayer.shoorseriesnameinminititle().getText();
	        log.info(shoorseriesnameonminititle);
	        assertEquals(Shoorseriesnameonshodetail,shoorseriesnameonminititle);
	        String shoorserieslabelonminititle=videoandaudioPlayer.labelsonminititle().get(0).getText();
	        log.info(shoorserieslabelonminititle);
	        assertEquals(shoorserieslabel,shoorserieslabelonminititle);
	        	
	        	String genernameonminititle=videoandaudioPlayer.labelsonminititle().get(1).getText();
	        	log.info(genernameonminititle);
		        assertEquals(genernameonminititle,generename);
	        	String maturityratingonminititle=videoandaudioPlayer.labelsonminititle().get(2).getText();
	        	log.info(maturityratingonminititle);
		        assertEquals(maturityratingonminititle,maturityrating);
		        String languageonminititle=videoandaudioPlayer.labelsonminititle().get(3).getText();
		        log.info(languageonminititle);
		        assertEquals(languageonminititle,language);
		        String screeneddateonminititle=videoandaudioPlayer.labelsonminititle().get(4).getText();
		        log.info(screeneddateonminititle);
		        assertEquals(screeneddateonminititle,screeneddate);
		        String descriptioninminititle=videoandaudioPlayer.descrtioninminititle().getText();
		        assertTrue(descriptioninminititle.equalsIgnoreCase(description));
		        videoandaudioPlayer.watchlistbuttononminititle().click();
		        assertEquals(Toastanderrormessages.toastmessagem().getText(),shoorseriesnameonminititle+" has been added to watchlist");
	        	Toastanderrormessages.toastmessageclosem().click();
	        	videoandaudioPlayer.watchlistbuttononminititle().click();
	        	assertEquals(Toastanderrormessages.toastmessagem().getText(),shoorseriesnameonminititle+" has been removed from watchlist");
	        	Toastanderrormessages.toastmessageclosem().click();
	        	videoandaudioPlayer.buyorplaybuttononminititle().click();
	        	try {
	        		//Thread.sleep(3000);
	        		Thread.sleep(3000);
	        		videoandaudioPlayer.mousehoveronplayerm();
	        		assertEquals(videoandaudioPlayer.shoseriesnameonplayerm().getText(),shoorseriesnameonminititle);
	        		videoandaudioPlayer.closeplayerm().click();
	        	}catch(Exception e)
	        	{
	        		Paymentpage.carddetails();
	        		Paymentpage.paybuttonm();
	        		Thread.sleep(1000);
	        		Paymentpage.successwindowhandle();
	        		wait.until(ExpectedConditions.visibilityOf(Paymentpage.playbuttonafterbuym()));
	        		Paymentpage.playbuttonafterbuym().click();
	        		Thread.sleep(3000);
	        		videoandaudioPlayer.mousehoveronplayerm();
	        		log.info(videoandaudioPlayer.shoseriesnameonplayerm().getText());
	        		assertEquals(videoandaudioPlayer.shoseriesnameonplayerm().getText(),shoorseriesnameonminititle);
	        		videoandaudioPlayer.closeplayerm().click();
	        	} 
	    }
	    @Then("^Play promo and while switching promo check the details of mini title after all promos play$")
	    public void play_promo_and_while_switching_promo_check_the_details_of_mini_title_after_all_promos_play() throws Throwable {
	    	wait.until(ExpectedConditions.visibilityOf(Shoorseriesdetailpage.promosheadingm()));
	    	String studionameonshodetailpage=Shoorseriesdetailpage.studionameonshodetailpagem().getText();
	        String Shoorseriesnameonshodetail=Shoorseriesdetailpage.shonameinshodetailspage().getText();
	        String shoorserieslabel=Shoorseriesdetailpage.shoorseriestagm().getText();
	        String generename=Shoorseriesdetailpage.defaultgenerforsho().getText();
	        String maturityrating=Shoorseriesdetailpage.maturitytagforsho().getText();
	        String language=Shoorseriesdetailpage.languagetagforsho().getText();
	        String screeneddate=Shoorseriesdetailpage.screeneddateforseries().getText();
	        String description=Shoorseriesdetailpage.shoorseriesdescinsynposism().getText();
	        a.moveToElement(Shoorseriesdetailpage.promocardsm().get(0)).click().build().perform();
	        videoandaudioPlayer.mousehoveronplayerm();
	        wait.until(ExpectedConditions.visibilityOf(videoandaudioPlayer.getDuration()));
	        Thread.sleep(1000);
	        videoandaudioPlayer.promoswitching1();
	        wait.until(ExpectedConditions.visibilityOf(videoandaudioPlayer.nextpromobutton()));
	        String str3="Next promo";
	        while(str3.equalsIgnoreCase("Next promo"))
	        {
	        	videoandaudioPlayer.nextpromobutton().click();
	        	Thread.sleep(500);
	        	videoandaudioPlayer.mousehoveronplayerm();
	        	wait.until(ExpectedConditions.visibilityOf(videoandaudioPlayer.getDuration()));
	        	videoandaudioPlayer.promoswitching1();
	        	Thread.sleep(500);
	        	try {
	        	String text=videoandaudioPlayer.nextpromobutton().getText();
	        	//String str2=StringUtils.replace(text, "\n", " ");
	        	String str2=text.replaceAll("[\\n\\t ]", " ");
		    	str3=str2.substring(11);
		    	log.info(str3);
	        	}catch(Exception e)
	        	{
	        		break;
	        	}
	        }
	        wait.until(ExpectedConditions.visibilityOf(videoandaudioPlayer.studionameonminititle()));
	        String studionameonminititle=videoandaudioPlayer.studionameonminititle().getText();
	        log.info(studionameonminititle);
	        assertEquals(studionameonminititle,studionameonshodetailpage);
	        String shoorseriesnameonminititle=videoandaudioPlayer.shoorseriesnameinminititle().getText();
	        log.info(shoorseriesnameonminititle);
	        assertEquals(Shoorseriesnameonshodetail,shoorseriesnameonminititle);
	        String shoorserieslabelonminititle=videoandaudioPlayer.labelsonminititle().get(0).getText();
	        log.info(shoorserieslabelonminititle);
	        assertEquals(shoorserieslabel,shoorserieslabelonminititle);
	        	
	        	String genernameonminititle=videoandaudioPlayer.labelsonminititle().get(1).getText();
	        	log.info(genernameonminititle);
		        assertEquals(genernameonminititle,generename);
	        	String maturityratingonminititle=videoandaudioPlayer.labelsonminititle().get(2).getText();
	        	log.info(maturityratingonminititle);
		        assertEquals(maturityratingonminititle,maturityrating);
		        String languageonminititle=videoandaudioPlayer.labelsonminititle().get(3).getText();
		        log.info(languageonminititle);
		        assertEquals(languageonminititle,language);
		        String screenddateonminititle=videoandaudioPlayer.labelsonminititle().get(5).getText();
		        log.info(screenddateonminititle);
		        assertEquals(screeneddate,screenddateonminititle);
		        String descriptioninminititle=videoandaudioPlayer.descrtioninminititle().getText();
		        assertTrue(descriptioninminititle.equalsIgnoreCase(description));
		        videoandaudioPlayer.watchlistbuttononminititle().click();
		        assertEquals(Toastanderrormessages.toastmessagem().getText(),shoorseriesnameonminititle+" has been added to watchlist");
	        	Toastanderrormessages.toastmessageclosem().click();
	        	videoandaudioPlayer.watchlistbuttononminititle().click();
	        	assertEquals(Toastanderrormessages.toastmessagem().getText(),shoorseriesnameonminititle+" has been removed from watchlist");
	        	Toastanderrormessages.toastmessageclosem().click();
	        	videoandaudioPlayer.buyorplaybuttononminititle().click();
	        	try {
	        		Thread.sleep(3000);
	        		videoandaudioPlayer.mousehoveronplayerm();
	        		Thread.sleep(1000);
	        		JavascriptExecutor js=(JavascriptExecutor)driver;
	        		String text=(String)js.executeScript("return arguments[0].innerHTML;", videoandaudioPlayer.shoseriesnameonplayerm());
	        		log.info(text);
	        		assertEquals(text,shoorseriesnameonminititle);
	        		videoandaudioPlayer.closeplayerm().click();
	        	}catch(Exception e)
	        	{
	        		Paymentpage.carddetails();
	        		Paymentpage.paybuttonm();
	        		Thread.sleep(1000);
	        		Paymentpage.successwindowhandle();
	        		wait.until(ExpectedConditions.visibilityOf(Paymentpage.playbuttonafterbuym()));
	        		Paymentpage.playbuttonafterbuym().click();
	        		Thread.sleep(3000);
	        		videoandaudioPlayer.mousehoveronplayerm();
	        		log.info(videoandaudioPlayer.shoseriesnameonplayerm().getText());
	        		assertEquals(videoandaudioPlayer.shoseriesnameonplayerm().getText(),shoorseriesnameonminititle);
	        		videoandaudioPlayer.closeplayerm().click();
	        	}
	    }
	    @Then("^watch free sho or series$")
	    public void watch_free_sho_or_series() throws Throwable {
	    	String studionameonshodetailpage=Shoorseriesdetailpage.studionameonshodetailpagem().getText();
	        String Shoorseriesnameonshodetail=Shoorseriesdetailpage.shonameinshodetailspage().getText();
	        String shoorserieslabel=Shoorseriesdetailpage.shoorseriestagm().getText();
	        String generename=Shoorseriesdetailpage.defaultgenerforsho().getText();
	        String maturityrating=Shoorseriesdetailpage.maturitytagforsho().getText();
	        String language=Shoorseriesdetailpage.languagetagforsho().getText();
	        String screeneddate=Shoorseriesdetailpage.screeneddate().getText();
	        String description=Shoorseriesdetailpage.shoorseriesdescinsynposism().getText();
	        Thread.sleep(1000);
	        a.moveToElement(Shoorseriesdetailpage.promocardsm().get(1)).click().build().perform();
	        videoandaudioPlayer.mousehoveronplayerm();
	        videoandaudioPlayer.promoswitching1();
	        wait.until(ExpectedConditions.visibilityOf(videoandaudioPlayer.studionameonminititle()));
	        String studionameonminititle=videoandaudioPlayer.studionameonminititle().getText();
	        log.info(studionameonminititle);
	        assertEquals(studionameonminititle,studionameonshodetailpage);
	        String shoorseriesnameonminititle=videoandaudioPlayer.shoorseriesnameinminititle().getText();
	        log.info(shoorseriesnameonminititle);
	        assertEquals(Shoorseriesnameonshodetail,shoorseriesnameonminititle);
	        String shoorserieslabelonminititle=videoandaudioPlayer.labelsonminititle().get(0).getText();
	        log.info(shoorserieslabelonminititle);
	        assertEquals(shoorserieslabel,shoorserieslabelonminititle);
	        	
	        	String genernameonminititle=videoandaudioPlayer.labelsonminititle().get(1).getText();
	        	log.info(genernameonminititle);
		        assertEquals(genernameonminititle,generename);
	        	String maturityratingonminititle=videoandaudioPlayer.labelsonminititle().get(2).getText();
	        	log.info(maturityratingonminititle);
		        assertEquals(maturityratingonminititle,maturityrating);
		        String languageonminititle=videoandaudioPlayer.labelsonminititle().get(3).getText();
		        log.info(languageonminititle);
		        assertEquals(languageonminititle,language);
		        String screeneddateonminititle=videoandaudioPlayer.labelsonminititle().get(4).getText();
		        log.info(screeneddateonminititle);
		        assertEquals(screeneddateonminititle,screeneddate);
		        String descriptioninminititle=videoandaudioPlayer.descrtioninminititle().getText();
		        assertTrue(descriptioninminititle.equalsIgnoreCase(description));
		        videoandaudioPlayer.watchlistbuttononminititle().click();
		        assertEquals(Toastanderrormessages.toastmessagem().getText(),shoorseriesnameonminititle+" has been added to watchlist");
	        	Toastanderrormessages.toastmessageclosem().click();
	        	videoandaudioPlayer.watchlistbuttononminititle().click();
	        	assertEquals(Toastanderrormessages.toastmessagem().getText(),shoorseriesnameonminititle+" has been removed from watchlist");
	        	Toastanderrormessages.toastmessageclosem().click();
	        	videoandaudioPlayer.buyorplaybuttononminititle().click();
	        	Thread.sleep(3000);
        		videoandaudioPlayer.mousehoveronplayerm();
        		assertEquals(videoandaudioPlayer.shoseriesnameonplayerm().getText(),shoorseriesnameonminititle);
        		videoandaudioPlayer.closeplayerm().click();
	    }
	    @Then("^The text should show coming soon$")
	    public void the_text_should_show_coming_soon() throws Throwable {
	    	String studionameonshodetailpage=Shoorseriesdetailpage.studionameonshodetailpagem().getText();
	        String Shoorseriesnameonshodetail=Shoorseriesdetailpage.shonameinshodetailspage().getText();
	        String shoorserieslabel=Shoorseriesdetailpage.shoorseriestagm().getText();
	        String generename=Shoorseriesdetailpage.defaultgenerforsho().getText();
	        String maturityrating=Shoorseriesdetailpage.maturitytagforsho().getText();
	        String language=Shoorseriesdetailpage.languagetagforsho().getText();
	        String screeneddate=Shoorseriesdetailpage.screeneddate().getText();
	        String description=Shoorseriesdetailpage.shoorseriesdescinsynposism().getText();
	        a.moveToElement(Shoorseriesdetailpage.promocardsm().get(2)).click().build().perform();
	        videoandaudioPlayer.mousehoveronplayerm();
	        videoandaudioPlayer.promoswitching1();
	        Thread.sleep(1000);
	        String studionameonminititle=videoandaudioPlayer.studionameonminititle().getText();
	        log.info(studionameonminititle);
	        assertEquals(studionameonminititle,studionameonshodetailpage);
	        String shoorseriesnameonminititle=videoandaudioPlayer.shoorseriesnameinminititle().getText();
	        log.info(shoorseriesnameonminititle);
	        assertEquals(Shoorseriesnameonshodetail,shoorseriesnameonminititle);
	        String shoorserieslabelonminititle=videoandaudioPlayer.labelsonminititle().get(0).getText();
	        log.info(shoorserieslabelonminititle);
	        assertEquals(shoorserieslabel,shoorserieslabelonminititle);
	        	
	        	String genernameonminititle=videoandaudioPlayer.labelsonminititle().get(1).getText();
	        	log.info(genernameonminititle);
		        assertEquals(genernameonminititle,generename);
	        	String maturityratingonminititle=videoandaudioPlayer.labelsonminititle().get(2).getText();
	        	log.info(maturityratingonminititle);
		        assertEquals(maturityratingonminititle,maturityrating);
		        String languageonminititle=videoandaudioPlayer.labelsonminititle().get(3).getText();
		        log.info(languageonminititle);
		        assertEquals(languageonminititle,language);
		        String screeneddateonminititle=videoandaudioPlayer.labelsonminititle().get(4).getText();
		        log.info(screeneddateonminititle);
		        assertEquals(screeneddateonminititle,screeneddate);
		        String descriptioninminititle=videoandaudioPlayer.descrtioninminititle().getText();
		        assertTrue(descriptioninminititle.equalsIgnoreCase(description));
		        videoandaudioPlayer.watchlistbuttononminititle().click();
		        assertEquals(Toastanderrormessages.toastmessagem().getText(),shoorseriesnameonminititle+" has been added to watchlist");
	        	Toastanderrormessages.toastmessageclosem().click();
	        	videoandaudioPlayer.watchlistbuttononminititle().click();
	        	assertEquals(Toastanderrormessages.toastmessagem().getText(),shoorseriesnameonminititle+" has been removed from watchlist");
	        	Toastanderrormessages.toastmessageclosem().click();
	        	videoandaudioPlayer.buyorplaybuttononminititle().click();
	        	String str=videoandaudioPlayer.buyorplaybuttononminititle().getText();
	        	log.info(str);
	        	//String str1=StringUtils.replace(str,"\n", " ");
	        	String str1=str.replaceAll("[\\n\\t ]", " ");
	        	log.info(str1);
	        	String text=str1.substring(0,str1.lastIndexOf(" "));
	        	log.info(text);
	        	assertEquals(text,"Coming soon");
	        	videoandaudioPlayer.nextpromocancelbutton().click();
	        	videoandaudioPlayer.closeicon().click();
	        	
	    }
	    @Then("^Watch free sho or series from sho detail page$")
	    public void watch_free_sho_or_series_from_sho_detail_page() throws Throwable {
	    	String shoname=Shoorseriesdetailpage.shonameinshodetailspage().getText();
	    	assertEquals(Shoorseriesdetailpage.playorbuybuttonm().getText(),"Watch Free");
	        Shoorseriesdetailpage.playorbuybuttonm().click();
	        Thread.sleep(3000);
	        videoandaudioPlayer.mousehoveronplayerm();
	        Thread.sleep(1000);
	        assertEquals(shoname,videoandaudioPlayer.shoseriesnameonplayerm().getText());
	        videoandaudioPlayer.closeplayerm().click();
	        
	    }
	    @Then("^Scroll down and watch free the sho or series$")
	    public void scroll_down_and_watch_free_the_sho_or_series() throws Throwable {
	    	String shoname=Shoorseriesdetailpage.shonameinshodetailspage().getText();
	        Studioprofile.scrolldownm();
	        assertEquals(Shoorseriesdetailpage.playorbuybuttonsmallm().getText(),"Watch Free");
	        Shoorseriesdetailpage.playorbuybuttonsmallm().click();
	        Thread.sleep(3000);
	        videoandaudioPlayer.mousehoveronplayerm();
	        assertEquals(shoname,videoandaudioPlayer.shoseriesnameonplayerm().getText());
	        videoandaudioPlayer.closeplayerm().click();
	    }
	    @Then("^verify coming soon text$")
	    public void verify_coming_soon_text() throws Throwable {
	    	Shoorseriesdetailpage.playorbuybuttonm().click();
	        String str=Shoorseriesdetailpage.playorbuybuttonm().getText();
	        log.info(str);
        	//String str1=StringUtils.replace(str,"\n", " ");
	        String str1=str.replaceAll("[\\n\\t ]", " ");
        	log.info(str1);
        	String text=str1.substring(0,str1.lastIndexOf(" "));
        	log.info(text);
        	assertEquals(text,"Coming soon");
	    }
	    @Then("^Scroll down and coming soon the sho or series$")
	    public void scroll_down_and_coming_soon_the_sho_or_series() throws Throwable {
	    	Studioprofile.scrolldownm();
	    	Shoorseriesdetailpage.playorbuybuttonsmallm().click();
	    	String str=Shoorseriesdetailpage.playorbuybuttonsmallm().getText();
	    	log.info(str);
        	//String str1=StringUtils.replace(str,"\n", " ");
	    	String str1=str.replaceAll("[\\n\\t ]", " ");
        	log.info(str1);
        	String text=str1.substring(0,str1.lastIndexOf(" "));
        	log.info(text);
        	assertEquals(text,"Coming soon");
	    }
	    @Then("^Check the cancel button in minititle$")
	    public void check_the_cancel_button_in_minititle() throws Throwable {
	    	String studionameonshodetailpage=Shoorseriesdetailpage.studionameonshodetailpagem().getText();
	        String Shoorseriesnameonshodetail=Shoorseriesdetailpage.shonameinshodetailspage().getText();
	        String shoorserieslabel=Shoorseriesdetailpage.shoorseriestagm().getText();
	        String generename=Shoorseriesdetailpage.defaultgenerforsho().getText();
	        String maturityrating=Shoorseriesdetailpage.maturitytagforsho().getText();
	        String language=Shoorseriesdetailpage.languagetagforsho().getText();
	        String screeneddate=Shoorseriesdetailpage.screeneddateforseries().getText();
	        String description=Shoorseriesdetailpage.shoorseriesdescinsynposism().getText();
	        a.moveToElement(Shoorseriesdetailpage.promocardsm().get(0)).click().build().perform();
	        videoandaudioPlayer.mousehoveronplayerm();
	        videoandaudioPlayer.promoswitching1();
	        Thread.sleep(1000);
	        videoandaudioPlayer.nextpromocancelbutton().click();
	        try {
	        String text=videoandaudioPlayer.nextpromobutton().getText();
        	//String str2=StringUtils.replace(text, "\n", " ");
	        String str2=text.replaceAll("[\\n\\t ]", " ");
	    	String str3=str2.substring(11);
	        
	        while(str3.equalsIgnoreCase("Next promo"))
	        {
	        	videoandaudioPlayer.nextpromobutton().click();
	        	Thread.sleep(500);
	        	videoandaudioPlayer.mousehoveronplayerm();
	        	videoandaudioPlayer.promoswitching1();
	        	Thread.sleep(500);
	        }
	       }
	        catch(Exception e)
	        {
	        	log.info("No next promo button");
	        }
	        String studionameonminititle=videoandaudioPlayer.studionameonminititle().getText();
	        log.info(studionameonminititle);
	        assertEquals(studionameonminititle,studionameonshodetailpage);
	        String shoorseriesnameonminititle=videoandaudioPlayer.shoorseriesnameinminititle().getText();
	        log.info(shoorseriesnameonminititle);
	        assertEquals(Shoorseriesnameonshodetail,shoorseriesnameonminititle);
	        String shoorserieslabelonminititle=videoandaudioPlayer.labelsonminititle().get(0).getText();
	        log.info(shoorserieslabelonminititle);
	        assertEquals(shoorserieslabel,shoorserieslabelonminititle);
	        	
	        	String genernameonminititle=videoandaudioPlayer.labelsonminititle().get(1).getText();
	        	log.info(genernameonminititle);
		        assertEquals(genernameonminititle,generename);
	        	String maturityratingonminititle=videoandaudioPlayer.labelsonminititle().get(2).getText();
	        	log.info(maturityratingonminititle);
		        assertEquals(maturityratingonminititle,maturityrating);
		        String languageonminititle=videoandaudioPlayer.labelsonminititle().get(3).getText();
		        log.info(languageonminititle);
		        assertEquals(languageonminititle,language);
		        String screenddateonminititle=videoandaudioPlayer.labelsonminititle().get(5).getText();
		        log.info(screenddateonminititle);
		        assertEquals(screeneddate,screenddateonminititle);
		        String descriptioninminititle=videoandaudioPlayer.descrtioninminititle().getText();
		        assertTrue(descriptioninminititle.equalsIgnoreCase(description));
		        videoandaudioPlayer.watchlistbuttononminititle().click();
		        assertEquals(Toastanderrormessages.toastmessagem().getText(),shoorseriesnameonminititle+" has been added to watchlist");
	        	Toastanderrormessages.toastmessageclosem().click();
	        	videoandaudioPlayer.watchlistbuttononminititle().click();
	        	assertEquals(Toastanderrormessages.toastmessagem().getText(),shoorseriesnameonminititle+" has been removed from watchlist");
	        	Toastanderrormessages.toastmessageclosem().click();
	        	videoandaudioPlayer.buyorplaybuttononminititle().click();
	        	try {
	        		Thread.sleep(3000);
	        		videoandaudioPlayer.mousehoveronplayerm();
	        		assertEquals(videoandaudioPlayer.shoseriesnameonplayerm().getText(),shoorseriesnameonminititle);
	        		videoandaudioPlayer.closeplayerm().click();
	        	}catch(Exception e)
	        	{
	        		Paymentpage.carddetails();
	        		Paymentpage.paybuttonm();
	        		Thread.sleep(1000);
	        		Paymentpage.successwindowhandle();
	        		wait.until(ExpectedConditions.visibilityOf(Paymentpage.playbuttonafterbuym()));
	        		Paymentpage.playbuttonafterbuym().click();
	        		Thread.sleep(3000);
	        		
	        		videoandaudioPlayer.mousehoveronplayerm();
	        		log.info(videoandaudioPlayer.shoseriesnameonplayerm().getText());
	        		assertEquals(videoandaudioPlayer.shoseriesnameonplayerm().getText(),shoorseriesnameonminititle);
	        		videoandaudioPlayer.closeplayerm().click();
	        	}
	    
	    }
	    @Then("^Play the any episode from shodetail page for watch free content$")
	    public void play_the_any_episode_from_shodetail_page_for_watch_free_content() throws Throwable {
	        String seriesnameonshodetailpage=Shoorseriesdetailpage.shonameinshodetailspage().getText();
	        log.info(seriesnameonshodetailpage);
	        Shoorseriesdetailpage.episodescardsm().get(0).click();
	        Thread.sleep(1000);
	        videoandaudioPlayer.mousehoveronplayerm();
	        Thread.sleep(1000);
	        JavascriptExecutor js=(JavascriptExecutor)driver;
	        String text=(String)js.executeScript("return arguments[0].innerHTML;", videoandaudioPlayer.shoseriesnameonplayerm());
    		log.info(text);
	       // String seriesnameonplayer=videoandaudioPlayer.shoseriesnameonplayerm().getText();
	        //log.info(seriesnameonplayer);
	        assertEquals(seriesnameonshodetailpage,text);
	        
	        videoandaudioPlayer.closeplayerm().click();
	    }
	    @Then("^Play the any episode from episode page for watch free content$")
	    public void play_the_any_episode_from_episode_page_for_watch_free_content() throws Throwable {
	    	String seriesnameonshodetailpage=Shoorseriesdetailpage.shonameinshodetailspage().getText();
	        log.info(seriesnameonshodetailpage);
	        Shoorseriesdetailpage.episodespagelinkm().click();
	        Thread.sleep(1000);
	        Shoorseriesdetailpage.episodesnamesinepisodespagem().get(0).click();
	        videoandaudioPlayer.mousehoveronplayerm();
	        String seriesnameonplayer=videoandaudioPlayer.shoseriesnameonplayerm().getText();
	        log.info(seriesnameonplayer);
	        assertEquals(seriesnameonshodetailpage,seriesnameonplayer);
	        videoandaudioPlayer.closeplayerm().click();
	    }
	    @Then("^The feelers should be update when i am giving the (.+)$")
	    public void the_feelers_should_be_update_when_i_am_giving_the(String feeler) throws Throwable {
	    	String feelerepercentageshodetail=null;
	    	String feelertextonplayer = null;
	    	String feelerstextonshodetail = null;
	    	String feelerspercentageafterfeeler=null;
	        for(int i=0;i<Shoorseriesdetailpage.feelerssmilesinshodetailpagem().size();i++)
	        {
	        	if(Shoorseriesdetailpage.feelerssmilesinshodetailpagem().get(i).getText().equalsIgnoreCase(feeler))
	        	{
	        		feelerstextonshodetail=Shoorseriesdetailpage.feelerssmilesinshodetailpagem().get(i).getText();
	        		feelerepercentageshodetail=Shoorseriesdetailpage.feelerspercentagem().get(i).getText();
	        		break;
	        	}
	        }
	        Shoorseriesdetailpage.playorbuybuttonm().click();
	        try {
	        	Paymentpage.carddetails();
	        	Paymentpage.paybuttonm();
	        	Thread.sleep(1000);
	        	Paymentpage.successwindowhandle();
	        	Paymentpage.playbuttonafterbuym().click();
	        	videoandaudioPlayer.mousehoveronplayerm();
	        	Actions a=new Actions(driver);
	        	a.moveToElement(videoandaudioPlayer.addfeelresonplayer()).build().perform();
	        	for(int j=0;j<videoandaudioPlayer.feelerstext().size();j++)
	        	{
	        		if(videoandaudioPlayer.feelerstext().get(j).getText().equalsIgnoreCase(feeler))
	        		{
	        			feelertextonplayer=videoandaudioPlayer.feelerstext().get(j).getText();
	        			a.moveToElement(videoandaudioPlayer.feelerstext().get(j)).click().build().perform();
	        			
	        			
	        			break;
	        		}
	        	}
	        	videoandaudioPlayer.closeplayerm().click();
	        }
	        catch(Exception e)
	        {
	        	videoandaudioPlayer.mousehoveronplayerm();
	        	a.moveToElement(videoandaudioPlayer.addfeelresonplayer()).build().perform();
	        	for(int j=0;j<videoandaudioPlayer.feelerstext().size();j++)
	        	{
	        		if(videoandaudioPlayer.feelerstext().get(j).getText().equalsIgnoreCase(feeler))
	        		{
	        			feelertextonplayer=videoandaudioPlayer.feelerstext().get(j).getText();
	        			
	        			a.moveToElement(videoandaudioPlayer.feelerstext().get(j)).click().build().perform();
	        		}
	        	}
	        	videoandaudioPlayer.closeplayerm().click();
	        	
	        }

	        assertEquals(feelertextonplayer,feeler);
	        assertEquals(feelerstextonshodetail,feeler);
	        for(int k=0;k<Shoorseriesdetailpage.feelerssmilesinshodetailpagem().size();k++)
	        {
	        	if(Shoorseriesdetailpage.feelerssmilesinshodetailpagem().get(k).getText().equalsIgnoreCase(feeler))
	        	{
	        		feelerstextonshodetail=Shoorseriesdetailpage.feelerssmilesinshodetailpagem().get(k).getText();
	        		feelerspercentageafterfeeler=Shoorseriesdetailpage.feelerspercentagem().get(k).getText();
	        		break;
	        	}
	        }
	        log.info(feelerepercentageshodetail);
	        log.info(feelerspercentageafterfeeler);
	        assertNotEquals(feelerspercentageafterfeeler,feelerepercentageshodetail);
	    }



	    
}
