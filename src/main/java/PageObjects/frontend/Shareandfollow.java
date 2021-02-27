package PageObjects.frontend;





import static org.junit.Assert.assertEquals;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Resources.Base_setup;



public class Shareandfollow extends Base_setup
{
	
	public static Logger log=Logger.getLogger(Shareandfollow.class.getName());
	private static By facebookshare=By.xpath("//div[@class='clearfix']/app-gud-share/ul/li[1]");
	private static By twittershare=By.xpath("//div[@class='clearfix']/app-gud-share/ul/li[2]");
	private static By whatsappshare=By.xpath("//div[@class='clearfix']/app-gud-share/ul/li[3]");
	private static By copylinkshare=By.xpath("//div[@class='clearfix']/app-gud-share/ul/li[4]");
	private static By facebookusername=By.id("email");
	private static By facebookpassword=By.id("pass");
	private static By facebooklogin=By.name("login");
	private static By recomendedstudio=By.xpath("//span[@class='main']");
	private static By postfacebook=By.name("__CONFIRM__");
	private static By twitterusername=By.name("session[username_or_email]");
	private static By twitterpassword=By.name("session[password]");
	private static By twittersigin=By.xpath("//span[text()='Log in']");
	private static By twittertewwtbutton=By.xpath("//span[contains(text(),'Tweet')]");
	private static By whatsappbutton=By.id("action-button");
	private static By linktext=By.className("_2y_4");
	private static By promofacebookshare=By.xpath("//div[@class='clearfix']/app-gud-share/ul/li[1]");
	private static By promotwittershare=By.xpath("//div[@class='clearfix']/app-gud-share/ul/li[2]");
	private static By promowatsappshare=By.xpath("//div[@class='clearfix']/app-gud-share/ul/li[3]");	
	private static By promocopylinkshare=By.xpath("//div[@class='clearfix']/app-gud-share/ul/li[4]");
	private static By closesharepopup=By.xpath("//div[@class='mat-dialog-header']/div");
	private static By audioshare=By.xpath("//button[@data-plyr='share']");
	private static By sharepopup=By.xpath("//div[@class='cdk-overlay-pane delete-popup feeds-share']");
	
	public static void recomendedstudiom()
	{
		driver.findElement(recomendedstudio).click();
	}
	public static WebElement sharepopup()
	{
		return driver.findElement(sharepopup);
	}
	public static void facebooksharem()
	{
		
		driver.findElement(facebookshare).click();
		log.info("Clicked on facebook share");
	}
	public static void twittersharem()
	{
		driver.findElement(twittershare).click();
		log.info("Clicked on twitter share");
	}
	public static void whatsappsharem()
	{
		driver.findElement(whatsappshare).click();
		log.info("Clicked on whatsapp share");
	}
	public static void facebookwindowhandle() throws InterruptedException
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
                String pagetitle=driver.getTitle();
                log.info(pagetitle);
                driver.findElement(facebookusername).clear();
                driver.findElement(facebookusername).sendKeys("sameergudsho@gmail.com");
                driver.findElement(facebookpassword).clear();
                driver.findElement(facebookpassword).sendKeys("sameer1234");
                driver.findElement(facebooklogin).click();
                Thread.sleep(2000);
                String afterloginpagetitle=driver.getTitle();
                log.info(afterloginpagetitle);
                driver.findElement(postfacebook).click();
               
                driver.close();
               // driver.findElement(successbutton).click();
               // log.info("Clicked on payment success button and child window is going to close");
               // driver.close();		
               // log.info("child window closed");
        }		
    }		
        driver.switchTo().window(MainWindow);
        Thread.sleep(1000);
     }
	public static void twitterwindowhandle() throws InterruptedException
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
               String pagetitle=driver.getTitle();
                log.info(pagetitle);
                driver.findElement(twitterusername).click();
                driver.findElement(twitterusername).clear();
                driver.findElement(twitterusername).sendKeys("sameer83144398");
                driver.findElement(twitterpassword).clear();
                driver.findElement(twitterpassword).sendKeys("sameer1234");
                driver.findElement(twittersigin).click();
                Thread.sleep(2000);
                String afterloginpagetitle=driver.getTitle();
                log.info(afterloginpagetitle);
                driver.findElement(twittertewwtbutton).click();
                
                driver.close();
               // driver.findElement(successbutton).click();
               // log.info("Clicked on payment success button and child window is going to close");
               // driver.close();		
               // log.info("child window closed");
        }		
    }		
        driver.switchTo().window(MainWindow);				
     }
	public static void whatsappwindowhandlforpromo() throws InterruptedException
	{
		String text = null;
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
	                driver.findElement(whatsappbutton).isDisplayed();
	                 text= driver.findElement(linktext).getText();
	                log.info(text);
	                Thread.sleep(1000);
	                driver.close();
	         }
	         

	        }		
	            driver.switchTo().window(MainWindow);
	                
	        }
	
	
	
	public static void whatsappswindowhandle() throws InterruptedException
	{
		String text = null;
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
                driver.findElement(whatsappbutton).isDisplayed();
                 text= driver.findElement(linktext).getText();
                log.info(text);
                Thread.sleep(1000);
                driver.close();
                
        }
        

    }		
        driver.switchTo().window(MainWindow);
        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://"+text);
        WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(Shoorseriesdetailpage.sharebuttonm()));
        String currenttabtitle=driver.getTitle();
        log.info(currenttabtitle);
        String childurl=driver.getCurrentUrl();
        log.info(childurl);
        assertEquals("https://"+text,childurl);
        driver.close();
        driver.switchTo().window(tabs.get(0));
        String parenttabtitle=driver.getTitle();
        log.info(parenttabtitle);
        assertEquals(currenttabtitle,parenttabtitle);
        String parenturl=driver.getCurrentUrl();
        log.info(parenturl);
        assertEquals(parenturl,childurl);
     }
	public static void Studiowhatsappswindowhandle() throws InterruptedException
	{
		String text = null;
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
                driver.findElement(whatsappbutton).isDisplayed();
                 text= driver.findElement(linktext).getText();
                log.info(text);
                Thread.sleep(1000);
                driver.close();
                
        }
        

    }		
        driver.switchTo().window(MainWindow);
        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://"+text);
        WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(Shoorseriesdetailpage.sharebuttonm()));
        String currenttabtitle=driver.getTitle();
        log.info(currenttabtitle);
        String childurl=driver.getCurrentUrl();
        log.info(childurl);
        assertEquals("https://"+text,childurl);
        driver.close();
        driver.switchTo().window(tabs.get(0));
        String parenttabtitle=driver.getTitle();
        log.info(parenttabtitle);
        assertEquals(currenttabtitle,parenttabtitle);
        String parenturl=driver.getCurrentUrl();
        log.info(parenturl);
        assertEquals(parenturl,childurl);
     }
	public static void copylinksharem() throws InterruptedException, HeadlessException, UnsupportedFlavorException, IOException
	{
		driver.findElement(copylinkshare).click();
		log.info("Clicked on copy link button");
		String Actual=Toastanderrormessages.toastmessagem().getText();
        log.info("Toastmessage shown :" + Actual);
        assertEquals(Actual,"Link Copied!");
        String myText = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
		log.info(myText);
		((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://"+myText);
        WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(Shoorseriesdetailpage.sharebuttonm()));
        String currenttabtitle=driver.getTitle();
        log.info(currenttabtitle);
        String childurl=driver.getCurrentUrl();
        log.info(childurl);
        assertEquals("https://"+myText,childurl);
        driver.close();
        driver.switchTo().window(tabs.get(0));
        String parenttabtitle=driver.getTitle();
        log.info(parenttabtitle);
        assertEquals(currenttabtitle,parenttabtitle);
        String parenturl=driver.getCurrentUrl();
        log.info(parenturl);
        assertEquals(parenturl,childurl);
		
	}
	public static void promofacebooksharem()
	{
		driver.findElement(promofacebookshare).click();
		log.info("Shared Promo via facebook share");
	}
	public static void promotwittersharem()
	{
		driver.findElement(promotwittershare).click();
		log.info("Shared Promo via twitter share");
	}
	public static void promowhatsappsharem()
	{
		driver.findElement(promowatsappshare).click();
		log.info("Shared Promo via whatsapp share");
	}
	public static void promocopylinksharem() throws InterruptedException, HeadlessException, UnsupportedFlavorException, IOException
	{
		driver.findElement(promocopylinkshare).click();
		log.info("Clicked on copy link button");
		
	}
	public static void closesharepopupm()
	{
		driver.findElement(closesharepopup).click();
	}
	public static void audiosharem()
	{
		
		
		driver.findElement(audioshare).click();;
	}
	
	
	
			
					
}



