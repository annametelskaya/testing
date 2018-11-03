package by.bsu.metelskaya.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage {
    @FindBy(xpath = "//div[@class=\"el-tabs__content\"]")
    private WebElement content;
    @FindBy(xpath = "//div[@class=\"orig-destin origin\"]/div/input")
    private WebElement inputForm;
    @FindBy(xpath = "//li[@class=\"dropdown-item\"]/div/div[@class=\"airport\"]")
    private List<WebElement> dropdown;
    @FindBy(xpath = "//div[@class=\"departure\"]/div/input")
    private WebElement departureCalendar;
    @FindBy(xpath = "//div[@class=\"return\"]/div/input")
    private WebElement returnCalendar;
    @FindBy(xpath = "//td[@class=\"available\"]")
    private List<WebElement> availableDates;
    @FindBy(xpath = "//div[@focusoutforceopen=\"openPaxSelector\"]")
    private WebElement passengersSelector;
    @FindBy(xpath = "//div[@class=\"pax-count-input\"][3]/span[2]")
    private WebElement plusInfant;
    @FindBy(xpath = "//ul[@class=\"form-errors\"]")
    WebElement errors;
    @FindBy(xpath = "//div[@class=\"btn btn-blue btn-search\"]")
    WebElement serchButton;

    private WebDriver driver;


    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String tryTofindTicketWhenDepartureDateIsLaterThanReturnDate() {
        scrollToContent();
        typeArrivalAirport("Riga (RIX) - Latvia");
        typeDepartureAirport("Frankfurt (am Main) (FRA) - Germany");
        chooseReturnDate(1);
        chooseDepartureDate(3);
        return errors.getText();
    }

    public String tryToFindTicketWhenNumberOfInfantsIsMoreThanAdults() {
        scrollToContent();
        typeArrivalAirport("Riga (RIX) - Latvia");
        typeDepartureAirport("Frankfurt (am Main) (FRA) - Germany");
        chooseDepartureDate(2);
        chooseReturnDate(1);
        clickToAddNewPassenger();
        addInfants(2);
        return errors.getText();
    }

    public String tryToFindWhenAllFieldsAreEmpty() {
        scrollToContent();
        clickSearch();
        clickSearch();
        return errors.getText();
    }

    MainPage scrollToContent() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", content);
        return this;
    }

    MainPage typeArrivalAirport(String airport) {
        inputForm.click();
        findAirport(airport);
        return this;
    }

    MainPage typeDepartureAirport(String airport) {
        findAirport(airport);
        return this;
    }

    MainPage chooseDepartureDate(int numberOfDaysFromNow) {
        departureCalendar.click();
        availableDates.get(numberOfDaysFromNow - 1).click();
        return this;
    }

    MainPage chooseReturnDate(int numberOfDaysFromNow) {
        returnCalendar.click();
        availableDates.get(numberOfDaysFromNow - 1).click();
        return this;
    }

    MainPage clickToAddNewPassenger() {
        passengersSelector.click();
        return this;
    }

    MainPage addInfants(int number) {
        addFewPassengers(number, plusInfant);
        return this;
    }

    MainPage clickSearch() {
        serchButton.click();
        return this;
    }

    private void addFewPassengers(int number, WebElement element) {
        for (int i = 0; i < number; i++) {
            element.click();
        }
    }

    private void findAirport(String airport) {
        for (WebElement a : dropdown) {
            if (a.getText().equals(airport)) {
                a.click();
                return;
            }
        }
    }
}
