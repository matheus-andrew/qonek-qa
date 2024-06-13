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
        contactListPage.clickButtonRahmadhany();

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

    @And("User click button 'Save Chat Tabs'")
    public void userClickButtonSaveChatTabs() {
        chatPage = new ChatPage(driver);
        chatPage.clickButtonSaveChatTabs();
    }
}

