package pages.pageObjectModel.vWOPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

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

    public String loginVwoInvalidWay(String user, String pass) {
        driver.get("https://app.vwo.com/#/login");
        driver.manage().window().maximize();
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(Sign_Button).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorText));
        String errorMsg = driver.findElement(errorText).getText();
        System.out.println(errorMsg);
        return errorMsg;
    }
    public void loginVwoValidWay(String user, String pass) {
        driver.get("https://app.vwo.com/#/login");
        driver.manage().window().maximize();
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(Sign_Button).click();

    }

}
