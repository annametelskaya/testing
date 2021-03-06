package by.bsu.metelskaya.steps;

import by.bsu.metelskaya.pages.MainPage;
import org.openqa.selenium.WebDriver;

public class MainPageSteps {
    private MainPage mainPage;

    public MainPageSteps(WebDriver driver) {
        mainPage = new MainPage(driver);
    }

    public String tryToFindTicketWhenDepartureDateIsLaterThanReturnDate() {
        mainPage.scrollToContent();
        mainPage.clickSearch(1);
        mainPage.chooseReturnDate(1);
        mainPage.chooseDepartureDate(3);
        return mainPage.getError();
    }
}
