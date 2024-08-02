package cucumber.StepDefinition;

import cucumber.Page.ChatTemplatePage;
import cucumber.Page.LoginPage;
import cucumber.util.CreateDriver;
import cucumber.util.PropertiesLoader;
import cucumber.util.Utils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

public class ChatTemplateSteps {

    private WebDriver driver;

    LoginPage loginPage;
    ChatTemplatePage chatTemplatePage;

    public ChatTemplateSteps(){
        driver = CreateDriver.getInstance().getDriver();
    }

    @Given("User already login")
    public void userAlreadyLogin() throws IOException {
        Properties conf = PropertiesLoader.loadProperties();
        String username = conf.getProperty("username");
        String password = conf.getProperty("password");
        String qonekurl = conf.getProperty("qonekurl");

        long startTime = System.currentTimeMillis();

        loginPage = new LoginPage(driver);
        loginPage.goToLoginPage(qonekurl);
        loginPage.inputEmail(username);
        loginPage.inputPassword(password);
        loginPage.clickSignIn();
        loginPage.validateInHomePage();

        long duration = System.currentTimeMillis() - startTime;
        System.out.println("Total time needed to login : " + Utils.convertMillisToString(duration));
    }

    @Given("User already login with account {string} and password {string}")
    public void userAlreadyLoginWithAccount(String username, String password) throws IOException {
        Properties conf = PropertiesLoader.loadProperties();
        String qonekurl = conf.getProperty("qonekurl");

        loginPage = new LoginPage(driver);
        loginPage.goToLoginPage(qonekurl);
        loginPage.inputEmail(username);
        loginPage.inputPassword(password);
        loginPage.clickSignIn();
        loginPage.validateInHomePage();
    }

    @And("User in chat template page")
    public void userInChatTemplatePage() {
        chatTemplatePage = new ChatTemplatePage(driver);
        chatTemplatePage.goToGuidebookPage();

        try {
            chatTemplatePage.deleteAllTemplate();
        } catch (Exception ignored) {}
    }

    @And("User not yet have Chat Template previously and have {string} button")
    public void userNotYetHaveChatTemplatePreviouslyAndHaveButton(String text) {
        chatTemplatePage = new ChatTemplatePage(driver);
        chatTemplatePage.assertButtonCreateNewTemplate(text);
    }

    @When("User click button Create New Template")
    public void userClickButtonCreateNewTemplate() {
        chatTemplatePage = new ChatTemplatePage(driver);
        chatTemplatePage.clickCreateNewTemplate();
    }

    @Then("Show pop-up Create New Chat Template")
    public void showPopUpCreateNewChatTemplate() {
        chatTemplatePage = new ChatTemplatePage(driver);
        chatTemplatePage.waitUntilPopUpNewTemplateCreationShown();
    }

    @And("Have 2 sides which is 'Editorial Template' and 'Preview Template'")
    public void haveTwoSidesWhichIsEditorialTemplateAndPreviewTemplate() {
        chatTemplatePage = new ChatTemplatePage(driver);
        chatTemplatePage.assertPopUpNewTemplateCreationHasTwoSides();
    }

    @And("Validate attributes on 'Editorial Template' form")
    public void validateAttributesOnEditorialTemplateForm() {
        chatTemplatePage = new ChatTemplatePage(driver);
        chatTemplatePage.assertEditorialTemplateHasTemplateName();
        chatTemplatePage.assertEditorialTemplateHasButtonLoadExisting();
        chatTemplatePage.assertEditorialTemplateHasBubbleChatNumber(1);
        chatTemplatePage.assertEditorialTemplateHasButtonAddBubbleChat();
        chatTemplatePage.assertEditorialTemplateHasButtonWaitForSecond();
        chatTemplatePage.assertEditorialTemplateHasInputHotKey();
    }

    @And("Validate attributes on 'Preview Template' form")
    public void validateAttributesOnPreviewTemplateForm() {
        chatTemplatePage = new ChatTemplatePage(driver);
        chatTemplatePage.assertPreviewTemplateHasMessagePreviewContainer();
        chatTemplatePage.assertPreviewTemplateHasButtonCreateNewTemplate();
    }

    @When("User input template name with {string}")
    public void userInputTemplateNameWith(String text) {
        chatTemplatePage = new ChatTemplatePage(driver);
        chatTemplatePage.inputEditorialTemplateTemplateName(text);
    }

    @Then("Input form template name will be filled with {string}")
    public void inputFormTemplateNameWillBeFilledWith(String text) {
        chatTemplatePage = new ChatTemplatePage(driver);
        chatTemplatePage.assertEditorialTemplateTemplateNameValue(text);
    }

    @When("User click and type {string} in form box Bubble Chat {int}")
    public void userClickAndTypeInFormBoxBubbleChat(String text, int number) {
        chatTemplatePage = new ChatTemplatePage(driver);
        chatTemplatePage.inputEditorialTemplateBubbleChat(number, text);
    }

    @Then("Box bubble chat {int} will be filled with message {string}")
    public void boxBubbleChatWillBeFilledWithMessage(int number, String text) {
        chatTemplatePage = new ChatTemplatePage(driver);
        if (text.contains("[Image]"))   {
            text = text.substring(text.indexOf("+") + 2);
            chatTemplatePage.assertEditorialTemplateBubbleChatImage(number);
        }
        chatTemplatePage.assertEditorialTemplateBubbleChatValue(number, text);
    }

    @And("On preview will show bubble chat {int} with message {string}")
    public void onPreviewWillShowBubbleChatWithMessage(int number, String text) {
        chatTemplatePage = new ChatTemplatePage(driver);
        chatTemplatePage.assertPreviewTemplateMessagePreview(number, text);
    }

    @When("User click button Add Bubble Chat")
    public void userClickButtonAddBubbleChat() {
        chatTemplatePage = new ChatTemplatePage(driver);
        chatTemplatePage.clickEditorialTemplateButtonAddBubbleChat();
    }

    @Then("Will shows new bubble chat {int} on 'Editorial Template'")
    public void willShowsNewBubbleChatOnEditorialTemplate(int number) {
        chatTemplatePage = new ChatTemplatePage(driver);
        chatTemplatePage.assertEditorialTemplateHasBubbleChatNumber(number);
    }

    @When("User click button 'Add File' on bubble chat {int}")
    public void userClickButtonAddFile(int number) {
        chatTemplatePage = new ChatTemplatePage(driver);
        chatTemplatePage.clickEditorialTemplateButtonAddFile(number);
    }

    @And("User click choose 'Image'")
    public void userClickChooseImage() {
        chatTemplatePage = new ChatTemplatePage(driver);
        chatTemplatePage.clickEditorialTemplateChooseImage();
    }

    @And("User upload image")
    public void userUploadImage() {
        chatTemplatePage = new ChatTemplatePage(driver);
        chatTemplatePage.clickEditorialTemplateUploadImage();
    }

    @Then("Chosen image will be added in bubble chat {int} box")
    public void chosenImageWillBeAddedInBubbleChatBox(int number) {
        chatTemplatePage = new ChatTemplatePage(driver);
        chatTemplatePage.assertEditorialTemplateBubbleChatImage(number);
    }

    @When("User click and type {string} on form Template Hotkey")
    public void userClickAndTypeOnFormTemplateHotkey(String text) throws InterruptedException {
        chatTemplatePage = new ChatTemplatePage(driver);
        chatTemplatePage.inputEditorialTemplateHotkey(text);
    }

    @Then("Input form Template Hotkey will be active and filled with {string}")
    public void inputFormTemplateHotkeyWillBeActiveAndFilledWith(String text) {
        chatTemplatePage = new ChatTemplatePage(driver);
        chatTemplatePage.assertEditorialTemplateHotkeyValue(text);
    }

    @When("User click button Create Template")
    public void userClickButtonCreateTemplate() {
        chatTemplatePage = new ChatTemplatePage(driver);
        chatTemplatePage.clickEditorialTemplateButtonCreateTemplate();
    }

    @Then("Pop-up will be closed")
    public void popUpWillBeClosed() {
        chatTemplatePage = new ChatTemplatePage(driver);
        chatTemplatePage.waitUntilPopUpNewTemplateCreationClosed();
    }

    @And("Template will be added in template table list with columns")
    public void templateWillBeAddedInTemplateTableListWithColumns(DataTable table) {
        List<List<String>> list = table.asLists(String.class);
        for (List<String> data : list) {
            String templateName = data.get(0);
            String hotkey = data.get(1);
            String createdTime = data.get(2);
            String guideBook = data.get(3);

            if (Objects.equals(createdTime, "[today]")) {
                String pattern = "dd/MM/yyyy";
                createdTime = new SimpleDateFormat(pattern).format(new Date());
            }

            chatTemplatePage = new ChatTemplatePage(driver);
            chatTemplatePage.assertEditorialTemplateTableColumns(templateName, hotkey, createdTime, guideBook);
        }
    }

    @And("On right side of table will have column button 'Edit' dan 'Delete'")
    public void onRightSideOfTableWillHaveColumnButtonEditDanDelete() {
        chatTemplatePage = new ChatTemplatePage(driver);
        chatTemplatePage.assertEditorialTemplateTableButtonEditDelete();
    }

    @And("User click Delete template on table list")
    public void userClickDeleteTemplateOnTableList() throws InterruptedException {
        chatTemplatePage = new ChatTemplatePage(driver);
        chatTemplatePage.deleteAllTemplate();
    }

    @Given("User already created chat template {string}")
    public void userAlreadyCreatedChatTemplate(String text) {
        chatTemplatePage = new ChatTemplatePage(driver);
        chatTemplatePage.assertChatTemplateCreated(text);
    }

    @And("User see button “New Template” on top right page")
    public void userSeeButtonNewTemplateOnTopRightPage() {
        chatTemplatePage = new ChatTemplatePage(driver);
        chatTemplatePage.assertChatTemplateButtonNewTemplate();
    }

    @And("Close pop up and delete chat template")
    public void closePopUpAndDeleteChatTemplate() throws InterruptedException {
        chatTemplatePage = new ChatTemplatePage(driver);
        chatTemplatePage.clickPopUpNewTemplateCreationCloseButton();
        chatTemplatePage.deleteAllTemplate();
    }

    @When("User click button 'Load Existing'")
    public void userClickButtonLoadExisting() {
        chatTemplatePage = new ChatTemplatePage(driver);
        chatTemplatePage.clickChatTemplateButtonLoadExisting();
    }

    @Then("User see dropdown list of Chat Template which already created")
    public void userSeeDropdownListOfChatTemplateWhichAlreadyCreated() {
        chatTemplatePage = new ChatTemplatePage(driver);
        chatTemplatePage.assertChatTemplateDropdownList();
    }

    @When("User choose chat template {string}")
    public void userChooseChatTemplate(String text) {
        chatTemplatePage = new ChatTemplatePage(driver);
        chatTemplatePage.clickChatTemplateDropdownList(text);
    }

    @And("Button Create Template will be changed to {string}")
    public void buttonCreateTemplateWillBeChangedTo(String text) {
        chatTemplatePage = new ChatTemplatePage(driver);
        chatTemplatePage.assertChatTemplateButtonCreateTemplate(text);
    }

    @When("User edit form bubble chat {int} with message {string}")
    public void userEditFormBubbleChatWithMessage(int number, String text) {
        chatTemplatePage = new ChatTemplatePage(driver);
        chatTemplatePage.editEditorialTemplateBubbleChat(number, text);
    }

    @When("User click button Edit Template")
    public void userClickButtonEditTemplate() {
        chatTemplatePage = new ChatTemplatePage(driver);
        chatTemplatePage.clickEditorialTemplateButtonCreateTemplate();
    }

    @And("Template {string} will be updated with bubble chat {int} message is {string}")
    public void templateWillBeUpdatedWithBubbleChatMessageIs(String templateName, int number, String message) {
        chatTemplatePage = new ChatTemplatePage(driver);
        chatTemplatePage.assertEditedTemplate(templateName, number, message);
    }

    @When("User edit form Template Name to {string}")
    public void userEditFormTemplateNameTo(String text) throws InterruptedException {
        chatTemplatePage = new ChatTemplatePage(driver);
        chatTemplatePage.editEditorialTemplateName(text);

    }

    @And("User edit form Template Hotkey to {string}")
    public void userEditFormTemplateHotkeyTo(String text) throws InterruptedException {
        chatTemplatePage = new ChatTemplatePage(driver);
        chatTemplatePage.editEditorialTemplateHotkey(text);
    }

    @And("Template will be added in list with Template Name {string} and Template Hotkey {string}")
    public void templateWillBeAddedInListWithTemplateNameAndTemplateHotkey(String templateName, String hotkey) {
        chatTemplatePage = new ChatTemplatePage(driver);
        chatTemplatePage.assertAddedTemplate(templateName, hotkey);
    }

    @And("Template {string} still exists in list template table")
    public void templateStillExistsInListTemplateTable(String templateName) {
        chatTemplatePage = new ChatTemplatePage(driver);
        chatTemplatePage.assertTemplateStillExistsInTable(templateName);
    }

    @And("User see a few template on list template table")
    public void userSeeAFewTemplateOnListTemplateTable() {
        chatTemplatePage = new ChatTemplatePage(driver);
        chatTemplatePage.assertListTemplateTable();
    }

    @When("User click button 'Edit' on template name {string}")
    public void userClickButtonEditOnTemplateName(String text) {
        chatTemplatePage = new ChatTemplatePage(driver);
        chatTemplatePage.clickEditButtonOnTemplateName(text);
    }

    @Then("Show pop-up Edit Chat Template")
    public void showPopUpEditChatTemplate() {
        chatTemplatePage = new ChatTemplatePage(driver);
        chatTemplatePage.waitUntilPopUpNewTemplateCreationShown();
    }

    @And("User see button 'Save Template'")
    public void userSeeButtonSaveTemplate() {
        chatTemplatePage = new ChatTemplatePage(driver);
        chatTemplatePage.assertButtonSaveTemplate();
    }

    @And("User click button 'Save Template'")
    public void userClickButtonSaveTemplate() {
        chatTemplatePage = new ChatTemplatePage(driver);
        chatTemplatePage.clickSaveTemplateButton();
    }

    @And("Edit form template name will be filled with {string}")
    public void editFormTemplateNameWillBeFilledWith(String text) {
        chatTemplatePage = new ChatTemplatePage(driver);
        chatTemplatePage.assertEditorialTemplateTemplateName(text);
    }

    @Then("Form Template Hotkey will be error with red highlight")
    public void formTemplateHotkeyWillBeErrorWithRedHighlight() {
        chatTemplatePage = new ChatTemplatePage(driver);
        chatTemplatePage.assertEditorialTemplateHotkeyError();
    }

    @And("User will see error message {string}")
    public void userWillSeeErrorMessage(String text) {
        chatTemplatePage = new ChatTemplatePage(driver);
        chatTemplatePage.assertErrorMessage(text);
    }

    @Then("Pop-up will not be closed")
    public void popUpWillNotBeClosed() {
        chatTemplatePage = new ChatTemplatePage(driver);
        chatTemplatePage.assertPopUpNewTemplateCreationIsNotClosed();
    }

    @And("Template cannot be saved")
    public void templateCannotBeSaved() {
        chatTemplatePage = new ChatTemplatePage(driver);
        chatTemplatePage.assertTemplateCannotBeSaved();
    }


}
