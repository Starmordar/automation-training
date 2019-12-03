package framework.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {
    private static final String BROWSER = "browser";
    private static final String BROWSER_FIREFOX = "firefox";

    private WebDriver driver;
    protected abstract void createWebDriver();

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (System.getProperty(BROWSER)) {
                case BROWSER_FIREFOX: {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                }
                default: {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                }
            }
            driver.manage().window().maximize();
        }

        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}