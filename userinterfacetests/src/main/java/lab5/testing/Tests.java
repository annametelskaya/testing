package lab5.testing;


import org.junit.Assert;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Tests {

    public void fillAllFields(WebDriver driver, WebDriverWait wait) throws InterruptedException {
        driver.get("https://www.airbaltic.com/en-BY/index");
        Thread.sleep(5000);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("input-container")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("dropdown-item"))).get(0).click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("dropdown-item"))).get(1).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("date-field-wrap"))).click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("available"))).get(4).click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("available"))).get(1).click();
        Thread.sleep(5000);
    }

    @Test
    public void findTicketWhenDepartureDateIsLaterThanReturnDate() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/home/anna/.m2/repository/webdriver/chromedriver/linux64/2.41/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        fillAllFields(driver, wait);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("date-field-wrap"))).click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("direct"))).get(10).click();
        Thread.sleep(5000);
        String realError = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("form-errors"))).getText();
        String expectedError = "The date of the inbound flight cannot be earlier than the date of the outbound flight. Please adjust your selection.";
        driver.quit();
        Assert.assertEquals(realError, expectedError);
    }

    @Test
    public void findTicketWhenThereAreBlankFields() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/home/anna/.m2/repository/webdriver/chromedriver/linux64/2.41/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get("https://www.airbaltic.com/en-BY/index");
        Thread.sleep(5000);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("input-container")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("btn"))).submit();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("btn"))).submit();
        Thread.sleep(5000);
        String realError = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("form-errors"))).getText();
        String expectedError = "Please select the departure date.\n" +
                "Please select the return date.\n" +
                "Please select the destination of your journey.\n" +
                "Please select the origin of your journey.";
        driver.quit();
        Assert.assertEquals(realError, expectedError);
    }

    @Test
    public void findTicketWhenNumberOfBabiesIsMoreThanAdults() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/home/anna/.m2/repository/webdriver/chromedriver/linux64/2.41/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        fillAllFields(driver, wait);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("pax-selector-block"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div/form/div[4]/div[2]/div[2]/div/div[2]/div[5]/span[2]"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div/form/div[4]/div[2]/div[2]/div/div[2]/div[5]/span[2]"))).click();
        Thread.sleep(5000);
        String realError = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("form-errors"))).getText();
        String expectedError = "The number of infants can not be higher than the number of adults. Only an adult can accompany an infant.";
        driver.quit();
        Assert.assertEquals(realError, expectedError);
    }
}
