
package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import pages.LoginPage;

public class UsernameTest extends BaseTest {

    @Test
    public void verifyUsernameField() {

        driver.get("https://the-internet.herokuapp.com/login");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername("tomsmith");

        String actualValue = loginPage.getUsernameValue();

        Assert.assertEquals(actualValue, "tomsmith");

        System.out.println("PASS: Username entered successfully!");
    }
}
