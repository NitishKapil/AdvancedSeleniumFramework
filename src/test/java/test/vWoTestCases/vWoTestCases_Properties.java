package test.vWoTestCases;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.pageObjectModel.vWOPage.DashBoardpage;
import pages.pageObjectModel.vWOPage.LoginPage;
import utils.PropertiesReader;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class vWoTestCases_Properties {

    @Test
    public void negativeTestCase() throws IOException {
        WebDriver driver = new ChromeDriver();
        LoginPage loginPage = new LoginPage(driver);
        String errorText = loginPage.loginVwoInvalidWay(PropertiesReader.readkey("inValidUsername"),PropertiesReader.readkey("inValidPassword"));
        assertThat(errorText).isEqualToIgnoringCase(PropertiesReader.readkey("error_msg"));
    }

    @Owner("Nitish Kapil")
    @Description("Positive Test of Login Credentials")
    @Test
    public void positiveTestCase() throws IOException {
        WebDriver driver = new ChromeDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginVwoValidWay(PropertiesReader.readkey("validUsername"),PropertiesReader.readkey("validPassword"));
        DashBoardpage dashBoardpage = new DashBoardpage(driver);
        String name = dashBoardpage.userName();
        System.out.println(name);
        assertThat(name).isEqualToIgnoringCase(PropertiesReader.readkey("name"));
    }


}
