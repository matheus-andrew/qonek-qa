package cucumber.Page;

import cucumber.util.Utils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Map;

public class ContactListPage {
    private final String CONTACT_LIST_TABLE_ROW = "//*[contains(@class, 'contactItem ')]//*[@title='%s']/following-sibling::td";
    private final String CONTACT_LIST_TABLE_NAME = "[contains(@id,'btn_editname')]";
    private final String CONTACT_LIST_TABLE_NAME_EDIT = "//*[contains(@id,'btn_editname') and contains(@title,'%s')]";
    private final String CONTACT_LIST_TABLE_BIRTH = "[contains(@class, 'birth')]";
    private final String CONTACT_LIST_TABLE_COUNTRY = "[contains(@class, 'country')][1]";
    private final String CONTACT_LIST_TABLE_PROVINCE = "[contains(@class, 'country')][2]";
    private final String CONTACT_LIST_TABLE_CITY = "[contains(@class, 'country')][3]";
    private final String CONTACT_LIST_TABLE_ADDRESS = "[contains(@class, 'country')][4]";
    private final String CONTACT_LIST_TABLE_ADDRESS_EDIT = "//*[contains(@name, 'address-%s')]";
    private final String CONTACT_LIST_TABLE_POSTAL_CODE = "[contains(@class, 'country')][5]";
    private final String CONTACT_LIST_TABLE_POSTAL_CODE_EDIT = "//*[contains(@name, 'postalCode-%s')]";
    private final String CONTACT_LIST_TABLE_TAG = "//*[@class='contactListTag']";
    private final String CONTACT_LIST_TABLE_NOTE = "[contains(@id,'btn_editnote')]";
    private final String CONTACT_LIST_TABLE_NOTE_EDIT = "//*[contains(@name, 'note-%s')]";
    private final String CONTACT_LIST_TABLE_EDIT_BY_NO_WA = "//*[contains(@id,'contactlist_bodytable_btn_editonecontact') and contains(@id,'%s')]";
    private final String CONTACT_LIST_TABLE_CONTACT_HISTORY_BY_NO_WA = "//*[contains(@id,'ontactlist_bodytable_btn_gotodetailchatroom') and contains(@id,'%s')]";
    private final String CONTACT_LIST_TABLE_DELETE_BY_NO_WA = "//*[contains(@id,'contactlist_bodytable_btn_deleteonecontact') and contains(@id,'%s')]";
    private final String CONTACT_LIST_BUTTON_EDIT_BULK = "//*[@id='contactlist_btn_editbulk']";
    private final String CONTACT_LIST_EDIT_BULK_POPUP = "//*[@class='ConfirmMultiEdit']";
    private final String CONTACT_LIST_EDIT_BULK_POPUP_EDIT_COUNTRY = "//*[@id='geocustomfield_popup_select_country_EditBulkContactgeo']";
    private final String CONTACT_LIST_EDIT_BULK_POPUP_EDIT_PROVINCE = "//*[@id='geocustomfield_popup_select_state_EditBulkContactgeo']";
    private final String CONTACT_LIST_EDIT_BULK_POPUP_EDIT_TAG = "//input[contains(@id,'react-select')]";
    private final String CONTACT_LIST_EDIT_BULK_POPUP_EDIT_TAG_MENU = "//*[@id='usemultiedit_popup_btn_openmenuedit_EditBulkContacttag']";
    private final String CONTACT_LIST_EDIT_BULK_POPUP_EDIT_TAG_MENU_ADD = "//*[@id='usemultiedit_popup_dropdown_menuadd_EditBulkContacttag']";
    private final String CONTACT_LIST_EDIT_BULK_POPUP_BUTTON_SAVE = "//*[@id='confirmeditmulti_popup_btn_save']";

    private final String CONTACT_HISTORY_PAGE = "//*[@class='ContactHistory']";
    private final String CONTACT_HISTORY_BUTTON_EXPORT = "//*[@id='contactlistdetail_button_exporthistory']";
    private final String CONTACT_HISTORY_CONFIRMATION_EXPORT = "//*[@id='confirmexportcontactlog_popup_btn_confirmexporthistory']";
    private final String CONTACT_HISTORY_BUTTON_FILTER_ACTIVITY = "//*[@id='usecontactlistdetail_popup_btn_filter_activity']/*[local-name()='svg']/*[local-name()='path']";
    private final String CONTACT_HISTORY_BUTTON_FILTER_SESSION_ID = "//*[@id='usecontactlistdetail_popup_btn_filter_session']/*[local-name()='svg']/*[local-name()='path']";
    private final String CONTACT_HISTORY_BUTTON_EDIT_CONTACT = "//*[@id='contactlistdetail_btn_editcontact']";
    private final String CONTACT_HISTORY_EDIT_CONTACT_NAME = "//*[@id='contactlistdetail_textinput_editname' and @type='text']";
    private final String CONTACT_HISTORY_EDIT_ADDRESS = "//*[@id='contactlistdetail_textinput_address']";
    private final String CONTACT_HISTORY_EDIT_BUTTON_SAVE = "//*[@id='contactlistdetail_btn_save']";
    private final String CONTACT_HISTORY_INPUT_SEARCH = "//*[@id='contactlistdetail_textinput_searchcontact']";
    private final String CONTACT_HISTORY_BUTTON_X = "//*[@id='contactlistdetail_page_btn_3']/*[local-name()='path']";

    private final String POPUP_ADD_EDIT_CONTACT = "//*[@class='EditContactListPopup_head']";
    private final String POPUP_ADD_EDIT_CONTACT_NUMBER_WARNING = "//*[@class='warningChangeNumber']";
    private final String EDIT_CONTACT_POSTAL_CODE = "//*[@id='renderinputfield_client_textinput_postalcode']";
    private final String EDIT_CONTACT_ADDRESS = "//*[@id='renderinputfield_client_textinput_address']";
    private final String EDIT_CONTACT_CITY = "//*[@id='renderinputfield_client_selectautocomplete_city']";
    private final String EDIT_CONTACT_PROVINCE = "//*[@id='renderinputfield_client_selectautocomplete_province']";
    private final String EDIT_CONTACT_COUNTRY = "//*[@id='renderinputfield_client_select_country']";
    private final String EDIT_CONTACT_BIRTH = "//*[@class='ant-picker-clear']";
    private final String EDIT_CONTACT_NAME = "//*[@id='renderinputfield_client_textinput_contactname']";
    private final String EDIT_CONTACT_NUMBER = "//*[@id='renderinputfield_client_textinput_contactnumber']";
    private final String EDIT_CONTACT_SAVE = "//*[@id='editcontactlist_popup_btn_save']";

    private final String BUTTON_NEW_CONTACT = "//*[@id='contactlist_btn_newcontact']";
    private final String BUTTON_ADD_BULK = "//*[@id='contactlist_btn_insertchat']";
    private final String BUTTON_ADD_BULK_DROPDOWN_IMPORT_FILE = "//*[@id='contactlist_btn_importfile']";
    private final String BUTTON_ADD_BULK_DROPDOWN_SYNC_WA = "//*[@id='contactlist_btn_syncfromwa']";
    private final String BUTTON_EXPORT_ALL = "//*[@id='contactlist_btn_exportall']";
    private final String BUTTON_INPUT_SEARCH = "//*[@id='contactlist_textinput_searchcontact']";
    private final String BUTTON_SEARCH = "//*[@id='contactlist_btn_search']";
    private final String BUTTON_CLOSE_SEARCH = "//*[@id='contactlist_btn_closesearch']/*[local-name()='path']";
    private final String BUTTON_FILTER_CONTACT_NAME = "//*[@id='broadcastlist_popup_btn_filter_name']/*[local-name()='svg']/*[local-name()='path']";
    private final String BUTTON_FILTER_CONTACT_NAME_SORT_ASC = "//*[@id='usecontactlist_popup_btn_menusort_name_0']";
    private final String BUTTON_FILTER_CONTACT_NAME_SORT_DESC = "//*[@id='usecontactlist_popup_btn_menusort_name_1']";
    private final String BUTTON_FILTER_CONTACT_NAME_SET_FILTER = "//*[@class='btn-apply']";
    private final String BUTTON_APPLY_FILTER = "//*[@class='apply_filter']";
    private final String BUTTON_REMOVE_FILTER = "//*[@id='contactlist_btn_removefilter']";
    private final String BUTTON_EXPAND_FILTER_NAME = "//*[@id='usecontactlist_popup_btn_filtercondition_name']";
    private final String BUTTON_EXPAND_FILTER_ACTIVITY = "//*[@id='usecontactlistdetail_popup_btn_filtercondition_activity']";
    private final String BUTTON_EXPAND_FILTER_VALUE_SESSION_ID = "//*[@id='usecontactlistdetail_popup_button_filtervalue_session']";
    private final String BUTTON_NEXT_PAGE = "//*[@id='contactlist_btn_nextpagination']";
    private final String BUTTON_PREV_PAGE = "//*[@id='contactlist_btn_prevpagination']";
    private final String SEARCH_PAGINATION_NUMBER = "//*[@id='contactlist_textinput_searchpagination']";
    private final String SEARCH_PAGINATION_DATA_VIEW = "//*[@id='contactlist_btn_dataviewlimit']";
    private final String BUTTON_DELETE_BULK = "//*[@id='contactlist_btn_deletebulk']";
    private final String POPUP_DELETE_BULK = "//*[@class='ConfirmMultiDeteleCL']";
    private final String POPUP_DELETE_BULK_BUTTON_YES = "//*[@id='confirmdeletemulti_popup_btn_deletemulticontact']";

    private final String POPUP_EXPORT_ALL = "//*[@class='ConfirmExport']";
    private final String POPUP_EXPORT_ALL_BUTTON_YES = "//*[@id='confirmexport_popup_btn_exporttoexcel']";

    private final String POPUP_IMPORT_FILE_INPUT_EXCEL = "//input[@name='file']";
    private final String POPUP_IMPORT_FILE_BUTTON_SUBMIT = "//*[@id='addcontactlist_popup_btn_submit']";
    private final String POPUP_IMPORT_FILE_OVERWRITE_DATA = "//*[@class='AddContactList_head']/h3";
    private final String POPUP_IMPORT_FILE_BUTTON_OVERWRITE = "//*[@id='addcontactlist_popup_btn_overwrite']";
    private final String POPUP_IMPORT_FILE_WARN_DATA = "//*[@class='big_data_warn']/p";
    private final String POPUP_IMPORT_FILE_SKIP_OR_OVERWRITE = "//*[@class='ContactOverwrite']";


    private final String POPUP_SYNC_WA_SELECT_WA = "//*[@id='chatbody_chattabs_select_username']";
    private final String POPUP_SYNC_WA_SELECT_WA_OPTION = "//li[@id='chatbody_chattabs_select_username-option-0']";
    private final String POPUP_SYNC_WA_BUTTON_NEXT = "//*[@id='addcontactlistwa_popup_btn_next']";
    private final String POPUP_SYNC_WA_STEP_2 = "//*[@class='AddContactListWa_bodyStepTable']";
    private final String POPUP_SYNC_WA_CHECKBOX = "//*[contains(@id,'contactlistwapopup_tablebody_checkbox_checkonedata_')]";
    private final String POPUP_SYNC_WA_BUTTON_SUBMIT = "//*[@id='addcontactlistwa_popup_btn_next']";
    private final String POPUP_SYNC_WA_OVERWRITE = "//*[@class='ContactOverwrite']";
    private final String POPUP_SYNC_WA_BUTTON_SKIP = "//*[@id='addcontactlist_popup_btn_skip']";

    private final String POPUP_ADD_NEW_CONTACT = "//*[@class='AddOneContactList_head']";
    private final String POPUP_ADD_BUTTON_SAVE = "//*[@id='addonecontactlist_popup_btn_save']";

    private WebDriver driver;
    private WebDriverWait wait;

    public ContactListPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(120));
    }

    public void validateRedirectToContactList() {
        String url = "https://qonek-uat.web.app/contact/contact-list";
        wait.until(ExpectedConditions.urlToBe(url));

        String actualUrl = driver.getCurrentUrl();
        assert actualUrl.equals(url) : "actual: " + actualUrl + " expected: " + url;

        new Actions(driver).pause(500).perform();
    }

    public void validateContactListIsAutoUpdated(List<Map<String, String>> list) {
        for (Map<String, String> map : list) {
            map = Utils.replaceNullValuesWithEmptyStrings(map);

            String xpath = String.format(CONTACT_LIST_TABLE_ROW, map.get("Contact Number"));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath + CONTACT_LIST_TABLE_NAME)));
            WebElement name = driver.findElement(By.xpath(xpath + CONTACT_LIST_TABLE_NAME));
            assert name.getText().equals(map.get("Contact Name")) : "1 actual: " + name.getText() + " expected: " + map.get("Contact Name");

            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath + CONTACT_LIST_TABLE_BIRTH)));
            WebElement birth = driver.findElement(By.xpath(xpath + CONTACT_LIST_TABLE_BIRTH));

            assert birth.getText().equals(map.get("Birth")) : "2 actual: " + birth.getText() + " expected: " + map.get("Birth");

            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath + CONTACT_LIST_TABLE_COUNTRY)));
            WebElement country = driver.findElement(By.xpath(xpath + CONTACT_LIST_TABLE_COUNTRY));
            assert country.getText().equals(map.get("Country")) : "3 actual: " + country.getText() + " expected: " + map.get("Country");

            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath + CONTACT_LIST_TABLE_PROVINCE)));
            WebElement province = driver.findElement(By.xpath(xpath + CONTACT_LIST_TABLE_PROVINCE));
            assert province.getText().equals(map.get("Province")) : "4 actual: " + province.getText() + " expected: " + map.get("Province");

            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath + CONTACT_LIST_TABLE_CITY)));
            WebElement city = driver.findElement(By.xpath(xpath + CONTACT_LIST_TABLE_CITY));
            assert city.getText().equals(map.get("City")) : "5 actual: " + city.getText() + " expected: " + map.get("City");

            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath + CONTACT_LIST_TABLE_ADDRESS)));
            WebElement address = driver.findElement(By.xpath(xpath + CONTACT_LIST_TABLE_ADDRESS));
            assert address.getText().equals(map.get("Address")) : "6 actual: " + address.getText() + " expected: " + map.get("Address");

            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath + CONTACT_LIST_TABLE_POSTAL_CODE)));
            WebElement postalCode = driver.findElement(By.xpath(xpath + CONTACT_LIST_TABLE_POSTAL_CODE));
            assert postalCode.getText().equals(map.get("Postal Code")) : "7 actual: " + postalCode.getText() + " expected: " + map.get("Postal Code");

            String[] tagArray = map.get("Tag Contact").split(";");

            List<WebElement> tags;
            try {
                new WebDriverWait(this.driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath + CONTACT_LIST_TABLE_TAG)));
                tags = driver.findElements(By.xpath(xpath + CONTACT_LIST_TABLE_TAG));
            } catch (Exception e) {
                new WebDriverWait(this.driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath + "//*[@class='tags']")));
                tags = driver.findElements(By.xpath(xpath + "//*[@class='tags']"));
            }
            for (String tag : tagArray) {
                assert tags.stream().anyMatch(f -> f.getText().equals(tag)) : "8 actual: " + tags + " expected: " + tag;
            }

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

    public void revertContactRahmadhany() {
        String wa = String.format(CONTACT_LIST_TABLE_EDIT_BY_NO_WA, "6285259027122");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(wa)));
        WebElement element = driver.findElement(By.xpath(wa));
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
        } catch (Exception ignored) {
        }

        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(EDIT_CONTACT_PROVINCE)));
            WebElement province = driver.findElement(By.xpath(EDIT_CONTACT_PROVINCE));
            province.clear();
            province.sendKeys(Keys.CONTROL, "a");
            province.sendKeys(Keys.DELETE);
            new Actions(driver).pause(700).perform();
        } catch (Exception ignored) {
        }

        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(EDIT_CONTACT_COUNTRY)));
            WebElement country = driver.findElement(By.xpath(EDIT_CONTACT_COUNTRY));
            country.clear();
            country.sendKeys(Keys.CONTROL, "a");
            country.sendKeys(Keys.DELETE);
            new Actions(driver).pause(700).perform();
        } catch (Exception ignored) {
        }

        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(EDIT_CONTACT_BIRTH)));
            WebElement birth = driver.findElement(By.xpath(EDIT_CONTACT_BIRTH));
            new Actions(driver)
                    .moveToElement(birth)
                    .click()
                    .pause(700).perform();
        } catch (Exception ignored) {
        }

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

    public void clickButtonNewContact() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BUTTON_NEW_CONTACT)));
        WebElement element = driver.findElement(By.xpath(BUTTON_NEW_CONTACT));
        element.click();
        new Actions(driver).pause(1000).perform();
    }

    public void validateShowPopUpAddNewContact() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(POPUP_ADD_NEW_CONTACT)));
    }

    public void validateButtonSaveWillBeGreyOut() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(POPUP_ADD_BUTTON_SAVE)));
        WebElement element = driver.findElement(By.xpath(POPUP_ADD_BUTTON_SAVE));
        assert !element.isEnabled() : "actual: " + element.isEnabled() + " expected: " + false;
    }

    public void clickAndTypeOnFieldContactNumber(String text) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(EDIT_CONTACT_NUMBER)));
        WebElement name = driver.findElement(By.xpath(EDIT_CONTACT_NUMBER));
        name.clear();
        name.sendKeys(Keys.CONTROL, "a");
        name.sendKeys(Keys.DELETE);
        name.sendKeys(text);
        new Actions(driver).pause(700).perform();
    }

    public void clickAndTypeOnFieldContactName(String text) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(EDIT_CONTACT_NAME)));
        WebElement name = driver.findElement(By.xpath(EDIT_CONTACT_NAME));
        name.clear();
        name.sendKeys(text);
        new Actions(driver).pause(700).perform();
    }

    public void clickButtonSave() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(POPUP_ADD_BUTTON_SAVE)));
        WebElement save = driver.findElement(By.xpath(POPUP_ADD_BUTTON_SAVE));
        save.click();
        new Actions(driver).pause(2000).perform();
    }

    public void clickButtonEditOnContact(String text) {
        String wa = String.format(CONTACT_LIST_TABLE_EDIT_BY_NO_WA, text);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(wa)));
        WebElement element = driver.findElement(By.xpath(wa));
        element.click();
        new Actions(driver).pause(2000).perform();
    }

    public void clickButtonDeleteOnContact(String text) {
        String wa = String.format(CONTACT_LIST_TABLE_DELETE_BY_NO_WA, text);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(wa)));
        WebElement element = driver.findElement(By.xpath(wa));
        element.click();
        new Actions(driver).pause(2000).perform();
    }

    public void validateShowPopUpEditContact() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(POPUP_ADD_EDIT_CONTACT)));
    }

    public void clickFieldContactNumber() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(EDIT_CONTACT_NUMBER)));
        WebElement element = driver.findElement(By.xpath(EDIT_CONTACT_NUMBER));
        element.click();
    }

    public void validateShowWarningChangedContactNumber() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(POPUP_ADD_EDIT_CONTACT_NUMBER_WARNING)));
    }

    public void clickButtonYesOnWarningChangedContactNumber() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(POPUP_ADD_EDIT_CONTACT_NUMBER_WARNING + "//button[2]")));
        WebElement element = driver.findElement(By.xpath(POPUP_ADD_EDIT_CONTACT_NUMBER_WARNING + "//button[2]"));
        element.click();
        new Actions(driver).pause(500).perform();
    }

    public void clickButtonSaveOnEditContact() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(EDIT_CONTACT_SAVE)));
        WebElement element = driver.findElement(By.xpath(EDIT_CONTACT_SAVE));
        element.click();
        new Actions(driver).pause(500).perform();
    }

    public void clickAndChangedNameInto(String from, String to) {
        String xpath = String.format(CONTACT_LIST_TABLE_NAME_EDIT, from.toLowerCase());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        WebElement element = driver.findElement(By.xpath(xpath));
        element.click();

        new Actions(driver)
                .scrollToElement(element)
                .moveToElement(element)
                .click()
                .pause(500)
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE)
                .pause(500)
                .sendKeys(to)
                .pause(1000)
                .build().perform();
    }

    public void clickContactAndChangedAddress(String contact, String text) {
        String x = String.format(CONTACT_LIST_TABLE_ROW, contact);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(x + CONTACT_LIST_TABLE_ADDRESS)));
        WebElement e = driver.findElement(By.xpath(x + CONTACT_LIST_TABLE_ADDRESS));
        new Actions(driver)
                .scrollToElement(e)
                .moveToElement(e)
                .click()
                .build().perform();

        String xpath = String.format(CONTACT_LIST_TABLE_ADDRESS_EDIT, contact);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        WebElement element = driver.findElement(By.xpath(xpath));
        element.click();

        new Actions(driver)
                .scrollToElement(element)
                .moveToElement(element)
                .click()
                .pause(500)
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE)
                .pause(500)
                .sendKeys(text)
                .pause(1000)
                .build().perform();
    }

    public void clickContactAndChangedPostalCode(String contact, String text) {
        String x = String.format(CONTACT_LIST_TABLE_ROW, contact);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(x + CONTACT_LIST_TABLE_POSTAL_CODE)));
        WebElement e = driver.findElement(By.xpath(x + CONTACT_LIST_TABLE_POSTAL_CODE));
        new Actions(driver)
                .scrollToElement(e)
                .moveToElement(e)
                .click()
                .pause(500)
                .build().perform();

        String xpath = String.format(CONTACT_LIST_TABLE_POSTAL_CODE_EDIT, contact);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        WebElement element = driver.findElement(By.xpath(xpath));

        new Actions(driver)
                .scrollToElement(element)
                .moveToElement(element)
                .click()
                .pause(500)
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE)
                .pause(500)
                .sendKeys(text)
                .pause(1000)
                .build().perform();
    }

    public void clickContactAndChangedNotes(String contact, String text) {
        String x = String.format(CONTACT_LIST_TABLE_ROW, contact);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(x + CONTACT_LIST_TABLE_NOTE)));
        WebElement e = driver.findElement(By.xpath(x + CONTACT_LIST_TABLE_NOTE));
        new Actions(driver)
                .scrollToElement(e)
                .moveToElement(e)
                .click()
                .pause(500)
                .build().perform();

        String xpath = String.format(CONTACT_LIST_TABLE_NOTE_EDIT, contact);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        WebElement element = driver.findElement(By.xpath(xpath));

        new Actions(driver)
                .scrollToElement(element)
                .moveToElement(element)
                .click()
                .pause(500)
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE)
                .pause(500)
                .sendKeys(text)
                .pause(1000)
                .build().perform();
    }

    public void clickButtonAddBulk() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BUTTON_ADD_BULK)));
        WebElement element = driver.findElement(By.xpath(BUTTON_ADD_BULK));
        element.click();
    }

    public void chooseImportFileWhenAddBulk() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BUTTON_ADD_BULK_DROPDOWN_IMPORT_FILE)));
        WebElement element = driver.findElement(By.xpath(BUTTON_ADD_BULK_DROPDOWN_IMPORT_FILE));
        element.click();
    }

    public void uploadExcelTemplateIntoPopUpImportFile() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(POPUP_IMPORT_FILE_INPUT_EXCEL)));
        WebElement element = driver.findElement(By.xpath(POPUP_IMPORT_FILE_INPUT_EXCEL));

        File file = new File(
                "src" + File.separator + "test" + File.separator +
                        "resources" + File.separator + "TemplateMySalesContact.xlsx");
        element.sendKeys(file.getAbsolutePath());

        new Actions(driver).pause(1000).perform();
    }

    public void uploadExcelTemplateOverwriteIntoPopUpImportFile() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(POPUP_IMPORT_FILE_INPUT_EXCEL)));
        WebElement element = driver.findElement(By.xpath(POPUP_IMPORT_FILE_INPUT_EXCEL));

        File file = new File(
                "src" + File.separator + "test" + File.separator +
                        "resources" + File.separator + "TemplateMySalesContactOverwrite.xlsx");
        element.sendKeys(file.getAbsolutePath());

        new Actions(driver).pause(1000).perform();
    }

    public void clickButtonSubmit() {
        try {
            new WebDriverWait(this.driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(By.xpath(POPUP_IMPORT_FILE_BUTTON_SUBMIT)));
            WebElement element = driver.findElement(By.xpath(POPUP_IMPORT_FILE_BUTTON_SUBMIT));
            element.click();
        } catch (Exception ignored) {
            new WebDriverWait(this.driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(By.xpath(POPUP_SYNC_WA_BUTTON_SUBMIT)));
            WebElement element = driver.findElement(By.xpath(POPUP_SYNC_WA_BUTTON_SUBMIT));
            element.click();
        }

        new Actions(driver).pause(10000).perform();
    }

    public void chooseSyncFromWhatsAppWhenAddBulk() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BUTTON_ADD_BULK_DROPDOWN_SYNC_WA)));
        WebElement element = driver.findElement(By.xpath(BUTTON_ADD_BULK_DROPDOWN_SYNC_WA));
        element.click();
    }

    public void clickInputFieldChooseWhatsAppNumber() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(POPUP_SYNC_WA_SELECT_WA)));
        WebElement element = driver.findElement(By.xpath(POPUP_SYNC_WA_SELECT_WA));
        element.click();
    }

    public void chooseWhatsappNumber(String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(POPUP_SYNC_WA_SELECT_WA_OPTION)));
        WebElement element = driver.findElement(By.xpath(POPUP_SYNC_WA_SELECT_WA_OPTION));
        element.click();

        clickInputFieldChooseWhatsAppNumber();
    }

    public void clickButtonNext() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(POPUP_SYNC_WA_BUTTON_NEXT)));
        WebElement element = driver.findElement(By.xpath(POPUP_SYNC_WA_BUTTON_NEXT));
        element.click();

        new Actions(driver).pause(10000).perform();
    }

    public void validatePopUpWhatsAppSyncWillContinueToSecondStep() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(POPUP_SYNC_WA_STEP_2)));
    }

    public void checkFirstContactWantedToBeAdded() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(POPUP_SYNC_WA_CHECKBOX)));
        List<WebElement> elements = driver.findElements(By.xpath(POPUP_SYNC_WA_CHECKBOX));
        elements.get(0).click();
    }

    public void validateChosenContactWillBeAddedToContactListTable(String text) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format("//*[contains(@class, 'contactItem ')]//*[@title='%s']", text))));

        String xpath = String.format(CONTACT_LIST_TABLE_ROW, text);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath + CONTACT_LIST_TABLE_NAME)));
    }


    public void validateShowPopUpOverwriteData() {
        try {
            new WebDriverWait(this.driver, Duration.ofSeconds(3)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(POPUP_IMPORT_FILE_OVERWRITE_DATA)));
            WebElement element = driver.findElement(By.xpath(POPUP_IMPORT_FILE_OVERWRITE_DATA));
            assert element.getText().equals("Overwrite Data") : "actual: " + element.getText() + " expected: Overwrite Data";
        } catch (Exception ignored) {
            new WebDriverWait(this.driver, Duration.ofSeconds(3)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(POPUP_SYNC_WA_OVERWRITE)));
        }

    }

    public void clickButtonYesOverwrite() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(POPUP_IMPORT_FILE_BUTTON_OVERWRITE)));
        WebElement element = driver.findElement(By.xpath(POPUP_IMPORT_FILE_BUTTON_OVERWRITE));
        element.click();

        new Actions(driver).pause(2000).perform();
    }

    public void clickButtonSkip() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(POPUP_SYNC_WA_BUTTON_SKIP)));
        WebElement element = driver.findElement(By.xpath(POPUP_SYNC_WA_BUTTON_SKIP));
        element.click();

        new Actions(driver).pause(2000).perform();
    }

    public void clickButtonExportAll() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BUTTON_EXPORT_ALL)));
        WebElement element = driver.findElement(By.xpath(BUTTON_EXPORT_ALL));
        element.click();
    }

    public void validateShowPopUpExportAllConfirmation() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(POPUP_EXPORT_ALL)));
    }

    public void clickButtonYesImSureOnExportAllConfirmation() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(POPUP_EXPORT_ALL_BUTTON_YES)));
        WebElement element = driver.findElement(By.xpath(POPUP_EXPORT_ALL_BUTTON_YES));
        element.click();

        new Actions(driver).pause(1000).perform();
    }

    public void validateContactListWillBeExportedToExcelFormat() {
        assert Utils.verifyDownloadedFile("contact-list") : "File is not downloaded";
        new Actions(driver).pause(1000).perform();
        assert Utils.deleteDownloadedFile("contact-list") : "Failed to delete file";
    }

    public void clickAndTypeOnFieldInputSearch(String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BUTTON_INPUT_SEARCH)));
        WebElement element = driver.findElement(By.xpath(BUTTON_INPUT_SEARCH));
        new Actions(driver).moveToElement(element).click().sendKeys(text).build().perform();
    }

    public void clickButtonSearch() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BUTTON_SEARCH)));
        WebElement element = driver.findElement(By.xpath(BUTTON_SEARCH));
        element.click();
        new Actions(driver).pause(2000).build().perform();
    }

    public void clickIconXOnFieldInputSearch() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BUTTON_CLOSE_SEARCH)));
        WebElement element = driver.findElement(By.xpath(BUTTON_CLOSE_SEARCH));
        new Actions(driver).moveToElement(element).click().build().perform();
    }

    public void clickIconFilterOnContactName() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(BUTTON_FILTER_CONTACT_NAME)));
        WebElement element = driver.findElement(By.xpath(BUTTON_FILTER_CONTACT_NAME));
        new Actions(driver).moveToElement(element).click().pause(1000).build().perform();
    }

    public void clickSortAZOnPopUpFilter() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(BUTTON_FILTER_CONTACT_NAME_SORT_ASC)));
        WebElement element = driver.findElement(By.xpath(BUTTON_FILTER_CONTACT_NAME_SORT_ASC));
        element.click();
    }

    public void clickSortZAOnPopUpFilter() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(BUTTON_FILTER_CONTACT_NAME_SORT_DESC)));
        WebElement element = driver.findElement(By.xpath(BUTTON_FILTER_CONTACT_NAME_SORT_DESC));
        element.click();
    }

    public void clickButtonSetFilterOnPopUpFilter() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BUTTON_FILTER_CONTACT_NAME_SET_FILTER)));
        WebElement element = driver.findElement(By.xpath(BUTTON_FILTER_CONTACT_NAME_SET_FILTER));
        element.click();
    }

    public void clickButtonApplyFilter() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BUTTON_APPLY_FILTER)));
        WebElement element = driver.findElement(By.xpath(BUTTON_APPLY_FILTER));
        element.click();
        new Actions(driver).pause(1500).build().perform();
    }


    public void clickButtonRemoveFilter() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BUTTON_REMOVE_FILTER)));
        WebElement element = driver.findElement(By.xpath(BUTTON_REMOVE_FILTER));
        element.click();
    }

    public void clickExpandFilterByConditionName() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BUTTON_EXPAND_FILTER_NAME)));
        WebElement element = driver.findElement(By.xpath(BUTTON_EXPAND_FILTER_NAME + "/p"));
        new Actions(driver).moveToElement(element).click().pause(1000).build().perform();

        String xpath = "//*[@id='usecontactlist_popup_select_filtercondition_name']/following-sibling::input";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        WebElement e = driver.findElement(By.xpath(xpath));
        new Actions(driver).moveToElement(e).click().pause(1000).build().perform();
    }

    public void clickExpandFilterByConditionActivity() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BUTTON_EXPAND_FILTER_ACTIVITY)));
        WebElement element = driver.findElement(By.xpath(BUTTON_EXPAND_FILTER_ACTIVITY + "/p"));
        new Actions(driver).moveToElement(element).click().pause(1000).build().perform();

        String xpath = "//*[@id='usecontactlistdetail_popup_select_filtercondition_activity']/following-sibling::input";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        WebElement e = driver.findElement(By.xpath(xpath));
        new Actions(driver).moveToElement(e).click().pause(1000).build().perform();
    }

    public void onFieldConditionChoose(String text) {
        switch (text) {
            case "Text Starts With":
                String xpath = "//*[@id='usecontactlist_popup_dropdown_filtercondition_start-with_name']";
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
                WebElement element = driver.findElement(By.xpath(xpath));
                new Actions(driver).moveToElement(element).click().pause(1000).build().perform();
                break;
            case "Text Contains":
                String xpath1 = "//*[@id='usecontactlistdetail_popup_dropdown_filtercondition_textcontains_activity']";
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath1)));
                WebElement element1 = driver.findElement(By.xpath(xpath1));
                new Actions(driver).moveToElement(element1).click().pause(1000).build().perform();
                break;
            default:
                break;
        }
    }

    public void userTypeOnFieldCondition(String text) {
        String xpath = "//*[@class='contactListFilterInput']";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        WebElement element = driver.findElement(By.xpath(xpath));
        new Actions(driver).moveToElement(element).click().sendKeys(text).pause(1000).build().perform();
    }

    public void userClickIconFilterOnColumnCheckbox(String[] textArray) {
        for (String text : textArray) {
            String xpath = String.format("//*[@name='checkbox-%s']/following-sibling::*/*[local-name()='path']", text);
            String xpath1 = String.format("//*[@name='checkbox-%s']", text);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            WebElement e1 = driver.findElement(By.xpath(xpath1));
            if (!e1.isSelected()) {
                WebElement e = driver.findElement(By.xpath(xpath));
                new Actions(driver).moveToElement(e).click().pause(500).build().perform();

            }
        }
    }

    public void userClickButtonContactHistoryOnContact(String text) {
        boolean done = false;
        String wa = String.format(CONTACT_LIST_TABLE_CONTACT_HISTORY_BY_NO_WA, text);

        while(!done) {
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(wa)));
                done = true;
            } catch (Exception ignored) {
                userClickButtonNextPaginationOnContactList();
            }
        }

        WebElement element = driver.findElement(By.xpath(wa));
        element.click();
        new Actions(driver).pause(2000).perform();
    }

    public void userWillBeRedirectedToPageContactHistory() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CONTACT_HISTORY_PAGE)));
    }

    public void contactHistoryListWillShowsAllHistoryData(List<Map<String, String>> list) {
        for (Map<String, String> map : list) {
            map = Utils.replaceNullValuesWithEmptyStrings(map);
            List<WebElement> e = driver.findElements(By.xpath("//*[contains(@class,'Thead_ContactHistory')]//th"));

            for (int i=1; i<e.size(); i++) {
                String xpath = String.format("//*[contains(@class,'Tbody_ContactHistory')]//td[contains(@class,'%s')]", e.get(i).getAttribute("class"));
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
                List<WebElement> key = driver.findElements(By.xpath(xpath));

                if (i == 1 || i == 2) {
                    assert Utils.validateDate(key.get(0).getText(), map.get(e.get(i).getText()));
                }else {
                    int finalI = i;
                    Map<String, String> finalMap = map;
                    assert key.stream().anyMatch(f -> f.getText().contains(finalMap.get(e.get(finalI).getText())));
                }
            }
        }
    }

    public void userClickButtonExportHistory() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CONTACT_HISTORY_BUTTON_EXPORT)));
        WebElement element = driver.findElement(By.xpath(CONTACT_HISTORY_BUTTON_EXPORT));
        new Actions(driver).moveToElement(element).click().pause(500).click().perform();
    }

    public void userClickButtonYesImSureOnExportHistoryConfirmation() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CONTACT_HISTORY_CONFIRMATION_EXPORT)));
        WebElement element = driver.findElement(By.xpath(CONTACT_HISTORY_CONFIRMATION_EXPORT));
        element.click();
    }

    public void historyListWillBeExportedToExcelFormat() {
        new Actions(driver).pause(5000).perform();
        assert Utils.verifyDownloadedFile("Logs") : "File is not downloaded";
        new Actions(driver).pause(1000).perform();
        assert Utils.deleteDownloadedFile("Logs") : "Failed to delete file";
    }

    public void userClickIconFilterActivityOnContactHistoryPage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CONTACT_HISTORY_BUTTON_FILTER_ACTIVITY)));
        WebElement element = driver.findElement(By.xpath(CONTACT_HISTORY_BUTTON_FILTER_ACTIVITY));
        new Actions(driver).moveToElement(element).click().pause(1000).build().perform();
    }

    public void userClickButtonEditContactOnDetailContactPanel() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CONTACT_HISTORY_BUTTON_EDIT_CONTACT)));
        WebElement element = driver.findElement(By.xpath(CONTACT_HISTORY_BUTTON_EDIT_CONTACT));
        new Actions(driver).moveToElement(element).click().pause(500).build().perform();
    }

    public void userClickAndTypeOnFieldContactNameContactListDetail(String text) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CONTACT_HISTORY_EDIT_CONTACT_NAME)));
        WebElement element = driver.findElement(By.xpath(CONTACT_HISTORY_EDIT_CONTACT_NAME));
        element.clear();
        element.sendKeys(text);
        new Actions(driver).pause(700).perform();
    }

    public void userClickAndTypeOnFieldAddressContactListDetail(String text) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CONTACT_HISTORY_EDIT_ADDRESS)));
        WebElement element = driver.findElement(By.xpath(CONTACT_HISTORY_EDIT_ADDRESS));
        element.clear();
        element.sendKeys(text);
        new Actions(driver).pause(700).perform();
    }

    public void userClickButtonSaveOnContactListDetail() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CONTACT_HISTORY_EDIT_BUTTON_SAVE)));
        WebElement element = driver.findElement(By.xpath(CONTACT_HISTORY_EDIT_BUTTON_SAVE));
        new Actions(driver).moveToElement(element).click().pause(500).build().perform();
    }

    public void userClickButtonEditBulkOnContactListPage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CONTACT_LIST_BUTTON_EDIT_BULK)));
        WebElement element = driver.findElement(By.xpath(CONTACT_LIST_BUTTON_EDIT_BULK));
        new Actions(driver).moveToElement(element).click().pause(500).build().perform();
    }

    public void showPopUpEditBulk() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CONTACT_LIST_EDIT_BULK_POPUP)));
    }

    public void userClickAndTypeOnFieldCountryEditBulk(String text) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CONTACT_LIST_EDIT_BULK_POPUP_EDIT_COUNTRY)));
        WebElement element = driver.findElement(By.xpath(CONTACT_LIST_EDIT_BULK_POPUP_EDIT_COUNTRY));
        new Actions(driver).moveToElement(element).click().sendKeys(text).sendKeys(Keys.ENTER).pause(500).build().perform();
    }

    public void userClickAndTypeOnFieldProvinceEditBulk(String text) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CONTACT_LIST_EDIT_BULK_POPUP_EDIT_PROVINCE)));
        WebElement element = driver.findElement(By.xpath(CONTACT_LIST_EDIT_BULK_POPUP_EDIT_PROVINCE));
        new Actions(driver).moveToElement(element).click().sendKeys(text).sendKeys(Keys.ENTER).pause(500).build().perform();
    }

    public void userClickOnTagEditBulkAndChoose(String text) {
        switch (text) {
            case "Add":
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CONTACT_LIST_EDIT_BULK_POPUP_EDIT_TAG_MENU)));
                WebElement element = driver.findElement(By.xpath(CONTACT_LIST_EDIT_BULK_POPUP_EDIT_TAG_MENU));
                new Actions(driver).moveToElement(element).click().pause(500).build().perform();

                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CONTACT_LIST_EDIT_BULK_POPUP_EDIT_TAG_MENU_ADD)));
                WebElement e = driver.findElement(By.xpath(CONTACT_LIST_EDIT_BULK_POPUP_EDIT_TAG_MENU_ADD));
                new Actions(driver).moveToElement(e).click().pause(500).build().perform();
                break;
        }
    }

    public void userClickAndTypeOnFieldTagEditBulk(String text) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CONTACT_LIST_EDIT_BULK_POPUP_EDIT_TAG)));
        WebElement element = driver.findElement(By.xpath(CONTACT_LIST_EDIT_BULK_POPUP_EDIT_TAG));

        Point coordinates = element.getLocation();
        new Actions(driver)
                .moveToElement(element)
                .click()
                .sendKeys(text)
                .pause(500)
                .moveToLocation(coordinates.getX(), coordinates.getY() - 50)
                .click()
                .pause(500)
                .build().perform();
    }

    public void userClickButtonSaveOnEditBulk() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CONTACT_LIST_EDIT_BULK_POPUP_BUTTON_SAVE)));
        WebElement element = driver.findElement(By.xpath(CONTACT_LIST_EDIT_BULK_POPUP_BUTTON_SAVE));
        new Actions(driver).moveToElement(element).click().pause(5000).build().perform();
    }

    public void uploadExcelTemplate1000IntoPopUpImportFile() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(POPUP_IMPORT_FILE_INPUT_EXCEL)));
        WebElement element = driver.findElement(By.xpath(POPUP_IMPORT_FILE_INPUT_EXCEL));

        File file = new File(
                "src" + File.separator + "test" + File.separator +
                        "resources" + File.separator + "ContactList1000Data.xlsx");
        element.sendKeys(file.getAbsolutePath());

        new Actions(driver).pause(1000).perform();
    }

    public void userSeeWarnUploadMoreThanData() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(POPUP_IMPORT_FILE_WARN_DATA)));
        WebElement element = driver.findElement(By.xpath(POPUP_IMPORT_FILE_WARN_DATA));
        assert element.getText().equals("The data that was uploaded exceeded 1000 data, the system will process this in the background. You can check the progression within the notification icon.");
    }

    public void userUploadExcelTemplate1000OverwriteIntoPopUpImportFile() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(POPUP_IMPORT_FILE_INPUT_EXCEL)));
        WebElement element = driver.findElement(By.xpath(POPUP_IMPORT_FILE_INPUT_EXCEL));

        File file = new File(
                "src" + File.separator + "test" + File.separator +
                        "resources" + File.separator + "ContactList1000DataOverwrite.xlsx");
        element.sendKeys(file.getAbsolutePath());

        new Actions(driver).pause(1000).perform();
    }

    public void userSeePopUpSkipOrOverwrite() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(POPUP_IMPORT_FILE_SKIP_OR_OVERWRITE)));
    }

    public void userUploadExcelTemplate20IntoPopUpImportFile() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(POPUP_IMPORT_FILE_INPUT_EXCEL)));
        WebElement element = driver.findElement(By.xpath(POPUP_IMPORT_FILE_INPUT_EXCEL));

        File file = new File(
                "src" + File.separator + "test" + File.separator +
                        "resources" + File.separator + "ContactList20Data.xlsx");
        element.sendKeys(file.getAbsolutePath());

        new Actions(driver).pause(1000).perform();
    }

    public void userClickButtonNextPaginationOnContactList() {
        while (!driver.findElement(By.xpath(BUTTON_NEXT_PAGE)).getAttribute("class").equals("Active")) {
            new Actions(driver).pause(500).build().perform();
        }

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BUTTON_NEXT_PAGE)));
        WebElement element = driver.findElement(By.xpath(BUTTON_NEXT_PAGE));
        new Actions(driver).moveToElement(element).click().pause(500).build().perform();
    }

    public void userOnPageOfContactList(int number) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SEARCH_PAGINATION_NUMBER)));
        WebElement element = driver.findElement(By.xpath(SEARCH_PAGINATION_NUMBER));
        assert element.getAttribute("value").equals(String.valueOf(number)) : "actual: " + element.getAttribute("value") + " expected: " + number;
    }

    public void userClickButtonPrevPaginationOnContactList() {
        while (!driver.findElement(By.xpath(BUTTON_PREV_PAGE)).getAttribute("class").equals("Active")) {
            new Actions(driver).pause(500).build().perform();
        }

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BUTTON_PREV_PAGE)));
        WebElement element = driver.findElement(By.xpath(BUTTON_PREV_PAGE));
        new Actions(driver).moveToElement(element).click().pause(500).build().perform();
    }

    public void userClickFieldDataViewOnPaginationAndChoose(String text) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SEARCH_PAGINATION_DATA_VIEW)));
        WebElement element = driver.findElement(By.xpath(SEARCH_PAGINATION_DATA_VIEW));
        new Actions(driver).moveToElement(element).click().pause(500).build().perform();

        if (text.equals("50")) {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='contactlist_btn_limitnumber_50']")));
            element = driver.findElement(By.xpath("//*[@id='contactlist_btn_limitnumber_50']"));
            new Actions(driver).moveToElement(element).click().pause(2000).build().perform();
        } else if (text.equals("10")) {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='contactlist_btn_limitnumber_10']")));
            element = driver.findElement(By.xpath("//*[@id='contactlist_btn_limitnumber_10']"));
            new Actions(driver).moveToElement(element).click().pause(2000).build().perform();
        } else {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='contactlist_btn_limitnumber_100']")));
            element = driver.findElement(By.xpath("//*[@id='contactlist_btn_limitnumber_100']"));
            new Actions(driver).moveToElement(element).click().pause(2000).build().perform();
        }
    }

    public void tableContactListWillOnlyShowRowDataContactList(int number) {
        String xpath = "//*[contains(@class,'MuiTableRow-root contactItem')]";
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath)));
        List<WebElement> element = driver.findElements(By.xpath(xpath));
        assert element.size() == number : "actual: " + element.size() + " expected: " + number;
    }

    public void showPopUpDeleteConfirmation() {
        String xpath = "//*[@class='DeleteContactListPopup_head']";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    public void userClickButtonYesIMSureOnDeleteConfirmation() {
        String xpath = "//*[@id='deletecontactlist_popup_btn_confirmdelete']";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        WebElement element = driver.findElement(By.xpath(xpath));
        new Actions(driver).moveToElement(element).click().pause(500).build().perform();
    }

    public void userClickButtonDeleteBulkOnContactListPage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(BUTTON_DELETE_BULK)));
        WebElement element = driver.findElement(By.xpath(BUTTON_DELETE_BULK));
        new Actions(driver).moveToElement(element).click().pause(500).build().perform();
    }

    public void showPopUpDeleteBulkConfirmation() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(POPUP_DELETE_BULK)));
    }

    public void userClickButtonYesIMSureOnDeleteBulkConfirmation() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(POPUP_DELETE_BULK_BUTTON_YES)));
        WebElement element = driver.findElement(By.xpath(POPUP_DELETE_BULK_BUTTON_YES));
        new Actions(driver).moveToElement(element).click().pause(500).build().perform();
    }

    public void userTypeOnInputSearchContactHistory(String text) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CONTACT_HISTORY_INPUT_SEARCH)));
        WebElement element = driver.findElement(By.xpath(CONTACT_HISTORY_INPUT_SEARCH));
        new Actions(driver).moveToElement(element).click().sendKeys(text).pause(500).build().perform();
    }

    public void tableContactListHistoryWillBeFilteredWithBlueHighlighted() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@class='highlighted']")));
        List<WebElement> elements = driver.findElements(By.xpath("//*[@class='highlighted']"));
        assert elements.size() > 1;
    }

    public void userClickIconXOnInputSearchContactHistory() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CONTACT_HISTORY_BUTTON_X)));
        WebElement element = driver.findElement(By.xpath(CONTACT_HISTORY_BUTTON_X));
        new Actions(driver).moveToElement(element).click().pause(1000).build().perform();
    }

    public void tableContactListHistoryWillBeBackToNormal() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='highlighted']")));
    }

    public void userClickIconFilterSessionIDOnContactHistoryPage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CONTACT_HISTORY_BUTTON_FILTER_SESSION_ID)));
        WebElement element = driver.findElement(By.xpath(CONTACT_HISTORY_BUTTON_FILTER_SESSION_ID));
        new Actions(driver).moveToElement(element).click().pause(1000).build().perform();
    }

    public void userClickExpandFilterByValue() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BUTTON_EXPAND_FILTER_VALUE_SESSION_ID)));
        WebElement element = driver.findElement(By.xpath(BUTTON_EXPAND_FILTER_VALUE_SESSION_ID + "/p"));
        new Actions(driver).moveToElement(element).click().pause(1000).build().perform();

        String xpath = "//*[@id='usecontactlist_popup_select_filtercondition_name']/following-sibling::input";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        WebElement e = driver.findElement(By.xpath(xpath));
        new Actions(driver).moveToElement(e).click().pause(1000).build().perform();
    }

    public void onFieldFilterByValueTickOnlyOne() {
        String nextPage = "//*[@id='usecontactlistdetail_popup_button_filtervalue_nextpagination_session']/*[local-name()='svg']/*[local-name()='path']";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(nextPage)));
        WebElement element = driver.findElement(By.xpath(nextPage));
        new Actions(driver).moveToElement(element).click().pause(500).build().perform();

        String values = "//*[@class='valueItem']";
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(values)));
        List<WebElement> elements = driver.findElements(By.xpath(values));
        new Actions(driver).moveToElement(elements.get(2)).click().pause(500).build().perform();
    }

    public void searchChatWillFoundNothing() {

    }
}
