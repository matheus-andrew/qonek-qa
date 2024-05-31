package cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber" , "json:target/cucumber.json"},
        glue = {"cucumber.StepDefinition", "cucumber.Page"},
        features = "src/test/resources/cucumber/parallel",
        tags = ""
)
public class RunCucumberIT {}
