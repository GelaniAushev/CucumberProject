package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.CommonMethods;
import utils.ConfigReader;

import java.time.Duration;

public class LoginSteps extends CommonMethods {

    @When("user enters correct username and password")
    public void user_enters_correct_username_and_password() {
        sendText(ConfigReader.read("userName"), loginPage.usernameField);
        sendText(ConfigReader.read("password"), loginPage.passwordField);
    }
    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        click(loginPage.loginBtn);
    }
    @Then("user is able to see dashboard page")
    public void user_is_able_to_see_dashboard_page() {
        Assert.assertTrue(dashboardPage.messageText.isDisplayed());
        System.out.println("Test is passed");
    }

    @When("user enters incorrect username and password")
    public void user_enters_incorrect_username_and_password() {
        sendText("admin1", loginPage.usernameField);
        sendText("Human", loginPage.passwordField);
    }
    @Then("user is able to see error message")
    public void user_is_able_to_see_error_message() {
        String errorValue=loginPage.errorMessage.getText();
        Assert.assertEquals("Invalid credentials",errorValue);
        System.out.println("Error Message");
    }

}
