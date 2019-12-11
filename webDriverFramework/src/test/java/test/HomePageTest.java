package test;

import model.CountrySearchOptions;
import model.HotelSearchOptions;
import model.PriceRange;
import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.HotelPageInformation;
import service.CountrySearchOptionsCreator;
import service.HotelSearchOptionsCreator;
import service.PriceRangeCreator;
import service.UserCreator;

import java.lang.reflect.Method;

import static util.StringUtils.NORWAY_BANNER_CONTENT;

public class HomePageTest extends CommonCondition {

    @Test
    public void userCannotCreateNewAccountWithoutCaptchaSubmit() {
        User userData = UserCreator.authentificationData();

        boolean hasCaptchaError = new HomePage(driver)
                .openPage()
                .openRegistrationMenu()
                .inputUserData(userData)
                .isCaptchaWarnAppearsOnScreen();

        Assert.assertTrue(hasCaptchaError);
    }

    @Test
    public void cookiesWarnAppearsWhenUserEnterPage() {
        boolean hasCookiesWarn = new HomePage(driver)
                .openPage()
                .isCookiesWarnAppearsOnScreen();

        Assert.assertTrue(hasCookiesWarn);
    }

    @Test
    public void chooseMainPageLanguageStoresInCookies() {
        String bannerContent = new HomePage(driver)
                .openPage()
                .changeSystemLang()
                .refreshPage()
                .getUpdatedMainHeroBanner();

        Assert.assertEquals(NORWAY_BANNER_CONTENT, bannerContent);
    }

    @Test
    public void lastSuccessfulSearchSavesInHomePageInputField() {
        CountrySearchOptions countryData = CountrySearchOptionsCreator.countrySearchData();

        String cityName = new HomePage(driver)
                .openPage()
                .typeCity(countryData.getCountry())
                .submitHotelSearch()
                .redirectToHomePage()
                .getCityNameFromInputField();

        Assert.assertEquals(countryData.getCountry(), cityName);
    }
}
