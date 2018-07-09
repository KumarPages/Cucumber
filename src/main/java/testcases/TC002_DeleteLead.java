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
features = "src/main/java/features/DeleteLead.feature",glue={"pages"})


public class TC002_DeleteLead extends LeafTapsWrappers{

	@BeforeClass
	public void setValues() {
		browserName="chrome";
		testCaseName="Delete a Lead";
		testDescription="Search and Delete a Lead";
		category="smoke";
		dataSheetName="TC002";
		authors="Babu";
	}
	
	@Test(dataProvider="fetchData")
	public void createLead(String fname) {
		String[] data = {fname};
		RunCucumberTests.runTests(this.getClass(), "Delete an existing Lead", "DeleteLead", data);
	}
}
