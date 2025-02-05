package base;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class baseClass {

    @Description("Allure report with the Testng")
    @Test
    public void methodDrYiver()
    {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
    }
}
