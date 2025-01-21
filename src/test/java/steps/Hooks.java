package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.CommonMethods;

import java.io.IOException;

public class Hooks extends CommonMethods {

    @Before
    public void start()throws IOException{
        openBrowserAndLaunchApplication();
    }

    @After
    public void end(Scenario scenario){
        closeBrowser();
    }

}
