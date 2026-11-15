package reports;
import java.awt.Desktop;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Base.BaseTest;

public class ExtentTestListener implements ITestListener {

    private static ExtentReports extent =
            ExtentManager.getInstance();

    private static ThreadLocal<ExtentTest> test =
            new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest extentTest =
                extent.createTest(result.getMethod().getMethodName());

        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        long duration = result.getEndMillis() - result.getStartMillis();

        test.get().log(Status.PASS, "Test Passed Successfully");

        test.get().info("Execution Time: " + duration + " ms");

    }
    @Override
    public void onTestFailure(ITestResult result) {

        long duration = result.getEndMillis() - result.getStartMillis();

        test.get().log(Status.FAIL, "Test Failed");

        test.get().fail(result.getThrowable());

        test.get().info("Execution Time: " + duration + " ms");

        BaseTest baseTest = (BaseTest) result.getInstance();

        WebDriver driver = baseTest.driver;

        System.out.println("Screenshot Driver: " + driver);

        String screenshotPath = captureScreenshot(
                driver,
                result.getMethod().getMethodName()
        );

        System.out.println("Screenshot Path: " + screenshotPath);

        test.get().addScreenCaptureFromPath(screenshotPath);
    
    }
    
    @Override
    public void onTestSkipped(ITestResult result) {

        long duration = result.getEndMillis() - result.getStartMillis();

        test.get().log(Status.SKIP, "Test Skipped");

        test.get().info("Execution Time: " + duration + " ms");

    }
    @Override
    public void onFinish(org.testng.ITestContext context) {

        extent.flush();

        try {
            File reportFile = new File("test-output/AutomationReport.html");

            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(reportFile.toURI());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    
    }
    
    private String captureScreenshot(WebDriver driver, String testName) {
    	

        File source = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

        String filePath = "screenshots/" + testName + "_" + timestamp + ".png";
        File destination = new File(filePath);

        destination.getParentFile().mkdirs();
        
        
        try {
            Files.copy(source.toPath(), destination.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return filePath;
    }
}
