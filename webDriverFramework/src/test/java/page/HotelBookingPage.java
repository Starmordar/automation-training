package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class HotelBookingPage extends AbstractPage {

    @FindBy(xpath = "//*[@data-element-name=\"submit-step1-button\"]")
    private WebElement redirectToBillingPage;

    private By errorUsernameLabel = By.id("sc-bwzfXH jGnqfe");

    private By userRegistrationLabel = By.id("contactDetails");

    @FindBy(css = ".sc-bwzfXH.eBegzL span strong")
    private WebElement infoPageScore;

    protected HotelBookingPage(WebDriver driver) {
        super(driver);

        PageFactory.initElements(driver, this);
    }

    public String getInfoScore() {
        logger.info("Get hotel rating from hotel booking page");

        return infoPageScore.getText().replace(",",".");
    }

    public boolean isErrorLabelAppers() {
        redirectToBillingPage.click();
        logger.info("Getting warn for unregistered users");

        return driver.findElements(errorUsernameLabel).size() == 0;
    }

    public boolean isRegistrationFormExists() {
        logger.info("Getting user registration form");

        return driver.findElements(userRegistrationLabel).size() == 0;
    }

    @Override
    protected HotelBookingPage openPage() {
        logger.info("Open hotel booking page");
        return this;
    }
}
