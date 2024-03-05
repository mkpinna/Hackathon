package TestCases;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class TravelInsurance {
	//(//div[@class="row_wrap flexRow contentWrapper"]//div[@class="quotesCard__planName"])["+i+"]
	static JavascriptExecutor js;
	public static void main(String[] args) throws InterruptedException
	{
	WebDriver driver=new ChromeDriver();
	js=(JavascriptExecutor)driver;
	driver.navigate().to("https://www.policybazaar.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	////*[@class="MuiPickersCalendar-weekContainer"]//*[@class="MuiPickersDateRangeDay-root"]
	driver.findElement(By.xpath("(//div[@class='shadowHandlerBox'])[7]//ancestor::a")).click();
	WebElement Destination=driver.findElement(By.xpath("//*[@id=\"input-row\"]"));
	Destination.click();
	WebElement Country=driver.findElement(By.xpath("//input[@id='country']"));
	Country.sendKeys("United");
	driver.findElement(By.xpath("//*[text()='United Kingdom']")).click();
	driver.findElement(By.xpath("//button[@class='travel_main_cta']")).click();

	Actions act=new Actions(driver);
	WebElement hover=driver.findElement(By.xpath("(//*[contains(@class,\"MuiInputBase-input\")])[1]"));
	act.moveToElement(hover);
	hover.click();
	
//	driver.findElement(By.xpath("//*[@id=\"prequote-wrapper\"]/div[2]/div/div[1]/div/div[1]/div/div/input")).click();

    LocalDate localDate = LocalDate.now();//For reference
	LocalDate next = localDate.plusDays(4);
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
	String formmatedCurrDate=localDate.format(formatter);
	String formattedNextString = next.format(formatter);
	String chekinDate=formmatedCurrDate.substring(0,2);
	System.out.println(formattedNextString);
	String endDate = formattedNextString.substring(0,2);
	
	List<WebElement> dates=driver.findElements(By.xpath("//*[@class=\"MuiPickersCalendar-weekContainer\"]//*[@class=\"MuiPickersDateRangeDay-root\"]"));
	
	for(WebElement ele: dates)
	{
		String val=ele.getText();
		if(val.equalsIgnoreCase(chekinDate))
		{
			ele.click();
		}
		if(val.equalsIgnoreCase(endDate))
		{
			ele.click();
			break;
		}
	}
	
	WebElement button=driver.findElement(By.xpath("//*[text()='Next']"));
	button.click();
	Thread.sleep(2000);
	WebElement select_2=driver.findElement(By.xpath("//*[@id='traveller_2']"));//selecting passengers as 2
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].click()",select_2);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id='divarrow_undefined'][1]")).click();//clicking on the selecting the age of the first person
	Thread.sleep(3000);
	WebElement select_22=driver.findElement(By.xpath("//*[@id='22 years_undefined']"));//selecting age as 22
	js.executeScript("arguments[0].click()",select_22);
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//*[@class=\"customDropdown \"]//*[@id=\"divarrow_undefined\"])[2]")).click();//clicking on selecting 2nd passenger
	Thread.sleep(3000);
	WebElement select_21=driver.findElement(By.xpath("//*[@id=\"21 years_undefined\"]"));//selecting age as 21
	js.executeScript("arguments[0].click()",select_21);
	
	WebElement nextButton=driver.findElement(By.xpath("//*[text()='Next']"));
	nextButton.click();
	
	driver.findElement(By.id("ped_no")).click();
	Thread.sleep(1000);
	try
	{
	js.executeScript("arguments[0].click()",nextButton);
	}
	catch(Exception e)
	{
		
	}
	
	driver.findElement(By.id("mobileNumber")).click();
	driver.findElement(By.id("mobileNumber")).sendKeys("9812312346");
	driver.findElement(By.xpath("//*[text()='View plans']")).click();
	
	WebElement sortBy=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/aside/section[1]/details/summary"));
	js.executeScript("arguments[0].click()",sortBy);
	
	try
	{
	driver.findElement(By.id("17_sort")).click();
	}
	catch(Exception e)
	{
		driver.findElement(By.xpath("//*[@id=\"modal-root\"]/div/div/span")).click();
	}
	finally
	{
		act.click(sortBy);
		driver.findElement(By.id("17_sort")).click();
	}
	
	//(//div[@class="row_wrap flexRow contentWrapper"]//div[@class="quotesCard__planName"]//p[@class="quotesCard--insurerName"])["+i+"]
	
	//xpath to get the names of the companies
	
	//(//p[@class="wrap-space " ]//span[@class="premiumPlanPrice"])
	
	//xpath for displaying the price
	
	for(int i=1;i<=3;i++)
	{
		String companyName=driver.findElement(By.xpath("(//div[@class=\"row_wrap flexRow contentWrapper\"]//div[@class=\"quotesCard__planName\"]//p[@class=\"quotesCard--insurerName\"])["+i+"]")).getText();
		String price=driver.findElement(By.xpath("(//p[@class=\"wrap-space \" ]//span[@class=\"premiumPlanPrice\"])["+i+"]")).getText();
		System.out.println(companyName+" "+price);
		
	}
	driver.quit();
	
	
	
	
	
	
	
	
	}

}
