package by.bsu.metelskaya;

import by.bsu.metelskaya.steps.MainPageSteps;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MainPageTests {
    WebDriver driver;
    MainPageSteps steps;

    @Before
    public void openPage() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        options.addArguments("--no-sandbox"); // Bypass OS security model
        driver = new ChromeDriver(options);
        driver.get("https://www.airbaltic.com/en-BY/index");
        steps = new MainPageSteps(driver);
    }

    @Test
    public void findTicketWhenDepartureDateIsLaterThanReturnDate() {
        String expectedError = "The date of the inbound flight cannot be earlier than the date of the outbound flight. Please adjust your selection.";
        Assert.assertEquals(steps.getErrorWhenDepartureDateIsLaterThanReturnDate(), expectedError);
    }

    @Test
    public void findTicketWhenNumberOfInfantIsMoreThanAdults() {
        String expectedError = "The number of infants can not be higher than the number of adults. Only an adult can accompany an infant.";
        Assert.assertEquals(steps.getErrorWhenNumberOfInfantsIsMoreThanAdults(), expectedError);
    }

    @Test
    public void findTicketWhenAllFieldsAreEmpty() {
        String expectedError = "Please select the departure date.\n" +
                "Please select the return date.\n" +
                "Please select the destination of your journey.\n" +
                "Please select the origin of your journey.";
        Assert.assertEquals(steps.getErrorWhenAllFieldsAreEmpty(), expectedError);
    }

    @Test
    public void findTicketWhenArrivalAirportEqualsToDepartureOne() {
        String expectedError = "Please select the destination of your journey.";
        Assert.assertEquals(steps.getErrorWhenArrivalAirportEqualsToDepartureOne(), expectedError);
    }

    @Test
    public void findTicketWhenArrivalAirportDoesNotExist() {
        String expectedError = "Unfortunately, we do not fly to/from ";
        Assert.assertTrue(steps.getErrorWhenArrivalAirportDoesNotExist().contains(expectedError));
    }

    @Test
    public void findBookingWhenSurnameIsNotInEnglish() {
        String expectedError = "Only Latin characters are allowed";
        Assert.assertEquals(steps.getErrorWhenSurnameIsNotInEnglish(), expectedError);
    }

    @Test
    public void findBookingWhenTicketNumberIsLessThanSixSymbols() {
        String expectedError = "The booking reference consists of 6 symbols. The ticket number consists of 3 + 10 digits, separated by a hyphen.";
        Assert.assertEquals(steps.getErrorWhenTicketNumberIsLessThanSixsymbols(), expectedError);
    }

    @After
    public void close() {
        driver.quit();
        driver = null;
    }
}