package stepDefination;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import cucumberBase.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class Hooks {
	 static WebDriver driver;
	 static Properties p;
	 
	@Before
    public void init() throws IOException
    {
		System.out.println("---------initializing------");
    	driver=BaseClass.initilizeBrowser();	
    	System.out.println("-----driver created----------");
    	p=BaseClass.getProperties();
    	driver.get(p.getProperty("URL"));
    	driver.manage().window().maximize();			
	}
	
    @After
    public void close() throws IOException { 		
    	driver.quit();
    }
}
    

