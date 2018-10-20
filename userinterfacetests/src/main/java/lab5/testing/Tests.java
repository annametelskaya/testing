package lab5.testing;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Tests {

    @Test
    public void test() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/home/anna/.m2/repository/webdriver/chromedriver/linux64/2.41/chromedriver");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get("https://www.airbaltic.com/en-BY/index");
        Thread.sleep(5000);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("input-container")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("dropdown-item"))).get(0).click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("dropdown-item"))).get(1).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("date-field-wrap"))).click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("available"))).get(4).click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("available"))).get(5).click();
        Thread.sleep(5000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("date-field-wrap"))).click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("direct"))).get(10).click();
        Thread.sleep(5000);
        String realError = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("form-errors"))).getText();
        String expectedError = "The date of the inbound flight cannot be earlier than the date of the outbound flight. Please adjust your selection.";
        driver.quit();
        Assert.assertEquals(realError, expectedError);
    }
}
