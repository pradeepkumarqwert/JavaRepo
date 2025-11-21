package com.report.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {

    private ExtentSparkReporter sparkReporter;
    private ExtentReports extents;
    // Thread-safe: keeps track of current test per thread
    private static ThreadLocal<ExtentTest> extentTestThread = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {
        String timestamp = new java.text.SimpleDateFormat("yyyyMMdd_HHmmss").format(new java.util.Date());
        String reportPath = System.getProperty("user.dir") + "/Reports/MyReport_" + timestamp + ".html";

        sparkReporter = new ExtentSparkReporter(reportPath);
        sparkReporter.config().setDocumentTitle("Cloud 1.0 - Bulk Testing");
        sparkReporter.config().setReportName("ProjectMenu");
        sparkReporter.config().setTheme(Theme.DARK);

        extents = new ExtentReports();
        extents.attachReporter(sparkReporter);

        // Fetch dynamic system info from test context
        Object browserName = context.getAttribute("browserName");
        Object browserVersion = context.getAttribute("browserVersion");
        Object platformName = context.getAttribute("platformName");

        if (browserName != null) extents.setSystemInfo("Browser", browserName.toString());
        if (browserVersion != null) extents.setSystemInfo("Browser Version", browserVersion.toString());
        if (platformName != null) extents.setSystemInfo("OS", platformName.toString());
    }



    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extents.createTest(result.getMethod().getMethodName());
        extentTestThread.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTest test = extentTestThread.get();
        if (test != null) {
            test.log(Status.PASS, "Test Passed: " + result.getName());
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Throwable throwable = result.getThrowable();
        if (extentTestThread.get() != null) {
            extentTestThread.get().log(Status.FAIL, "Test Failed: " + result.getName());
            extentTestThread.get().log(Status.FAIL, throwable);
        }
        // Print in console also
        if (throwable != null) {
            throwable.printStackTrace();
        }
    }


    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentTest test = extentTestThread.get();
        if (test != null) {
            test.log(Status.SKIP, "Test Skipped: " + result.getName());
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        if (extents != null) {
            extents.flush();
        }
    }
}
