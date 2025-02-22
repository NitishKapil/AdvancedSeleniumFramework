package base;

import driver.DriverManager;
import driver.DriverManagerPL;
import io.qameta.allure.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.io.IOException;

public class CommonToAllTest {

    @Description("Allure report with the Testng")
    @BeforeMethod
    public void strtUp() throws IOException {
       // DriverManager.init();
        DriverManagerPL.init();

    }

    @AfterMethod
    public void tearDown()
    {
        DriverManagerPL.down();
    //    DriverManager.down();
    }

}
