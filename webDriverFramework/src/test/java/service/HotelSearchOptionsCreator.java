package service;

import model.HotelSearchOptions;

public class HotelSearchOptionsCreator {
    public static final String HOTEL_SEARCH_DESTINATION = "testdata.hotelData.destination";
    public static final String HOTEL_SEARCH_ARRIVAL_DATE = "testdata.hotelData.arrivalDate";
    public static final String HOTEL_SEARCH_DEPARTUE_DATE = "testdata.hotelData.departueDate";
    public static final String HOTEL_SEARCH_DEPARTUE_OCCUPANCY = "testdata.hotelData.occupancy";

    public static HotelSearchOptions hotelSearchData() {
        return new HotelSearchOptions(
                TestDataReader.getTestData(HOTEL_SEARCH_DESTINATION),
                TestDataReader.getTestData(HOTEL_SEARCH_ARRIVAL_DATE),
                TestDataReader.getTestData(HOTEL_SEARCH_DEPARTUE_DATE),
                TestDataReader.getTestData(HOTEL_SEARCH_DEPARTUE_OCCUPANCY)
        );
    }
}
