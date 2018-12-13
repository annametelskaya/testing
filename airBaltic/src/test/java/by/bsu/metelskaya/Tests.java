package by.bsu.metelskaya;

import by.bsu.metelskaya.common.PassengerInformation;
import by.bsu.metelskaya.common.SearchData;
import by.bsu.metelskaya.steps.FlightsBookingPageSteps;
import by.bsu.metelskaya.steps.MainPageSteps;
import by.bsu.metelskaya.steps.PassengerPageSteps;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Tests {
    WebDriver driver;
    MainPageSteps mainPageSteps;
    FlightsBookingPageSteps flightsBookingPageSteps;
    PassengerPageSteps passengerPageSteps;

    @Before
    public void openPage() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        options.addArguments("--no-sandbox"); // Bypass OS security model
        driver = new ChromeDriver(options);
        driver.get("https://www.airbaltic.com/en-BY/index");
        mainPageSteps = new MainPageSteps(driver);
        flightsBookingPageSteps = new FlightsBookingPageSteps(driver);
        passengerPageSteps = new PassengerPageSteps(driver);
    }

    @Test
    public void findTicketWhenDepartureDateIsLaterThanReturnDate() {
        SearchData data = new SearchData();
        data.setNumberOfDaysFromNowInDepartureDate(3);
        data.setNumberOfDaysFromNowInReturnCalendar(1);
        String expectedError = "The date of the inbound flight cannot be earlier than the date of the outbound flight. Please adjust your selection.";
        Assert.assertEquals(mainPageSteps.getErrorWhenDepartureDateIsLaterThanReturnDate(data), expectedError);
    }

    @Test
    public void findTicketWhenNumberOfInfantIsMoreThanAdults() {
        SearchData data = new SearchData();
        data.setNumberOfInfant(2);
        String expectedError = "The number of infants can not be higher than the number of adults. Only an adult can accompany an infant.";
        Assert.assertEquals(mainPageSteps.getErrorWhenNumberOfInfantsIsMoreThanAdults(data), expectedError);
    }

    @Test
    public void findTicketWhenAllFieldsAreEmpty() {
        String expectedError = "Please select the departure date.\n" +
                "Please select the return date.\n" +
                "Please select the destination of your journey.\n" +
                "Please select the origin of your journey.";
        Assert.assertEquals(mainPageSteps.getErrorWhenAllFieldsAreEmpty(), expectedError);
    }

    @Test
    public void findTicketWhenArrivalAirportEqualsToDepartureOne() {
        SearchData data = new SearchData();
        data.setArrivalAirport("Riga (RIX) - Latvia");
        data.setDepartureAirport("London (Gatwick) (LGW) - United Kingdom");
        String expectedError = "Please select the destination of your journey.";
        Assert.assertEquals(mainPageSteps.getErrorWhenArrivalAirportEqualsToDepartureOne(data), expectedError);
    }

    @Test
    public void findTicketWhenArrivalAirportDoesNotExist() {
        SearchData data = new SearchData();
        data.setArrivalAirport("example");
        String expectedError = "Unfortunately, we do not fly to/from ";
        Assert.assertTrue(mainPageSteps.getErrorWhenArrivalAirportDoesNotExist(data).contains(expectedError));
    }

    @Test
    public void findBookingWhenSurnameIsNotInEnglish() {
        SearchData data = new SearchData();
        data.setTicketNumberForBooking("123456");
        data.setSurnameForBooking("Иванов");
        String expectedError = "Only Latin characters are allowed";
        Assert.assertEquals(mainPageSteps.getErrorWhenSurnameIsNotInEnglish(data), expectedError);
    }

    @Test
    public void findBookingWhenTicketNumberIsLessThanSixSymbols() {
        SearchData data = new SearchData();
        data.setTicketNumberForBooking("12345");
        data.setSurnameForBooking("Brawn");
        String expectedError = "The booking reference consists of 6 symbols. The ticket number consists of 3 + 10 digits, separated by a hyphen.";
        Assert.assertEquals(mainPageSteps.getErrorWhenTicketNumberIsLessThanSixSymbols(data), expectedError);
    }

    @Test
    public void findTickets(){
        SearchData data = new SearchData();
        data.setArrivalAirport("Riga (RIX) - Latvia");
        data.setDepartureAirport("London (Gatwick) (LGW) - United Kingdom");
        data.setNumberOfDaysFromNowInDepartureDate(3);
        data.setNumberOfDaysFromNowInReturnCalendar(5);
        mainPageSteps.selectFlight(data);
        Assert.assertFalse(flightsBookingPageSteps.checksIsErrorExist());
    }

    @Test
    public void bookTicketWhenPassengerInformationIsNotFilled() {
        SearchData data = new SearchData();
        data.setArrivalAirport("Riga (RIX) - Latvia");
        data.setDepartureAirport("London (Gatwick) (LGW) - United Kingdom");
        data.setNumberOfDaysFromNowInDepartureDate(3);
        data.setNumberOfDaysFromNowInReturnCalendar(5);
        mainPageSteps.selectFlight(data);
        flightsBookingPageSteps.clickContinue();
        String expectedError = "All mandatory fields have not been filled in or there are fields which are filled in incorrectly. Please use Latin characters only, special characters like dash (-) or apostrophe (') are not accepted.";
        Assert.assertTrue(passengerPageSteps.getErrorWhenPassengerInformationIsNotFilled().contains(expectedError));
    }

    @After
    public void close() {
        driver.quit();
        driver = null;
    }
}