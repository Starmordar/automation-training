package model;

import java.util.Objects;

public class CountrySearchOptions {
    private String country;


    public CountrySearchOptions(String coutry) {
        this.country = coutry;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "CountrySearchOption{" +
                "country='" + country + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CountrySearchOptions that = (CountrySearchOptions) obj;
        return Objects.equals(getCountry(), that.getCountry());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCountry());
    }
}
