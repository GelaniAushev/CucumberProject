package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class DashboardPage extends CommonMethods {

    @FindBy(id="menu_pim_viewPimModule")
    public WebElement pimOpt;

    @FindBy(id="menu_pim_viewEmployeeList")
    public WebElement empListOpt;

    @FindBy(id="menu_pim_addEmployee")
    public WebElement addEmpOpt;

    @FindBy(id="welcome")
    public WebElement messageText;

    public DashboardPage() {
        PageFactory.initElements(driver,this);
    }

}
