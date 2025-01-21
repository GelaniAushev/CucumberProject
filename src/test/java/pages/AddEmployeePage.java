package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AddEmployeePage extends CommonMethods {

    @FindBy(id="firstName")
    public WebElement firstNameLoc;

    @FindBy(id="btnSave")
    public WebElement saveBtn;

    @FindBy(id="middleName")
    public WebElement middleNameLoc;

    @FindBy(id="lastName")
    public WebElement lastNameLoc;

    @FindBy(id = "employeeId")
    public WebElement employeeID;

    public AddEmployeePage() {
        PageFactory.initElements(driver,this);
    }

}
