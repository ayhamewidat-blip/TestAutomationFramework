
package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import pages.LoginPage;

public class ValidLoginTest extends BaseTest {

    @Test
    public void verifyValidLogin() {

        driver.get("https://the-internet.herokuapp.com/login");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("tomsmith", "SuperSecretPassword!");

        String message = loginPage.getFlashMessage();

        Assert.assertTrue(
            message.contains("You logged into a secure area!"),
            "Valid login failed!"
        );

        System.out.println("PASS: Valid login successful!");
    }
}
