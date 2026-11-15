
package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {

            ExtentSparkReporter spark =
                    new ExtentSparkReporter("test-output/AutomationReport.html");
            System.out.println("ExtentManager: System Info Configuration Started");

            spark.config().setDocumentTitle("Automation Test Report");
            spark.config().setReportName("QA Automation Execution Report");

            extent = new ExtentReports();

            extent.attachReporter(spark);

            extent.setSystemInfo("Project", "TestAutomationFramework");
            extent.setSystemInfo("Automation Tool", "Selenium WebDriver");
            extent.setSystemInfo("Testing Framework", "TestNG");
            extent.setSystemInfo("Language", "Java");
            extent.setSystemInfo("Browser", "Chrome");
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("Java Version", System.getProperty("java.version"));
            extent.setSystemInfo("Operating System", System.getProperty("os.name"));

            System.out.println("ExtentManager: System Info Configuration Completed");
            System.out.println("ExtentReports instance: " + extent);      
            System.out.println("Java Version: " + System.getProperty("java.version"));
            System.out.println("OS: " + System.getProperty("os.name"));    
        }

        return extent;
    }
}
