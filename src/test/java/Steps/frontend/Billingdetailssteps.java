package Steps.frontend;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.frontend.Paymentpage;
import PageObjects.frontend.Shoorseriesdetailpage;
import PageObjects.frontend.Studioprofile;
import PageObjects.frontend.Toastanderrormessages;
import Resources.Base_setup;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class Billingdetailssteps extends Base_setup {
	
	 public static Logger log=Logger.getLogger(Billingdetailssteps.class.getName());
	 WebDriverWait wait=new WebDriverWait(driver,30);
	 JavascriptExecutor js=(JavascriptExecutor)driver;
	 
	@Then("^Add billing details$")
    public void add_billing_details() throws Throwable {
		Shoorseriesdetailpage.playorbuybuttonm().click();
		wait.until(ExpectedConditions.visibilityOf(Paymentpage.addbillingadressbuttonm()));
		Studioprofile.scrolldownm();
		Actions a=new Actions(driver);
		a.moveToElement(Paymentpage.addbillingadressbuttonm()).click().build().perform();
        Paymentpage.billingdetailsinput("Guindy");
        Paymentpage.updatebutton().click();
        assertEquals(Toastanderrormessages.toastmessagem().getText(),"Address added successfully.");
        log.info(Paymentpage.billingaddressafterupdate().getText());
	}

	 @Then("^without address the (.+)$")
	 public void without_address_the(String errormessage) throws Throwable {
        assertEquals(Paymentpage.errormessagebilling().getText(),errormessage);
        Paymentpage.closeicon().click();
    }
	 @And("^placeholder values$")
	 public void placeholder_values() throws Throwable {
		 wait.until(ExpectedConditions.elementToBeClickable(Shoorseriesdetailpage.playorbuybuttonm()));
		 Shoorseriesdetailpage.playorbuybuttonm().click();
		 wait.until(ExpectedConditions.visibilityOf(Paymentpage.addbillingadressbuttonm()));
		 Studioprofile.scrolldownm();
		 Actions a =new Actions(driver);
		 a.moveToElement(Paymentpage.addbillingadressbuttonm()).click().build().perform();
	     wait.until(ExpectedConditions.visibilityOf(Paymentpage.billingdetailtext()));
		 assertEquals(Paymentpage.billingdetailtext().getText(),"Billing Address");
		 assertEquals(Paymentpage.youlocationtextplaceholder().getText(),"Your Location");
		 assertEquals(Paymentpage.addressplaceholder().getText(),"Address");
		 assertEquals(Paymentpage.billingadressfield().getAttribute("placeholder"),"Enter a location");
		 Paymentpage.updatebutton().click();
		 
	    }
	 @Then("^Try to buy the show without billing details$")
	 public void try_to_buy_the_show_without_billing_details() throws Throwable {
	       Shoorseriesdetailpage.playorbuybuttonm().click();
	       wait.until(ExpectedConditions.visibilityOf(Paymentpage.addbillingadressbuttonm()));
	       Paymentpage.carddetails();
	       Paymentpage.paybuttonm();
	    }
	 @Then("^Chnage the address by cliking on link$")
	 public void chnage_the_address_by_cliking_on_link() throws Throwable {
		 Shoorseriesdetailpage.playorbuybuttonm().click();
		 wait.until(ExpectedConditions.visibilityOf(Paymentpage.addbillingadressbuttonm()));
		 Studioprofile.scrolldownm();
		 String beforeaddressupdate=Paymentpage.billingaddressafterupdate().getText();
		 Paymentpage.changelink().click();
		 wait.until(ExpectedConditions.visibilityOf(Paymentpage.billingdetailtext()));
		 Paymentpage.billingadressfield().clear();
		 Paymentpage.billingdetailsinput("greamsroad");
		 wait.until(ExpectedConditions.elementToBeClickable(Paymentpage.updatebutton()));
		 Paymentpage.updatebutton().click();
		 assertEquals(Toastanderrormessages.toastmessagem().getText(),"Address changed successfully.");
		 log.info(Paymentpage.billingaddressafterupdate().getText());
		 assertNotEquals(Paymentpage.billingaddressafterupdate().getText(),beforeaddressupdate);
		 
	    }



}
