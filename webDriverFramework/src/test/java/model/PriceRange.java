package model;

import java.util.Objects;

public class PriceRange {
    private String minPrice;
    private String maxPrice;


    public PriceRange(String minPrice, String maxPrice) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    public String getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(String minPrice) {
        this.minPrice = minPrice;
    }

    public String getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(String maxPrice) {
        this.maxPrice = maxPrice;
    }

    @Override
    public String toString() {
        return "PriceRange{" +
                "minPrice='" + minPrice + '\'' +
                "maxPrice='" + maxPrice + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PriceRange that = (PriceRange) obj;
        return Objects.equals(getMinPrice(), that.getMinPrice()) &&
                Objects.equals(getMaxPrice(), that.getMaxPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMinPrice(), getMaxPrice());
    }
}
