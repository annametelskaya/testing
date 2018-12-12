package by.bsu.metelskaya.common;

public class SearchData {
    private String arrivalAirport;
    private String departureAirport;
    private int numberOfDaysFromNowInDepartureDate;
    private int numberOfDaysFromNowInReturnCalendar;
    private int numberOfAdults;
    private int numberOfChildren;
    private int numberOfInfant;
    private String ticketNumberForBooking;
    private String surnameForBooking;

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public void setNumberOfDaysFromNowInDepartureDate(int numberOfDaysFromNowInDepartureDate) {
        this.numberOfDaysFromNowInDepartureDate = numberOfDaysFromNowInDepartureDate;
    }

    public void setNumberOfDaysFromNowInReturnCalendar(int numberOfDaysFromNowInReturnCalendar) {
        this.numberOfDaysFromNowInReturnCalendar = numberOfDaysFromNowInReturnCalendar;
    }

    public void setNumberOfAdults(int numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }

    public void setNumberOfChildren(int numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }

    public void setNumberOfInfant(int numberOfInfant) {
        this.numberOfInfant = numberOfInfant;
    }

    public void setTicketNumberForBooking(String ticketNumberForBooking) {
        this.ticketNumberForBooking = ticketNumberForBooking;
    }

    public void setSurnameForBooking(String surnameForBooking) {
        this.surnameForBooking = surnameForBooking;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public int getNumberOfDaysFromNowInDepartureDate() {
        return numberOfDaysFromNowInDepartureDate;
    }

    public int getNumberOfDaysFromNowInReturnCalendar() {
        return numberOfDaysFromNowInReturnCalendar;
    }

    public int getNumberOfAdults() {
        return numberOfAdults;
    }

    public int getNumberOfChildren() {
        return numberOfChildren;
    }

    public int getNumberOfInfant() {
        return numberOfInfant;
    }

    public String getTicketNumberForBooking() {
        return ticketNumberForBooking;
    }

    public String getSurnameForBooking() {
        return surnameForBooking;
    }
}
