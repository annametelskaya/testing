import by.bsu.metelskaya.pages.MainPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Tests {
    WebDriver driver;
    MainPage page;

    @Before
    public void openPage() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.airbaltic.com/en-BY/index");
        page = new MainPage(driver);
    }

    @Test
    public void findTicketWhenDepartureDateIsLaterThanReturnDate() {
        String expectedError = "The date of the inbound flight cannot be earlier than the date of the outbound flight. Please adjust your selection.";
        Assert.assertEquals(page.tryTofindTicketWhenDepartureDateIsLaterThanReturnDate(), expectedError);
    }

    @Test
    public void findTicketWhenNumberOfInfantIsMoreThanAdults() {
        String expectedError = "The number of infants can not be higher than the number of adults. Only an adult can accompany an infant.";
        Assert.assertEquals(page.tryToFindTicketWhenNumberOfInfantsIsMoreThanAdults(), expectedError);
    }

    @Test
    public void findWhenAllFieldsAreEmpty() {
        String expectedError = "Please select the departure date.\n" +
                "Please select the return date.\n" +
                "Please select the destination of your journey.\n" +
                "Please select the origin of your journey.";
        Assert.assertEquals(page.tryToFindWhenAllFieldsAreEmpty(), expectedError);

    }

    @After
    public void close() {
        driver.quit();
    }
}