package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/Features/negativeTestWithScenarios.feature",
        glue = {"stepDefinitions"},
        tags = "@invalidBD",
        plugin = {"json:target/cucumber-reporting.json","html:cucumber-html-report.html"}
        /*
        tags:
        @invalidInputOnSelectVehiclePage
        @invalidInputOnRegistrationDatePage
        @invalidBD
         */

)
public class cukesRunner {
}
