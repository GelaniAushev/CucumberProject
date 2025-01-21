package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonMethods extends PageInitializer{

    public static WebDriver driver;

    public void openBrowserAndLaunchApplication(){
        switch (ConfigReader.read("browser")){
            case "Chrome":
                driver=new ChromeDriver();
                break;
            case "FireFox":
                driver=new FirefoxDriver();
                break;
            case "Edge":
                driver=new EdgeDriver();
                break;
            case "Safari":
                driver=new SafariDriver();
                break;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(ConfigReader.read("url"));
        initializePageObjects();
    }

    public void closeBrowser(){
        if (driver!=null){
            driver.quit();
        }
    }

    public void sendText(String text, WebElement element){
        element.clear();
        element.sendKeys(text);
    }

    public WebDriverWait getWait(){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(Constants.EXPLICIT_WAIT));
        return wait;
    }

    public void waitForElementToBeClickAble(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public void click(WebElement element){
        waitForElementToBeClickAble(element);
        element.click();
    }


}
