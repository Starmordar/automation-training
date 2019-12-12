package util;

import driver.DriverSingleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TestListener implements ITestListener {
    protected final Logger logger = LogManager.getRootLogger();

    public void onTestStart(ITestResult iTestResult) {
        logger.info(iTestResult.getMethod().getMethodName() + " test started");
    }

    public void onTestSuccess(ITestResult iTestResult) {
        logger.info(iTestResult.getMethod().getMethodName() + " build successful");
    }

    public void onTestFailure(ITestResult iTestResult) {
        logger.error(iTestResult.getMethod().getMethodName() + " test failed");
        logger.error(iTestResult.getThrowable().getMessage());

        saveScreenshot();
    }

    public void onTestSkipped(ITestResult iTestResult) {
        logger.info(iTestResult.getMethod().getMethodName() + " skipped");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        logger.info(iTestResult.getMethod().getMethodName() + " failed within success percentage");
    }

    public void onStart(ITestContext iTestContext) {
        logger.info("Start build test suite");
    }

    public void onFinish(ITestContext iTestContext) {
        logger.info("Finish build test suite");
    }

    private void saveScreenshot() {
        File screenCapture = ((TakesScreenshot) DriverSingleton
                .getDriver())
                .getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenCapture, new File(
                    ".//target/screenshots/"
                            + getCurrentTimeAsString() +
                            ".png"));
        } catch (IOException e) {
            logger.error("Failed to save screenshot: " + e.getLocalizedMessage());
        }
    }

    private String getCurrentTimeAsString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd_HH-mm-ss");

        return ZonedDateTime.now().format(formatter);
    }
}
