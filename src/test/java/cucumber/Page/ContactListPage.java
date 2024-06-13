package cucumber.Page;

import cucumber.util.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class ContactListPage {
    private final String CONTACT_LIST_TABLE_ROW = "//*[contains(@class, 'contactItem ')]//*[@title='%s']/following-sibling::td";
    private final String CONTACT_LIST_TABLE_NAME = "[contains(@id,'btn_editname')]";
    private final String CONTACT_LIST_TABLE_BIRTH = "[contains(@class, 'birth')]";
    private final String CONTACT_LIST_TABLE_COUNTRY = "[contains(@class, 'country')][1]";
    private final String CONTACT_LIST_TABLE_PROVINCE = "[contains(@class, 'country')][2]";
    private final String CONTACT_LIST_TABLE_CITY = "[contains(@class, 'country')][3]";
    private final String CONTACT_LIST_TABLE_ADDRESS = "[contains(@class, 'country')][4]";
    private final String CONTACT_LIST_TABLE_POSTAL_CODE = "[contains(@class, 'country')][5]";
    private final String CONTACT_LIST_TABLE_TAG = "//*[@class='contactListTag']";
    private final String CONTACT_LIST_TABLE_NOTE = "[contains(@id,'btn_editnote')]";
    private final String CONTACT_LIST_TABLE_EDIT_BY_NO_WA = "//*[@id='contactlist_bodytable_btn_editonecontact_6285259027122']";

    private final String EDIT_CONTACT_POSTAL_CODE = "//*[@id='renderinputfield_client_textinput_postalcode']";
    private final String EDIT_CONTACT_ADDRESS = "//*[@id='renderinputfield_client_textinput_address']";
    private final String EDIT_CONTACT_CITY = "//*[@id='renderinputfield_client_selectautocomplete_city']";
    private final String EDIT_CONTACT_PROVINCE = "//*[@id='renderinputfield_client_selectautocomplete_province']";
    private final String EDIT_CONTACT_COUNTRY = "//*[@id='renderinputfield_client_select_country']";
    private final String EDIT_CONTACT_BIRTH = "//*[@class='ant-picker-clear']";
    private final String EDIT_CONTACT_NAME = "//*[@id='renderinputfield_client_textinput_contactname']";
    private final String EDIT_CONTACT_SAVE = "//*[@id='editcontactlist_popup_btn_save']";


    private WebDriver driver;
    private WebDriverWait wait;

    public ContactListPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
    }

    public void validateRedirectToContactList() {
        String url = "https://qonek-uat.web.app/contact/contact-list";
        wait.until(ExpectedConditions.urlToBe(url));

        String actualUrl = driver.getCurrentUrl();
        assert actualUrl.equals(url) : "actual: " + actualUrl + " expected: " + url;
    }

    public void validateContactListIsAutoUpdated(List<Map<String, String>> list) {
        for (Map<String, String> map : list) {
            String xpath = String.format(CONTACT_LIST_TABLE_ROW, map.get("Contact Number"));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath + CONTACT_LIST_TABLE_NAME)));
            WebElement name = driver.findElement(By.xpath(xpath + CONTACT_LIST_TABLE_NAME));
            assert name.getText().equals(map.get("Contact Name")) : "actual: " + name.getText() + " expected: " + map.get("Contact Name");

            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath + CONTACT_LIST_TABLE_BIRTH)));
            WebElement birth = driver.findElement(By.xpath(xpath + CONTACT_LIST_TABLE_BIRTH));
            assert birth.getText().equals(map.get("Birth")) : "actual: " + birth.getText() + " expected: " + map.get("Birth");

            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath + CONTACT_LIST_TABLE_COUNTRY)));
            WebElement country = driver.findElement(By.xpath(xpath + CONTACT_LIST_TABLE_COUNTRY));
            assert country.getText().equals(map.get("Country")) : "actual: " + country.getText() + " expected: " + map.get("Country");

            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath + CONTACT_LIST_TABLE_PROVINCE)));
            WebElement province = driver.findElement(By.xpath(xpath + CONTACT_LIST_TABLE_PROVINCE));
            assert province.getText().equals(map.get("Province")) : "actual: " + province.getText() + " expected: " + map.get("Province");

            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath + CONTACT_LIST_TABLE_CITY)));
            WebElement city = driver.findElement(By.xpath(xpath + CONTACT_LIST_TABLE_CITY));
            assert city.getText().equals(map.get("City")) : "actual: " + city.getText() + " expected: " + map.get("City");

            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath + CONTACT_LIST_TABLE_ADDRESS)));
            WebElement address = driver.findElement(By.xpath(xpath + CONTACT_LIST_TABLE_ADDRESS));
            assert address.getText().equals(map.get("Address")) : "actual: " + address.getText() + " expected: " + map.get("Address");

            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath + CONTACT_LIST_TABLE_POSTAL_CODE)));
            WebElement postalCode = driver.findElement(By.xpath(xpath + CONTACT_LIST_TABLE_POSTAL_CODE));
            assert postalCode.getText().equals(map.get("Postal Code")) : "actual: " + postalCode.getText() + " expected: " + map.get("Postal Code");

            WebElement tag;
            try {
                new WebDriverWait(this.driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath + CONTACT_LIST_TABLE_TAG)));
                tag = driver.findElement(By.xpath(xpath + CONTACT_LIST_TABLE_TAG));
            } catch (Exception e) {
                new WebDriverWait(this.driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath + "//*[@class='tags']")));
                tag = driver.findElement(By.xpath(xpath + "//*[@class='tags']"));
            }
            assert tag.getText().equals(map.get("Tag Contact")) : "actual: " + tag.getText() + " expected: " + map.get("Tag Contact");

            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath + CONTACT_LIST_TABLE_NOTE)));
            WebElement note = driver.findElement(By.xpath(xpath + CONTACT_LIST_TABLE_NOTE));
            assert map.get("Notes").contains(Utils.removeTrailingDots(note.getText())) : "actual: " + note.getText() + " expected: " + map.get("Notes");
        }
    }

    public void validateNotesIsHighlighted(String text) {
        String xpath = String.format(CONTACT_LIST_TABLE_ROW, text);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath + CONTACT_LIST_TABLE_NOTE)));
        WebElement element = driver.findElement(By.xpath(xpath + CONTACT_LIST_TABLE_NOTE));

        String elementColor = Color.fromString(element.getCssValue("color")).asRgba();
        assert elementColor.equals("rgba(101, 98, 223, 1)") : "actual: " + element.getCssValue("color") + " expected: rgba(101, 98, 223, 1)";
    }

    public void clickButtonRahmadhany() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CONTACT_LIST_TABLE_EDIT_BY_NO_WA)));
        WebElement element = driver.findElement(By.xpath(CONTACT_LIST_TABLE_EDIT_BY_NO_WA));
        element.click();
        new Actions(driver).pause(2000).perform();

        WebElement name = driver.findElement(By.xpath(EDIT_CONTACT_NAME));
        name.clear();
        name.sendKeys("Rahmadhany");
        new Actions(driver).pause(700).perform();

        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(EDIT_CONTACT_CITY)));
            WebElement city = driver.findElement(By.xpath(EDIT_CONTACT_CITY));
            city.clear();
            city.sendKeys(Keys.CONTROL, "a");
            city.sendKeys(Keys.DELETE);
            new Actions(driver).pause(700).perform();
        } catch (Exception ignored) {}

        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(EDIT_CONTACT_PROVINCE)));
            WebElement province = driver.findElement(By.xpath(EDIT_CONTACT_PROVINCE));
            province.clear();
            province.sendKeys(Keys.CONTROL, "a");
            province.sendKeys(Keys.DELETE);
            new Actions(driver).pause(700).perform();
        } catch (Exception ignored) {}

        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(EDIT_CONTACT_COUNTRY)));
            WebElement country = driver.findElement(By.xpath(EDIT_CONTACT_COUNTRY));
            country.clear();
            country.sendKeys(Keys.CONTROL, "a");
            country.sendKeys(Keys.DELETE);
            new Actions(driver).pause(700).perform();
        } catch (Exception ignored) {}

        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(EDIT_CONTACT_BIRTH)));
            WebElement birth = driver.findElement(By.xpath(EDIT_CONTACT_BIRTH));
            new Actions(driver)
                    .moveToElement(birth)
                    .click()
                    .pause(700).perform();
        } catch (Exception ignored) {}

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(EDIT_CONTACT_POSTAL_CODE)));
        WebElement postalCode = driver.findElement(By.xpath(EDIT_CONTACT_POSTAL_CODE));
        postalCode.clear();
        postalCode.sendKeys(Keys.CONTROL, "a");
        postalCode.sendKeys(Keys.DELETE);
        postalCode.clear();
        new Actions(driver).pause(700).perform();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(EDIT_CONTACT_ADDRESS)));
        WebElement address = driver.findElement(By.xpath(EDIT_CONTACT_ADDRESS));
        address.clear();
        address.sendKeys(Keys.CONTROL, "a");
        address.sendKeys(Keys.DELETE);
        address.clear();
        new Actions(driver).pause(700).perform();

        WebElement save = driver.findElement(By.xpath(EDIT_CONTACT_SAVE));
        save.click();
        new Actions(driver).pause(2000).perform();


    }
}
