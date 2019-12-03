package gangsta.task;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.util.ArrayList;

public class BillingPage {

    private final WebDriver driver;
    private final By inputCityLocator = By.id("firstName_lastName");
    private final By inputLocator = By.xpath("//*[@data-element-name=\"travel-with-kids\"]");
    private final By SubmitBtn = By.xpath("//*[@data-element-name=\"submit-step1-button\"]");

    public BillingPage(WebDriver driver) {
        this.driver = driver;
    }

//    public Integer submitChoosedPreference() {
//       driver.findElements(inputLocator).click();
//       driver.findElements(SubmitBtn).click();
//
//       driver.findElements(inputCityLocator).size();
//    }

    public Integer submitSearch() {
        return driver.findElements(inputCityLocator).size();
    }
}

