package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HotelsPage extends AbstractPage{

    @FindBy(xpath = "//*[@data-element-value='PriceFilterRange']")
    private WebElement priceDropdown;

    @FindBy(id = "price_box_1")
    private WebElement priceBox;

    private By hotel = By.className("hotel-list-container");

    protected HotelsPage(WebDriver driver) {
        super(driver);

        PageFactory.initElements(driver, this);
    }

    public boolean comparePriceInfo(String minPrice, String maxPrice){
        priceDropdown.click();

        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        wait.until(ExpectedConditions.elementToBeClickable(priceBox));

        priceBox.clear();
        priceBox.sendKeys(maxPrice);
        logger.info("Input price range to hotels filter");

        priceDropdown.click();
        logger.info("Search hotels by price range");

        logger.info("Getting element with according price range");
        return driver.findElements(hotel).size() == 0;
    }

    @Override
    protected HotelsPage openPage() {
        logger.info("Open hotels page");

        return this;
    }
}
