package TestRunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		    features = "C:\\Users\\harishahi\\eclipseoxy\\eclipse-workspace\\CucumberMajorProject\\Features\\BasicCourse.features",
		    glue = {"co.qa.StepDefinition"},
		    tags = "@BasicCourse"
			)
public class Runner {

}
