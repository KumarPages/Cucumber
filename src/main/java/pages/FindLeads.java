package pages;

import cucumber.api.java.en.*;
import wrappers.LeafTapsWrappers;
public class FindLeads extends LeafTapsWrappers {
	
	@When("In Find Leads Enter First Name (.*)")
	public void enterFirstNameInFindLeads(String fname){
		enterByXpath("(//*[@name='firstName'])[3]", fname);
	}
	
	
	@When("Click Find Leads Button")
	public void clickFindLeads(){
		clickByXpath("//button[.='Find Leads']");
	}
	
	@When("Click First Matching Lead")
	public void clickFirstMatchingLead() {
		clickByXpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]");
	}
	
	

}
