package page;

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
        return driver.findElements(cookieWarnContainer).size() != 0;
    }

    public HomePage changeSystemLang() {
        currentPageLang.click();
        norwayPageLang.click();
        logger.info("kek");
        return new HomePage(driver);
    }

    public HomePage refreshPage() {
        driver.navigate().refresh();

        return this;
    }

    public String getUpdatedMainHeroBanner() {
        return mainHeroBannerInfo.getText();
    }

    public HomePage openRegistrationMenu() {
        openRegistration.click();

        return this;
    }

    public HomePage inputUserData(String email, String password, String firstName, String lastName) {
        emailInputField.sendKeys(email);
        passwordInputField.sendKeys(password);
        firstnameInputField.sendKeys(firstName);
        lastnameInputField.sendKeys(lastName);
        submitBtn.click();

        return this;
    }

    public boolean isCaptchaWarnAppearsOnScreen() {
        return driver.findElements(captchaValidator).size() != 0;
    }

    public HomePage typeHotelOptions(String cityName, String arrivalDate, String departueDate, String occupancy) {
        searchInputField.click();
        searchInputField.sendKeys(cityName);

        return this;
    }

    public SearchHotelResult submitHotelSearch() {
        backMainPageViewBtn.click();
        submitSearchBtn.click();

        return new SearchHotelResult(driver);
    }

    public String getCityNameFromInputField() {
        return searchInputField.getAttribute("value");
    }

    public HomePage typeCity(String cityName) {
        searchInputField.click();
        searchInputField.sendKeys(cityName);

        return this;
    }

    @Override
    public HomePage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }
}