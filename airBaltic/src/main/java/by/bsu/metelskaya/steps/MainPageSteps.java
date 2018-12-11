package by.bsu.metelskaya.steps;

import by.bsu.metelskaya.page.MainPage;
import org.openqa.selenium.WebDriver;

public class MainPageSteps {
    private MainPage mainPage;

    public MainPageSteps(WebDriver driver) {
        mainPage = new MainPage(driver);
    }

    public void getAllTickets() {
        mainPage.selectArrivalAirport("Riga (RIX) - Latvia");
        mainPage.selectArrivalAirport("London (Gatwick) (LGW) - United Kingdom");
        mainPage.selectDepartureDate(1);
        mainPage.selectReturnDate(1);
        mainPage.clickSearch();
    }

    public String getErrorWhenArrivalAirportDoesNotExist() {
        mainPage.fillArrivalAirportField("example");
        return mainPage.getAirportError();
    }

    public String getErrorWhenDepartureDateIsLaterThanReturnDate() {
        mainPage.scrollToContent();
        mainPage.clickSearch();
        mainPage.selectReturnDate(1);
        mainPage.selectDepartureDate(3);
        return mainPage.getError();
    }

    public String getErrorWhenNumberOfInfantsIsMoreThanAdults() {
        mainPage.scrollToContent();
        mainPage.clickSearch();
        mainPage.clickToAddNewPassenger();
        mainPage.addInfants(2);
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

    public String getErrorWhenSurnameIsNotInEnglish() {
        mainPage.clickBookingTab();
        mainPage.fillTicketNumberField("123456");
        mainPage.fillSurnameField("Иванов");
        mainPage.clickBookingMerge();
        return mainPage.getError();
    }

    public String getErrorWhenTicketNumberIsLessThanSixsymbols() {
        mainPage.clickBookingTab();
        mainPage.fillTicketNumberField("12345");
        mainPage.fillSurnameField("Brawn");
        mainPage.clickBookingMerge();
        return mainPage.getError();
    }
}
