package by.bsu.metelskaya.steps;

import by.bsu.metelskaya.page.PassengerPage;
import org.openqa.selenium.WebDriver;

public class PassengerPageSteps {
    PassengerPage passengerPage;

    public PassengerPageSteps(WebDriver driver) {
        passengerPage = new PassengerPage(driver);
    }

    public String getErrorWhenPassengerInformationIsNotFilled() {
        passengerPage.clickContinueButton();
        return passengerPage.getError();
    }
}
