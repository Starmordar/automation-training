package model;

import java.util.Objects;

public class HotelSearchOptions {
    private String destination;
    private String arrivalDate;
    private String departureDate;
    private String occupancy;


    public HotelSearchOptions(String destination, String departureDate, String arrivalDate, String occupancy) {
        this.destination = destination;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.occupancy = occupancy;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getOccupancy() {
        return occupancy;
    }

    public void setOccupancy(String occupancy) {
        this.occupancy = occupancy;
    }


    @Override
    public String toString() {
        return "HotelSearchOption{" +
                "destination='" + destination + '\'' +
                ", arrivalDate='" + arrivalDate + '\'' +
                ", departueDate='" + departureDate + '\'' +
                ", occupancy='" + occupancy + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        HotelSearchOptions that = (HotelSearchOptions) obj;
        return Objects.equals(getDestination(), that.getDestination()) &&
                Objects.equals(getArrivalDate(), that.getArrivalDate()) &&
                Objects.equals(getDepartureDate(), that.getDepartureDate()) &&
                Objects.equals(getOccupancy(), that.getOccupancy());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDestination(), getArrivalDate(), getDepartureDate(), getOccupancy());
    }
}
