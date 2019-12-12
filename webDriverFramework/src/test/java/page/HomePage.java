package page;

import model.HotelSearchOptions;
import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://www.agoda.com/ru-ru/";

    @FindBy(className = "SearchBoxTextEditor")
    private WebElement searchInputField;

    @FindBy(xpath = "//*[@data-selenium=\"homesTab\"]")
    private WebElement backMainPageViewBtn;

    @FindBy(className = "Searchbox__searchButton")
    private WebElement submitSearchBtn;

    @FindBy(className = "language-trigger")
    private WebElement currentPageLang;

    @FindBy(className = "lang-no")
    private WebElement norwayPageLang;

    @FindBy(xpath = "//*[@data-selenium='hero-banner-h1']")
    private WebElement mainHeroBannerInfo;

    @FindBy(id = "sign-up-btn")
    private WebElement openRegistration;

    @FindBy(id = "signup-email-input")
    private WebElement emailInputField;

    @FindBy(id = "signup-password-input")
    private WebElement passwordInputField;

    @FindBy(id = "signup-firstname-input")
    private WebElement firstnameInputField;

    @FindBy(id = "signup-lastname-input")
    private WebElement lastnameInputField;

    @FindBy(id = "sign-up-submit-button")
    private WebElement submitBtn;

    private By cookieWarnContainer = By.className("cookieWarn");
    private By captchaValidator = By.id("signup-captcha-panel-validator-error");

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isCookiesWarnAppearsOnScreen() {
        logger.info("Try get cookie warn element");
        return driver.findElements(cookieWarnContainer).size() == 0;
    }

    public HomePage changeSystemLang() {
        currentPageLang.click();
        logger.info("Open language selection section");

        norwayPageLang.click();
        logger.info("Choose Norway language as default");

        return new HomePage(driver);
    }

    public HomePage refreshPage() {
        driver.navigate().refresh();
        logger.info("Refresh page");

        return this;
    }

    public String getUpdatedMainHeroBanner() {
        logger.info("Getting value from main-hero banner on home page");
        return mainHeroBannerInfo.getText();
    }

    public HomePage openRegistrationMenu() {
        openRegistration.click();
        logger.info("Open registration form");

        return this;
    }

    public HomePage inputUserData(User userData) {
        emailInputField.sendKeys(userData.getEmail());
        logger.info("Input user email");

        passwordInputField.sendKeys(userData.getPassword());
        logger.info("Input user password");

        firstnameInputField.sendKeys(userData.getFirstName());
        logger.info("Input user firstname");

        lastnameInputField.sendKeys(userData.getLastName());
        logger.info("Input user lastname");

        submitBtn.click();
        logger.info("submit registration button");

        return this;
    }

    public boolean isCaptchaWarnAppearsOnScreen() {
        logger.info("Getting captcha error message");
        return driver.findElements(captchaValidator).size() != 0;
    }

    public HomePage typeHotelOptions(HotelSearchOptions hotelData) {
        searchInputField.click();
        searchInputField.sendKeys(hotelData.getDestination());
        logger.info("Input hotel options");

        return this;
    }

    public SearchHotelResult submitHotelSearch() {
        backMainPageViewBtn.click();
        submitSearchBtn.click();
        logger.info("Redirect to page with search results");

        return new SearchHotelResult(driver);
    }

    public String getCityNameFromInputField() {
        logger.info("Get value from search input");

        return searchInputField.getAttribute("value");
    }

    public HomePage typeCity(String cityName) {
        searchInputField.click();
        searchInputField.sendKeys(cityName);
        logger.info("Type city name in search input");

        return this;
    }

    @Override
    public HomePage openPage() {
        driver.get(HOMEPAGE_URL);

        logger.info("Open home page");

        return this;
    }
}