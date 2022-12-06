package com.FXO_Shiftleft_BDD.automation.testRunner;

//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


//@RunWith(Cucumber.class)
@CucumberOptions(
		features={".//src/test/resources/Feature/mirkalPickupFlow.feature",
					".//src/test/resources/Feature/PickupFlow_CCPayment.feature"},
		
//		features=".//src/test/resources/Feature/PickupFlow_CCPayment.feature",
		glue="com.FXO_Shiftleft_BDD.automation.stepDefinations",
		monochrome=true,
		dryRun=false,
		plugin= {"pretty","html:target/HtmlReports.html"}
		)
public class RunTest extends AbstractTestNGCucumberTests {

}
