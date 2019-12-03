package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotelResult extends AbstractPage {

    @FindBy(className = "isotope-item")
    private WebElement hotelTitle;

    @FindBy(className = "InterstitialList__container")
    private WebElement cityTitle;

    @FindBy(className = "LogoAndLinksMenu__LogoContainer")
    private WebElement redirectToHome;

    protected SearchHotelResult(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public HomePage redirectToHomePage() {
        redirectToHome.click();

        return new HomePage(driver);
    }

    public HotelsPage redirectToHotels() {
        cityTitle.click();

        return new HotelsPage(driver);
    }

    public HotelPageInformation redirectToPageWithHotelInfo() {
        hotelTitle.click();

        return new HotelPageInformation(driver);
    }

    @Override
    protected SearchHotelResult openPage() {
        return this;
    }
}
