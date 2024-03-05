package TestCases;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import Utilities.ExcelUtil;

public class BaseClass_testNG {
	public static WebDriver driver;
	Logger log;
	public Properties p;
	
	 @BeforeClass(alwaysRun = true)
	  @Parameters({"os","browser"})
	  public void beforeClass(String os,String browser) throws InterruptedException, IOException {
		
		 FileReader file=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configure.properties");
		 p=new Properties();
		 p.load(file);
		 log=LogManager.getLogger(this.getClass());
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		 	{	
			
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--disable-blink-features=AutomationControlled");
			option.addArguments("--disable-notifications");
			DesiredCapabilities capabilities=new DesiredCapabilities(option);
			
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("No matching os..");
				return;
			}
			
			//browser
			switch(browser.toLowerCase())
			{
			case "chrome" : 
				capabilities.setBrowserName("chrome"); 
				break;
			case "edge" :
				capabilities.setBrowserName("Edge"); 
				break;
			default: System.out.println("No matching browser.."); 
			return;
			}
			
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
			
		    }
		else if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			switch(browser.toLowerCase())
			{
			case "chrome":
				ChromeOptions option = new ChromeOptions();
				option.addArguments("--disable-blink-features=AutomationControlled");
				option.addArguments("--disable-notifications");
				driver=new ChromeDriver(option); 
				break;
			case "edge": 
				driver=new EdgeDriver();
				break;
			default: System.out.println("No matching browser..");
						return;
			}
		}
		  
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  driver.navigate().to(p.getProperty("URL"));
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  ExcelUtil.excelInit();
	  }

	  @AfterClass
	  public void afterClass() throws IOException {
		 ExcelUtil.closeExcel();
		 driver.quit();
	  }
}


//DesiredCapabilities capabilities=new DesiredCapabilities();
//capabilities.setPlatform(Platform.WIN11);
// if(browser.equals("chrome"))
// {
//	  capabilities.setBrowserName("chrome");
//	  ChromeOptions option = new ChromeOptions();
//		option.addArguments("--disable-blink-features=AutomationControlled");
//		option.addArguments("--disable-notifications");
//		driver=new ChromeDriver(option);
// }
// else if(browser.equals("edge"))
// {
//	  
//	  driver=new EdgeDriver();
// }
