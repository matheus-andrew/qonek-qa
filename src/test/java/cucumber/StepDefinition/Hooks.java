package cucumber.StepDefinition;

import cucumber.util.CreateDriver;
import cucumber.util.PropertiesLoader;
import cucumber.util.Utils;
import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;

import java.io.IOException;
import java.util.Properties;

public class Hooks {

    public WebDriver driver;
    public Scenario scenario;
    public long startTimeScenario;

    @Before
    public void openBrowser(Scenario scenario) throws IOException {
        this.scenario = scenario;
        Properties conf = PropertiesLoader.loadProperties();
        String instance = conf.getProperty("instance");

        CreateDriver.getInstance().setDriver(instance);
        driver = CreateDriver.getInstance().getDriver();
        driver.manage().window().maximize();

        startTimeScenario = System.currentTimeMillis();
    }

    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "Screenshot");
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
            }
        }

        long endTimeScenario = System.currentTimeMillis();
        long milliseconds = (endTimeScenario - startTimeScenario);
        scenario.attach("", "text/plain", "Duration : " + Utils.convertMillisToString(milliseconds));

        driver.quit();
    }

    @AfterStep
    public void screenshot(Scenario scenario){
        byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", scenario.getName());
    }
}
