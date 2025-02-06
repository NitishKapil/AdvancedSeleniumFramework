package pages.pageObjectModel.vWOPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashBoardpage {

    WebDriver driver;
    WebDriverWait wait;
    private By userNameOnDashboard = By.xpath("//span[@data-qa=\"lufexuloga\"]");

    public DashBoardpage(WebDriver driver) {
        this.driver = driver;
    }

    public String userName()
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(userNameOnDashboard));
        String name1 = driver.findElement(userNameOnDashboard).getText();
        System.out.println(name1);
        return name1;
    }


}
