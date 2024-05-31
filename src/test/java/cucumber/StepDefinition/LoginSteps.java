package cucumber.StepDefinition;

import cucumber.Page.LoginPage;
import cucumber.util.CreateDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;

public class LoginSteps {

    private WebDriver driver;

    LoginPage loginPage;

    public LoginSteps(){
        driver = CreateDriver.getInstance().getDriver();
    }

    @Given("User in login page")
    public void userInLoginPage() {
        driver.get("https://qonek-uat.web.app/");
    }

    @When("User input username {string} and password {string}")
    public void userInputUsernameAndPassword(String username, String password) {
        loginPage = new LoginPage(driver);
        loginPage.inputEmail(username);
        loginPage.inputPassword(password);
    }

    @Then("User will see login error message {string}")
    public void userWillSeeLoginErrorMessage(String text) {
        loginPage = new LoginPage(driver);
        loginPage.validateLoginErrorMessage(text);
    }

    @And("User click login button")
    public void userClickLoginButton() {
        loginPage = new LoginPage(driver);
        loginPage.clickSignIn();
    }
}
