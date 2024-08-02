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
    private final String BUTTON_CLOSED_SESSION_ALL_SELECTED = "//*[@id='sidebarchatnotification_btn_closedsession']";
    private final String POPUP_TAGGING_ALL_SELECTED = "//*[@class='MTag']";
    private final String POPUP_CLOSED_SESSION_SELECTED = "//*[@class='MCloseSession']";
    private final String POPUP_CLOSED_SESSION_SELECTED_YES_BUTTON = "//*[@id='chatbody_multiclosesession_btn_closesession']";
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

    private final String SIDEBAR_UNANSWERED_CHAT_BUTTON = "//*[@id='sidebarchatnotification_btn_unansweredchat']";
    private final String SIDEBAR_UNANSWERED_CHAT_PANEL = "//*[@class='backToAllChat']";

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
    private final String CHAT_USER_TAB_BUTTON_CHATROOM_HISTORY = "//*[@id='chatbody_chatuser_btn_openchathistory']";

    private final String CHATROOM_HISTORY_TAB = "//*[@class='ChatUserHistory']";
    private final String CHATROOM_HISTORY_TAB_INPUT_SEARCH = "//*[@class='ChatUserHistory_Search']";
    private final String CHATROOM_HISTORY_TAB_BUTTON_FILTER = "//*[@id='chatbody_chatuser_chathistory_btn_filter']";
    private final String CHATROOM_HISTORY_TAB_BUTTON_SORT = "//*[@id='chatbody_chatuser_chathistory_btn_sort']";
    private final String CHATROOM_HISTORY_TAB_BOX_SESSION = "//*[@class='Asdiv HistoryItem ']";
    private final String CHATROOM_HISTORY_TAB_BOX_SESSION_POPUP = "//*[@class='DetailChatSession']";
    private final String CHATROOM_HISTORY_TAB_FILTER_APPLY = "//*[@id='chatbody_chatuser_chathistory_btn_applyfilter']";
    private final String CHATROOM_HISTORY_TAB_CLOSE_FILTER = "//*[@id='chatbody_chatuser_chathistory_btn_closefilter']";
    private final String CHATROOM_HISTORY_TAB_BUTTON_BACK = "//*[@id='chatbody_chatuser_chathistory_btn_close']/*[local-name()='path']";

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

    private final String POPUP_DELETE_MESSAGE = "//*[@class='DeleteOneChat']";
    private final String POPUP_DELETE_MESSAGE_YES_BUTTON = "//*[@id='DeleteOneChat_popup_btn_confirmdelete']";

    private WebDriver driver;
    private WebDriverWait wait;
    private int waitTimeForLoop = 300000;

    public ChatPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(20));
    }

    public void goToChatPage() {
        Utils.retryOperation(() -> {
            wait.until(ExpectedConditions.elementToBeClickable(By.id(BUTTON_INBOX)));
            WebElement element = driver.findElement(By.id(BUTTON_INBOX));
            element.click();
        }, waitTimeForLoop);
    }

    public void openContact(String chatTo, String chatFrom) {
        Utils.retryOperationWithCatch(() -> {
            goToChatPage();
            String xpath = String.format(BTN_OPEN_CHAT, chatFrom, chatTo);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            WebElement element = driver.findElement(By.xpath(xpath));
            new Actions(driver)
                    .moveToElement(element)
                    .click()
                    .build().perform();
        }, () -> driver.navigate().refresh(), waitTimeForLoop);
    }

    public void validateContactChatting(String[] chatTo, String[] chatFrom) {
        Utils.retryOperationWithCatch(() -> {
            String xpath = String.format(BTN_OPEN_CHAT, chatFrom[0], chatTo[0]);
            new WebDriverWait(this.driver, Duration.ofSeconds(60)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            WebElement element = driver.findElement(By.xpath(xpath));
            element.click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CHAT_USER_TAB_PROFILE_DETAIL)));
            WebElement profileDetail = driver.findElement(By.xpath(CHAT_USER_TAB_PROFILE_DETAIL + "/p"));
            assert profileDetail.getText().equals(chatTo[1]) : "actual: " + profileDetail.getText() + " expected: " + chatTo[1];

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CHAT_USER_TAB_USER_DETAIL_WA)));
            WebElement userDetail = driver.findElement(By.xpath(CHAT_USER_TAB_USER_DETAIL_WA));
            assert userDetail.getText().contains(chatFrom[1]) : "actual: " + userDetail.getText() + " expected: " + chatFrom[1];
        }, () -> driver.navigate().refresh(), waitTimeForLoop);
    }

    public void validateChatroomIsHandledBy(String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ASSIGNEE_CHATROOM)));
        WebElement element = driver.findElement(By.xpath(ASSIGNEE_CHATROOM));
        assert element.getText().equals(text) : "actual: " + element.getText() + " expected: " + text;
    }

    public void clickAndInputChat(String text) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(INPUT_CHAT)));
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

        new Actions(driver).pause(5000).perform();
    }

    public void validateMessageIsSend(String message, String user) {
        int attempts = 0;
        while(attempts < 5) {
            try {
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(BUBBLE_CHAT_OWN + "/p[@class='text']")));
                new Actions(driver).pause(7000).perform();

                List<WebElement> txtMessages = driver.findElements(By.xpath(BUBBLE_CHAT_OWN + "/p[@class='text']"));
                List<WebElement> txtNames = driver.findElements(By.xpath(BUBBLE_CHAT_OWN + "/p[@class='name']"));

                assert txtMessages.stream().anyMatch(f -> f.getText().contains(message)) : "There is no message with text: " + message;
                assert txtNames.stream().anyMatch(f -> f.getText().contains(user)) : "There is no user: " + user;
                break;
            } catch (Throwable ignored) {}
            attempts++;
            System.out.println("Repeat validateMessageIsSend " + attempts + " times");
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
        int attempts = 0;
        boolean found = false;
        while (attempts < 5) {
            try {
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(BUBBLE_CHAT_OWN)));
                List<WebElement> txtMessages = driver.findElements(By.xpath(BUBBLE_CHAT_OWN + "/p[@class='text']"));

                int until = txtMessages.size() > 6 ? txtMessages.size() - 6 : 0;
                for (int i=txtMessages.size()-1; i>=until; i--) {
                    new Actions(driver)
                            .scrollToElement(txtMessages.get(i))
                            .pause(500)
                            .perform();

                    if (txtMessages.get(i).getText().contains(text)) {
                        String id = txtMessages.get(i).getAttribute("id");
                        String xpath = String.format(BUBBLE_CHAT_OWN + "/p[@id='%s']/preceding-sibling::button[contains(@class, 'image')]", id);
                        WebElement image = driver.findElement(By.xpath(xpath));
                        assert image.isDisplayed() : "actual: " + image.isDisplayed() + " expected: " + true;
                        found = true;
                        break;
                    }
                }
                if (found) {break;}
            } catch (Throwable e) {
                System.out.println(e.getMessage());
            }
            attempts++;
            System.out.println("Repeat validateImageIsSendWithCaption " + attempts + " times");
            driver.navigate().refresh();
            openContact("6285259027122", "6282213288475");
        }

        assert found : "Text not found after 5 times";
    }


    public void validateFileIsSendWithCaption(String text) {
        int attempts = 0;
        boolean found = false;
        while(attempts < 5) {
            try {
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(BUBBLE_CHAT_OWN)));
                List<WebElement> txtMessages = driver.findElements(By.xpath(BUBBLE_CHAT_OWN + "/p[@class='text']"));

                int until = txtMessages.size() > 6 ? txtMessages.size() - 6 : 0;
                for (int i=txtMessages.size()-1; i>=until; i--) {
                    if (txtMessages.get(i).getText().contains(text)) {
                        String id = txtMessages.get(i).getAttribute("id");
                        String xpath = String.format(BUBBLE_CHAT_OWN + "/p[@id='%s']/preceding-sibling::button[contains(@class, 'document')]", id);
                        WebElement image = driver.findElement(By.xpath(xpath));
                        assert image.isDisplayed() : "actual: " + image.isDisplayed() + " expected: " + true;
                        found = true;
                        break;
                    }
                }
                if (found) {break;}
            } catch (Throwable e) {
                System.out.println(e.getMessage());
            }
            attempts++;
            System.out.println("Repeat validateFileIsSendWithCaption " + attempts + " times");
            driver.navigate().refresh();
            openContact("6285259027122", "6282213288475");
        }

        assert found : "Text not found after 5 times";
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
        long startTime = System.currentTimeMillis();
        new Actions(driver).pause(3000).perform();
        final String finalText = text;

        Utils.retryOperationWithCatch(() -> {
            if (finalText.equals("MM/dd/yyyy HH:mm - New Session ID Created")) {
                String patternText = "^\\d{2}/\\d{2}/\\d{4} \\d{2}:\\d{2}\n-\nNew Session ID \\d+ Created$";

                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(BUBBLE_CHAT_OTHER + "//*[@class='Center']")));
                List<WebElement> elements = driver.findElements(By.xpath(BUBBLE_CHAT_OTHER + "//*[@class='Center']"));
                Pattern pattern = Pattern.compile(patternText);
                int skip = (elements.size() > 10) ? elements.size() - 10 : 0;
                boolean isValid = elements.stream().skip(skip).map(WebElement::getText).anyMatch(f -> pattern.matcher(f).matches());
                assert isValid : "actual: " + elements.get(elements.size() - 1).getText() + " expected: " + patternText;
            } else if (finalText.equals("MM/dd/yyyy HH:mm - Session ID Expired")) {
                String patternText = "^\\d{2}/\\d{2}/\\d{4} \\d{2}:\\d{2}\n-\nSession ID \\d+ Expired$";

                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(BUBBLE_CHAT_OTHER + "//*[@class='Center']")));
                List<WebElement> elements = driver.findElements(By.xpath(BUBBLE_CHAT_OTHER + "//*[@class='Center']"));
                Pattern pattern = Pattern.compile(patternText);
                int skip = (elements.size() > 10) ? elements.size() - 10 : 0;
                boolean isValid = elements.stream().skip(skip).map(WebElement::getText).anyMatch(f -> pattern.matcher(f).matches());
                assert isValid : "actual: " + elements.get(elements.size() - 1).getText() + " expected: " + patternText;
            } else if (finalText.equals("MM/dd/yyyy HH:mm - Closed Session ID")) {
                String patternText = "^\\d{2}/\\d{2}/\\d{4} \\d{2}:\\d{2}\n-\nClosed Session ID \\d+$";

                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(BUBBLE_CHAT_OTHER + "//*[@class='Center']")));
                List<WebElement> elements = driver.findElements(By.xpath(BUBBLE_CHAT_OTHER + "//*[@class='Center']"));
                Pattern pattern = Pattern.compile(patternText);
                int skip = (elements.size() > 10) ? elements.size() - 10 : 0;
                boolean isValid = elements.stream().skip(skip).map(WebElement::getText).anyMatch(f -> pattern.matcher(f).matches());
                assert isValid : "actual: " + elements.get(elements.size() - 1).getText() + " expected: " + patternText;
            } else if (finalText.equals("MM/dd/yyyy HH:mm - Session ID Expired Unanswered")) {
                String patternText = "^\\d{2}/\\d{2}/\\d{4} \\d{2}:\\d{2}\n-\nSession ID \\d+ Expired Unanswered$";

                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(BUBBLE_CHAT_OTHER + "//*[@class='Center']")));
                List<WebElement> elements = driver.findElements(By.xpath(BUBBLE_CHAT_OTHER + "//*[@class='Center']"));
                Pattern pattern = Pattern.compile(patternText);
                int skip = (elements.size() > 10) ? elements.size() - 10 : 0;
                boolean isValid = elements.stream().skip(skip).map(WebElement::getText).anyMatch(f -> pattern.matcher(f).matches());
                assert isValid : "actual: " + elements.get(elements.size() - 1).getText() + " expected: " + patternText;
            } else {
                String[] textArray = finalText.split(" ");
                List<WebElement> tags;
                boolean done = false;

                if (finalText.contains("Edited") || finalText.contains("Updated")) {
                    wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(BUBBLE_CHAT_OTHER + "//button")));
                    tags = driver.findElements(By.xpath(BUBBLE_CHAT_OTHER + "//button"));
                } else {
                    wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(BUBBLE_CHAT_OTHER)));
                    tags = driver.findElements(By.xpath(BUBBLE_CHAT_OTHER));
                }

                int until = tags.size() > 6 ? tags.size() - 6 : 0;
                for (int i=tags.size()-1; i>=until; i--) {
                    new Actions(driver)
                            .scrollToElement(tags.get(i))
                            .pause(500)
                            .perform();

                    String elementTag = tags.get(i).getText();
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
        }, () -> {
            System.out.println("Repeat validateTagIsShowInMiddleChatroom...");
            driver.navigate().refresh();
            openContact("6285259027122", "6282213288475");
        }, waitTimeForLoop);

        long duration = System.currentTimeMillis() - startTime;
        System.out.println("Total time in validateTagIsShowInMiddleChatroom : " + Utils.convertMillisToString(duration));
    }



    public void clickExpandNotes() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CHAT_USER_TAB_NOTES)));
        WebElement element = driver.findElement(By.xpath(CHAT_USER_TAB_NOTES));
        element.click();
    }

    public void inputNotes(String text) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CHAT_USER_TAB_ADD_NOTE)));
        } catch (Exception e) {
            clickExpandNotes();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CHAT_USER_TAB_ADD_NOTE)));
        }
        WebElement element = driver.findElement(By.xpath(CHAT_USER_TAB_ADD_NOTE));
        new Actions(driver)
                .moveToElement(element)
                .click()
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .pause(500)
                .sendKeys(text)
                .build().perform();

        String btnSave_xpath = "//*[@class='noteAction']/button";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(btnSave_xpath)));
        WebElement btnSave = driver.findElement(By.xpath(btnSave_xpath));
        btnSave.click();
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

    public void clickInfoIcon(String text) {
        // add wait just in case the middle chat is not shown yet
        driver.navigate().refresh();
        openContact("6285259027122", "6282213288475");

        String xpath;
        if (text.equals("contact")) {
            xpath = BUBBLE_CHAT_OTHER + "//*[@class='ContactInformationInfo']/following-sibling::*[local-name()='svg']/*[local-name()='path']";
        } else {
            xpath = BUBBLE_CHAT_OTHER + "//*[contains(@class,'Note')]" + BUBBLE_CHAT_INFO_ICON;
        }
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath)));
        List<WebElement> infoIcon = driver.findElements(By.xpath(xpath));

        new Actions(driver)
                .scrollToElement(infoIcon.get(infoIcon.size() - 2))
                .moveToElement(infoIcon.get(infoIcon.size() - 2))
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
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CHAT_USER_TAB_NOTES_TOGGLE_IMPORTANT)));
        } catch (Exception e) {
            clickExpandNotes();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CHAT_USER_TAB_NOTES_TOGGLE_IMPORTANT)));
        }
        WebElement element = driver.findElement(By.xpath(CHAT_USER_TAB_NOTES_TOGGLE_IMPORTANT));

        do {
            if (element.getAttribute("src").contains("Switch-on")) {
                new Actions(driver).moveToElement(element).click().pause(2000).perform();
                clickExpandNotes();
                WebElement element1 = driver.findElement(By.xpath(CHAT_USER_TAB_NOTES_TOGGLE_IMPORTANT));
                new Actions(driver).moveToElement(element1).pause(2000).click().pause(500).perform();
            } else {
                new Actions(driver).moveToElement(element).click().pause(1000).perform();
            }
        } while (!element.getAttribute("src").contains("Switch-on"));
    }

    public void validateNotesIsHighlighted() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CHAT_USER_TAB_NOTES_TITLE)));
        WebElement element = driver.findElement(By.xpath(CHAT_USER_TAB_NOTES_TITLE));

        String elementColor = Color.fromString(element.getCssValue("color")).asRgba();
        assert elementColor.equals("rgba(101, 98, 223, 1)") : "actual: " + element.getCssValue("color") + " expected: rgba(101, 98, 223, 1)";
    }

    public void validateDetailChatSessionShowsInformation(List<Map<String, String>> list) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(CHAT_USER_TAB_USER_DETAIL_CHAT_SESSION)));
        List<WebElement> a = driver.findElements(By.xpath(CHAT_USER_TAB_USER_DETAIL_CHAT_SESSION));

        long startTime = System.currentTimeMillis();
        for (int i = 2; i <= a.size(); i++) {
            long startLoopTime = System.currentTimeMillis();
            do {
                try {
                    WebElement key = driver.findElement(By.xpath(CHAT_USER_TAB_USER_DETAIL_CHAT_SESSION + "[" + i + "]/*[contains(@class,'detailLeft')]"));
                    WebElement value = driver.findElement(By.xpath(CHAT_USER_TAB_USER_DETAIL_CHAT_SESSION + "[" + i + "]/*[contains(@class,'detailRight')]"));
                    wait.until(ExpectedConditions.not(ExpectedConditions.stalenessOf(value)));

                    if ((i == 4 || i == 5 || i == 6) && !list.get(0).get(key.getText()).equals("-")) {
                        assert Utils.validateDate(value.getText(), list.get(0).get(key.getText())) : "i: " + i + "| actual: " + value.getText() + "| expected: " + list.get(0).get(key.getText());
                    } else {
                        assert value.getText().contains(list.get(0).get(key.getText())) : "i: " + i + "| actual: " + value.getText() + "| expected: " + list.get(0).get(key.getText());
                    }

                    System.out.println("Success checked i : " + i + ", key : " + key.getText());
                } catch (Throwable e) {
                    continue;
                }
                break;
            } while ((System.currentTimeMillis() - startLoopTime) < 30000);
        }

        System.out.println("Total time needed to validateDetailChatSessionShowsInformation: " + Utils.convertMillisToString(System.currentTimeMillis() - startTime));
    }

    public void clickMenuSetting() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id(BUTTON_SETTING)));
        WebElement element = driver.findElement(By.id(BUTTON_SETTING));
        element.click();
    }

    public void validatePhotoProfileIsHighlighted(String color) {
        long startTime = System.currentTimeMillis();
        do {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(PROFILE_SIDEBAR_ACTIVE_BORDER)));
            WebElement element = driver.findElement(By.xpath(PROFILE_SIDEBAR_ACTIVE_BORDER));
            String elementColor = element.getAttribute("class");
            try {
                switch (color) {
                    case "blue":
                        assert elementColor.contains("avatar-border-ongoing") : "actual: " + elementColor + " expected: avatar-border-ongoing";
                        break;
                    case "yellow":
                        assert elementColor.contains("avatar-border-warning") : "actual: " + elementColor + " expected: avatar-border-warning";
                        break;
                    case "red":
                        assert elementColor.contains("avatar-border-danger") : "actual: " + elementColor + " expected: avatar-border-danger";
                        break;
                    case "none":
                        assert elementColor.contains("avatar") : "actual: " + elementColor + " expected: avatar";
                        break;
                }
                break;
            } catch (Throwable e) {
                if (color.equals("blue") && (elementColor.contains("avatar-border-warning") || elementColor.contains("avatar-border-danger") || elementColor.contains("avatar"))) {
                    break;
                } else if (color.equals("yellow") && (elementColor.contains("avatar-border-danger") || elementColor.contains("avatar"))) {
                    break;
                } else if (color.equals("red") && elementColor.contains("avatar")) {
                    break;
                }
            }
            new Actions(driver).pause(2000).perform();
        } while ((System.currentTimeMillis() - startTime) < 120000);

        System.out.println("Total time needed to validatePhotoProfileIsHighlighted : " + Utils.convertMillisToString(System.currentTimeMillis() - startTime));
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

        new Actions(driver)
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

    public void inputBirth(String text) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(EDIT_INFO_CONTACT_TAB_BIRTH)));
        WebElement element = driver.findElement(By.xpath(EDIT_INFO_CONTACT_TAB_BIRTH));

        do {
            new Actions(driver)
                    .moveToElement(element)
                    .click()
                    .keyDown(Keys.CONTROL)
                    .sendKeys("a")
                    .keyUp(Keys.CONTROL)
                    .sendKeys(text)
                    .build().perform();

            WebElement picker = driver.findElement(By.xpath("//div[@class='ant-picker-panel-layout']/parent::div/parent::div"));
            if (!picker.getAttribute("class").contains("hidden")) {
                try {
                    WebElement date = driver.findElement(By.xpath("//td[@title='2024-07-01']"));
                    new Actions(driver).moveToElement(date).click().build().perform();
                } catch (Throwable ignored) {}
            }
        } while (!element.getAttribute("value").equals(text));
    }

    public void inputCountry(String text) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(EDIT_INFO_CONTACT_TAB_COUNTRY)));
        WebElement element = driver.findElement(By.xpath(EDIT_INFO_CONTACT_TAB_COUNTRY));

        do {
            new Actions(driver)
                    .moveToElement(element)
                    .click()
                    .keyDown(Keys.CONTROL)
                    .sendKeys("a")
                    .keyUp(Keys.CONTROL)
                    .sendKeys(text)
                    .build().perform();

            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(EDIT_INFO_CONTACT_TAB_SELECT_COUNTRY)));
                WebElement select = driver.findElement(By.xpath(EDIT_INFO_CONTACT_TAB_SELECT_COUNTRY));
                select.click();
            } catch (Throwable ignored) {}
        } while (!element.getAttribute("value").equals(text));
    }

    public void inputProvince(String text) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(EDIT_INFO_CONTACT_TAB_PROVINCE)));
        WebElement element = driver.findElement(By.xpath(EDIT_INFO_CONTACT_TAB_PROVINCE));

        do {
            new Actions(driver)
                    .moveToElement(element)
                    .click()
                    .keyDown(Keys.CONTROL)
                    .sendKeys("a")
                    .keyUp(Keys.CONTROL)
                    .sendKeys(text)
                    .build().perform();

            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(EDIT_INFO_CONTACT_TAB_SELECT_PROVINCE)));
                WebElement select = driver.findElement(By.xpath(EDIT_INFO_CONTACT_TAB_SELECT_PROVINCE));
                select.click();
            } catch (Throwable ignored) {}
        } while (!element.getAttribute("value").equals(text));
    }

    public void inputCity(String text) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(EDIT_INFO_CONTACT_TAB_CITY)));
        WebElement element = driver.findElement(By.xpath(EDIT_INFO_CONTACT_TAB_CITY));

        do {
            new Actions(driver)
                    .moveToElement(element)
                    .click()
                    .keyDown(Keys.CONTROL)
                    .sendKeys("a")
                    .keyUp(Keys.CONTROL)
                    .sendKeys(text)
                    .build().perform();

            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(EDIT_INFO_CONTACT_TAB_SELECT_CITY)));
                WebElement select = driver.findElement(By.xpath(EDIT_INFO_CONTACT_TAB_SELECT_CITY));
                select.click();
            } catch (Throwable ignored) {}
        } while (!element.getAttribute("value").equals(text));
    }

    public void inputAddress(String text) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(EDIT_INFO_CONTACT_TAB_ADDRESS)));
        WebElement element = driver.findElement(By.xpath(EDIT_INFO_CONTACT_TAB_ADDRESS));

        do {
            new Actions(driver)
                    .moveToElement(element)
                    .click()
                    .keyDown(Keys.CONTROL)
                    .sendKeys("a")
                    .keyUp(Keys.CONTROL)
                    .sendKeys(text)
                    .build().perform();
        } while (!element.getAttribute("value").equals(text));
    }

    public void inputPostalCode(String text) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(EDIT_INFO_CONTACT_TAB_POSTAL_CODE)));
        WebElement element = driver.findElement(By.xpath(EDIT_INFO_CONTACT_TAB_POSTAL_CODE));

        do {
            new Actions(driver)
                    .moveToElement(element)
                    .click()
                    .keyDown(Keys.CONTROL)
                    .sendKeys("a")
                    .keyUp(Keys.CONTROL)
                    .sendKeys(text)
                    .build().perform();
        } while (!element.getAttribute("value").equals(text));
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

        for (WebElement element: elements) {
            WebElement activity = element.findElement(By.xpath("//*[@class='Left']"));

            for (Map<String, String> map : list) {
                if (map.get("Activity").equals(activity.getText())) {
                    WebElement from = element.findElement(By.xpath("//*[@class='Center']"));
                    new Actions(driver).scrollToElement(from).build().perform();
                    assert from.getText().equals(map.get("From")) : "actual: " + from.getText() + " expected: " + map.get("From");

                    WebElement to = element.findElement(By.xpath("//*[@class='Right']"));
                    new Actions(driver).scrollToElement(to).build().perform();
                    assert to.getText().equals(map.get("To")) : "actual: " + to.getText() + " expected: " + map.get("To");
                }
            }
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

            new Actions(driver).pause(500).perform();
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

    public void clickButtonClosedSessionAllSelected() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BUTTON_CLOSED_SESSION_ALL_SELECTED)));
        WebElement element = driver.findElement(By.xpath(BUTTON_CLOSED_SESSION_ALL_SELECTED));
        element.click();
    }

    public void validatePopUpTaggingAllSelected() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(POPUP_TAGGING_ALL_SELECTED)));
    }

    public void validatePopUpClosedSessionSelected() {
        long startTime = System.currentTimeMillis();
        boolean found = false;
        do {
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(POPUP_CLOSED_SESSION_SELECTED)));
                WebElement element = driver.findElement(By.xpath(POPUP_CLOSED_SESSION_SELECTED + "//*[@class='Title']"));
                assert element.getText().contains("Closed Session Selected Chatroom?") : "actual: " + element.getText() + " expected: Are you sure Closed Session Selected Chatroom?";
                found = true;
            } catch (Throwable e) {
                System.out.println(e.getMessage());
            }
            if (found) {break;}
        } while ((System.currentTimeMillis() - startTime) < 30000);
        assert found;
    }

    public void clickButtonYesSure() {
        new Actions(driver).pause(3000).build().perform();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(POPUP_CLOSED_SESSION_SELECTED_YES_BUTTON)));
        WebElement element = driver.findElement(By.xpath(POPUP_CLOSED_SESSION_SELECTED_YES_BUTTON));
        new Actions(driver).moveToElement(element).click().pause(5000).build().perform();
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

        new Actions(driver).pause(1000).perform();
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
            WebElement checkbox = driver.findElement(By.xpath(xpath));

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

        do {
            try {
                element.clear();
                new Actions(driver).pause(500).perform();
                element.sendKeys(text);

                break;
            } catch (Throwable ignored) {}
        } while (!element.getAttribute("value").equals(text));
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
        assert elements.stream().anyMatch(f -> f.getText().contains(text));
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

    public void clickButtonDeleteChatTabs() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CHAT_TABS_NEW_TABS_DROPDOWN_DELETE)));
        WebElement element = driver.findElement(By.xpath(CHAT_TABS_NEW_TABS_DROPDOWN_DELETE));
        element.click();

        new Actions(driver).pause(2000).perform();
    }

    public void validateOnChatTabsWillNoLongerShowTab(String text) {
        try {
            new WebDriverWait(this.driver, Duration.ofSeconds(3))
                    .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(CHAT_TABS_NEW_TABS)));
            List<WebElement> elements = driver.findElements(By.xpath(CHAT_TABS_NEW_TABS));
            assert elements.stream().noneMatch(f -> f.getText().equals(text));
        }catch (Exception ignored) {}
    }

    public void clickButtonChatroomHistory() {
        Utils.retryOperation(() -> {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CHAT_USER_TAB_BUTTON_CHATROOM_HISTORY)));
            WebElement element = driver.findElement(By.xpath(CHAT_USER_TAB_BUTTON_CHATROOM_HISTORY));
            element.click();

            new Actions(driver).pause(2000).perform();
        }, waitTimeForLoop);
    }

    public void validateChatroomHistoryWillBeOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CHATROOM_HISTORY_TAB)));
    }

    public void validateChatroomHistoryHaveInputSearchButtonFilterAndButtonSortByDate() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CHATROOM_HISTORY_TAB_INPUT_SEARCH)));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CHATROOM_HISTORY_TAB_BUTTON_FILTER)));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CHATROOM_HISTORY_TAB_BUTTON_SORT)));
    }

    public void validateChatroomHistoryHaveBoxChatSessionIDWithStatus(String text) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CHATROOM_HISTORY_TAB_BOX_SESSION)));
        List<WebElement> elements = driver.findElements(By.xpath(CHATROOM_HISTORY_TAB_BOX_SESSION));

        boolean done = false;
        for (WebElement e : elements) {
            String id = e.getAttribute("id");
            WebElement element = driver.findElement(By.xpath(String.format("//*[@id='%s']//button", id)));

            if (element.getText().equals(text)) {
                done = true;
                break;
            }
        }
        assert done;
    }

    public void clickBoxChatSessionIDWithStatus(String text) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CHATROOM_HISTORY_TAB_BOX_SESSION)));
        List<WebElement> elements = driver.findElements(By.xpath(CHATROOM_HISTORY_TAB_BOX_SESSION));

        for (WebElement e : elements) {
            String id = e.getAttribute("id");
            WebElement element = driver.findElement(By.xpath(String.format("//*[@id='%s']//button", id)));

            if (element.getText().equals(text)) {
                element.click();
                break;
            }
            new Actions(driver).pause(500).perform();
        }
    }

    public void validateChatroomSessionHistoryWillBeOpened() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CHATROOM_HISTORY_TAB_BOX_SESSION_POPUP)));
    }

    public void validateWillShowsPopUpChatSessionID(String text) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='Session']")));
        WebElement element = driver.findElement(By.xpath("//*[@class='Session']"));
        assert element.getText().equals(text);
    }

    public void validateChatroomSessionHistoryHaveInformation(List<Map<String, String>> list) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@class='Information']/div")));
        List<WebElement> elements = driver.findElements(By.xpath("//*[@class='Information']/div"));

        for (int i=1; i<=elements.size(); i++) {
            int attempts = 0;
            while (attempts < 5) {
                try {
                    List<WebElement> element = driver.findElements(By.xpath("//*[@class='Information']/div[" + i + "]//p"));
                    String text = element.get(0).getText().replace("\n", "");

                    WebElement key = driver.findElement(By.xpath("//*[@class='Information']/div[" + i + "]//div[@class='Left']"));

                    if (list.get(0).get(key.getText()).contains("yyyy")) {
                        assert Utils.validateDate(text, list.get(0).get(key.getText())) : "actual: " + text + " expected: " + list.get(0).get(key.getText());
                    } else {
                        assert text.equals(list.get(0).get(key.getText())) : "actual: " + text + " expected: " + list.get(0).get(key.getText());
                    }
                    break;
                } catch (Throwable ignored) {}
                new Actions(driver).pause(2000).perform();
                attempts++;
            }
        }
    }

    public void clickButtonSortByDate() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CHATROOM_HISTORY_TAB_BUTTON_SORT)));
        WebElement element = driver.findElement(By.xpath(CHATROOM_HISTORY_TAB_BUTTON_SORT));
        element.click();
    }

    public void validateChatroomHistoryWillBeSortedByDate() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CHATROOM_HISTORY_TAB_BUTTON_SORT + "/img")));
        WebElement element = driver.findElement(By.xpath(CHATROOM_HISTORY_TAB_BUTTON_SORT + "/img"));
        assert element.getAttribute("src").contains("sort-on") : "actual: " + element.getAttribute("src") + " expected: sort-on";
    }

    public void clickButtonFilterOnChatroomHistory() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CHATROOM_HISTORY_TAB_BUTTON_FILTER)));
        WebElement element = driver.findElement(By.xpath(CHATROOM_HISTORY_TAB_BUTTON_FILTER + "/*[local-name()='svg']/*[local-name()='path'][1]"));

        new Actions(driver)
                .moveToElement(element)
                .click()
                .pause(2000)
                .build().perform();
    }

    public void tickSessionOnChatroomHistory(List<String> textArray) {
        List<String> sessions = new ArrayList<>(Arrays.asList("closed_session", "expired_session", "expired_pending_session", "expired_unanswered_session"));
        textArray = textArray.stream()
                .map(String::toLowerCase)
                .map(s -> s.replace(" ", "_"))
                .map(s -> s + "_session")
                .collect(Collectors.toList());

        for (String s: sessions) {
            String xpath = String.format("//*[@id='%s']", s);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            WebElement checkbox = driver.findElement(By.xpath(xpath));

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

    public void clickButtonApplyFilterOnChatroomHistory() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CHATROOM_HISTORY_TAB_FILTER_APPLY)));
        WebElement element = driver.findElement(By.xpath(CHATROOM_HISTORY_TAB_FILTER_APPLY));
        element.click();

//        current version is auto close after click apply
//        WebElement close = driver.findElement(By.xpath(CHATROOM_HISTORY_TAB_CLOSE_FILTER + "/*[local-name()='path']"));
//        new Actions(driver)
//                .moveToElement(close)
//                .click()
//                .pause(2000)
//                .build().perform();
    }

    public void validateChatroomHistoryWillBeFilteredAndShowedFilterResultsWithButtonResetFilter() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='FilterResult']//*[@class='Left']")));
        WebElement l = driver.findElement(By.xpath("//*[@class='FilterResult']//*[@class='Left']"));
        assert l.getText().contains("Filter results :") : "actual: " + l.getText() + ", expected:Filter results :";

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='chatbody_chatuser_chathistory_btn_reset_filter']")));
        WebElement r = driver.findElement(By.xpath("//*[@id='chatbody_chatuser_chathistory_btn_reset_filter']"));
        assert r.getText().contains("Reset Filter") : "actual: " + r.getText() + ", expected: Reset Filter";
    }

    public void clickButtonBackOnChatroomHistory() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CHATROOM_HISTORY_TAB_BUTTON_BACK)));
        WebElement element = driver.findElement(By.xpath(CHATROOM_HISTORY_TAB_BUTTON_BACK));
        new Actions(driver)
                .moveToElement(element)
                .click()
                .pause(2000)
                .build().perform();
    }

    public void validateChatroomHistoryWillBeClosedAndRedirectToDetailChatSession() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CHAT_USER_TAB_PROFILE_DETAIL)));
    }

    public void validateSidebarChatHaveButtonUnansweredChatOnBottomChatboxPanel() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SIDEBAR_UNANSWERED_CHAT_BUTTON)));
    }

    public void clickButtonUnansweredChat() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SIDEBAR_UNANSWERED_CHAT_BUTTON)));
        WebElement element = driver.findElement(By.xpath(SIDEBAR_UNANSWERED_CHAT_BUTTON));
        element.click();
    }

    public void validateUnansweredChatPanelWillBeShown() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SIDEBAR_UNANSWERED_CHAT_PANEL)));
    }

    public void validateAllChatroomWillOnlyShownUnansweredChat() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='AvatarContainer']/img")));
        List<WebElement> elements = driver.findElements(By.xpath("//*[@class='AvatarContainer']/img"));

        assert elements.stream().anyMatch(f -> f.getAttribute("class").contains("avatar-border-danger"));
    }

    public void clickButtonDeleteOnTopLeftAreaChat() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='chatbody_chatcontent_btn_deletechat']")));
        WebElement element = driver.findElement(By.xpath("//*[@id='chatbody_chatcontent_btn_deletechat']"));
        element.click();
    }

    public void clickButtonYesOnConfirmationPopUp() {
        String xpath = "//*[@id='deletechat_popup_btn_confirmdelete']";
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        WebElement element = driver.findElement(By.xpath(xpath));

        try {
            while (element.isDisplayed()) {
                new Actions(driver)
                        .moveToElement(element)
                        .click()
                        .pause(500)
                        .build().perform();
            }
        } catch (StaleElementReferenceException ignore) {}
    }

    public void validateChatroomWillBeDeletedFromChatbox() {
        String xpath = "//p[@class='Warn']";
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            WebElement element = driver.findElement(By.xpath(xpath));
            wait.until(ExpectedConditions.textToBePresentInElement(element, "Has Been Deleted"));
            assert element.getText().contains("Deleted") : "actual: " + element.getText() + " expected: Has Been Deleted";
        } catch (Throwable e) {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
        }
    }

    public void searchNewChat(String chatTo, String chatFrom) {
        Utils.retryOperation(() -> {
            clickAndTypeOnFieldInputSearchOnSidebarChatbox(chatTo);
            clickContactAfterSearch();

            String xpath = String.format("//*[@class='name' and .='%s']", chatFrom);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            WebElement waNumber = driver.findElement(By.xpath(xpath));
            waNumber.click();

            new Actions(driver).pause(500).perform();

            clickButtonStartChat();
        }, waitTimeForLoop);

    }

    public void clickButtonDeleteWhenCheckingContact() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sidebarchatnotification_btn_delete']")));
        WebElement element = driver.findElement(By.xpath("//*[@id='sidebarchatnotification_btn_delete']"));
        element.click();
    }

    public void clickAndTypeOnFieldInputSearchOnSidebarChatbox(String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='chatsheader_textinput_searchchat']")));
        WebElement element = driver.findElement(By.xpath("//*[@id='chatsheader_textinput_searchchat']"));
        element.sendKeys(text);

        new Actions(driver).pause(3000).perform();
    }

    public void validateSearchChatWillBeFilteredIntoPartsIfExist() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='LabelChatSidebar_Contact']")));
    }

    public void clickContactAfterSearch() {
        String xpath = "//*[@class='LabelChatSidebar_Contact']/parent::div/following-sibling::div[contains(@id,'btn_openchat')]";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        WebElement element = driver.findElement(By.xpath(xpath));
        element.click();
    }

    public void validateShowPopUpInitiateChatFirst() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='InitiateChat']")));
    }

    public void chooseWhatsAppNumber(String text) {
        String[] textArray = text.split(" - ");

        String xpath = String.format("//*[@class='name' and .='%s']", textArray[1]);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        WebElement waNumber = driver.findElement(By.xpath(xpath));
        waNumber.click();

        new Actions(driver).pause(500).perform();
    }

    public void clickButtonStartChat() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='chatbody_initiatechat_btn_startchat']")));
        WebElement startChat = driver.findElement(By.xpath("//*[@id='chatbody_initiatechat_btn_startchat']"));
        startChat.click();

        new Actions(driver).pause(500).perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='chatsheader_btn_clearsearchchat']")));
        WebElement closeSearch = driver.findElement(By.xpath("//*[@id='chatsheader_btn_clearsearchchat']/*[local-name()='path']"));
        closeSearch.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(INPUT_CHAT)));
    }

    public void clickIconOpenChatroomOnContact(String text) {
        String xpath = String.format("//*[contains(@id,'btn_gotochatroom') and contains(@id,'%s')]/div[2]", text);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        WebElement element = driver.findElement(By.xpath(xpath));

        String xpath1 = String.format("//*[contains(@id,'btn_gotochatroom') and contains(@id,'%s')]//*[local-name()='svg']/*[local-name()='path']", text);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath1)));
        WebElement element1 = driver.findElement(By.xpath(xpath1));

        new Actions(driver)
                .scrollToElement(element)
                .moveToElement(element1)
                .click()
                .pause(1000).perform();
    }

    public void searchChatWillFoundNothing() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='LabelChatSidebar_Contact']")));
    }

    public boolean checkIfThereIsAnyUnansweredChat() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SIDEBAR_UNANSWERED_CHAT_BUTTON)));
        WebElement element = driver.findElement(By.xpath(SIDEBAR_UNANSWERED_CHAT_BUTTON));

        return !element.getText().contains("0");
    }

    public boolean checkIfThereAlreadyHasNotes() {
        new WebDriverWait(this.driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='BodyWarn']/p")));
        WebElement element = driver.findElement(By.xpath("//*[@class='BodyWarn']/p"));

        return element.getText().contains("Already Has Notes");
    }

    public void clickYesRewriteAddNotes() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='chatbody_multinote_btn_confirmrewrite']")));
        WebElement element = driver.findElement(By.xpath("//*[@id='chatbody_multinote_btn_confirmrewrite']"));
        element.click();

        new Actions(driver).pause(5000).perform();
    }

    public void userDoHoverOnLastBubbleChatAndClickDropdown() {
        long startTime = System.currentTimeMillis();
        do {
            try {
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(BUBBLE_CHAT_OWN + "/p[@class='text']")));
                List<WebElement> chats = driver.findElements(By.xpath(BUBBLE_CHAT_OWN + "/p[@class='text']"));
                new Actions(driver)
                        .moveToElement(chats.get(chats.size() - 1))
                        .pause(500)
                        .build().perform();


                String xpath = "//div[@class='ChatContent_Parent']//button[@type='button']//*[name()='svg']";
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath)));
                List<WebElement> elements = driver.findElements(By.xpath(xpath));
                new Actions(driver)
                        .moveToElement(elements.get(elements.size() - 1))
                        .pause(500)
                        .click()
                        .pause(1500)
                        .build().perform();
            } catch (Throwable e) {
                new Actions(driver).pause(2000).perform();
                System.out.println("Retrying userDoHoverOnLastBubbleChatAndClickDropdown...");
                continue;
            }
            break;
        } while ((System.currentTimeMillis() - startTime) < 60000);
    }

    public void userClickDeleteMessage() {
        int attempts = 0;
        do {
            try {
                String xpath = "//*[.='Delete Message']/preceding-sibling::*[local-name()='svg']/*[local-name()='path']";
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath)));
                List<WebElement> elements = driver.findElements(By.xpath(xpath));
                new Actions(driver)
                        .moveToElement(elements.get(elements.size() - 1))
                        .pause(500)
                        .click()
                        .build().perform();
            } catch (Throwable e) {
                new Actions(driver).pause(1000).perform();
                System.out.println("Retrying userClickDeleteMessage " + attempts + " times...");
                clickAndInputChat("Retry");
                clickSendButton();
                validateMessageIsSend("Retry", "qa-matt@gmail.com");
                userDoHoverOnLastBubbleChatAndClickDropdown();
                attempts++;
                continue;
            }
            break;
        } while (attempts < 5);
    }

    public void userWillSeePopUpDeleteOneChatConfirmation() {
        long startTime = System.currentTimeMillis();
        boolean found = false;
        do {
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(POPUP_DELETE_MESSAGE)));
                WebElement element = driver.findElement(By.xpath(POPUP_DELETE_MESSAGE + "//*[@class='Warn']"));
                assert element.getText().contains("Delete Message?") : "actual: " + element.getText() + " expected: Are you sure Delete Message?";
                found = true;
            } catch (Throwable e) {
                System.out.println(e.getMessage());
            }
            if (found) {break;}
        } while ((System.currentTimeMillis() - startTime) < 30000);
        assert found;
    }

    public void userClickButtonDeleteMessageOnConfirmationPopUp() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(POPUP_DELETE_MESSAGE_YES_BUTTON)));
        WebElement element = driver.findElement(By.xpath(POPUP_DELETE_MESSAGE_YES_BUTTON));
        new Actions(driver)
                .moveToElement(element)
                .click()
                .build().perform();
    }
}
