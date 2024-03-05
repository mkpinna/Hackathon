package pageObjects;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarInsurancePOM {
	WebDriver driver;
	JavascriptExecutor js;
	Actions act;
	public String s1;
	public CarInsurancePOM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="(//div[@class='shadowHandlerBox'])[4]//ancestor::a")
	WebElement Car_insurance_logo;
	
	public void click_car_insurace()
	{
		Car_insurance_logo.click();
	}
//	@FindBy(id="regNoTextBox")
//	WebElement car_no;
//	
//	public void enter_car_no()
//	{
//		car_no.sendKeys("DL-10-CB-1234");
//	}
	
	@FindBy(xpath="//*[text()='Buying a new car? Click here']")
	WebElement Buying_New_car;
	public void click_buying_new_car()
	{
		Buying_New_car.click();
	}
	@FindBy(id="spn2")
	WebElement city;
	public void select_city_delhi()
	{
		city.click();
	}
	@FindBy(xpath="//*[text()='DL2']")
	WebElement DL2;
	
	public void click_DL2()
	{
		DL2.click();
	}
	
	@FindBy(xpath="//*[text()='VOLKSWAGEN']//parent::span")
	WebElement volkswagen;
	public void click_volkwagen()
	{
		volkswagen.click();
	}
	
	@FindBy(xpath="//*[@data-modelid=\"515\"]//span")
	WebElement ameo;
	public void click_ameo_car()
	{
		act=new Actions(driver);
		act.moveToElement(ameo).perform();
		act.click(ameo).perform();
	}
	
	@FindBy(xpath="//*[@data-fueltypeid=\"7\"]//span")
	WebElement petrol;
	public void click_petrol()
	{
		petrol.click();
	}
	
	@FindBy(xpath="//*[text()=\"Highline (999 cc)\"]//parent::span")
	WebElement model;
	public void click_model()
	{
		model.click();
	}
	
	
	
	
//	@FindBy(id="btnGetQuotes")
//	WebElement viewPrices;
//	
//	public void click_viewPrices()
//	{
//		viewPrices.click();
//	}
	
	@FindBy(id="name")
	WebElement name;
	public void enter_name()
	{
		name.sendKeys("Murali");
	}
	
	@FindBy(id="email")
	WebElement email;
	public void enter_invalid_email()
	{
		email.sendKeys("policy123#gmail.com");
	}
	
	public void enter_valid_email()
	{
		email.sendKeys(Keys.CONTROL + "a");
		email.sendKeys(Keys.DELETE);
		email.sendKeys("policy123@gmail.com");
	}
	
	@FindBy(xpath="//*[text()=\"Please enter a valid e-mail ID.\"][2]")
	WebElement error_message;
	public String get_email_errorMessage()
	{
		s1=error_message.getText();
		return error_message.getText();
	}
	
	@FindBy(id="mobileNo")
	WebElement mobile_no;
	public void send_mob_No()
	{
		mobile_no.sendKeys("9812312346");
	}
	
	@FindBy(xpath="(//*[text()='View Prices']//parent::button)")
	WebElement view_prices;
	
	public void click_view_prices()
	{
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()",view_prices);	
		
	}
	
	@FindBy(xpath="(//*[@class=\"radioBox bgWhite\"])[2]")
	WebElement Next_7_Days;
	public void click_Next_7_Days()
	{
		Actions act=new Actions(driver);
		act.moveToElement(Next_7_Days).perform();
		act.click().perform();
	}
	
	@FindBy(xpath="//*[@name=\"exShowRoomPrice\"]")
	WebElement car_price;
	public void enter_car_price()
	{
		car_price.sendKeys("900000");
	}
	
	@FindBy(xpath="//*[text()=\"Submit\"]")
	WebElement submit;
	public void click_submit_button() throws InterruptedException
	{
		submit.click();
		Thread.sleep(2000);
	}
	@FindBy(xpath="//*[@class=\"primaryBtnV2 fillingEffect\"]")
	WebElement firstoption;
	public void click_first_insurance()
	{
		firstoption.click();	
	}
	
	@FindBy(name="summaryFormPF")
	WebElement summary;
	public String getInsuranceQuote()
	{
		return summary.getText();
	}
	
	@FindBy(xpath="//*[@class=\"logo\"]")
	WebElement logo;
	public void click_logo()
	{
	logo.click();	
	}
}
