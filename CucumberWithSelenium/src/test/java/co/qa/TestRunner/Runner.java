package co.qa.TestRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)				
@CucumberOptions(
		features="C:\\Users\\harishahi\\eclipseoxy\\eclipse-workspace\\CucumberWithSelenium\\Features\\MyTest.features",
		glue={"co.qa.stepDefinition"}
//		tags= "@MyTest"
		)

public class Runner {

}
