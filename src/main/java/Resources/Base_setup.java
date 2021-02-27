package Resources;


import java.io.FileInputStream;



import java.io.IOException;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;




public class Base_setup 
{
	
	static public WebDriver driver;
	//public static final String USERNAME = "contus1";
	//public static final String AUTOMATE_KEY = "f4xtU1SEDvuP2Ad27yxy";
    //public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	public static WebDriver intiliazedriver() throws IOException
	{
	Properties prop=new Properties();
	//FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/Resource/baseproperties.properties");
	FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\baseproperties.properties");
    prop.load(fis);
    String browsername=prop.getProperty("browser");
    String url=prop.getProperty("baseurl");
    if(browsername.contains("chrome"))
    {
    	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver\\chromedriver87.exe");
    	ChromeOptions options=new ChromeOptions();
    	if(browsername.contains("headless"))
    	{
    	options.addArguments("headless");
    	options.addArguments("window-size=1400,600");
    	}
    	options.addArguments("--disable-notifications");
    	driver=new ChromeDriver(options);
    	
    	        
    }
    else if(browsername.contains("Firefox"))
    {
    	System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\chromedriver\\geckodriver.exe");
    	driver=new FirefoxDriver();
    }
    else if(browsername=="internetexplorer")
    {
    	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver\\chromedriver.exe");
    	driver=new InternetExplorerDriver();
    }
    
    
   
   /* DesiredCapabilities caps = new DesiredCapabilities();
    
    caps.setCapability("os", "Windows");
    caps.setCapability("os_version", "10");
    caps.setCapability("browser", "Chrome");
    caps.setCapability("browser_version", "80");
    caps.setCapability("name", "contus1's First Test");
    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);*/
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
     
     driver.get(url);
     return driver;
	
	}
	
	
	/*public void pom() {
		PageFactory.initElements(driver, Loginandsignup.class);
	}*/
	

}