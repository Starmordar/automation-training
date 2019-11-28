package framework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class HomePage extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://www.agoda.com/ru-ru/";

    @FindBy(xpath = "//div[@class ='SearchBoxTextEditor']")
    private WebElement inputCityLocator;

    @FindBy(xpath = "//*[@data-selenium=\"homesTab\"]")
    private WebElement redirectBtnLocator;

    @FindBy(xpath = "//div[@class ='Searchbox__searchButton']")
    private WebElement submitBtnLocator;

    @FindBy(xpath = "//div[@class ='IconBox--checkIn']")
    private WebElement arrivalBtn;

    @FindBy(xpath = "//div[@class ='IconBox--checkOut']")
    private WebElement departueBtn;

    @FindBy(xpath = "//div[@class ='IconBox--occupancy']")
    private WebElement occupancy;


    public HomePage(WebDriver driver) {
        super(driver);
        
        PageFactory.initElements(driver, this);
    }

    public HomePage incorrectSearch(String destination, String arrivalDate, String departureDate, Integer numberOfPersons) {
        inputData(destination, arrivalDate, departureDate, numberOfPersons);

        return new HomePage(driver);
    }

    public HotelsPage correctSearch(String destination, String arrivalDate, String departureDate, Integer numberOfPersons) {
        inputData(destination, arrivalDate, departureDate, numberOfPersons);

        return new HotelsPage(driver);
    }

    public void inputData(String destination, String arrivalDate, String departureDate) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        inputCityLocator.sendKeys(destination);
        redirectBtnLocator.click();
        arrivalBtn.click();

        this.arrivalDate = driver.findElement(By.xpath("//span[@data-time = '" + arrivalDate + "']"));
        arrivalDate.click();

        this.departureDate = driver.findElement(By.xpath("//span[@data-time = '" + departureDate + "']"));
        departureDate.click();

        submitBtnLocator.click();

    }

    public String searchNotFoundAlert() {
        return alertMessage.getText();
    }

    @Override
    public HomePage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }
}