
package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import pages.LoginPage;

public class InvalidLoginTest extends BaseTest {

    @Test
    public void verifyInvalidLogin() {

        driver.get("https://the-internet.herokuapp.com/login");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("wronguser", "wrongpassword");

        String message = loginPage.getFlashMessage();

        Assert.assertTrue(
            message.contains("Your username is invalid!"),
            "Expected invalid login message was not displayed!"
        );

        System.out.println("PASS: Invalid login handled successfully!");
    }
}
