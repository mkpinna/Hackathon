package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.TravelInsurancePOM;
import cucumberBase.BaseClass;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.logging.log4j.Logger;

import Utilities.ExcelUtil;

public class TravelInsurance {
	TravelInsurancePOM obj1;
	Logger log;
	
	
	@Given("the user clicks on the policy bazar page")
	public void the_user_clicks_on_the_policy_bazar_page() throws FileNotFoundException {
		obj1=new TravelInsurancePOM(BaseClass.getDriver());
		log=BaseClass.getLogger();
		ExcelUtil.excelInit();
		log.info("Log Started In Cucumber..");
		log.info("User Is On The Policy Bazar Home Page..");
		
	}

	@When("the user clicks the travel insurance")
	public void the_user_clicks_the_travel_insurance() {
		log.info("User Clicked Travel Insurance...");
		obj1.clickTravelInsurance();
	}

	@When("the user enters {string} and select United Kingdom")
	public void the_user_enters_and_select_united_kingdom(String string) {
		obj1.clickDestination();
		log.info("User Clicked Clicked Destination..");
		obj1.sndCountry();
		obj1.clickUnitedKingdom();	
		log.info("User Selected Destination..");
		
	}

	@When("the user clicks next after delecting destination")
	public void the_user_clicks_next_after_delecting_destination() {
		obj1.clickNext();
	}

	@When("the user clicks select date")
	public void the_user_clicks_select_date() {
		obj1.clickDate();
		obj1.selectDates();
		log.info("User Opted the Dates..");
		

	}

	@When("the user clicks next after selecting date")
	public void the_user_clicks_next_after_selecting_date() {
		obj1.clickNext();
	}

	@When("the user selects no of persons as two")
	public void the_user_selects_no_of_persons_as_two() {
		obj1.clickNoOfPersons();
		log.info("User selected no of persons..");
	}

	@When("the user selects age for the two students")
	public void the_user_selects_age_for_the_two_students() {
		obj1.clickdrop_1();
		obj1.selectAge_21();
		log.info("User selected first person age..");
		obj1.clickdrop_2();
		obj1.selectAge_22();
		log.info("User selected second person age..");
	}

	@When("the user clicks next after students selection")
	public void the_user_clicks_next_after_students_selection() {
		obj1.clickNext();
	}

	@When("the user clicks no for medical issues")
	public void the_user_clicks_no_for_medical_issues() {
		obj1.click_no();
		log.info("User Clicked No For Medical Problems..");
	}

	@When("the user clicks next after no")
	public void the_user_clicks_next_after_no() {
		obj1.click_next_NO();
	}

	@When("the user enters {string}")
	public void the_user_enters(String string) {
		obj1.click_mobNo();
		obj1.enter_mobNo();
		log.info("User Entered Mobile Number..");
	}

	@When("the user clicks viewplans")
	public void the_user_clicks_viewplans() {
		obj1.click_view_plan();
	}

	@When("the user select price as low to high")
	public void the_user_select_price_as_low_to_high() throws InterruptedException {
		obj1.select_low_to_high();
		log.info("User Selected Sort Price Low TO High..");
	}

	@Then("the user prints the first three companies details")
	public void the_user_prints_the_first_three_companies_details() throws IOException {
		obj1.print_first_three_companies();
		log.info("User Printed The First Three Companies..");
		ExcelUtil.closeExcel();
	}
	
}
