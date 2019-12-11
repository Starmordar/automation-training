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

    protected HotelPageInformation(WebDriver driver) {
        super(driver);

        PageFactory.initElements(driver, this);
    }

    public String getHotelRating() {
        logger.info("Get hotel rating from hotel information page");

        return infoPageScore.getText().replace(",",".");
    }

    public HotelBookingPage redirectToBookingPage() {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        wait.until(ExpectedConditions.elementToBeClickable(bookBtn));
        bookBtn.click();
        logger.info("Redirect to hotel booking page");

        return new HotelBookingPage(driver);
    }

    public String getHotelName() {
        logger.info("Getting hotel name");

        return destinationOfHotelPage.getText();
    }

    @Override
    protected HotelPageInformation openPage() {
        logger.info("Open hotel information page");

        return this;
    }
}
