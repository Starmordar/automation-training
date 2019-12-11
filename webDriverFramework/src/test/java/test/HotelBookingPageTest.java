package test;

import model.HotelSearchOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import service.HotelSearchOptionsCreator;

public class HotelBookingPageTest extends CommonCondition {

    @Test
    public void registrationFormAppearsForUnregisteredUser() {
        HotelSearchOptions hotelData = HotelSearchOptionsCreator.hotelSearchData();

        boolean hasFormAppears = new HomePage(driver)
                .openPage()
                .typeHotelOptions(hotelData)
                .submitHotelSearch()
                .redirectToPageWithHotelInfo()
                .redirectToBookingPage()
                .isRegistrationFormExists();

        Assert.assertFalse(hasFormAppears);
    }

    @Test
    public void userMustAuthorizedForAccessToBillingPage() {
        HotelSearchOptions hotelData = HotelSearchOptionsCreator.hotelSearchData();

        boolean hasEmptyFieldsError = new HomePage(driver)
                .openPage()
                .typeHotelOptions(hotelData)
                .submitHotelSearch()
                .redirectToPageWithHotelInfo()
                .redirectToBookingPage()
                .isErrorLabelAppers();

        Assert.assertTrue(hasEmptyFieldsError);
    }
}
