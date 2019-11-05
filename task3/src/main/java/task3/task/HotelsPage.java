package gangsta.task;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HotelsPage {

    private final WebDriver driver;
    private final By hotelLocator = By.className("property-card");

    public HotelsPage(WebDriver driver) {
        this.driver = driver;
    }

    public HotelPage chooseHotel() {
        String dr = driver.findElement(hotelLocator).getAttribute("href");
        driver.get(dr);
        return new HotelPage(this.driver);
    }
}
