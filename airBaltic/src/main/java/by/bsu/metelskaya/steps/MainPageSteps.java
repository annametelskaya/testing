package by.bsu.metelskaya.steps;

import by.bsu.metelskaya.common.SearchData;
import by.bsu.metelskaya.page.MainPage;
import org.openqa.selenium.WebDriver;

public class MainPageSteps {
    private MainPage mainPage;

    public MainPageSteps(WebDriver driver) {
        mainPage = new MainPage(driver);
    }

    public void selectCheapFlight() {
//        mainPage.selectArrivalAirport("Riga (RIX) - Latvia");
//        mainPage.selectDepartureAirport("London (Gatwick) (LGW) - United Kingdom");
//        mainPage.selectDepartureDate(1);
//        mainPage.selectReturnDate(2);
//        mainPage.clickSearch();
        mainPage.selectFlight();
    }

    public String getErrorWhenArrivalAirportDoesNotExist(SearchData data) {
        mainPage.fillArrivalAirportField(data.getArrivalAirport());
        return mainPage.getAirportError();
    }

    public String getErrorWhenDepartureDateIsLaterThanReturnDate(SearchData data) {
        mainPage.scrollToContent();
        mainPage.clickSearch();
        mainPage.selectReturnDate(data.getNumberOfDaysFromNowInReturnCalendar());
        mainPage.selectDepartureDate(data.getNumberOfDaysFromNowInDepartureDate());
        return mainPage.getError();
    }

    public String getErrorWhenNumberOfInfantsIsMoreThanAdults(SearchData data) {
        mainPage.scrollToContent();
        mainPage.clickSearch();
        mainPage.clickToAddNewPassenger();
        mainPage.addInfants(data.getNumberOfInfant());
        return mainPage.getError();
    }

    public String getErrorWhenAllFieldsAreEmpty() {
        mainPage.scrollToContent();
        mainPage.clickSearch();
        mainPage.clickSearch();
        return mainPage.getError();
    }

    public String getErrorWhenArrivalAirportEqualsToDepartureOne() {
        mainPage.scrollToContent();
        mainPage.selectArrivalAirport("Frankfurt (am Main) (FRA) - Germany");
        mainPage.selectDepartureAirport("Moscow (Sheremetyevo) (SVO) - Russia");
        mainPage.selectArrivalAirport("Moscow (Sheremetyevo) (SVO) - Russia");
        return mainPage.getError();
    }

    public String getErrorWhenSurnameIsNotInEnglish(SearchData data) {
        mainPage.clickBookingTab();
        mainPage.fillTicketNumberField(data.getTicketNumberForBooking());
        mainPage.fillSurnameField(data.getSurnameForBooking());
        mainPage.clickBookingMerge();
        return mainPage.getError();
    }

    public String getErrorWhenTicketNumberIsLessThanSixSymbols(SearchData data) {
        mainPage.clickBookingTab();
        mainPage.fillTicketNumberField(data.getTicketNumberForBooking());
        mainPage.fillSurnameField(data.getSurnameForBooking());
        mainPage.clickBookingMerge();
        return mainPage.getError();
    }
}
