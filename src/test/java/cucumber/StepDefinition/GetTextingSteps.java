package cucumber.StepDefinition;


import cucumber.Page.*;
import cucumber.util.CreateDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class GetTextingSteps {
    private WebDriver driver;

    ContactListPage contactListPage;
    WhatsappPage whatsappPage;
    ChatPage chatPage;
    SettingPage settingPage;

    public GetTextingSteps() {
        driver = CreateDriver.getInstance().getDriver();
    }

    @And("User already add Whatsapp number {string}")
    public void userAlreadyAddWhatsappNumber(String text) {
        String[] textArray = text.split(" - ");

        whatsappPage = new WhatsappPage(driver);
        whatsappPage.goToWhatsappPage();
        whatsappPage.validateWhatsappNumberIsConnected(textArray);
    }

    @And("User in inbox page")
    public void userInInboxPage() {
        chatPage = new ChatPage(driver);
        chatPage.goToChatPage();
    }

    @And("There is contact {string} chatting with {string}")
    public void thereIsContactChattingWith(String chatTo, String chatFrom) {
        String[] chatToArray = chatTo.split(" - ");
        String[] chatFromArray = chatFrom.split(" - ");

        chatPage = new ChatPage(driver);
        chatPage.validateContactChatting(chatToArray, chatFromArray);
    }

    @And("The chatroom is handled by user {string}")
    public void theChatroomIsHandledByUser(String text) {
        chatPage = new ChatPage(driver);
        chatPage.validateChatroomIsHandledBy(text);
    }

    @When("User click field input chat dan type {string}")
    public void userClickFieldInputChatDanType(String text) {
        chatPage = new ChatPage(driver);
        chatPage.clickAndInputChat(text);
    }

    @And("User click button 'Send'")
    public void userClickButtonSend() {
        chatPage = new ChatPage(driver);
        chatPage.clickSendButton();
    }

    @Then("Message {string} from user {string} will be send")
    public void messageFromUserWillBeSend(String message, String user) {
        chatPage = new ChatPage(driver);
        chatPage.validateMessageIsSend(message, user);
    }

    @When("[chat-page] User click button 'Attach' on the left side of field input chat")
    public void chatPageUserClickButtonAttachOnTheLeftSideOfFieldInputChat() {
        chatPage = new ChatPage(driver);
        chatPage.clickAttachButton();
    }

    @When("[chat-page] User click button 'Emoji' on the left side of field input chat")
    public void chatPageUserClickButtonEmojiOnTheLeftSideOfFieldInputChat() {
        chatPage = new ChatPage(driver);
        chatPage.clickEmojiButton();
    }

    @And("[chat-page] User click choose 'Image'")
    public void chatPageUserClickChooseImage() {
        chatPage = new ChatPage(driver);
        chatPage.clickAttachImage();
    }

    @And("[chat-page] User click choose 'File'")
    public void chatPageUserClickChooseFile() {
        chatPage = new ChatPage(driver);
        chatPage.clickAttachFile();
    }

    @And("[chat-page] User upload image")
    public void chatPageUserUploadImage() {
        chatPage = new ChatPage(driver);
        chatPage.uploadImage();
    }

    @And("[chat-page] User upload file")
    public void chatPageUserUploadFile() {
        chatPage = new ChatPage(driver);
        chatPage.uploadFile();
    }

    @Then("Image will be added on field input chat")
    public void imageWillBeAddedOnFieldInputChat() {
        chatPage = new ChatPage(driver);
        chatPage.validateImageIsAdded();
    }

    @Then("File will be added on field input chat")
    public void fileWillBeAddedOnFieldInputChat() {
        chatPage = new ChatPage(driver);
        chatPage.validateFileIsAdded();
    }

    @And("Button 'Attach' icon will be changed to '+'")
    public void buttonAttachIconWillBeChangedTo() {
        chatPage = new ChatPage(driver);
        chatPage.validateAttachIconIsChanged();
    }

    @When("User click and type {string} on input field caption")
    public void userClickAndTypeOnInputFieldCaption(String text) {
        chatPage = new ChatPage(driver);
        chatPage.inputCaption(text);
    }

    @Then("Image will be added on field input chat in order number {int}")
    public void imageWillBeAddedOnFieldInputChatInOrderNumber(int number) {
        chatPage = new ChatPage(driver);
        chatPage.validateImageIsAddedInOrder(number);
    }

    @Then("File will be added on field input chat in order number {int}")
    public void fileWillBeAddedOnFieldInputChatInOrderNumber(int number) {
        chatPage = new ChatPage(driver);
        chatPage.validateFileIsAddedInOrder(number);
    }

    @When("User click image order number {int} and type {string} on input field caption")
    public void userClickImageOrderNumberAndTypeOnInputFieldCaption(int number, String text) {
        chatPage = new ChatPage(driver);
        chatPage.inputCaptionInOrder(number, text);
    }

    @When("User click file order number {int} and type {string} on input field caption")
    public void userClickFileOrderNumberAndTypeOnInputFieldCaption(int number, String text) {
        chatPage = new ChatPage(driver);
        chatPage.inputCaptionInOrder(number, text);
    }

    @Then("Image will be sent with caption {string}")
    public void imageWillBeSentWithCaption(String text) {
        chatPage = new ChatPage(driver);
        chatPage.validateImageIsSendWithCaption(text);
    }

    @Then("File will be sent with caption {string}")
    public void fileWillBeSentWithCaption(String text) {
        chatPage = new ChatPage(driver);
        chatPage.validateFileIsSendWithCaption(text);
    }

    @And("[chat-page] User choose wanted emoji")
    public void chatPageUserChooseWantedEmoji() {
        chatPage = new ChatPage(driver);
        chatPage.chooseWantedEmoji();
    }

    @When("User click menu Contact")
    public void userClickMenuContact() {
        chatPage = new ChatPage(driver);
        chatPage.clickMenuContact();
    }

    @Then("User will be redirected to page Contact List")
    public void userWillBeRedirectedToPageContactList() {
        contactListPage = new ContactListPage(driver);
        contactListPage.validateRedirectToContactList();
    }

    @And("Contact {string} will automatically saved")
    public void contactWillAutomaticallySaved(String text) {
        String[] textArray = text.split(" - ");

        chatPage = new ChatPage(driver);
        chatPage.validateContactIsSaved(textArray);
    }

    @When("User click button 'Add Tag' on Detail Chatroom panel")
    public void userClickButtonAddTagOnDetailChatroomPanel() {
        chatPage = new ChatPage(driver);
        chatPage.clickAddTagButton();
    }

    @And("User click and type {string} on field search tag")
    public void userClickAndTypeOnFieldSearchTag(String text) {
        chatPage = new ChatPage(driver);
        chatPage.inputTag(text);
    }

    @And("User click create a new tag")
    public void userClickCreateANewTag() {
        chatPage = new ChatPage(driver);
        chatPage.clickCreateNewTag();
    }

    @Then("Tag {string} will be added on Contact {string}")
    public void tagWillBeAddedOnContact(String tag, String text) {
        String[] textArray = text.split(" - ");

        chatPage = new ChatPage(driver);
        chatPage.validateTagIsAdded(tag, textArray);
    }

    @And("On middle chatroom will shows {string}")
    public void onMiddleChatroomWillShows(String text) {
        chatPage = new ChatPage(driver);
        chatPage.validateTagIsShowInMiddleChatroom(text);
    }

    @And("Contact list will be auto updated")
    public void contactListWillBeAutoUpdated(DataTable dataTable) {
        List<Map<String, String>> list = dataTable.asMaps(String.class,String.class);

        contactListPage = new ContactListPage(driver);
        contactListPage.validateContactListIsAutoUpdated(list);
    }

    @When("User click expand Notes on Detail Chatroom panel")
    public void userClickExpandNotesOnDetailChatroomPanel() {
        chatPage = new ChatPage(driver);
        chatPage.clickExpandNotes();
    }

    @And("User click and type {string} on field notes")
    public void userClickAndTypeOnFieldNotes(String text) throws InterruptedException {
        chatPage = new ChatPage(driver);
        chatPage.inputNotes(text);
    }

    @Then("Notes {string} will be added akan on contact")
    public void notesWillBeAddedAkanOnContact(String text) throws InterruptedException {
        chatPage = new ChatPage(driver);
        chatPage.validateNotesIsAdded(text);
    }

    @When("User click icon info on records")
    public void userClickIconInfoOnRecords() {
        chatPage = new ChatPage(driver);
        chatPage.clickInfoIcon();
    }

    @Then("Show pop-up Added Notes")
    public void showPopUpAddedNotes() {
        chatPage = new ChatPage(driver);
        chatPage.validatePopUpAddedNotes();
    }

    @And("Show table has column From and To")
    public void showTableHasColumnFromAndTo(DataTable dataTable) {
        List<Map<String, String>> list = dataTable.asMaps(String.class,String.class);

        chatPage = new ChatPage(driver);
        chatPage.validateTableHasColumnFromAndTo(list);
    }

    @And("User click toggle 'Important'")
    public void userClickToggleImportant() {
        chatPage = new ChatPage(driver);
        chatPage.clickToggleImportant();
    }

    @Then("Notes will be blue highlighted")
    public void notesWillBeBlueHighlighted() {
        chatPage = new ChatPage(driver);
        chatPage.validateNotesIsHighlighted();
    }

    @And("[contact-page] Column Notes on contact number {string} will be blue highlighted")
    public void contactPageColumnNotesOnContactNumberWillBeBlueHighlighted(String text) {
        contactListPage = new ContactListPage(driver);
        contactListPage.validateNotesIsHighlighted(text);
    }

    @And("On Detail Chat Session shows information")
    public void onDetailChatSessionShowsInformation(DataTable dataTable) {
        List<Map<String, String>> list = dataTable.asMaps(String.class,String.class);

        chatPage = new ChatPage(driver);
        chatPage.validateDetailChatSessionShowsInformation(list);
    }

    @And("User change pending time to {int} min and expired time to {int} min")
    public void userChangePendingTimeToMinAndExpiredTimeToMin(int pending, int expired) {
        chatPage = new ChatPage(driver);
        chatPage.clickMenuSetting();

        settingPage = new SettingPage(driver);
        settingPage.clickMenuChatSetting();
        settingPage.changePendingAndExpiredTime(pending, expired);

        chatPage.goToChatPage();
    }

    @When("User not send message and no interaction for {int} min")
    public void userNotSendMessageAndNoInteractionForMin(int duration) throws InterruptedException {
        Thread.sleep((long) duration * 62 * 1000);
    }

    @When("User click menu Setting")
    public void userClickMenuSetting() {
        chatPage = new ChatPage(driver);
        chatPage.clickMenuSetting();
    }

    @Then("User will be redirected to page App Information")
    public void userWillBeRedirectedToPageAppInformation() {
        settingPage = new SettingPage(driver);
        settingPage.validateRedirectToAppInformation();
    }

    @When("User click sub menu Chat Setting")
    public void userClickSubMenuChatSetting() {
        settingPage = new SettingPage(driver);
        settingPage.clickMenuChatSetting();
    }

    @Then("User will be redirected to Chat Setting")
    public void userWillBeRedirectedToChatSetting() {
        settingPage = new SettingPage(driver);
        settingPage.validateRedirectToChatSetting();
    }

    @When("[chat-setting-page] User click button 'Edit'")
    public void chatSettingPageUserClickButtonEdit() {
        settingPage = new SettingPage(driver);
        settingPage.clickMenuChatSettingButtonEdit();
    }

    @When("[chat-setting-page] User click button 'Apply Edit'")
    public void chatSettingPageUserClickButtonApplyEdit() {
        settingPage = new SettingPage(driver);
        settingPage.clickMenuChatSettingButtonApplyEdit();
    }

    @And("User change Pending time to {string}")
    public void userChangePendingTimeTo(String text) {
        String[] textArray = text.split(" & ");
        String[] pendingHour = textArray[0].split(" ");
        String[] pendingMinute = textArray[1].split(" ");

        settingPage = new SettingPage(driver);
        settingPage.changePendingTime(Integer.parseInt(pendingHour[0]), Integer.parseInt(pendingMinute[0]));
    }

    @And("User change Expired time to {string}")
    public void userChangeExpiredTimeTo(String text) {
        String[] textArray = text.split(" & ");
        String[] pendingHour = textArray[0].split(" ");
        String[] pendingMinute = textArray[1].split(" ");

        settingPage = new SettingPage(driver);
        settingPage.changeExpiredTime(Integer.parseInt(pendingHour[0]), Integer.parseInt(pendingMinute[0]));
    }

    @Then("Chat session will be updated, Pending time will be {string} and Expired time will be {string}")
    public void chatSessionWillBeUpdatedPendingTimeWillBeAndExpiredTimeWillBe(String pending, String expired) {
        settingPage = new SettingPage(driver);
        settingPage.validateChatSessionUpdated(pending, expired);
    }

    @And("Photo profile contact on chatbox will be blue highlighted")
    public void photoProfileContactOnChatboxWillBeBlueHighlighted() {
        chatPage = new ChatPage(driver);
        chatPage.validatePhotoProfileIsHighlighted("blue");
    }

    @And("Photo profile contact on chatbox will be yellow highlighted")
    public void photoProfileContactOnChatboxWillBeYellowHighlighted() {
        chatPage = new ChatPage(driver);
        chatPage.validatePhotoProfileIsHighlighted("yellow");
    }

    @And("Photo profile contact on chatbox will be red highlighted")
    public void photoProfileContactOnChatboxWillBeRedHighlighted() {
        chatPage = new ChatPage(driver);
        chatPage.validatePhotoProfileIsHighlighted("red");
    }

    @And("Photo profile contact on chatbox will be none highlighted")
    public void photoProfileContactOnChatboxWillBeNoneHighlighted() {
        chatPage = new ChatPage(driver);
        chatPage.validatePhotoProfileIsHighlighted("none");
    }

    @When("User click button 'Close Session'")
    public void userClickButtonCloseSession() {
        chatPage = new ChatPage(driver);
        chatPage.clickButtonCloseSession();
    }

    @When("User click button 'Edit Info Contact' on Detail Chatroom panel")
    public void userClickButtonEditInfoContactOnDetailChatroomPanel() {
        chatPage = new ChatPage(driver);
        chatPage.clickButtonEditInfoContact();

    }

    @Then("Detail Chatroom panel will be changed to Edit Info Contact panel")
    public void detailChatroomPanelWillBeChangedToEditInfoContactPanel() {
        chatPage = new ChatPage(driver);
        chatPage.validateRedirectToEditInfoContact();
    }

    @When("User click field Contact Name and type {string}")
    public void userClickFieldContactNameAndType(String text) {
        chatPage = new ChatPage(driver);
        chatPage.inputContactName(text);
    }

    @And("User click field Birth and type {string}")
    public void userClickFieldBirthAndType(String text) {
        chatPage = new ChatPage(driver);
        chatPage.inputBirth(text);
    }

    @And("User click field Country and type {string}")
    public void userClickFieldCountryAndType(String text) {
        chatPage = new ChatPage(driver);
        chatPage.inputCountry(text);
    }

    @And("User click field Province and type {string}")
    public void userClickFieldProvinceAndType(String text) {
        chatPage = new ChatPage(driver);
        chatPage.inputProvince(text);
    }

    @And("User click field City and type {string}")
    public void userClickFieldCityAndType(String text) {
        chatPage = new ChatPage(driver);
        chatPage.inputCity(text);
    }

    @And("User click field Address and type {string}")
    public void userClickFieldAddressAndType(String text) {
        chatPage = new ChatPage(driver);
        chatPage.inputAddress(text);
    }

    @And("User click field Postal Code and type {string}")
    public void userClickFieldPostalCodeAndType(String text) {
        chatPage = new ChatPage(driver);
        chatPage.inputPostalCode(text);
    }

    @And("User click button 'Save' on Edit Info Contact panel")
    public void userClickButtonSaveOnEditInfoContactPanel() {
        chatPage = new ChatPage(driver);
        chatPage.clickButtonSave();
    }

    @Then("Edit Info Contact panel will be changed to Detail Chatroom panel")
    public void editInfoContactPanelWillBeChangedToDetailChatroomPanel() {
        chatPage = new ChatPage(driver);
        chatPage.validateRedirectToDetailChatRoom();
    }

    @Then("Show pop-up Edited Contact")
    public void showPopUpEditedContact() {
        chatPage = new ChatPage(driver);
        chatPage.validatePopUpEditedContact();
    }

    @And("Show table has column Activity,From and To")
    public void showTableHasColumnActivityFromAndTo(DataTable dataTable) {
        List<Map<String, String>> list = dataTable.asMaps(String.class,String.class);

        chatPage = new ChatPage(driver);
        chatPage.validateTableHasColumnActivityFromAndTo(list);
    }

    @And("Revert back contact Rahmadhany")
    public void revertBackContactRahmadhany() {
        contactListPage = new ContactListPage(driver);
        contactListPage.revertContactRahmadhany();

        userInInboxPage();
        thereIsContactChattingWith("6285259027122 - Rahmadhany", "6282213288475 - Julia");
        userClickButtonEditInfoContactOnDetailChatroomPanel();
        detailChatroomPanelWillBeChangedToEditInfoContactPanel();
        userClickFieldAddressAndType("");
        userClickFieldPostalCodeAndType("");
        userClickButtonSaveOnEditInfoContactPanel();
        editInfoContactPanelWillBeChangedToDetailChatroomPanel();
    }

    @When("User click button 'Check' on chatbox sidebar")
    public void userClickButtonCheckOnChatboxSidebar() {
        chatPage = new ChatPage(driver);
        chatPage.clickButtonCheck();
    }

    @And("User check Chatroom from contact {string}")
    public void userCheckChatroomFromContact(String text) {
        String[] textArray = text.split(",");
        chatPage = new ChatPage(driver);
        chatPage.checkChatroom(textArray);
    }

    @And("User click button 'More' on chatbox sidebar")
    public void userClickButtonMoreOnChatboxSidebar() {
        chatPage = new ChatPage(driver);
        chatPage.clickButtonMore();
    }

    @And("User choose 'Tagging All Selected'")
    public void userChooseTaggingAllSelected() {
        chatPage = new ChatPage(driver);
        chatPage.clickButtonTaggingAllSelected();
    }

    @Then("Show pop-up Tagging All Selected")
    public void showPopUpTaggingAllSelected() {
        chatPage = new ChatPage(driver);
        chatPage.validatePopUpTaggingAllSelected();
    }

    @When("User click and type {string} on field Search Tag Tagging")
    public void userClickAndTypeOnFieldSearchTagTagging(String text) {
        chatPage = new ChatPage(driver);
        chatPage.inputFieldSearchTagOnTaggingAllSelected(text);
    }

    @When("User click and type {string} on field Search Tag Notes")
    public void userClickAndTypeOnFieldSearchTagNotes(String text) {
        chatPage = new ChatPage(driver);
        chatPage.inputFieldSearchTagOnNotesAllSelected(text);
    }

    @And("User click button 'Add Tagging'")
    public void userClickButtonAddTagging() {
        chatPage = new ChatPage(driver);
        chatPage.clickButtonAddTagging();
    }

    @And("User choose 'Notes All Selected'")
    public void userChooseNotesAllSelected() {
        chatPage = new ChatPage(driver);
        chatPage.clickButtonNotesAllSelected();
    }

    @Then("Show pop-up Notes All Selected")
    public void showPopUpNotesAllSelected() {
        chatPage = new ChatPage(driver);
        chatPage.validatePopUpNotesAllSelected();
    }


    @And("user click toggle important note")
    public void userClickToggleImportantNote() {
        chatPage = new ChatPage(driver);
        chatPage.clickToggleImportantNote();
    }

    @And("User click button 'Add Notes'")
    public void userClickButtonAddNotes() {
        chatPage = new ChatPage(driver);
        chatPage.clickButtonAddNotes();
    }

    @When("User click button 'Filter' on chatbox sidebar")
    public void userClickButtonFilterOnChatboxSidebar() {
        chatPage = new ChatPage(driver);
        chatPage.clickButtonFilter();
    }

    @And("User tick session {string}")
    public void userTickSession(String text) {
        String[] textArray = text.split(", ");
        List<String> a = new ArrayList<>();
        Collections.addAll(a, textArray);

        chatPage = new ChatPage(driver);
        chatPage.tickSession(a);
    }

    @And("User choose {string} on form User Name")
    public void userChooseOnFormUserName(String text) {
        chatPage = new ChatPage(driver);
        chatPage.chooseFormUserName(text);
    }

    @And("User click button 'Apply Filter'")
    public void userClickButtonApplyFilter() {
        chatPage = new ChatPage(driver);
        chatPage.clickButtonApplyFilter();
    }

    @And("User click button 'Apply Filter' on Chatroom History")
    public void userClickButtonApplyFilterOnChatroomHistory() {
        chatPage = new ChatPage(driver);
        chatPage.clickButtonApplyFilterOnChatroomHistory();
    }

    @Then("Chatroom on chatbox will be filtered and showed 'Filter Results' with button 'Reset Filter'")
    public void chatroomOnChatboxWillBeFilteredAndShowedFilterResultsWithButtonResetFilter() {
        chatPage = new ChatPage(driver);
        chatPage.validateChatroomOnChatboxWillBeFiltered("filter");
    }

    @When("User click button Add New Chat Tabs")
    public void userClickButtonAddNewChatTabs() {
        chatPage = new ChatPage(driver);
        chatPage.clickButtonAddNewChatTabs();
    }

    @And("User click and type {string} on form Chat Tabs Name")
    public void userClickAndTypeOnFormChatTabsName(String text) {
        chatPage = new ChatPage(driver);
        chatPage.inputFormChatTabsName(text);
    }

    @And("User click button 'Create Chat Tabs'")
    public void userClickButtonCreateChatTabs() {
        chatPage = new ChatPage(driver);
        chatPage.clickButtonCreateChatTabs();
    }

    @And("On Chat Tabs will added new tab {string}")
    public void onChatTabsWillAddedNewTab(String text) {
        chatPage = new ChatPage(driver);
        chatPage.validateOnChatTabsWillAddedNewTab(text);
    }

    @When("User click tab {string}")
    public void userClickTab(String text) {
        chatPage = new ChatPage(driver);
        chatPage.clickTab(text);
    }

    @Then("Chatroom on chatbox will be filtered and showed 'Chat Tab Results' with button 'Close'")
    public void chatroomOnChatboxWillBeFilteredAndShowedChatTabResultsWithButtonClose() {
        chatPage = new ChatPage(driver);
        chatPage.validateChatroomOnChatboxWillBeFiltered("tab");
    }

    @When("User click tab {string} dropdown")
    public void userClickTabDropdown(String text) {
        chatPage = new ChatPage(driver);
        chatPage.clickTabDropdown(text);
    }

    @And("User click button Edit chat tabs")
    public void userClickButtonEditChatTabs() {
        chatPage = new ChatPage(driver);
        chatPage.clickButtonEditChatTabs();
    }

    @And("User click button Delete chat tabs")
    public void userClickButtonDeleteChatTabs() {
        chatPage = new ChatPage(driver);
        chatPage.clickButtonDeleteChatTabs();
    }

    @And("User click button 'Save Chat Tabs'")
    public void userClickButtonSaveChatTabs() {
        chatPage = new ChatPage(driver);
        chatPage.clickButtonSaveChatTabs();
    }


    @And("On Chat Tabs will no longer show tab {string}")
    public void onChatTabsWillNoLongerShowTab(String text) {
        chatPage = new ChatPage(driver);
        chatPage.validateOnChatTabsWillNoLongerShowTab(text);
    }

    @And("User click button 'Chatroom History' on Detail Chat Session panel")
    public void userClickButtonChatroomHistoryOnDetailChatSessionPanel() {
        chatPage = new ChatPage(driver);
        chatPage.clickButtonChatroomHistory();
    }

    @Then("Chatroom History will be opened")
    public void chatroomHistoryWillBeOpened() {
        chatPage = new ChatPage(driver);
        chatPage.validateChatroomHistoryWillBeOpened();
    }

    @And("Chatroom History have input search, button Filter, and button Sort by Date")
    public void chatroomHistoryHaveInputSearchButtonFilterAndButtonSortByDate() {
        chatPage = new ChatPage(driver);
        chatPage.validateChatroomHistoryHaveInputSearchButtonFilterAndButtonSortByDate();
    }

    @And("Chatroom History have box Chat Session ID with status {string}")
    public void chatroomHistoryHaveBoxChatSessionIDWithStatus(String text) {
        chatPage = new ChatPage(driver);
        chatPage.validateChatroomHistoryHaveBoxChatSessionIDWithStatus(text);
    }

    @When("User click box Chat Session ID with status {string}")
    public void userClickBoxChatSessionIDWithStatus(String text) {
        chatPage = new ChatPage(driver);
        chatPage.clickBoxChatSessionIDWithStatus(text);
    }

    @Then("Chatroom Session History will be opened")
    public void chatroomSessionHistoryWillBeOpened() {
        chatPage = new ChatPage(driver);
        chatPage.validateChatroomSessionHistoryWillBeOpened();
    }

    @And("Will shows pop-up Chat Session ID {string}")
    public void willShowsPopUpChatSessionID(String text) {
        chatPage = new ChatPage(driver);
        chatPage.validateWillShowsPopUpChatSessionID(text);
    }

    @And("Chatroom Session History have information")
    public void chatroomSessionHistoryHaveInformation(DataTable dataTable) {
        List<Map<String, String>> list = dataTable.asMaps(String.class,String.class);

        chatPage = new ChatPage(driver);
        chatPage.validateChatroomSessionHistoryHaveInformation(list);
    }

    @And("User click button Sort by Date")
    public void userClickButtonSortByDate() {
        chatPage = new ChatPage(driver);
        chatPage.clickButtonSortByDate();
    }

    @Then("Chatroom History will be sorted by Date")
    public void chatroomHistoryWillBeSortedByDate() {
        chatPage = new ChatPage(driver);
        chatPage.validateChatroomHistoryWillBeSortedByDate();
    }

    @When("User click button Filter on Chatroom History")
    public void userClickButtonFilterOnChatroomHistory() {
        chatPage = new ChatPage(driver);
        chatPage.clickButtonFilterOnChatroomHistory();
    }

    @And("User tick session {string} on Chatroom History")
    public void userTickSessionOnChatroomHistory(String text) {
        String[] textArray = text.split(", ");
        List<String> a = new ArrayList<>();
        Collections.addAll(a, textArray);

        chatPage = new ChatPage(driver);
        chatPage.tickSessionOnChatroomHistory(a);
    }

    @Then("Chatroom History will be filtered and showed 'Filter Results' with button 'Reset Filter'")
    public void chatroomHistoryWillBeFilteredAndShowedFilterResultsWithButtonResetFilter() {
        chatPage = new ChatPage(driver);
        chatPage.validateChatroomHistoryWillBeFilteredAndShowedFilterResultsWithButtonResetFilter();
    }

    @When("User click button Back on Chatroom History")
    public void userClickButtonBackOnChatroomHistory() {
        chatPage = new ChatPage(driver);
        chatPage.clickButtonBackOnChatroomHistory();
    }

    @Then("Chatroom History will be closed and redirect to Detail Chat Session")
    public void chatroomHistoryWillBeClosedAndRedirectToDetailChatSession() {
        chatPage = new ChatPage(driver);
        chatPage.validateChatroomHistoryWillBeClosedAndRedirectToDetailChatSession();
    }

    @And("Sidebar chat have button Unanswered Chat on bottom Chatbox panel")
    public void sidebarChatHaveButtonUnansweredChatOnBottomChatboxPanel() {
        chatPage = new ChatPage(driver);
        chatPage.validateSidebarChatHaveButtonUnansweredChatOnBottomChatboxPanel();
    }

    @When("User click button Unanswered Chat")
    public void userClickButtonUnansweredChat() {
        chatPage = new ChatPage(driver);
        chatPage.clickButtonUnansweredChat();
    }

    @Then("Unanswered Chat panel will be shown")
    public void unansweredChatPanelWillBeShown() {
        chatPage = new ChatPage(driver);
        chatPage.validateUnansweredChatPanelWillBeShown();
    }

    @And("All chatroom will only shown Unanswered Chat")
    public void allChatroomWillOnlyShownUnansweredChat() {
        chatPage = new ChatPage(driver);
        chatPage.validateAllChatroomWillOnlyShownUnansweredChat();
    }

    @When("User click button Delete on top left area chat")
    public void userClickButtonDeleteOnTopLeftAreaChat() {
        chatPage = new ChatPage(driver);
        chatPage.clickButtonDeleteOnTopLeftAreaChat();
    }

    @And("User click button Yes on confirmation pop-up")
    public void userClickButtonYesOnConfirmationPopUp() {
        chatPage = new ChatPage(driver);
        chatPage.clickButtonYesOnConfirmationPopUp();
    }

    @Then("Chatroom will be deleted from Chatbox")
    public void chatroomWillBeDeletedFromChatbox() {
        chatPage = new ChatPage(driver);
        chatPage.validateChatroomWillBeDeletedFromChatbox();
    }

    @And("Start new chat {string}")
    public void startNewChat(String text) {
        String[] textArray = text.split(", ");
        chatPage = new ChatPage(driver);
        chatPage.searchNewChat(textArray[0], textArray[1]);
    }

    @And("User click button Delete when checking contact")
    public void userClickButtonDeleteWhenCheckingContact() {
        chatPage = new ChatPage(driver);
        chatPage.clickButtonDeleteWhenCheckingContact();
    }

    @When("User click button New Contact")
    public void userClickButtonNewContact() {
        contactListPage = new ContactListPage(driver);
        contactListPage.clickButtonNewContact();
    }

    @Then("Show pop-up Add New Contact")
    public void showPopUpAddNewContact() {
        contactListPage = new ContactListPage(driver);
        contactListPage.validateShowPopUpAddNewContact();
    }

    @And("Button Save will be grey out")
    public void buttonSaveWillBeGreyOut() {
        contactListPage = new ContactListPage(driver);
        contactListPage.validateButtonSaveWillBeGreyOut();
    }

    @When("User click and type {string} on field Contact Number")
    public void userClickAndTypeOnFieldContactNumber(String text) {
        contactListPage = new ContactListPage(driver);
        contactListPage.clickAndTypeOnFieldContactNumber(text);
    }

    @When("User click and type {string} on field Contact Name")
    public void userClickAndTypeOnFieldContactName(String text) {
        contactListPage = new ContactListPage(driver);
        contactListPage.clickAndTypeOnFieldContactName(text);
    }

    @And("User click button Save")
    public void userClickButtonSave() {
        contactListPage = new ContactListPage(driver);
        contactListPage.clickButtonSave();
    }

    @When("User click button Edit on contact {string}")
    public void userClickButtonEditOnContact(String text) {
        contactListPage = new ContactListPage(driver);
        contactListPage.clickButtonEditOnContact(text);
    }

    @Then("Show pop-up Edited Contact on Edit Contact")
    public void showPopUpEditedContactOnEditContact() {
        contactListPage = new ContactListPage(driver);
        contactListPage.validateShowPopUpEditContact();
    }

    @When("User click field Contact Number")
    public void userClickFieldContactNumber() {
        contactListPage = new ContactListPage(driver);
        contactListPage.clickFieldContactNumber();
    }

    @Then("Show warning changed contact number")
    public void showWarningChangedContactNumber() {
        contactListPage = new ContactListPage(driver);
        contactListPage.validateShowWarningChangedContactNumber();
    }

    @When("User click button Yes on warning changed contact number")
    public void userClickButtonYesOnWarningChangedContactNumber() {
        contactListPage = new ContactListPage(driver);
        contactListPage.clickButtonYesOnWarningChangedContactNumber();
    }

    @And("User click button Save on Edit Contact")
    public void userClickButtonSaveOnEditContact() {
        contactListPage = new ContactListPage(driver);
        contactListPage.clickButtonSaveOnEditContact();
    }

    @When("User click and type {string} on field input search on sidebar chatbox")
    public void userClickAndTypeOnFieldInputSearchOnSidebarChatbox(String text) {
        chatPage = new ChatPage(driver);
        chatPage.clickAndTypeOnFieldInputSearchOnSidebarChatbox(text);
    }

    @Then("Search chat will be filtered into 3 parts if exist")
    public void searchChatWillBeFilteredIntoPartsIfExist() {
        chatPage = new ChatPage(driver);
        chatPage.validateSearchChatWillBeFilteredIntoPartsIfExist();
    }

    @When("User click contact after search")
    public void userClickContactAfterSearch() {
        chatPage = new ChatPage(driver);
        chatPage.clickContactAfterSearch();
    }

    @Then("Show pop-up Initiate Chat First")
    public void showPopUpInitiateChatFirst() {
        chatPage = new ChatPage(driver);
        chatPage.validateShowPopUpInitiateChatFirst();
    }

    @When("User choose WhatsApp Number {string}")
    public void userChooseWhatsAppNumber(String text) {
        chatPage = new ChatPage(driver);
        chatPage.chooseWhatsAppNumber(text);
    }

    @And("User click button Start Chat")
    public void userClickButtonStartChat() {
        chatPage = new ChatPage(driver);
        chatPage.clickButtonStartChat();
    }

    @And("User click icon Open Chatroom on contact {string}")
    public void userClickIconOpenChatroomOnContact(String text) {
        chatPage = new ChatPage(driver);
        chatPage.clickIconOpenChatroomOnContact(text);
    }

    @When("User click and changed name {string} into {string}")
    public void userClickAndChangedNameInto(String from, String to) {
        contactListPage = new ContactListPage(driver);
        contactListPage.clickAndChangedNameInto(from, to);
    }

    @When("User click button Add Bulk")
    public void userClickButtonAddBulk() {
        contactListPage = new ContactListPage(driver);
        contactListPage.clickButtonAddBulk();
    }

    @And("User choose Import File when Add Bulk")
    public void userChooseImportFileWhenAddBulk() {
        contactListPage = new ContactListPage(driver);
        contactListPage.chooseImportFileWhenAddBulk();
    }

    @And("User upload excel template into pop-up Import File")
    public void userUploadExcelTemplateIntoPopUpImportFile() {
        contactListPage = new ContactListPage(driver);
        contactListPage.uploadExcelTemplateIntoPopUpImportFile();
    }

    @And("User upload excel template 1000 into pop-up Import File")
    public void userUploadExcelTemplate1000IntoPopUpImportFile() {
        contactListPage = new ContactListPage(driver);
        contactListPage.uploadExcelTemplate1000IntoPopUpImportFile();
    }

    @When("User click button Submit")
    public void userClickButtonSubmit() {
        contactListPage = new ContactListPage(driver);
        contactListPage.clickButtonSubmit();
    }

    @And("User choose Sync From WhatsApp when Add Bulk")
    public void userChooseSyncFromWhatsAppWhenAddBulk() {
        contactListPage = new ContactListPage(driver);
        contactListPage.chooseSyncFromWhatsAppWhenAddBulk();
    }

    @When("User click input field Choose WhatsApp Number")
    public void userClickInputFieldChooseWhatsAppNumber() {
        contactListPage = new ContactListPage(driver);
        contactListPage.clickInputFieldChooseWhatsAppNumber();
    }

    @And("User choose Whatsapp number {string}")
    public void userChooseWhatsappNumber(String text) {
        contactListPage = new ContactListPage(driver);
        contactListPage.chooseWhatsappNumber(text);
    }

    @When("User click button Next")
    public void userClickButtonNext() {
        contactListPage = new ContactListPage(driver);
        contactListPage.clickButtonNext();
    }

    @Then("Pop-up WhatsApp Sync will continue to second step")
    public void popUpWhatsAppSyncWillContinueToSecondStep() {
        contactListPage = new ContactListPage(driver);
        contactListPage.validatePopUpWhatsAppSyncWillContinueToSecondStep();
    }

    @When("User check contact wanted to be added")
    public void userCheckContactWantedToBeAdded() {
        contactListPage = new ContactListPage(driver);
        contactListPage.checkFirstContactWantedToBeAdded();
    }

    @Then("Chosen contact will be added to Contact List table")
    public void chosenContactWillBeAddedToContactListTable() {
        contactListPage = new ContactListPage(driver);
        contactListPage.validateChosenContactWillBeAddedToContactListTable("6282133334531");
    }

    @And("User upload excel template overwrite into pop-up Import File")
    public void userUploadExcelTemplateOverwriteIntoPopUpImportFile() {
        contactListPage = new ContactListPage(driver);
        contactListPage.uploadExcelTemplateOverwriteIntoPopUpImportFile();
    }

    @Then("Show pop-up Overwrite Data")
    public void showPopUpOverwriteData() {
        contactListPage = new ContactListPage(driver);
        contactListPage.validateShowPopUpOverwriteData();
    }

    @When("User click button Yes, Overwrite")
    public void userClickButtonYesOverwrite() {
        contactListPage = new ContactListPage(driver);
        contactListPage.clickButtonYesOverwrite();
    }

    @And("user click contact {string} and changed address {string}")
    public void userClickContactAndChangedAddress(String contact, String text) {
        contactListPage = new ContactListPage(driver);
        contactListPage.clickContactAndChangedAddress(contact, text);
    }

    @And("user click contact {string} and changed postal code {string}")
    public void userClickContactAndChangedPostalCode(String contact, String text) {
        contactListPage = new ContactListPage(driver);
        contactListPage.clickContactAndChangedPostalCode(contact, text);
    }

    @And("user click contact {string} and changed notes {string}")
    public void userClickContactAndChangedNotes(String contact, String text) {
        contactListPage = new ContactListPage(driver);
        contactListPage.clickContactAndChangedNotes(contact, text);
    }

    @When("User click button Skip")
    public void userClickButtonSkip() {
        contactListPage = new ContactListPage(driver);
        contactListPage.clickButtonSkip();
    }

    @When("User click button Export All")
    public void userClickButtonExportAll() {
        contactListPage = new ContactListPage(driver);
        contactListPage.clickButtonExportAll();
    }

    @Then("Show pop-up Export All Confirmation")
    public void showPopUpExportAllConfirmation() {
        contactListPage = new ContactListPage(driver);
        contactListPage.validateShowPopUpExportAllConfirmation();
    }

    @When("User click button Yes, Im Sure on Export All Confirmation")
    public void userClickButtonYesImSureOnExportAllConfirmation() {
        contactListPage = new ContactListPage(driver);
        contactListPage.clickButtonYesImSureOnExportAllConfirmation();
    }

    @Then("Contact list will be exported to excel format")
    public void contactListWillBeExportedToExcelFormat() {
        contactListPage = new ContactListPage(driver);
        contactListPage.validateContactListWillBeExportedToExcelFormat();
    }

    @When("User click and type {string} on field input search")
    public void userClickAndTypeOnFieldInputSearch(String text) {
        contactListPage = new ContactListPage(driver);
        contactListPage.clickAndTypeOnFieldInputSearch(text);
    }

    @And("User click button Search")
    public void userClickButtonSearch() {
        contactListPage = new ContactListPage(driver);
        contactListPage.clickButtonSearch();
    }

    @When("User click icon X on field input search")
    public void userClickIconXOnFieldInputSearch() {
        contactListPage = new ContactListPage(driver);
        contactListPage.clickIconXOnFieldInputSearch();
    }

    @When("User click icon filter on Contact Name")
    public void userClickIconFilterOnContactName() {
        contactListPage = new ContactListPage(driver);
        contactListPage.clickIconFilterOnContactName();
    }

    @And("User click Sort A-Z on pop-up filter")
    public void userClickSortAZOnPopUpFilter() {
        contactListPage = new ContactListPage(driver);
        contactListPage.clickSortAZOnPopUpFilter();
    }

    @And("User click Sort Z-A on pop-up filter")
    public void userClickSortZAOnPopUpFilter() {
        contactListPage = new ContactListPage(driver);
        contactListPage.clickSortZAOnPopUpFilter();
    }

    @And("User click button Set Filter on pop-up filter")
    public void userClickButtonSetFilterOnPopUpFilter() {
        contactListPage = new ContactListPage(driver);
        contactListPage.clickButtonSetFilterOnPopUpFilter();
    }

    @And("user click button Apply Filter on page Contact List")
    public void userClickButtonApplyFilterOnPageContactList() {
        contactListPage = new ContactListPage(driver);
        contactListPage.clickButtonApplyFilter();
    }

    @When("User click button Remove Filter")
    public void userClickButtonRemoveFilter() {
        contactListPage = new ContactListPage(driver);
        contactListPage.clickButtonRemoveFilter();
    }

    @And("User click expand Filter by Condition {string}")
    public void userClickExpandFilterByCondition(String text) {
        switch (text) {
            case "Name":
                contactListPage = new ContactListPage(driver);
                contactListPage.clickExpandFilterByConditionName();
                break;
            case "Activity":
                contactListPage = new ContactListPage(driver);
                contactListPage.clickExpandFilterByConditionActivity();
                break;
        }
    }

    @And("On field Condition choose {string}")
    public void onFieldConditionChoose(String text) {
        contactListPage = new ContactListPage(driver);
        contactListPage.onFieldConditionChoose(text);
    }

    @And("User type {string} on field condition")
    public void userTypeOnFieldCondition(String text) {
        contactListPage = new ContactListPage(driver);
        contactListPage.userTypeOnFieldCondition(text);
    }

    @And("User click icon filter {string} on column Checkbox")
    public void userClickIconFilterOnColumnCheckbox(String text) {
        String[] textArray = text.split(",");

        contactListPage = new ContactListPage(driver);
        contactListPage.userClickIconFilterOnColumnCheckbox(textArray);
    }

    @When("User click button Contact History on contact {string}")
    public void userClickButtonContactHistoryOnContact(String text) {
        contactListPage = new ContactListPage(driver);
        contactListPage.userClickButtonContactHistoryOnContact(text);
    }

    @Then("User will be redirected to page Contact History")
    public void userWillBeRedirectedToPageContactHistory() {
        contactListPage = new ContactListPage(driver);
        contactListPage.userWillBeRedirectedToPageContactHistory();
    }

    @And("Contact History list will shows all history data")
    public void contactHistoryListWillShowsAllHistoryData(DataTable dataTable) {
        List<Map<String, String>> list = dataTable.asMaps(String.class,String.class);

        contactListPage = new ContactListPage(driver);
        contactListPage.contactHistoryListWillShowsAllHistoryData(list);
    }

    @And("User click button Export History")
    public void userClickButtonExportHistory() {
        contactListPage = new ContactListPage(driver);
        contactListPage.userClickButtonExportHistory();
    }

    @And("User click button Yes, Im Sure on Export History Confirmation")
    public void userClickButtonYesImSureOnExportHistoryConfirmation() {
        contactListPage = new ContactListPage(driver);
        contactListPage.userClickButtonYesImSureOnExportHistoryConfirmation();
    }

    @Then("History list will be exported to excel format")
    public void historyListWillBeExportedToExcelFormat() {
        contactListPage = new ContactListPage(driver);
        contactListPage.historyListWillBeExportedToExcelFormat();
    }

    @When("User click icon filter Activity on Contact History page")
    public void userClickIconFilterActivityOnContactHistoryPage() {
        contactListPage = new ContactListPage(driver);
        contactListPage.userClickIconFilterActivityOnContactHistoryPage();
    }

    @When("User click button Edit Contact on Detail Contact panel")
    public void userClickButtonEditContactOnDetailContactPanel() {
        contactListPage = new ContactListPage(driver);
        contactListPage.userClickButtonEditContactOnDetailContactPanel();
    }

    @And("User click and type {string} on field Contact Name Contact List Detail")
    public void userClickAndTypeOnFieldContactNameContactListDetail(String text) {
        contactListPage = new ContactListPage(driver);
        contactListPage.userClickAndTypeOnFieldContactNameContactListDetail(text);
    }

    @And("User click and type {string} on field Address Contact List Detail")
    public void userClickAndTypeOnFieldAddressContactListDetail(String text) {
        contactListPage = new ContactListPage(driver);
        contactListPage.userClickAndTypeOnFieldAddressContactListDetail(text);
    }

    @And("User click button Save on Contact List Detail")
    public void userClickButtonSaveOnContactListDetail() {
        contactListPage = new ContactListPage(driver);
        contactListPage.userClickButtonSaveOnContactListDetail();
    }

    @And("User click button Edit Bulk on Contact List Page")
    public void userClickButtonEditBulkOnContactListPage() {
        contactListPage = new ContactListPage(driver);
        contactListPage.userClickButtonEditBulkOnContactListPage();
    }

    @Then("Show pop-up Edit Bulk")
    public void showPopUpEditBulk() {
        contactListPage = new ContactListPage(driver);
        contactListPage.showPopUpEditBulk();
    }

    @When("User click and type {string} on field Country Edit Bulk")
    public void userClickAndTypeOnFieldCountryEditBulk(String text) {
        contactListPage = new ContactListPage(driver);
        contactListPage.userClickAndTypeOnFieldCountryEditBulk(text);
    }

    @And("User click and type {string} on field Province Edit Bulk")
    public void userClickAndTypeOnFieldProvinceEditBulk(String text) {
        contactListPage = new ContactListPage(driver);
        contactListPage.userClickAndTypeOnFieldProvinceEditBulk(text);
    }

    @And("User click on Tag Edit Bulk and choose {string}")
    public void userClickOnTagEditBulkAndChoose(String text) {
        contactListPage = new ContactListPage(driver);
        contactListPage.userClickOnTagEditBulkAndChoose(text);
    }

    @And("User click and type {string} on field Tag Edit Bulk")
    public void userClickAndTypeOnFieldTagEditBulk(String text) {
        contactListPage = new ContactListPage(driver);
        contactListPage.userClickAndTypeOnFieldTagEditBulk(text);
    }

    @And("user click button Save on Edit Bulk")
    public void userClickButtonSaveOnEditBulk() {
        contactListPage = new ContactListPage(driver);
        contactListPage.userClickButtonSaveOnEditBulk();
    }


    @Then("User see warn upload more than 1000 data")
    public void userSeeWarnUploadMoreThanData() {
        contactListPage = new ContactListPage(driver);
        contactListPage.userSeeWarnUploadMoreThanData();
    }

    @And("User upload excel template 1000 Overwrite into pop-up Import File")
    public void userUploadExcelTemplate1000OverwriteIntoPopUpImportFile() {
        contactListPage = new ContactListPage(driver);
        contactListPage.userUploadExcelTemplate1000OverwriteIntoPopUpImportFile();
    }

    @Then("User see pop-up Skip or Overwrite")
    public void userSeePopUpSkipOrOverwrite() {
        contactListPage = new ContactListPage(driver);
        contactListPage.userSeePopUpSkipOrOverwrite();
    }

    @And("User upload excel template 20 into pop-up Import File")
    public void userUploadExcelTemplate20IntoPopUpImportFile() {
        contactListPage = new ContactListPage(driver);
        contactListPage.userUploadExcelTemplate20IntoPopUpImportFile();
    }

    @When("User click button Next pagination on Contact List")
    public void userClickButtonNextPaginationOnContactList() {
        contactListPage = new ContactListPage(driver);
        contactListPage.userClickButtonNextPaginationOnContactList();
    }

    @Then("User on page {int} of Contact List")
    public void userOnPageOfContactList(int number) {
        contactListPage = new ContactListPage(driver);
        contactListPage.userOnPageOfContactList(number);
    }

    @When("User click button Prev pagination on Contact List")
    public void userClickButtonPrevPaginationOnContactList() {
        contactListPage = new ContactListPage(driver);
        contactListPage.userClickButtonPrevPaginationOnContactList();
    }

    @When("User click field data view on pagination and choose {string}")
    public void userClickFieldDataViewOnPaginationAndChoose(String arg0) {
        contactListPage = new ContactListPage(driver);
        contactListPage.userClickFieldDataViewOnPaginationAndChoose(arg0);
    }

    @Then("Table Contact List will only show {int} row data Contact List")
    public void tableContactListWillOnlyShowRowDataContactList(int number) {
        contactListPage = new ContactListPage(driver);
        contactListPage.tableContactListWillOnlyShowRowDataContactList(number);
    }

    @When("User click button Delete on contact {string}")
    public void userClickButtonDeleteOnContact(String text) {
        contactListPage = new ContactListPage(driver);
        contactListPage.clickButtonDeleteOnContact(text);
    }

    @Then("Show pop-up Delete confirmation")
    public void showPopUpDeleteConfirmation() {
        contactListPage = new ContactListPage(driver);
        contactListPage.showPopUpDeleteConfirmation();
    }

    @When("User click button Yes, I’m Sure on Delete confirmation")
    public void userClickButtonYesIMSureOnDeleteConfirmation() {
        contactListPage = new ContactListPage(driver);
        contactListPage.userClickButtonYesIMSureOnDeleteConfirmation();
    }

    @And("user click button Delete Bulk on Contact List page")
    public void userClickButtonDeleteBulkOnContactListPage() {
        contactListPage = new ContactListPage(driver);
        contactListPage.userClickButtonDeleteBulkOnContactListPage();
    }

    @Then("Show pop-up Delete Bulk confirmation")
    public void showPopUpDeleteBulkConfirmation() {
        contactListPage = new ContactListPage(driver);
        contactListPage.showPopUpDeleteBulkConfirmation();
    }

    @When("User click button Yes, I’m Sure on Delete Bulk confirmation")
    public void userClickButtonYesIMSureOnDeleteBulkConfirmation() {
        contactListPage = new ContactListPage(driver);
        contactListPage.userClickButtonYesIMSureOnDeleteBulkConfirmation();
    }

    @When("User type {string} on input search Contact History")
    public void userTypeOnInputSearchContactHistory(String text) {
        contactListPage = new ContactListPage(driver);
        contactListPage.userTypeOnInputSearchContactHistory(text);
    }

    @Then("Table Contact List History will be filtered with blue highlighted")
    public void tableContactListHistoryWillBeFilteredWithBlueHighlighted() {
        contactListPage = new ContactListPage(driver);
        contactListPage.tableContactListHistoryWillBeFilteredWithBlueHighlighted();
    }

    @When("User click icon X on input search Contact History")
    public void userClickIconXOnInputSearchContactHistory() {
        contactListPage = new ContactListPage(driver);
        contactListPage.userClickIconXOnInputSearchContactHistory();
    }

    @Then("Table Contact List History will be back to normal")
    public void tableContactListHistoryWillBeBackToNormal() {
        contactListPage = new ContactListPage(driver);
        contactListPage.tableContactListHistoryWillBeBackToNormal();
    }

    @When("User click icon filter SessionID on Contact History page")
    public void userClickIconFilterSessionIDOnContactHistoryPage() {
        contactListPage = new ContactListPage(driver);
        contactListPage.userClickIconFilterSessionIDOnContactHistoryPage();
    }

    @And("User click expand Filter by Value {string}")
    public void userClickExpandFilterByValue(String text) {
        switch (text) {
            case "SessionID":
                contactListPage = new ContactListPage(driver);
                contactListPage.userClickExpandFilterByValue();
                break;
        }
    }

    @And("On field filter by value tick only one")
    public void onFieldFilterByValueTickOnlyOne() {
        contactListPage = new ContactListPage(driver);
        contactListPage.onFieldFilterByValueTickOnlyOne();
    }

    @Then("Search chat will found nothing")
    public void searchChatWillFoundNothing() {
        chatPage = new ChatPage(driver);
        chatPage.searchChatWillFoundNothing();
    }
}

