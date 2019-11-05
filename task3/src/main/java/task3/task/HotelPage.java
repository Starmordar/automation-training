package gangsta.task;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HotelPage {

    private final WebDriver driver;
    private final By hotelDescriptionLocator = By.xpath("//*[@data-element-name=\"book-btn\"]");

    public HotelPage(WebDriver driver) {
        this.driver = driver;
    }

    public BillingPage redirectToBetterLife() {
        driver.findElement(hotelDescriptionLocator).click();

        return new BillingPage(this.driver);
    }
}

