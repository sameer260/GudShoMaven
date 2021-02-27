package Steps.frontend;

import static org.junit.Assert.assertEquals;


import static org.junit.Assert.assertTrue;

import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.frontend.Shareandfollow;
import PageObjects.frontend.Shoorseriesdetailpage;
import PageObjects.frontend.Streaming;
import PageObjects.frontend.Studioprofile;
import PageObjects.frontend.Toastanderrormessages;
import PageObjects.frontend.socialpageandsearch;
import PageObjects.frontend.videoandaudioPlayer;
import Resources.Base_setup;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class Studioprofilesteps extends Base_setup
{
	public static Logger log=Logger.getLogger(Studioprofilesteps.class.getName());
	static WebDriverWait wait=new WebDriverWait(driver,10);
	
	
	
	@Given("^In search enter (.+) and select wanted (.+)$")
    public void in_search_enter_and_select_wanted(String keyword, String shoseriesorstudioname) throws Throwable 
	{
		
		socialpageandsearch.homepagesearch().sendKeys(keyword);
		Thread.sleep(500);
        socialpageandsearch.autosuggestivenamesm(shoseriesorstudioname);
        
         
    }
	@When("^It should redirect to the correct (.+) page$")
    public void it_should_redirect_to_the_correct_page(String shoseriesorstudioname) throws Throwable {
		Thread.sleep(1000);
		String Actual=Studioprofile.studionameonstudiopagem().getText();
		log.info("Actual Studio name on the studio detail page:" + Actual);
		log.info("Expected Studio name is:" + shoseriesorstudioname);
        assertEquals(Actual,shoseriesorstudioname);
    }
	@When("^Click on the studio info$")
    public void click_on_the_studio_info() throws Throwable {
		Studioprofile.studioinfom().click();
        log.info("Cliked on the Studi info icon");
    }
	
    @Then("^See studioinfo and click back$")
    public void see_studioinfo_and_click_back() throws Throwable {
    	Actions a=new Actions(driver);
        assertTrue(Studioprofile.studiodescriptionm().isDisplayed());
        log.info("Studio description is displayed is dipslayed");
        String description=Studioprofile.studiodescriptionm().getText();
        log.info(description);
        assertTrue(Studioprofile.studiodescrbackiconm().isDisplayed());
        a.moveToElement(Studioprofile.studiodescrbackiconm()).click().build().perform();
        log.info("Cliked on back button from studio info popup");
        assertTrue(Studioprofile.followerscountm().isDisplayed());
        log.info("Followers count is dipslayed");
    }

    @And("^verify all the studiodetails are showing in the page$")
    public void verify_all_the_studiodetails_are_showing_in_the_page() throws Throwable {
    	assertTrue(Studioprofile.profileimagem().isDisplayed());
    	 log.info("Profileimage is dipslayed");
    	assertTrue(Studioprofile.shocountm().isDisplayed());
    	 log.info("Shocount is dipslayed");
    	String shocount=Studioprofile.shocountm().getText();
    	log.info("Shocount is :" + shocount);
    	assertTrue(Studioprofile.seriescountm().isDisplayed());
    	 log.info("Series count is dipslayed");
    	String seriescount=Studioprofile.seriescountm().getText();
    	log.info("Seriescount is :" + seriescount);
    	assertTrue(Studioprofile.followerscountm().isDisplayed());
    	 log.info("Followers count is dipslayed");
    	String followerscount=Studioprofile.followerscountm().getText();
    	log.info("Followers count is :" + followerscount);
    	assertTrue(Studioprofile.studioinfom().isDisplayed());
    	 log.info("Studo info icon is dipslayed");
    }
    @When("^Mousehover on given (.+) and add to watchlist$")
    public void mousehover_on_given_and_add_to_watchlist(String shoorseriesname) throws Throwable {
    	Studioprofile.scrolldownm();
    	Thread.sleep(1000);
    	Studioprofile.addtowatchlist(shoorseriesname);
        log.info("The sho or series added to the watch list is :" + shoorseriesname);
    }
    @Then("^Mousehover on given (.+) and share$")
    public void mousehover_on_given_and_share(String shoorseriesname) throws Throwable {
    	Studioprofile.scrolldownm();
    	Thread.sleep(1000);
    	Studioprofile.shareshocard(shoorseriesname);
    	
    	Shareandfollow.facebooksharem();
    	Shareandfollow.facebookwindowhandle();
    	Shareandfollow.twittersharem();
    	Shareandfollow.twitterwindowhandle();
    	Shareandfollow.whatsappsharem();
    	Shareandfollow.whatsappwindowhandlforpromo();
    	Shareandfollow.promocopylinksharem();
    	Shareandfollow.closesharepopupm();
    	String Actual=Toastanderrormessages.toastmessagem().getText();
        log.info("Toastmessage shown :" + Actual);
        assertEquals(Actual,"Link Copied!");
    	
    }
    @Then("^Check all the sho and shoseries and promos and audiotracks$")
    public void check_all_the_sho_and_shoseries_and_promos_and_audiotracks() throws Throwable {
    	Studioprofile.onlyinallgenere();
      
    }
    @Then("^verify (.+) on the page with (.+)$")
    public void verify_on_the_page_with(String rowtitlename, String expectedrowtitlename) throws Throwable {
    	Studioprofile.rowtitlesm(rowtitlename);
       log.info("Actual Row title is :" + rowtitlename);
       assertEquals(expectedrowtitlename,Studioprofile.actualrowtitlename);
       log.info("Expected Row title name is: " + expectedrowtitlename);
    }
    @Then("^click on each genere and capture the all shoandseries in the genere$")
    public void click_on_each_genere_and_capture_the_all_shoandseries_in_the_genere() throws Throwable {
    	Studioprofile.shoorseriesnamesingeners();
    }
    @And("^click on (.+) and capture shoorseries name$")
    public void click_on_and_capture_shoorseries_name(String generename) throws Throwable {
    	Studioprofile.Shoorseriesinindividualgenere(generename);
    }

    @When("^Verify the click opertion is happening on right (.+)$")
    public void verify_the_click_opertion_is_happening_on_right(String generename) throws Throwable {
        assertEquals(generename,Studioprofile.actualgenerename); 
        log.info("Genere name is :" + generename);
    }
    @When("^verify (.+) is present in the particular genere$")
    public void verify_is_present_in_the_particular_genere(String shoorseries) throws Throwable {
    	Studioprofile.shoorseriesingenere(shoorseries);
        log.info("The sho or series name in the genere is:" + shoorseries);
        assertTrue(Studioprofile.actualshoorseriesname.equalsIgnoreCase(shoorseries));
    }

    @Then("^click on (.+) on other (.+) and verify the shotitle$")
    public void click_on_on_other_and_verify_the_shotitle(String shoorseries, String generename) throws Throwable {
    	Studioprofile.verifytheshoorseriesisclickble(shoorseries,generename);
	    assertTrue(Studioprofile.actualshoorseriesnameingenere.equalsIgnoreCase(Studioprofile.actualshonamenshodetailpage));
	    assertTrue(Studioprofile.actualshoorseriesnameingenere.equalsIgnoreCase(shoorseries));
    }
    @Then("^Click on view more from banner to see (.+)$")
    public void click_on_view_more_from_banner_to_see(String shoorseriesname) throws Throwable {
    	Studioprofile.viewmorefrombanner(shoorseriesname);
       
    }
    @And("^verify shoorseriesname with shoorseries detail page$")
    public void verify_shoorseriesname_with_shoorseries_detail_page() throws Throwable {
    	String str=Shoorseriesdetailpage.shonameinshodetailspage().getText();
		String expected = str.substring(0, str.lastIndexOf(""));
		log.info("Expeceted  sho or series name in sho detail page is:" + expected);
		assertTrue(Studioprofile.actual.equalsIgnoreCase(expected));
		driver.navigate().back();
    }
    @And("^Click on play trailer button from banner to see (.+)$")
    public void click_on_play_trailer_button_from_banner_to_see(String shoorseriesname) throws Throwable {
    	Studioprofile.playtrailerfrombanner(shoorseriesname);
    }
    @Then("^Verify the page title of the promo (.+)$")
    public void verify_the_page_title_of_the_promo(String shoorseriesname) throws Throwable {
    	try
    	{
    		String txt=Toastanderrormessages.alerdailogm().getText();
    		log.info("In banner if there is no promo of the sho or series the toast message displayed as :" + txt);
    		
    	}   
    	catch(Exception e){
    		videoandaudioPlayer.mousehoveronplayerm();
    		String Actual=videoandaudioPlayer.shoseriesnameonplayerm().getText();
    		log.info("Actual sho or series name on the player is :" + Actual);
    		assertTrue(Actual.equalsIgnoreCase(Studioprofile.actual));
    	    String promopagetitle = driver.getTitle();
    	    log.info("Titile of the page is:" + promopagetitle);
    	    log.info("The shoor series name is:" + shoorseriesname);
		    assertEquals(promopagetitle, "GudSho | Promo | " + shoorseriesname);
		    videoandaudioPlayer.closeplayerm().click();
			
		}
    	
    }
    @Then("^click on (.+) which want to play$")
    public void click_on_which_want_to_play(String promoname) throws Throwable {
    	Studioprofile.playpromom(promoname);
    }
    @And("^verify (.+) is matched with actual promoname from studio detail page$")
    public void verify_is_matched_with_actual_promoname_from_studio_detail_page(String promoname) throws Throwable {
        assertTrue(promoname.equalsIgnoreCase(videoandaudioPlayer.promonameonplayerm().getText()));
    }
    @Then("^Play the (.+) which you want to play$")
    public void play_the_which_you_want_to_play(String audioname) throws Throwable {
    	Studioprofile.playaudiom(audioname);
    }
    @And("^verify (.+) playing on player with studio detail page$")
    public void verify_playing_on_player_with_studio_detail_page(String audioname) throws Throwable {
        assertTrue(videoandaudioPlayer.audionameonplayerm().getText().equalsIgnoreCase(audioname));
    }
    @Then("^Share the promo by facebook$")
    public void share_the_promo_by_facebook() throws Throwable {
    	//Studioprofile.scrolldownm();
        log.info("promoname shraed is:" + Studioprofile.promonamesoninrowtitle().getText());
       
        Studioprofile.promoshareicon();
        Shareandfollow.promofacebooksharem();
        Shareandfollow.facebookwindowhandle();
        
    }
    @Then("^Share the promo by twitter$")
    public void share_the_promo_by_twitter() throws Throwable {
        Shareandfollow.promotwittersharem();
        Shareandfollow.twitterwindowhandle();
        
    }

    @Then("^Share the promo by whatsapp$")
    public void share_the_promo_by_whatsapp() throws Throwable {
        Shareandfollow.promowhatsappsharem();
        Shareandfollow.whatsappwindowhandlforpromo();
        
    }

    @Then("^Share the promo by copylink$")
    public void share_the_promo_by_copylink() throws Throwable {
        Shareandfollow.promocopylinksharem();
        String Actual=Toastanderrormessages.toastmessagem().getText();
        log.info("Toastmessage shown :" + Actual);
        assertEquals(Actual,"Link Copied!");
        Shareandfollow.closesharepopupm();
    }
    

    @Then("^Share the audio by facebook$")
    public void share_the_audio_by_facebook() throws Throwable {
    	Studioprofile.scrolldownm();
        log.info("audioname shraed is:" + Studioprofile.audionamesm().getText());
        Studioprofile.mousehoveronaudiotracksm();
        Thread.sleep(1500);
        Shareandfollow.audiosharem();
        Thread.sleep(1500);
        Shareandfollow.promofacebooksharem();
        Shareandfollow.facebookwindowhandle();
        
        
    }

    @Then("^Share the audio by twitter$")
    public void share_the_audio_by_twitter() throws Throwable {
    	Studioprofile.scrolldownm();
        log.info("audioname shraed is:" + Studioprofile.audionamesm().getText());
        Shareandfollow.promotwittersharem();
        Shareandfollow.twitterwindowhandle();
     
    }

    @Then("^Share the audio by watsapp$")
    public void share_the_audio_by_watsapp() throws Throwable {
    	Studioprofile.scrolldownm();
        log.info("audioname shraed is:" + Studioprofile.audionamesm().getText());
        
        Shareandfollow.promowhatsappsharem();
        Shareandfollow.whatsappwindowhandlforpromo();
       
    }

    @Then("^Share the audio by copylink$")
    public void share_the_audio_by_copylink() throws Throwable {
    	Studioprofile.scrolldownm();
        log.info("audioname shraed is:" + Studioprofile.audionamesm().getText());
        Studioprofile.mousehoveronaudiotracksm();
        Shareandfollow.audiosharem();
        Shareandfollow.promocopylinksharem();
        String Actual=Toastanderrormessages.toastmessagem().getText();
        log.info("Toastmessage shown :" + Actual);
        assertEquals(Actual,"Link Copied!");
        Shareandfollow.closesharepopupm();
    }
    @Then("^share studio by facebook$")
    public void share_studio_by_facebook() throws Throwable {
        Studioprofile.studiofacebooksharem().click();
        Shareandfollow.facebookwindowhandle();
    }

    @Then("^share studio by twitter$")
    public void share_studio_by_twitter() throws Throwable {
        Studioprofile.studiotwittersharem().click();;
        Shareandfollow.twitterwindowhandle();
    }

    @Then("^share studio by whataspp$")
    public void share_studio_by_whataspp() throws Throwable {
        Studioprofile.studiowatsappsharem().click();
        Shareandfollow.Studiowhatsappswindowhandle();
    }

    @Then("^share studio by copylink$")
    public void share_studio_by_copylink() throws Throwable {
    	Studioprofile.studiocopylinksharem();
    	
    }
    int gudcountafterplay;
    int viewcountafterplay;
    @Then("^The view count and gud count sould be incremented by one after promo play$")
    public void the_view_count_and_gud_count_sould_be_incremented_by_one_after_promo_play() throws Throwable {
    	Studioprofile.scrolldownm();
    	String viewscountstr=Streaming.viewcountm().get(0).getText();
		String viewcountonlystr=viewscountstr.substring(0,viewscountstr.lastIndexOf(" "));
		int viewcountbeforeplay=Integer.parseInt(viewcountonlystr); 
		log.info("View Count before play:" + viewcountbeforeplay);
		String gudscountstr=Streaming.gudcountm().get(0).getText();
		String gudcountonlystr=gudscountstr.substring(0,gudscountstr.lastIndexOf(" "));
		int gudcountbeforeplay=Integer.parseInt(gudcountonlystr);  
		log.info("Gud count before pay:"+ gudcountbeforeplay);
       String actualpromoname= Studioprofile.promonames().getText();
       Studioprofile.mousehoveronpromos();
       Thread.sleep(2000);
       videoandaudioPlayer.mousehoveronplayerm();
       wait.until(ExpectedConditions.visibilityOf(videoandaudioPlayer.clapsymbolinplayerm()));
       int gudcountbeforeonplayer=videoandaudioPlayer.gudcountonplayer();
   	   assertEquals(gudcountbeforeplay,gudcountbeforeonplayer);
       String expecetedpromoname=videoandaudioPlayer.promonameonplayerm().getText();
       assertTrue(actualpromoname.equalsIgnoreCase(expecetedpromoname));
       videoandaudioPlayer.clapsymbolinplayerm().click();;
       Thread.sleep(1200);
       int gudcountafteronplayer=videoandaudioPlayer.gudcountonplayer();
       String Actual=Toastanderrormessages.toastmessagem().getText();
       log.info(Actual);
       Toastanderrormessages.toastmessageclosem().click();
       videoandaudioPlayer.mousehoveronplayerm();
       videoandaudioPlayer.closeplayerm().click();
       
       socialpageandsearch.searchiconclickm().click();
       socialpageandsearch.inputintosearchm().sendKeys("Sameer");
       socialpageandsearch.autosuggestivenamesm("Sameer");
       Thread.sleep(4000);
       driver.navigate().refresh();
       Thread.sleep(7000);
     
       Studioprofile.scrolldownm();
       String viewscountstr1=Streaming.viewcountm().get(0).getText();
		String viewcountonlystr1=viewscountstr1.substring(0,viewscountstr1.lastIndexOf(" "));
		viewcountafterplay=Integer.parseInt(viewcountonlystr1); 
		log.info("View Count after play:" + viewcountafterplay);
		String gudscountstr1=Streaming.gudcountm().get(0).getText();
		String gudcountonlystr1=gudscountstr1.substring(0,gudscountstr1.lastIndexOf(" "));
		gudcountafterplay=Integer.parseInt(gudcountonlystr1); 
		log.info("Gud Count after play:" + gudcountafterplay);
		 assertEquals(gudcountafterplay,gudcountafteronplayer);
		assertEquals(viewcountafterplay,viewcountbeforeplay+1);
		assertEquals(gudcountafterplay,gudcountbeforeplay+1);
       
    }
    @Then("^The view and gud count also same in inside the page$")
    public void the_view_and_gud_count_also_same_in_inside_the_page() throws Throwable {
    	Studioprofile.scrolldownm();
        String viewscountstr1=Shoorseriesdetailpage.promoviewcountm().get(0).getText();
 		String viewcountonlystr1=viewscountstr1.substring(0,viewscountstr1.lastIndexOf(" "));
 		int viewcountafterplay=Integer.parseInt(viewcountonlystr1); 
 		log.info("View Count after play:" + viewcountafterplay);
 		String gudscountstr1=Streaming.gudcountm().get(0).getText();
 		String gudcountonlystr1=gudscountstr1.substring(0,gudscountstr1.lastIndexOf(" "));
 		int gudcountafterplay=Integer.parseInt(gudcountonlystr1); 
 		log.info("Gud Count after play:" + gudcountafterplay);
 		assertEquals(viewcountafterplay,viewcountafterplay);
 		assertEquals(gudcountafterplay,gudcountafterplay);
    }
    @Then("^The view count and gud count sould be decremented by one after promo play$")
    public void the_view_count_and_gud_count_sould_be_decremented_by_one_after_promo_play() throws Throwable {
    	
    	Studioprofile.scrolldownm();
    	String viewscountstr=Streaming.viewcountm().get(0).getText();
		String viewcountonlystr=viewscountstr.substring(0,viewscountstr.lastIndexOf(" "));
		int viewcountbeforeplay=Integer.parseInt(viewcountonlystr); 
		log.info("View Count before play:" + viewcountbeforeplay);
		String gudscountstr=Streaming.gudcountm().get(0).getText();
		String gudcountonlystr=gudscountstr.substring(0,gudscountstr.lastIndexOf(" "));
		int gudcountbeforeplay=Integer.parseInt(gudcountonlystr);  
		log.info("Gud count before pay:"+ gudcountbeforeplay);
       String actualpromoname= Studioprofile.promonames().getText();
       Studioprofile.mousehoveronpromos();
       Thread.sleep(2000);
       videoandaudioPlayer.mousehoveronplayerm();
       wait.until(ExpectedConditions.visibilityOf(videoandaudioPlayer.clapsymbolinplayerm()));
       int gudcountbeforeonplayer=videoandaudioPlayer.gudcountonplayer();
   	   assertEquals(gudcountbeforeplay,gudcountbeforeonplayer);
       String expecetedpromoname=videoandaudioPlayer.promonameonplayerm().getText();
       assertTrue(actualpromoname.equalsIgnoreCase(expecetedpromoname));
       videoandaudioPlayer.clapsymbolinplayerm().click();;
       Thread.sleep(1000);
       String Actual=Toastanderrormessages.toastmessagem().getText();
       log.info(Actual);
       Toastanderrormessages.toastmessageclosem().click();
       videoandaudioPlayer.mousehoveronplayerm();
       int gudcountafteronplayer=videoandaudioPlayer.gudcountonplayer();
       videoandaudioPlayer.closeplayerm().click();
       Thread.sleep(1000);

       socialpageandsearch.searchiconclickm().click();
       socialpageandsearch.inputintosearchm().sendKeys("Sameer");
       socialpageandsearch.autosuggestivenamesm("Sameer");
       Thread.sleep(4000);
       driver.navigate().refresh();
       Thread.sleep(8000);
     
       Studioprofile.scrolldownm();
       String viewscountstr1=Streaming.viewcountm().get(0).getText();
		String viewcountonlystr1=viewscountstr1.substring(0,viewscountstr1.lastIndexOf(" "));
		int viewcountafterplay=Integer.parseInt(viewcountonlystr1); 
		log.info("View Count after play:" + viewcountafterplay);
		String gudscountstr1=Streaming.gudcountm().get(0).getText();
		String gudcountonlystr1=gudscountstr1.substring(0,gudscountstr1.lastIndexOf(" "));
		int gudcountafterplay=Integer.parseInt(gudcountonlystr1); 
		log.info("Gud Count after play:" + gudcountafterplay);
		 assertEquals(gudcountafterplay,gudcountafteronplayer);
		assertEquals(viewcountafterplay,viewcountbeforeplay+1);
		assertEquals(gudcountafterplay,gudcountbeforeplay-1);
       
    }
    @And("^click on latestpromos page to see all the promos by clicking on (.+)$")
    public void click_on_latestpromos_page_to_see_all_the_promos_by_clicking_on(String rowtitlename) throws Throwable {
        Studioprofile.rowtitleclickm(rowtitlename);
        Thread.sleep(1500);
        
    }
    @And("^come back$")
    public void come_back() throws Throwable {
    	Actions a=new Actions(driver);
    	Thread.sleep(2000);
        a.moveToElement(Streaming.backarrowm()).click().build().perform();
        assertTrue(Studioprofile.studionameonstudiopagem().isDisplayed());
    }
    
    @Then("^Follow the studio by facebook$")
    public void follow_the_studio_by_facebook() throws Throwable {
        Studioprofile.studioinfom().click();
        Thread.sleep(700);
        Studioprofile.followstudio().get(0).click();
        String MainWindow=driver.getWindowHandle();				
        Set<String> s1=driver.getWindowHandles();		
        Iterator<String> i1=s1.iterator();			
        while(i1.hasNext())			
        {		
         String ChildWindow=i1.next();		
        		
         if(!MainWindow.equalsIgnoreCase(ChildWindow))			
         {    		
                driver.switchTo().window(ChildWindow);
                String pagetitle=driver.getTitle();
                log.info(pagetitle);
                assertEquals(pagetitle,"Facebook – log in or sign up");
                assertEquals(driver.getCurrentUrl(),"https://www.facebook.com/");
                driver.close();
         }
        } 
        driver.switchTo().window(MainWindow);
    }

    @Then("^Follow rhe studio by twitter$")
    public void follow_rhe_studio_by_twitter() throws Throwable {
    	Studioprofile.followstudio().get(1).click();
    	String MainWindow=driver.getWindowHandle();				
        Set<String> s1=driver.getWindowHandles();		
        Iterator<String> i1=s1.iterator();			
        while(i1.hasNext())			
        {		
         String ChildWindow=i1.next();		
        		
         if(!MainWindow.equalsIgnoreCase(ChildWindow))			
         {    		
                driver.switchTo().window(ChildWindow);
                String pagetitle=driver.getTitle();
                log.info(pagetitle);
                assertEquals(driver.getCurrentUrl(),"https://twitter.com/");
                driver.close();
         }
        } 
        driver.switchTo().window(MainWindow);
    
    }

    @Then("^Follow the studio by instagram$")
    public void follow_the_studio_by_instagram() throws Throwable {
    	Studioprofile.followstudio().get(2).click();
    	String MainWindow=driver.getWindowHandle();				
        Set<String> s1=driver.getWindowHandles();		
        Iterator<String> i1=s1.iterator();			
        while(i1.hasNext())			
        {		
         String ChildWindow=i1.next();		
        		
         if(!MainWindow.equalsIgnoreCase(ChildWindow))			
         {    		
                driver.switchTo().window(ChildWindow);
                String pagetitle=driver.getTitle();
                log.info(pagetitle);
                assertEquals(driver.getCurrentUrl(),"https://www.instagram.com/");
                driver.close();
         }
        } 
        driver.switchTo().window(MainWindow);
    
    }

    @Then("^Follow the studio by linkedin$")
    public void follow_the_studio_by_linkedin() throws Throwable {
    	Studioprofile.followstudio().get(3).click();
    	String MainWindow=driver.getWindowHandle();				
        Set<String> s1=driver.getWindowHandles();		
        Iterator<String> i1=s1.iterator();			
        while(i1.hasNext())			
        {		
         String ChildWindow=i1.next();		
        		
         if(!MainWindow.equalsIgnoreCase(ChildWindow))			
         {    		
                driver.switchTo().window(ChildWindow);
                String pagetitle=driver.getTitle();
                log.info(pagetitle);
                assertEquals(driver.getCurrentUrl(),"https://www.linkedin.com/");
                driver.close();
         }
        } 
        driver.switchTo().window(MainWindow);
    
    }

    @Then("^Follow the studio by website$")
    public void follow_the_studio_by_website() throws Throwable {
    	Studioprofile.followstudio().get(4).click();
    	String MainWindow=driver.getWindowHandle();				
        Set<String> s1=driver.getWindowHandles();		
        Iterator<String> i1=s1.iterator();			
        while(i1.hasNext())			
        {		
         String ChildWindow=i1.next();		
        		
         if(!MainWindow.equalsIgnoreCase(ChildWindow))			
         {    		
                driver.switchTo().window(ChildWindow);
                String pagetitle=driver.getTitle();
                log.info(pagetitle);
                assertEquals(driver.getCurrentUrl(),"https://gudsho.com/");
                driver.close();
         }
        } 
        driver.switchTo().window(MainWindow);
    
    }

    @Then("^check error toast message as \"([^\"]*)\"$")
    public void check_error_toast_message_as_something(String expected) throws Throwable {
        String Actual=Toastanderrormessages.toastmessagem().getText();
        Assert.assertEquals(expected, Actual);
    }

}
