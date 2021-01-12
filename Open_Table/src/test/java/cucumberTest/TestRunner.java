package cucumberTest;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//import org.junit.runner.RunWith;

//import cucumber.api.CucumberOptions;
//import cucumber.api.junit.Cucumber;

/*@RunWith(Cucumber.class)
@CucumberOptions(
features = "features/demo_recipe.feature"  
,glue={"stepDefinitions"}
,plugin= {"html:reports"}
)*/

@CucumberOptions(
features = "features/details_of_restaurant.feature"
,glue={"stepDefinitions"}
,plugin = {"html:cucumber_reports","junit:cucumber_reports/sucumber.xml"}
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
