
package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;

public class BrowserTest extends BaseTest {

    @Test
    public void verifyBrowserIsOpened() {

        Assert.assertNotNull(driver,
                "Chrome browser was not opened!");

        System.out.println(
                "PASS: Chrome browser opened successfully!");

    }
}
