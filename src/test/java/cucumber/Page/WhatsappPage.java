package cucumber.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WhatsappPage {
    private final String BUTTON_WA = "navmenu_navbtn_wa";
    private final String WA_INFO = "//*[@class='info']";

    private WebDriver driver;
    private WebDriverWait wait;

    public WhatsappPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(120));
    }

    public void goToWhatsappPage() {
        try {
            WebElement title = driver.findElement(By.xpath("//*[@class='head']/h4"));
            assert title.getText().equals("WA Connection");
        } catch (Exception e) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(By.id(BUTTON_WA)));
                WebElement element = driver.findElement(By.id(BUTTON_WA));
                element.click();
            } catch (Exception ignored) {}
        }
    }

    public void validateWhatsappNumberIsConnected(String[] textArray) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(WA_INFO)));
        WebElement number = driver.findElement(By.xpath(WA_INFO + "/p"));
        WebElement name = driver.findElement(By.xpath(WA_INFO + "/h4"));

        assert number.getText().contains(textArray[0]) : "actual: " + number.getText() + " expected: " + textArray[0];
        assert name.getText().equals(textArray[1]) : "actual: " + name.getText() + " expected: " + textArray[1];
    }
}
