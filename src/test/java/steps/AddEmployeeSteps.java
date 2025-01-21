package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.CommonMethods;

import java.time.Duration;

public class AddEmployeeSteps extends CommonMethods {

    @When("user clicks on PIM button")
    public void user_clicks_on_pim_button() {
        WebElement PIM= driver.findElement(By.id("menu_pim_viewPimModule"));
        PIM.click();
    }
    @When("user clicks on Add Employee button")
    public void user_clicks_on_add_employee_button() {
        click(dashboardPage.addEmpOpt);
    }
    @When("user enters firstname and middlename and lastname")
    public void user_enters_firstname_and_middlename_and_lastname() {
        sendText("Bobby", addEmployeePage.firstNameLoc);
        sendText("ms", addEmployeePage.middleNameLoc);
        sendText("Johnson", addEmployeePage.lastNameLoc);
    }
    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        click(addEmployeePage.saveBtn);
    }
    @Then("user adds employee successfully")
    public void user_adds_employee_successfully() {
        System.out.println("Employee Added");
    }

    @When("user enters firstname and middlename and lastname and ID")
    public void user_enters_firstname_and_middlename_and_lastname_and_id() {
        sendText("Bobby", addEmployeePage.firstNameLoc);
        sendText("Junior", addEmployeePage.middleNameLoc);
        sendText("Johnson", addEmployeePage.lastNameLoc);
        sendText("01337007", addEmployeePage.employeeID);

    }

}
