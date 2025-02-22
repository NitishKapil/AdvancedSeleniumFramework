package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.PropertiesReader;

import java.io.IOException;

public class DriverManager {

    public static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }


    public static void init() throws IOException {
        String browser = PropertiesReader.readkey("browser");
        browser.toLowerCase();
        if (driver == null) {
            switch (browser) {
                case "chrome":
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    driver.manage().window().maximize();
                    break;
                default:
                    System.out.println("No browser found !");


            }

        }
    }

    public static void down() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }


}
