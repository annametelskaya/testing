package by.bsu.metelskaya.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    @FindBy(xpath = "//td[@class='direct available']")
    private List<WebElement> available;

    @FindBy(xpath = "//td[@class='available in-range highlighted']")
    private List<WebElement> availableInRange;

    @FindBy(xpath = "//div[@focusoutforceopen='openPaxSelector']")
    private WebElement passengersSelector;

    @FindBy(xpath = "//div[@class='pax-count-input'][1]/span[last()]")
    private WebElement plusAdult;

    @FindBy(xpath = "//div[@class='pax-count-input'][2]/span[last()]")
    private WebElement plusChildren;

    @FindBy(xpath = "//div[@class='pax-count-input'][3]/span[last()]")
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

    @FindBy(xpath = "//div[@class='promo-code-block']")
    private WebElement promoCodeButton;

    @FindBy(xpath = "//div[@class='promo-code-field']/input")
    private WebElement promoCode;

    private WebDriver driver;
    private WebDriverWait wait;


    public MainPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void scrollToContent() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", content);
    }

    public void selectArrivalAirport(String airport) {
        checkVisibility(inputForm).click();
        findAirport(airport);
    }

    public void selectDepartureAirport(String airport) {
        findAirport(airport);
    }

    public void selectDepartureDate(int numberOfDaysFromNow) {
        checkVisibility(departureCalendar).click();
        checkVisibility(availableDates.get(numberOfDaysFromNow - 1)).click();
    }

    public void selectDeparture(int numberOfDaysFromNow) {
        checkVisibility(departureCalendar).click();
        checkVisibility(available.get(numberOfDaysFromNow - 1)).click();
    }

    public void selectReturnDate(int numberOfDaysFromNow) {
        checkVisibility(returnCalendar).click();
        checkVisibility(availableDates.get(numberOfDaysFromNow - 1)).click();
    }

    public void selectReturn(int numberOfDaysFromNow) {
        checkVisibility(returnCalendar).click();
        checkVisibility(available.get(numberOfDaysFromNow - 1)).click();
    }

    public void selectPromoCode() {
        checkVisibility(promoCodeButton).click();
    }

    public void fillArrivalAirportField(String airport) {
        checkVisibility(inputForm).sendKeys(airport);
    }

    public void fillTicketNumberField(String number) {
        checkVisibility(ticketNumberField).sendKeys(number);
    }

    public void fillSurnameField(String surname) {
        checkVisibility(surnameField).sendKeys(surname);
    }

    public void fillPromoCode(String code){
        checkVisibility(promoCode).sendKeys(code);
    }

    public void clickToAddNewPassenger() {
        checkVisibility(passengersSelector).click();
    }

    public void clickBookingTab() {
        checkVisibility(bookingTab).click();
    }

    public void clickBookingMerge() {
        checkVisibility(mmbButton).submit();
    }

    public void clickSearch() {
        checkVisibility(searchButton).submit();
    }

    public void addInfants(int number) {
        addPassengers(number, "infant");
    }

    public String getError() {
        return checkVisibility(errors).getText();
    }

    public String getAirportError() {
        return checkVisibility(airportError).getText();
    }

    private void addPassengers(int number, String type) {
        switch (type) {
            case "adult": {
                for (int i = 0; i < number; i++) {
                    checkVisibility(plusAdult).click();
                }
                break;
            }
            case "children": {
                for (int i = 0; i < number; i++) {
                    checkVisibility(plusChildren).click();
                }
                break;
            }
            case "infant": {
                for (int i = 0; i < number; i++) {
                    checkVisibility(plusInfant).click();
                }
                break;
            }
        }
    }

    private void findAirport(String airportName) {
        for (WebElement airport : dropdown) {
            if (checkVisibility(airport).getText().equals(airportName)) {
                checkVisibility(airport).click();
                return;
            }
        }
    }

    private WebElement checkVisibility(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
}