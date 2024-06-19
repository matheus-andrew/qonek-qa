package cucumber.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class ChromeManager implements BrowserManager {
    @Override
    public WebDriver getDriver() {
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--ignore-certificate-errors");
//        options.addArguments("--incognito");
//        options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
//        options.addArguments("--start-maximized");
        options.addArguments("force-device-scale-factor=0.55");
        options.addArguments("high-dpi-support=0.55");

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", System.getProperty("user.dir") + "\\src\\test\\resources");
        options.setExperimentalOption("prefs", prefs);

        return new ChromeDriver(options);
    }
}
