package framework.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HotelsPage extends AbstractPage {

    @FindBy(xpath = "//div[@class ='property-card']")
    private WebElement hotelDescriptionLocator;

    public HotelsPage(WebDriver driver) {
        super(driver);

        PageFactory.initElements(this.driver, this);
    }

    public HotelPage chooseHotel() {
        hotelDescriptionLocator.click();

        return new HotelPage(driver);
    }

    @Override
    public HotelsPage openPage() {
        return this;
    }
}