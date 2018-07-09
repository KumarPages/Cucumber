package cucumber;

import java.util.List;

import cucumber.api.testng.CucumberFeatureWrapperImpl;
import cucumber.api.testng.TestNGCucumberRunner;
import cucumber.runtime.model.CucumberFeature;

public class RunCucumberTests {

	public static void runTests(Class clazz, String feature, String fileName,String[] data){
		System.out.println(clazz.getDeclaredMethods());
		UpdateCucumberExamples.replace(fileName,data);
		

		TestNGCucumberRunner runner = new TestNGCucumberRunner(clazz);
		List<CucumberFeature> alLFeatures = runner.getFeatures();
		for (CucumberFeature cucumberFeature : alLFeatures) {
			CucumberFeatureWrapperImpl imp = new CucumberFeatureWrapperImpl(cucumberFeature);
			if(imp.toString().equalsIgnoreCase(feature)) {
				runner.runCucumber(cucumberFeature);
			}
		}
		
	}
}