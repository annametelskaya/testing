package by.bsu.metelskaya.steps;

import by.bsu.metelskaya.page.MainPage;
import org.openqa.selenium.WebDriver;

public class MainPageSteps {
    private MainPage mainPage;

    public MainPageSteps(WebDriver driver) {
        mainPage = new MainPage(driver);
    }

    public String getErrorWhenDepartureDateIsLaterThanReturnDate() {
        mainPage.scrollToContent();
        mainPage.clickSearch(1);
        mainPage.selectReturnDate(1);
        mainPage.selectDepartureDate(3);
        return mainPage.getError();
    }

    public String getErrorWhenNumberOfInfantsIsMoreThanAdults() {
        mainPage.scrollToContent();
        mainPage.clickSearch(1);
        mainPage.clickToAddNewPassenger();
        mainPage.addInfants(2);
        return mainPage.getError();
    }

    public String getErrorWhenAllFieldsAreEmpty() {
        mainPage.scrollToContent();
        mainPage.clickSearch(2);
        return mainPage.getError();
    }

    public String getErrorWhenArrivalAirportEqualsToDepartureOne() {
        mainPage.scrollToContent();
        mainPage.selectArrivalAirport("Frankfurt (am Main) (FRA) - Germany");
        mainPage.selectDepartureAirport("Riga (RIX) - Latvia");
        mainPage.selectArrivalAirport("Riga (RIX) - Latvia");
        return mainPage.getError();
    }

    public String getErrorWhenSurnameIsNotInEnglish() {
        mainPage.clickBookingTab();
        mainPage.fillTicketNumberField("123456");
        mainPage.fillSurnameField("Иванов");
        mainPage.clickBookingMerge();
        return mainPage.getError();
    }

    public String getErrorWhenTicketNumberIsLessThan6symbols() {
        mainPage.clickBookingTab();
        mainPage.fillTicketNumberField("12345");
        mainPage.fillSurnameField("Brawn");
        mainPage.clickBookingMerge();
        return mainPage.getError();
    }


}
