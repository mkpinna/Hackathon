package stepDefination;

import org.apache.logging.log4j.Logger;


import cucumberBase.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CarInsurancePOM;

public class CarInsuranceStep {
	CarInsurancePOM obj2;
	Logger log;
	
	@Given("the user is on the policy bazar page")
	public void the_user_is_on_the_policy_bazar_page() {
		obj2=new CarInsurancePOM(BaseClass.getDriver());
		log=BaseClass.getLogger();
		log.info("User is on the Policy Bazar Home Page");
	}

	@When("the user click on the car insurance")
	public void the_user_click_on_the_car_insurance() {
		obj2.click_car_insurace();
	}

	@When("the user click on buying new car")
	public void the_user_click_on_buying_new_car() {
		obj2.click_buying_new_car();
		log.info("User Clicked Buying New Cars..");
	}

	@When("the user select city as delhi")
	public void the_user_select_city_as_delhi() {
		obj2.select_city_delhi();
		log.info("User Selected City as Delhi..");
	}

	@When("the user select area in delhi")
	public void the_user_select_area_in_delhi() {
		obj2.click_DL2();
		log.info("User Selected Area As DL2..");
	}

	@When("the user select company as volkswagon")
	public void the_user_select_company_as_volkswagon() {
		obj2.click_volkwagen();
		log.info("User Selected Car As Volkswagon..");
	}

	@When("the user select the car name")
	public void the_user_select_the_car_name() {
		obj2.click_ameo_car();
		log.info("User Selected Car Name as Ameo..");
	}

	@When("the user select the fuel type")
	public void the_user_select_the_fuel_type() {
		obj2.click_petrol();
		log.info("User Selected Fuel Type as Petrol..");
	}

	@When("the user select the model as highline plus")
	public void the_user_select_the_model_as_highline_plus() {
		obj2.click_model();
		log.info("User Selected The Model As Highline plus..");
	}

	@When("the user enter Invalid email {string} Name {string} Email {string} MobileNo")
	public void the_user_enter_invalid_email_name_email_mobile_no(String string, String string2, String string3) {
		obj2.enter_name();
		obj2.enter_invalid_email();
		log.info("User Entered Invalid Email Id..");
		obj2.send_mob_No();
		System.out.println(obj2.get_email_errorMessage());
	}
	
	@When("the user enter valid  email {string} Name  {string} Email {string} MobileNo")
	public void the_user_enter_valid_email_name_email_mobile_no(String string, String string2, String string3) {
		obj2.enter_valid_email();
		log.info("User Entered Valid Email..");
	}

	@When("the user enters the details click on the viewprices")
	public void the_user_enters_the_details_click_on_the_viewprices() {
		obj2.click_view_prices();
	}

	@When("the user click the registration in next seven days")
	public void the_user_click_the_registration_in_next_seven_days() {
		obj2.click_Next_7_Days();
		log.info("User Clicked On the Delhivery in next 7 Days..");
	}

	@When("the user enters the car price")
	public void the_user_enters_the_car_price() {
		obj2.enter_car_price();
	}

	@When("the  user clicks on the submit button")
	public void the_user_clicks_on_the_submit_button() throws InterruptedException {
		obj2.click_submit_button();
		log.info("User Enetred Car Ex Show Room Price As 9 Lakhs..");
	}

	@When("the user clicks first insurance")
	public void the_user_clicks_first_insurance() {
		obj2.click_first_insurance();
		log.info("User Selected The First Car Insurace Company..");
	}

	@Then("the user prints the car insurance quote")
	public void the_user_prints_the_car_insurance_quote() {
		String s=obj2.getInsuranceQuote();
		log.info("User Printed the Car Insurance Quote For That Company..");
		System.out.println(s);
	}

}
