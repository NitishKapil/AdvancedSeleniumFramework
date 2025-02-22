package pages.pageObjectModel.vWOPage;

import base.CommonToAllPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertiesReader;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;

public class LoginPage extends CommonToAllPages {

    WebDriver driver;
    WebDriverWait wait;
    WebElement element;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locator of LoginPage of VWO
    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By Sign_Button = By.id("js-login-btn");
    private By errorText = By.id("js-notification-box-msg");

    public String loginVwoInvalidWay(String user, String pass) throws IOException {
        getUrl("URL");
        enterElement(username, user);
        enterElement(password, pass);
        clickElement(Sign_Button);
        visibiltyOfElement(errorText);
        String errorMsg = getText(errorText);
        System.out.println(errorMsg);
        return errorMsg;
    }

    public void loginVwoValidWay(String user, String pass) throws IOException {
        getUrl("URL");
        enterElement(username,user);
        enterElement(password,pass);
        clickElement(Sign_Button);

    }

}
