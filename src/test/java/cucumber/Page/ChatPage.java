package cucumber.Page;

import cucumber.util.Utils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ChatPage {


    private final String BUTTON_INBOX = "navmenu_navbtn_inbox";
    private final String BUTTON_CONTACT = "navmenu_navbtn_contact";
    private final String BUTTON_SETTING = "navmenu_navbtn_setting";
    private final String BUTTON_ADD_TAG = "chatbody_addtaguser_btn_addtag";

    private final String BTN_OPEN_CHAT = "//*[@id='sidebarchatcontact_btn_openchat_%s:%s']";
    private final String BUTTON_CLOSE_SESSION = "//*[@id='chatbody_chatcontent_btn_closesession']";
    private final String PROFILE_SIDEBAR_ACTIVE_BORDER = "//*[contains(@class,'ContactActive')]//*[@class='AvatarContainer']/img";
    private final String BUTTON_CHECK = "//*[@id='chatsheader_btn_selectmode']";
    private final String BUTTON_FILTER = "//*[@id='chatsheader_btn_filter']";
    private final String BUTTON_ADD_NEW_CHAT_TABS = "//*[@id='chatsheader_btn_addchattab']";
    private final String BUTTON_MORE = "//*[@id='sidebarchatnotification_btn_more']";
    private final String BUTTON_TAGGING_ALL_SELECTED = "//*[@id='sidebarchatnotification_btn_taggingallselected']";
    private final String POPUP_TAGGING_ALL_SELECTED = "//*[@class='MTag']";
    private final String POPUP_TAGGING_ALL_SELECTED_INPUT_TAG = "//*[contains(@id,'-input')]";
    private final String POPUP_TAGGING_ALL_SELECTED_BUTTON_ADD_TAG = "//*[@id='chatbody_multitag_btn_addtagging']";
    private final String BUTTON_NOTES_ALL_SELECTED = "//*[@id='sidebarchatnotification_btn_notesallselected']";
    private final String POPUP_NOTES_ALL_SELECTED = "//*[@class='MNote']";
    private final String POPUP_NOTES_ALL_SELECTED_INPUT_TAG = "//*[@id='chatbody_multinote_textarea_notes']";
    private final String POPUP_NOTES_ALL_SELECTED_BUTTON_IMPORTANT = "//*[@id='chatbody_multinote_btn_switchimportant']";
    private final String POPUP_NOTES_ALL_SELECTED_BUTTON_ADD_NOTES = "//*[@id='chatbody_multinote_btn_addnotes']";
    private final String FILTER_SESSION = "//*[@id='chatsheader_filterchat_checkbox_%s']";
    private final String FILTER_USERNAME = "//*[@id='chatbody_editchattabs_select_username']";
    private final String FILTER_USERNAME_SELECTED = "//*[@id='chatbody_editchattabs_select_username-option-0']";
    private final String FILTER_BUTTON_APPLY = "//*[@id='chatsheader_filterchat_btn_applyfilter']";

    private final String CHAT_TABS_SESSION = "//*[@id='chatbody_chattabs_btn_%s']";
    private final String EDIT_CHAT_TABS_SESSION = "//*[@id='chatbody_editchattabs_btn_%s']";
    private final String EDIT_CHAT_TABS_BUTTON_SAVE = "//*[@id='chatbody_editchattabs_btn_saveedit']";
    private final String CHAT_TABS_USERNAME = "//*[@id='chatbody_chattabs_select_username']";
    private final String CHAT_TABS_USERNAME_SELECTED = "//*[@id='chatbody_chattabs_select_username-option-0']";
    private final String CHAT_TABS_NAME = "//*[@id='chatbody_chattabs_textinput_name' or @id='chatbody_editchattabs_inputtext_name']";
    private final String CHAT_TABS_BUTTON_CREATE_CHAT_TABS = "//*[@id='chatbody_chattabs_btn_createchattab']";
    private final String CHAT_TABS_NEW_TABS = "//*[contains(@id,'chatsheader_chattabsnav_btn_activechattab_')]";
    private final String CHAT_TABS_NEW_TABS_DROPDOWN_EDIT = "//*[contains(@id,'chatsheader_chattabsnav_drpdwn_edit_')]";
    private final String CHAT_TABS_NEW_TABS_DROPDOWN_DELETE = "//*[contains(@id,'chatsheader_chattabsnav_drpdwn_delete_')]";

    private final String CHAT_USER_TAB_PROFILE_DETAIL = "//*[@class='ChatUser_ProfileDetail']";
    private final String CHAT_USER_TAB_USER_DETAIL_WA = "//*[@class='ChatUser_Detail']/div[2]/p[2]";
    private final String CHAT_USER_TAB_USER_DETAIL_CHAT_SESSION= "//*[@class='ChatUser_Detail']/div";
    private final String CHAT_USER_TAB_INPUT_TAG = "//*[@class='ChatUser_search']//input";
    private final String CHAT_USER_TAB_TAG_LIST = "//*[@class='tag-item']";
    private final String CHAT_USER_TAB_NOTES = "//*[@id='chatbody_chatuser_accordion_notes']";
    private final String CHAT_USER_TAB_NOTES_TITLE = "//*[@id='chatbody_chatuser_accordion_notes']//*[@class='body_small_medium']";
    private final String CHAT_USER_TAB_NOTES_TOGGLE_IMPORTANT = "//*[@id='chatbody_chatuser_btn_switchimportant']";
    private final String CHAT_USER_TAB_ADD_NOTE = "//*[@id='note']";
    private final String CHAT_USER_TAB_BUTTON_EDIT_INFO_CONTACT = "//*[@id='chatbody_chatuser_btn_edit']";

    private final String EDIT_INFO_CONTACT_TAB_HEADER = "//*[@class='ChatUserEdit_Header']";
    private final String EDIT_INFO_CONTACT_TAB_CONTACT_NAME = "//*[@id='chatbody_chatuser_textinput_name']";
    private final String EDIT_INFO_CONTACT_TAB_BIRTH = "//*[@id='chatbody_chatuser_date_birthdate']";
    private final String EDIT_INFO_CONTACT_TAB_COUNTRY = "//*[@id='chatbody_chatuser_select_country']";
    private final String EDIT_INFO_CONTACT_TAB_SELECT_COUNTRY = "//*[@id='chatbody_chatuser_select_country-option-0']";
    private final String EDIT_INFO_CONTACT_TAB_PROVINCE = "//*[@id='chatbody_chatuser_select_province']";
    private final String EDIT_INFO_CONTACT_TAB_SELECT_PROVINCE = "//*[@id='chatbody_chatuser_select_province-option-0']";
    private final String EDIT_INFO_CONTACT_TAB_CITY = "//*[@id='chatbody_chatuser_select_city']";
    private final String EDIT_INFO_CONTACT_TAB_SELECT_CITY = "//*[@id='chatbody_chatuser_select_city-option-1']";
    private final String EDIT_INFO_CONTACT_TAB_ADDRESS = "//*[@id='chatbody_chatuser_inputtext_address']";
    private final String EDIT_INFO_CONTACT_TAB_POSTAL_CODE = "//*[@id='chatbody_chatuser_inputtext_postalcode']";
    private final String EDIT_INFO_CONTACT_TAB_BUTTON_SAVE = "//*[@id='chatbody_chatuser_btn_saveeditaction']";

    private final String CHAT_ROOM_TAG_LIST = "//*[@class='SidebarChat_Tag']/div[@class='tag']";
    private final String ASSIGNEE_CHATROOM = "//*[@id='assigne-chatroom']";
    private final String INPUT_CHAT = "//*[@id='inputChat']";
    private final String BTN_SEND = "//*[@id='chatbody_chatcontent_btn_sendmessage']";
    private final String BUBBLE_CHAT_OWN = "//*[@class='ChatContent_Own']";
    private final String BUBBLE_CHAT_OTHER = "//*[@class='ChatContent_Other']";
    private final String BUBBLE_CHAT_INFO_ICON = "//*[local-name()='svg']/*[local-name()='path']";
    private final String POPUP_ADD_NOTE = "//*[@class='NoteRecord']";
    private final String POPUP_ADD_NOTE_TABLE_ROW = "//*[@class='NoteRecord']//*[@class='Note']";
    private final String POPUP_EDITED_CONTACT = "//*[@class='ContactRecord']";
    private final String POPUP_EDITED_CONTACT_TABLE_ROW = "//*[@class='ContactRecord']//*[@class='Item']";

    private final String BTN_EMOJI = "//*[@id='chatbody_chatcontent_btn_insertemoji']";
    private final String EMOJI_WANTED = "//img[@alt='grinning']";
    private final String BTN_ATTACH = "//*[@id='chatbody_chatcontent_btn_insertfile']";
    private final String BTN_ATTACH_IMAGE = "//*[@id='chatbody_chatcontent_btn_inputimage']";
    private final String BTN_ATTACH_FILE = "//*[@id='chatbody_chatcontent_btn_inputdocument']";
    private final String UPLOAD_IMAGE = "//*[@id='inputFileImage']";
    private final String UPLOAD_FILE = "//*[@id='inputFileDocument']";
    private final String IMAGE_PREVIEW = "//*[@class='imgPreview']//div[@class='center']//img";
    private final String IMAGE_PREVIEW_ICONS = "//*[@class='changeImge_item']";
    private final String IMAGE_PREVIEW_INPUT_CHAT = "//*[@class='imgPreview']//div[@class='bottom']//textarea";
    private final String IMAGE_PREVIEW_BTN_SEND = "//*[@class='imgPreview']//div[@class='bottom']/button";
    private final String BTN_ATTACH_PLUS_ICON = "//*[@class='imgPreview']//div[@class='left']//button[2]";
    private final String CONTACT_LIST_TABLE_CONTACT_NUMBER = "//*[contains(@id,'btn_edit_nowa')]";
    private final String CONTACT_LIST_TABLE_CONTACT_NAME = "//*[contains(@id,'btn_editname')]";

    private WebDriver driver;
    private WebDriverWait wait;

    public ChatPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(120));
    }

    public void goToChatPage() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id(BUTTON_INBOX)));
        WebElement element = driver.findElement(By.id(BUTTON_INBOX));
        element.click();
    }

    public void validateContactChatting(String[] chatTo, String[] chatFrom) {
        String xpath = String.format(BTN_OPEN_CHAT, chatFrom[0], chatTo[0]);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        WebElement element = driver.findElement(By.xpath(xpath));
        element.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CHAT_USER_TAB_PROFILE_DETAIL)));
        WebElement profileDetail = driver.findElement(By.xpath(CHAT_USER_TAB_PROFILE_DETAIL + "/p"));
        assert profileDetail.getText().equals(chatTo[1]) : "actual: " + profileDetail.getText() + " expected: " + chatTo[1];

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CHAT_USER_TAB_USER_DETAIL_WA)));
        WebElement userDetail = driver.findElement(By.xpath(CHAT_USER_TAB_USER_DETAIL_WA));
        assert userDetail.getText().contains(chatFrom[1]) : "actual: " + userDetail.getText() + " expected: " + chatFrom[1];
    }

    public void validateChatroomIsHandledBy(String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ASSIGNEE_CHATROOM)));
        WebElement element = driver.findElement(By.xpath(ASSIGNEE_CHATROOM));
        assert element.getText().equals(text) : "actual: " + element.getText() + " expected: " + text;
    }

    public void clickAndInputChat(String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(INPUT_CHAT)));
        WebElement element = driver.findElement(By.xpath(INPUT_CHAT));
        element.click();
        element.sendKeys(text);
    }

    public void clickSendButton() {
        try {
            new WebDriverWait(this.driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(By.xpath(BTN_SEND)));
            WebElement element = driver.findElement(By.xpath(BTN_SEND));
            element.click();
        } catch (Exception e) {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IMAGE_PREVIEW_BTN_SEND)));
            WebElement element = driver.findElement(By.xpath(IMAGE_PREVIEW_BTN_SEND));
            element.click();
        }
    }

    public void validateMessageIsSend(String message, String user) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(BUBBLE_CHAT_OWN)));

        int i = 0;

        List<WebElement> txtMessages = driver.findElements(By.xpath(BUBBLE_CHAT_OWN + "/p[@class='text']"));
        for (WebElement txtMessage : txtMessages) {
            if (txtMessage.getText().contains(message)) {
                i++;
                break;
            }
        }

        List<WebElement> txtNames = driver.findElements(By.xpath(BUBBLE_CHAT_OWN + "/p[@class='name']"));
        for (WebElement txtName : txtNames) {
            if (txtName.getText().contains(user)) {
                i += 2;
                break;
            }
        }

        switch (i) {
            case 0:
                assert false : "There is no message with text: " + message + " and user: " + user;
                break;
            case 1:
                assert false : "There is no user: " + user;
                break;
            case 2:
                assert false : "There is no message with text: " + message;
                break;
            case 3:
                assert true;
                break;
        }
    }

    public void clickAttachButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BTN_ATTACH)));
        WebElement element = driver.findElement(By.xpath(BTN_ATTACH));
        element.click();
    }

    public void clickEmojiButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BTN_EMOJI)));
        WebElement element = driver.findElement(By.xpath(BTN_EMOJI));
        element.click();
    }

    public void clickAttachImage() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BTN_ATTACH_IMAGE)));
    }

    public void clickAttachFile() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BTN_ATTACH_FILE)));
    }

    public void uploadImage() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(UPLOAD_IMAGE)));
        } catch (Exception e) {
            clickAttachButton();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(UPLOAD_IMAGE)));
        }
        WebElement element = driver.findElement(By.xpath(UPLOAD_IMAGE));

        File file = new File(
                "src" + File.separator + "test" + File.separator +
                        "resources" + File.separator + "blank-image.png");
        element.sendKeys(file.getAbsolutePath());
    }

    public void uploadFile() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(UPLOAD_FILE)));
        } catch (Exception e) {
            clickAttachButton();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(UPLOAD_FILE)));
        }
        WebElement element = driver.findElement(By.xpath(UPLOAD_FILE));

        File file = new File(
                "src" + File.separator + "test" + File.separator +
                        "resources" + File.separator + "blank-file.pdf");
        element.sendKeys(file.getAbsolutePath());
    }

    public void validateImageIsAdded() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(IMAGE_PREVIEW)));
        WebElement element = driver.findElement(By.xpath(IMAGE_PREVIEW));
        assert element.isDisplayed() : "actual: " + element.isDisplayed() + " expected: " + true;
    }

    public void validateFileIsAdded() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(IMAGE_PREVIEW)));
        WebElement element = driver.findElement(By.xpath(IMAGE_PREVIEW));
        assert element.isDisplayed() : "actual: " + element.isDisplayed() + " expected: " + true;
    }

    public void validateAttachIconIsChanged() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BTN_ATTACH_PLUS_ICON)));
    }

    public void inputCaption(String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(IMAGE_PREVIEW_INPUT_CHAT)));
        WebElement element = driver.findElement(By.xpath(IMAGE_PREVIEW_INPUT_CHAT));
        element.click();
        element.sendKeys(text);
    }

    public void validateImageIsAddedInOrder(int number) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(IMAGE_PREVIEW_ICONS)));
        List<WebElement> elements = driver.findElements(By.xpath(IMAGE_PREVIEW_ICONS));

        assert elements.size() == number : "actual: " + elements.size() + " expected: " + number;
    }

    public void validateFileIsAddedInOrder(int number) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(IMAGE_PREVIEW_ICONS)));
        List<WebElement> elements = driver.findElements(By.xpath(IMAGE_PREVIEW_ICONS));

        assert elements.size() == number : "actual: " + elements.size() + " expected: " + number;
    }

    public void inputCaptionInOrder(int number, String text) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(IMAGE_PREVIEW_ICONS)));
        List<WebElement> elements = driver.findElements(By.xpath(IMAGE_PREVIEW_ICONS));
        elements.get(number-1).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(IMAGE_PREVIEW_INPUT_CHAT)));
        WebElement element = driver.findElement(By.xpath(IMAGE_PREVIEW_INPUT_CHAT));
        element.click();
        element.sendKeys(text);
    }

    public void validateImageIsSendWithCaption(String text) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(BUBBLE_CHAT_OWN)));

        int i = 0;

        List<WebElement> txtMessages = driver.findElements(By.xpath(BUBBLE_CHAT_OWN + "/p[@class='text']"));
        for (WebElement txtMessage : txtMessages) {

            new Actions(driver)
                    .scrollToElement(txtMessage)
                    .pause(500)
                    .perform();

            if (txtMessage.getText().contains(text)) {
                String id = txtMessage.getAttribute("id");
                String xpath = String.format(BUBBLE_CHAT_OWN + "/p[@id='%s']/preceding-sibling::button[contains(@class, 'image')]", id);
                WebElement image = driver.findElement(By.xpath(xpath));
                assert image.isDisplayed() : "actual: " + image.isDisplayed() + " expected: " + true;
                i++;
                break;
            }
        }

        assert i == 1;
    }


    public void validateFileIsSendWithCaption(String text) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(BUBBLE_CHAT_OWN)));

        int i = 0;

        List<WebElement> txtMessages = driver.findElements(By.xpath(BUBBLE_CHAT_OWN + "/p[@class='text']"));
        for (WebElement txtMessage : txtMessages) {

            new Actions(driver)
                    .scrollToElement(txtMessage)
                    .pause(500)
                    .perform();

            if (txtMessage.getText().contains(text)) {
                String id = txtMessage.getAttribute("id");
                String xpath = String.format(BUBBLE_CHAT_OWN + "/p[@id='%s']/preceding-sibling::button[contains(@class, 'document')]", id);
                WebElement image = driver.findElement(By.xpath(xpath));
                assert image.isDisplayed() : "actual: " + image.isDisplayed() + " expected: " + true;
                i++;
                break;
            }
        }

        assert i == 1;
    }

    public void chooseWantedEmoji() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EMOJI_WANTED)));
        WebElement element = driver.findElement(By.xpath(EMOJI_WANTED));
        element.click();

        clickEmojiButton();
    }

    public void clickMenuContact() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id(BUTTON_CONTACT)));
        WebElement element = driver.findElement(By.id(BUTTON_CONTACT));
        element.click();
    }

    public void validateContactIsSaved(String[] textArray) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(CONTACT_LIST_TABLE_CONTACT_NUMBER)));
        List<WebElement> contactNumbers = driver.findElements(By.xpath(CONTACT_LIST_TABLE_CONTACT_NUMBER));
        assert contactNumbers.stream().anyMatch(f -> f.getText().equals(textArray[0]));

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(CONTACT_LIST_TABLE_CONTACT_NAME)));
        List<WebElement> contactName = driver.findElements(By.xpath(CONTACT_LIST_TABLE_CONTACT_NAME));
        assert contactName.stream().anyMatch(f -> f.getText().equals(textArray[1]));
    }

    public void clickAddTagButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id(BUTTON_ADD_TAG)));
        WebElement element = driver.findElement(By.id(BUTTON_ADD_TAG));
        element.click();
    }

    public void inputTag(String text) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CHAT_USER_TAB_INPUT_TAG)));
        WebElement element = driver.findElement(By.xpath(CHAT_USER_TAB_INPUT_TAG));
        element.click();
        element.sendKeys(text);
    }

    public void clickCreateNewTag() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CHAT_USER_TAB_INPUT_TAG)));
        WebElement element = driver.findElement(By.xpath(CHAT_USER_TAB_INPUT_TAG));
        element.sendKeys(Keys.ENTER);
    }

    public void validateTagIsAdded(String tag, String[] textArray) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(CHAT_USER_TAB_TAG_LIST)));
        List<WebElement> tags = driver.findElements(By.xpath(CHAT_USER_TAB_TAG_LIST));
        assert tags.stream().anyMatch(f -> f.getText().equals(tag));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CHAT_USER_TAB_PROFILE_DETAIL)));
        WebElement name = driver.findElement(By.xpath(CHAT_USER_TAB_PROFILE_DETAIL + "/p"));
        assert name.getText().equals(textArray[1]) : "actual 1: " + name.getText() + " expected: " + textArray[1];

        WebElement number = driver.findElement(By.xpath(CHAT_USER_TAB_PROFILE_DETAIL + "/h4"));
        assert number.getText().equals("+" + textArray[0]) : "actual 2: " + number.getText() + " expected: +" + textArray[0];
    }

    public void validateTagIsShowInMiddleChatroom(String text) {
        if (text.equals("MM/dd/yyyy HH:mm - New Session ID Created")) {
            text = "^\\d{2}/\\d{2}/\\d{4} \\d{2}:\\d{2}\n-\nNew Session ID \\d+ Created$";

            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(BUBBLE_CHAT_OTHER + "//*[@class='Center']")));
            List<WebElement> elements = driver.findElements(By.xpath(BUBBLE_CHAT_OTHER + "//*[@class='Center']"));
            Pattern pattern = Pattern.compile(text);
            boolean isValid = pattern.matcher(elements.get(elements.size() - 1).getText()).matches();
            assert isValid : "actual: " + elements.get(elements.size() - 1).getText() + " expected: " + text;
            return;
        } else if (text.equals("MM/dd/yyyy HH:mm - Session ID Expired")) {
            text = "^\\d{2}/\\d{2}/\\d{4} \\d{2}:\\d{2}\n-\nSession ID \\d+ Expired$";

            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(BUBBLE_CHAT_OTHER + "//*[@class='Center']")));
            List<WebElement> elements = driver.findElements(By.xpath(BUBBLE_CHAT_OTHER + "//*[@class='Center']"));
            Pattern pattern = Pattern.compile(text);
            boolean isValid = pattern.matcher(elements.get(elements.size() - 1).getText()).matches();
            assert isValid : "actual: " + elements.get(elements.size() - 1).getText() + " expected: " + text;
            return;
        } else if (text.equals("MM/dd/yyyy HH:mm - Closed Session ID")) {
            text = "^\\d{2}/\\d{2}/\\d{4} \\d{2}:\\d{2}\n-\nClosed Session ID \\d+$";

            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(BUBBLE_CHAT_OTHER + "//*[@class='Center']")));
            List<WebElement> elements = driver.findElements(By.xpath(BUBBLE_CHAT_OTHER + "//*[@class='Center']"));
            Pattern pattern = Pattern.compile(text);
            boolean isValid = pattern.matcher(elements.get(elements.size() - 1).getText()).matches();
            assert isValid : "actual: " + elements.get(elements.size() - 1).getText() + " expected: " + text;
            return;
        }

        String[] textArray = text.split(" ");
        List<WebElement> tags;

        if (text.contains("Edited") || text.contains("Updated")) {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(BUBBLE_CHAT_OTHER + "//button")));
            tags = driver.findElements(By.xpath(BUBBLE_CHAT_OTHER + "//button"));
        } else {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(BUBBLE_CHAT_OTHER)));
            tags = driver.findElements(By.xpath(BUBBLE_CHAT_OTHER));
        }

        boolean done = false;

        for (WebElement tag : tags) {

            new Actions(driver)
                    .scrollToElement(tag)
                    .pause(500)
                    .perform();

            String elementTag = tag.getText();
            boolean containsAll = true;
            for (String s : textArray) {
                if (!elementTag.contains(s)) {
                    containsAll = false;
                    break;
                }
            }
            if (containsAll) {
                done = true;
                break;
            }
        }

        assert done : "actual: " + done + " expected: " + true;
    }



    public void clickExpandNotes() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CHAT_USER_TAB_NOTES)));
        WebElement element = driver.findElement(By.xpath(CHAT_USER_TAB_NOTES));
        element.click();
    }

    public void inputNotes(String text) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CHAT_USER_TAB_ADD_NOTE)));
        WebElement element = driver.findElement(By.xpath(CHAT_USER_TAB_ADD_NOTE));
        element.click();
        element.clear();
        element.sendKeys(text);

        Thread.sleep(2000);
    }

    public void validateNotesIsAdded(String text) throws InterruptedException {
        Thread.sleep(3000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CHAT_USER_TAB_NOTES)));
        WebElement element = driver.findElement(By.xpath(CHAT_USER_TAB_NOTES));
        element.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CHAT_USER_TAB_ADD_NOTE)));
        WebElement note = driver.findElement(By.xpath(CHAT_USER_TAB_ADD_NOTE));
        assert note.getText().equals(text) : "actual: " + note.getText() + " expected: " + text;
    }

    public void clickInfoIcon() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(BUBBLE_CHAT_OTHER + BUBBLE_CHAT_INFO_ICON)));
        List<WebElement> infoIcon = driver.findElements(By.xpath(BUBBLE_CHAT_OTHER + BUBBLE_CHAT_INFO_ICON));

        new Actions(driver).
                moveToElement(infoIcon.get(infoIcon.size() - 2))
                .click()
                .build().perform();
    }

    public void validatePopUpAddedNotes() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(POPUP_ADD_NOTE)));
    }

    public void validateTableHasColumnFromAndTo(List<Map<String, String>> list) {
        for (Map<String, String> map : list) {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(POPUP_ADD_NOTE_TABLE_ROW + "//*[@class='Left']")));
            WebElement from = driver.findElement(By.xpath(POPUP_ADD_NOTE_TABLE_ROW + "//*[@class='Left']"));
            assert from.getText().equals(map.get("From")) : "actual: " + from.getText() + " expected: " + map.get("From");

            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(POPUP_ADD_NOTE_TABLE_ROW + "//*[@class='Right']")));
            WebElement to = driver.findElement(By.xpath(POPUP_ADD_NOTE_TABLE_ROW + "//*[@class='Right']"));
            assert to.getText().equals(map.get("To")) : "actual: " + to.getText() + " expected: " + map.get("To");
        }
    }

    public void clickToggleImportant() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CHAT_USER_TAB_NOTES_TOGGLE_IMPORTANT)));
        WebElement element = driver.findElement(By.xpath(CHAT_USER_TAB_NOTES_TOGGLE_IMPORTANT));

        if (element.getAttribute("src").contains("Switch-on")) {
            return;
        }

        element.click();
    }

    public void validateNotesIsHighlighted() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CHAT_USER_TAB_NOTES_TITLE)));
        WebElement element = driver.findElement(By.xpath(CHAT_USER_TAB_NOTES_TITLE));

        String elementColor = Color.fromString(element.getCssValue("color")).asRgba();
        assert elementColor.equals("rgba(101, 98, 223, 1)") : "actual: " + element.getCssValue("color") + " expected: rgba(101, 98, 223, 1)";
    }

    public void validateDetailChatSessionShowsInformation(List<Map<String, String>> list) {

        List<WebElement> a = driver.findElements(By.xpath("//*[@class='ChatUser_Detail']/div"));

        for (int i = 2; i <= a.size(); i++) {
            WebElement key = driver.findElement(By.xpath("//*[@class='ChatUser_Detail']/div[" + i + "]/*[contains(@class,'detailLeft')]"));
            WebElement value = driver.findElement(By.xpath("//*[@class='ChatUser_Detail']/div[" + i + "]/*[contains(@class,'detailRight')]"));

            if ((i==4 || i==5 || i==6) && !list.get(0).get(key.getText()).equals("-")) {
                assert Utils.validateDate(value.getText(), list.get(0).get(key.getText()));
            } else {
                assert value.getText().contains(list.get(0).get(key.getText())) : "actual: " + value.getText() + " expected: " + list.get(0).get(key.getText());
            }
        }
    }

    public void clickMenuSetting() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id(BUTTON_SETTING)));
        WebElement element = driver.findElement(By.id(BUTTON_SETTING));
        element.click();
    }

    public void validatePhotoProfileIsHighlighted(String color) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PROFILE_SIDEBAR_ACTIVE_BORDER)));
        WebElement element = driver.findElement(By.xpath(PROFILE_SIDEBAR_ACTIVE_BORDER));

        switch (color) {
            case "blue":
                assert element.getAttribute("class").contains("avatar-border-ongoing") : "actual: " + element.getAttribute("class") + " expected: avatar-border-ongoing";
                break;
            case "yellow":
                assert element.getAttribute("class").contains("avatar-border-warning") : "actual: " + element.getAttribute("class") + " expected: avatar-border-warning";
                break;
            case "red":
                assert element.getAttribute("class").contains("avatar-border-danger") : "actual: " + element.getAttribute("class") + " expected: avatar-border-danger";
                break;
            case "none":
                assert element.getAttribute("class").contains("avatar") : "actual: " + element.getAttribute("class") + " expected: avatar";
                break;
        }

    }

    public void clickButtonCloseSession() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BUTTON_CLOSE_SESSION)));
        WebElement element = driver.findElement(By.xpath(BUTTON_CLOSE_SESSION));
        element.click();

        new Actions(driver).pause(2000).perform();
    }

    public void clickButtonEditInfoContact() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CHAT_USER_TAB_BUTTON_EDIT_INFO_CONTACT)));
        WebElement element = driver.findElement(By.xpath(CHAT_USER_TAB_BUTTON_EDIT_INFO_CONTACT));
        element.click();
    }

    public void validateRedirectToEditInfoContact() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(EDIT_INFO_CONTACT_TAB_HEADER)));
        WebElement element = driver.findElement(By.xpath(EDIT_INFO_CONTACT_TAB_HEADER));
        assert element.getText().equals("Edit Info Contact") : "actual: " + element.getText() + " expected: Edit Info Contact";
    }

    public void inputContactName(String text) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(EDIT_INFO_CONTACT_TAB_CONTACT_NAME)));
        WebElement element = driver.findElement(By.xpath(EDIT_INFO_CONTACT_TAB_CONTACT_NAME));

        new Actions(driver).scrollToElement(element).build().perform();

        element.clear();
        element.sendKeys(text);
    }

    public void inputBirth(String text) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(EDIT_INFO_CONTACT_TAB_BIRTH)));
        WebElement element = driver.findElement(By.xpath(EDIT_INFO_CONTACT_TAB_BIRTH));

        new Actions(driver)
                .scrollToElement(element)
                .click()
                .pause(500)
                .build().perform();

        element.sendKeys(Keys.CONTROL, "a");
        element.sendKeys(Keys.DELETE);
        new Actions(driver).pause(1000).perform();
        element.sendKeys(text);
        element.sendKeys(Keys.ENTER);

        Point coordinates = element.getLocation();

        new Actions(driver)
                .moveToLocation(coordinates.getX(), coordinates.getY() + 100)
                .click()
                .pause(1000)
                .build().perform();
    }

    public void inputCountry(String text) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(EDIT_INFO_CONTACT_TAB_COUNTRY)));
        WebElement element = driver.findElement(By.xpath(EDIT_INFO_CONTACT_TAB_COUNTRY));

        element.clear();
        element.sendKeys(text);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(EDIT_INFO_CONTACT_TAB_SELECT_COUNTRY)));
        WebElement select = driver.findElement(By.xpath(EDIT_INFO_CONTACT_TAB_SELECT_COUNTRY));

        select.click();
    }

    public void inputProvince(String text) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(EDIT_INFO_CONTACT_TAB_PROVINCE)));
        WebElement element = driver.findElement(By.xpath(EDIT_INFO_CONTACT_TAB_PROVINCE));

        element.clear();
        element.sendKeys(text);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(EDIT_INFO_CONTACT_TAB_SELECT_PROVINCE)));
        WebElement select = driver.findElement(By.xpath(EDIT_INFO_CONTACT_TAB_SELECT_PROVINCE));

        select.click();
    }

    public void inputCity(String text) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(EDIT_INFO_CONTACT_TAB_CITY)));
        WebElement element = driver.findElement(By.xpath(EDIT_INFO_CONTACT_TAB_CITY));

        element.clear();
        element.sendKeys(text);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(EDIT_INFO_CONTACT_TAB_SELECT_CITY)));
        WebElement select = driver.findElement(By.xpath(EDIT_INFO_CONTACT_TAB_SELECT_CITY));

        select.click();
    }

    public void inputAddress(String text) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(EDIT_INFO_CONTACT_TAB_ADDRESS)));
        WebElement element = driver.findElement(By.xpath(EDIT_INFO_CONTACT_TAB_ADDRESS));

        element.clear();
//        element.sendKeys(text);
    }

    public void inputPostalCode(String text) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(EDIT_INFO_CONTACT_TAB_POSTAL_CODE)));
        WebElement element = driver.findElement(By.xpath(EDIT_INFO_CONTACT_TAB_POSTAL_CODE));

        element.clear();
//        element.sendKeys(text);
    }

    public void clickButtonSave() {
        new Actions(driver).pause(5000).perform();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EDIT_INFO_CONTACT_TAB_BUTTON_SAVE)));
        WebElement element = driver.findElement(By.xpath(EDIT_INFO_CONTACT_TAB_BUTTON_SAVE));
        element.click();

        new Actions(driver).pause(2000).perform();
    }

    public void validateRedirectToDetailChatRoom() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(EDIT_INFO_CONTACT_TAB_HEADER)));
    }

    public void validatePopUpEditedContact() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(POPUP_EDITED_CONTACT)));
    }

    public void validateTableHasColumnActivityFromAndTo(List<Map<String, String>> list) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(POPUP_EDITED_CONTACT_TABLE_ROW)));
        List<WebElement> elements = driver.findElements(By.xpath(POPUP_EDITED_CONTACT_TABLE_ROW));

        for (int i=0; i<elements.size(); i++) {
            WebElement from = driver.findElement(By.xpath(POPUP_EDITED_CONTACT_TABLE_ROW + "[" + (i+1) + "]//*[@class='Center']"));
            new Actions(driver).scrollToElement(from).build().perform();
            assert from.getText().equals(list.get(i).get("From")) : "actual: " + from.getText() + " expected: " + list.get(i).get("From");

            WebElement to = driver.findElement(By.xpath(POPUP_EDITED_CONTACT_TABLE_ROW + "[" + (i+1) + "]//*[@class='Right']"));
            new Actions(driver).scrollToElement(to).build().perform();
            assert to.getText().equals(list.get(i).get("To")) : "actual: " + to.getText() + " expected: " + list.get(i).get("To");
        }

    }

    public void clickButtonCheck() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BUTTON_CHECK)));
        WebElement element = driver.findElement(By.xpath(BUTTON_CHECK));
        element.click();
    }

    public void checkChatroom(String[] textArray) {
        for (String s: textArray) {
            String xpath = String.format(BTN_OPEN_CHAT, "6282213288475", s);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            WebElement element = driver.findElement(By.xpath(xpath));
            element.click();
        }
    }

    public void clickButtonMore() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BUTTON_MORE)));
        WebElement element = driver.findElement(By.xpath(BUTTON_MORE));
        element.click();
    }

    public void clickButtonTaggingAllSelected() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BUTTON_TAGGING_ALL_SELECTED)));
        WebElement element = driver.findElement(By.xpath(BUTTON_TAGGING_ALL_SELECTED));
        element.click();
    }

    public void validatePopUpTaggingAllSelected() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(POPUP_TAGGING_ALL_SELECTED)));
    }

    public void inputFieldSearchTagOnTaggingAllSelected(String text) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(POPUP_TAGGING_ALL_SELECTED_INPUT_TAG)));
        WebElement element = driver.findElement(By.xpath(POPUP_TAGGING_ALL_SELECTED_INPUT_TAG));
        element.click();
        element.sendKeys(text);
        element.sendKeys(Keys.ENTER);
    }

    public void inputFieldSearchTagOnNotesAllSelected(String text) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(POPUP_NOTES_ALL_SELECTED_INPUT_TAG)));
        WebElement element = driver.findElement(By.xpath(POPUP_NOTES_ALL_SELECTED_INPUT_TAG));
        element.click();
        element.sendKeys(text);
    }

    public void clickButtonAddTagging() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(POPUP_TAGGING_ALL_SELECTED_BUTTON_ADD_TAG)));
        WebElement element = driver.findElement(By.xpath(POPUP_TAGGING_ALL_SELECTED_BUTTON_ADD_TAG));
        element.click();

        new Actions(driver).pause(10000).perform();
    }

    public void clickButtonNotesAllSelected() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BUTTON_NOTES_ALL_SELECTED)));
        WebElement element = driver.findElement(By.xpath(BUTTON_NOTES_ALL_SELECTED));
        element.click();
    }

    public void validatePopUpNotesAllSelected() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(POPUP_NOTES_ALL_SELECTED)));
    }


    public void clickToggleImportantNote() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(POPUP_NOTES_ALL_SELECTED_BUTTON_IMPORTANT)));
        WebElement element = driver.findElement(By.xpath(POPUP_NOTES_ALL_SELECTED_BUTTON_IMPORTANT));
        element.click();
    }

    public void clickButtonAddNotes() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(POPUP_NOTES_ALL_SELECTED_BUTTON_ADD_NOTES)));
        WebElement element = driver.findElement(By.xpath(POPUP_NOTES_ALL_SELECTED_BUTTON_ADD_NOTES));
        element.click();

        new Actions(driver).pause(10000).perform();
    }

    public void clickButtonFilter() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BUTTON_FILTER)));
        WebElement element = driver.findElement(By.xpath(BUTTON_FILTER));
        element.click();
    }

    public void tickSession(List<String> textArray) {
        List<String> sessions = new ArrayList<>(Arrays.asList("ongoing", "pending", "expired", "expiredunanswered", "expiredpending", "closesession"));
        textArray = textArray.stream()
                .map(String::toLowerCase)
                .map(s -> s.replace(" ", ""))
                .collect(Collectors.toList());

        for (String s: sessions) {
            String xpath;
            try {
                xpath = String.format(FILTER_SESSION, s);
                new WebDriverWait(this.driver, Duration.ofSeconds(1)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            } catch (Exception e) {
                try {
                    xpath = String.format(CHAT_TABS_SESSION, s);
                    new WebDriverWait(this.driver, Duration.ofSeconds(1)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
                } catch (Exception f) {
                    xpath = String.format(EDIT_CHAT_TABS_SESSION, s);
                    new WebDriverWait(this.driver, Duration.ofSeconds(1)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
                }
            }
            WebElement checkbox = driver.findElement(By.xpath(xpath + "/preceding-sibling::input"));

            if (textArray.stream().anyMatch(f -> f.equals(s))) {
                if (!checkbox.isSelected()) {
                    checkbox.click();
                }
            } else {
                if (checkbox.isSelected()) {
                    checkbox.click();
                }
            }
        }
    }

    public void chooseFormUserName(String text) {
        WebElement element;
        try {
            new WebDriverWait(this.driver, Duration.ofSeconds(1)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(FILTER_USERNAME)));
            element = driver.findElement(By.xpath(FILTER_USERNAME));
        } catch (Exception e) {
            new WebDriverWait(this.driver, Duration.ofSeconds(1)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(CHAT_TABS_USERNAME)));
            element = driver.findElement(By.xpath(CHAT_TABS_USERNAME));
        }
        element.sendKeys(Keys.BACK_SPACE);
        element.sendKeys(Keys.BACK_SPACE);
        element.sendKeys(Keys.BACK_SPACE);
        element.sendKeys(text);

        WebElement selected;
        try {
            new WebDriverWait(this.driver, Duration.ofSeconds(1)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(FILTER_USERNAME_SELECTED)));
            selected = driver.findElement(By.xpath(FILTER_USERNAME_SELECTED));
        } catch (Exception e) {
            new WebDriverWait(this.driver, Duration.ofSeconds(1)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(CHAT_TABS_USERNAME_SELECTED)));
            selected = driver.findElement(By.xpath(CHAT_TABS_USERNAME_SELECTED));
        }
        selected.click();
        element.click();
    }

    public void clickButtonApplyFilter() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(FILTER_BUTTON_APPLY)));
        WebElement element = driver.findElement(By.xpath(FILTER_BUTTON_APPLY));
        element.click();

        new Actions(driver).pause(2000).perform();
    }

    public void validateChatroomOnChatboxWillBeFiltered(String text) {
        switch (text) {
            case "filter":
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='L']")));
                WebElement l = driver.findElement(By.xpath("//*[@class='L']"));
                assert l.getText().contains("Filter result: ") : "actual: " + l.getText() + " expected: Filter result: ";

                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='R ']")));
                WebElement r = driver.findElement(By.xpath("//*[@class='R ']"));
                assert r.getText().contains("Reset Filter") : "actual: " + r.getText() + " expected: Reset Filter";
                break;
            case "tab":
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='L']")));
                WebElement l1 = driver.findElement(By.xpath("//*[@class='L']"));
                assert l1.getText().contains("Chat Tab result: ") : "actual: " + l1.getText() + " expected: Chat Tab result: ";

                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='R R_Black']")));
                WebElement r1 = driver.findElement(By.xpath("//*[@class='R R_Black']"));
                assert r1.getText().contains("Close") : "actual: " + r1.getText() + " expected: Close";
                break;
        }

    }

    public void clickButtonAddNewChatTabs() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BUTTON_ADD_NEW_CHAT_TABS)));
        WebElement element = driver.findElement(By.xpath(BUTTON_ADD_NEW_CHAT_TABS));
        element.click();
    }

    public void inputFormChatTabsName(String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CHAT_TABS_NAME)));
        WebElement element = driver.findElement(By.xpath(CHAT_TABS_NAME));
        element.clear();
        element.sendKeys(text);
    }

    public void clickButtonCreateChatTabs() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CHAT_TABS_BUTTON_CREATE_CHAT_TABS)));
        WebElement element = driver.findElement(By.xpath(CHAT_TABS_BUTTON_CREATE_CHAT_TABS));
        element.click();

        new Actions(driver).pause(2000).perform();
    }

    public void validateOnChatTabsWillAddedNewTab(String text) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(CHAT_TABS_NEW_TABS)));
        List<WebElement> elements = driver.findElements(By.xpath(CHAT_TABS_NEW_TABS));
        assert elements.stream().anyMatch(f -> f.getText().equals(text));
    }

    public void clickTab(String text) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(CHAT_TABS_NEW_TABS)));
        List<WebElement> elements = driver.findElements(By.xpath(CHAT_TABS_NEW_TABS));

        for (WebElement e : elements) {
            if (e.getText().equals(text)) {
                e.click();
                break;
            }
        }
    }

    public void clickTabDropdown(String text) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(CHAT_TABS_NEW_TABS)));
        List<WebElement> elements = driver.findElements(By.xpath(CHAT_TABS_NEW_TABS));

        for (WebElement e : elements) {
            if (e.getText().equals(text)) {
                String id = e.getAttribute("id");
                WebElement element = driver.findElement(By.xpath("//*[@id='" + id + "']/following-sibling::button"));
                element.click();
                break;
            }
        }
    }

    public void clickButtonEditChatTabs() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CHAT_TABS_NEW_TABS_DROPDOWN_EDIT)));
        WebElement element = driver.findElement(By.xpath(CHAT_TABS_NEW_TABS_DROPDOWN_EDIT));
        element.click();
    }

    public void clickButtonSaveChatTabs() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EDIT_CHAT_TABS_BUTTON_SAVE)));
        WebElement element = driver.findElement(By.xpath(EDIT_CHAT_TABS_BUTTON_SAVE));
        element.click();

        new Actions(driver).pause(2000).perform();
    }
}
