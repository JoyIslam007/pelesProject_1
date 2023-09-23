import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentSparkReporter;

public class BaseTest {
    protected static ExtentReports extent;

    static {
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }
}