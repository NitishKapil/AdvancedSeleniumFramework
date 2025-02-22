package test.vWoTestCases;

import base.CommonToAllTest;
import driver.DriverManagerPL;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import listners.RetryAnalyzer;
import org.testng.annotations.Test;
import pages.pageObjectModel.vWOPage.DashBoardpage;
import pages.pageObjectModel.vWOPage.LoginPage;
import utils.ExcelReader;
import utils.PropertiesReader;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@Test(retryAnalyzer = RetryAnalyzer.class)
public class vWoTestCases_Properties_DriverManager_ExcelReader extends CommonToAllTest {

    @Test(dataProvider = "getdata", dataProviderClass = ExcelReader.class)
    public void negativeTestCase(String username, String password) throws IOException {
        LoginPage loginPage = new LoginPage(DriverManagerPL.getDriver());
        String errorText = loginPage.loginVwoInvalidWay(username, password);
        assertThat(errorText).isEqualToIgnoringCase(PropertiesReader.readkey("error_msg"));
    }

    @Owner("Nitish Kapil")
    @Description("Positive Test of Login Credentials")
    @Test(dataProvider = "getData", dataProviderClass = ExcelReader.class)
    public void positiveTestCase(String user, String password) throws IOException {
        LoginPage loginPage = new LoginPage(DriverManagerPL.getDriver());
        loginPage.loginVwoValidWay(user, password);
        DashBoardpage dashBoardpage = new DashBoardpage(DriverManagerPL.getDriver());
        String name = dashBoardpage.userName();
        System.out.println(name);
        assertThat(name).isEqualToIgnoringCase(PropertiesReader.readkey("name"));

    }


}
