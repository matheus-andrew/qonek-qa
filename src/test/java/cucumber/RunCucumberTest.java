package cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber.html" , "json:target/cucumber-report/cucumber.json"},
        glue = {"cucumber.StepDefinition", "cucumber.Page"},
        features = "src/test/resources/cucumber/getTexting",
        tags = "@Feature"
)
public class RunCucumberTest {}
