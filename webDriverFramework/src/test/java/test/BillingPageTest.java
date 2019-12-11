package test;

import model.HotelSearchOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.HotelPageInformation;
import service.HotelSearchOptionsCreator;

public class BillingPageTest extends CommonCondition {

    @Test
    public void hotelRatingOnHoteInfoPageMatchScoreOnBillingPage() {
        HotelSearchOptions hotelData = HotelSearchOptionsCreator.hotelSearchData();

        HotelPageInformation hotelPageInfromationInstance = new HomePage(driver)
                .openPage()
                .typeHotelOptions(hotelData)
                .submitHotelSearch()
                .redirectToPageWithHotelInfo();

        String ratingFromHotelPage = hotelPageInfromationInstance.getHotelRating();
        String ratingFromBookingHotelPage = hotelPageInfromationInstance
                .redirectToBookingPage()
                .getInfoScore();

        Assert.assertEquals(ratingFromBookingHotelPage, ratingFromHotelPage);
    }
}
