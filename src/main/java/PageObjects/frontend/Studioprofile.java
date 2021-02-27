package PageObjects.frontend;





import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.WebDriverWait;

import Resources.Base_setup;
import junit.framework.Assert;


public class Studioprofile extends Base_setup
{
public static Logger log=Logger.getLogger(Studioprofile.class.getName());
  static WebDriverWait wait=new WebDriverWait(driver,10);
   JavascriptExecutor js = (JavascriptExecutor) driver;
  
   
   
   
   
   
   private static By studionameonstudiopage=By.xpath("//div[@class='edit-title']/h4");
   private static By studiotype=By.xpath("//div[@class='video-type']");
   private static By viewmorebutton=By.xpath("//div[@class='swiper-slide ng-star-inserted swiper-slide-active']/div/div/div/button[1]");
   private static By followerscount=By.xpath("//div[@class='gudsho-counts flex justify-content-center']//div[2]");
   private static By followbutton=By.xpath("//div[@class='followers-btn']/app-follow-studios/button");
   private static By followbuttononheader=By.xpath("//div[@class='follow-btn']/app-follow-studios/button");
   private static By shocount=By.xpath("//div[@class='gudsho-counts flex justify-content-center']//div[3]");
   private static By seriescount=By.xpath("//div[@class='gudsho-counts flex justify-content-center']//div[4]");
   private static By studioinfo=By.xpath("//div[@class='count-list cursor']");
   private static By studiodescription=By.xpath("//p[@class='description']");
   private static By studiodescrbackicon=By.xpath("//span[@class='studio-back-icon']");
   private static By profileimage=By.xpath("//div[@class='profile-view']");
   private static By shoorseriesnames=By.xpath("//div[@class='hover-sho-detail ng-star-inserted']/div/h5");
   private static By shonameonmousehover=By.xpath("//div[@class='mat-ripple card-img cursor auto-image']");
   private static By addtowatchlist=By.xpath("//div[@class='details-btns flex']/div[1]");
   private static By shareshocard=By.xpath("//div[@class='details-btns flex']/div[2]");
   private static By allnames=By.xpath("//div[@class='slider-content']/swiper/div/app-gud-card/div/div/div[2]");
   private static By nocontentingeneres=By.xpath("//div[@class='text-center ng-star-inserted']/h3");
   private static By rowtities=By.xpath("//div[@class='slider-header flex justify-content-between']/h4");
   private static By generestext=By.xpath("//div[@class='slider-content']/swiper/div/ul/li");
   private static By seeallgeneresbutton=By.xpath("//div[@class='text-center ng-star-inserted']/button");
   private static By mousehoveronshoseriesnames=By.xpath("//div[@class='card-main vertical-card']/div[1]");
   private static By shoname=By.xpath("//div[@class='swiper-slide ng-star-inserted swiper-slide-active']/div/div/div/h3/span[1]");
   private static By nextsliderbutton=By.xpath("//div[@class='slider-content banner-slider-content ng-star-inserted']/swiper/div/div[1]");
   private static By shoorseriesnamesinbanner=By.xpath("//div[@class='swiper-slide ng-star-inserted swiper-slide-active']/div/div/div/h3/span");
   private static By shodescription=By.xpath("//div[@class='swiper-slide ng-star-inserted swiper-slide-active']/div/div/div/p");
   private static By playtrailerbutton=By.xpath("//div[@class='swiper-slide ng-star-inserted swiper-slide-active']/div/div/div/button[2]");
   private static By promonames=By.xpath("//div[@class='card-footer flex justify-content-between ng-star-inserted']/div/h4");
   private static By promonamesoninrowtitle=By.xpath("//div[@class='card-left box-promo']/h4");
   private static By mousehoveronpromocards=By.xpath("//div[@class='mat-ripple card-img']");
   private static By audionames=By.xpath("//h4[@class='card-title text-control']");
   private static By mousehoveronaudiotracks=By.xpath("//div[@class='card-main audio-card-content']/div[1]");
   private static By promoshareicon=By.xpath("//div[@class='see-all-image cursor']/div[1]");
   private static By followingtext=By.xpath("//div[@class='followers-btn']/app-follow-studios/button/span");
   private static By unfollowstudioicon=By.xpath("//div[@class='unfollow-option ng-star-inserted']");
   private static By unfollowbutton=By.xpath("//button[@class='mat-menu-item ng-star-inserted']/span");
   
   //Share and Follow
   private static By studiofacebookshare=By.xpath("//ul[@class='shocial-links']/li[1]");
   private static By studiotwittershare=By.xpath("//ul[@class='shocial-links']/li[2]");
   private static By studiowatsappshare=By.xpath("//ul[@class='shocial-links']/li[3]");
   private static By studiocopylinkshare=By.xpath("//ul[@class='shocial-links']/li[4]");
   private static By followstudio=By.xpath("//ul[@class='shocial-links follow-link-list']/li");
   
   
   public static WebElement studionameonstudiopagem()
   {
	   return driver.findElement(studionameonstudiopage);
   }
   public static WebElement studiotypem()
   {
	   return driver.findElement(studiotype);
   }
   public static WebElement viewmorebuttonm()
   {
	   return driver.findElement(viewmorebutton);
   }
   public static WebElement followerscountm()
   {
	   return driver.findElement(followerscount);
   }
   public static WebElement shocountm()
   {
	   return driver.findElement(shocount);
   }
   public static WebElement seriescountm()
   {
	   return driver.findElement(seriescount);
   }
   public static WebElement studioinfom()
   {
	   return driver.findElement(studioinfo);
   }
   public static WebElement studiodescriptionm()
   {
	  
	   return driver.findElement(studiodescription);
   }
   public static WebElement studiodescrbackiconm()
   {
	   return driver.findElement(studiodescrbackicon);
   }
   public static WebElement profileimagem()
   {
	   return driver.findElement(profileimage);
   }
   
    public static String shonameonstudioprofilewatchlist;
	public static void addtowatchlist(String shoorseriesname) throws InterruptedException 
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		Actions a=new Actions(driver);
		List<WebElement> shoseriesnames = driver.findElements(shoorseriesnames);
		int size1 = shoseriesnames.size();
		if (size1 > 0) {
			for (int j = 0; j < size1; j++) {         
				String text = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerHTML;",driver.findElements(shoorseriesnames).get(j));
				if (text.equalsIgnoreCase(shoorseriesname)) {
				  shonameonstudioprofilewatchlist = (String) js.executeScript("return arguments[0].innerHTML;",driver.findElements(shoorseriesnames).get(j));
					log.info("Sho or series name which is going to add to atch list is:" + shonameonstudioprofilewatchlist);
					Thread.sleep(1000);
					a.moveToElement(driver.findElements(shonameonmousehover).get(j)).build().perform();
					Thread.sleep(1500);
					//js.executeScript("arguments[0].click();", driver.findElements(addtowatchlist).get(j));
					a.moveToElement(driver.findElements(addtowatchlist).get(j)).click().build().perform();
					log.info("Sho or series name added to watch list is :" + shonameonstudioprofilewatchlist);
					break;
				}
			}
		}
	}
	public static void shareshocard(String shoorseriesname) throws InterruptedException 
	{
		
		Actions a=new Actions(driver);
		List<WebElement> shoseriesnames = driver.findElements(shoorseriesnames);
		int size1 = shoseriesnames.size();
		System.out.println(size1);
		if (size1 > 0) {
			for (int j = 0; j < size1; j++) {
				String text=(String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerHTML;",driver.findElements(shoorseriesnames).get(j));
				if (text.equalsIgnoreCase(shoorseriesname)) {
					//String shonameonstudioprofilewatchlist = driver.findElements(shoorseriesnames).get(j).getText();
					//log.info("Sho or series name which is going to Share is:" + shonameonstudioprofilewatchlist);
					Thread.sleep(1000);
					a.moveToElement(driver.findElements(shonameonmousehover).get(j)).build().perform();
					Thread.sleep(1500);
					a.moveToElement(driver.findElements(shareshocard).get(j)).click().build().perform();
					//log.info("Sho or series name added to shared  is :" + shonameonstudioprofilewatchlist);
					break;
				}
			}
		}
	}
	public static void playpromom(String promoname) throws InterruptedException 
	{     Actions a=new Actions(driver);
		Studioprofile.scrolldownm();
		Thread.sleep(1000);
		List<WebElement> allpromonames = driver.findElements(promonames);
		int size1 = allpromonames.size();
		if (size1 > 0) {
			for (int j = 0; j < size1; j++) {
				String text = driver.findElements(promonames).get(j).getText();
				log.info("All promo names displayed are :" + text);
				if (text.equalsIgnoreCase(promoname)) {
					a.moveToElement(driver.findElements(mousehoveronpromocards).get(j)).click().build().perform();
					log.info("Mouse hovered and clicked on promo name is:" + promoname);
					Thread.sleep(6000);
					break;
				}
			}
		}
		else {
			log.info("No promo row available");
		}
	
	}

	
	public static void playaudiom(String audioname) throws InterruptedException 
	{
		Actions a=new Actions(driver);
		Studioprofile.scrolldownm();
		Thread.sleep(1000);
		List<WebElement> allpromonames = driver.findElements(audionames);
		int size1 = allpromonames.size();
		if (size1 > 0) {
			for (int j = 0; j < size1; j++) {
				String text = driver.findElements(audionames).get(j).getText();
				System.out.println(text);
				if (text.equalsIgnoreCase(audioname)) {
					Thread.sleep(1000);
					a.moveToElement(driver.findElements(mousehoveronaudiotracks).get(j)).click().build().perform();
					log.info("Mouse hovered and clicked on audio name is:" + audioname);
					Thread.sleep(5000);
					break;
				}
			}
		}
		else {
			log.info("No audio row available");
		}
		
	}


	public static void onlyinallgenere() throws InterruptedException
	{
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		Studioprofile.scrolldownm();
		Thread.sleep(1000);
			List<WebElement> shoseriesnames = driver.findElements(allnames);
			int size1 = shoseriesnames.size();
			if (size1 > 0) {
				for (int j = 0; j < size1; j++) {
					String script3 = "return arguments[0].innerText";
					String text = (String) js.executeScript(script3, driver.findElements(allnames).get(j));
					log.info("Name of the shoorseries and audiotracks in All genere  " + text);
				}
			} else 
			{
				Thread.sleep(2000);
				String noshoseriestext = driver.findElement(nocontentingeneres)
						.getText();
				log.info("All Genere" + " : " + noshoseriestext);
			}
		
	}
	   public static String actualrowtitlename;
		public static void rowtitlesm(String rowtitlename) throws InterruptedException {
				Studioprofile.scrolldownm();
				Thread.sleep(1000);
				List<WebElement> txt = driver.findElements(rowtities);
				int size = txt.size();
				for (int i = 0; i < size; i++) {
					String text = driver.findElements(rowtities).get(i).getText();
					log.info("Rows on the studio page: " + text);
					if (text.equalsIgnoreCase(rowtitlename)) {
						actualrowtitlename = driver.findElements(rowtities).get(i).getText();
						log.info("Actual row title name is :" + rowtitlename);
						break;
					}
				}
			       
		}
		
		public static void rowtitleclickm(String rowtitlename) throws InterruptedException {
			Actions a=new Actions(driver);
				Studioprofile.scrolldownm();
				Thread.sleep(1000);
				List<WebElement> txt = driver.findElements(rowtities);
				int size = txt.size();
				for (int i = 0; i < size; i++) {
					String text = driver.findElements(rowtities).get(i).getText();
					log.info("Rows on the studio page: " + text);
					if (text.equalsIgnoreCase(rowtitlename)) {
						a.moveToElement(driver.findElements(rowtities).get(i)).click().build().perform();
						log.info("Actual row title name is :" + rowtitlename);
						break;
					}
				}
			       
		}

		public static void shoorseriesnamesingeners() throws InterruptedException {
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			Actions a=new Actions(driver);
			List<WebElement> genertext = driver.findElements(generestext);
			int size = genertext.size();
			for (int i = 1; i < size; i++) {
				String script = "return arguments[0].innerText";
				String txt = (String) js.executeScript(script, driver.findElements(generestext).get(i));
				log.info("Name of the Genere :" + txt);
				js.executeScript("arguments[0].click();", driver.findElements(generestext).get(i));
				Thread.sleep(2000);
				a.sendKeys(Keys.END).build().perform();
				Thread.sleep(2000);
				List<WebElement> shoseriesnames = driver.findElements(shoorseriesnames);
				int size1 = shoseriesnames.size();
				if (size1 > 0) {
					for (int j = 0; j < size1; j++) {
						String script3 = "return arguments[0].innerText";
						String text = (String) js.executeScript(script3, driver.findElements(shoorseriesnames).get(j));
						log.info("Name of the sho or series  " + text);
					}
				} else {
					Thread.sleep(2000);
					String noshoseriestext = driver.findElement(nocontentingeneres).getText();
					log.info(txt + " : " + noshoseriestext);
					driver.findElement(seeallgeneresbutton).isDisplayed();
					log.info("See all generes button is displayed");
					driver.findElement(seeallgeneresbutton).click();
					log.info("Cliked on seeall genersbutton ");

				}

			}

		}	

		public static String actualgenerename;

		public static void Shoorseriesinindividualgenere(String generename) throws InterruptedException {
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			Actions a=new Actions(driver);
			List<WebElement> genertext = driver.findElements(generestext);
			int size = genertext.size();
			for (int i = 1; i < size; i++) {
				String script = "return arguments[0].innerText";
				String txt = (String) js.executeScript(script, driver.findElements(generestext).get(i));
				Thread.sleep(1000);
				if (txt.equalsIgnoreCase(generename)) {
					String script2 = "return arguments[0].innerText";
					actualgenerename = (String) js.executeScript(script2, driver.findElements(generestext).get(i));
					js.executeScript("arguments[0].click();", driver.findElements(generestext).get(i));
					Thread.sleep(1000);
					a.sendKeys(Keys.END).build().perform();
					Thread.sleep(1000);
					List<WebElement> shoseriesnames = driver.findElements(shoorseriesnames);
					int size1 = shoseriesnames.size();
					if (size1 > 0) {
						for (int j = 0; j < size1; j++) {
							String script3 = "return arguments[0].innerText";
							String text = (String) js.executeScript(script3,
									driver.findElements(shoorseriesnames).get(j));
							log.info(generename + " : " + text);
						}
					} else {
						String noshoseriestext = driver.findElement(nocontentingeneres).getText();
						log.info(txt + " : " + noshoseriestext);
						driver.findElement(seeallgeneresbutton).isDisplayed();
						log.info("See all generes button is displayed");
						driver.findElement(seeallgeneresbutton).click();
						log.info("Cliked on seeall genersbutton ");
					}
					break;

				}

			}

		}

		public static String actualshoorseriesname;

		public static void shoorseriesingenere(String shoorseries) throws InterruptedException {
			 JavascriptExecutor js = (JavascriptExecutor) driver;
					Studioprofile.scrolldownm();
					List<WebElement> shoseriesnames = driver.findElements(shoorseriesnames);
					int size1 = shoseriesnames.size();
					if (size1 > 0) {
						for (int j = 0; j < size1; j++) {
							String text=(String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerHTML;",driver.findElements(shoorseriesnames).get(j));
							if (text.equalsIgnoreCase(shoorseries)) {
								String script3 = "return arguments[0].innerHTML";
								actualshoorseriesname = (String) js.executeScript(script3,
										driver.findElements(shoorseriesnames).get(j));
								break;
							}

						}
					} else {
						String noshoseriestext = driver.findElement(nocontentingeneres).getText();
						log.info(noshoseriestext);
						driver.findElement(seeallgeneresbutton).isDisplayed();
						log.info("See all generes button is displayed");
						driver.findElement(seeallgeneresbutton).click();
						log.info("Cliked on seeall genersbutton ");
					}
					

				}

			//}

		//}
        public static String actualshoorseriesnameingenere;
        
        public static String actualshonamenshodetailpage;
       // public static String shonameonstudioprofilepage;
		public static void verifytheshoorseriesisclickble(String shoorseries, String generename)
				throws InterruptedException {
			Actions a=new Actions(driver);
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			List<WebElement> shoseriesnames = driver.findElements(shoorseriesnames);
			int size1 = shoseriesnames.size();
			if (size1 > 0) {
				for (int j = 0; j < size1; j++) {
					String text=(String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerHTML;",driver.findElements(shoorseriesnames).get(j));
					if (text.equalsIgnoreCase(shoorseries)) {
						String script3 = "return arguments[0].innerHTML";
						actualshoorseriesnameingenere = (String) js.executeScript(script3,
								driver.findElements(shoorseriesnames).get(j));
						log.info(actualshoorseriesnameingenere);
						//shonameonstudioprofilepage = driver.findElements(shoorseriesnames).get(j).getText();
						//System.out.println(shonameonstudioprofilepage);
						Thread.sleep(1000);
						a.moveToElement(driver.findElements(mousehoveronshoseriesnames).get(j)).click()
								.build().perform();
						
						Thread.sleep(1000);
						String str = Shoorseriesdetailpage.shonameinshodetailspage().getText();
						actualshonamenshodetailpage = str.substring(0, str.lastIndexOf(""));
						log.info(actualshonamenshodetailpage);
						Thread.sleep(2000);
						driver.navigate().back();
						break;

					}

				}
			} else {
				String noshoseriestext = driver.findElement(nocontentingeneres).getText();
				log.info("if there is no sho or series in geners the text displayed is: " + noshoseriestext);
				driver.findElement(seeallgeneresbutton).isDisplayed();
				log.info("See all generes button is displayed");
				driver.findElement(seeallgeneresbutton).click();
				log.info("Cliked on seeall genersbutton ");
			}

		}
		public static String actual;
		public static void viewmorefrombanner(String shoorseriesname) throws InterruptedException
		   {
			Actions a=new Actions(driver);
			      a.sendKeys(Keys.HOME);
				  while(!(driver.findElement(shoname).getText().equalsIgnoreCase(shoorseriesname)))
				  {
					  a.moveToElement(driver.findElement(nextsliderbutton)).click().build().perform();
					  
				  }
				  Thread.sleep(2000);
				  actual= driver.findElement(shoorseriesnamesinbanner).getText();
				   log.info("Sho or series name going to see the detail page is :" + actual);
				  a.moveToElement( driver.findElement(viewmorebutton)).click().build().perform();
				  log.info("Cliked on view more button:" + actual);
				  
		   }
		public static void playtrailerfrombanner(String shoorseriesname) throws InterruptedException
		   {
			Actions a=new Actions(driver);
			      a.sendKeys(Keys.HOME);
				  while(!(driver.findElement(shoname).getText().equalsIgnoreCase(shoorseriesname)))
				  {
					  a.moveToElement(driver.findElement(nextsliderbutton)).click().build().perform();
					  
				  }
				  actual= driver.findElement(shoorseriesnamesinbanner).getText();
				  String shodescriptiontext=driver.findElement(shodescription).getText(); 
				  log.info("Sho or series description showing on banner is :" + shodescriptiontext);
				  Thread.sleep(1000);
				  driver.findElement(playtrailerbutton).click(); 
				  log.info("Cliked on Play trailer button");
				  
		   }
		   
		public static void scrolldownm()
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			try {
				Object lastHeight = js.executeScript("return document.body.scrollHeight");
				while (true) {
					js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
					Thread.sleep(2000);
					Object newHeight = js.executeScript("return document.body.scrollHeight");
					if (newHeight.equals(lastHeight)) {
						break;
					}
					lastHeight = newHeight;
				       }
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		public static WebElement promonames()   
		{
			return driver.findElement(promonames);
		}
		public static void mousehoveronpromos()
		{
			Actions a=new Actions(driver);
			a.moveToElement(driver.findElement(mousehoveronpromocards)).click().build().perform();;
		}
		public static void mousehoveronpromocards()
		{
			Actions a=new Actions(driver);
			a.moveToElement(driver.findElement(mousehoveronpromocards)).build().perform();;
		}
		public static void promoshareicon()
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", driver.findElement(promoshareicon));
			//a.moveToElement(driver.findElement(promoshareicon)).click().build().perform();
			
		}
		public static WebElement audionamesm()
		{
			return driver.findElement(audionames);
		}
		public static void mousehoveronaudiotracksm()
		{
			Actions a=new Actions(driver);
			a.moveToElement(driver.findElement(mousehoveronaudiotracks)).click().build().perform();
		}
		public static WebElement studiofacebooksharem()
		{
			return driver.findElement(studiofacebookshare);
		}
		public static WebElement studiotwittersharem()
		{
			return driver.findElement(studiotwittershare);
		}
		public static WebElement studiowatsappsharem()
		{
			return driver.findElement(studiowatsappshare);
		}
		public static void studiocopylinksharem() throws InterruptedException, HeadlessException, UnsupportedFlavorException, IOException
		{
			driver.findElement(studiocopylinkshare).click();
			log.info("Clicked on copy link button");
			String Actual=Toastanderrormessages.toastmessagem().getText();
	        log.info("Toastmessage shown :" + Actual);
	        Assert.assertEquals(Actual,"Link Copied!");
	        String myText = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
			log.info(myText);
			((JavascriptExecutor)driver).executeScript("window.open()");
	        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
	        driver.switchTo().window(tabs.get(1));
	        driver.get("https://"+myText);
	        String currenttabtitle=driver.getTitle();
	        log.info(currenttabtitle);
	        String childurl=driver.getCurrentUrl();
	        log.info(childurl);
	        Assert.assertEquals("https://"+myText,childurl);
	        driver.close();
	        driver.switchTo().window(tabs.get(0));
	        String parenttabtitle=driver.getTitle();
	        log.info(parenttabtitle);
	        Assert.assertEquals(currenttabtitle,parenttabtitle);
	        String parenturl=driver.getCurrentUrl();
	        log.info(parenturl);
	        Assert.assertEquals(parenturl,childurl);
		}
		public static WebElement followingtextm()
		{
			return driver.findElement(followingtext);
		}
		public static WebElement unfollowstudiom()
		{
			return driver.findElement(unfollowstudioicon);
		}
		public static WebElement unfollowbuttonm()
		{
			return driver.findElement(unfollowbutton);
		}
		public static List<WebElement> followstudio()
		{
			return driver.findElements(followstudio);
		}
		public static WebElement promonamesoninrowtitle()
		{
			return driver.findElement(promonamesoninrowtitle);
		}
		public static WebElement followbutton()
		{
			return driver.findElement(followbutton);
		}
		public static WebElement followbuttononheader()
		{
			return driver.findElement(followbuttononheader);
		}

}
