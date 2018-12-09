package by.bsu.metelskaya;

import by.bsu.metelskaya.steps.MainPageSteps;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tests {
    WebDriver driver;
    MainPageSteps steps;

    @Before
    public void openPage() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.airbaltic.com/en-BY/index");
        steps = new MainPageSteps(driver);
    }

    @Test
    public void findTicketWhenDepartureDateIsLaterThanReturnDate() {
        String expectedError = "The date of the inbound flight cannot be earlier than the date of the outbound flight. Please adjust your selection.";
        Assert.assertEquals(steps.tryToFindTicketWhenDepartureDateIsLaterThanReturnDate(), expectedError);
    }

    @Test
    public void findTicketWhenNumberOfInfantIsMoreThanAdults() {
        String expectedError = "The number of infants can not be higher than the number of adults. Only an adult can accompany an infant.";
        Assert.assertEquals(steps.tryToFindTicketWhenNumberOfInfantsIsMoreThanAdults(), expectedError);
    }

    @Test
    public void findWhenAllFieldsAreEmpty() {
        String expectedError = "Please select the departure date.\n" +
                "Please select the return date.\n" +
                "Please select the destination of your journey.\n" +
                "Please select the origin of your journey.";
        Assert.assertEquals(steps.tryToFindWhenAllFieldsAreEmpty(), expectedError);

    }

    @After
    public void close() {
        driver.quit();
    }
}