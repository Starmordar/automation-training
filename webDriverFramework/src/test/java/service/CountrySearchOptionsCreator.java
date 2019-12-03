package service;

import model.CountrySearchOptions;

public class CountrySearchOptionsCreator {
    public static final String COUNTRY_SEARCH_COUNTRYNAME = "testdata.countrySearchData.countryName";

    public static CountrySearchOptions countrySearchData() {
        return new CountrySearchOptions(
                TestDataReader.getTestData(COUNTRY_SEARCH_COUNTRYNAME)
        );
    }
}
