package pageObjects;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.ExcelUtil;

public class TravelInsurancePOM {
	WebDriver driver;
	JavascriptExecutor js;
	
	public TravelInsurancePOM(WebDriver driver)
	{
		this.driver=driver;
		js=(JavascriptExecutor)driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="(//div[@class='shadowHandlerBox'])[7]//ancestor::a")
	WebElement travelInsurance;
	
	public void clickTravelInsurance()
	{
		travelInsurance.click();
	}
	
	@FindBy(xpath="//*[@id=\"input-row\"]")
	WebElement Destination;
	
	public void clickDestination()
	{
		Destination.click();
	}
	
	
	@FindBy(xpath="//input[@id='country']")
	WebElement country;
	
	public void sndCountry()
	{
		country.sendKeys("United");
	}
	
	@FindBy(xpath="//*[text()=\"United Kingdom\"]")
	WebElement UK;
	
	public void clickUnitedKingdom()
	{
		UK.click();
	}
	
	@FindBy(xpath="//*[text()='Next']")
	WebElement next;
	
	public void clickNext()
	{
		next.click();
	}
	
	
	
	@FindBy(xpath="(//*[contains(@class,\"MuiInputBase-input\")])[1]")
	WebElement Date;
	
	public void clickDate()
	{
		Date.click();
	}
	
	public void selectDates()
	{

	    LocalDate localDate = LocalDate.now();//For reference
	    LocalDate next1=localDate.plusDays(1);
		LocalDate next = localDate.plusDays(10);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
		String formmatedCurrDate=next1.format(formatter);
		String formattedNextString = next.format(formatter);
		String chekinDate=formmatedCurrDate.substring(1,2);
		System.out.print(chekinDate);
		System.out.println(formattedNextString);
		String endDate = formattedNextString.substring(0,2);
		System.out.print(endDate);
		List<WebElement> dates=driver.findElements(By.xpath("//*[@class=\"MuiPickersCalendar-weekContainer\"]//*[@class=\"MuiPickersDateRangeDay-root\"]"));
		for(WebElement ele: dates)
		{
			String val=ele.getText();
			System.out.print(val);
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
	}
	
	@FindBy(xpath="//*[@id='traveller_2']")
	WebElement select_no_passengers;
	
	public void clickNoOfPersons()
	{
		js.executeScript("arguments[0].click()",select_no_passengers);
	}
	
	@FindBy(xpath="//*[@id='divarrow_undefined'][1]")
	WebElement drop_1;
	
	public void clickdrop_1()
	{
		drop_1.click();
	}
	
	@FindBy(id="22 years_undefined")
	WebElement age_22;
	public void selectAge_22()
	{
		js.executeScript("arguments[0].click()",age_22);
	}
	
	
	@FindBy(xpath="(//*[@id='divarrow_undefined'])[2]")
	WebElement drop_2;
	
	public void clickdrop_2()
	{
		drop_2.click();
	}
	
	@FindBy(id="21 years_undefined")
	WebElement age_21;
	
	public void selectAge_21()
	{
		js.executeScript("arguments[0].click()",age_21);
	}
	
	@FindBy(xpath="//*[@id='ped_no']")
	WebElement no;
	public void click_no()
	{
		no.click();
	}
	
	public void click_next_NO()

	{
		try
		{
		js.executeScript("arguments[0].click()",next);
		}
		catch(Exception e)
		{
			
		}
	}
	@FindBy(id="mobileNumber")
	WebElement mob;
	public void click_mobNo()
	{
		mob.click();
	}
	public void enter_mobNo()
	{
		mob.sendKeys("9812312346");
	}
	@FindBy(xpath="//*[text()='View plans']")
	WebElement view_plan;
	
	public void click_view_plan()
	{
		view_plan.click();
	}
	@FindBy(xpath="//*[@id=\"root\"]/div/div[2]/aside/section[1]/details/summary")
	WebElement sort_by;
	
	public void select_low_to_high() throws InterruptedException
	{
		try
		{
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id=\"modal-root\"]/div/div/span")).click();
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			js.executeScript("arguments[0].click()",sort_by);
			driver.findElement(By.id("17_sort")).click();
		}
	}
	
	public void print_first_three_companies()
	{
		for(int i=1;i<=3;i++)
		{
			String companyName=driver.findElement(By.xpath("(//div[@class=\"row_wrap flexRow contentWrapper\"]//div[@class=\"quotesCard__planName\"]//p[@class=\"quotesCard--insurerName\"])["+i+"]")).getText();
			String price=driver.findElement(By.xpath("(//p[@class=\"wrap-space \" ]//span[@class=\"premiumPlanPrice\"])["+i+"]")).getText();
			
			XSSFRow k1=ExcelUtil.createRow(i);
			ExcelUtil.setData(k1, 1, companyName);
			ExcelUtil.setData(k1, 2, price);
			System.out.println(companyName+" "+price);
			
			
		}
	}
	@FindBy(xpath="//*[text()=\"Policybazaar\"]")
	WebElement go_To_home;
	public void click_policy_bazar_logo()

	{
		js.executeScript("arguments[0].click()", go_To_home);
	}
	
	

}
