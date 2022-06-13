package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/Features/DifferentPathScenariTypes.feature",
        glue = {"stepDefinitions"},
        plugin = {"json:target/cucumber-reporting.json","html:cucumber-html-report.html"}


)
public class cukesRunner {
}
