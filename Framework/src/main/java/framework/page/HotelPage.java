package framework.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HotelPage extends AbstractPage {

    @FindBy(xpath = "//*[@data-element-name=\"book-btn\"]")
    private WebElement hotelDescriptionLocator;

    public HotelPage(WebDriver driver) {
        super(driver);

        PageFactory.initElements(this.driver, this);
    }

    public String getDestinationHotel() {
        return hotelDescriptionLocator.getText();
    }

    public BillingPage redirectToBetterLife() {
        hotelDescriptionLocator.click();

        return new BillingPage(driver);
    }

    @Override
    public HotelPage openPage() {
        return this;
    }
}