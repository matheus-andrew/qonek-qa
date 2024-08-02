package cucumber.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class SettingPage {
    private final String SIDEBAR_CHAT_SETTING = "sidebarsetting_btn_chatsetting";
    private final String CHAT_SETTING_PENDING_EXPIRED_TIME = "//*[@class='ChatSettingPage_sessionLeft']//*[@class='input']";
    private final String CHAT_SETTING_BTN_EDIT = "//*[@id='chatsetting_page_btn_editchatsession']";
    private final String CHAT_SETTING_BTN_APPLYEDIT = "//*[@id='chatsetting_page_btn_applyedit']";

    private WebDriver driver;
    private WebDriverWait wait;

    public SettingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
    }

    public void validateRedirectToAppInformation() {
        String url = "https://qonek-uat.web.app/setting/app-information";
        wait.until(ExpectedConditions.urlToBe(url));

        String actualUrl = driver.getCurrentUrl();
        assert actualUrl.equals(url) : "actual: " + actualUrl + " expected: " + url;
    }

    public void validateRedirectToChatSetting() {
        String url = "https://qonek-uat.web.app/setting/chat";
        wait.until(ExpectedConditions.urlToBe(url));

        String actualUrl = driver.getCurrentUrl();
        assert actualUrl.equals(url) : "actual: " + actualUrl + " expected: " + url;
    }

    public void clickMenuChatSetting() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id(SIDEBAR_CHAT_SETTING)));
        WebElement element = driver.findElement(By.id(SIDEBAR_CHAT_SETTING));
        element.click();
    }

    public void clickMenuChatSettingButtonEdit() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CHAT_SETTING_BTN_EDIT)));
        WebElement element = driver.findElement(By.xpath(CHAT_SETTING_BTN_EDIT));
        element.click();
    }

    public void clickMenuChatSettingButtonApplyEdit() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CHAT_SETTING_BTN_APPLYEDIT)));
        WebElement element = driver.findElement(By.xpath(CHAT_SETTING_BTN_APPLYEDIT));
        element.click();
        new Actions(driver).pause(2000).perform();
    }

    public void changePendingAndExpiredTime(int pending, int expired) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CHAT_SETTING_PENDING_EXPIRED_TIME)));
        List<WebElement> elements = driver.findElements(By.xpath(CHAT_SETTING_PENDING_EXPIRED_TIME));

        String result = elements.stream().map(WebElement::getText).collect(Collectors.joining(", "));

        if (result.equals(String.format("0 Hours, %s Min, 0 Hours, %s Min", pending, expired))) {
            return;
        }

        clickMenuChatSettingButtonEdit();
        new Actions(driver).pause(1000).perform();

        List<WebElement> newElements = driver.findElements(By.xpath(CHAT_SETTING_PENDING_EXPIRED_TIME + "/input"));

        int[] timer = {0, pending, 0, expired};
        for (int i = 0; i < 4; i++) {
            new Actions(driver)
                    .moveToElement(newElements.get(i))
                    .click()
                    .keyDown(Keys.CONTROL)
                    .sendKeys("a")
                    .keyUp(Keys.CONTROL)
                    .pause(500)
                    .sendKeys(String.valueOf(timer[i]))
                    .build().perform();
        }

        clickMenuChatSettingButtonApplyEdit();
    }

    public void changePendingTime(int hour, int minute) {
        List<WebElement> elements = driver.findElements(By.xpath(CHAT_SETTING_PENDING_EXPIRED_TIME + "/input"));

        int[] timer = {hour, minute};
        for (int i = 0; i < 2; i++) {
            new Actions(driver)
                    .moveToElement(elements.get(i))
                    .click()
                    .keyDown(Keys.CONTROL)
                    .sendKeys("a")
                    .keyUp(Keys.CONTROL)
                    .pause(500)
                    .sendKeys(String.valueOf(timer[i]))
                    .build().perform();
        }
    }

    public void changeExpiredTime(int hour, int minute) {
        List<WebElement> elements = driver.findElements(By.xpath(CHAT_SETTING_PENDING_EXPIRED_TIME + "/input"));

        int[] timer = {hour, minute};
        for (int i = 2; i < 4; i++) {
            new Actions(driver)
                    .moveToElement(elements.get(i))
                    .click()
                    .keyDown(Keys.CONTROL)
                    .sendKeys("a")
                    .keyUp(Keys.CONTROL)
                    .pause(500)
                    .sendKeys(String.valueOf(timer[i - 2]))
                    .build().perform();
        }
    }

    public void validateChatSessionUpdated(String pending, String expired) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CHAT_SETTING_PENDING_EXPIRED_TIME)));
        List<WebElement> elements = driver.findElements(By.xpath(CHAT_SETTING_PENDING_EXPIRED_TIME));

        String result = elements.stream().map(WebElement::getText).collect(Collectors.joining(", "));

        String pending1 = pending.replace(" &", ",");
        String expired1 = expired.replace(" &", ",");
        String expected = pending1 + ", " + expired1;
        assert result.equals(expected) : "actual: " + result + " expected: " + expected;
    }
}
