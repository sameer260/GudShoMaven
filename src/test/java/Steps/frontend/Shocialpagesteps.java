package Steps.frontend;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;

import org.openqa.selenium.JavascriptExecutor;
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

public class Shocialpagesteps extends Base_setup
{
	public static Logger log=Logger.getLogger(Shocialpagesteps.class.getName());
    WebDriverWait wait=new WebDriverWait(driver,20);
	@Given("^Click on headder logo$")
    public void click_on_headder_logo() throws Throwable {
		
		socialpageandsearch.logoheaderm();
		Thread.sleep(2000);
    }
	@Given("^invalid data in to the search field$")
    public void invalid_data_in_to_the_search_field() throws Throwable {
        socialpageandsearch.homepagesearch().sendKeys("jhdhssjh");
        
    }

    @Then("^Check the text it should show no searh found text$")
    public void check_the_text_it_should_show_no_searh_found_text() throws Throwable {
      log.info(socialpageandsearch.nosearchfoundtext().getText());
      assertEquals(socialpageandsearch.nosearchfoundtext().getText(),"No Search Results Found");
       
    }

    @And("^The (.+) will display$")
    public void the_will_display(String title) throws Throwable {
        for(int i=0;i<socialpageandsearch.allheadingtext().size();i++)
        {
        	//log.info(socialpageandsearch.allheadingtext().get(i).getText());
        	if(socialpageandsearch.allheadingtext().get(i).getText().equalsIgnoreCase(title))
            {
        	  log.info(socialpageandsearch.allheadingtext().get(i).getText());
	          assertEquals(title,socialpageandsearch.allheadingtext().get(i).getText());
	          log.info("Title displayed");
	          break;
             }
        	
        }
    }

    @Then("^Click on Follow button on Studio Page and check the same (.+) is visibile on home page$")
    public void click_on_follow_button_on_studio_page_and_check_the_same_is_visibile_on_home_page(String shoseriesorstudioname) throws Throwable {
    	String studionameonstudiopage=Studioprofile.studionameonstudiopagem().getText();
    	//Followers count before follow
        String str=Studioprofile.followerscountm().getText();
        String str1=str.replaceAll("[\\n\\t ]", " ");
        //String str1=StringUtils.replace(str, "\n", " ");
        String stringfollowercountbefore=str1.substring(0,str1.lastIndexOf(" "));
        int followerscountbefore=Integer.parseInt(stringfollowercountbefore);
        log.info(followerscountbefore);
        assertEquals(studionameonstudiopage,shoseriesorstudioname);
        //Click on follow button and check toast message
        Studioprofile.followbutton().click();
        Thread.sleep(1000);
        assertEquals(Toastanderrormessages.toastmessagem().getText(),"You have started following this studio");
        Toastanderrormessages.toastmessageclosem().click();
        //Again capture the followers count after follow
        String str2=Studioprofile.followerscountm().getText();
        //String str3=StringUtils.replace(str2, "\n", " ");
        String str3=str2.replaceAll("[\\n\\t ]", " ");
        String stringfollowercountafter=str3.substring(0,str3.lastIndexOf(" "));
        int followerscountafter=Integer.parseInt(stringfollowercountafter);
        log.info(followerscountafter);
        //The followers count should increment by one
        assertEquals(followerscountbefore+1,followerscountafter);
        //Click on home page
        socialpageandsearch.logoheaderm().click();
        //Check the followed studio displaying with prorper count
        for(int i=0;i<socialpageandsearch.allstudionames().size();i++)
        {
        	if(socialpageandsearch.allstudionames().get(i).getText().equalsIgnoreCase(shoseriesorstudioname))
        	{
        		assertEquals(socialpageandsearch.allstudionames().get(i).getText(),shoseriesorstudioname);
        		assertEquals(studionameonstudiopage,socialpageandsearch.allstudionames().get(i).getText());
        		String followerstext=socialpageandsearch.followerstext().get(i).getText();
        		String strfollowerscountonsocialpage=followerstext.substring(0,followerstext.lastIndexOf(" "));
        		int followerscountonsocialpage=Integer.parseInt(strfollowerscountonsocialpage);
        		log.info(followerscountonsocialpage);
        		assertEquals(followerscountonsocialpage,followerscountafter);
        		break;
        	}
        }   
    }
    @Then("^From homepage click on (.+) and unfollow the studio$")
    public void from_homepage_click_on_and_unfollow_the_studio(String shoseriesorstudioname) throws Throwable {
    	Actions a=new Actions(driver);
    	Studioprofile.scrolldownm();
         int followerscountonsocialpage=0;
    	for(int i=0;i<socialpageandsearch.allstudionames().size();i++)
        {
        	if(socialpageandsearch.allstudionames().get(i).getText().equalsIgnoreCase(shoseriesorstudioname))
        	{
        		assertEquals(socialpageandsearch.allstudionames().get(i).getText(),shoseriesorstudioname);
        		String followerstext=socialpageandsearch.followerstext().get(i).getText();
        		String strfollowerscountonsocialpage=followerstext.substring(0,followerstext.lastIndexOf(" "));
        		followerscountonsocialpage=Integer.parseInt(strfollowerscountonsocialpage);
        		log.info(followerscountonsocialpage);
        		a.moveToElement(socialpageandsearch.allstudionames().get(i)).click().build().perform();
        		break;
        	}
        } 
    	 Thread.sleep(1500);
    	 String str=Studioprofile.followerscountm().getText();
    	 log.info(str);
        // String str1=StringUtils.replace(str, "\n", " ");
    	 String str1=str.replaceAll("[\\n\\t ]", " ");
         String stringfollowercountbefore=str1.substring(0,str1.lastIndexOf(" "));
         int followerscountbefore=Integer.parseInt(stringfollowercountbefore);
         log.info(followerscountbefore);
         assertEquals(followerscountonsocialpage,followerscountbefore);
    	Studioprofile.studioinfom().click();
    	Thread.sleep(1000);
    	Studioprofile.unfollowstudiom().click();
    	Thread.sleep(1000);
    	Studioprofile.unfollowbuttonm().click();
    	
    	
    	Thread.sleep(1000);
    	assertEquals(Toastanderrormessages.toastmessagem().getText(),"You have unfollowed this studio");
    	Toastanderrormessages.toastmessageclosem().click();
    	String str2=Studioprofile.followerscountm().getText();
       // String str3=StringUtils.replace(str2, "\n", " ");
    	String str3=str2.replaceAll("[\\n\\t ]", " ");
        String stringfollowercountafter=str3.substring(0,str3.lastIndexOf(" "));
        int followerscountafter=Integer.parseInt(stringfollowercountafter);
        log.info(followerscountafter);
        assertEquals(followerscountafter,followerscountbefore-1);
        socialpageandsearch.logoheaderm().click();
    }

    @And("^Check from home page (.+) the studio is invisble$")
    public void check_from_home_page_the_studio_is_invisble(String shoseriesorstudioname) throws Throwable {
        Thread.sleep(1000);
        for(int i=0;i<socialpageandsearch.allstudionames().size();i++)
        {
        	String studioname = null;
        	if(socialpageandsearch.allstudionames().get(i).getText().equalsIgnoreCase(shoseriesorstudioname))
        	{
        		studioname=socialpageandsearch.allstudionames().get(i).getText();
        		break;
        	}
        	else {
        		log.info("Studio unfollwed succesfully");
        		assertEquals(studioname,null);
        	}
        } 
        
    }
    @Then("^Click on Follow button on Studio Page from headder and check the same (.+) is visibile on home page$")
    public void click_on_follow_button_on_studio_page_from_headder_and_check_the_same_is_visibile_on_home_page(String shoseriesorstudioname) throws Throwable {
    	String studionameonstudiopage=Studioprofile.studionameonstudiopagem().getText();
    	//Followers count before follow
        String str=Studioprofile.followerscountm().getText();
        //String str1=StringUtils.replace(str, "\n", " ");
        String str1=str.replaceAll("[\\n\\t ]", " ");
        String stringfollowercountbefore=str1.substring(0,str1.lastIndexOf(" "));
        int followerscountbefore=Integer.parseInt(stringfollowercountbefore);
        log.info(followerscountbefore);
        assertEquals(studionameonstudiopage,shoseriesorstudioname);
        //Click on follow button and check toast message
        Studioprofile.scrolldownm();
        Thread.sleep(1000);
        Studioprofile.followbuttononheader().click();
        Thread.sleep(1000);
        assertEquals(Toastanderrormessages.toastmessagem().getText(),"You have started following this studio");
        Toastanderrormessages.toastmessageclosem().click();
        //Again capture the followers count after follow
        String str2=Studioprofile.followerscountm().getText();
        String str3=str2.replaceAll("[\\n\\t ]", " ");
        //String str3=StringUtils.replace(str2, "\n", " ");
        String stringfollowercountafter=str3.substring(0,str3.lastIndexOf(" "));
        int followerscountafter=Integer.parseInt(stringfollowercountafter);
        log.info(followerscountafter);
        //The followers count should increment by one
        assertEquals(followerscountbefore+1,followerscountafter);
        //Click on home page
        socialpageandsearch.logoheaderm().click();
        //Check the followed studio displaying with prorper count
        for(int i=0;i<socialpageandsearch.allstudionames().size();i++)
        {
        	if(socialpageandsearch.allstudionames().get(i).getText().equalsIgnoreCase(shoseriesorstudioname))
        	{
        		assertEquals(socialpageandsearch.allstudionames().get(i).getText(),shoseriesorstudioname);
        		assertEquals(studionameonstudiopage,socialpageandsearch.allstudionames().get(i).getText());
        		String followerstext=socialpageandsearch.followerstext().get(i).getText();
        		String strfollowerscountonsocialpage=followerstext.substring(0,followerstext.lastIndexOf(" "));
        		int followerscountonsocialpage=Integer.parseInt(strfollowerscountonsocialpage);
        		log.info(followerscountonsocialpage);
        		assertEquals(followerscountonsocialpage,followerscountafter);
        		break;
        	}
        }   
    }
    @Given("^Check the latest promos and latest titles heading text is displyed$")
    public void check_the_latest_promos_and_latest_titles_heading_text_is_displyed() throws Throwable {
    	//Studioprofile.scrolldownm();
    	String latestpromo=socialpageandsearch.allheadingtext().get(1).getText();
    	log.info(latestpromo);
    	String latesttitle=socialpageandsearch.allheadingtext().get(2).getText();
    	log.info(latesttitle);
        assertTrue(socialpageandsearch.allheadingtext().get(1).isDisplayed());
        assertTrue(socialpageandsearch.allheadingtext().get(2).isDisplayed());
        assertEquals(socialpageandsearch.allheadingtext().get(1).getText(),"Latest Promos");
        assertEquals(socialpageandsearch.allheadingtext().get(2).getText(),"Latest Titles");
    }

    @Then("^Just printout the promos and titles card names$")
    public void just_printout_the_promos_and_titles_card_names() throws Throwable {
        for(int i=0;i<socialpageandsearch.promonamesoncards().size();i++)
        {
        	assertTrue(socialpageandsearch.pngtitlesimgonpromocards().get(i).isDisplayed());
        	assertTrue(socialpageandsearch.promonamesoncards().get(i).isDisplayed());
        	assertTrue(socialpageandsearch.shoorserieslabelonpromocards().get(i).isDisplayed());
        	assertTrue(socialpageandsearch.viewcountofpromos().get(i).isDisplayed());
        	log.info(socialpageandsearch.viewcountofpromos().get(i).getText());
        	assertTrue(socialpageandsearch.gudcountofpromos().get(i).isDisplayed());
        	log.info(socialpageandsearch.gudcountofpromos().get(i).getText());
        	assertTrue(socialpageandsearch.promonamesoncards().get(i).isDisplayed());
        	log.info(socialpageandsearch.promonamesoncards().get(i).getText());
        	break;
        }
        for(int i=0;i<socialpageandsearch.shoorseriesnames().size();i++)
        {
        	assertTrue(socialpageandsearch.shoorseriesnames().get(i).isDisplayed());
        	String shoname=socialpageandsearch.shoorseriesnames().get(i).getText();
        	log.info(shoname);
        	assertTrue(socialpageandsearch.shoorserieslabelonshocards().get(i).isDisplayed());
        	assertTrue(socialpageandsearch.shoorserieslabelonpromocards().get(i).isDisplayed());
        	Actions a=new Actions(driver);
        	a.moveToElement(socialpageandsearch.shonameonmousehover().get(i)).build().perform();
        	Thread.sleep(500);
        	assertTrue(socialpageandsearch.shareshocard().get(i).isDisplayed());
        	assertEquals(shoname,socialpageandsearch.shonameoncard().get(i).getText());
        	assertTrue(socialpageandsearch.addtowatchlist().get(i).isDisplayed());
        	assertTrue(socialpageandsearch.shonameoncard().get(i).isDisplayed());
        	assertTrue(socialpageandsearch.shodetailsoncard().get(i).isDisplayed());
 
        	break;
        }
    }
    @Then("^Click on watch list button and check the same sho is present on homepage$")
    public void click_on_watch_list_button_and_check_the_same_sho_is_present_on_homepage() throws Throwable {
    	Thread.sleep(2000);
        String shonameonshodetailpage=Shoorseriesdetailpage.shonameinshodetailspage().getText();
        log.info(shonameonshodetailpage);
        Shoorseriesdetailpage.watchlistnuttonm().click();
        String expected=Toastanderrormessages.toastmessagem().getText();
        String actual=shonameonshodetailpage+" has been added to watchlist";
        assertTrue(expected.equalsIgnoreCase(actual));
        Toastanderrormessages.toastmessageclosem().click();
        socialpageandsearch.logoheaderm().click();
        Thread.sleep(1000);
        Studioprofile.scrolldownm();
        		for(int j=0;j<socialpageandsearch.shoorseriesnames().size();j++)
        		{
        			String text = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerHTML;",socialpageandsearch.shoorseriesnames().get(j));
        			if(text.equalsIgnoreCase(shonameonshodetailpage))
        			{
        			String name=(String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerHTML;",socialpageandsearch.shoorseriesnames().get(j));
        			log.info(name);
        			assertTrue(name.equalsIgnoreCase(shonameonshodetailpage));
        				break;
        			}
               }
        
          }
    @Then("^Click on watch list button and check the same sho is removed from homepage$")
    public void click_on_watch_list_button_and_check_the_same_sho_is_removed_from_homepage() throws Throwable {
    	String shonameonshodetailpage=Shoorseriesdetailpage.shonameinshodetailspage().getText();
    	Shoorseriesdetailpage.watchlistnuttonm().click();
    	assertEquals(Toastanderrormessages.toastmessagem().getText(),shonameonshodetailpage+" has been removed from watchlist");
    	Toastanderrormessages.toastmessageclosem().click();
    	Thread.sleep(1500);
    	socialpageandsearch.logoheaderm().click();
    	Studioprofile.scrolldownm();
    	String shonameonhomepage=null;
        		for(int j=0;j<socialpageandsearch.shoorseriesnames().size();j++)
        		{
        			String text=(String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerHTML;",socialpageandsearch.shoorseriesnames().get(j));

        			if(text.equalsIgnoreCase(shonameonshodetailpage))
        			{
        				shonameonhomepage = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerHTML;",socialpageandsearch.shoorseriesnames().get(j));
        				log.info(shonameonhomepage);
        				break;
        			}	
        			else {
        				log.info(shonameonhomepage);
        				assertEquals(shonameonhomepage,null);
        			}
        } 
    }

	@Then("^Click on watch list button after scrolldown and check the same sho is present on homepage and check (.+)$")
	public void click_on_watch_list_button_after_scrolldown_and_check_the_same_sho_is_present_on_homepage_and_check(
			String toastmessage) throws Throwable {
		Actions a = new Actions(driver);
		String shonameonshodetailpage = Shoorseriesdetailpage.shonameinshodetailspage().getText();
		log.info(shonameonshodetailpage);
		Studioprofile.scrolldownm();
		Shoorseriesdetailpage.headerwatchlistbuttonm().click();
		wait.until(ExpectedConditions.visibilityOf(Toastanderrormessages.toastmessagem()));
		assertEquals(Toastanderrormessages.toastmessagem().getText(), shonameonshodetailpage + " " + toastmessage);
		Toastanderrormessages.toastmessageclosem().click();
		((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight,0)");
		Thread.sleep(3000);
		a.moveToElement(socialpageandsearch.logoheaderm()).click().build().perform();
		Thread.sleep(1000);
		Studioprofile.scrolldownm();
		String shonameonhomepage = null;
		for (int j = 0; j < socialpageandsearch.shoorseriesnames().size(); j++) {
			String text=(String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerHTML;",socialpageandsearch.shoorseriesnames().get(j));
			log.info(text);
			if (text.equalsIgnoreCase(shonameonshodetailpage)) {

				shonameonhomepage = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerHTML;",socialpageandsearch.shoorseriesnames().get(j));
				log.info(shonameonhomepage);
				assertTrue(shonameonhomepage.equalsIgnoreCase(shonameonshodetailpage));
				break;
			} else {
				log.info(shonameonhomepage);
				assertEquals(shonameonhomepage, null);
			}
		}
	}
	
	
	
	@Then("^Click on watch list button from promo minititle and check (.+)$")
	public void click_on_watch_list_button_from_promo_minititle_and_check(String toastmessage) throws Throwable {
		String shonameonshodetailpage = Shoorseriesdetailpage.shonameinshodetailspage().getText();
		Shoorseriesdetailpage.promocardsm().get(3).click();
		Thread.sleep(2000);
		videoandaudioPlayer.mousehoveronplayerm();
		Thread.sleep(2000);
		videoandaudioPlayer.promoswitching();
		wait.until(ExpectedConditions.visibilityOf(videoandaudioPlayer.watchlistbuttononminititle()));
		videoandaudioPlayer.watchlistbuttononminititle().click();
		assertEquals(Toastanderrormessages.toastmessagem().getText(), shonameonshodetailpage + " " + toastmessage);
		Toastanderrormessages.toastmessageclosem().click();
		videoandaudioPlayer.closeicon().click();
		socialpageandsearch.logoheaderm().click();
		Studioprofile.scrolldownm();
		String shonameonhomepage = null;
		for (int j = 0; j < socialpageandsearch.shoorseriesnames().size(); j++) {
			String text=(String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerHTML;",socialpageandsearch.shoorseriesnames().get(j));
			log.info(text);
			if (text.equalsIgnoreCase(shonameonshodetailpage)) {

				shonameonhomepage = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerHTML;",socialpageandsearch.shoorseriesnames().get(j));
				log.info(shonameonhomepage);
				assertTrue(shonameonhomepage.equalsIgnoreCase(shonameonshodetailpage));
				

				break;
			} else {
				log.info(shonameonhomepage);
				assertEquals(shonameonhomepage, null);
			}
		}

	}
	@Then("^Click on watch list on (.+) and (.+) and check on home page$")
    public void click_on_watch_list_on_and_and_check_on_home_page(String shoname, String toastmessage) throws Throwable {
		
		Studioprofile.scrolldownm();
		Thread.sleep(1000);
		Studioprofile.addtowatchlist(shoname);
		String shonameonstudiopage=Studioprofile.shonameonstudioprofilewatchlist;
		String toastmessageafter=Toastanderrormessages.toastmessagem().getText();
		String toastmessgeactual=shonameonstudiopage+" "+toastmessage;
		assertTrue(toastmessgeactual.equalsIgnoreCase(toastmessageafter));
		Toastanderrormessages.toastmessageclosem().click();
		socialpageandsearch.logoheaderm().click();
		Studioprofile.scrolldownm();
		String shonameonhomepage=null;
		Actions a=new Actions(driver);
		for (int j = 0; j < socialpageandsearch.shoorseriesnames().size(); j++) {
			String text=(String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerHTML;",socialpageandsearch.shoorseriesnames().get(j));
			if (text.equalsIgnoreCase(shonameonstudiopage)) {

				shonameonhomepage = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerHTML;",socialpageandsearch.shoorseriesnames().get(j));
				log.info(shonameonhomepage);
				a.moveToElement(socialpageandsearch.addtowatchlist().get(j)).click().build().perform();
				assertEquals(shonameonhomepage, shonameonstudiopage);
				
				

				break;
			} else {
				log.info(shonameonhomepage);
				assertEquals(shonameonhomepage, null);
			}
		}
		
    }
	@Given("^Add to watch list from latestitles and (.+)$")
    public void add_to_watch_list_from_latestitles_and(String toastmessage) throws Throwable {
		Actions a=new Actions(driver);
		a.moveToElement(socialpageandsearch.shonameonmousehover().get(0)).build().perform();
		Thread.sleep(500);
		a.moveToElement(socialpageandsearch.addtowatchlist().get(0)).click().build().perform();
		assertTrue(Toastanderrormessages.toastmessagem().isDisplayed());
		String actualtoast=Toastanderrormessages.toastmessagem().getText();
		log.info(actualtoast);
		
    }

	 @Then("^remove to watch list from latestitles and (.+)$")
	    public void remove_to_watch_list_from_latestitles_and(String toastmessage1) throws Throwable {
		 Actions a=new Actions(driver);
			a.moveToElement(socialpageandsearch.shonameonmousehover().get(0)).build().perform();
			Thread.sleep(500);
			a.moveToElement(socialpageandsearch.addtowatchlist().get(0)).click().build().perform();
			assertTrue(Toastanderrormessages.toastmessagem().isDisplayed());
			String actualtoast=Toastanderrormessages.toastmessagem().getText();
			log.info(actualtoast);
			
	    }
	 @Given("^Mouse hover on (.+) and remove from watchlist verify the (.+)$")
	  public void mouse_hover_on_and_remove_from_watchlist_verify_the(String shoseriesorstudioname, String toastmessage) throws Throwable {
	     Studioprofile.scrolldownm(); 
	     Actions a=new Actions(driver);
		 for(int i=0;i<socialpageandsearch.shoorseriesnames().size(); i++)
	       {
			 String text=(String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerHTML;",socialpageandsearch.shoorseriesnames().get(i));
	    	 log.info(text);  
			 if(text.equalsIgnoreCase(shoseriesorstudioname))
	    	   {
	    		   String shoname=(String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerHTML;",socialpageandsearch.shoorseriesnames().get(i));
	    		   log.info(shoname);
	    		   
	    		   a.moveToElement(socialpageandsearch.shoorseriesnames().get(i)).build().perform();
	    		   Thread.sleep(1000);
	    		   a.moveToElement(socialpageandsearch.addtowatchlist().get(i)).click().build().perform();
	    		   assertEquals(shoname+" "+toastmessage,Toastanderrormessages.toastmessagem().getText());
	    		   break;
	    	   }
	       }
	    }
	 @And("^Removed (.+) should not on home page$")
	    public void removed_should_not_on_home_page(String shoseriesorstudioname) throws Throwable {
		 Actions a=new Actions(driver);
		 Studioprofile.scrolldownm();
		 String shonameonhomepage=null;
			for (int j = 0; j < socialpageandsearch.shoorseriesnames().size(); j++) {
				String text=(String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerHTML;",socialpageandsearch.shoorseriesnames().get(j));
				if (text.equalsIgnoreCase(shoseriesorstudioname)) {
                 
					shonameonhomepage = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerHTML;",socialpageandsearch.shoorseriesnames().get(j));
					log.info(shonameonhomepage);
					a.moveToElement(socialpageandsearch.shoorseriesnames().get(j)).build().perform();
					socialpageandsearch.addtowatchlist().get(j).click();
					assertTrue(shonameonhomepage.equalsIgnoreCase(shoseriesorstudioname));
					

					break;
				} else {
					log.info(shonameonhomepage);
					assertEquals(shonameonhomepage, null);
				}
			}
			Toastanderrormessages.toastmessageclosem().click();
			socialpageandsearch.logoheaderm().click();
	    }
	 @Given("^Share shocard from latestst titles$")
	    public void share_shocard_from_latestst_titles() throws Throwable {
		 Actions a=new Actions(driver);
 		a.moveToElement(socialpageandsearch.shonameonmousehover().get(0)).build().perform();
 		Thread.sleep(500);
 		a.moveToElement(socialpageandsearch.shareshocard().get(0)).click().build().perform();
 		Shareandfollow.facebooksharem();
        Shareandfollow.facebookwindowhandle();
        Shareandfollow.twittersharem();
        Shareandfollow.twitterwindowhandle();
        Shareandfollow.whatsappwindowhandlforpromo();
        Shareandfollow.promocopylinksharem();
        assertEquals(Toastanderrormessages.toastmessagem().getText(),"Link Copied!");
        Shareandfollow.closesharepopupm();
	    }
	 @Given("^Share (.+) via all social links$")
	 public void share_via_all_social_links(String shoname) throws Throwable {
		 Studioprofile.scrolldownm();
	        for(int i=0;i<socialpageandsearch.shoorseriesnames().size();i++)
	        {
	        	String text = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerHTML;",socialpageandsearch.shoorseriesnames().get(i));
	        	if(text.equalsIgnoreCase(shoname))
	        	{
	        		Actions a=new Actions(driver);
	        		a.moveToElement(socialpageandsearch.shonameonmousehover().get(i)).build().perform();
	        		Thread.sleep(500);
	        		a.moveToElement(socialpageandsearch.shareshocard().get(i)).click().build().perform();
	        		break;
	        	}
	        }
	        Shareandfollow.facebooksharem();
	        Shareandfollow.facebookwindowhandle();
	        Shareandfollow.twittersharem();
	        Shareandfollow.twitterwindowhandle();
	        Shareandfollow.whatsappwindowhandlforpromo();
	        Shareandfollow.promocopylinksharem();
	        assertEquals(Toastanderrormessages.toastmessagem().getText(),"Link Copied!");
	        Shareandfollow.closesharepopupm();
	        
	    }
	 @Given("^Redirection of shocard from latestst titles and it should redirect to correct sho detail page$")
	    public void redirection_of_shocard_from_latestst_titles_and_it_should_redirect_to_correct_sho_detail_page() throws Throwable {
		 Actions a=new Actions(driver);
		 a.moveToElement(socialpageandsearch.shonameonmousehover().get(0)).click().build().perform();
		 Thread.sleep(2000);
		 String shonameonshodetailpage=Shoorseriesdetailpage.shoorseriesnameonheader().getText();
		 log.info(shonameonshodetailpage);
		 assertTrue(Shoorseriesdetailpage.watchlistnuttonm().isDisplayed());
		 Studioprofile.scrolldownm();
		 assertTrue(Shoorseriesdetailpage.shoorseriesnameonheader().isDisplayed());
		 
	    }
	 @Given("^Click on (.+) and it should redirect to correct sho detail page$")
	    public void click_on_and_it_should_redirect_to_correct_sho_detail_page(String shoname) throws Throwable {
		 Studioprofile.scrolldownm();
		 String shonameonhomepage = null;
	        for(int i=0;i<socialpageandsearch.shoorseriesnames().size();i++)
	        {
	        	String text = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerHTML;",socialpageandsearch.shoorseriesnames().get(i));
	        	if(text.equalsIgnoreCase(shoname))
	        	{
	        		Actions a=new Actions(driver);
	        		shonameonhomepage=(String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerHTML;",socialpageandsearch.shoorseriesnames().get(i));
	        		log.info(shonameonhomepage);
	        		a.moveToElement(socialpageandsearch.shonameonmousehover().get(i)).click().build().perform();
	        		break;
	        	}
	        }
	        wait.until(ExpectedConditions.visibilityOf(Shoorseriesdetailpage.shonameinshodetailspage()));
	        assertEquals(Shoorseriesdetailpage.shonameinshodetailspage().getText(),shonameonhomepage);
	    }
	 @Then("^Play (.+) and fav the audio and same check same on my fav audios$")
	    public void play_and_fav_the_audio_and_same_check_same_on_my_fav_audios(String audio) throws Throwable {

		 Actions a=new Actions(driver);
	        Shoorseriesdetailpage.audionamesinshodetailpagem(audio);
	        Thread.sleep(500);
	        String audionameonplayer=videoandaudioPlayer.audionameonplayerm().getText();
	        log.info(audionameonplayer);
	        videoandaudioPlayer.heartsymbolm().click();
	        videoandaudioPlayer.closeaudioplayerm().click();
	        ((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight,0)");
			Thread.sleep(3000);
			a.moveToElement(socialpageandsearch.logoheaderm()).click().build().perform();
			Thread.sleep(2000);
			Studioprofile.scrolldownm();
			String audionameonhomepage = null;
			for(int i=0;i<socialpageandsearch.audionames().size();i++)
			{
				if(socialpageandsearch.audionames().get(i).getText().equalsIgnoreCase(audio))
				{
					audionameonhomepage=socialpageandsearch.audionames().get(i).getText();
					log.info(audionameonhomepage);
					assertTrue(audionameonhomepage.equalsIgnoreCase(audionameonplayer));
					break;
				}
				else
				{
					assertEquals(audionameonhomepage,null);
				}
			}
			
	        
	        
	        
	    }
	 @Then("^Play (.+) and fav the audio from studio detail page and same check same on my fav audios$")
	    public void play_and_fav_the_audio_from_studio_detail_page_and_same_check_same_on_my_fav_audios(String audio) throws Throwable {
	       // Studioprofile.scrolldownm();
	        Studioprofile.playaudiom(audio);
	        Thread.sleep(1000);
	        videoandaudioPlayer.heartsymbolm().click();
	        String audionameonstudiodetail=videoandaudioPlayer.audionameonplayerm().getText();
	        log.info(audionameonstudiodetail);
	        videoandaudioPlayer.closeaudioplayerm().click();
	        socialpageandsearch.logoheaderm().click();
	        Thread.sleep(2000);
	        driver.navigate().refresh();
	        Thread.sleep(3000);
	        Studioprofile.scrolldownm();
	        String audionamenhomepage=null;
	        for(int i=0;i<socialpageandsearch.audionames().size();i++)
			{
				if(socialpageandsearch.audionames().get(i).getText().equalsIgnoreCase(audio))
				{
					audionamenhomepage=socialpageandsearch.audionames().get(i).getText();
					log.info(audionamenhomepage);
					assertTrue(audionamenhomepage.equalsIgnoreCase(audionameonstudiodetail));
					break;
				}
				else
				{
					assertEquals(audionamenhomepage,null);
				}
			}
	        
	    }
	 @Given("^Share (.+) from home page$")
	 public void share_from_home_page(String audio) throws Throwable {
		    Studioprofile.scrolldownm();
	        Studioprofile.playaudiom(audio);
	        Thread.sleep(1000);
	        Shareandfollow.audiosharem();
	        Shareandfollow.facebooksharem();
	        Shareandfollow.facebookwindowhandle();
	        Shareandfollow.twittersharem();
	        Shareandfollow.twitterwindowhandle();
	        Shareandfollow.whatsappsharem();
	        Shareandfollow.whatsappwindowhandlforpromo();
	        Shareandfollow.promocopylinksharem();
	        assertEquals(Toastanderrormessages.toastmessagem().getText(),"Link Copied!");
	        Shareandfollow.closesharepopupm();
	        
	    }
	 @Then("^Play the (.+) and like the promo and check on home page$")
	 public void play_the_and_like_the_promo_and_check_on_home_page_and(String promo) throws Throwable {
		 int beforeviewcount=Shoorseriesdetailpage.viewcountonshodetailpagem(promo);
	    	log.info("Promo view count before playing promo:" + beforeviewcount);
	    	int gudcountbefore=Shoorseriesdetailpage.gudcountonshodetailpagem(promo);
	    	log.info("Promo gud count before playing promo:" + gudcountbefore);
	    	Shoorseriesdetailpage.promoorepisodenamesonshodetailpagem(promo);
	    	Thread.sleep(3000);
	    	videoandaudioPlayer.mousehoveronplayerm();
	    	int gudcountbeforeonplayer=videoandaudioPlayer.gudcountonplayer();
	    	assertEquals(gudcountbefore,gudcountbeforeonplayer);
	    	videoandaudioPlayer.clapsymbolinplayerm().click();
	    	Thread.sleep(1000);
	    	int gudcountafteronplayer=videoandaudioPlayer.gudcountonplayer();
	    	assertEquals(Toastanderrormessages.toastmessagem().getText(),"You liked this promo");
	    	Toastanderrormessages.toastmessageclosem().click();
	    	videoandaudioPlayer.mousehoveronplayerm();
	    	videoandaudioPlayer.closeplayerm().click();
	    	
	        Thread.sleep(1000);
	        int afterviewcount=Shoorseriesdetailpage.viewcountonshodetailpagem(promo);
	    	log.info("Promo view count after playing promo:" + afterviewcount);
	    	int gudcountafter=Shoorseriesdetailpage.gudcountonshodetailpagem(promo);
	    	log.info("Promo gud count after playing promo:" + gudcountafter);
	    	assertEquals(gudcountafteronplayer,gudcountafter);
	    	assertEquals(beforeviewcount+1,afterviewcount);
	    	assertEquals(gudcountbefore+1,gudcountafter);
	    	socialpageandsearch.logoheaderm().click();
	    	Studioprofile.scrolldownm();
	    	for(int i=0;i<socialpageandsearch.promonamesoncards().size();i++)
	    	{
	    		if(socialpageandsearch.promonamesoncards().get(i).getText().equalsIgnoreCase(promo))
	    		{
	    			assertEquals(socialpageandsearch.promonamesoncards().get(i).getText(),promo);
	    			log.info(socialpageandsearch.promonamesoncards().get(i).getText());
	    			String str=socialpageandsearch.viewcountofpromos().get(i).getText();
	    			String str1=str.substring(0,str.lastIndexOf(" "));
	    			int viewcountonhomepage=Integer.parseInt(str1);
	    			log.info("View count on homepage"+viewcountonhomepage);
	    			assertEquals(viewcountonhomepage,afterviewcount);
	    			assertEquals(viewcountonhomepage,beforeviewcount+1);
	    			String str2=socialpageandsearch.gudcountofpromos().get(i).getText();
	    			String str3=str2.substring(0,str2.lastIndexOf(" "));
	    			int Gudcountonhomepage=Integer.parseInt(str3);
	    			log.info("Gud count on homepage"+Gudcountonhomepage);
	    			assertEquals(Gudcountonhomepage,gudcountafter);
	    			assertEquals(Gudcountonhomepage,gudcountbefore+1);
	    			assertEquals(gudcountafteronplayer,Gudcountonhomepage);
	    			break;
	    		}
	    		
	    	}
	    }
	 @Then("^Play the (.+) and dislike the promo and check on home page$")
	    public void play_the_and_dislike_the_promo_and_check_on_home_page(String promo) throws Throwable {
		 int beforeviewcount=Shoorseriesdetailpage.viewcountonshodetailpagem(promo);
	    	log.info("Promo view count before playing promo:" + beforeviewcount);
	    	int gudcountbefore=Shoorseriesdetailpage.gudcountonshodetailpagem(promo);
	    	log.info("Promo gud count before playing promo:" + gudcountbefore);
	    	Shoorseriesdetailpage.promoorepisodenamesonshodetailpagem(promo);
	    	Thread.sleep(3000);
	    	videoandaudioPlayer.mousehoveronplayerm();
	    	int gudcountbeforeonplayer=videoandaudioPlayer.gudcountonplayer();
	    	assertEquals(gudcountbefore,gudcountbeforeonplayer);
	    	videoandaudioPlayer.clapsymbolinplayerm().click();
	    	Thread.sleep(500);
	    	int gudcountafteronplayer=videoandaudioPlayer.gudcountonplayer();
	    	videoandaudioPlayer.closeplayerm().click();
	    	assertEquals(Toastanderrormessages.toastmessagem().getText(),"You unliked this promo");
	    	Toastanderrormessages.toastmessageclosem().click();
	        Thread.sleep(1000);
	        int afterviewcount=Shoorseriesdetailpage.viewcountonshodetailpagem(promo);
	    	log.info("Promo view count after playing promo:" + afterviewcount);
	    	int gudcountafter=Shoorseriesdetailpage.gudcountonshodetailpagem(promo);
	    	log.info("Promo gud count after playing promo:" + gudcountafter);
	    	assertEquals(gudcountafteronplayer,gudcountafter);
	    	assertEquals(beforeviewcount+1,afterviewcount);
	    	assertEquals(gudcountbefore-1,gudcountafter);
	    	socialpageandsearch.logoheaderm().click();
	    	Studioprofile.scrolldownm();
	    	for(int i=0;i<socialpageandsearch.promonamesoncards().size();i++)
	    	{
	    		if(socialpageandsearch.promonamesoncards().get(i).getText().equalsIgnoreCase(promo))
	    		{
	    			assertEquals(socialpageandsearch.promonamesoncards().get(i).getText(),promo);
	    			String str=socialpageandsearch.viewcountofpromos().get(i).getText();
	    			String str1=str.substring(0,str.lastIndexOf(" "));
	    			int viewcountonhomepage=Integer.parseInt(str1);
	    			assertEquals(viewcountonhomepage,afterviewcount);
	    			assertEquals(viewcountonhomepage,beforeviewcount+1);
	    			String str2=socialpageandsearch.gudcountofpromos().get(i).getText();
	    			String str3=str2.substring(0,str2.lastIndexOf(" "));
	    			int Gudcountonhomepage=Integer.parseInt(str3);
	    			log.info(Gudcountonhomepage);
	    			assertEquals(Gudcountonhomepage,gudcountafter);
	    			assertEquals(Gudcountonhomepage,gudcountbefore+1);
	    			assertEquals(gudcountafteronplayer,Gudcountonhomepage);
	    			
	    		}
	    		else {
	    			log.info("No promo displayed");
	    		}
	    		
	    	}
	    }

	    @Then("^Play promo from stuido profile page and check on home page$")
	    public void play_promo_from_stuido_profile_page_and_check_on_home_page() throws Throwable {
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
	       Thread.sleep(500);
	       int gudcountbeforeonplayer=videoandaudioPlayer.gudcountonplayer();
	   	   assertEquals(gudcountbeforeplay,gudcountbeforeonplayer);
	       String expecetedpromoname=videoandaudioPlayer.promonameonplayerm().getText();
	       assertTrue(actualpromoname.equalsIgnoreCase(expecetedpromoname));
	       videoandaudioPlayer.clapsymbolinplayerm().click();;
	       Thread.sleep(1000);
	       int gudcountafteronplayer=videoandaudioPlayer.gudcountonplayer();
	       String Actual=Toastanderrormessages.toastmessagem().getText();
	       log.info(Actual);
	       assertEquals(gudcountbeforeonplayer+1,gudcountafteronplayer);
	       Toastanderrormessages.toastmessageclosem().click();
	       videoandaudioPlayer.mousehoveronplayerm();
	       videoandaudioPlayer.closeplayerm().click();
	       socialpageandsearch.logoheaderm().click();
	       Studioprofile.scrolldownm();
	       for(int i=0;i<socialpageandsearch.promonamesoncards().size();i++)
	    	{
	    		if(socialpageandsearch.promonamesoncards().get(i).getText().equalsIgnoreCase(actualpromoname))
	    		{
	    			assertEquals(socialpageandsearch.promonamesoncards().get(i).getText(),actualpromoname);
	    			String str=socialpageandsearch.viewcountofpromos().get(i).getText();
	    			String str1=str.substring(0,str.lastIndexOf(" "));
	    			int viewcountonhomepage=Integer.parseInt(str1);
	    			log.info("View count on homepage"+viewcountonhomepage);
	    			assertEquals(viewcountonhomepage,viewcountbeforeplay+1);
	    			String str2=socialpageandsearch.gudcountofpromos().get(i).getText();
	    			String str3=str2.substring(0,str2.lastIndexOf(" "));
	    			int Gudcountonhomepage=Integer.parseInt(str3);
	    			log.info("Gud count on homepage"+Gudcountonhomepage);
	    			assertEquals(Gudcountonhomepage,gudcountbeforeonplayer+1);
	    			assertEquals(gudcountafteronplayer,Gudcountonhomepage);
	    			
	    		}
	    		else {
	    			log.info("No promo displayed");
	    		}
	    	}
	    }
	    @Then("^Play promo from stuido profile page and check on home page after dislike$")
	    public void play_promo_from_stuido_profile_page_and_check_on_home_page_after_dislike() throws Throwable {
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
	       Thread.sleep(500);
	       int gudcountbeforeonplayer=videoandaudioPlayer.gudcountonplayer();
	   	   assertEquals(gudcountbeforeplay,gudcountbeforeonplayer);
	       String expecetedpromoname=videoandaudioPlayer.promonameonplayerm().getText();
	       assertTrue(actualpromoname.equalsIgnoreCase(expecetedpromoname));
	       videoandaudioPlayer.clapsymbolinplayerm().click();;
	       Thread.sleep(1000);
	       int gudcountafteronplayer=videoandaudioPlayer.gudcountonplayer();
	       String Actual=Toastanderrormessages.toastmessagem().getText();
	       log.info(Actual);
	       assertEquals(gudcountafteronplayer,gudcountbeforeonplayer-1);
	       Toastanderrormessages.toastmessageclosem().click();
	       videoandaudioPlayer.mousehoveronplayerm();
	       videoandaudioPlayer.closeplayerm().click();
	       socialpageandsearch.logoheaderm().click();
	       Studioprofile.scrolldownm();
	       for(int i=0;i<socialpageandsearch.promonamesoncards().size();i++)
	    	{
	    		if(socialpageandsearch.promonamesoncards().get(i).getText().equalsIgnoreCase(actualpromoname))
	    		{
	    			assertEquals(socialpageandsearch.promonamesoncards().get(i).getText(),actualpromoname);
	    			String str=socialpageandsearch.viewcountofpromos().get(i).getText();
	    			String str1=str.substring(0,str.lastIndexOf(" "));
	    			int viewcountonhomepage=Integer.parseInt(str1);
	    			log.info("View count on homepage"+viewcountonhomepage);
	    			assertEquals(viewcountonhomepage,viewcountbeforeplay+1);
	    			String str2=socialpageandsearch.gudcountofpromos().get(i).getText();
	    			String str3=str2.substring(0,str2.lastIndexOf(" "));
	    			int Gudcountonhomepage=Integer.parseInt(str3);
	    			log.info("Gud count on homepage"+Gudcountonhomepage);
	    			assertEquals(Gudcountonhomepage,gudcountbeforeonplayer+1);
	    			assertEquals(gudcountafteronplayer,Gudcountonhomepage);
	    			
	    		}
	    		else {
	    			log.info("No promo displayed");
	    		}
	    	}
	    }
	    @Given("^Dislike the (.+) from the home page and check its should invisble$")
	    public void dislike_the_from_the_home_page_and_check_its_should_invisble(String promo) throws Throwable {
	    	Studioprofile.scrolldownm();
	    	for(int i=0;i<socialpageandsearch.promonamesoncards().size();i++)
	    	{
	    		((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight,0)");
	    		if(socialpageandsearch.promonamesoncards().get(i).getText().equalsIgnoreCase(promo))
	    		{
	    			
	    			assertEquals(socialpageandsearch.promonamesoncards().get(i).getText(),promo);
	    			String str=socialpageandsearch.viewcountofpromos().get(i).getText();
	    			String str1=str.substring(0,str.lastIndexOf(" "));
	    			int viewcountonhomepage=Integer.parseInt(str1);
	    			log.info("View count on homepage"+viewcountonhomepage);
	    			String str2=socialpageandsearch.gudcountofpromos().get(i).getText();
	    			String str3=str2.substring(0,str2.lastIndexOf(" "));
	    			int Gudcountonhomepage=Integer.parseInt(str3);
	    			log.info("Gud count on homepage"+Gudcountonhomepage);
	    			Actions a=new Actions(driver);
	    			a.moveToElement(socialpageandsearch.hoveronpromocards().get(i)).click().build().perform();
	    			Thread.sleep(2000);
	    		       videoandaudioPlayer.mousehoveronplayerm();
	    		       Thread.sleep(1000);
	    		       int gudcountbeforeonplayer=videoandaudioPlayer.gudcountonplayer();
	    		   	   assertEquals(Gudcountonhomepage,gudcountbeforeonplayer);
	    		       String expecetedpromoname=videoandaudioPlayer.promonameonplayerm().getText();
	    		       log.info(expecetedpromoname);
	    		       assertTrue(promo.equalsIgnoreCase(expecetedpromoname));
	    		       videoandaudioPlayer.clapsymbolinplayerm().click();;
	    		       Thread.sleep(1000);
	    		       int gudcountafteronplayer=videoandaudioPlayer.gudcountonplayer();
	    		       String Actual=Toastanderrormessages.toastmessagem().getText();
	    		       log.info(Actual);
	    		       assertEquals(gudcountafteronplayer,gudcountbeforeonplayer-1);
	    		       Toastanderrormessages.toastmessageclosem().click();
	    		       videoandaudioPlayer.mousehoveronplayerm();
	    		       videoandaudioPlayer.closeplayerm().click();
	    		       Thread.sleep(2000);
	    		       Studioprofile.scrolldownm();
	    			   break;
	    		}
	    }
	    	for(int i=0;i<socialpageandsearch.promonamesoncards().size();i++)
	    	{
	    		
	    	if(socialpageandsearch.promonamesoncards().get(i).getText().equalsIgnoreCase(promo)) {
		    	   log.info("Not working properly");
		       }
		       else {
		    	   log.info("Promo invisbile");
		    	   break;
		       }
	    	}
	 }
	    @Given("^Play the promo from the latestpromos and like the promo$")
	    public void play_the_promo_from_the_latestpromos_and_like_the_promo() throws Throwable {
	    	//Studioprofile.scrolldownm();
	    		String promo=socialpageandsearch.promonamesoncards().get(0).getText();
	    		log.info(promo);
	    			String str=socialpageandsearch.viewcountofpromos().get(0).getText();
	    			String str1=str.substring(0,str.lastIndexOf(" "));
	    			int viewcountonhomepage=Integer.parseInt(str1);
	    			log.info("View count on homepage"+viewcountonhomepage);
	    			String str2=socialpageandsearch.gudcountofpromos().get(0).getText();
	    			String str3=str2.substring(0,str2.lastIndexOf(" "));
	    			int Gudcountonhomepage=Integer.parseInt(str3);
	    			log.info("Gud count on homepage"+Gudcountonhomepage);
	    			Actions a=new Actions(driver);
	    			a.moveToElement(socialpageandsearch.hoveronpromocards().get(0)).click().build().perform();
	    			Thread.sleep(2000);
	    		       videoandaudioPlayer.mousehoveronplayerm();
	    		       Thread.sleep(1000);
	    		       int gudcountbeforeonplayer=videoandaudioPlayer.gudcountonplayer();
	    		   	   assertEquals(Gudcountonhomepage,gudcountbeforeonplayer);
	    		       String expecetedpromoname=videoandaudioPlayer.promonameonplayerm().getText();
	    		       log.info(expecetedpromoname);
	    		       assertTrue(promo.equalsIgnoreCase(expecetedpromoname));
	    		       videoandaudioPlayer.clapsymbolinplayerm().click();
	    		       Thread.sleep(1000);
	    		       int gudcountafteronplayer=videoandaudioPlayer.gudcountonplayer();
	    		       String Actual=Toastanderrormessages.toastmessagem().getText();
	    		       log.info(Actual);
	    		       assertEquals(gudcountafteronplayer,gudcountbeforeonplayer+1);
	    		       Toastanderrormessages.toastmessageclosem().click();
	    		       videoandaudioPlayer.mousehoveronplayerm();
	    		       videoandaudioPlayer.closeplayerm().click();
	    		       Thread.sleep(2000);
	    		       Studioprofile.scrolldownm();
		    			String str4=socialpageandsearch.viewcountofpromos().get(0).getText();
		    			String str5=str4.substring(0,str4.lastIndexOf(" "));
		    			int viewcountafteronhomepage=Integer.parseInt(str5);
		    			log.info("View count on homepage"+viewcountafteronhomepage);
		    			String str6=socialpageandsearch.gudcountofpromos().get(0).getText();
		    			String str7=str6.substring(0,str6.lastIndexOf(" "));
		    			int Gudcountafteronhomepage=Integer.parseInt(str7);
		    			log.info("Gud count on homepage"+Gudcountafteronhomepage);
		    			assertEquals(viewcountafteronhomepage,viewcountonhomepage+1);
		    			assertEquals(Gudcountafteronhomepage,Gudcountonhomepage+1);
	    }
	    @Given("^Share the promo from latest promos section$")
	    public void share_the_promo_from_latest_promos_section() throws Throwable {
	    	Actions a=new Actions(driver);
	    	String promo=socialpageandsearch.promonamesoncards().get(0).getText();
    		log.info(promo);
    		a.moveToElement(socialpageandsearch.hoveronpromocards().get(0)).build().perform();
    		Thread.sleep(1000);
    		a.moveToElement(socialpageandsearch.sharebuttononpromocrds().get(0)).click().build().perform();
    		Shareandfollow.facebooksharem();
            Shareandfollow.facebookwindowhandle();
            Shareandfollow.twittersharem();
            Shareandfollow.twitterwindowhandle();
            Shareandfollow.whatsappsharem();
            Shareandfollow.whatsappwindowhandlforpromo();
            Shareandfollow.promocopylinksharem();
            assertEquals(Toastanderrormessages.toastmessagem().getText(),"Link Copied!");
            Shareandfollow.closesharepopupm();
    		
	    }
	    @Given("^Share the (.+) from my gud promos$")
	    public void share_the_from_my_gud_promos(String promo) throws Throwable {
	    	Studioprofile.scrolldownm();
	    	Actions a =new Actions(driver);
	       for(int i=0;i<socialpageandsearch.promonamesoncards().size();i++)
	       {
	    	   
	    	   if(socialpageandsearch.promonamesoncards().get(i).getText().equalsIgnoreCase(promo))
	    	   {
	    		  //((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight,0)");
	    		   String promoname=socialpageandsearch.promonamesoncards().get(i).getText();
	       		log.info(promoname);
	       		assertTrue(promoname.equals(promo));
	       		//a.moveToElement(socialpageandsearch.hoveronpromocards().get(i)).build().perform();
	       		//Thread.sleep(500);
	       		a.moveToElement(socialpageandsearch.sharebuttononpromocrds().get(i)).click().build().perform();
	       		Shareandfollow.facebooksharem();
	               Shareandfollow.facebookwindowhandle();
	               Shareandfollow.twittersharem();
	               Shareandfollow.twitterwindowhandle();
	               Shareandfollow.whatsappsharem();
	               Shareandfollow.whatsappwindowhandlforpromo();
	               Shareandfollow.promocopylinksharem();
	               assertEquals(Toastanderrormessages.toastmessagem().getText(),"Link Copied!");
	               Shareandfollow.closesharepopupm();
	    	   }
	    	   
	       }
	    }
	    @Then("^Play (.+) and check on home page in continue watching and remove$")
	    public void play_and_check_on_home_page_in_continue_watching_and_remove(String shoseriesorstudioname) throws Throwable {
	        Shoorseriesdetailpage.playorbuybuttonm().click();
	        Thread.sleep(5000);
	        videoandaudioPlayer.mousehoveronplayerm();
	        videoandaudioPlayer.closeplayerm().click();
	        socialpageandsearch.logoheaderm().click();
	        Thread.sleep(2000);
	        assertEquals(socialpageandsearch.continuewatchngtitle().getText(),"Continue Watching");
	        for(int i=0;i<socialpageandsearch.shoorseriesnamesincontinuewatching().size();i++)
	        {
	        	if(socialpageandsearch.shoorseriesnamesincontinuewatching().get(i).getText().equalsIgnoreCase(shoseriesorstudioname))
	        	{
	        		assertTrue(shoseriesorstudioname.equalsIgnoreCase(socialpageandsearch.shoorseriesnamesincontinuewatching().get(i).getText()));
	        		Actions a=new Actions(driver);
	        		a.moveToElement(socialpageandsearch.closeiconofcontinuewatching().get(i)).click().build().perform();
	        		
	        		String expected=shoseriesorstudioname+" "+"has been removed";
	        		String actual=Toastanderrormessages.toastmessagem().getText();
	        		assertTrue(expected.equalsIgnoreCase(actual));
	        	}
	        }
	        
	    }
	    @Then("^Check continue watching after playing and series and remove$")
	    public void check_continue_watching_after_playing_and_series_and_remove() throws Throwable {
	    	Shoorseriesdetailpage.playorbuybuttonm().click();
	        Thread.sleep(5000);
	        videoandaudioPlayer.mousehoveronplayerm();
	        String str=videoandaudioPlayer.promonameonplayerm().getText();
	        String episodename=str.substring(10);
	        log.info(episodename);
	        videoandaudioPlayer.closeplayerm().click();
	        socialpageandsearch.logoheaderm().click();
	        Thread.sleep(2000);
	        assertEquals(socialpageandsearch.continuewatchngtitle().getText(),"Continue Watching");
	        for(int i=0;i<socialpageandsearch.shoorseriesnamesincontinuewatching().size();i++)
	        {
	        	if(socialpageandsearch.shoorseriesnamesincontinuewatching().get(i).getText().equalsIgnoreCase(episodename))
	        	{
	        		assertTrue(episodename.equalsIgnoreCase(socialpageandsearch.shoorseriesnamesincontinuewatching().get(i).getText()));
	        		Actions a=new Actions(driver);
	        		a.moveToElement(socialpageandsearch.closeiconofcontinuewatching().get(i)).click().build().perform();
	        		
	        		String expected=episodename+" "+"has been removed";
	        		String actual=Toastanderrormessages.toastmessagem().getText();
	        		assertTrue(expected.equalsIgnoreCase(actual));
	        	}
	        }
	        
	    }
	    @Then("^Check the continue watching after playing and (.+) and remove$")
	    public void check_the_continue_watching_after_playing_and_and_remove(String episode) throws Throwable {
	        for(int i=0;i<Shoorseriesdetailpage.episodenameinshodetailpagem().size();i++)
	        {
	        	if(Shoorseriesdetailpage.episodenameinshodetailpagem().get(i).getText().equalsIgnoreCase(episode))
	        	{
	        		
	        		Actions a=new Actions(driver);
	        		a.moveToElement(Shoorseriesdetailpage.episodescardsm().get(i)).click().build().perform();
	        		break;
	        	}
	        }
	        Thread.sleep(5000);
	        videoandaudioPlayer.mousehoveronplayerm();
	        String str=videoandaudioPlayer.promonameonplayerm().getText();
	        String episodename=str.substring(10);
	        log.info(episodename);
	        videoandaudioPlayer.closeplayerm().click();
	        socialpageandsearch.logoheaderm().click();
	        Thread.sleep(2000);
	        assertEquals(socialpageandsearch.continuewatchngtitle().getText(),"Continue Watching");
	        for(int i=0;i<socialpageandsearch.shoorseriesnamesincontinuewatching().size();i++)
	        {
	        	if(socialpageandsearch.shoorseriesnamesincontinuewatching().get(i).getText().equalsIgnoreCase(episodename))
	        	{
	        		assertTrue(episodename.equalsIgnoreCase(socialpageandsearch.shoorseriesnamesincontinuewatching().get(i).getText()));
	        		Actions a=new Actions(driver);
	        		a.moveToElement(socialpageandsearch.closeiconofcontinuewatching().get(i)).click().build().perform();
	        		
	        		String expected=episodename+" "+"has been removed";
	        		String actual=Toastanderrormessages.toastmessagem().getText();
	        		assertTrue(expected.equalsIgnoreCase(actual));
	        	}
	        }
	        
	    }
	   

}    
    
    
    
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   /* @Then("^Click on (.+) and check redirected correctly and check followers count is displaying correctly$")
    public void click_on_and_check_redirected_correctly_and_check_followers_count_is_displaying_correctly(String studioname) throws Throwable {
    	String studionameonstudiopage=null;
    	String followerscountonstudiopage = null;
    	for(int i=0;i< socialpageandsearch.allstudionames().size();i++)
       {
    	   if(socialpageandsearch.allstudionames().get(i).getText().equalsIgnoreCase(studioname))
    	   {
    		  studionameonstudiopage= socialpageandsearch.allstudionames().get(i).getText();
    		  followerscountonstudiopage=socialpageandsearch.followerstext().get(i).getText();
    		   socialpageandsearch.allstudionames().get(i).click();
    		   break;
    	   }
       }
    	String str=Studioprofile.followerscountm().getText();
    	String str1=StringUtils.replace(str, "\n", " ");
       assertEquals(followerscountonstudiopage,str1);
       assertEquals(studionameonstudiopage,Studioprofile.studionameonstudiopagem().getText());
       assertEquals(studioname,studionameonstudiopage);
       assertEquals(studioname,Studioprofile.studionameonstudiopagem().getText());
    }
    @Then("^Follow the (.+) and check followers count incremented and its should matches with studio page$")
    public void follow_the_and_check_followers_count_incremented_and_its_should_matches_with_studio_page(String studioname) throws Throwable {
    	//Studioprofile.scrolldownm();
    	int followerscount=0;
    	String studionameonstudiopage=null;
    	for(int i=0;i< socialpageandsearch.allstudionames().size();i++)
        {
        	if(socialpageandsearch.allstudionames().get(i).getText().equalsIgnoreCase(studioname))
        	{
        		String followscountbefore=socialpageandsearch.followerstext().get(i).getText();
        		String str1before=followscountbefore.substring(0,followscountbefore.lastIndexOf(" "));
        		int followerscountbefore=Integer.parseInt(str1before);
        		log.info(followerscountbefore);
        		studionameonstudiopage=socialpageandsearch.allstudionames().get(i).getText();
        		Actions a=new Actions(driver);
        		a.moveToElement(socialpageandsearch.followbutton().get(i)).click().build().perform();
        		Thread.sleep(1000);
        		assertEquals(Toastanderrormessages.toastmessagem().getText(),"You have started following this studio");
        		Thread.sleep(2000);
        		String follows=socialpageandsearch.followerstext().get(i).getText();
        		String str1=follows.substring(0,follows.lastIndexOf(" "));
        		followerscount=Integer.parseInt(str1);
        		log.info(followerscount);
        		assertEquals(followerscountbefore+1,followerscount);
        		socialpageandsearch.allstudionames().get(i).click();
        		break;
        	}
        }
    	String studionameonstudioprofilepage=Studioprofile.studionameonstudiopagem().getText();
    	String str=Studioprofile.followerscountm().getText();
    	String str1=StringUtils.replace(str, "\n", " ");
    	String str2=str1.substring(0,str1.lastIndexOf(" "));
    	int followerscountonstudioprofilepage=Integer.parseInt(str2);
    	assertEquals(studionameonstudioprofilepage,studionameonstudiopage);
    	assertEquals(followerscountonstudioprofilepage,followerscount);
    	
    }
    @And("^Unfollow the (.+) from following studios and then unfollow studio from studio profile page$")
    public void unfollow_the_from_following_studios_and_then_unfollow_studio_from_studio_profile_page(String studioname) throws Throwable {
        socialpageandsearch.shocialpagem().click();
    	Actions a=new Actions(driver);
    	String studionameonsocialpage = null;
       int followerscount = 0;
    	for(int i=0;i< socialpageandsearch.allstudionames().size();i++)
       {
    	   if(socialpageandsearch.allstudionames().get(i).getText().equalsIgnoreCase(studioname))
    	   {
    		   studionameonsocialpage= socialpageandsearch.allstudionames().get(i).getText();
    		   String str=socialpageandsearch.followerstext().get(i).getText();
    		   String str1=str.substring(0,str.lastIndexOf(" "));
    		   followerscount=Integer.parseInt(str1);
    		   socialpageandsearch.allstudionames().get(i).click();
    		   
    	   }
       }
    	assertEquals(studioname,studionameonsocialpage);
    	String str=Studioprofile.followerscountm().getText();
    	String str1=StringUtils.replace(str, "\n", " ");
    	String str2=str1.substring(0,str1.lastIndexOf(" "));
    	int followerscountonstudioprofilepage=Integer.parseInt(str2);
    	assertEquals(followerscountonstudioprofilepage,followerscount);
    	Studioprofile.studioinfom().click();
    	Thread.sleep(1000);
    	a.moveToElement(Studioprofile.unfollowstudiom()).click().build().perform();
    	Thread.sleep(1000);
    	a.moveToElement(Studioprofile.unfollowbuttonm()).click().build().perform();
    	driver.navigate().back();
    	Thread.sleep(2000);
    	socialpageandsearch.shocialpagem().click();
    	socialpageandsearch.socialpagetitlesfornewuser().get(2).click();
    	for(int j=0;j<socialpageandsearch.allstudionames().size();j++)
    	{
    		if(socialpageandsearch.allstudionames().get(j).getText().equalsIgnoreCase(studioname))
    		{
    			socialpageandsearch.allstudionames().get(j).getText();
    			String str3=socialpageandsearch.followerstext().get(j).getText();
    			String str4=str3.substring(0,str3.lastIndexOf(" "));
    			int followerscountinstudiopage=Integer.parseInt(str4);
    			assertEquals(followerscount-1,followerscountinstudiopage);
    		}
    	}
    	
    	
    	
    }*/


