package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import pages.LoginPage;

public class PasswordTest extends BaseTest {

    @Test
    public void verifyPasswordField() {

        driver.get("https://the-internet.herokuapp.com/login");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterPassword("SuperSecretPassword!");

        String actualValue = loginPage.getPasswordValue();

        Assert.assertEquals(actualValue, "SuperSecretPassword!");

        System.out.println("PASS: Password entered successfully!");
    }
}