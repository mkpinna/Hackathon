package stepDefination;

import java.util.List;

import org.apache.logging.log4j.Logger;

import cucumberBase.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Health_InsurancePOM;

public class HealthInsuranceStep {
	List<String>list_health_insurances;
	Health_InsurancePOM obj3;
	Logger log;
	
	@Given("the user is on the policy bazar home page")
	public void the_user_is_on_the_policy_bazar_home_page() {
		obj3=new Health_InsurancePOM(BaseClass.getDriver());
		log=BaseClass.getLogger();
		log.info("User Is On The PolicyBazar HomePage..");
	}

	@When("the user hover to the insurace products")
	public void the_user_hover_to_the_insurace_products() {
		obj3.hoverToInsuraceProducts();
		log.info("User Hovered on Insurance Products..");
		

	}

	@Then("the user prints all the health insurance menu")
	public void the_user_prints_all_the_health_insurance_menu() {
		list_health_insurances=obj3.print_health_insurances();
		System.out.print(list_health_insurances);
		log.info("User Printed All The Health Insurances..");
		log.info("Log End In Cucumber..");
	}

}
