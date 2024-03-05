package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Health_InsurancePOM {
	WebDriver driver;
	Actions act;
	List<String> temp;  
	public Health_InsurancePOM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//*[text()=\"Insurance Products \"]")
	WebElement insurace_Products;
	public void hoverToInsuraceProducts()
	{
		act=new Actions(driver);
		act.moveToElement(insurace_Products).perform();
	}
	
	
	@FindBy(xpath="((//*[@class=\"ruby-col-3 hidden-md\"])[2]//li)")
	List<WebElement> list_of_health_insurances;
	
	public List<String> print_health_insurances()
	{
		temp=new ArrayList<String>();
		
		for(WebElement ele:list_of_health_insurances)
		{
			String value=ele.getText();
			temp.add(value);
		}
		return temp;
		
	}
	
//	@FindBy(xpath="(//div[@class='shadowHandlerBox'])[6]//ancestor::a")
//	WebElement health_insurace;
//	public void click_health_insurance()
//	{
//		health_insurace.click();
//	}
//	@FindBy(xpath="//*[text()=\" Continue › \"]")
//	WebElement continue_button;
//	public void click_continue()
//	{
//		continue_button.click();
//	}
//	@FindBy(xpath="//select[@id=\"Self\"]")
//	WebElement selectAge;
//	public void select_Age()
//	{
//		Select drop=new Select(selectAge);
//		wait = new WebDriverWait(driver,Duration.ofSeconds(15));          //add Explicit Wait
//		wait.until(ExpectedConditions.elementToBeClickable(selectAge));
//		//drop.selectByValue("22");
//		drop.selectByVisibleText("22 yr");
//	}
//	@FindBy(xpath="//*[text()=\"Hyderabad\"]")
//	WebElement city;
//	public void select_city_hyderabad()
//	{
//		wait.until(ExpectedConditions.elementToBeClickable(city));
//		city.click();
//	}
//	
//	@FindBy(xpath="//*[text()=\"Your full name\"]//preceding::input")
//	WebElement name;
//	public void enter_name()
//	{
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"Your full name\"]//preceding::input")));
//		//name.click();
//		//js.executeScript("arguments[0].click()",driver.findElement(By.xpath("//*[@class=\"fieldBlock\"]")));
//		js.executeScript("document.getElementById('fullName').value='Murali';");
//	}
//	
//	@FindBy(id="mobile")
//	WebElement mob_no;
//	public void enterMob_no()
//	{
//		mob_no.sendKeys("9342525252");
//		driver.get("https://health.policybazaar.com/ped/5?pq=health0&new=1&lp=1&utm_content=health_icon_newlp&enquiryid=NTY4NTY1OTQz&encenq=SFBnNFl4dTFXemZGalFYUW1lTWI5TmxCZG9QbnJRbnpJRnRaVU9WTVpTVT0&k=eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJFbnF1aXJ5SWQiOjU2ODU2NTk0MywiRXhwaXJ5VGltZSI6MTcxNjI5MDk4MX0.JTmVQA3kxN-hBd_SnBaueLK0mUTDF8FZIC2kC7LKBvj5TVMdhFtfsflvX36TXLDFcn7XrPdpShA8vt4n7aqDtJgNyB15wUeHvY1vVDyFD9cV1IKDDoD6qRhB4hxAUYNlsgaFo_pNtPortGuUZy9GwO-ImjbL1lD5K9rYpy6qZkk&profileid=112759970");
//	}
	
	
	
}
