package wrappers;

import java.util.Map;
import java.util.Map.Entry;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import gherkin.formatter.model.ScenarioOutline;
import utils.DataInputProvider;

public class LeafTapsWrappers extends GenericWrappers {
	
	public String browserName;
	public String dataSheetName;
	public static Scenario scenario;
	public static ScenarioOutline scenarioutline;

	/*@Before
	public void before(Scenario scenario) {		
		System.out.println("currently executig scenario " + scenario.getName());
		this.scenario = scenario;
	}

	@Before
	public void before(ScenarioOutline scenarioutline) {		
		System.out.println("currently executig scenario " + scenarioutline.getName());
		Map<String, Object> map = scenarioutline.toMap();
		for (Entry<String, Object> item : map.entrySet()) {
			System.out.println(item.getKey());
			System.out.println(item.getValue());

		}
		this.scenarioutline = scenarioutline;
	}
*/
	@BeforeSuite
	public void beforeSuite(){
		startResult();
	}

	@BeforeTest
	public void beforeTest(){
		loadObjects();
	}
	
	@BeforeMethod
	public void beforeMethod(){
		test = startTestCase(testCaseName, testDescription);
		test.assignCategory(category);
		test.assignAuthor(authors);
		invokeApp(browserName);
		enterById("username", "DemoSalesManager");
		enterById("password", "crmsfa");
		clickByClassName("decorativeSubmit");

	}
		
	@AfterSuite
	public void afterSuite(){
		endResult();
	}

	@AfterTest
	public void afterTest(){
		unloadObjects();
	}
	
	@AfterMethod
	public void afterMethod(){
		endTestcase();
		quitBrowser();
		
	}
	
	@DataProvider(name="fetchData")
	public  Object[][] getData(){
		return DataInputProvider.getSheet(dataSheetName);		
	}	
	
	
}






