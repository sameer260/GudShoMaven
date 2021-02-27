package PageObjects.frontend;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Resources.Base_setup;


public class Streaming extends Base_setup
{
	
	 static By streamingtab=By.xpath("//div[@role='tablist']/div/div[1]");
	private static By streamingpagetitles=By.xpath("//div[@class='slider-header flex justify-content-between']/h4");
	private static By shocardnames=By.xpath("//div[@class='card-sho']");
	private static By shocards=By.xpath("//div[@class='card-main vertical-card']/div[1]");
	private static By Shonameonshocards=By.xpath("//div[@class='hover-sho-detail ng-star-inserted']/div");
	private static By shoorserieslabelonshocards=By.xpath("//span[@class='wl-sho card-badge badge full-badge sho ng-star-inserted']");
	private static By generenameonshocard=By.xpath("//ul[@class='ng-star-inserted']/li[1]");
	private static By maturityratingonshocard=By.xpath("//ul[@class='ng-star-inserted']/li[2]/span");
	private static By videoduration=By.xpath("//ul[@class='ng-star-inserted']/li[3]");
	private static By rowsliders=By.xpath("//div[@class='slider-content']");
	private static By nextarrow=By.xpath("//div[@class='arrow-next-prev']/div[1]");
	private static By backarrow=By.xpath("//span[@class='back-icon cursor']");
	private static By promonames=By.xpath("//div[@class='card-footer flex justify-content-between ng-star-inserted']/div/h4");
	private static By shoorseriesnameonprmocard=By.xpath("//div[@class='card-left video-promo']/p[1]");
	private static By viewcount=By.xpath("//p[@class='views ng-star-inserted']");
	private static By gudcount=By.xpath("//span[@class='gud-count']");
	private static By mousehoveronpromocards=By.xpath("//div[@class='card-main promo-card-content sho-promocard']");
	private static By studioname=By.xpath("//div[@class='card-left box-promo']/a/h6");
	private static By followerscount=By.xpath("//div[@class='card-left box-promo']/p");
	private static By followbutton=By.xpath("//app-follow-studios[@class='ng-star-inserted']");
	private static By studiocards=By.xpath("//div[@class='card-main studio-card-content']");
	private static By audionames=By.xpath("//div[@class='card-main audio-card-content']//div[2]/div/div/h4");
	private static By composernameinaudio=By.xpath("//div[@class='card-left width-full']/span");
	private static By audiocards=By.xpath("//div[@class='card-main audio-card-content']");
	private static By promoshareicon=By.xpath("//div[@class='hover-share flex align-items-center justify-content-center ng-star-inserted']");
	private static By promonamesnpromopage=By.xpath("//div[@class='card-left box-promo']/h4");
	private static By viewcountnpromopage=By.xpath("//div[@class='card-right box-promo ng-star-inserted']/span");
	private static By watchlistbutton=By.xpath("//div[@class='follow-btn ng-star-inserted']");
	private static By tooltiponwatchlater=By.xpath("//div[@class='follow-btn ng-star-inserted']/app-watch-later/div/span");
	private static By shoorspisoesnameincontinuewatching=By.xpath("//div[@class='card-left width-full box-promo']");
	private static By continuewatchingcads=By.xpath("//div[@class='see-all-image cursor']");
	private static By crossicononcontinuewatching=By.xpath("//div[@class='see-all-image cursor']/div/span");
	
	
	public static WebElement streamingtabm()
	{
		return driver.findElement(streamingtab);
	}
	public static List<WebElement> streamingpagetitlesm()
	{
		return driver.findElements(streamingpagetitles);
	}
	public static List<WebElement> shocardnamesm()
	{
		return driver.findElements(shocardnames);
	}
	public static List<WebElement> shocardsm()
	{
		return driver.findElements(shocards);
	}
	public static List<WebElement> rowslidersm()
	{
		return driver.findElements(rowsliders);
	}
	public static List<WebElement> nextarrowm()
	{
		return driver.findElements(nextarrow);
	}
	public static WebElement backarrowm()
	{
		return driver.findElement(backarrow);
	}
	public static List<WebElement> promonamesm()
	{
		return driver.findElements(promonames);
	}
	public static List<WebElement> shoorseriesnameonprmocardm()
	{
		return driver.findElements(shoorseriesnameonprmocard);
	}
	public static List<WebElement> viewcountm()
	{
		return driver.findElements(viewcount);
	}
	public static List<WebElement> gudcountm()
	{
		return driver.findElements(gudcount);
	}
	public static List<WebElement> mousehoveronpromocardsm()
	{
		return driver.findElements(mousehoveronpromocards);
	}
	public static List<WebElement> studionamem()
	{
		return driver.findElements(studioname);
	}
	public static List<WebElement> followerscountm()
	{
		return driver.findElements(followerscount);
	}
	public static List<WebElement> followbuttonm()
	{
		return driver.findElements(followbutton);
	}
	public static List<WebElement> studiocardsm()
	{
		return driver.findElements(studiocards);
	}
	public static List<WebElement> audionamesm()
	{
		return driver.findElements(audionames);
	}
	public static List<WebElement> composernamem()
	{
		return driver.findElements(composernameinaudio);
	}
	public static List<WebElement> audiocardsm()
	{
		return driver.findElements(audiocards);
	}
	public static List<WebElement> promoshareiconm()
	{
		return driver.findElements(promoshareicon);
	}
	public static List<WebElement> promonamesnpromopagem()
	{
		return driver.findElements(promonamesnpromopage);
	}
	public static List<WebElement> viewcountnpromopagem()
	{
		return driver.findElements(viewcountnpromopage);
	}
	public static List<WebElement> watchlistbuttonm()
	{
		return driver.findElements(watchlistbutton);
	}
	public static List<WebElement> Shonameonshocardsm()
	{
		return driver.findElements(Shonameonshocards);
	}
	public static List<WebElement> shoorserieslabelonshocardsm()
	{
		return driver.findElements(shoorserieslabelonshocards);
	}
	public static List<WebElement> generenameonshocardm()
	{
		return driver.findElements(generenameonshocard);
	}
	public static List<WebElement> maturityratingonshocardm()
	{
		return driver.findElements(maturityratingonshocard);
	}
	public static List<WebElement> videodurationm()
	{
		return driver.findElements(videoduration);
	}
	public static List<WebElement> tooltiponwatchlaterm()
	{
		return driver.findElements(tooltiponwatchlater);
	}
	public static List<WebElement> shoorspisoesnameincontinuewatchingm()
	{
		return driver.findElements(shoorspisoesnameincontinuewatching);
	}
	public static List<WebElement> continuewatchingcadsm()
	{
		return driver.findElements(continuewatchingcads);
	}
	public static List<WebElement> crossicononcontinuewatchingm()
	{
		return driver.findElements(crossicononcontinuewatching);
	}
	
	
	public static Properties inputs() throws IOException
	{
		Properties property=new Properties();
		FileInputStream file=new FileInputStream("D:\\Eclipseworkspace\\webautomation\\src\\main\\java\\Resources\\inputs.properties");
		property.load(file);
		return property;
	}
	
	
	
}
