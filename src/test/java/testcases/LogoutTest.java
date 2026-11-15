
package testcases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import Base.BaseTest;
import pages.LoginPage;

public class LogoutTest extends BaseTest {

    @Test
    public void verifyLogout() {

        driver.get("https://the-internet.herokuapp.com/login");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("tomsmith", "SuperSecretPassword!");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/secure"));

        loginPage.clickLogout();

        String message = loginPage.getFlashMessage();
        System.out.println("Actual Logout Message: " + message);

        Assert.assertTrue(
            message.contains("You logged out of the secure area!"),
            "Logout failed!"
        );

        System.out.println("PASS: Logout successful!");
    }
}
