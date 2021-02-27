package PageObjects.frontend;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Resources.Base_setup;

public class Paymentpage  extends Base_setup {
	
	private static By cardno=By.id("card-number");
	private static By paymentsection=By.xpath("//div[@class='payments-inner']");
	private static By backicon=By.xpath("//div[@class='back-arrow']/a/mat-icon");
	private static By paymentsmethods=By.xpath("//div[@class='card-sidebar']//app-cards-list/ul/li");
	private static By expiryyear=By.id("expires_at");
	private static By cvvno=By.id("key_no");
	private static By nameoncard=By.id("name");
	private static By savethiscard=By.xpath("//div[@class='mat-checkbox-inner-container']");
	private static By paybutton=By.xpath("//div[@class='cards-info']/app-card-payments/form/button[1]");
	private static By successbutton=By.xpath("//button[text()='Success']");
	private static By failurebutton=By.xpath("//button[text()='Failure']");
	private static By thumbimage=By.xpath("//div[@class='movie-thumb']");
	private static By studioname=By.xpath("//div[@class='movie-details']/h6");
	private static By presentstext=By.xpath("//div[@class='movie-details']/h5");
	private static By shoorseriesname=By.xpath("//div[@class='movie-details']/h3");
	private static By shoorserieslabel=By.xpath("//div[@class='movie-details']/h3/span");
	private static By validity=By.xpath("//div[@class='duration-left']/span");
	private static By validitytext=By.xpath("//div[@class='purchase-info']/p");
	private static By paymentpageheading=By.xpath("//h3[@class='desc']");
	private static By transcationunsuccesfull=By.xpath("//div[@class='transaction-block']/h3");
	
	private static By billingdetailsheading=By.xpath("//h6[@class='billing-title']");
	private static By Username=By.xpath("//ul[@class='customer-details']/li[1]/p");
	private static By usernamelabel=By.xpath("//ul[@class='customer-details']/li[1]/h4");
	private static By UserEmail=By.xpath("//ul[@class='customer-details']/li[2]/p");
	private static By UserEmaillabel=By.xpath("//ul[@class='customer-details']/li[2]/h4");
	private static By Billingdate=By.xpath("//ul[@class='customer-details']/li[3]/p");
	private static By Billingdatelabel=By.xpath("//ul[@class='customer-details']/li[3]/h4");
	private static By Billingamount=By.xpath("//ul[@class='customer-details']/li[4]/p");
	private static By Billingamountlabel=By.xpath("//ul[@class='customer-details']/li[4]/h4");
	//add billing details
	private static By addbillingadressbutton=By.xpath("//div[@class='payment-right']/app-billing-details/div[2]");
	private static By billingdetailtext=By.xpath("//div[@class='mat-dialog-header']/h5");
	private static By youlocationtextplaceholder=By.xpath("//p[@class='location-mark']");
	private static By addressplaceholder=By.xpath("//label[@class='focused']");
	private static By billingadressfield=By.id("billingAddress");
	private static By updatebutton=By.xpath("//div[@class='submit-location']/button");
	private static By closeicon=By.xpath("//div[@class='cards-info']/div/div");
	private static By errormessagebilling=By.xpath("//div[@class='error ng-star-inserted']");
	private static By changelink=By.xpath("//span[@class='blue change cursor']");
	private static By billingaddressafterupdate=By.xpath("//div[@class='billing-address changed ng-star-inserted']/p");
	//Transaction window
	private static By note=By.xpath("//p[@class='note']");
	private static By Transcationunsuccefullmessage=By.xpath("//div[@class='transaction-block']/h1");
	private static By tryagainbutton=By.xpath("//div[@class='transaction-block']/button[1]");
	private static By backbutton=By.xpath("//div[@class='transaction-block']/button[2]");
	private static By buytextonbuybutton=By.xpath("//ul[@class='shocial-ticket-actions']/li/button/span");
	private static By errormessage=By.xpath("//div[@class='error ng-star-inserted']/div");
	private static By Comingsoontext=By.xpath("//div[@class='appviewpoint']/ul/li/span");
	private static By notifysoontext=By.xpath("//div[@class='appviewpoint']/ul/li/button/code");
	private static By UPIpaybutton=By.xpath("//span[text()='Pay']");
	private static By upiid=By.id("virtualaddress");
	//Transaction successfull
	private static By playbuttonafterbuy=By.xpath("//div[@class='transaction-block']/div[4]/button[2]");
	private static By continueafterbuy=By.xpath("//div[@class='transaction-block']/div[4]/button[1]");
	private static By transactionsuccess=By.xpath("//div[@class='transaction-payment']/div/h3");
	private static By Amountpaidtext=By.xpath("//div[@class='payment-amount ng-star-inserted']/h2");
	private static By amountontransactionpage=By.xpath("//div[@class='payment-amount ng-star-inserted']/h2/span");
	private static By paymentdetailheading=By.xpath("//div[@class='payments-detail ng-star-inserted']/h4");
	private static By usernamelabelontransaction=By.xpath("//div[@class='payments-detail ng-star-inserted']/ul/li[1]/p");
	private static By useremaillabelontransaction=By.xpath("//div[@class='payments-detail ng-star-inserted']/ul/li[2]/p");
	private static By seriesnamelabelontransaction=By.xpath("//div[@class='payments-detail ng-star-inserted']/ul/li[3]/p");
	private static By transactionidlabelontransaction=By.xpath("//div[@class='payments-detail ng-star-inserted']/ul/li[4]/p");
	private static By usernameontransaction=By.xpath("//div[@class='payments-detail ng-star-inserted']/ul/li[1]/span");
	private static By useremailontransaction=By.xpath("//div[@class='payments-detail ng-star-inserted']/ul/li[2]/span");
	private static By seriesnameontransaction=By.xpath("//div[@class='payments-detail ng-star-inserted']/ul/li[3]/span");
	private static By transactionidontransaction=By.xpath("//div[@class='payments-detail ng-star-inserted']/ul/li[4]/span");
	private static By thankumessageforuser=By.xpath("//p[@class='info']");
	
	
	
	public static WebElement cardnom()
	{
		return driver.findElement(cardno);
	}
	public static WebElement expiryyearm()
	{
		return driver.findElement(expiryyear);
	}
	public static WebElement cvvnom()
	{
		return driver.findElement(cvvno);
	}
	public static WebElement nameoncardm()
	{
		return driver.findElement(nameoncard);
	}
	public static WebElement savethiscardm()
	{
		return driver.findElement(savethiscard);
	}
	public static  WebElement paymentsectionm()
	{
		return driver.findElement(paymentsection);
	}
	public static WebElement backiconm()
	{
		return driver.findElement(backicon);
	}
	public static List<WebElement> paymentsmethodsm()
	{
		 return driver.findElements(paymentsmethods);
	}
	public static void paymentsmethodsm(String paymentmethod)
	{
		List<WebElement> ele=driver.findElements(paymentsmethods);
		int size=ele.size();
		for(int i=0;i<size;i++)
		{
			String str=driver.findElements(paymentsmethods).get(i).getText();
			if(str.equalsIgnoreCase(paymentmethod))
			{
				driver.findElements(paymentsmethods).get(i).click();
				break;
			}
		}
	}
	public static void carddetails()
	{
		
		driver.findElement(cardno).sendKeys("4111111111111111");
		driver.findElement(expiryyear).sendKeys("0221");
		driver.findElement(cvvno).sendKeys("123");
		driver.findElement(nameoncard).sendKeys("sameer");
		driver.findElement(savethiscard).click();
		
	}
	public static void paybuttonm()
	{
		 driver.findElement(paybutton).click();
	}
	public static void successwindowhandle()
	{
		
	    String MainWindow=driver.getWindowHandle();				
        Set<String> s1=driver.getWindowHandles();		
        Iterator<String> i1=s1.iterator();			
        while(i1.hasNext())			
        {		
         String ChildWindow=i1.next();		
        		
         if(!MainWindow.equalsIgnoreCase(ChildWindow))			
         {    		
                driver.switchTo().window(ChildWindow);
                WebDriverWait wait=new WebDriverWait(driver,20);
                wait.until(ExpectedConditions.visibilityOfElementLocated(successbutton));
                driver.findElement(successbutton).click();
                driver.close();		
                
        }		
    }		
        driver.switchTo().window(MainWindow);				
     }
	public static void failedwindow()
	{
		
	    String MainWindow=driver.getWindowHandle();				
        Set<String> s1=driver.getWindowHandles();		
        Iterator<String> i1=s1.iterator();			
        while(i1.hasNext())			
        {		
         String ChildWindow=i1.next();		
        		
         if(!MainWindow.equalsIgnoreCase(ChildWindow))			
         {    		
                driver.switchTo().window(ChildWindow);
                WebDriverWait wait=new WebDriverWait(driver,20);
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(failurebutton)));
                driver.findElement(failurebutton).click();
                driver.close();		
                
        }		
    }		
        driver.switchTo().window(MainWindow);				
     }
	public static void closewindow()
	{
		
	    String MainWindow=driver.getWindowHandle();				
        Set<String> s1=driver.getWindowHandles();		
        Iterator<String> i1=s1.iterator();			
        while(i1.hasNext())			
        {		
         String ChildWindow=i1.next();		
        		
         if(!MainWindow.equalsIgnoreCase(ChildWindow))			
         {    		
                driver.switchTo().window(ChildWindow);	                                                                                                           
                driver.close();		
                
        }		
    }		
        driver.switchTo().window(MainWindow);				
     }
	public static WebElement playbuttonafterbuym()
	{
		return driver.findElement(playbuttonafterbuy);
	}
	public static WebElement continueafterbuym()
	{
		return driver.findElement(continueafterbuy);
	}
	public static WebElement Username()
	{
		return driver.findElement(Username);
	}
	public static WebElement UserEmail()
	{
		return driver.findElement(UserEmail);
	}
	public static WebElement Billingdate()
	{
		return driver.findElement(Billingdate);
	}
	public static WebElement Billingamount()
	{
		return driver.findElement(Billingamount);
	}
	public static WebElement Transcationunsuccefullmessage()
	{
		return driver.findElement(Transcationunsuccefullmessage);
	}
	public static WebElement backbutton()
	{
		return driver.findElement(backbutton);
	}
	public static WebElement buytextonbuybutton()
	{
		return driver.findElement(buytextonbuybutton);
	}
	public static WebElement tryagainbutton()
	{
		return driver.findElement(tryagainbutton);
	}
	public static WebElement errormessage()
	{
		return driver.findElement(errormessage);
	}
	public static WebElement usernamelabelm()
	{
		return driver.findElement(usernamelabel);
	}
	public static WebElement UserEmaillabelm()
	{
		return driver.findElement(UserEmaillabel);
	}
	public static WebElement Billingdatelabelm()
	{
		return driver.findElement(Billingdatelabel);
	}
	public static WebElement Billingamountlabelm()
	{
		return driver.findElement(Billingamountlabel);
	}
	public static WebElement addbillingadressbuttonm()
	{
		return driver.findElement(addbillingadressbutton);
	}
	public static WebElement notem()
	{
		return driver.findElement(note);
	}
	public static WebElement billingdetailsheadingm()
	{
		return driver.findElement(billingdetailsheading);
	}
	public static WebElement thumbimagem()
	{
		return driver.findElement(thumbimage);
	}
	public static WebElement studionamem()
	{
		return driver.findElement(studioname);
	}
	public static WebElement presentstextm()
	{
		return driver.findElement(presentstext);
	}
	public static WebElement shoorseriesnamem()
	{
		return driver.findElement(shoorseriesname);
	}
	public static WebElement shoorserieslabelm() 
	{
		return driver.findElement(shoorserieslabel);
	}
	public static List<WebElement> validitym()
	{
		return driver.findElements(validity);
	}
	public static WebElement validitytextm()
	{
		return driver.findElement(validitytext);
	}
	public static WebElement paymentpageheadingm()
	{
		return driver.findElement(paymentpageheading);
	}
	 public static String errormessagem()
     {
     	return driver.findElement(errormessage).getText();
     }
	 public static WebElement transcationunsuccesfullm()
	 {
		 return driver.findElement(transcationunsuccesfull);
	 }
	public static WebElement transactionsuccess()
	{
		return driver.findElement(transactionsuccess);
	}
	public static WebElement Amountpaidtext()
	{
		return driver.findElement(Amountpaidtext);
	}
	public static WebElement amountontransactionpage()
	{
		return driver.findElement(amountontransactionpage);
	}
	public static WebElement paymentdetailheading()
	{
		return driver.findElement(paymentdetailheading);
	}
	public static WebElement usernamelabelontransaction()
	{
		return driver.findElement(usernamelabelontransaction);
	}
	public static WebElement useremaillabelontransaction()
	{
		return driver.findElement(useremaillabelontransaction);
	}
	public static WebElement shoseriesnamelabelontransaction()
	{
		return driver.findElement(seriesnamelabelontransaction);
	}
	public static WebElement transactionidlabelontransaction()
	{
		return driver.findElement(transactionidlabelontransaction);
	}
	public static WebElement usernameontransaction()
	{
		return driver.findElement(usernameontransaction);
	}
	public static WebElement useremailontransaction()
	{
		return driver.findElement(useremailontransaction);
	}
	public static WebElement shoseriesnameontransaction()
	{
		return driver.findElement(seriesnameontransaction);
	}
	public static WebElement transactionidontransaction()
	{
		return driver.findElement(transactionidontransaction);
	}
	public static WebElement thankumessageforuser()
	{
		return driver.findElement(thankumessageforuser);
	}
	public static WebElement UPIpaybutton()
	{
		return driver.findElement(UPIpaybutton);
	}
	public static WebElement upiid()
	{
		return driver.findElement(upiid);
	}
	//Add billing address
	public static WebElement billingdetailtext()
	{
		return driver.findElement(billingdetailtext);
	}
	public static WebElement youlocationtextplaceholder()
	{
		return driver.findElement(youlocationtextplaceholder);
	}
	public static WebElement addressplaceholder()
	{
		return driver.findElement(addressplaceholder);
	}
	public static WebElement billingadressfield()
	{
		return driver.findElement(billingadressfield);
	}
	public static WebElement updatebutton()
	{
		return driver.findElement(updatebutton);
	}
	public static WebElement closeicon()
	{
		return driver.findElement(closeicon);
	}
	public static WebElement errormessagebilling()
	{
		return driver.findElement(errormessagebilling);
	}
	public static WebElement changelink()
	{
		return driver.findElement(changelink);
	}
	public static WebElement billingaddressafterupdate()
	{
		return driver.findElement(billingaddressafterupdate);
	}
	/*public static void Buyorplay()
	{
		try {
		Paymentpage.carddetails();
	    Thread.sleep(1000);
 	   Paymentpage.paybuttonm();
 	   Thread.sleep(1000);
 	   Paymentpage.successwindowhandle();
 	   Thread.sleep(500);
 	   Paymentpage.playbuttonafterbuym().click();
 	   Thread.sleep(1000);
 	   videoandaudioPlayer.mousehoveronplayerm();
 	   String str=videoandaudioPlayer.shoseriesnameonplayerm().getText();
 	   log.info(str);
 	   assertEquals(str,shoseriesorstudioname);
 	   videoandaudioPlayer.closeplayerm().click();
	}*/
	
	public static void billingdetailsinput(String location) throws InterruptedException
	{
		
		Paymentpage.billingadressfield().sendKeys(location);
		Thread.sleep(1000);
		Actions a=new Actions(driver);
		a.sendKeys(Keys.ARROW_DOWN).build().perform();
		a.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		
		
	}

}
