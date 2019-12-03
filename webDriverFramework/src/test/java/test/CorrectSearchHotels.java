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

import static util.StringUtils.HOTEL_DESTINATION;
import static util.StringUtils.NORWAY_BANNER_CONTENT;
import static util.StringUtils.SEARCH_CITY_NAME;

public class CorrectSearchHotels extends CommonCondition {

    //    done
    @Test
    public void userCannotCreateNewAccountWithoutCaptchaSubmit() {
        User userData = UserCreator.authentificationData();

        boolean hasCaptchaError = new HomePage(driver)
                .openPage()
                .openRegistrationMenu()
                .inputUserData(
                        userData.getEmail(),
                        userData.getPassword(),
                        userData.getFirstName(),
                        userData.getFirstName()
                )
                .isCaptchaWarnAppearsOnScreen();

        Assert.assertTrue(hasCaptchaError);
    }

    //    done
    @Test
    public void cookiesWarnAppearsWhenUserEnterPage() {
        boolean hasCookiesWarn = new HomePage(driver)
                .openPage()
                .isCookiesWarnAppearsOnScreen();

        Assert.assertTrue(hasCookiesWarn);
    }

    //    done
    @Test
    public void checkCurrentDestinationOnHotelPage() {
        HotelSearchOptions hotelData = HotelSearchOptionsCreator.hotelSearchData();

        String hotelName = new HomePage(driver)
                .openPage()
                .typeHotelOptions(
                        hotelData.getDestination(),
                        hotelData.getArrivalDate(),
                        hotelData.getDepartureDate(),
                        hotelData.getOccupancy()
                )
                .submitHotelSearch()
                .redirectToPageWithHotelInfo()
                .getHotelName();

        Assert.assertEquals(HOTEL_DESTINATION, hotelName);
    }

    //    done
    @Test
    public void registrationFormAppearsForUnregisteredUser() {
        HotelSearchOptions hotelData = HotelSearchOptionsCreator.hotelSearchData();

        boolean hasFormAppears = new HomePage(driver)
                .openPage()
                .typeHotelOptions(
                        hotelData.getDestination(),
                        hotelData.getArrivalDate(),
                        hotelData.getDepartureDate(),
                        hotelData.getOccupancy()
                )
                .submitHotelSearch()
                .redirectToPageWithHotelInfo()
                .redirectToBookingPage()
                .isRegistrationFormExists();

        Assert.assertFalse(hasFormAppears);
    }

    //    done
    @Test
    public void userMustAuthorizedForAccessToBillingPage() {
        HotelSearchOptions hotelData = HotelSearchOptionsCreator.hotelSearchData();

        boolean hasEmptyFieldsError = new HomePage(driver)
                .openPage()
                .typeHotelOptions(
                        hotelData.getDestination(),
                        hotelData.getArrivalDate(),
                        hotelData.getDepartureDate(),
                        hotelData.getOccupancy()
                )
                .submitHotelSearch()
                .redirectToPageWithHotelInfo()
                .redirectToBookingPage()
                .isErrorLabelAppers();

        Assert.assertTrue(hasEmptyFieldsError);
    }

    //    done
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
    public void hotelRatingOnHoteInfoPageMatchScoreOnBillingPage() {
        HotelSearchOptions hotelData = HotelSearchOptionsCreator.hotelSearchData();

        HotelPageInformation hotelPageInfromationInstance = new HomePage(driver)
                .openPage()
                .typeHotelOptions(
                        hotelData.getDestination(),
                        hotelData.getArrivalDate(),
                        hotelData.getDepartureDate(),
                        hotelData.getOccupancy()
                )
                .submitHotelSearch()
                .redirectToPageWithHotelInfo();

        String ratingFromHotelPage = hotelPageInfromationInstance.getHotelRating();
        String ratingFromBookingHotelPage = hotelPageInfromationInstance
                .redirectToBookingPage()
                .getInfoScore();

        Assert.assertEquals(ratingFromBookingHotelPage, ratingFromHotelPage);
    }

    //    done
    @Test
    public void lastSuccessfulSearchSavesInHomePageInputField() {
        CountrySearchOptions countryData = CountrySearchOptionsCreator.countrySearchData();

        String cityName = new HomePage(driver)
                .openPage()
                .typeCity(countryData.getCountry())
                .submitHotelSearch()
                .redirectToHomePage()
                .getCityNameFromInputField();

        Assert.assertEquals(SEARCH_CITY_NAME, cityName);
    }

//    done
    @Test
    public void pageDoesNotShowsHotelsMoreThanAssignedPrice() {
        CountrySearchOptions countryData = CountrySearchOptionsCreator.countrySearchData();
        PriceRange priceData = PriceRangeCreator.priceData();

        boolean notHotelPriceMoreThanAssigned = new HomePage(driver)
                .openPage()
                .typeCity(countryData.getCountry())
                .submitHotelSearch()
                .redirectToHotels()
                .comparePriceInfo(
                        priceData.getMinPrice(),
                        priceData.getMaxPrice()
                );

        Assert.assertTrue(notHotelPriceMoreThanAssigned);
    }
}
