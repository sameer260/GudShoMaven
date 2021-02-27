package Steps.frontend;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;


import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

import PageObjects.frontend.Shareandfollow;
import PageObjects.frontend.Shoorseriesdetailpage;
import PageObjects.frontend.Streaming;
import PageObjects.frontend.Studioprofile;
import PageObjects.frontend.Toastanderrormessages;
import PageObjects.frontend.videoandaudioPlayer;
import Resources.Base_setup;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Streamingpagesteps extends Base_setup
{
	public static Logger log=Logger.getLogger(Streamingpagesteps.class.getName());
	
	@Given("^verify all the titles are available on the streaming page$")
	public void verify_all_the_titles_are_available_on_the_streaming_page() throws Throwable {
		Studioprofile.scrolldownm();

		for (int i = 0; i < Streaming.streamingpagetitlesm().size(); i++) {
			log.info(Streaming.streamingpagetitlesm().get(i).getText());
		}
		assertEquals(Streaming.streamingpagetitlesm().get(2).getText(), Streaming.inputs().getProperty("Title1"));
		assertEquals(Streaming.streamingpagetitlesm().get(3).getText(), Streaming.inputs().getProperty("Title2"));
		assertEquals(Streaming.streamingpagetitlesm().get(4).getText(), Streaming.inputs().getProperty("Title3"));
		assertEquals(Streaming.streamingpagetitlesm().get(5).getText(), Streaming.inputs().getProperty("Title4"));
		assertEquals(Streaming.streamingpagetitlesm().get(6).getText(), Streaming.inputs().getProperty("Title5"));
		assertEquals(Streaming.streamingpagetitlesm().get(7).getText(), Streaming.inputs().getProperty("Title6"));
		assertEquals(Streaming.streamingpagetitlesm().get(8).getText(), Streaming.inputs().getProperty("Title7"));

	}

	@When("^click on any sho card$")
	public void click_on_any_sho_card() throws Throwable {
		for (int i = 0; i < Streaming.shocardnamesm().size(); i++) {
			Actions a = new Actions(driver);
				if (Streaming.shocardnamesm().get(i).getText()
						.equalsIgnoreCase(Streaming.inputs().getProperty("Shoorseriesname"))) {
					log.info(Streaming.shocardnamesm().get(i).getText());
					assertEquals(Streaming.shocardnamesm().get(i).getText(),
							Streaming.inputs().getProperty("Shoorseriesname"));
					a.moveToElement(Streaming.shocardsm().get(i)).click().build().perform();
					break;
				}		
		}
		Thread.sleep(1500);
		log.info(Shoorseriesdetailpage.shonameinshodetailspage().getText());
		assertTrue(Shoorseriesdetailpage.shonameinshodetailspage().getText().equalsIgnoreCase(
				Streaming.inputs().getProperty("Shoorseriesname")));
	}

	@Then("^check the page has redirected correctly$")
	public void check_the_page_has_redirected_correctly() throws Throwable {
		Thread.sleep(1500);
		log.info(Shoorseriesdetailpage.shonameinshodetailspage().getText());
		assertTrue(Shoorseriesdetailpage.shonameinshodetailspage().getText().equalsIgnoreCase(
				Streaming.inputs().getProperty("Shoseriesname2")));
	}

	@Given("^To check the redirection of sho card in particular row$")
	public void to_check_the_redirection_of_sho_card_in_particular_row() throws Throwable {
		Actions a=new Actions(driver);
		Studioprofile.scrolldownm();
		Thread.sleep(1000);
		for (int i = 0; i < Streaming.streamingpagetitlesm().size(); i++) {
			if (Streaming.streamingpagetitlesm().get(i).getText()
					.equalsIgnoreCase(Streaming.inputs().getProperty("Title5"))) {
				while(!Streaming.nextarrowm().get(i).getAttribute("aria-disabled").equalsIgnoreCase("true"))
        		{
        			a.moveToElement(Streaming.nextarrowm().get(i)).click().build().perform();
        		}
				for (int j = 0; j < Streaming.shocardnamesm().size(); j++) {
						if (Streaming.shocardnamesm().get(j).getText()
								.equalsIgnoreCase(Streaming.inputs().getProperty("Shoseriesname2"))) {
							log.info(Streaming.shocardnamesm().get(j).getText());
							assertTrue(Streaming.shocardnamesm().get(j).getText().equalsIgnoreCase(
									Streaming.inputs().getProperty("Shoseriesname2")));
							a.moveToElement(Streaming.shocardsm().get(j)).click().build().perform();
							break;
						}
				}
				break;
			}

		}

	}
	
	 @Given("^Check the redirection of sho card in particular row from all sho page$")
	    public void check_the_redirection_of_sho_card_in_particular_row_from_all_sho_page() throws Throwable {
		 Actions a = new Actions(driver);
		 Studioprofile.scrolldownm();
			Thread.sleep(1000);
			for (int i = 0; i < Streaming.streamingpagetitlesm().size(); i++) {
				if (Streaming.streamingpagetitlesm().get(i).getText()
						.equalsIgnoreCase(Streaming.inputs().getProperty("Title5"))) {
					a.moveToElement(Streaming.streamingpagetitlesm().get(i)).click().build().perform();
					Studioprofile.scrolldownm();
					Thread.sleep(500);
					for (int j = 0; j < Streaming.shocardnamesm().size(); j++) {
							if (Streaming.shocardnamesm().get(j).getText()
									.equalsIgnoreCase(Streaming.inputs().getProperty("Shoseriesname2"))) {
								log.info(Streaming.shocardnamesm().get(j).getText());
								assertTrue(Streaming.shocardnamesm().get(j).getText().equalsIgnoreCase(
										Streaming.inputs().getProperty("Shoseriesname2")));
								a.moveToElement(Streaming.shocardsm().get(j)).click().build().perform();
								break;
							}
					}
					break;
				}

			}

	    }
	    @Given("^Play the promo and like the promo and check the count$")
	    public void play_the_promo_and_like_the_promo_and_check_the_count() throws Throwable {
	    	Actions a=new Actions(driver);
	    	Studioprofile.scrolldownm();
	    	for(int i=0;i<Streaming.promonamesm().size();i++)
	    	{
	    		if(Streaming.promonamesm().get(i).getText().equalsIgnoreCase(Streaming.inputs().getProperty("Promoname")))
	    		{
	    		String viewstr=Streaming.viewcountm().get(i).getText();
	    		String viewstr1=viewstr.substring(0,viewstr.lastIndexOf(" "));
	    		int viewcount=Integer.parseInt(viewstr1);
	    		log.info("view count :" + viewcount);
	    		
	    		String gudstr=Streaming.gudcountm().get(i).getText();
	    		String gudstr1=gudstr.substring(0,gudstr.lastIndexOf(" "));
	    		int gudcount=Integer.parseInt(gudstr1);
	    		log.info("gud count :" + gudcount);
	    		
	    		String promoname=Streaming.promonamesm().get(i).getText();
	    		log.info(promoname);
	    		log.info(Streaming.shoorseriesnameonprmocardm().get(i).getText());
	    		
	    		a.moveToElement(Streaming.mousehoveronpromocardsm().get(i)).click().build().perform();
	    		videoandaudioPlayer.mousehoveronplayerm();
	    		String promonameonplayer=videoandaudioPlayer.promonameonplayerm().getText();
	    		log.info("Promoname on player:" + promonameonplayer);
	    		assertEquals(promonameonplayer,promoname);
	    		videoandaudioPlayer.clapsymbolinplayerm().click();
	    		videoandaudioPlayer.closeplayerm().click();
	    		
	    		Thread.sleep(1000);
	    		driver.navigate().refresh();
	    		Thread.sleep(5000);
	    		
	    		Studioprofile.scrolldownm();
	    		String afterviewstr=Streaming.viewcountm().get(i).getText();
	    		String afterviewstr1=afterviewstr.substring(0,afterviewstr.lastIndexOf(" "));
	    		int afterviewcount=Integer.parseInt(afterviewstr1);
	    		log.info("view count :" + afterviewcount);
	    		String aftergudstr=Streaming.gudcountm().get(i).getText();
	    		String aftergudstr1=aftergudstr.substring(0,aftergudstr.lastIndexOf(" "));
	    		int aftergudcount=Integer.parseInt(aftergudstr1);
	    		log.info("gud count :" + aftergudcount);
	    		assertEquals(viewcount+1,afterviewcount);
	    		assertEquals(aftergudcount,gudcount+1);
	    		break;
	    		}
	    		
	    	}
	    }
	    @Then("^Again play the same promo and dislike and now see the gud count$")
	    public void again_play_the_same_promo_and_dislike_and_now_see_the_gud_count() throws Throwable {
	    	Actions a=new Actions(driver);
	    	//Studioprofile.scrolldownm();
	    	for(int i=0;i<Streaming.promonamesm().size();i++)
	    	{
	    		if(Streaming.promonamesm().get(i).getText().equalsIgnoreCase(Streaming.inputs().getProperty("Promoname")))
	    		{
	    		String viewstr=Streaming.viewcountm().get(i).getText();
	    		String viewstr1=viewstr.substring(0,viewstr.lastIndexOf(" "));
	    		int viewcount=Integer.parseInt(viewstr1);
	    		log.info("view count :" + viewcount);
	    		
	    		String gudstr=Streaming.gudcountm().get(i).getText();
	    		String gudstr1=gudstr.substring(0,gudstr.lastIndexOf(" "));
	    		int gudcount=Integer.parseInt(gudstr1);
	    		log.info("gud count befroedislike :" + gudcount);
	    		String promoname=Streaming.promonamesm().get(i).getText();
	    		log.info(promoname);
	    		log.info(Streaming.shoorseriesnameonprmocardm().get(i).getText());
	    		a.moveToElement(Streaming.mousehoveronpromocardsm().get(i)).click().build().perform();
	    		videoandaudioPlayer.mousehoveronplayerm();
	    		String promonameonplayer=videoandaudioPlayer.promonameonplayerm().getText();
	    		log.info("Promoname on player:" + promonameonplayer);
	    		assertEquals(promonameonplayer,promoname);
	    		videoandaudioPlayer.clapsymbolinplayerm().click();
	    		videoandaudioPlayer.closeplayerm().click();
	    		Thread.sleep(1000);
	    		driver.navigate().refresh();
	    		Thread.sleep(5000);
	    		Studioprofile.scrolldownm();
	    		String afterviewstr=Streaming.viewcountm().get(i).getText();
	    		String afterviewstr1=afterviewstr.substring(0,afterviewstr.lastIndexOf(" "));
	    		int afterviewcount=Integer.parseInt(afterviewstr1);
	    		log.info("view count :" + afterviewcount);
	    		String aftergudstr=Streaming.gudcountm().get(i).getText();
	    		String aftergudstr1=aftergudstr.substring(0,aftergudstr.lastIndexOf(" "));
	    		int aftergudcount=Integer.parseInt(aftergudstr1);
	    		log.info("gud count afterdislike :" + aftergudcount);
	    		assertEquals(viewcount+1,afterviewcount);
	    		assertEquals(aftergudcount,gudcount-1);
	    		break;
	    		}
	    		
	    	}
	    }
	   
	    @Given("^To check gud and view count of promo from all promos page after like$")
	    public void to_check_gud_and_view_count_of_promo_from_all_promos_page_after_like() throws Throwable {
	    	Actions a = new Actions(driver);
			 Studioprofile.scrolldownm();
				Thread.sleep(1000);
				for (int j = 0; j < Streaming.streamingpagetitlesm().size(); j++) {
					if (Streaming.streamingpagetitlesm().get(j).getText()
							.equalsIgnoreCase(Streaming.inputs().getProperty("Title8"))) {
						a.moveToElement(Streaming.streamingpagetitlesm().get(j)).click().build().perform();
						Thread.sleep(1000);
						Studioprofile.scrolldownm();
						Thread.sleep(500);
						for(int i=0;i<Streaming.promonamesnpromopagem().size();i++)
				    	{
				    		if(Streaming.promonamesnpromopagem().get(i).getText().equalsIgnoreCase(Streaming.inputs().getProperty("Promoname")))
				    		{
				    		String viewstr=Streaming.viewcountnpromopagem().get(i).getText();
				    		String viewstr1=viewstr.substring(0,viewstr.lastIndexOf(" "));
				    		int viewcount=Integer.parseInt(viewstr1);
				    		log.info("view count :" + viewcount);
				    		
				    		String gudstr=Streaming.gudcountm().get(i).getText();
				    		String gudstr1=gudstr.substring(0,gudstr.lastIndexOf(" "));
				    		int gudcount=Integer.parseInt(gudstr1);
				    		log.info("gud count :" + gudcount);
				    		
				    		String promoname=Streaming.promonamesnpromopagem().get(i).getText();
				    		log.info(promoname);

				    		a.moveToElement(Streaming.mousehoveronpromocardsm().get(i)).click().build().perform();
				    		videoandaudioPlayer.mousehoveronplayerm();
				    		String promonameonplayer=videoandaudioPlayer.promonameonplayerm().getText();
				    		log.info("Promoname on player:" + promonameonplayer);
				    		assertEquals(promonameonplayer,promoname);
				    		videoandaudioPlayer.clapsymbolinplayerm().click();
				    		videoandaudioPlayer.closeplayerm().click();
				    		driver.navigate().refresh();
				    		Thread.sleep(5000);
				    		Studioprofile.scrolldownm();
				    		a.moveToElement(Streaming.streamingpagetitlesm().get(j)).click().build().perform();
				    		Studioprofile.scrolldownm();
				    		String afterviewstr=Streaming.viewcountnpromopagem().get(i).getText();
				    		String afterviewstr1=afterviewstr.substring(0,afterviewstr.lastIndexOf(" "));
				    		int afterviewcount=Integer.parseInt(afterviewstr1);
				    		log.info("view count :" + afterviewcount);
				    		String aftergudstr=Streaming.gudcountm().get(i).getText();
				    		String aftergudstr1=aftergudstr.substring(0,aftergudstr.lastIndexOf(" "));
				    		int aftergudcount=Integer.parseInt(aftergudstr1);
				    		log.info("gud count :" + aftergudcount);
				    		assertEquals(viewcount+1,afterviewcount);
				    		assertEquals(aftergudcount,gudcount+1);
				    		break;
				    		}
				    		
				    	}
					}
				}	
	    }

	    @Then("^To check gud and view count of promo from all promos page after dislike$")
	    public void to_check_gud_and_view_count_of_promo_from_all_promos_page_after_dislike() throws Throwable {
	    	Actions a = new Actions(driver);
			 Studioprofile.scrolldownm();
				
						for(int i=0;i<Streaming.promonamesnpromopagem().size();i++)
				    	{
				    		if(Streaming.promonamesnpromopagem().get(i).getText().equalsIgnoreCase(Streaming.inputs().getProperty("Promoname")))
				    		{
				    		String viewstr=Streaming.viewcountnpromopagem().get(i).getText();
				    		String viewstr1=viewstr.substring(0,viewstr.lastIndexOf(" "));
				    		int viewcount=Integer.parseInt(viewstr1);
				    		log.info("view count :" + viewcount);
				    		String gudstr=Streaming.gudcountm().get(i).getText();
				    		String gudstr1=gudstr.substring(0,gudstr.lastIndexOf(" "));
				    		int gudcount=Integer.parseInt(gudstr1);
				    		log.info("gud count befroedislike :" + gudcount);
				    		String promoname=Streaming.promonamesnpromopagem().get(i).getText();
				    		log.info(promoname);
				    		a.moveToElement(Streaming.mousehoveronpromocardsm().get(i)).click().build().perform();
				    		videoandaudioPlayer.mousehoveronplayerm();
				    		String promonameonplayer=videoandaudioPlayer.promonameonplayerm().getText();
				    		log.info("Promoname on player:" + promonameonplayer);
				    		assertEquals(promonameonplayer,promoname);
				    		videoandaudioPlayer.clapsymbolinplayerm().click();
				    		videoandaudioPlayer.closeplayerm().click();
				    		driver.navigate().refresh();
				    		Thread.sleep(5000);
				    		Studioprofile.scrolldownm();
				    		Thread.sleep(1000);
				  
							for (int j = 0; j < Streaming.streamingpagetitlesm().size(); j++) {
								if (Streaming.streamingpagetitlesm().get(j).getText()
										.equalsIgnoreCase(Streaming.inputs().getProperty("Title8"))) {
									a.moveToElement(Streaming.streamingpagetitlesm().get(j)).click().build().perform();
									Studioprofile.scrolldownm();
									Thread.sleep(1000);
				    		String afterviewstr=Streaming.viewcountnpromopagem().get(i).getText();
				    		String afterviewstr1=afterviewstr.substring(0,afterviewstr.lastIndexOf(" "));
				    		int afterviewcount=Integer.parseInt(afterviewstr1);
				    		log.info("view count :" + afterviewcount);
				    		String aftergudstr=Streaming.gudcountm().get(i).getText();
				    		String aftergudstr1=aftergudstr.substring(0,aftergudstr.lastIndexOf(" "));
				    		int aftergudcount=Integer.parseInt(aftergudstr1);
				    		log.info("gud count afterdislike :" + aftergudcount);
				    		assertEquals(viewcount+1,afterviewcount);
				    		assertEquals(aftergudcount,gudcount-1);
				    		break;
				    		}	
				    	}		
					} 		
		    	}	
	        }
	    public static int followcountonstreaming;
	    @When("^Click on follow and followers count should increase by one$")
	    public void click_on_follow_and_followers_count_should_increase_by_one() throws Throwable {
	    	driver.navigate().back();
	    	Thread.sleep(3000);
	    	Actions a=new Actions(driver);
	        Studioprofile.scrolldownm();
	       
	    	
			for (int i = 0; i < Streaming.studiocardsm().size(); i++) {
				for (int j = 0; j < Streaming.streamingpagetitlesm().size(); j++) {
					if (Streaming.streamingpagetitlesm().get(j).getText()
							.equalsIgnoreCase(Streaming.inputs().getProperty("Title4"))) {
						a.moveToElement(Streaming.streamingpagetitlesm().get(j)).build().perform();
						Thread.sleep(500);
						a.moveToElement(Streaming.nextarrowm().get(j)).click().build().perform();

						if (Streaming.studionamem().get(i).getText()
								.equalsIgnoreCase(Streaming.inputs().getProperty("Studioname"))) {
							a.moveToElement(Streaming.followbuttonm().get(i)).click().build().perform();
			        		log.info(Toastanderrormessages.toastmessagem().getText());
			        		assertEquals(Toastanderrormessages.toastmessagem().getText(),Streaming.inputs().getProperty("Toastermessageforfollowstudio"));
							
							assertEquals(Streaming.studionamem().get(i).getText(),Streaming.inputs().getProperty("Studioname"));
							String str=Streaming.followerscountm().get(i).getText();
							String str1=str.substring(0,str.lastIndexOf(" "));
							followcountonstreaming=Integer.parseInt(str1);
							log.info(followcountonstreaming);
							a.moveToElement(Streaming.studionamem().get(i)).click().build().perform();
                             break;
						}
						break;
						
					}
					
				}
			}
	    	
	      
	    }
	   
	    @Given("^Click on the studio name check its redirecting to correct page$")
	    public void click_on_the_studio_name_check_its_redirecting_to_correct_page() throws Throwable {
	    	
	    	Actions a =new Actions(driver);
	    	int followcountonstreaming=0;
	    	Studioprofile.scrolldownm();
			for (int i = 0; i < Streaming.studiocardsm().size(); i++) {
				for (int j = 0; j < Streaming.streamingpagetitlesm().size(); j++) {
					if (Streaming.streamingpagetitlesm().get(j).getText()
							.equalsIgnoreCase(Streaming.inputs().getProperty("Title4"))) {
						a.moveToElement(Streaming.streamingpagetitlesm().get(j)).build().perform();
						Thread.sleep(500);
						a.moveToElement(Streaming.nextarrowm().get(j)).click().build().perform();

						if (Streaming.studionamem().get(i).getText()
								.equalsIgnoreCase(Streaming.inputs().getProperty("Studioname"))) {

							a.moveToElement(Streaming.studionamem().get(i)).click().build().perform();
							assertEquals(Streaming.studionamem().get(i).getText(),Streaming.inputs().getProperty("Studioname"));
							String str=Streaming.followerscountm().get(i).getText();
							String str1=str.substring(0,str.lastIndexOf(" "));
							followcountonstreaming=Integer.parseInt(str1);
							log.info(followcountonstreaming);
                             break;
						}
						break;
					}
					
				}
			}
	    	
	    	Thread.sleep(2000);
	    	String str1=Studioprofile.followerscountm().getText();
	    	//String str2=StringUtils.replace(str1, "\n", " ");
	    	String str2=str1.replaceAll("[\\n\\t ]", " ");
	    	String str3=str2.substring(0,str2.lastIndexOf(" "));
	    	int followcount=Integer.parseInt(str3);
	    	log.info(followcount);
	    	assertEquals(followcountonstreaming,followcount);
	    	
	    }
	    public int followcountonstudiodetailpage;
	    @Then("^Click on same studio and check the followers count on the studio profile page$")
	    public void click_on_same_studio_and_check_the_followers_count_on_the_studio_profile_page() throws Throwable {
	    	
	    	
	    	Thread.sleep(1000);
	    	driver.navigate().refresh();
	    	Thread.sleep(5000);
	    	String str1=Studioprofile.followerscountm().getText();
	    	//String str2=StringUtils.replace(str1, "\n", " ");
	    	String str2=str1.replaceAll("[\\n\\t ]", " ");
	    	String str3=str2.substring(0,str2.lastIndexOf(" "));
	    	followcountonstudiodetailpage=Integer.parseInt(str3);
	    	log.info(followcountonstudiodetailpage);
	    	assertEquals(Studioprofile.followingtextm().getText(),"Following");
	    	assertEquals(followcountonstreaming,followcountonstudiodetailpage);
	    }

	    @Then("^check on streaming page also the count should decrease and button should change$")
	    public void check_on_streaming_page_also_the_count_should_decrease_and_button_should_change() throws Throwable {
	    	Actions a=new Actions(driver);
	    	driver.navigate().back();
	    	Thread.sleep(1000);
	    	driver.navigate().refresh();
	        Studioprofile.scrolldownm();
	        Thread.sleep(5000);
	    	
			for (int i = 0; i < Streaming.studiocardsm().size(); i++) {
				for (int j = 0; j < Streaming.streamingpagetitlesm().size(); j++) {
					if (Streaming.streamingpagetitlesm().get(j).getText()
							.equalsIgnoreCase(Streaming.inputs().getProperty("Title4"))) {
						a.moveToElement(Streaming.streamingpagetitlesm().get(j)).build().perform();
						Thread.sleep(500);
						a.moveToElement(Streaming.nextarrowm().get(j)).click().build().perform();

						if (Streaming.studionamem().get(i).getText()
								.equalsIgnoreCase(Streaming.inputs().getProperty("Studioname"))) {
							assertEquals(Streaming.studionamem().get(i).getText(),Streaming.inputs().getProperty("Studioname"));
							String str=Streaming.followerscountm().get(i).getText();
							String str1=str.substring(0,str.lastIndexOf(" "));
							int afterunfollowcountonstreaming=Integer.parseInt(str1);
							log.info(afterunfollowcountonstreaming);
							assertEquals(afterunfollowcountonstreaming,followcountonstreaming-1);
							String str4=Streaming.followbuttonm().get(i).getText();
					    	//String str5=StringUtils.replace(str4, "\n", " ");
							String str5=str4.replaceAll("[\\n\\t ]", " ");
					    	//String str6=str5.substring(0,str5.lastIndexOf(" "));
					    	assertEquals(str5,"add Follow");
                             break;
						}
						break;
						
					}
					
				}
			}
	    	
	      
	    }

	    @And("^unfollow the same studio from studio page and check the count should decrease$")
	    public void unfollow_the_same_studio_from_studio_page_and_check_the_count_should_decrease() throws Throwable {
	    	Thread.sleep(1000);
	        //JavascriptExecutor js=(JavascriptExecutor)driver;
	       // js.executeScript("arguments[0].click();", Studioprofile.studioinfom());
	    	Actions a=new Actions(driver);
	    	a.moveToElement(Studioprofile.studioinfom()).click().build().perform();
	    	Thread.sleep(700);
	    	a.moveToElement(Studioprofile.unfollowstudiom()).click().build().perform();
	    	Thread.sleep(700);
	    	a.moveToElement(Studioprofile.unfollowbuttonm()).click().build().perform();
	    	Thread.sleep(500);
	        log.info(Toastanderrormessages.toastmessagem().getText());
    		assertEquals(Toastanderrormessages.toastmessagem().getText(),Streaming.inputs().getProperty("Toastermessageforunfollowstudio"));
    		Thread.sleep(1000);
    		String str1=Studioprofile.followerscountm().getText();
	    	//String str2=StringUtils.replace(str1, "\n", " ");
    		String str2=str1.replaceAll("[\\n\\t ]", " ");
	    	String str3=str2.substring(0,str2.lastIndexOf(" "));
	    	int afterunfollowcountonstudiodetailpage=Integer.parseInt(str3);
	    	log.info(afterunfollowcountonstudiodetailpage);
	    	String str4=Studioprofile.followingtextm().getText();
	    	//String str5=StringUtils.replace(str4, "\n", " ");
	    	String str5=str4.replaceAll("[\\n\\t ]", " ");
	    	//String str6=str5.substring(0,str5.lastIndexOf(" "));
	    	assertEquals(str5,"add Follow");
	    	assertEquals(followcountonstreaming-1,afterunfollowcountonstudiodetailpage);
	    	
	    }
	    @Given("^Play any audio and check player opend and audio is playing$")
	    public void play_any_audio_and_check_player_opend_and_audio_is_playing() throws Throwable {
	    	Actions a=new Actions(driver);
	        Studioprofile.scrolldownm();
	        for(int k=0;k< Streaming.audionamesm().size();k++)
	        {
	        	if(Streaming.audionamesm().get(k).getText().equalsIgnoreCase(Streaming.inputs().getProperty("Audioname")))
	        	{
	        		a.moveToElement(Streaming.audionamesm().get(k)).click().build().perform();
	        		assertEquals(Streaming.audionamesm().get(k).getText(),Streaming.inputs().getProperty("Audioname"));
	        		assertEquals(Streaming.composernamem().get(k).getText(),Streaming.inputs().getProperty("Composername"));
	        		break;
	        	}
	        }
	        
	        assertTrue(videoandaudioPlayer.gudshoiconinaudioplayerm().isDisplayed());
	        assertEquals(Streaming.inputs().getProperty("Audioname"),videoandaudioPlayer.audionameonplayerm());
	        assertEquals(videoandaudioPlayer.compsernameonplayerm().getText(),Streaming.inputs().getProperty("Composername"));
	    }

	    @When("^Play next and previous song and check its playing correctly$")
	    public void play_next_and_previous_song_and_check_its_playing_correctly() throws Throwable {
	        videoandaudioPlayer.nexticononplayerm().click();
	        Thread.sleep(500);
	        assertTrue(Streaming.inputs().getProperty("Nextsong").equalsIgnoreCase(videoandaudioPlayer.audionameonplayerm().getText()));
	        assertTrue(videoandaudioPlayer.compsernameonplayerm().getText().equalsIgnoreCase(Streaming.inputs().getProperty("Nextsongomposername")));
	        videoandaudioPlayer.previousicononplayerm().click();
	        Thread.sleep(500);
	        assertTrue(Streaming.inputs().getProperty("Previoussong").equalsIgnoreCase(videoandaudioPlayer.audionameonplayerm().getText()));
	        assertTrue(videoandaudioPlayer.compsernameonplayerm().getText().equalsIgnoreCase(Streaming.inputs().getProperty("Previoussongcomposername")));
	    }

	    @Then("^Click fav and check its marked in to fav$")
	    public void click_fav_and_check_its_marked_in_to_fav() throws Throwable {
	        videoandaudioPlayer.heartsymbolm().click();
	        log.info(videoandaudioPlayer.unfavouratetextm().getText());
	        assertEquals(videoandaudioPlayer.unfavouratetextm().getText(),"Un Favorite");
	        videoandaudioPlayer.heartsymbolm().click();
	        log.info(videoandaudioPlayer.addfavoraitetextm().getText());
	        assertEquals(videoandaudioPlayer.addfavoraitetextm().getText(),"Add Favorite");
	        videoandaudioPlayer.closeaudioplayerm().click();

	    }

	    @Given("^Click on pagetitle to redirect the all songs page$")
	    public void click_on_pagetitle_to_redirect_the_all_songs_page() throws Throwable {
	        Studioprofile.scrolldownm();
	        for(int i=0;i<Streaming.streamingpagetitlesm().size();i++)
	        {
	        	if(Streaming.streamingpagetitlesm().get(i).getText().equalsIgnoreCase(Streaming.inputs().getProperty("Title7")))
	        	{
	        		Streaming.streamingpagetitlesm().get(i).click();
	        		break;
	        	}
	        	
	        }
	      
	    }
	    
	    

	    @Given("^Share the promo by facebook from streaming page$")
	    public void share_the_promo_by_facebook_from_streaming_page() throws Throwable {
	    	Studioprofile.scrolldownm();
	    	Actions a=new Actions(driver);
	    	//Thread.sleep(2000);
	        for(int i=0;i<Streaming.promonamesm().size();i++)
	        {
	        	if(Streaming.promonamesm().get(i).getText().equalsIgnoreCase(Streaming.inputs().getProperty("Promoname"))) {
	        		//assertEquals(Streaming.promoshareiconm().get(i).getText(),Streaming.inputs().getProperty("Promoname"));
	        		a.moveToElement(Streaming.promoshareiconm().get(i)).click().build().perform();
	        		
	        	}
	        }
	        Shareandfollow.facebooksharem();
	        Shareandfollow.facebookwindowhandle();
	    }

	    @Then("^Share the promos by twitter from streaming page$")
	    public void share_the_promos_by_twitter_from_streaming_page() throws Throwable {
	        Shareandfollow.twittersharem();
	        Shareandfollow.twitterwindowhandle();
	    
	    }

	    @Then("^Share the promos by whatsapp from streaming page$")
	    public void share_the_promos_by_whatsapp_from_streaming_page() throws Throwable {
	        Shareandfollow.whatsappsharem();
	        Shareandfollow.whatsappswindowhandle();
	    
	    }

	    @Then("^Share the promos by copylink from streaming page$")
	    public void share_the_promos_by_copylink_from_streaming_page() throws Throwable {
	        Shareandfollow.copylinksharem();
	        assertEquals(Toastanderrormessages.toastmessagem().getText(),"Link Copied!");
	    
	    }
	    @Given("^Click on all promos title and facebook share$")
	    public void click_on_all_promos_title_and_facebook_share() throws Throwable {
	    	Actions a = new Actions(driver);
			 Studioprofile.scrolldownm();
				Thread.sleep(1000);
				for (int j = 0; j < Streaming.streamingpagetitlesm().size(); j++) {
					if (Streaming.streamingpagetitlesm().get(j).getText()
							.equalsIgnoreCase(Streaming.inputs().getProperty("Title8"))) {
						a.moveToElement(Streaming.streamingpagetitlesm().get(j)).click().build().perform();
						Studioprofile.scrolldownm();
						for(int i=0;i<Streaming.promonamesnpromopagem().size();i++)
				    	{
				    		if(Streaming.promonamesnpromopagem().get(i).getText().equalsIgnoreCase(Streaming.inputs().getProperty("Promoname")))
				    		{
				    			a.moveToElement(Streaming.promoshareiconm().get(i)).click().build().perform();
				        		break;
				    		}
				    	}
						break;
					}	
				}
				Shareandfollow.facebooksharem();
				Shareandfollow.facebookwindowhandle();
	    }

	    @Given("^Share the audio by facebook from streaming page$")
	    public void share_the_audio_by_facebook_from_streaming_page() throws Throwable {
	    	Actions a=new Actions(driver);
	        Studioprofile.scrolldownm();
	        for(int k=0;k< Streaming.audionamesm().size();k++)
	        {
	        	if(Streaming.audionamesm().get(k).getText().equalsIgnoreCase(Streaming.inputs().getProperty("Audioname")))
	        	{
	        		a.moveToElement(Streaming.audionamesm().get(k)).click().build().perform();
	        		assertEquals(Streaming.audionamesm().get(k).getText(),Streaming.inputs().getProperty("Audioname"));
	        		break;
	        	}
	        }
	    		Shareandfollow.audiosharem();
	    		Thread.sleep(500);
	    		assertTrue(videoandaudioPlayer.gudshoiconinaudioplayerm().isDisplayed());
	    		Shareandfollow.facebooksharem();
	    		Shareandfollow.facebookwindowhandle();
	    	
	    }

	    @Then("^Share the audio by twitter from streaming page$")
	    public void share_the_audio_by_twitter_from_streaming_page() throws Throwable {
	    	Shareandfollow.twittersharem();
    		Shareandfollow.twitterwindowhandle();
	    }

	    @Then("^Share the audio by whatsapp from streaming page$")
	    public void share_the_audio_by_whatsapp_from_streaming_page() throws Throwable {
	    	Shareandfollow.whatsappsharem();
    		Shareandfollow.whatsappswindowhandle();
    		
	    }

	    @Then("^Share the audio by copylink from streaming page$")
	    public void share_the_audio_by_copylink_from_streaming_page() throws Throwable {
	        Shareandfollow.copylinksharem();
	        assertEquals(Toastanderrormessages.toastmessagem().getText(),"Link Copied!");
	    }
	    @Given("^click on all audios andShare the audio by facebook$")
	    public void click_on_all_audios_andshare_the_audio_by_facebook() throws Throwable {
	    	 Studioprofile.scrolldownm();
		        for(int i=0;i<Streaming.streamingpagetitlesm().size();i++)
		        {
		        	if(Streaming.streamingpagetitlesm().get(i).getText().equalsIgnoreCase(Streaming.inputs().getProperty("Title7")))
		        	{
		        		Streaming.streamingpagetitlesm().get(i).click();
		        		Actions a=new Actions(driver);
		    	        Studioprofile.scrolldownm();
		    	        for(int k=0;k< Streaming.audionamesm().size();k++)
		    	        {
		    	        	if(Streaming.audionamesm().get(k).getText().equalsIgnoreCase(Streaming.inputs().getProperty("Audioname")))
		    	        	{
		    	        		a.moveToElement(Streaming.audionamesm().get(k)).click().build().perform();
		    	        		assertEquals(Streaming.audionamesm().get(k).getText(),Streaming.inputs().getProperty("Audioname"));
		    	        		break;
		    	        	}
		    	        }
		    	    		Shareandfollow.audiosharem();
		    	    		Thread.sleep(500);
		    	    		assertTrue(videoandaudioPlayer.gudshoiconinaudioplayerm().isDisplayed());
		    	    		Shareandfollow.facebooksharem();
		    	    		Shareandfollow.facebookwindowhandle();
		    	    	
		        		break;
		        	}
		        	
		        }
		       
	    }

	    @Given("^Add to watch list from streaming page$")
	    public void add_to_watch_list_from_streaming_page() throws Throwable {
	    	Actions a =new Actions(driver);
	        Studioprofile.scrolldownm();
	        for(int i=0;i< Streaming.shocardnamesm().size();i++)
	        {
	        	if(Streaming.shocardnamesm().get(i).getText().equalsIgnoreCase(Streaming.inputs().getProperty("Shoorseriesname")))
	        	{
	        		String str=Streaming.shocardnamesm().get(i).getText();
	        		log.info(str);
	        		a.moveToElement(Streaming.shocardsm().get(i)).build().perform();
	        		Thread.sleep(500);
	        		assertEquals(Streaming.Shonameonshocardsm().get(i).getText(),str);
	        		assertEquals(Streaming.shoorserieslabelonshocardsm().get(i).getText(),Streaming.inputs().getProperty("Shoorserieslabeloncard"));
	        		assertEquals(Streaming.generenameonshocardm().get(i).getText(),Streaming.inputs().getProperty("Generenameonshocard"));
	        		assertEquals(Streaming.maturityratingonshocardm().get(i).getText(),Streaming.inputs().getProperty("Maturityratingoncard"));
	        		assertEquals(Streaming.videodurationm().get(i).getText(),Streaming.inputs().getProperty("Videodurationoncard"));
	        		Streaming.watchlistbuttonm().get(i).click();
	        		Thread.sleep(1000);
	        		log.info(str+" "+"has been added to watchlist");
	    	        assertEquals(Toastanderrormessages.toastmessagem().getText(),str+" "+"has been added to watchlist");
	    	        Toastanderrormessages.toastmessageclosem().click();
	    	       
	    	        break;
	        	}
	        }
	    
	 }
	    @Then("^remove from watch list$")
	    public void remove_from_watch_list() throws Throwable {
	    	Actions a =new Actions(driver);
	       // Studioprofile.scrolldownm();
	        for(int i=0;i< Streaming.shocardnamesm().size();i++)
	        {
	        	if(Streaming.shocardnamesm().get(i).getText().equalsIgnoreCase(Streaming.inputs().getProperty("Shoorseriesname")))
	        	{
	        		String str=Streaming.shocardnamesm().get(i).getText();
	        		log.info(str);
	        		a.moveToElement(Streaming.shocardsm().get(i)).build().perform();
	        		Streaming.watchlistbuttonm().get(i).click();
	        		Thread.sleep(1000);
	        		log.info(Toastanderrormessages.toastmessagem().getText());
	        		log.info(str+" "+"has been added to watchlist");
	    	        assertEquals(Toastanderrormessages.toastmessagem().getText(),str+" "+"has been removed from watchlist");
	    	        Toastanderrormessages.toastmessageclosem().click();
	    	        
	    	        break;
	        	}
	        }
	    }
	    @Given("^Add to watch list from streaming page from particular row$")
	    public void add_to_watch_list_from_streaming_page_from_particular_row() throws Throwable {
	    	Actions a=new Actions(driver);
	        Studioprofile.scrolldownm();
	       for(int i=0;i<Streaming.streamingpagetitlesm().size();i++)
	        {
	        	if(Streaming.streamingpagetitlesm().get(i).getText().equalsIgnoreCase(Streaming.inputs().getProperty("Title5")))
	        	{
	        		while(!Streaming.nextarrowm().get(i).getAttribute("aria-disabled").equalsIgnoreCase("true"))
	        		{
	        			a.moveToElement(Streaming.nextarrowm().get(i)).click().build().perform();
	        		}
	        		for(int j=0;j<Streaming.shocardnamesm().size();j++)
	        		{
	        			if(Streaming.shocardnamesm().get(j).getText().equalsIgnoreCase(Streaming.inputs().getProperty("Shoorseriesname1")))
	        			{
	        			String str=Streaming.shocardnamesm().get(j).getText();
	        		    a.moveToElement(Streaming.shocardsm().get(j)).build().perform();
	        		    Thread.sleep(1000);
	        		    log.info(Streaming.Shonameonshocardsm().get(j).getText());
	        		    assertEquals(Streaming.Shonameonshocardsm().get(j).getText(),str);
	        		    Thread.sleep(500);
	        		    Streaming.watchlistbuttonm().get(j).click();
		    	        assertEquals(Toastanderrormessages.toastmessagem().getText(),str+" "+"has been added to watchlist");
		    	        Toastanderrormessages.toastmessageclosem().click();
		    	        
		    	        break;
	        			}
	        	}
	        		break;
	          }
	        }
	    }

	    @Then("^remove from watch list from particular row$")
	    public void remove_from_watch_list_from_particular_row() throws Throwable {
	    	Actions a=new Actions(driver);
	    	for(int j=0;j<Streaming.shocardnamesm().size();j++)
    		{
    			if(Streaming.shocardnamesm().get(j).getText().equalsIgnoreCase(Streaming.inputs().getProperty("Shoorseriesname1")))
    			{
    			String str=Streaming.shocardnamesm().get(j).getText();
    		    a.moveToElement(Streaming.shocardsm().get(j)).build().perform();
    		    Thread.sleep(500);
    		    Streaming.watchlistbuttonm().get(j).click();
    		    log.info(Toastanderrormessages.toastmessagem().getText());
    	        assertEquals(Toastanderrormessages.toastmessagem().getText(),str+" "+"has been removed from watchlist");
    	        Toastanderrormessages.toastmessageclosem().click();
    	       
    	        break;
    			}
    	   }
	    }
	    @Given("^Add to watch list from streaming page from particular row from all sho or series page$")
	    public void add_to_watch_list_from_streaming_page_from_particular_row_from_all_sho_or_series_page() throws Throwable {
	    	Actions a=new Actions(driver);
	        Studioprofile.scrolldownm();
	        for(int i=0;i<Streaming.streamingpagetitlesm().size();i++)
	        {
	        	if(Streaming.streamingpagetitlesm().get(i).getText().equalsIgnoreCase(Streaming.inputs().getProperty("Title5")))
	        	{
	        		a.moveToElement(Streaming.streamingpagetitlesm().get(i)).click().build().perform();
	        		
	        	Studioprofile.scrolldownm();
	        	Thread.sleep(1000);
	        	for(int j=0;j<Streaming.shocardnamesm().size();j++)
        		{
        			if(Streaming.shocardnamesm().get(j).getText().equalsIgnoreCase(Streaming.inputs().getProperty("Shoorseriesname1")))
        			{
        			String str=Streaming.shocardnamesm().get(j).getText();
        		    a.moveToElement(Streaming.shocardsm().get(j)).build().perform();
        		    Thread.sleep(1000);
        		    assertEquals(Streaming.Shonameonshocardsm().get(j).getText(),str);
        		    Streaming.watchlistbuttonm().get(j).click();
        		    log.info(Toastanderrormessages.toastmessagem().getText());
	        		log.info(str+" "+"has been added to watchlist");
	    	        assertEquals(Toastanderrormessages.toastmessagem().getText(),str+" "+"has been added to watchlist");
	    	        Toastanderrormessages.toastmessageclosem().click();
	    	        
	    	        break;
        			}
        		}
	        	break;
	        }	
	    }
	}
	    @Then("^remove from watch list from particular row from all page$")
	    public void remove_from_watch_list_from_particular_row_from_all_page() throws Throwable {
	    	Actions a=new Actions(driver);
	    	for(int j=0;j<Streaming.shocardnamesm().size();j++)
    		{
    			if(Streaming.shocardnamesm().get(j).getText().equalsIgnoreCase(Streaming.inputs().getProperty("Shoorseriesname1")))
    			{
    			String str=Streaming.shocardnamesm().get(j).getText();
    		    a.moveToElement(Streaming.shocardsm().get(j)).build().perform();
    		    Thread.sleep(500);
    		    Streaming.watchlistbuttonm().get(j).click();
    	        assertEquals(Toastanderrormessages.toastmessagem().getText(),str+" "+"has been removed from watchlist");
    	        Toastanderrormessages.toastmessageclosem().click();
    	       
    	        break;
    			}
    	   }
	    }
	    @Given("^Remove the continue watching from the streaming page$")
	    public void remove_the_continue_watching_from_the_streaming_page() throws Throwable {
	    	Thread.sleep(3000);
	    	Actions a=new Actions(driver);
	        log.info(Streaming.streamingpagetitlesm().get(0).getText());
	        assertEquals(Streaming.streamingpagetitlesm().get(0).getText(),"Continue Watching");
	        assertTrue(Streaming.streamingpagetitlesm().get(0).isDisplayed());
	        a.moveToElement(Streaming.streamingpagetitlesm().get(0)).build().perform();
	        if(Streaming.nextarrowm().get(0).isDisplayed())
	        {
	           while(!Streaming.nextarrowm().get(0).getAttribute("aria-disabled").equalsIgnoreCase("true"))
    		   {
    			   a.moveToElement(Streaming.nextarrowm().get(0)).click().build().perform();
    		   }
	        }
	        
	        for(int i=0;i<Streaming.shoorspisoesnameincontinuewatchingm().size();i++)
	        {
	        	
	        	if(Streaming.shoorspisoesnameincontinuewatchingm().get(i).getText().equalsIgnoreCase(Streaming.inputs().getProperty("Removefromcontinewatching")))
	        	{
	        		String str=Streaming.shoorspisoesnameincontinuewatchingm().get(i).getText();
	        		log.info(str);
	        		assertEquals(Streaming.shoorspisoesnameincontinuewatchingm().get(i).getText(),Streaming.inputs().getProperty("Removefromcontinewatching"));
	        		a.moveToElement(Streaming.continuewatchingcadsm().get(i)).build().perform();
	        		a.moveToElement(Streaming.crossicononcontinuewatchingm().get(i)).click().build().perform();
	        		log.info(Toastanderrormessages.toastmessagem().getText());
	    	        assertEquals(str+" "+"has been removed",Toastanderrormessages.toastmessagem().getText());
	        	}
	        }
	    }
	    @Then("^check the removed sho or episode should not visible again in continue watching$")
	    public void check_the_removed_sho_or_episode_should_not_visible_again_in_continue_watching() throws Throwable {
	    	Thread.sleep(3000);
	    	Actions a=new Actions(driver);
	        log.info(Streaming.streamingpagetitlesm().get(0).getText());
	        assertEquals(Streaming.streamingpagetitlesm().get(0).getText(),"Continue Watching");
	        assertTrue(Streaming.streamingpagetitlesm().get(0).isDisplayed());
	        a.moveToElement(Streaming.streamingpagetitlesm().get(0)).build().perform();
	        if(Streaming.nextarrowm().get(0).isDisplayed())
	        {
	           while(!Streaming.nextarrowm().get(0).getAttribute("aria-disabled").equalsIgnoreCase("true"))
    		   {
    			   a.moveToElement(Streaming.nextarrowm().get(0)).click().build().perform();
    		   }
	        }
	        String str = null;
	        for(int i=0;i<Streaming.shoorspisoesnameincontinuewatchingm().size();i++)
	        {
	        	
	        	if(Streaming.shoorspisoesnameincontinuewatchingm().get(i).getText().equalsIgnoreCase(Streaming.inputs().getProperty("Removefromcontinewatching")))
	        	{
	        		str=Streaming.shoorspisoesnameincontinuewatchingm().get(i).getText();
	        		log.info(str);
	        		assertEquals(Streaming.shoorspisoesnameincontinuewatchingm().get(i).getText(),Streaming.inputs().getProperty("Removefromcontinewatching"));
	        		a.moveToElement(Streaming.continuewatchingcadsm().get(i)).build().perform();
	        		a.moveToElement(Streaming.crossicononcontinuewatchingm().get(i)).click().build().perform();
	        		log.info(Toastanderrormessages.toastmessagem().getText());
	    	        assertEquals(str+" "+"has been removed",Toastanderrormessages.toastmessagem().getText());
	        	}
	        	else
	        	{
	        		String str1=null;
	        		assertEquals(str1,str);
	        		
	        	}
	        }	
	    }
        public String shoorepisodename;
	    @Given("^click on any sho or episode card on continue watching$")
	    public void click_on_any_sho_or_episode_card_on_continue_watching() throws Throwable {
	    	Actions a=new Actions(driver);
	    
	    	for(int i=0;i<Streaming.shoorspisoesnameincontinuewatchingm().size();i++)
	        {
	        	
	        	if(Streaming.shoorspisoesnameincontinuewatchingm().get(i).getText().equalsIgnoreCase(Streaming.inputs().getProperty("Continuewatchingredirection")))
	        	{
	        		shoorepisodename=Streaming.shoorspisoesnameincontinuewatchingm().get(i).getText();
	        		log.info(shoorepisodename);
	        		assertEquals(Streaming.shoorspisoesnameincontinuewatchingm().get(i).getText(),Streaming.inputs().getProperty("Continuewatchingredirection"));
	        		a.moveToElement(Streaming.continuewatchingcadsm().get(i)).click().build().perform();
	        		Thread.sleep(7000);
	        		
	        	}
	        }	
	    }

	    @Then("^Check the redirected correctly or not$")
	    public void check_the_redirected_correctly_or_not() throws Throwable {
	    	videoandaudioPlayer.mousehoveronplayerm();
	    	
	        assertTrue(videoandaudioPlayer.shoseriesnameonplayerm().getText().equalsIgnoreCase(shoorepisodename));
	        videoandaudioPlayer.closeplayerm().click();
	    }
	    
	
	
	
	
	
	
	
	
	
}	
	







































































	
	/* @Given("^To check the promo is playing from particular row and like the promo and check view and gud count$")
	    public void to_check_the_promo_is_playing_from_particular_row_and_like_the_promo_and_check_view_and_gud_count() throws Throwable {
	    	Actions a=new Actions(driver);
	    	Studioprofile.scrolldownm();
	    	for (int j = 0; j < Streaming.streamingpagetitlesm().size(); j++) {
				if (Streaming.streamingpagetitlesm().get(j).getText()
						.equalsIgnoreCase(Streaming.inputs().getProperty("Title8"))) {
					for(int i=0;i<Streaming.promonamesm().size();i++)
			    	{
			    		if(Streaming.promonamesm().get(i).getText().equalsIgnoreCase(Streaming.inputs().getProperty("Promoname")))
			    		{
			    		String viewstr=Streaming.viewcountm().get(i).getText();
			    		String viewstr1=viewstr.substring(0,viewstr.lastIndexOf(" "));
			    		int viewcount=Integer.parseInt(viewstr1);
			    		log.info("view count :" + viewcount);
			    		
			    		String gudstr=Streaming.gudcountm().get(i).getText();
			    		String gudstr1=gudstr.substring(0,gudstr.lastIndexOf(" "));
			    		int gudcount=Integer.parseInt(gudstr1);
			    		log.info("gud count :" + gudcount);
			    		
			    		String promoname=Streaming.promonamesm().get(i).getText();
			    		log.info(promoname);
			    		log.info(Streaming.shoorseriesnameonprmocardm().get(i).getText());
			    		a.moveToElement(Streaming.mousehoveronpromocardsm().get(i)).click().build().perform();
			    		videoandaudioPlayer.mousehoveronplayerm();
			    		String promonameonplayer=videoandaudioPlayer.promonameonplayerm().getText();
			    		log.info("Promoname on player:" + promonameonplayer);
			    		assertEquals(promonameonplayer,promoname);
			    		videoandaudioPlayer.clapsymbolinplayerm().click();
			    		videoandaudioPlayer.closeplayerm().click();
			    		Thread.sleep(1000);
			    		driver.navigate().refresh();
			    		Thread.sleep(2000);
			    		Studioprofile.scrolldownm();
			    		Thread.sleep(1000);
			    		String afterviewstr=Streaming.viewcountm().get(i).getText();
			    		String afterviewstr1=afterviewstr.substring(0,afterviewstr.lastIndexOf(" "));
			    		int afterviewcount=Integer.parseInt(afterviewstr1);
			    		log.info("view count :" + afterviewcount);
			    		String aftergudstr=Streaming.gudcountm().get(i).getText();
			    		String aftergudstr1=aftergudstr.substring(0,aftergudstr.lastIndexOf(" "));
			    		int aftergudcount=Integer.parseInt(aftergudstr1);
			    		log.info("gud count :" + aftergudcount);
			    		assertEquals(viewcount+1,afterviewcount);
			    		assertEquals(aftergudcount,gudcount+1);
			    		break;
			    		}
			    		
			    	}
				}
	    	}	
	    }
	    @Then("^Again play the promo and dislike the promo and check the view and gud count$")
	    public void again_play_the_promo_and_dislike_the_promo_and_check_the_view_and_gud_count() throws Throwable {
	    	Actions a=new Actions(driver);
	    	Studioprofile.scrolldownm();
	    	for (int j = 0; j < Streaming.streamingpagetitlesm().size(); j++) {
				if (Streaming.streamingpagetitlesm().get(j).getText()
						.equalsIgnoreCase(Streaming.inputs().getProperty("Title8"))) {
					for(int i=0;i<Streaming.promonamesm().size();i++)
			    	{
			    		if(Streaming.promonamesm().get(i).getText().equalsIgnoreCase(Streaming.inputs().getProperty("Promoname")))
			    		{
			    		String viewstr=Streaming.viewcountm().get(i).getText();
			    		String viewstr1=viewstr.substring(0,viewstr.lastIndexOf(" "));
			    		int viewcount=Integer.parseInt(viewstr1);
			    		log.info("view count :" + viewcount);
			    		String gudstr=Streaming.gudcountm().get(i).getText();
			    		String gudstr1=gudstr.substring(0,gudstr.lastIndexOf(" "));
			    		int gudcount=Integer.parseInt(gudstr1);
			    		log.info("gud count befroedislike :" + gudcount);
			    		String promoname=Streaming.promonamesm().get(i).getText();
			    		log.info(promoname);
			    		log.info(Streaming.shoorseriesnameonprmocardm().get(i).getText());
			    		a.moveToElement(Streaming.mousehoveronpromocardsm().get(i)).click().build().perform();
			    		videoandaudioPlayer.mousehoveronplayerm();
			    		String promonameonplayer=videoandaudioPlayer.promonameonplayerm().getText();
			    		log.info("Promoname on player:" + promonameonplayer);
			    		assertEquals(promonameonplayer,promoname);
			    		videoandaudioPlayer.clapsymbolinplayerm().click();
			    		videoandaudioPlayer.closeplayerm().click();
			    		Thread.sleep(1000);
			    		driver.navigate().refresh();
			    		Thread.sleep(2000);
			    		Studioprofile.scrolldownm();
			    		String afterviewstr=Streaming.viewcountm().get(i).getText();
			    		String afterviewstr1=afterviewstr.substring(0,afterviewstr.lastIndexOf(" "));
			    		int afterviewcount=Integer.parseInt(afterviewstr1);
			    		log.info("view count :" + afterviewcount);
			    		String aftergudstr=Streaming.gudcountm().get(i).getText();
			    		String aftergudstr1=aftergudstr.substring(0,aftergudstr.lastIndexOf(" "));
			    		int aftergudcount=Integer.parseInt(aftergudstr1);
			    		log.info("gud count afterdislike :" + aftergudcount);
			    		assertEquals(viewcount+1,afterviewcount);
			    		assertEquals(aftergudcount,gudcount-1);
			    		break;
			    		}
			    		
			    	}
				}
	    	}	
	    }
	
	
	/*for(String key : Streaming.inputs().stringPropertyNames()) {
		  String value = Streaming.inputs().getProperty(key);
		  System.out.println(key + " => " + value);
		  
		}*/
	    /*for(int i=0;i<Streaming.studiocardsm().size();i++)
        {
        	if(Streaming.studionamem().get(i).getText().equalsIgnoreCase(Streaming.inputs().getProperty("Studioname")))
        	{
        		String studioname=Streaming.studionamem().get(i).getText();
        		log.info(studioname);
        		assertEquals(studioname,Streaming.inputs().getProperty("Studioname"));
        		String str=Streaming.followerscountm().get(i).getText();
        		log.info(str);
        		String str1=str.substring(0,str.lastIndexOf(" "));
        		int followerscount=Integer.parseInt(str1);
        		log.info(followerscount);
        		a.moveToElement(Streaming.followbuttonm().get(i)).click().build().perform();
        		log.info(Toastanderrormessages.toastmessagem().getText());
        		assertEquals(Toastanderrormessages.toastmessagem().getText(),Streaming.inputs().getProperty("Toastermessageforfollowstudio"));
        		String str2=Streaming.followerscountm().get(i).getText();
        		String str3=str2.substring(0,str2.lastIndexOf(" "));
        		afterfollowerscount=Integer.parseInt(str3);
        		log.info(afterfollowerscount);
        		assertEquals(followerscount+1,afterfollowerscount);
        		a.moveToElement(Streaming.studionamem().get(i)).click().build().perform();
        	}
        	
        }*/
	    /*  @And("^Check the streaming page is coming back from shodetaile page$")
	    public void check_the_streaming_page_is_coming_back_from_shodetaile_page() throws Throwable {
	    	Thread.sleep(1000);
	        driver.navigate().back();
	        Thread.sleep(1500);
	        Streaming.backarrowm().click();
	        Thread.sleep(500);
	        assertTrue(Streaming.streamingtabm().isDisplayed());
	    }*/
        
	

