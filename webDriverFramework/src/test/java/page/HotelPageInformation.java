package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HotelPageInformation extends AbstractPage {

    @FindBy(className = "HeaderCerebrum__Name")
    private WebElement destinationOfHotelPage;

    @FindBy(xpath = "//*[@data-component='pill-dropdown-title']")
    private WebElement priceDropdown;

    @FindBy(className = "ChildRoomsList-bookButtonInput")
    private WebElement bookBtn;

    @FindBy(className = "ReviewScore-Number")
    private WebElement infoPageScore;

    public String getHotelRating() {
        return infoPageScore.getText();
    }

    public HotelBookingPage redirectToBookingPage() {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        wait.until(ExpectedConditions.elementToBeClickable(bookBtn));
        bookBtn.click();

        return new HotelBookingPage(driver);
    }

    public String getHotelName() {
        return destinationOfHotelPage.getText();
    }

    protected HotelPageInformation(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    protected HotelPageInformation openPage() {
        return this;
    }
}
