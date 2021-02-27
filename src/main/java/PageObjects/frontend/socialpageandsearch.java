package PageObjects.frontend;




import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Resources.Base_setup;

public class socialpageandsearch extends Base_setup
{
	
	 private static By socialpagetitlesfornewuser=By.xpath("//div[@class='flicks-cardtitle']/h3");
	 private static By socialpagedescriptionfornewuser=By.xpath("//div[@class='flicks-cardtitle']/p");
     private static By logoheader=By.xpath("//div[@class='header-logo']");
     private static By searchiconclick=By.name("search");
     private static By inputintosearch=By.xpath("//input[@role='combobox']");
     private static By headerlogo=By.linkText("home");
     private static By autosuggestivenames=By.xpath("//mat-option[@role='option']//span//span");
     private static By shocialpage=By.xpath("//div[@role='tablist']/div/div[2]");
     private static By nosearchfoundtext=By.xpath("//div[@class='mat-list-item-content']");
     private static By homepagesearch=By.xpath("//input[@placeholder='Search for Movies, Web Series, Studios, etc.']");
     //private static By homepagesearch=By.id("mat-input-1");
    //Home Page
     private static By studionames=By.xpath("//div[@class='card-main studio-card-content']/div[2]/div/a/h6");
     private static By followerstext=By.xpath("//div[@class='card-left box-promo']/p");
     private static By Latestpromostext=By.xpath("//span[@class='text ng-star-inserted']");
     private static By allheadingtext=By.xpath("//h4[@class='slider-title ng-star-inserted']");
     private static By shoorserieslabelonpromocards=By.xpath("//div[@class='card-main promo-card-content sho-promocard']/span");
     //private static By sharebuttononpromocrds=By.xpath("//div[@class='card-main promo-card-content sho-promocard']/div[1]/div");
     private static By sharebuttononpromocrds=By.xpath("//div[@class='hover-share flex align-items-center justify-content-center ng-star-inserted']");
     private static By hoveronpromocards=By.xpath("//div[@class='card-main promo-card-content sho-promocard']/div[1]");
     private static By promonamesoncards=By.xpath("//div[@class='card-left video-promo is-promo-title-img']/h4");
     private static By viewcountofpromos=By.xpath("//div[@class='card-left video-promo is-promo-title-img']/p");
     private static By gudcountofpromos=By.xpath("//span[@class='gud-count']");
     private static By pngtitlesimgonpromocards=By.xpath("//img[@alt='promo Poster']");
     private static By shoorseriesnames=By.xpath("//div[@class='hover-sho-detail ng-star-inserted']/div/h5");
     private static By shonameonmousehover=By.xpath("//div[@class='mat-ripple card-img cursor auto-image']");
     private static By addtowatchlist=By.xpath("//div[@class='details-btns flex']/div[1]");
     private static By shareshocard=By.xpath("//div[@class='details-btns flex']/div[2]");
     private static By shoorserieslabelonshocards=By.xpath("//div[@class='mat-ripple card-img cursor auto-image']/span");
     private static By shonameoncard=By.xpath("//div[@class='card-sho-name']");
     private static By shodetailsoncard=By.xpath("//ul[@class='ng-star-inserted']/li");
     private static By audionames=By.xpath("//h4[@class='card-title text-control']");
    // private static By genereonshocard=By.xpath("//ul[@class='ng-star-inserted']/li[1]");
     
     private static By continuewatchngtitle=By.xpath("//h4[@class='slider-title']");
     private static By shoorseriesnamesincontinuewatching=By.xpath("//div[@class='card-left width-full box-promo']/h6");
     private static By contiuewatchingcards=By.xpath("//img[@alt='promo Poster']");
     private static By closeiconofcontinuewatching=By.xpath("//span[@class='close flex align-items-center justify-content-center ng-star-inserted']");
     
     public static WebElement homepagesearch()
     {
    	 return driver.findElement(homepagesearch);
     }
     public static List<WebElement> socialpagetitlesfornewuser()
     {
    	 return driver.findElements(socialpagetitlesfornewuser);
     }
     public static List<WebElement> socialpagedescriptionfornewuser()
     {
    	 return driver.findElements(socialpagedescriptionfornewuser);
     }
     public static WebElement shocialpagem()
     {
    	 return driver.findElement(shocialpage);
     }
     public static void headerlogom()
     {
    	 driver.findElement(headerlogo).click();
     }
     public static WebElement logoheaderm()
     {
    	 return driver.findElement(logoheader);
     }
     public static WebElement searchiconclickm()
     {
  	   return driver.findElement(searchiconclick);
     }
     public static WebElement inputintosearchm()
     {
  	   return driver.findElement(inputintosearch);
     }
     public static WebElement nosearchfoundtext()
     {
    	 return driver.findElement(nosearchfoundtext);
     }
     public static void autosuggestivenamesm(String shoseriesorstudioname) throws InterruptedException
     {
    	 WebDriverWait wait=new WebDriverWait(driver,20);
       wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(autosuggestivenames)));
       Actions a=new Actions(driver);
  	   List<WebElement> ele=driver.findElements(autosuggestivenames);
  	   int size=ele.size();
  	   for(int i=0;i<size;i++)
  	   {
  		   String str=driver.findElements(autosuggestivenames).get(i).getText();
  		   if(str.equalsIgnoreCase(shoseriesorstudioname))
  		   {
  			   a.moveToElement(driver.findElements(autosuggestivenames).get(i)).click().build().perform();
  			   break;
  		   }
  	   }
     }
     public static List<WebElement> allstudionames()
     {
    	 return driver.findElements(studionames);
    	 
     }
     public static List<WebElement> followerstext()
     {
    	 return driver.findElements(followerstext);
     }
     public static WebElement Latestpromostext()
     {
    	 return driver.findElement(Latestpromostext);
     }
     public static List<WebElement> allheadingtext()
     {
    	 return driver.findElements(allheadingtext);
     }
     public static List<WebElement> shoorserieslabelonpromocards()
     {
    	 return driver.findElements(shoorserieslabelonpromocards);
     }
     public static List<WebElement> sharebuttononpromocrds()
     {
    	 return driver.findElements(sharebuttononpromocrds);
     }
     public static List<WebElement> hoveronpromocards()
     {
    	 return driver.findElements(hoveronpromocards);
     }
     public static List<WebElement> promonamesoncards()
     {
    	 return driver.findElements(promonamesoncards);
     }
     public static List<WebElement> viewcountofpromos()
     {
    	 return driver.findElements(viewcountofpromos);
     }
     public static List<WebElement> gudcountofpromos()
     {
    	 return driver.findElements(gudcountofpromos);
     }
     public static List<WebElement> pngtitlesimgonpromocards()
     {
    	 return driver.findElements(pngtitlesimgonpromocards);
     }
     public static List<WebElement> shoorseriesnames()
     {
    	 return driver.findElements(shoorseriesnames);
     }
     
     public static List<WebElement> shonameonmousehover()
     {
    	 return driver.findElements(shonameonmousehover);
     }
     public static List<WebElement> addtowatchlist()
     {
    	 return driver.findElements(addtowatchlist);
     }
     public static WebElement addtowatchlistindividual()
     {
    	 return driver.findElement(addtowatchlist);
     }
     public static List<WebElement> shareshocard()
     {
    	 return driver.findElements(shareshocard);
     }
     public static List<WebElement> shoorserieslabelonshocards()
     {
    	 return driver.findElements(shoorserieslabelonshocards);
     }
     public static List<WebElement> shonameoncard()
     {
    	 return driver.findElements(shonameoncard);
     }
     public static List<WebElement> shodetailsoncard()
     {
    	 return driver.findElements(shodetailsoncard);
     }
     public static List<WebElement> audionames()
     {
    	 return driver.findElements(audionames);
     }
     public static WebElement continuewatchngtitle()
     {
    	 return driver.findElement(continuewatchngtitle);
     }
     public static List<WebElement> shoorseriesnamesincontinuewatching()
     {
    	 return driver.findElements(shoorseriesnamesincontinuewatching);
     }
     public static List<WebElement> contiuewatchingcards()
     {
    	 return driver.findElements(contiuewatchingcards);
     }
     public static List<WebElement> closeiconofcontinuewatching()
     {
    	 return driver.findElements(closeiconofcontinuewatching);
     }
     
}
