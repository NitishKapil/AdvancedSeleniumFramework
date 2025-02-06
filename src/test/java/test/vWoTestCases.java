package test;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.pageObjectModel.vWOPage.DashBoardpage;
import pages.pageObjectModel.vWOPage.LoginPage;

import static org.assertj.core.api.Assertions.assertThat;

public class vWoTestCases {

    @Test
    public void negativeTestCase() {
        WebDriver driver = new ChromeDriver();
        LoginPage loginPage = new LoginPage(driver);
        String errorText = loginPage.loginVwoInvalidWay("nits", "12234");
        assertThat(errorText).isEqualToIgnoringCase("Your email, password, IP address or location did not match");
    }

    @Owner("Nitish Kapil")
    @Description("Positive Test of Login Credentials")
    @Test
    public void positiveTestCase() {
        WebDriver driver = new ChromeDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginVwoValidWay("nitish.kapil@vertexinfosoft.com", "Kapil@005");
        DashBoardpage dashBoardpage = new DashBoardpage(driver);
        String name = dashBoardpage.userName();
        System.out.println(name);
        assertThat(name).isEqualToIgnoringCase("Nitish kapil");
    }


}
