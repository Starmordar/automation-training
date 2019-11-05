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

public class HomePage {

    private final WebDriver driver;
    private final By inputCityLocator = By.className("SearchBoxTextEditor");
    private final By redirectBtnLocator = By.xpath("//*[@data-selenium=\"homesTab\"]");
    private final By submitBtnLocator = By.className(" Searchbox__searchButton");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage typeCity(String city) {
        driver.findElement(inputCityLocator).click();
        driver.findElement(inputCityLocator).sendKeys(city);

        return this;
    }

    public HomePage redirectToHotelsArea() {
        driver.findElement(redirectBtnLocator).click();

        return this;
    }

    public SearchResultsPage submitSearch() {
        driver.findElement(submitBtnLocator).click();

        return new SearchResultsPage(this.driver);
    }
}

