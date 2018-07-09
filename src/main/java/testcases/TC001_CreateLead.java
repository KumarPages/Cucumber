package testcases;

import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cucumber.api.testng.CucumberFeatureWrapperImpl;
import cucumber.api.testng.TestNGCucumberRunner;
import cucumber.runtime.model.CucumberFeature;
import cucumber.RunCucumberTests;
import cucumber.UpdateCucumberExamples;
import wrappers.LeafTapsWrappers;
import cucumber.api.CucumberOptions;

@CucumberOptions(plugin={"pretty","html:format"},
features = "src/main/java/features/CreateLead.feature",glue={"pages"})


public class TC001_CreateLead extends LeafTapsWrappers{

	@BeforeClass
	public void setValues() {
		browserName="chrome";
		testCaseName="Create a new Lead";
		testDescription="Create a new Lead";
		category="smoke";
		dataSheetName="TC001";
		authors="Babu";
	}
	
	@Test(dataProvider="fetchData")
	public void createLead(String cname, String fname, String lname) {
		String[] data = {cname, fname, lname};
		RunCucumberTests.runTests(this.getClass(), "Create a new Lead", "CreateLead", data);
	}
}
