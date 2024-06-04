package cucumber.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class ChatTemplatePage {
    private final String BUTTON_LOAD_EXISTING_TEMPLATE = "addnewtemplatechat_btn_loadexisting";
    private final String BUTTON_GUIDE_BOOK = "navmenu_navbtn_guidebook";
    private final String BUTTON_CREATE_NEW_TEMPLATE = "//*[contains(., 'New Template')]/parent::button";
    private final String POP_UP_NEW_TEMPLATE_CREATION = "BroadcastChatTemplate";
    private final String POP_UP_CLOSE_BUTTON = "//*[@class='Header']/*[local-name()='svg']/*[local-name()='path']";
    private final String LEFT_MODAL = "leftModalAddNewTemplate";
    private final String RIGHT_MODAL = "RightModalAddNewTemplate";
    private final String INPUT_TEMPLATE_NAME = "addnewtemplatechat_textinput_templatename";
    private final String EDIT_TEMPLATE_NAME = "inputChatTemplateModal";
    private final String BUTTON_LOAD_EXISTING = "addnewtemplatechat_btn_loadexisting";
    private final String CONTAINER_BUBBLE_CHAT = "//*[@class='ContainerBuble']";
    private final String BUBBLE_CHAT_NUMBER = "//*[contains(@class, 'Asdiv DataView')]";
    private final String INPUT_BUBBLE_CHAT = "//*[contains(@class, 'ql-editor')]";
    private final String BUTTON_ADD_FILE = "//*[contains(@class, 'Asp')]";
    private final String BUTTON_IMAGE = "//*[@class='BubbleTemplateContent_Popover_item pointer' and .='Image']";
    private final String UPLOAD_IMAGE = "inputFileImage";
    private final String BUTTON_ADD_BUBBLE_CHAT = "addnewtemplate_buble_btn_addbublechat";
    private final String BUTTON_WAIT_FOR_SECOND = "addnewtemplate_buble_btn_waitforrespond";
    private final String INPUT_HOTKEY = "inputlabel_textinput_hotkey";
    private final String MESSAGE_PREVIEW_CONTAINER = "ContainerPreviewAddNewTemplate";
    private final String CHAT_CONTENT_USER = "//div[@class='ChatContent_User']";
    private final String MESSAGE_PREVIEW = "//p[@class='text']";
    private final String BUBBLE_CHAT_IMAGE = "//img[not(@class='triangle')]";
    private final String BUTTON_CREATE_TEMPLATE = "addnewtemplate_buble_btn_createtemplate";
    private final String BUTTON_SAVE_TEMPLATE = "edittemplatechat_btn_savetemplate";
    private final String TEMPLATE_TABLE_COLUMNS = "//*[contains(@class, 'MuiTableBody-root')]//td";
    private final String TEMPLATE_TABLE_COLUMNS_EDIT = "//button[@id='chattemplate_page_btn_edit']";
    private final String TEMPLATE_TABLE_EDIT_WITH_TEMPLATE_NAME = "//*[@id='contactlist_bodytable_btn_3_0' and @title='%s']/following-sibling::td//button[@id='chattemplate_page_btn_edit']";
    private final String TEMPLATE_TABLE_TEMPLATE_NAME = "//*[@id='contactlist_bodytable_btn_3_0']";
    private final String TEMPLATE_TABLE_TEMPLATE_NAME_WITH_TITLE = "//*[@id='contactlist_bodytable_btn_3_0' and @title='%s']";
    private final String TEMPLATE_TABLE_COLUMNS_DELETE = "//button[@id='chattemplate_page_btn_delete']";
    private final String TEMPLATE_TABLE_COLUMNS_DELETE_CONFIRMATION = "//button[@id='confirmchattemplate_page_confirm_delete_popup_btn_chattemplate_page_confirm_delete']";
    private final String DROPDOWN_LIST_LOAD_EXISTING = "//*[@class='labelOptionTemplate']";
    private final String HOTKEY_ERROR_MESSAGE = "ContainerHotkeys";

    private WebDriver driver;
    private WebDriverWait wait;

    public ChatTemplatePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(60));
    }

    public void goToGuidebookPage() {
        try {
            WebElement title = driver.findElement(By.xpath("//*[@class='head']/h4"));
            assert title.getText().equals("Robo");
        } catch (Exception e) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(By.id(BUTTON_GUIDE_BOOK)));
                WebElement btnGuidebook = driver.findElement(By.id(BUTTON_GUIDE_BOOK));
                btnGuidebook.click();
            } catch (Exception ignored) {}
        }
    }

    public void clickCreateNewTemplate() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BUTTON_CREATE_NEW_TEMPLATE)));
        WebElement btnCreateNewTemplate = driver.findElement(By.xpath(BUTTON_CREATE_NEW_TEMPLATE));

        btnCreateNewTemplate.click();
    }

    public void assertButtonCreateNewTemplate(String expectedText) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BUTTON_CREATE_NEW_TEMPLATE)));
        WebElement btnCreateNewTemplate = driver.findElement(By.xpath(BUTTON_CREATE_NEW_TEMPLATE));

        String text = btnCreateNewTemplate.getText();
        assert text.equals(expectedText) : "actual: " + text + " expected: " + expectedText;
    }

    public void waitUntilPopUpNewTemplateCreationShown() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(POP_UP_NEW_TEMPLATE_CREATION)));
    }

    public void assertPopUpNewTemplateCreationHasTwoSides() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(LEFT_MODAL)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(RIGHT_MODAL)));
    }

    public void assertEditorialTemplateHasTemplateName() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(INPUT_TEMPLATE_NAME)));
    }

    public void inputEditorialTemplateTemplateName(String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(INPUT_TEMPLATE_NAME)));
        WebElement element = driver.findElement(By.id(INPUT_TEMPLATE_NAME));

        element.sendKeys(text);
    }

    public void assertEditorialTemplateTemplateName(String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(EDIT_TEMPLATE_NAME)));
        WebElement element = driver.findElement(By.className(EDIT_TEMPLATE_NAME));

        assert element.getAttribute("value").equals(text) : "actual: " + element.getText() + " expected: " + text;
    }

    public void assertEditorialTemplateTemplateNameValue(String expected_text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(INPUT_TEMPLATE_NAME)));
        WebElement element = driver.findElement(By.id(INPUT_TEMPLATE_NAME));

        assert element.getAttribute("value").equals(expected_text) : "actual: " + element.getAttribute("value") + " expected: " + expected_text;
    }

    public void assertEditorialTemplateHasButtonLoadExisting() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(BUTTON_LOAD_EXISTING)));
    }

    public void assertEditorialTemplateHasBubbleChatNumber(int number) {
        String xPath = CONTAINER_BUBBLE_CHAT + "[" + number + "]" + BUBBLE_CHAT_NUMBER;
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
        WebElement element = driver.findElement(By.xpath(xPath));

        assert element.getText().equals(String.valueOf(number)) : "actual: " + element.getText() + " expected: " + number;
    }

    public void inputEditorialTemplateBubbleChat(int number, String text) {
        String xPath = CONTAINER_BUBBLE_CHAT + "[" + number + "]" + INPUT_BUBBLE_CHAT;
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
        WebElement element = driver.findElement(By.xpath(xPath));

        element.sendKeys(text);
    }

    public void editEditorialTemplateBubbleChat(int number, String text) {
        String xPath = CONTAINER_BUBBLE_CHAT + "[" + number + "]" + INPUT_BUBBLE_CHAT;
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
        WebElement element = driver.findElement(By.xpath(xPath));

        element.clear();
        element.click();
        element.sendKeys(text);
    }

    public void assertEditorialTemplateBubbleChatValue(int number, String text) {
        String xPath = CONTAINER_BUBBLE_CHAT + "[" + number + "]" + INPUT_BUBBLE_CHAT;
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
        WebElement element = driver.findElement(By.xpath(xPath));

        assert element.getText().equals(text) : "actual: " + element.getText() + " expected: " + text;
    }

    public void assertEditorialTemplateHasButtonAddBubbleChat() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(BUTTON_ADD_BUBBLE_CHAT)));
    }

    public void assertEditorialTemplateHasButtonWaitForSecond() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(BUTTON_WAIT_FOR_SECOND)));
    }

    public void assertEditorialTemplateHasInputHotKey() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(INPUT_HOTKEY)));
        WebElement element = driver.findElement(By.id(INPUT_HOTKEY));

        assert !element.getAttribute("value").isEmpty() : "actual: " + element.getAttribute("value") + " expected: not empty";
    }

    public void assertPreviewTemplateHasMessagePreviewContainer() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(MESSAGE_PREVIEW_CONTAINER)));
    }

    public void assertPreviewTemplateMessagePreview(int number,String expectedText) {
        String xPath = CHAT_CONTENT_USER + "[" + number + "]" + MESSAGE_PREVIEW;
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
        WebElement element = driver.findElement(By.xpath(xPath));

        assert element.getText().equals(expectedText) : "actual: " + element.getText() + " expected: " + expectedText;
    }

    public void assertPreviewTemplateHasButtonCreateNewTemplate() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(BUTTON_CREATE_TEMPLATE)));
    }

    public void clickEditorialTemplateButtonAddBubbleChat() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(BUTTON_ADD_BUBBLE_CHAT)));
        WebElement element = driver.findElement(By.id(BUTTON_ADD_BUBBLE_CHAT));

        element.click();
    }

    public void clickEditorialTemplateButtonAddFile(int number) {
        String xPath = CONTAINER_BUBBLE_CHAT + "[" + number + "]" + BUTTON_ADD_FILE;
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
        WebElement element = driver.findElement(By.xpath(xPath));

        element.click();
    }

    public void clickEditorialTemplateChooseImage() {
        WebElement element = driver.findElement(By.xpath(BUTTON_IMAGE));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clickEditorialTemplateUploadImage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(UPLOAD_IMAGE)));
        WebElement element = driver.findElement(By.id(UPLOAD_IMAGE));

        File file = new File(
                "src" + File.separator + "test" + File.separator +
                        "resources" + File.separator + "blank-image.png");
        element.sendKeys(file.getAbsolutePath());
    }

    public void assertEditorialTemplateBubbleChatImage(int number) {
        String xPath = CHAT_CONTENT_USER  + BUBBLE_CHAT_IMAGE;
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
    }

    public void inputEditorialTemplateHotkey(String text) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(INPUT_HOTKEY)));
        WebElement element = driver.findElement(By.id(INPUT_HOTKEY));

        while (!Objects.equals(element.getAttribute("value"), "")) {
            element.clear();
            Thread.sleep(1000);
        }

        element.sendKeys(text);
    }

    public void assertEditorialTemplateHotkeyValue(String expected_text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(INPUT_HOTKEY)));
        WebElement element = driver.findElement(By.id(INPUT_HOTKEY));

        assert element.getAttribute("value").equals(expected_text) : "actual: " + element.getAttribute("value") + " expected: " + expected_text;
    }

    public void clickEditorialTemplateButtonCreateTemplate() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id(BUTTON_CREATE_TEMPLATE)));
        WebElement element = driver.findElement(By.id(BUTTON_CREATE_TEMPLATE));

        element.click();
    }

    public void waitUntilPopUpNewTemplateCreationClosed() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(POP_UP_NEW_TEMPLATE_CREATION)));
    }

    public void assertEditorialTemplateTableColumns(String templateName, String hotkey, String createdTime, String guideBook) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(TEMPLATE_TABLE_COLUMNS)));
        List<WebElement> element = driver.findElements(By.xpath(TEMPLATE_TABLE_COLUMNS));

        int i = 0;

        for (WebElement e : element) {
            if (e.getText().equals(templateName)) {i++;}
            if (e.getText().equals(hotkey)) {i++;}
            if (e.getText().equals(createdTime)) {i++;}
            if (e.getText().equals(guideBook)) {i++;}
            if (i == 4) {break;}
        }

        assert i == 4 : "New Template is not exists in table";
    }

    public void assertEditorialTemplateTableButtonEditDelete() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(TEMPLATE_TABLE_COLUMNS_EDIT)));
        List<WebElement> btnEdit = driver.findElements(By.xpath(TEMPLATE_TABLE_COLUMNS_EDIT));
        assert !btnEdit.isEmpty();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(TEMPLATE_TABLE_COLUMNS_DELETE)));
        List<WebElement> btnDelete = driver.findElements(By.xpath(TEMPLATE_TABLE_COLUMNS_DELETE));
        assert !btnDelete.isEmpty();
    }

    public void clickEditorialTemplateTableButtonDelete() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(TEMPLATE_TABLE_COLUMNS_DELETE)));
        WebElement element = driver.findElement(By.xpath(TEMPLATE_TABLE_COLUMNS_DELETE));

        element.click();
    }

    public void clickEditorialTemplateTableButtonDeleteConfirmation() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath(TEMPLATE_TABLE_COLUMNS_DELETE_CONFIRMATION));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TEMPLATE_TABLE_COLUMNS_DELETE_CONFIRMATION)));

        element.click();

        Thread.sleep(1000);
    }

    public void deleteAllTemplate() throws InterruptedException {
        WebElement btnCreateNewTemplate = driver.findElement(By.xpath(BUTTON_CREATE_NEW_TEMPLATE));
        if (btnCreateNewTemplate.getText().equals("Create New Template")) {
            return;
        }

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(TEMPLATE_TABLE_TEMPLATE_NAME)));
        List<WebElement> templateName = driver.findElements(By.xpath(TEMPLATE_TABLE_TEMPLATE_NAME));
        List<WebElement> btnDelete = driver.findElements(By.xpath(TEMPLATE_TABLE_COLUMNS_DELETE));

        for (int i=templateName.size()-1; i>=0; i--) {
            Point coordinatesBtnDelete = btnDelete.get(i).getLocation();

            Actions builder = new Actions(driver);
            builder
                    .clickAndHold(templateName.get(i))
                    .moveToLocation(coordinatesBtnDelete.getX() + 50, coordinatesBtnDelete.getY())
                    .pause(2000)
                    .build().perform();

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(TEMPLATE_TABLE_COLUMNS_DELETE)));

            btnDelete.get(i).click();
            clickEditorialTemplateTableButtonDeleteConfirmation();
        }
    }

    public void assertChatTemplateCreated(String templateName) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(TEMPLATE_TABLE_COLUMNS)));
        List<WebElement> element = driver.findElements(By.xpath(TEMPLATE_TABLE_COLUMNS));

        assert element.get(1).getText().equals(templateName);
    }

    public void assertChatTemplateButtonNewTemplate() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BUTTON_CREATE_NEW_TEMPLATE)));
    }

    public void clickPopUpNewTemplateCreationCloseButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(POP_UP_CLOSE_BUTTON)));
        WebElement element = driver.findElement(By.xpath(POP_UP_CLOSE_BUTTON));

        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();

        try {
            element.click();
        } catch (Exception ignored) {}
    }

    public void clickChatTemplateButtonLoadExisting() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id(BUTTON_LOAD_EXISTING_TEMPLATE)));
        WebElement element = driver.findElement(By.id(BUTTON_LOAD_EXISTING_TEMPLATE));

        element.click();
    }

    public void assertChatTemplateDropdownList() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(DROPDOWN_LIST_LOAD_EXISTING)));
    }

    public void clickChatTemplateDropdownList(String text) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(DROPDOWN_LIST_LOAD_EXISTING)));
        List<WebElement> element = driver.findElements(By.xpath(DROPDOWN_LIST_LOAD_EXISTING));

        for (WebElement e : element) {
            if (e.getText().equals(text)) {
                e.click();
                break;
            }
        }
    }

    public void assertChatTemplateButtonCreateTemplate(String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(BUTTON_CREATE_TEMPLATE)));
        WebElement element = driver.findElement(By.id(BUTTON_CREATE_TEMPLATE));

        assert element.getText().equals(text) : "actual: " + element.getText() + " expected: " + text;
    }

    public void assertEditedTemplate(String templateName, int number, String message) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(TEMPLATE_TABLE_COLUMNS)));
        List<WebElement> element = driver.findElements(By.xpath(TEMPLATE_TABLE_COLUMNS));
        assert element.get(1).getText().equals(templateName);

        Point coordinatesBtnDelete= driver.findElement(By.xpath(TEMPLATE_TABLE_COLUMNS_DELETE)).getLocation();
        Actions builder = new Actions(driver);
        builder
                .clickAndHold(element.get(1))
                .moveToLocation(coordinatesBtnDelete.getX() + 50, coordinatesBtnDelete.getY())
                .pause(2000)
                .build().perform();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(TEMPLATE_TABLE_COLUMNS_EDIT)));
        WebElement btnEdit = driver.findElement(By.xpath(TEMPLATE_TABLE_COLUMNS_EDIT));
        btnEdit.click();

        String xPath = CONTAINER_BUBBLE_CHAT + "[" + number + "]" + INPUT_BUBBLE_CHAT;
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
        WebElement bubbleChat = driver.findElement(By.xpath(xPath));

        assert bubbleChat.getText().equals(message) : "actual: " + bubbleChat.getText() + " expected: " + message;
    }

    public void editEditorialTemplateName(String text) throws InterruptedException {
        WebElement element = driver.findElement(By.className(EDIT_TEMPLATE_NAME));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(EDIT_TEMPLATE_NAME)));

        while (!Objects.equals(element.getAttribute("value"), "")) {
            element.clear();
            Thread.sleep(2000);
        }

        element.sendKeys(text);
    }

    public void editEditorialTemplateHotkey(String text) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(INPUT_HOTKEY)));
        WebElement element = driver.findElement(By.id(INPUT_HOTKEY));

        while (!Objects.equals(element.getAttribute("value"), "")) {
            element.clear();
            Thread.sleep(2000);
        }

        element.sendKeys(text);
    }

    public void assertAddedTemplate(String templateName, String hotkey) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(TEMPLATE_TABLE_COLUMNS)));
        List<WebElement> element = driver.findElements(By.xpath(TEMPLATE_TABLE_COLUMNS));

        int i = 0;

        for (WebElement e : element) {
            if (e.getText().equals(templateName)) {
                i++;
            }

            if (e.getText().equals(hotkey)) {
                i++;
            }
        }

        assert i == 2 : "New Template is not exists in table";
    }

    public void assertTemplateStillExistsInTable(String templateName) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(TEMPLATE_TABLE_COLUMNS)));
        List<WebElement> element = driver.findElements(By.xpath(TEMPLATE_TABLE_COLUMNS));

        int i = 0;

        for (WebElement e : element) {
            if (e.getText().equals(templateName)) {
                i++;
            }
        }

        assert i == 1 : "Template is not exists in table";
    }

    public void assertListTemplateTable() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(TEMPLATE_TABLE_COLUMNS)));
    }

    public void clickEditButtonOnTemplateName(String text) {
        Point coordinatesBtnDelete= driver.findElement(By.xpath(TEMPLATE_TABLE_COLUMNS_DELETE)).getLocation();
        String xpath2 = String.format(TEMPLATE_TABLE_TEMPLATE_NAME_WITH_TITLE, text);
        WebElement templateName = driver.findElement(By.xpath(xpath2));
        Actions builder = new Actions(driver);
        builder
                .clickAndHold(templateName)
                .moveToLocation(coordinatesBtnDelete.getX() + 50, coordinatesBtnDelete.getY())
                .pause(2000)
                .build().perform();

        String xpath = String.format(TEMPLATE_TABLE_EDIT_WITH_TEMPLATE_NAME, text);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        WebElement element = driver.findElement(By.xpath(xpath));

        element.click();
    }

    public void assertButtonSaveTemplate() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id(BUTTON_SAVE_TEMPLATE)));
    }

    public void clickSaveTemplateButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(BUTTON_SAVE_TEMPLATE)));
        WebElement element = driver.findElement(By.id(BUTTON_SAVE_TEMPLATE));

        element.click();
    }

    public void assertEditorialTemplateHotkeyError() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(HOTKEY_ERROR_MESSAGE)));
        WebElement element = driver.findElement(By.className(HOTKEY_ERROR_MESSAGE));

        String elementColor = Color.fromString(element.getCssValue("color")).asRgba();

        assert elementColor.equals("rgba(255, 0, 0, 1)") : "actual: " + element.getCssValue("color") + " expected: rgba(255, 0, 0, 1)";
    }

    public void assertErrorMessage(String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(HOTKEY_ERROR_MESSAGE)));
        WebElement element = driver.findElement(By.className(HOTKEY_ERROR_MESSAGE));

        assert element.getText().equals(text) : "actual: " + element.getText() + " expected: " + text;
    }

    public void assertPopUpNewTemplateCreationIsNotClosed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(POP_UP_NEW_TEMPLATE_CREATION)));
    }

    public void assertTemplateCannotBeSaved() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(BUTTON_SAVE_TEMPLATE)));
        WebElement element = driver.findElement(By.id(BUTTON_SAVE_TEMPLATE));

        assert !element.isEnabled() : "actual: " + element.isEnabled() + " expected: " + false;
    }
}
