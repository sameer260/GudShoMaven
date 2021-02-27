package Steps.frontend;





import java.io.File;







import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;



import PageObjects.frontend.Loginandsignup;
import PageObjects.frontend.Toastanderrormessages;

//import com.vimalselvam.cucumber.listener.Reporter;

//import com.vimalselvam.cucumber.listener.Reporter;


import Resources.Base_setup;


//import com.vimalselvam.cucumber.listener.Reporter;



import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;




public class Hooks extends Base_setup {
	
	static Loginandsignup ls=new Loginandsignup();
	
	public static String actual;
	@Before("~@nohook")
	public static void loginapplication() throws InterruptedException, IOException
	{
		Base_setup.intiliazedriver();
		    ls.signinlinkm().click();
		    
			try {
			 ls.phoneemailfieldm().sendKeys("9573875793");
			 ls.passwordfieldm().sendKeys("sameer6789");
			 ls.signinutton().click();
			 Toastanderrormessages.toastmessageclosem().click();
			 
			 //Thread.sleep(5000);
			 //String str1=l.welcomemessagem();
			 //System.out.println(str1);
		     //String str=StringUtils.replace(str1, "\n", " ");
		     //actual=str.substring(18);
		     
			 }
			 catch(Exception e)
			 {
				 System.out.println("502 bad gateway error");
			 }
	}
	
	@After(order=0)
	public void teardown()
	{
		driver.close();
		
	}
	@After(order=1)
	public void screenshotm(Scenario scenario) throws IOException 
	{
		if(scenario.isFailed())
		{
			String scenarioname=scenario.getName();
			TakesScreenshot ts=(TakesScreenshot)driver;
			File source=ts.getScreenshotAs(OutputType.FILE);
			String destinationpath=System.getProperty("user.dir")+"\\screenshotsfolder\\"+ scenarioname+".png";
			FileUtils.copyFile(source, new File(destinationpath));
			//com.cucumber.listener.Reporter.addScreenCaptureFromPath(destinationpath.toString());
			
		}
	}

}
	


