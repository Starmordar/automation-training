package gangsta.task;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class App {

    
    public boolean isUserNotInSystem() {
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.agoda.com/ru-ru/");

        HomePage home = new HomePage(driver);

        home.typeCity("Варшава")
            .redirectToHotelsArea();

        SearchResultsPage searchPage = home.submitSearch();

        HotelsPage hotelsPage = searchPage.chooseCity();

        HotelPage hotelPage = hotelsPage.chooseHotel();

//        BillingPage billinPage = hotelPage.redirectToBetterLife();
//
//        if (billinPage.submitSearch() == 0) return true;
        return false;
    }



    public boolean isWebsiteSavesChoosedData() {
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.agoda.com/ru-ru/");

        HomePage home = new HomePage(driver);

        home.typeCity("Варшава");
        home.redirectToHotelsArea();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        SearchResultsPage search = home.submitSearch();

        HotelsPage hotels = search.chooseCity();

        HotelPage hotel = hotels.chooseHotel();

        BillingPage bill = hotel.redirectToBetterLife();

//        bill.submitChoosedPreference();
//
//        if (billinPage.submitSearch() == 0) return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println("lol");
        System.setProperty("webdriver.chrome.driver", "/home/roman/Desktop/chromedriver");
    }
}
