package by.bsu.metelskaya.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage {
    @FindBy(xpath = "//div[@class='el-tabs__content']")
    private WebElement content;

    @FindBy(xpath = "//div[@class='orig-destin origin']/div/input")
    private WebElement inputForm;

    @FindBy(xpath = "//div[@class='orig-destin destin']/div/input")
    private WebElement inputTo;

    @FindBy(xpath = "//li[@class='dropdown-item']/div/div[@class='airport']")
    private List<WebElement> dropdown;

    @FindBy(xpath = "//div[@class='departure']/div/input")
    private WebElement departureCalendar;

    @FindBy(xpath = "//div[@class='return']/div/input")
    private WebElement returnCalendar;

    @FindBy(xpath = "//td[@class='available']")
    private List<WebElement> availableDates;

    @FindBy(xpath = "//div[@focusoutforceopen='openPaxSelector']")
    private WebElement passengersSelector;

    @FindBy(xpath = "//div[@class='pax-count-input'][last()]/span[last()]")
    private WebElement plusInfant;

    @FindBy(xpath = "//ul[@class='dropdown-menu open empty']/li")
    private WebElement airportError;

    @FindBy(xpath = "//ul[@class='form-errors']")
    private WebElement errors;

    @FindBy(xpath = "//div[@class='btn btn-blue btn-search']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@class='el-tabs__item manage-my-booking']")
    private WebElement bookingTab;

    @FindBy(xpath = "//div[@class='mmb-field-group booking-nr']/div[@class='mmb-field-wrap']/input")
    private WebElement ticketNumberField;

    @FindBy(xpath = "//div[@class='mmb-field-group surname']/div[@class='mmb-field-wrap']/input")
    private WebElement surnameField;

    @FindBy(xpath = "//div[@class='btn btn-blue btn-mmb']/button")
    private WebElement mmbButton;

    private WebDriver driver;


    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void scrollToContent() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", content);
    }

    public void selectArrivalAirport(String airport) {
        inputForm.click();
        findAirport(airport);
    }

    public void selectDepartureAirport(String airport) {
        findAirport(airport);
    }

    public void selectDepartureDate(int numberOfDaysFromNow) {
        departureCalendar.click();
        availableDates.get(numberOfDaysFromNow - 1).click();
    }

    public void selectReturnDate(int numberOfDaysFromNow) {
        returnCalendar.click();
        availableDates.get(numberOfDaysFromNow - 1).click();
    }

    public void fillArrivalAirportField(String airport) {
        inputForm.sendKeys(airport);
    }

    public void fillTicketNumberField(String number) {
        ticketNumberField.sendKeys(number);
    }

    public void fillSurnameField(String surname) {
        surnameField.sendKeys(surname);
    }

    public void clickToAddNewPassenger() {
        passengersSelector.click();
    }

    public void clickBookingTab() {
        bookingTab.click();
    }

    public void clickBookingMerge() {
        mmbButton.submit();
    }

    public void clickSearch(int number) {
        for (int i = 0; i < number; i++)
            searchButton.submit();
    }

    public void addInfants(int number) {
        addFewPassengers(number, plusInfant);
    }

    public String getError() {
        return errors.getText();
    }

    public String getAirportError() {
        return airportError.getText();
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

