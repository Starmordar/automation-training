package framework.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ChromeDriverManager extends DriverSingleton {
    
    @Override 
    public void createWebDriver() {
        ChromeOptions options = new ChromeOptions();
        
        this.driver = new ChromeDriver(options);
    }
}