package framework.service;

import model.HotelSearchOptions;

public class HotelSearchOptionsCreator {
    public static final String TESTDATA_HOTEL_SEARCH_DESTINATION = "testdata.hotelSearchCriteria.destination";
    public static final String TESTDATA_HOTEL_SEARCH_CHECKIN_DATE = "testdata.hotelSearchCriteria.arrivalDate";
    public static final String TESTDATA_HOTEL_SEARCH_CHECKOUT_DATE = "testdata.hotelSearchCriteria.departureDate";
    public static final String TESTDATA_HOTEL_SEARCH_PEOPLE = "testdata.hotelSearchCriteria.numberOfPeople";
    public static final String INCORRECT_CHECKIN_DATE = "40.01.2000";

    public static HotelSearchOptions withCorrectSearch() {
        return new HotelSearchOptions(
                TestDataReader.getTestData(TESTDATA_HOTEL_SEARCH_DESTINATION),
                TestDataReader.getTestData(TESTDATA_HOTEL_SEARCH_CHECKIN_DATE),
                TestDataReader.getTestData(TESTDATA_HOTEL_SEARCH_CHECKOUT_DATE),
                Integer.parseInt(TestDataReader.getTestData(TESTDATA_HOTEL_SEARCH_PEOPLE))
        );
    }

    public static HotelSearchOptions withIncorrectDestination() {
        return new HotelSearchOptions(
                TestDataReader.getTestData(TESTDATA_HOTEL_SEARCH_DESTINATION),
                TestDataReader.getTestData(INCORRECT_CHECKIN_DATE),
                TestDataReader.getTestData(TESTDATA_HOTEL_SEARCH_CHECKOUT_DATE),
                Integer.parseInt(TestDataReader.getTestData(TESTDATA_HOTEL_SEARCH_PEOPLE))
        );
    }
}