package TestCases;

import java.io.IOException;
import java.util.List;
import org.testng.annotations.Test;

import Utilities.takeScreenshot;
import pageObjects.CarInsurancePOM;
import pageObjects.Health_InsurancePOM;
import pageObjects.TravelInsurancePOM;

public class Tests extends BaseClass_testNG {
	//https://github.com/mkpinna/PolicyBazar.git
	//https://github.com/mkpinna/miniproject.git
	TravelInsurancePOM obj1;
	CarInsurancePOM obj2;
	List<String>list_health_insurances;
	public static String path;
	
	@Test(priority=1,groups = {"smoke Test one"})
	public void open_travel_insurance()
	{
		obj1=new TravelInsurancePOM(driver);
		obj1.clickTravelInsurance();
		log.info("Log Started In TestNG..");
		log.info("User Clicked Travel Insurance..");
		
	}
	@Test(priority=2,groups = {"regression Test One"},dependsOnGroups = {"smoke Test one"})
	public void select_destination() throws IOException
	{
		
		obj1.clickDestination();
		log.info("User Clicked Clicked Destination..");
		obj1.sndCountry();
		obj1.clickUnitedKingdom();	
		log.info("User Selected Destination..");
		path=takeScreenshot.ScreenshotPage("Setting Destination", driver);
	}
	@Test(priority=3,groups = {"regression Test One"})
	public void next_Fuctionality() throws InterruptedException
	{
		obj1.clickNext();
		Thread.sleep(2000);
	}
	@Test(priority=4,groups = {"regression Test One"})
	public void click_Date()
	{
		obj1.clickDate();
	}
	
	@Test(priority=5,groups = {"regression Test One"})
	public void select_Date() throws IOException
	{
		obj1.selectDates();
		log.info("User Opted the Dates..");
		path=takeScreenshot.ScreenshotPage("Date Selected", driver);
		obj1.clickNext();
	}
	
	@Test(priority=6,groups = {"regression Test One"})
	public void click_No_of_persons()
	{
		obj1.clickNoOfPersons();
		log.info("User selected no of persons..");
	}
	
	@Test(priority=7,groups = {"regression Test One"})
	public void drop_1()
	{
		obj1.clickdrop_1();
		obj1.selectAge_21();
		log.info("User selected first person age..");

	}
	
	@Test(priority=8,groups = {"regression Test One"})
	public void drop_2_and_Next()
	{
		obj1.clickdrop_2();
		obj1.selectAge_22();
		log.info("User selected second person age..");
		obj1.clickNext();
	}
	
	@Test(priority=9,groups= {"regression Test One"})
	public void press_no()
	{
		obj1.click_no();
		log.info("User Clicked No For Medical Problems..");
	}
	
	@Test(priority=10,groups= {"regression Test One"})
	public void next_click_no()
	{
		obj1.click_next_NO();
	}
	
	@Test(priority=11,groups= {"regression Test One"})
	public void enter_mob_no()
	{
		obj1.click_mobNo();
		obj1.enter_mobNo();
		log.info("User Entered Mobile Number..");
	}
	@Test(priority=12,groups= {"regression Test One"})
	public void press_Viewplan()
	{
		obj1.click_view_plan();
	}
	@Test(priority=13,groups= {"regression Test One"})
	public void lowest_prices_of_three_insurances() throws InterruptedException
	{
	obj1.select_low_to_high();	
	log.info("User Selected Sort Price Low TO High..");
	}
	@Test(priority=14,groups= {"regression Test One"})
	public void print_First_Three_companies() throws IOException
	{
		path=takeScreenshot.ScreenshotPage("First Three Companies", driver);
		obj1.print_first_three_companies();
		log.info("User Printed The First Three Companies..");
	}
	@Test(priority=15)
	public void go_To_Home_Page() throws IOException
	{
		obj1.click_policy_bazar_logo();
		log.info("User Navigated to Home Page..");
		path=takeScreenshot.ScreenshotPage("Home Page After Logo Click", driver);
	}
	
	@Test(priority=15,groups = {"smoke Test Two"})
	public void open_car_insurance()
	{
		obj2=new CarInsurancePOM(driver);
		obj2.click_car_insurace();
		
	}
	
	@Test(priority=16,groups= {"regression Test Two"},dependsOnGroups = {"smoke Test Two"})
	public void enter_new_car_details()
	{
		
		obj2.click_buying_new_car();
		log.info("User Clicked Buying New Cars..");
		obj2.select_city_delhi();
		log.info("User Selected City as Delhi..");
		obj2.click_DL2();
		log.info("User Selected Area As DL2..");
		obj2.click_volkwagen();
		log.info("User Selected Car As Volkswagon..");
		obj2.click_ameo_car();
		log.info("User Selected Car Name as Ameo..");
		obj2.click_petrol();
		log.info("User Selected Fuel Type as Petrol..");
		obj2.click_model();
		log.info("User Selected The Model As Highline plus..");
		
	}
	@Test(priority=17,groups= {"regression Test Two"})
	public void enter_invalid_email() throws IOException
	{
		obj2.enter_name();
		obj2.enter_invalid_email();
		obj2.send_mob_No();
		log.info("User Entered Invalid Email Id..");
		path=takeScreenshot.ScreenshotPage("error_email_message", driver);
		log.info("User Captured The ScreenShot of It..");
		System.out.println(obj2.get_email_errorMessage());
		
	}
	@Test(priority=18,groups= {"regression Test Two"})
	public void enter_valid_email() throws IOException, InterruptedException
	{
		obj2.enter_valid_email();
		log.info("User Entered Valid Email..");
		path=takeScreenshot.ScreenshotPage("Valid_Email", driver);
		log.info("User Captured Screenshot of Valid Email..");
		obj2.click_view_prices();
		obj2.click_Next_7_Days();
		log.info("User Clicked On the Delhivery in next 7 Days..");
		obj2.enter_car_price();
		log.info("User Enetred Car Ex Show Room Price As 9 Lakhs..");
		obj2.click_submit_button();
		obj2.click_first_insurance();
		log.info("User Selected The First Car Insurace Company..");
		String s=obj2.getInsuranceQuote();
		log.info("User Printed the Car Insurance Quote For That Company..");
		System.out.println(s);
		
		
	}
	
	@Test(priority=19)
	public void go_to_HomePage()
	{
		obj2.click_logo();
		log.info("User Navigated To The Home Page..");
	}
	
	@Test(priority=20,groups= {"regression Test Three"})
	public void entering_health_insurance_details() throws IOException
	{
		Health_InsurancePOM obj3=new Health_InsurancePOM(driver);
		obj3.hoverToInsuraceProducts();
		log.info("User Hovered on Insurance Products..");
		path=takeScreenshot.ScreenshotPage("Health Insurance List", driver);
		list_health_insurances=obj3.print_health_insurances();
		log.info("User Printed All The Health Insurances..");
		System.out.println(list_health_insurances);
		log.info("Log End ..");
		
	}

}
