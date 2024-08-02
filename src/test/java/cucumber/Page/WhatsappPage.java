package cucumber.Page;

import cucumber.util.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WhatsappPage {
    private final String BUTTON_WA = "navmenu_navbtn_wa";
    private final String WA_INFO = "//*[@class='info']";
    private final String TITLE = "//*[@class='head']/h4";

    private WebDriver driver;
    private WebDriverWait wait;
    private int waitTimeForLoop = 300000;

    public WhatsappPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
    }

    public void goToWhatsappPage() {
        Utils.retryOperation(() -> {
            wait.until(ExpectedConditions.elementToBeClickable(By.id(BUTTON_WA)));
            WebElement element = driver.findElement(By.id(BUTTON_WA));
            element.click();

            WebElement title = driver.findElement(By.xpath(TITLE));
            assert title.getText().equals("WA Connection") : "actual: " + title.getText() + " expected: WA Connection";
        }, waitTimeForLoop);
    }

    public void validateWhatsappNumberIsConnected(String[] textArray) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(WA_INFO)));
        List<WebElement> numbers = driver.findElements(By.xpath(WA_INFO + "/p"));
        List<WebElement> names = driver.findElements(By.xpath(WA_INFO + "/h4"));

        assert numbers.stream().anyMatch(f -> f.getText().contains(textArray[0])) : "expected: " + textArray[0];
        assert names.stream().anyMatch(f -> f.getText().contains(textArray[1])) : "expected: " + textArray[1];
    }
}
