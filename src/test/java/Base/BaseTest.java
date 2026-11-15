package Base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import reports.ExtentTestListener;
import base.DriverFactory;

@Listeners(ExtentTestListener.class)

public class BaseTest {

	public WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.createDriver();
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}