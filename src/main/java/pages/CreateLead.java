package pages;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import wrappers.LeafTapsWrappers;
public class CreateLead extends LeafTapsWrappers {	
	
	@When("Enter Company Name (.*)")
	public void enterCompanyName(String cname){
		enterById("createLeadForm_companyName", cname);
	}
	
	@When("Enter First Name (.*)")
	public void enterFirstName(String fname){
		enterById("createLeadForm_firstName", fname);
	}
	

	@When("Enter Last Name (.*)")
	public void enterLastName(String lname){
		enterById("createLeadForm_lastName", lname);
	}
	
	@When("Click Create Lead Button")
	public void clickCreateLead(){
		clickByName("submitButton");
	}
	

	
	

}
