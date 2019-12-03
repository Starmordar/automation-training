package framework.model;

public class HotelSearchOptions {
    private String destination;
    private String arrivalDate;
    private String departureDate;
    private Integer numberOfPersons;


    public HotelSearchOptions(String destination, String arrivalDate, String departureDate, Integer numberOfPersons) {
        this.destination = destination;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.numberOfPersons = numberOfPersons;
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

    public int getPersonNumber() {
        return numberOfPersons;
    }

    public void setPersonNumber(Integer numberOfPersons) {
        this.numberOfPersons = numberOfPersons;
    }

    @Override
    public String toString() {
        return "HotelSearchOption{" +
                "destination='" + destination + '\'' +
                ", arrivalDate='" + arrivalDate + '\'' +
                ", departureDate='" + departureDate + '\'' +
                ", numberOfPersons=" + numberOfPersons +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        HotelSearchOptions that = (HotelSearchOptions) obj;
        return Objects.equals(getPersonNumber() == that.getPersonNumber()) &&
               Objects.equals(getDestination(), that.getDestination()) &&
               Objects.equals(getArrivalDate(), that.getArrivalDate()) &&
               Objects.equals(getDepartureDate(), that.getDepartureDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDestination(), getArrivalDate(), getDepartureDate(), getPersonNumber());
    }
}
