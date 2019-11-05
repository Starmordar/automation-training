package gangsta.task;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SearchResultsPage {

    private final WebDriver driver;
    private final By inputCityLocator = By.className("cities");

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public HotelsPage chooseCity() {
        driver.findElement(inputCityLocator).click();

        return new HotelsPage(this.driver);
    }
}

