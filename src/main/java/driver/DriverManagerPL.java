package driver;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.PropertiesReader;

import java.io.IOException;
import java.util.Objects;

public class DriverManagerPL {

    public static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<WebDriver>();

    public static void setDriver(WebDriver driver) {

        driverThreadLocal.set(driver);

    }

    public static WebDriver getDriver() {
        return driverThreadLocal.get();

    }

    public static void unLoad() {
        driverThreadLocal.remove();
    }

    public static void down() {
        if (Objects.nonNull(DriverManagerPL.getDriver())) {
            getDriver().quit();
            unLoad();
        }
        }

    public static void init() {
        if (Objects.isNull(DriverManagerPL.getDriver())) {
            ChromeOptions options = new ChromeOptions();

            long threadId = Thread.currentThread().getId();
            System.out.println("Thread ID: " + threadId);

            // Assign different positions before launching the browser
            if (threadId % 3 == 0) {
                options.addArguments("--window-position=200,0");  // Left Side
            } else if (threadId % 3 == 1) {
                options.addArguments("--window-position=300,0");  // Right Side
            }
            WebDriver driver = new ChromeDriver(options);
            setDriver(driver);



        }

    }


}
