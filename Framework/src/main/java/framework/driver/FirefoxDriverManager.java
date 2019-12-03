package framework.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverManager extends DriverSingleton {
    
    @Override 
    public void createWebDriver() {
        FirefoxOptions options = new FirefoxOptions();
        
        this.driver = new FirefoxDriver(options);
    }
}