package PageObjects.frontend;





import java.util.List;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Resources.Base_setup;
import junit.framework.Assert;


public class videoandaudioPlayer extends Base_setup
{
   public static Logger log=Logger.getLogger(videoandaudioPlayer.class.getName());
  
   private static By clapsymbolinplayer=By.xpath("//div[@class='player-clap singup-pops-player']");
   private static By shoorseriesnameinplayer=By.xpath("//div[@class='video-titles ng-star-inserted']/div[2]/h2");
   private static By mousehoveronplayer=By.xpath("//div[@class='plyr__poster']");
   private static By closebuttoninplayer=By.xpath("//div[@id='inner-video']/button");
   private static By promonameonplayer=By.xpath("//span[@class='season-details ng-star-inserted']");
   private static By fastforward=By.xpath("//div[@class='center_control']/button[4]");
   private static By getDuration=By.xpath("//div[@class='center_left']/div[1]");
   private static By currentduration=By.xpath("//div[@aria-label='Current time']");
   
   //Mini Title
   private static By shoorseriesnameinminititle=By.xpath("//div[@class='pause-title-detail']/h1");
   private static By labelsonminititle=By.xpath("//div[@class='sho-hints ng-star-inserted']/ul/li/span");
   private static By studionameonminititle=By.xpath("//div[@class='studio-name']");
   private static By descrtioninminititle=By.xpath("//span[@class='desc']");
   private static By buyorplaybuttononminititle=By.xpath("//ul[@class='shocial-ticket-actions']/app-gud-play-button/ul/li");
   private static By watchlistbuttononminititle=By.xpath("//li[@class='watch-lists banner-watch-lists']");
   private static By nextpromobutton=By.xpath("//button[@class='button is-icon white large next-promo mat-button mat-button-base ng-star-inserted']");
   private static By nextpromocancelbutton=By.xpath("//button[@class='button is-default secondary banner e-large next-promo cancel mat-button mat-button-base ng-star-inserted']");		   
   //Promo (Next promo,Next Episode,and promos on rightside)
   static By promonextbutton=By.xpath("//div[@class='gudsho-next-promo']");
   static By promonamesontightsidepanel=By.xpath("//div[@class='promo-list-right']/h4");
   static By closeicon=By.xpath("//button[@class='back_btn mat-button mat-button-base']");
   
   
   
   
   
   
   
   
   //AudioPlayer
   private static By heartsymbol = By.xpath("//*[@data-plyr='heart']");
   private static By closeaudioplayer=By.xpath("//div[@class='center_right']/button[3]");
   private static By audionameonplayer=By.xpath("//div[@class='music-content']/div[1]");
   private static By gudshoicon=By.xpath("//div[@class='player-logo']");
   private static By nexticononplayer=By.xpath("//div[@class='center_control']/button[3]");
   private static By previousicononplayer=By.xpath("//div[@class='center_control']/button[1]");
   private static By compsernameonplayer=By.xpath("//div[@class='gudsho-audio-statistics']/div");
   private static By unfavouratetext=By.xpath("//div[@class='center_left']/button/span[1]");
   private static By addfavoraitetext=By.xpath("//div[@class='center_left']/button/span[2]");
   static By playorpausebutton=By.xpath("//div[@class='center_control']/button[2]");
   static By playtooltip=By.xpath("//div[@class='center_control']/button[2]/span[2]");
   static By pausetooltip=By.xpath("//div[@class='center_control']/button[2]/span[1]");
   static By audiocurrentduration=By.xpath("//div[@class='audio_time_duration']/div[1]");
   //static By totoalduration=By.xpath("//div[@class='audio_time_duration']/div[2]");
   static By shuffledisableandenable=By.xpath("//div[@class='center_right']/button[2]");
   static By shuffledisableenabletooltip=By.xpath("//div[@class='center_right']/button[2]/span");
   static By repeatsong=By.xpath("//div[@class='center_right']/button[1]");
   static By volumemuteandunmute=By.xpath("//div[@class='plyr__controls__item plyr__volume']");
   static By volumecontrol=By.xpath("//input[@data-plyr='volume']");
   static By showorhide=By.xpath("//div[@class='gudsho_audio_hide']");
   static  By nextsong=By.xpath("//div[@class='center_control']/button[3]");
   static By nextsongtooltip=By.xpath("//div[@class='center_control']/button[3]");
   static By previoussong=By.xpath("//div[@class='center_control']/button[1]");
   static By previoustooltip=By.xpath("//div[@class='center_control']/button[1]/span");
   static By playerbackwordbutton=By.xpath("//div[@class='center_control']/button[2]");
   static By playerbackwardbuttontooltip=By.xpath("//div[@class='center_control']/button[2]/span");
   static By playerforwardbutton=By.xpath("//div[@class='center_control']/button[4]");
   static By playerforwardbuttontooltip=By.xpath("//div[@class='center_control']/button[4]/span");
   
   //videoplayer settings
    static By playerpauseandplaybutton=By.xpath("//div[@class='center_control']/button[3]");
	static By playerandpausetooltip=By.xpath("//div[@class='center_control']/button[3]/span");
	static By volumebutton=By.xpath("//div[@class='plyr__controls__item plyr__volume']/button");
	static By volumebuttonattribute=By.xpath("//div[@class='plyr__controls__item plyr__volume']/input");
	static By fullscreensbutton=By.xpath("//div[@class='center_right']/button");
	static By fullscreenbuttontooltip=By.xpath("//div[@class='center_right']/button/span[2]");
	static By exitfullscreentooltip=By.xpath("//div[@class='center_right']/button/span[1]");
	static By nextepisodebutton=By.xpath("//div[@class='gudsho-next-episodes']");
	static By episodepopupbutton=By.xpath("//div[@class='gudsho-seasons plyr__controls__item']");
	static By seriesnameonepisodepopup=By.xpath("//div[@class='season-popup-head']/h5");
	static By seasondropdown=By.xpath("//div[@class='season-popup-head']/mat-form-field");
	static By seasonname=By.xpath("//mat-option[@role='option']");
	static By episodepopupclose=By.xpath("//span[@class='mat-ripple close-season cursor']");
	static By episodesnames=By.xpath("//div[@class='episode-list-right']/h4");
	static By episodedesc=By.xpath("//div[@class='episode-list-right']/p");
	static By headingsofpromosandextras=By.xpath("//div[@class='video-promo-body']/div/span");
	static By hidepromos=By.xpath("//span[@class='cursor']");
	static By showpromosonplayer=By.xpath("//span[@class='show-promo-details cursor ng-star-inserted open-promo-details']");
	static By promonamesonrightsidepanel=By.xpath("//div[@class='promo-list-right']/h4");
	static By viewcountonpromorightside=By.xpath("//div[@class='view-count flex']");
	static By gudcountonpromorightside=By.xpath("//div[@class='clap-count flex align-items-center']/span");
	static By gudcountonplayer=By.xpath("//span[@class='guds-count ng-star-inserted']");
	static By addfeelresonplayer=By.xpath("//div[@class='player-feelers ng-star-inserted']/h3");
	static By feelerstext=By.xpath("//ul[@class='feelers-wrap']/li/span[2]");
   
 
   public static WebElement showorhide()
   {
	   return driver.findElement(showorhide);
   }
   public static WebElement shoseriesnameonplayerm()
   {
	   return driver.findElement(shoorseriesnameinplayer);
   }
   public static WebElement promonameonplayerm()
   {
	   return driver.findElement(promonameonplayer);
   }
   
   public static WebElement clapsymbolinplayerm()
   {
	   return driver.findElement(clapsymbolinplayer);
   }
   public static void  mousehoveronplayerm() throws InterruptedException
   {
	   Actions a=new Actions(driver);
	   a.moveToElement(driver.findElement(mousehoveronplayer)).build().perform();
	   Thread.sleep(1000);
	   log.info("Mouse hover on player");
	   
   }
   public static WebElement closeplayerm()
   {
	   return driver.findElement(closebuttoninplayer);
   }
   public static WebElement heartsymbolm()
   {
	   return driver.findElement(heartsymbol);
   }
   public static WebElement closeaudioplayerm()
   {
	   return driver.findElement(closeaudioplayer);
   }
   public static WebElement audionameonplayerm()
   {
	   return driver.findElement(audionameonplayer);
   }
   public static WebElement gudshoiconinaudioplayerm()
   {
	   return driver.findElement(gudshoicon);
   }
   public static WebElement nexticononplayerm()
   {
	   return driver.findElement(nexticononplayer);
   }
   public static WebElement previousicononplayerm()
   {
	   return driver.findElement(previousicononplayer);
   }
   public static WebElement compsernameonplayerm()
   {
	   return driver.findElement(compsernameonplayer);
   }
   public static WebElement unfavouratetextm()
   {
	   return driver.findElement(unfavouratetext);
   }
   public static WebElement addfavoraitetextm()
   {
	   return driver.findElement(addfavoraitetext);
   }
   public static WebElement shoorseriesnameinminititle()
   {
	   return driver.findElement(shoorseriesnameinminititle);
   }
   public static List<WebElement> labelsonminititle()
   {
	   return driver.findElements(labelsonminititle);
   }
   public static WebElement studionameonminititle()
   {
	   return driver.findElement(studionameonminititle);
   }
   public static WebElement descrtioninminititle()
   {
	   return driver.findElement(descrtioninminititle);
   }
   public static WebElement buyorplaybuttononminititle()
   {
	   return driver.findElement(buyorplaybuttononminititle);
   }
   public static WebElement watchlistbuttononminititle()
   {
	   return driver.findElement(watchlistbuttononminititle);
   }
   public static void promoswitching() throws InterruptedException
   {
		String totalSeconds = driver.findElement(getDuration).getText();
		log.info(totalSeconds);
		String currentdura = null;
		while(!totalSeconds.equals(currentdura))
		{
			try {
		    driver.findElement(fastforward).click();
			currentdura=driver.findElement(currentduration).getText();
			log.info(currentdura);
			}
			catch(Exception e)
			{
				break;
			}
			
		}
   }
   public static WebElement nextpromobutton()
   {
	   return driver.findElement(nextpromobutton);
   }
   public static List<WebElement> promonamesontightsidepanel()
   {
	   return driver.findElements(promonamesontightsidepanel);
   }
   public static WebElement promonextbutton()
   {
	   return driver.findElement(promonextbutton);
   }
   public static WebElement closeicon()
   {
	   return driver.findElement(closeicon);
   }
   public static WebElement nextepisodebutton()
   {
	   return driver.findElement(nextepisodebutton);
   }
   public static WebElement episodepopupbutton()
   {
	   return driver.findElement(episodepopupbutton);
   }
   public static WebElement seriesnameonepisodepopup()
   {
	   return driver.findElement(seriesnameonepisodepopup);
   }
   public static WebElement seasondropdown()
   {
	   return driver.findElement(seasondropdown);
   }
   public static List<WebElement> seasonname()
   {
	   return driver.findElements(seasonname);
   }
   public static WebElement episodepopupclose()
   {
	   return driver.findElement(episodepopupclose);
   }
   public static List<WebElement> episodesnames()
   {
	   return driver.findElements(episodesnames);
   }
   public static List<WebElement> episodedesc()
   {
	   return driver.findElements(episodedesc);
   }
   public static WebElement headingsofpromosandextras()
   {
	   return driver.findElement(headingsofpromosandextras);
   }
   public static WebElement hidepromos()
   {
	   return driver.findElement(hidepromos);
   }
   public static WebElement showpromosonplayer()
   {
	   return driver.findElement(showpromosonplayer);
   }
   public static List<WebElement> promonamesonrightsidepanel()
   {
	   return driver.findElements(promonamesonrightsidepanel);
   }
   public static List<WebElement> viewcountonpromorightside()
   {
	   return driver.findElements(viewcountonpromorightside);
   }
   public static List<WebElement> gudcountonpromorightside()
   {
	   return driver.findElements(gudcountonpromorightside);
   }
   public static int gudcountonplayer() throws InterruptedException
   {
	   String str=driver.findElement(gudcountonplayer).getText();
	   String str1=str.substring(0,str.lastIndexOf(" "));
	   Thread.sleep(1000);
	   int gudcountonplayer=Integer.parseInt(str1);
	   return gudcountonplayer;
	   
   }
   public static WebElement nextpromocancelbutton()
   {
	   return driver.findElement(nextpromocancelbutton);
   }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   public static WebElement playorpausebutton()
   {
	   return driver.findElement(playorpausebutton);
   }
   public static WebElement playtooltip()
   {
	   return driver.findElement(playtooltip);
   }
   public static WebElement pausetooltip()
   {
	   return driver.findElement(pausetooltip);
   }
   public static String totalduratioofaudio;
   public static String Currentdurationwheretheaudiostopped;
   public static String playorpausetooltipwhenaudiopaused;
   public static String tooltipwhenaudioplayingtopauseaudio;
   public static String repeatspngtooltip1;
   public static String afterfirstclickttooltip;
   public static String aftersecondtimetooltip;
   public static String afterlastclicktooltip;
   public static String enableshuffletooltip;
   public static String disableshuffletooltip;
   public static String lasttimedisabletooltip;
   public static void audioplayerallsettingsm(String duration) throws InterruptedException
   {
	   Thread.sleep(2000);
	   Actions a=new Actions(driver);
	   a.moveToElement(driver.findElement(playorpausebutton)).build().perform();
	   Thread.sleep(2000);
	   tooltipwhenaudioplayingtopauseaudio=driver.findElement(pausetooltip).getText();
	   log.info(tooltipwhenaudioplayingtopauseaudio);
	   log.info("Audio is palying");
	    totalduratioofaudio=driver.findElement(getDuration).getText();
	    log.info(totalduratioofaudio);
	    while(!driver.findElement(currentduration).getText().equalsIgnoreCase(duration))
	    {
	    	Thread.sleep(300);
	    }
	    driver.findElement(playorpausebutton).click();
	    Thread.sleep(2000);
	    playorpausetooltipwhenaudiopaused=driver.findElement(playtooltip).getText();
	    log.info(playorpausetooltipwhenaudiopaused);
	    Currentdurationwheretheaudiostopped=driver.findElement(audiocurrentduration).getText();
	    log.info(Currentdurationwheretheaudiostopped);
	    log.info("audio passed");
	    a.moveToElement(driver.findElement(repeatsong)).build().perform();
	    repeatspngtooltip1=driver.findElement(By.xpath("//div[@class='center_right']/button[1]/span[3]")).getText();
	    log.info(repeatspngtooltip1);
	    driver.findElement(repeatsong).click();
	    Thread.sleep(1000);
	    afterfirstclickttooltip=driver.findElement(By.xpath("//div[@class='center_right']/button[1]/span[2]")).getText();
	    log.info(afterfirstclickttooltip);
	    driver.findElement(repeatsong).click();
	    Thread.sleep(1000);
	    aftersecondtimetooltip=driver.findElement(By.xpath("//div[@class='center_right']/button[1]/span[1]")).getText();
	    log.info(aftersecondtimetooltip);
	    driver.findElement(repeatsong).click();
	    Thread.sleep(1000);
	    afterlastclicktooltip=driver.findElement(By.xpath("//div[@class='center_right']/button[1]/span[3]")).getText();
	    log.info(afterlastclicktooltip);
	    a.moveToElement(driver.findElement(shuffledisableandenable)).build().perform();
	    Thread.sleep(1000);
	    enableshuffletooltip=driver.findElement(By.xpath("//div[@class='center_right']/button[2]/span[2]")).getText();
	    log.info(enableshuffletooltip);
	    driver.findElement(shuffledisableandenable).click();
	    Thread.sleep(1000);
	    disableshuffletooltip=driver.findElement(By.xpath("//div[@class='center_right']/button[2]/span[1]")).getText();
	    log.info(disableshuffletooltip);
	    driver.findElement(shuffledisableandenable).click();
	    Thread.sleep(1000);
	    lasttimedisabletooltip=driver.findElement(By.xpath("//div[@class='center_right']/button[2]/span[2]")).getText();
	    log.info(lasttimedisabletooltip);
	    driver.findElement(closeaudioplayer).click();
	
   }
   public static String nextsongtooltip1;
   public static String audioonnextclick;
   public static void nextsongbuttonm() throws InterruptedException
   {
	   Actions a=new Actions(driver);
	   a.moveToElement(driver.findElement(nextsongtooltip)).build().perform();
	   Thread.sleep(2000);
	   nextsongtooltip1=driver.findElement(nextsongtooltip).getText();
	   log.info(nextsongtooltip1);
	  // Assert.assertEquals(nextsongtooltip1,"Next Song");
	   driver.findElement(nextsong).click();
	   audioonnextclick=driver.findElement(audionameonplayer).getText();
	   log.info(audioonnextclick);
	   
   }
   public static String previoussongtooltip1;
   public static String audioonpreviousclick;
   public static void previoussongbuttonm() throws InterruptedException
   {
	   Actions a=new Actions(driver);
	   a.moveToElement(driver.findElement(previoussong)).build().perform();
	   Thread.sleep(2000);
	   previoussongtooltip1=driver.findElement(previoustooltip).getText();
	   log.info(previoussongtooltip1);
	  // Assert.assertEquals("Previous Song",previoussongtooltip1);
	   driver.findElement(previoussong).click();
	   audioonpreviousclick=driver.findElement(audionameonplayer).getText();
	   log.info(audioonpreviousclick);
   }
   public static String volumeattributevalueinmute;
   public static String volumeattributevalueinfullvolume;
   public static String volumeafterclickingonvolumecontrol;
   public static void muteandunmuteaudiom() throws InterruptedException
   {
	   Actions a=new Actions(driver);
	    driver.findElement(volumemuteandunmute).click();
	    volumeattributevalueinmute=driver.findElement(volumecontrol).getAttribute("aria-valuetext");
	    Assert.assertEquals("0.0%",volumeattributevalueinmute);
		log.info(volumeattributevalueinmute);
		log.info("Audio muted");
		Thread.sleep(4000);
		driver.findElement(volumemuteandunmute).click();
		volumeattributevalueinfullvolume=driver.findElement(volumecontrol).getAttribute("aria-valuetext");
		log.info(volumeattributevalueinfullvolume);
		Assert.assertEquals("100.0%",volumeattributevalueinfullvolume);
		log.info("Audio unmuted");
		a.moveToElement(driver.findElement(volumecontrol)).build().perform();
		a.moveToElement(driver.findElement(volumecontrol)).click().build().perform();
		Thread.sleep(1000);
		volumeafterclickingonvolumecontrol=driver.findElement(volumecontrol).getAttribute("aria-valuetext");
		Assert.assertEquals("35.0%",volumeafterclickingonvolumecontrol);
		log.info(volumeafterclickingonvolumecontrol);
   }
   
   
   
   //video player 
   
   public static String currentdusration;
	public static String  tooltippause;
	public static void playeerpause(String k) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(getDuration)));
		String totoaldurationofvideo=driver.findElement(getDuration).getText();
	    log.info("Total duration of the video: " + totoaldurationofvideo);
	    tooltippause=driver.findElement(playerpauseandplaybutton).getText();
		log.info(tooltippause);
		Thread.sleep(1000);
		while(!driver.findElement(currentduration).getText().equals(k))
		{
			
			
		}
		currentdusration=driver.findElement(currentduration).getText();
		driver.findElement(playerpauseandplaybutton).click();
		log.info("Video paused at:" + k);
	}
	public static String tooltipplay;
	public static void playbutton() throws InterruptedException
	{
		tooltipplay=driver.findElement(playerpauseandplaybutton).getText();
		log.info(tooltipplay);
		driver.findElement(playerpauseandplaybutton).click();
		Thread.sleep(3000);
		driver.findElement(playerpauseandplaybutton).click();
		String str=driver.findElement(currentduration).getText();
		log.info(str);
	}
	
	public static String forwardtooltip;
	public static String currentdusrationafterforward;
	public static void forwardm(String forward) throws InterruptedException
	{
		while(!driver.findElement(currentduration).getText().equals(forward))
		{
			
		}
		driver.findElement(playerpauseandplaybutton).click();
		driver.findElement(playerforwardbutton).click();
		currentdusrationafterforward=driver.findElement(currentduration).getText();
		log.info(currentdusrationafterforward);
		Thread.sleep(2000);

		forwardtooltip=driver.findElement(playerforwardbuttontooltip).getText();
		log.info(forwardtooltip);
		
		
	}
	
	
	public static String backwardtooltip;
	public static String currentdurationafterbackward;
	public static void backwardm(String backward) throws InterruptedException
	{
		driver.findElement(playerpauseandplaybutton).click();
		while(!driver.findElement(currentduration).getText().equals(backward))
		{
			
		}
		driver.findElement(playerpauseandplaybutton).click();
		driver.findElement(playerbackwordbutton).click();
		currentdurationafterbackward=driver.findElement(currentduration).getText();
		log.info(currentdurationafterbackward);
		Thread.sleep(2000);
		backwardtooltip=driver.findElement(playerbackwardbuttontooltip).getText();
		log.info(backwardtooltip);
	
	}
	public static String enterfullscreentooltip;
	public static String exitfullscreentooltip1;
	public static void audiomuteandadjust() throws InterruptedException
	{
		driver.findElement(volumebutton).click();
		Thread.sleep(2000);
		volumeattributevalueinmute=driver.findElement(volumebuttonattribute).getAttribute("aria-valuetext");
		log.info(volumeattributevalueinmute);
		log.info("Audio muted");
		Thread.sleep(4000);
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(volumebutton)).click().build().perform();
		Thread.sleep(1000);
		volumeattributevalueinfullvolume=driver.findElement(volumebuttonattribute).getAttribute("aria-valuetext");
		log.info(volumeattributevalueinfullvolume);
		log.info("Audio unmuted");
		a.moveToElement(driver.findElement(volumebutton)).build().perform();
		a.moveToElement(driver.findElement(volumecontrol)).click().build().perform();
		Thread.sleep(1000);
		volumeafterclickingonvolumecontrol=driver.findElement(volumebuttonattribute).getAttribute("aria-valuetext");
		log.info(volumeafterclickingonvolumecontrol);
		WebElement ele=driver.findElement(fullscreensbutton);
		a.moveToElement(ele).build().perform();
		Thread.sleep(2000);
		enterfullscreentooltip=driver.findElement(fullscreenbuttontooltip).getText();
		log.info(enterfullscreentooltip);
		ele.click();
		Thread.sleep(3000);
		a.moveToElement(ele).click().build().perform();
		log.info("Full screen exited");
		
	}
	public static WebElement fullscreensbutton()
	{
		return driver.findElement(fullscreensbutton);
	}
	public static WebElement addfeelresonplayer()
	{
		return driver.findElement(addfeelresonplayer);
	}
	public static List<WebElement> feelerstext()
	{
		return driver.findElements(feelerstext);
	}
	public static WebElement getDuration()
	{
		return driver.findElement(getDuration);
	}
   
   
	
	
	
	public static void promoswitching1() throws InterruptedException
	   {
			String totalduration = driver.findElement(getDuration).getText();
			log.info(totalduration);
			String minsintotoalduration=totalduration.substring(0,totalduration.lastIndexOf(":"));
			String secondsintotalduration=totalduration.substring(3);
			log.info(secondsintotalduration);
			int integervalueofrunningdurationseconds=Integer.parseInt(secondsintotalduration);
			int k=integervalueofrunningdurationseconds-10;
			String minsinrunningduration = null;
			while(!minsintotoalduration.equals(minsinrunningduration))
			{
			    driver.findElement(fastforward).click();
				String runningdurationtotal=driver.findElement(currentduration).getText();
				log.info(runningdurationtotal);
				minsinrunningduration=runningdurationtotal.substring(0,runningdurationtotal.lastIndexOf(":"));		
				log.info(minsinrunningduration);
			}
			Thread.sleep(1000);
			if(integervalueofrunningdurationseconds>10)
			{
			   int i=0;
			   while(!(k<=i))
			   {
				driver.findElement(fastforward).click();
				String runningdurationtotal=driver.findElement(currentduration).getText();
				log.info(runningdurationtotal);
				String secondsinrunningduration=runningdurationtotal.substring(3);
				log.info(secondsinrunningduration);
				i=Integer.parseInt(secondsinrunningduration);
			   }
			}		
	   }
}
