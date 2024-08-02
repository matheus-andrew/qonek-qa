package cucumber.Page;

import cucumber.util.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginPage {
    private final String FIELD_EMAIL = "sign_in_text_input_email";
    private final String FIELD_PASSWORD = "sign_in_text_input_password";
    private final String BTN_SIGN_IN = "sign_in_button_sign_in";
    private final String WARN = "warn";

    private WebDriver driver;
    private WebDriverWait wait;
    private int waitTimeForLoop = 300000;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
    }

    public void inputEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FIELD_EMAIL)));
        WebElement element = driver.findElement(By.id(FIELD_EMAIL));

        element.sendKeys(email);
    }

    public void inputPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FIELD_PASSWORD)));
        WebElement element = driver.findElement(By.id(FIELD_PASSWORD));

        element.sendKeys(password);
    }

    public void clickSignIn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(BTN_SIGN_IN)));
        WebElement element = driver.findElement(By.id(BTN_SIGN_IN));

        element.click();
    }

    public void validateInHomePage() {
        Utils.retryOperation(() -> {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='NavigationMenu_logo']")));
        }, waitTimeForLoop);
    }

    public void validateLoginErrorMessage(String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(WARN)));
        WebElement element = driver.findElement(By.className(WARN));

        assert element.getText().equals(text) : "actual: " + element.getText() + " expected: " + text;
    }

    public void goToLoginPage(String url) {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        Utils.retryOperationWithCatch(() -> {
            driver.get(url);
        }, () -> {
            System.out.println("Page load timeout exceeded, attempting to stop loading and refresh...");
            stopPageLoading();
        }, waitTimeForLoop);

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(300));
    }

    private void stopPageLoading() {
        do {
            try {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.stop();");
            } catch (Exception e) {
                System.out.println("Failed to stop page loading: " + e.getMessage());
            }
        } while(!verifyPageStoppedLoading());
    }

    private boolean verifyPageStoppedLoading() {
        try {
            // Wait until the page is fully loaded or stopped
            wait.until((ExpectedCondition<Boolean>) wd ->
                    ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
            System.out.println("Page has stopped loading.");
            return true;
        } catch (Exception e) {
            System.out.println("Page may still be loading: " + e.getMessage());
            return false;
        }
    }
}
