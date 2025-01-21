package utils;

import pages.AddEmployeePage;
import pages.DashboardPage;
import pages.EmployeeSearchPage;
import pages.LoginPage;

public class PageInitializer {

    public static LoginPage loginPage;
    public static EmployeeSearchPage employeeSearchPage;
    public static DashboardPage dashboardPage;
    public static AddEmployeePage addEmployeePage;


    public static void initializePageObjects(){
        loginPage=new LoginPage();
        employeeSearchPage=new EmployeeSearchPage();
        dashboardPage=new DashboardPage();
        addEmployeePage=new AddEmployeePage();
    }


}
