package framework;

import model.HotelSearchOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HotelHomePage;
import service.HotelSearchOptionsCreator;

import static util.StringUtils.DESTINATION;
import static util.StringUtils.CITY_NAME;

public class SearchHotels extends CommonCondition {

    @Test
    public void checkCurrentDestinationOnHotelsPage() {
        HotelSearchOptions hotelSearchOptions = HotelSearchOptionsCreator.withCorrectSearch();
        String message = new HomePage(driver)
                .openPage()
                .correctSearch(
                        hotelSearchOptions.getDestination(),
                        hotelSearchOptions.getArrivalDate(),
                        hotelSearchOptions.getDepartureDate())
                .chooseHotel()
                .getDestinationHotel();
                
        Assert.assertEquals(DESTINATION, message);
    }
    
    @Test
    public void checkCurrentDestinationOnHotelPage() {
        HotelSearchOptions hotelSearchOptions = HotelSearchOptionsCreator.withIncorrectDestination();
        String message = new HomePage(driver)
                .openPage()
                .incorrectSearch(
                        hotelSearchOptions.getDestination(),
                        hotelSearchOptions.getArrivalDate(),
                        hotelSearchOptions.getDepartureDate())
                .searchNotFoundAlertMessage();

        Assert.assertEquals(CITY_NAME, message);
    }
}