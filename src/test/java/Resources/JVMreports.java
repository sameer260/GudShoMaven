package Resources;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class JVMreports
{
	public static  void generatejvmreport(String json)
	{
		File f = new File("target/cucumber-reports");
		Configuration con = new Configuration(f,"Gudsho");
		con.addClassifications("Platform","Android");
		con.addClassifications("PlatformVersion","10");
		con.addClassifications("sprint", "1");
		
		List<String> jvm =new ArrayList<String>();	
				jvm.add(json);
				
	ReportBuilder rep=new ReportBuilder(jvm, con);
	}

}
