package service;

import model.PriceRange;

public class PriceRangeCreator {
    public static final String PRICE_RANGE_MIN = "testdata.priceRange.minPrice";
    public static final String PRICE_RANGE_MAX = "testdata.priceRange.maxPrice";

    public static PriceRange priceData() {
        return new PriceRange(
                TestDataReader.getTestData(PRICE_RANGE_MIN),
                TestDataReader.getTestData(PRICE_RANGE_MAX)
        );
    }
}
