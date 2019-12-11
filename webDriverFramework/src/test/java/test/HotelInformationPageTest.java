package test;

import model.HotelSearchOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import service.HotelSearchOptionsCreator;

public class HotelInformationPageTest extends CommonCondition {

    @Test
    public void checkCurrentDestinationOnHotelPage() {
        HotelSearchOptions hotelData = HotelSearchOptionsCreator.hotelSearchData();

        String hotelName = new HomePage(driver)
                .openPage()
                .typeHotelOptions(hotelData)
                .submitHotelSearch()
                .redirectToPageWithHotelInfo()
                .getHotelName();

        Assert.assertEquals(hotelData.getDestination(), hotelName);
    }

}
