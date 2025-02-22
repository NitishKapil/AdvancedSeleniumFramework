package test.vWoTestCases;

import base.CommonToAllTest;
import driver.DriverManager;
import driver.DriverManagerPL;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import listners.RetryAnalyzer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.pageObjectModel.vWOPage.DashBoardpage;
import pages.pageObjectModel.vWOPage.LoginPage;
import utils.PropertiesReader;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@Test(retryAnalyzer = RetryAnalyzer.class)
public class vWoTestCases_Properties_DriverManager extends CommonToAllTest {

    @Test
    public void negativeTestCase() throws IOException {
        LoginPage loginPage = new LoginPage(DriverManagerPL.getDriver());
        String errorText = loginPage.loginVwoInvalidWay(PropertiesReader.readkey("inValidUsername"), PropertiesReader.readkey("inValidPassword"));
        assertThat(errorText).isEqualToIgnoringCase(PropertiesReader.readkey("error_msg"));
    }

    @Owner("Nitish Kapil")
    @Description("Positive Test of Login Credentials")
    @Test
    public void positiveTestCase() throws IOException {
      LoginPage loginPage = new LoginPage(DriverManagerPL.getDriver());
        loginPage.loginVwoValidWay(PropertiesReader.readkey("validUsername"), PropertiesReader.readkey("validPassword"));
        DashBoardpage dashBoardpage = new DashBoardpage(DriverManagerPL.getDriver());
        String name = dashBoardpage.userName();
        System.out.println(name);
        assertThat(name).isEqualToIgnoringCase(PropertiesReader.readkey("name"));
     //
    }


}
