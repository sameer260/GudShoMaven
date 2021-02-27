package Steps.frontend;

import static org.junit.Assert.assertEquals;


import org.apache.log4j.Logger;

import PageObjects.frontend.Toastanderrormessages;
import Resources.Base_setup;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;


public class Toastmessageanderrormessagesteps extends Base_setup
{
	
	public static Logger log=Logger.getLogger(Toastmessageanderrormessagesteps.class.getName());
	
	@Then("^verify error (.+)$")
    public void verify_error(String toastmessage) throws Throwable {
       String Actual= Toastanderrormessages.erralerdailogm().getText();
       log.info("Expected errortoast message is:" + toastmessage);
       log.info("The ErrorToast message show as:" + Actual);
       assertEquals(Actual,toastmessage);
    }
	@Then("^(.+) should display$")
    public void should_display(String errormessage) throws Throwable {
        String Actual=Toastanderrormessages.errormessagem().getText();
        log.info("Expected errormessage as:" + errormessage);
        log.info("Errormessage displayed when enters wrong input:" + Actual);
        assertEquals(Actual,errormessage);
    }
	@And("^verify the (.+)$")
    public void verify_the(String toastmessage) throws Throwable {
    	String Actual=Toastanderrormessages.toastmessagem().getText();
    	log.info("Expected toast message:" + toastmessage);
    	log.info("Actual Toast message displayed as:" + Actual);
        assertEquals(Actual,toastmessage);
        Toastanderrormessages.toastmessageclosem().click();
    }

}
