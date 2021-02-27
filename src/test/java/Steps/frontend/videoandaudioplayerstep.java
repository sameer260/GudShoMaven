package Steps.frontend;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.frontend.Paymentpage;
import PageObjects.frontend.Shoorseriesdetailpage;
import PageObjects.frontend.Toastanderrormessages;
import PageObjects.frontend.videoandaudioPlayer;
import Resources.Base_setup;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class videoandaudioplayerstep  extends Base_setup
{
	 
	 public static Logger log=Logger.getLogger(videoandaudioplayerstep.class.getName());
	 @Then("^Mousehover on player and Click on clapicon to like the promo$")
	   public void mousehover_on_player_and_click_on_clapicon_to_like_the_promo() throws Throwable {
		 videoandaudioPlayer.mousehoveronplayerm();
		 videoandaudioPlayer.clapsymbolinplayerm().click(); 
	        log.info("Clicked on Clap icon ");
	        assertEquals(Toastanderrormessages.toastmessagem().getText(),"You liked this promo");
	        log.info("you liked this promo");
	    }
	 @Then("^close the player$")
	    public void close_the_player() throws Throwable {
		 videoandaudioPlayer.closeplayerm().click();
	        log.info("Clicked on close button on player");
	    }
	 @And("^Add into my fav audios clicking on heart symbol$")
	    public void add_into_my_fav_audios_clicking_on_heart_symbol() throws Throwable {
		 videoandaudioPlayer.heartsymbolm().click();
	        log.info("Clicked on heart symbol to add audio in to favouraties ");
	    }
	 @Then("^Close the audio player$")
	    public void close_the_audio_player() throws Throwable {
		 videoandaudioPlayer.closeaudioplayerm().click();
	       log.info("Closed the audio player");
	    }
	 @And("^check same (.+) is displayed on player$")
	    public void check_same_is_displayed_on_player(String promoname) throws Throwable {
	    	assertEquals(videoandaudioPlayer.promonameonplayerm().getText(),promoname);
	    	log.info("Promo name on Player is :"  + videoandaudioPlayer.promonameonplayerm().getText());
	    	log.info(promoname +  " Played successfully");
	    	
	    }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 //Audio Player settings
	 @Then("^Play any (.+)$")
	    public void play_any(String audioname) throws Throwable {
	        Shoorseriesdetailpage.audionamesinshodetailpagem(audioname);
	        Thread.sleep(1000);
	        
	    }

	    @And("^it should display gudsho icon$")
	    public void it_should_display_gudsho_icon() throws Throwable {
	    	assertTrue(videoandaudioPlayer.gudshoiconinaudioplayerm().isDisplayed());
	    }

	    @And("^stop the audio after (.+) and play the audio and other settings$")
	    public void stop_the_audio_after_and_play_the_audio_and_other_settings(String duration) throws Throwable {
	    	videoandaudioPlayer.audioplayerallsettingsm(duration);
	    	   assertEquals(videoandaudioPlayer.repeatspngtooltip1,"Repeat this Song");
		       assertEquals(videoandaudioPlayer.afterfirstclickttooltip,"Repeat All");
		       assertEquals(videoandaudioPlayer.aftersecondtimetooltip,"Disable Repeat");
		       assertEquals(videoandaudioPlayer.afterlastclicktooltip,"Repeat this Song");
		       assertEquals(videoandaudioPlayer.enableshuffletooltip,"Enable shuffle");
		       assertEquals(videoandaudioPlayer.disableshuffletooltip,"Disable shuffle");
		       assertEquals(videoandaudioPlayer.lasttimedisabletooltip,"Enable shuffle");
	    }
	    @And("^Hide or show the player$")
	    public void hide_or_show_the_player() throws Throwable {
	        videoandaudioPlayer.showorhide().click();
	        videoandaudioPlayer.showorhide().click();
	    }

	    @And("^next and previous song button$")
	    public void next_and_previous_song_button() throws Throwable {
	    	videoandaudioPlayer.nextsongbuttonm();
	    	videoandaudioPlayer.previoussongbuttonm();
	    }

	    @And("^mute and unmute the audio$")
	    public void mute_and_unmute_the_audio() throws Throwable {
	    	videoandaudioPlayer.muteandunmuteaudiom();
	    	videoandaudioPlayer.closeaudioplayerm().click();
	    }
	    
	    //Video Player Settings
	    @And("^Pause and Play the video after (.+) seconds$")
	    public void pause_and_play_the_video_after_seconds(String k) throws Throwable {
	        Thread.sleep(2000);
	        videoandaudioPlayer.mousehoveronplayerm();
	        videoandaudioPlayer.playeerpause(k);
	        assertEquals(k,videoandaudioPlayer.currentdusration);
	        assertEquals("Pause",videoandaudioPlayer.tooltippause);
	        Thread.sleep(7000);
	        videoandaudioPlayer.playbutton();
	        assertEquals("Play",videoandaudioPlayer.tooltipplay);
	    }
	    @And("^Forward video after (.+) and (.+)$")
	    public void forward_video_after_and(String forward, String durationafterforward) throws Throwable {
	    	videoandaudioPlayer.mousehoveronplayerm();
	    	videoandaudioPlayer.forwardm(forward);
		      log.info(durationafterforward);
		      
		      assertEquals(durationafterforward,videoandaudioPlayer.currentdusrationafterforward);
		      assertEquals(videoandaudioPlayer.forwardtooltip,"Forward 10s");
	    }

	    @And("^Backward video after (.+) and (.+)$")
	    public void backward_video_after_and(String backward, String durationafterbackward) throws Throwable {
	    	  videoandaudioPlayer.backwardm(backward);
		       assertEquals(videoandaudioPlayer.backwardtooltip,"Rewind 10s");
			   log.info(durationafterbackward);
			
			   assertEquals(durationafterbackward,videoandaudioPlayer.currentdurationafterbackward);
	    }
	    @And("^Mute and adjust the audio$")
	    public void mute_and_adjust_the_audio() throws Throwable {
	    	videoandaudioPlayer.mousehoveronplayerm();
	    	videoandaudioPlayer.audiomuteandadjust();
	        assertEquals("0.0%",videoandaudioPlayer.volumeattributevalueinmute);
	        assertEquals("100.0%",videoandaudioPlayer.volumeattributevalueinfullvolume);
	        assertEquals("35.0%",videoandaudioPlayer.volumeafterclickingonvolumecontrol);
	        assertEquals("Enter fullscreen",videoandaudioPlayer.enterfullscreentooltip);
	       
	    }
	    @And("^Click on next promo from the player$")
	    public void click_on_next_promo_from_the_player() throws Throwable {
	    	videoandaudioPlayer.mousehoveronplayerm();
	        String str3="Next promo";
	        //JavascriptExecutor js=(JavascriptExecutor)driver;
	        while(str3.equalsIgnoreCase("Next promo"))
	        {
	        	Thread.sleep(500);
	        	videoandaudioPlayer.mousehoveronplayerm();
	        	Thread.sleep(500);
	        	
	        	try {
	        	str3=videoandaudioPlayer.promonextbutton().getText();
	        	videoandaudioPlayer.promonextbutton().click();
	        	log.info(str3);
		    	//js.executeScript("arguments[0].click();", videoandaudioPlayer.fullscreensbutton());
	        	}catch(Exception e)
	        	{
	        		
	    	    	//js.executeScript("arguments[0].click();", videoandaudioPlayer.fullscreensbutton());
	        		videoandaudioPlayer.promoswitching();
	        		assertTrue(videoandaudioPlayer.shoorseriesnameinminititle().isDisplayed());
	        		assertTrue(videoandaudioPlayer.buyorplaybuttononminititle().isDisplayed());
	        		videoandaudioPlayer.closeicon().click();
	        		break;
	        		
	        	}
	        }
	       
	    }
	    @Then("^Buy or play any series$")
	    public void buy_or_play_any_series() throws Throwable {
	        Shoorseriesdetailpage.playorbuybuttonm().click();
	        try {
	        	Paymentpage.carddetails();
	        	Paymentpage.paybuttonm();
	        	Thread.sleep(3000);
	        	Paymentpage.successwindowhandle();
	        	Thread.sleep(1000);
	        	Paymentpage.playbuttonafterbuym().click();
	        }
	        catch(Exception e)
	        {
	        	log.info("Already bought playing video");
	        }
	    }

	    @And("^Click next episode button$")
	    public void click_next_episode_button() throws Throwable {
	    	String str3="Next Episode";
	        while(str3.equalsIgnoreCase("Next Episode"))
	        {
	        	Thread.sleep(1000);
	        	videoandaudioPlayer.mousehoveronplayerm();
	        	Thread.sleep(500);
	        	
	        	try {
	        	str3=videoandaudioPlayer.nextepisodebutton().getText();
	        	videoandaudioPlayer.nextepisodebutton().click();
	        	//JavascriptExecutor js=(JavascriptExecutor)driver;
		    	//js.executeScript("arguments[0].click();", videoandaudioPlayer.fullscreensbutton());
	        	log.info(str3);
	        	}catch(Exception e)
	        	{
	        		log.info("All episodes played");
	        		break;
	        		
	        	}
	        }
	        videoandaudioPlayer.mousehoveronplayerm();
	        videoandaudioPlayer.closeplayerm().click();
	    }
	    @And("^select (.+) and play (.+)$")
	    public void select_and_play(String seasonname, String episodename) throws Throwable {
	    	String seasonnameonepisodepage=null;
	    	String episodenameonpopup=null;
	        videoandaudioPlayer.mousehoveronplayerm();
	        Thread.sleep(1000);
	        videoandaudioPlayer.episodepopupbutton().click();
	        
	        videoandaudioPlayer.seasondropdown().click();
	        assertEquals(videoandaudioPlayer.seriesnameonepisodepopup().getText(),videoandaudioPlayer.shoseriesnameonplayerm().getText());
	        for(int i=0;i<videoandaudioPlayer.seasonname().size();i++)
	        {
	        	if(videoandaudioPlayer.seasonname().get(i).getText().equalsIgnoreCase(seasonname))
	        	{
	        		seasonnameonepisodepage=videoandaudioPlayer.seasonname().get(i).getText();
	        		videoandaudioPlayer.seasonname().get(i).click();
	        		Thread.sleep(1000);
	        		for(int j=0;j<videoandaudioPlayer.episodesnames().size();j++)
	        		{
	        			if(videoandaudioPlayer.episodesnames().get(j).getText().equalsIgnoreCase(episodename))
	        			{
	        				episodenameonpopup=videoandaudioPlayer.episodesnames().get(j).getText();
	        				log.info(episodenameonpopup);
	        				videoandaudioPlayer.episodesnames().get(j).click();
	        				break;
	        			}
	        		}
	        		break;
	        	}
	        }
	        videoandaudioPlayer.mousehoveronplayerm();
            String str=videoandaudioPlayer.promonameonplayerm().getText();
            String text=episodenameonpopup.substring(3);
	        log.info(seasonnameonepisodepage);
	        assertEquals(seasonnameonepisodepage+", "+text,str);
	        videoandaudioPlayer.episodepopupbutton().click();
	        videoandaudioPlayer.episodepopupclose().click();
	        
	       
	    }
	    @And("^From rightside promo section play the promos and check hide functionality$")
	    public void from_rightside_promo_section_play_the_promos_and_check_hide_functionality() throws Throwable {
	    	assertTrue(videoandaudioPlayer.headingsofpromosandextras().isDisplayed());
	    	assertEquals(videoandaudioPlayer.headingsofpromosandextras().getText(),"Promos & Extras");
	    	videoandaudioPlayer.hidepromos().click();
	    	Thread.sleep(1000);
	    	videoandaudioPlayer.mousehoveronplayerm();
	    	assertTrue(videoandaudioPlayer.showpromosonplayer().isDisplayed());
	    	videoandaudioPlayer.showpromosonplayer().click();
	    	Thread.sleep(500);
	    	assertTrue(videoandaudioPlayer.headingsofpromosandextras().isDisplayed());
	    	
	    	videoandaudioPlayer.mousehoveronplayerm();
	    	assertEquals(videoandaudioPlayer.promonameonplayerm().getText(),videoandaudioPlayer.promonamesonrightsidepanel().get(0).getText());
	    	assertTrue(videoandaudioPlayer.viewcountonpromorightside().get(0).isDisplayed());
	    	assertTrue(videoandaudioPlayer.gudcountonpromorightside().get(0).isDisplayed());
	    	
	    	for(int i=1;i<videoandaudioPlayer.promonamesonrightsidepanel().size();i++)
	    	{
	    		String promoname=videoandaudioPlayer.promonamesonrightsidepanel().get(i).getText();
	    		assertTrue(videoandaudioPlayer.viewcountonpromorightside().get(i).isDisplayed());
	    		log.info(videoandaudioPlayer.viewcountonpromorightside().get(i).getText());
	    		assertTrue(videoandaudioPlayer.gudcountonpromorightside().get(i).isDisplayed());
	    		log.info(videoandaudioPlayer.viewcountonpromorightside().get(i).getText());
	    		log.info(videoandaudioPlayer.gudcountonpromorightside().get(i).getText());
	    		videoandaudioPlayer.promonamesonrightsidepanel().get(i).click();
	    		videoandaudioPlayer.mousehoveronplayerm();
	    		Thread.sleep(2000);
	    		log.info(videoandaudioPlayer.promonameonplayerm().getText());
	    		assertEquals(videoandaudioPlayer.promonameonplayerm().getText(),promoname);	
	    	}
	    	videoandaudioPlayer.promoswitching();
	    	Thread.sleep(1000);
	    	videoandaudioPlayer.closeicon().click();
	    	
	    	assertTrue(Shoorseriesdetailpage.shonameinshodetailspage().isDisplayed());
	    }

	    @And("^Enter in to the full screen$")
	    public void enter_in_to_the_full_screen() throws Throwable {
	    	//Actions a=new Actions(driver);
	    	//a.moveToElement(videoandaudioPlayer.fullscreensbutton()).click().build().perform();
	    	//videoandaudioPlayer.fullscreensbutton().click();
	    	videoandaudioPlayer.mousehoveronplayerm();
	    	WebDriverWait wait=new WebDriverWait(driver,20);
	    	wait.until(ExpectedConditions.visibilityOf(videoandaudioPlayer.fullscreensbutton()));
	    	JavascriptExecutor js=(JavascriptExecutor)driver;
	    	js.executeScript("arguments[0].click();", videoandaudioPlayer.fullscreensbutton());
	    	Thread.sleep(1000);
	    }
	    @And("^Click on next promo from the player for full screen$")
	    public void click_on_next_promo_from_the_player_for_full_screen() throws Throwable {
	    	videoandaudioPlayer.mousehoveronplayerm();
	        String str3="Next promo";
	        JavascriptExecutor js=(JavascriptExecutor)driver;
	        while(str3.equalsIgnoreCase("Next promo"))
	        {
	        	Thread.sleep(500);
	        	videoandaudioPlayer.mousehoveronplayerm();
	        	Thread.sleep(500);
	        	
	        	try {
	        	str3=videoandaudioPlayer.promonextbutton().getText();
	        	videoandaudioPlayer.promonextbutton().click();
	        	log.info(str3);
		    	js.executeScript("arguments[0].click();", videoandaudioPlayer.fullscreensbutton());
	        	}catch(Exception e)
	        	{
	        		
	    	    	//js.executeScript("arguments[0].click();", videoandaudioPlayer.fullscreensbutton());
	        		videoandaudioPlayer.promoswitching();
	        		assertTrue(videoandaudioPlayer.shoorseriesnameinminititle().isDisplayed());
	        		assertTrue(videoandaudioPlayer.buyorplaybuttononminititle().isDisplayed());
	        		videoandaudioPlayer.closeicon().click();
	        		break;
	        		
	        	}
	        }
	    }
	    
	    @And("^Click next episode button for full screen$")
	    public void click_next_episode_button_for_full_screen() throws Throwable {
	    	String str3="Next Episode";
	        while(str3.equalsIgnoreCase("Next Episode"))
	        {
	        	Thread.sleep(1000);
	        	videoandaudioPlayer.mousehoveronplayerm();
	        	Thread.sleep(500);
	        	
	        	try {
	        	str3=videoandaudioPlayer.nextepisodebutton().getText();
	        	videoandaudioPlayer.nextepisodebutton().click();
	        	JavascriptExecutor js=(JavascriptExecutor)driver;
		    	js.executeScript("arguments[0].click();", videoandaudioPlayer.fullscreensbutton());
	        	log.info(str3);
	        	}catch(Exception e)
	        	{
	        		log.info("All episodes played");
	        		break;
	        		
	        	}
	        }
	        videoandaudioPlayer.mousehoveronplayerm();
	        videoandaudioPlayer.closeplayerm().click();
	    }
}
