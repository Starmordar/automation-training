package framework.util;

import com.epam.ta.driver.DriverSingleton;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


public class TestListener implements ITestListener {
    private static final String DATE_FORMAT = "uuuu-MM-dd_HH-mm-ss";
    private static final String FAIL_SAVE_SCREENSHOT_MSG = "Failed to save screenshot: ";
    private static final String SCREEN_TEMPLATE_PATH = ".//target/screenshots/";
    private static final String SCREEN_FORMAT = ".png";

    private Logger log = LogManager.getRootLogger();

    public void onTestFailure(ITestResult iTestResult) {
        saveScreenshot();
    }

    private void saveScreenshot() {
        File screenCapture = ((TakesScreenshot) DriverSingleton
                .getDriver())
                .getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenCapture, new File(
                    SCREEN_TEMPLATE_PATH
                            + getCurrentTimeAsString() + SCREEN_FORMAT));
        } catch (IOException e) {
            log.error(FAIL_SAVE_SCREENSHOT_MSG + e.getLocalizedMessage());
        }
    }

    private String getCurrentTimeAsString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);

        return ZonedDateTime.now().format(formatter);
    }
}
