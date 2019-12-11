package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchHotelResult extends AbstractPage {

    @FindBy(className = "isotope-item")
    private WebElement hotelTitle;

    @FindBy(className = "InterstitialList__container")
    private WebElement cityTitle;

    @FindAll({
            @FindBy(className = "LogoAndLinksMenu__LogoContainer"),
            @FindBy(className = "logo")
    })

    private List<WebElement> redirectToHome;

    protected SearchHotelResult(WebDriver driver) {
        super(driver);

        PageFactory.initElements(driver, this);
    }

    public HomePage redirectToHomePage() {
        redirectToHome.get(0).click();
        logger.info("Redirecting to home page");

        return new HomePage(driver);
    }

    public HotelsPage redirectToHotels() {
        cityTitle.click();
        logger.info("Redirect to hotels page");

        return new HotelsPage(driver);
    }

    public HotelPageInformation redirectToPageWithHotelInfo() {
        hotelTitle.click();
        logger.info("Redirect to page with hotel info");

        return new HotelPageInformation(driver);
    }

    @Override
    protected SearchHotelResult openPage() {
        logger.info("Open search result page");

        return this;
    }
}
