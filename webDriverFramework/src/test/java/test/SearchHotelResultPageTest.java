package test;

import model.CountrySearchOptions;
import model.PriceRange;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import service.CountrySearchOptionsCreator;
import service.PriceRangeCreator;

public class SearchHotelResultPageTest extends CommonCondition {

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
