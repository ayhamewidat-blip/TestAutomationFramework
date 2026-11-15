package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import pages.LoginPage;

public class LoginPageTest extends BaseTest {

    @Test
    public void verifyLoginPageIsOpened() {

        driver.get("https://the-internet.herokuapp.com/login");

        LoginPage loginPage = new LoginPage(driver);

        String actualTitle = loginPage.getPageTitle();

        System.out.println("Page Title: " + actualTitle);

        Assert.assertTrue(
            actualTitle.contains("The Internet"),
            "Login page was not opened correctly!"
        );

        System.out.println("PASS: Login page opened successfully!");
    }
    
   
}