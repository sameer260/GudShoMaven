package Steps.frontend;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Formatter;
import java.util.List;


import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.frontend.Accountandsettings;
import PageObjects.frontend.Paymentpage;
import PageObjects.frontend.Shoorseriesdetailpage;
import PageObjects.frontend.Studioprofile;
import PageObjects.frontend.Toastanderrormessages;
import PageObjects.frontend.videoandaudioPlayer;
import Resources.Base_setup;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Paymentpages extends Base_setup{
	
	public static Logger log=Logger.getLogger(Paymentpages.class.getName());
    WebDriverWait wait=new WebDriverWait(driver,20);
	
	@When("^Cross verify the sho or series details with payment page$")
    public void cross_verify_the_sho_or_series_details_with_payment_page() throws Throwable {
		String str=Shoorseriesdetailpage.studionameonshodetailpagem().getText();
		String shoname=Shoorseriesdetailpage.shonameinshodetailspage().getText();
		String shonamelabel=Shoorseriesdetailpage.shoorseriestagm().getText();
		log.info(shonamelabel);
		log.info(shoname);
		log.info(str);
		wait.until(ExpectedConditions.elementToBeClickable(Shoorseriesdetailpage.playorbuybuttonm()));
		Shoorseriesdetailpage.playorbuybuttonm().click();
		wait.until(ExpectedConditions.visibilityOf(Paymentpage.studionamem()));
		String str1=Paymentpage.studionamem().getText()+"'s";
		log.info(str1);
        assertTrue(Paymentpage.thumbimagem().isDisplayed());
        assertTrue(str1.equalsIgnoreCase(str));
        log.info(Paymentpage.presentstextm().getText());
        assertEquals(Paymentpage.presentstextm().getText(),"PRESENTS");
        log.info(Paymentpage.shoorseriesnamem().getText());
        assertEquals(shoname+" "+shonamelabel,Paymentpage.shoorseriesnamem().getText());
    }
	    @When("^Check the validity of sho or series (.+) and (.+)$")
	    public void check_the_validity_of_sho_or_series_and(String days, String hours) throws Throwable {
		Shoorseriesdetailpage.playorbuybuttonm().click();
		wait.until(ExpectedConditions.visibilityOf(Paymentpage.studionamem()));
		List<WebElement> alltext=Paymentpage.validitym();
		for(WebElement ele:alltext)
		{
			assertTrue(ele.isDisplayed());
			String str=ele.getText();
			String str1=str.replaceAll("[\\n\\t ]", " ");
			//String str1=StringUtils.replace(str, "\n", " ");
			log.info(str1);
		}
		assertEquals(Paymentpage.validitym().get(0).getText(),"Rental Validity :");
		assertEquals(Paymentpage.validitym().get(2).getText(),"Watchtime :");
		assertEquals(Paymentpage.validitym().get(1).getText(),days+" Days");
		assertEquals(Paymentpage.validitym().get(3).getText(),hours+" hrs");
		String str=Paymentpage.validitytextm().getText();
		assertEquals(str,"You can watch the film multiple times duration the " + hours +" hour period within "+ days +" days. This is non-refundable transaction.");
        }
	    @When("^Check the validty text if there is no text$")
	    public void check_the_validty_text_if_there_is_no_text() throws Throwable {
	    	Shoorseriesdetailpage.playorbuybuttonm().click();
	    	wait.until(ExpectedConditions.visibilityOf(Paymentpage.studionamem()));
			log.info(Paymentpage.validitytextm().getText());
	    	assertEquals(Paymentpage.validitytextm().getText(),"There is no watching time validity for this sho, you can watch this anywhere at anytime.");
	    }
	    @When("^check billing details (.+) and (.+)$")
	    public void check_billing_details_and(String username, String useremail) throws Throwable {
	    	String str=Shoorseriesdetailpage.playorbuybuttonm().getText();
	    	String str1=str.substring(4);
	    	log.info(str1);
	    	Shoorseriesdetailpage.playorbuybuttonm().click();
	    	wait.until(ExpectedConditions.visibilityOf(Paymentpage.studionamem()));
	    	assertTrue(Paymentpage.billingdetailsheadingm().isDisplayed());
	        assertEquals(Paymentpage.billingdetailsheadingm().getText(),"Billing Details");
	        assertEquals(Paymentpage.usernamelabelm().getText(),"User Name");
	        assertEquals(Paymentpage.UserEmaillabelm().getText(),"User Email");
	        assertEquals(Paymentpage.Billingdatelabelm().getText(),"Billing Date");
	        assertEquals(Paymentpage.Billingamountlabelm().getText(),"Grand Total");
	        assertTrue(Paymentpage.Username().getText().equalsIgnoreCase(username));
	        assertEquals(Paymentpage.UserEmail().getText(),useremail);
	        Formatter dateformat = new Formatter();
		    Calendar cal = Calendar.getInstance();
		    dateformat.format("%td %tb %tY", cal, cal, cal);
		    String presentdate=dateformat.toString();
		    log.info(presentdate);
		    log.info(Paymentpage.Billingdate().getText());
		    assertEquals(presentdate,Paymentpage.Billingdate().getText());
		    log.info(Paymentpage.Billingamount().getText());
		    assertEquals(Paymentpage.Billingamount().getText(),str1);

	        log.info(Paymentpage.notem().getText());
	        assertEquals(Paymentpage.notem().getText(),"I am over 18, And by clicking \"Pay\" you agree to the Terms and Conditions.");
	        Paymentpage.paybuttonm();
	    }
	    
	     @Then("^Click on buy button and do not give any details and check errormessages$")
	     public void click_on_buy_button_and_do_not_give_any_details_and_check_errormessages() throws Throwable {
	        Shoorseriesdetailpage.playorbuybuttonm().click();
	        Paymentpage.expiryyearm().sendKeys("0221");
	        Paymentpage.cvvnom().sendKeys("123");
	        Paymentpage.nameoncardm().sendKeys("sameer");
	        Paymentpage.paybuttonm();
	        assertEquals(Paymentpage.errormessage().getText(),"Card number required");
	        driver.navigate().refresh();
	        Thread.sleep(2000);
	        Shoorseriesdetailpage.playorbuybuttonm().click();
	        Paymentpage.cardnom().sendKeys("4111111111111111");
	        Paymentpage.cvvnom().sendKeys("123");
	        Paymentpage.nameoncardm().sendKeys("sameer");
	        Paymentpage.paybuttonm();
	        assertEquals(Paymentpage.errormessage().getText(),"Valid upto is Required");
	        driver.navigate().refresh();
	        Thread.sleep(2000);
	        Shoorseriesdetailpage.playorbuybuttonm().click();
	        Paymentpage.cardnom().sendKeys("4111111111111111");
	        Paymentpage.expiryyearm().sendKeys("0221");
	        Paymentpage.nameoncardm().sendKeys("sameer");
	        Paymentpage.paybuttonm();
	        assertEquals(Paymentpage.errormessage().getText(),"Cvv is Required");
	        driver.navigate().refresh();
	        Thread.sleep(2000);
	        Shoorseriesdetailpage.playorbuybuttonm().click();
	        Paymentpage.cardnom().sendKeys("4111111111111111");
	        Paymentpage.expiryyearm().sendKeys("0221");
	        Paymentpage.cvvnom().sendKeys("123");
	        Paymentpage.paybuttonm();
	        assertEquals(Paymentpage.errormessage().getText(),"Name is Required");
	        driver.navigate().refresh();
	        Thread.sleep(2000);
	        Shoorseriesdetailpage.playorbuybuttonm().click();
	        Paymentpage.cardnom().sendKeys("4111111111111111");
	        Paymentpage.expiryyearm().sendKeys("0221");
	        Paymentpage.cvvnom().sendKeys("123");
	        Paymentpage.nameoncardm().sendKeys("#$%3");
	        Paymentpage.paybuttonm();
	        assertEquals(Paymentpage.errormessage().getText(),"Name is Invalid");
	    }
	     public String textonbuybutton;
	     
	     @When("^Click on Buy button and do payment with (.+)$")
		    public void click_on_buy_button_and_do_payment_with(String paymentmethod) throws Throwable {
				    Shoorseriesdetailpage.playorbuybuttonm().click();
				    textonbuybutton=Shoorseriesdetailpage.playorbuybuttonm().getText();
				    wait.until(ExpectedConditions.visibilityOf(Paymentpage.studionamem()));
				    log.info(Paymentpage.paymentpageheadingm().getText());
				    assertEquals(Paymentpage.paymentpageheadingm().getText(),"Select Payment Methods");
				    String shoorserieslabel=Paymentpage.shoorserieslabelm().getText();
				    log.info(shoorserieslabel);
				    Paymentpage.paymentsmethodsm(paymentmethod);
			        Paymentpage.carddetails();
			        Paymentpage.paybuttonm();
			        Thread.sleep(1000);
			        
			        
			    }
	     @And("^Fail the payment$")
	     public void fail_the_payment() throws Throwable {
	    	 Paymentpage.failedwindow();
	     }
	     @And("^check toastmessage and again click try again$")
	     public void check_toastmessage_and_again_click_try_again() throws Throwable {
	    	 //wait.until(ExpectedConditions.visibilityOf(Toastanderrormessages.erralerdailogm()));
	        log.info(Toastanderrormessages.toastmessagem().getText());
	        assertEquals(Toastanderrormessages.erralerdailogm().getText(),"Transaction Failed. We regret to inform that your payment has failed, Please Try Again!");
	        assertEquals(Paymentpage.transcationunsuccesfullm().getText(),"Transaction UnSuccessful");
	        
	     }
	     @And("^Click on try again button and this time close the window$")
	     public void click_on_try_again_button_and_this_time_close_the_window() throws Throwable {
	    	    Paymentpage.tryagainbutton().click();
		        Paymentpage.carddetails();
		        Paymentpage.paybuttonm();
		        Thread.sleep(3000);
		        Paymentpage.closewindow();
		        log.info(Toastanderrormessages.toastmessagem().getText());
		        assertEquals(Toastanderrormessages.erralerdailogm().getText(),"Transaction Failed. We regret to inform that your payment has failed, Please Try Again!");
		        assertEquals(Paymentpage.transcationunsuccesfullm().getText(),"Transaction UnSuccessful");
		       
	     }
	     @And("^Fail transaction come back to sho or series detail page$")
	     public void fail_transaction_come_back_to_sho_or_series_detail_page() throws Throwable {
	         Paymentpage.backbutton().click();
	         assertTrue(Shoorseriesdetailpage.shonameinshodetailspage().isDisplayed());
	         assertTrue(Shoorseriesdetailpage.playorbuybuttonm().isDisplayed());
	         assertEquals(Shoorseriesdetailpage.playorbuybuttonm().getText(),textonbuybutton);
	     }
	     @When("^Buy the sho or series with (.+) and verify the details of transaction page$")
	     public void buy_the_sho_or_series_with_and_verify_the_details_of_transaction_page(String paymentmethod) throws Throwable {
	    	    textonbuybutton=Shoorseriesdetailpage.playorbuybuttonm().getText();
	    	    Shoorseriesdetailpage.playorbuybuttonm().click();
			    String amountonshodetailpage=textonbuybutton.substring(4);
			    Thread.sleep(1000);
			    String username=Paymentpage.Username().getText();
			    log.info(username);
			    String userEmail=Paymentpage.UserEmail().getText();
			    log.info(userEmail);
			    String str1=Paymentpage.shoorseriesnamem().getText();
			    String shoorseriesname=str1.substring(0,str1.lastIndexOf(" "));
			    log.info(shoorseriesname);
			    String amount=Paymentpage.Billingamount().getText();
			    log.info(amount);
			    log.info(Paymentpage.paymentpageheadingm().getText());
			    assertEquals(Paymentpage.paymentpageheadingm().getText(),"Select Payment Methods");
			    String shoorserieslabelonpaymentpage=Paymentpage.shoorserieslabelm().getText();
			    Paymentpage.paymentsmethodsm(paymentmethod);
		        Paymentpage.carddetails();
		        Paymentpage.paybuttonm();
		        Thread.sleep(3000);
	         Paymentpage.successwindowhandle();
	         Thread.sleep(1500);
	         log.info(Toastanderrormessages.erralerdailogm().getText());
	         assertEquals(Toastanderrormessages.erralerdailogm().getText(),"Thank you for your payment. Order Completed Successfully!");
	         assertTrue(Paymentpage.transactionsuccess().isDisplayed());
	         assertEquals(Paymentpage.transactionsuccess().getText(),"Transaction Successful");
	         //assertEquals(Paymentpage.Amountpaidtext().getText(),"Amount paid :");
	         String str=Paymentpage.amountontransactionpage().getText();
	         assertEquals(str,amountonshodetailpage);
	         assertEquals(Paymentpage.paymentdetailheading().getText(),"Payment Details");
	         assertEquals(Paymentpage.usernamelabelontransaction().getText(),"User Name");
	         assertEquals(Paymentpage.useremaillabelontransaction().getText(),"User Email");
	         assertEquals(Paymentpage.transactionidlabelontransaction().getText(),"Transaction ID");
	         assertEquals(Paymentpage.shoseriesnamelabelontransaction().getText(),shoorserieslabelonpaymentpage+" Name");
	         assertEquals(amount,str);
	         assertEquals(Paymentpage.usernameontransaction().getText(),username);
	         assertEquals(Paymentpage.useremailontransaction().getText(),userEmail);
	         assertEquals(Paymentpage.shoseriesnameontransaction().getText(),shoorseriesname);
	         String shoorseriname=Paymentpage.shoseriesnameontransaction().getText();
	         assertTrue(Paymentpage.transactionidontransaction().isDisplayed());
	         log.info(Paymentpage.transactionidontransaction().getText());
	         assertTrue(Paymentpage.thankumessageforuser().isDisplayed());
	         assertEquals(Paymentpage.thankumessageforuser().getText(),"Yay! Thank you for choosing GudSho. Now you can watch "+shoorseriname+" from anywhere, anytime. There's absolutely no expiry date for this purchase. Enjoy!");
	         
	     }
	     @And("^Click on play button after successfull bought$")
	     public void click_on_play_button_after_successfull_bought() throws Throwable {
	         Paymentpage.playbuttonafterbuym().click();
	         Thread.sleep(5000);
	         videoandaudioPlayer.mousehoveronplayerm();
	         videoandaudioPlayer.closeplayerm().click();
	         
	     }
	     @And("^Click on continue button$")
	     public void click_on_continue_button() throws Throwable {
	         Paymentpage.continueafterbuym().click();
	         assertEquals(Shoorseriesdetailpage.playorbuybuttonm().getText(),"Play");
	         Studioprofile.scrolldownm();
	         assertEquals(Shoorseriesdetailpage.playorbuybuttonsmallm().getText(),"Play");
	         Shoorseriesdetailpage.playorbuybuttonsmallm().click();
	         Thread.sleep(5000);
	         videoandaudioPlayer.mousehoveronplayerm();
	         videoandaudioPlayer.closeplayerm().click();
	     }
	     @When("^Buy the Sho or seires by choosing (.+) and  with (.+)$")
	     public void buy_the_sho_or_seires_by_choosing_and_with(String paymentmethod, String upiid) throws Throwable {
	    	 Studioprofile.scrolldownm();
	         Shoorseriesdetailpage.playorbuybuttonsmallm().click();
	         Thread.sleep(500);
	         Paymentpage.paymentsmethodsm(paymentmethod);
	         Paymentpage.upiid().sendKeys(upiid);
	         Paymentpage.UPIpaybutton().click();
	         Thread.sleep(5000);
	         log.info(Toastanderrormessages.toastmessagem().getText());
	         assertEquals("Payment Processed",Toastanderrormessages.toastmessagem().getText());
	         
	         
	         
	     }
	     @Then("^Check in the payment tab (.+) is showing with (.+) and (.+)$")
	     public void check_in_the_payment_tab_is_showing_with_and(String shoseriesorstudioname, String text, String paymentmethod) throws Throwable {
	         Shoorseriesdetailpage.playorbuybuttonm().click();
	         Thread.sleep(1000);
	         if(paymentmethod.equalsIgnoreCase("Card"))
	         {
	        	 Paymentpage.carddetails();
		         Paymentpage.paybuttonm(); 
	         }else if(paymentmethod.equalsIgnoreCase("UPI"))
	         {
	        	 Paymentpage.paymentsmethodsm(paymentmethod);
	        	 Paymentpage.upiid().sendKeys("sameer@ybl");
		         Paymentpage.UPIpaybutton().click();
		         Thread.sleep(5000);
	         }
	         String studioname= Paymentpage.studionamem().getText();
	         log.info(studioname);
	         String str=Paymentpage.shoorseriesnamem().getText();
	         String shoorseriename=str.substring(0,str.lastIndexOf(" "));
	         log.info(shoorseriename);
	         String Shoorserieslabel= Paymentpage.shoorserieslabelm().getText();
	         log.info(Shoorserieslabel);
	         String billingamount=Paymentpage.Billingamount().getText();
	         log.info(billingamount);
	         String billingdate= Paymentpage.Billingdate().getText();
	         log.info(billingdate);
	        
	         Thread.sleep(3000);
	         if(text.equalsIgnoreCase("Failed"))
	         {
	        	 Paymentpage.failedwindow();
	        	 assertEquals(Toastanderrormessages.toastmessagem().getText(),"Transaction Failed. We regret to inform that your payment has failed, Please Try Again!");
	         }
	         else if(text.equalsIgnoreCase("Success"))
	         {
	        	 if(paymentmethod.equalsIgnoreCase("UPI")) {
	        		 assertEquals(Toastanderrormessages.toastmessagem().getText(),"Payment Processed");
	        	 }
	        	 else {
	        	Paymentpage.successwindowhandle(); 
	        	assertEquals(Toastanderrormessages.toastmessagem().getText(),"Thank you for your payment. Order Completed Successfully!");
	                }
	         } 	 
	         
	         Toastanderrormessages.toastmessageclosem().click();
	         Actions a=new Actions(driver);
	         a.moveToElement(Accountandsettings.mousehoveronprofilem()).build().perform();
	         Accountandsettings.accountandsettingslinkm().click();
	         Thread.sleep(500);
	         Accountandsettings.Paymentstab().click();
	         Thread.sleep(1500);
	         for(int i=0;i<Accountandsettings.shoorseriesnames().size();i++)
	         {
	        	 if(Accountandsettings.shoorseriesnames().get(i).getText().equalsIgnoreCase(shoorseriename))
	        	 {
	        		assertTrue(Accountandsettings.shoorseriesnames().get(i).getText().equalsIgnoreCase(shoorseriename));
	        		assertTrue(Accountandsettings.shoorseriesnamelabel().get(i).getText().equalsIgnoreCase(Shoorserieslabel));
	        		assertTrue(Accountandsettings.rows().get(2).getText().equalsIgnoreCase(studioname));
	        		assertEquals(Accountandsettings.rows().get(3).getText(),paymentmethod);
	        		assertTrue(Accountandsettings.rows().get(4).getText().equalsIgnoreCase(billingdate));
	        		assertTrue(Accountandsettings.rows().get(5).getText().equalsIgnoreCase(billingamount));
	        		/*JavascriptExecutor js=(JavascriptExecutor)driver;
	        		String message=(String) (js.executeScript("return arguments[0].innerHTML",Accountandsettings.rows().get(6)));*/
	        		String message=Accountandsettings.successtext().getText();
	        		log.info(message);
	        		assertEquals(message,text);
	        		break;
	        	 }
	         }
	     }

	     @Given("^Check all the headings are displaying$")
	     public void check_all_the_headings_are_displaying() throws Throwable {
	    	 Actions a=new Actions(driver);
	         a.moveToElement(Accountandsettings.mousehoveronprofilem()).build().perform();
	    	 Accountandsettings.accountandsettingslinkm().click();
	         Thread.sleep(500);
	         Accountandsettings.Paymentstab().click();
	         Thread.sleep(1000);
	    	 assertTrue(Accountandsettings.tablehead().get(0).isDisplayed());
	    	 assertEquals(Accountandsettings.tablehead().get(0).getText(),"Sho/Series");
	    	 log.info(Accountandsettings.tablehead().get(0).getText());
	    	 assertTrue(Accountandsettings.tablehead().get(1).isDisplayed());
	    	 assertEquals(Accountandsettings.tablehead().get(1).getText(),"Transaction ID");
	    	 log.info(Accountandsettings.tablehead().get(1).getText());
	    	 assertTrue(Accountandsettings.tablehead().get(2).isDisplayed());
	    	 assertEquals(Accountandsettings.tablehead().get(2).getText(),"Studio");
	    	 log.info(Accountandsettings.tablehead().get(2).getText());
	    	 assertTrue(Accountandsettings.tablehead().get(3).isDisplayed());
	    	 assertEquals(Accountandsettings.tablehead().get(3).getText(),"Payment Modes");
	    	 log.info(Accountandsettings.tablehead().get(3).getText());
	    	 assertTrue(Accountandsettings.tablehead().get(4).isDisplayed());
	    	 assertEquals(Accountandsettings.tablehead().get(4).getText(),"Date");
	    	 log.info(Accountandsettings.tablehead().get(4).getText());
	    	 assertTrue(Accountandsettings.tablehead().get(5).isDisplayed());
	    	 assertEquals(Accountandsettings.tablehead().get(5).getText(),"Price");
	    	 log.info(Accountandsettings.tablehead().get(5).getText());
	    	 assertTrue(Accountandsettings.tablehead().get(6).isDisplayed());
	    	 assertEquals(Accountandsettings.tablehead().get(6).getText(),"Status");
	    	 log.info(Accountandsettings.tablehead().get(6).getText());
	     }
	     @Given("^Check all pagination scenarios$")
	     public void check_all_pagination_scenarios() throws Throwable {
	    	 Actions a=new Actions(driver);
	         a.moveToElement(Accountandsettings.mousehoveronprofilem()).build().perform();
	    	 Accountandsettings.accountandsettingslinkm().click();
	         Thread.sleep(500);
	         Accountandsettings.Paymentstab().click();
	         Thread.sleep(1000);
	         assertEquals(Accountandsettings.paginatortext().getText(),"Items per page:");
	         Thread.sleep(1000);
	         log.info(Accountandsettings.paginatordropdown().getText());
	         
	         a.moveToElement(Accountandsettings.paginatordropdown()).click().build().perform();
	         String first=Accountandsettings.paginatornumberindropdown().get(0).getText();
	         log.info(first);
	         a.moveToElement(Accountandsettings.paginatornumberindropdown().get(0)).click().build().perform();
	         assertEquals(Accountandsettings.paginatordropdown().getText(),first);
	         int rowscount=Accountandsettings.allrowscountperpage().size();
	         log.info(rowscount);
	         String str=Accountandsettings.paginationnumbers().getText();
	         String paginationnum1=str.substring(0,str.lastIndexOf(" of"));
	         log.info(paginationnum1);
	         assertEquals(paginationnum1,"1 – "+ rowscount);
	         
	         Thread.sleep(1000);
	         a.moveToElement(Accountandsettings.paginatordropdown()).click().build().perform();
	         String second=Accountandsettings.paginatornumberindropdown().get(1).getText();
	         log.info(second);
	         a.moveToElement(Accountandsettings.paginatornumberindropdown().get(1)).click().build().perform();
	         assertEquals(Accountandsettings.paginatordropdown().getText(),second);
	         Thread.sleep(1500);
	         int rowscount1=Accountandsettings.allrowscountperpage().size();
	         log.info(rowscount1);
	         String str1=Accountandsettings.paginationnumbers().getText();
	         String paginationnum2=str1.substring(0,str1.lastIndexOf(" of"));
	         log.info(paginationnum2);
	         assertEquals(paginationnum2,"1 – "+ rowscount1);
	         
	         Thread.sleep(1000);
	         a.moveToElement(Accountandsettings.paginatordropdown()).click().build().perform();
	         String third=Accountandsettings.paginatornumberindropdown().get(2).getText();
	         log.info(third);
	         a.moveToElement(Accountandsettings.paginatornumberindropdown().get(2)).click().build().perform();
	         assertEquals(Accountandsettings.paginatordropdown().getText(),third);
	         Thread.sleep(1500);
	         int rowscount2=Accountandsettings.allrowscountperpage().size();
	         log.info(rowscount2);
	         String str2=Accountandsettings.paginationnumbers().getText();
	         String paginationnum3=str2.substring(0,str2.lastIndexOf(" of"));
	         log.info(paginationnum3);
	         assertEquals(paginationnum3,"1 – "+ rowscount2);
	         
	         
	     }
			  
		

}
