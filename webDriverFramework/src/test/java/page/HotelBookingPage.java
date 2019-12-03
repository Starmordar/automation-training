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

    public String getInfoScore() {
        return infoPageScore.getText();
    }

    public boolean isErrorLabelAppers() {
        redirectToBillingPage.click();
        return driver.findElements(errorUsernameLabel).size() == 0;
    }

    public boolean isRegistrationFormExists() {
        return driver.findElements(userRegistrationLabel).size() == 0;
    }

    protected HotelBookingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    protected HotelBookingPage openPage() {
        return this;
    }
}
