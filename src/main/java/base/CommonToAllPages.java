package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertiesReader;

import java.io.IOException;
import java.time.Duration;

//import static driver.DriverManager.getDriver;
import static driver.DriverManagerPL.getDriver;

public class CommonToAllPages {

    public void clickElement(By by) {
        getDriver().findElement(by).click();
    }

    public void clickElement(WebElement by) {
        by.click();
    }

    public void enterElement(By by, String value) {
        getDriver().findElement(by).sendKeys(value);
    }

    public void enterElement(WebElement by, String value) {
        by.sendKeys(value);
    }

    public String getText(By by) {
       return getDriver().findElement(by).getText();
    }

    public void getText(WebElement by) {
        by.getText();
    }

    public void visibiltyOfElement(By by) {

        new WebDriverWait(getDriver(), Duration.ofSeconds(5000))
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement elementToBeClickable(WebElement by) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(3000))
                .until(ExpectedConditions.elementToBeClickable(by));
    }

    public void findElement(By by) {
        getDriver().findElement(by);
    }

    public void getUrl(String url) throws IOException {
        getDriver().get(PropertiesReader.readkey(url));
        
    }
    public void maximize( )
    {
        getDriver().manage().window().maximize();
    }

}
