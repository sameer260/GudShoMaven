package Runner;

import java.io.File;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.PropertyConfigurator;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.vimalselvam.cucumber.listener.ExtentProperties;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

//import com.vimalselvam.cucumber.listener.ExtentProperties;
//import com.vimalselvam.cucumber.listener.Reporter;
import Resources.Base_setup;
import Resources.JVMreports;


@RunWith(Cucumber.class)
@CucumberOptions(features= "Features/Frontend/BStudioprofile.feature",
glue={"Steps"},
//tags= {"@fail"},
//tags= {"@minititle1"},
plugin = {//"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:",
		 "json:Cucumber.json",
		 "junit:target/cucumber-reports/Cucumber.xml",
		 "html:target/cucumber-reports",
		 "json:jsonfolder\\Json\\reports.json",
		 "rerun:target/rerun.txt"},
//plugin= {"json:D:\\sameerworkspace\\GudSho\\jsonfolder\\reports.json"},
//plugin = {"com.cucumber.listener.ExtentCucumberFormatter:"},
monochrome=true)


					
public class Runner extends Base_setup
{	
	
	@BeforeClass
	public static void extent() throws IOException
	{
		
	  ExtentProperties extentprop=ExtentProperties.INSTANCE;
	  String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	  extentprop.setReportPath(System.getProperty("user.dir")+"\\ExtentReports\\Report"+timestamp+".html");
	  PropertyConfigurator.configure(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\log4j.properties");
	
	}
	
	@AfterClass
	public static void setup()
	{	
	Reporter.loadXMLConfig(new File(System.getProperty("user.dir")+"\\src\\test\\java\\Resources\\extent-config.xml"));
	Reporter.setSystemInfo("User Name", "Sameer");
	Reporter.setSystemInfo("Application Name", "GudSho ");
	Reporter.setSystemInfo("GudSho", "QA");
	Reporter.setTestRunnerOutput("Test Execution Cucumber Report");
	JVMreports.generatejvmreport("Cucumber.json");
	
	
	}
	
}