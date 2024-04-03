package base;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Logger;
/**
 * Base class for page objects.
 *
 * @param <T> The specific type of the page object.
 */
public class BasePageObject<T> {
    protected WebDriver driver;
    protected Logger log;
    protected WebDriverWait wait;
    protected BasePageObject(WebDriver driver, Logger log) {
        this.log = log;
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }
    /**
     * Navigates to a specified URL.
     *
     * @param url The URL to navigate to.
     * @return The instance of the current page object.
     */
    @SuppressWarnings("unchecked")
    protected T getPage(String url) {
        driver.get(url);
        return (T) this;
    }
    /**
     * Types text into an element.
     *
     * @param input   The text to type.
     * @param element The locator of the element to type into.
     */
    protected void type(Object input, By element) {
        find(element).sendKeys(input.toString());
    }
    /**
     * Clicks on an element.
     *
     * @param element The locator of the element to click.
     */
    protected void click(By element) {
        find(element).click();
    }

    /**
     * Finds an element using a specific locator.
     *
     * @param element The locator of the element to find.
     * @return The found element.
     */
    protected WebElement find(By element) {
        return driver.findElement(element);
    }
    /**
     * Waits for an element to be visible on the page.
     *
     * @param locator           The locator of the element to wait for.
     * @param timeOutInSeconds The maximum wait time in seconds.
     */
    protected void waitForVisibilityOf(By locator, Integer... timeOutInSeconds) {
        int attempts = 0;
        while (attempts < 2) {
            try {
                waitFor(ExpectedConditions.visibilityOfElementLocated(locator), timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null);
                break;
            } catch (StaleElementReferenceException e) {
            }
            attempts++;
        }
    }
    /**
     * Waits until a certain condition is met.
     *
     * @param condition         The condition to wait for.
     * @param timeOutInSeconds The maximum wait time in seconds.
     */
    private void waitFor(ExpectedCondition<WebElement> condition, Integer timeOutInSeconds) {
        timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : 50;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
        wait.until(condition);
    }
    /**
     * Asserts that the text of an element is equal to an expected text.
     *
     * @param expectedText The expected text.
     * @param element      The locator of the element to check the text for.
     */
    protected void assertTextEquals(String expectedText, By element) {
        String actualText = find(element).getText();
        if (!actualText.equals(expectedText)) {
            throw new AssertionError("The expected text: '" + expectedText + " 'is not equal to the actual text:  '" + actualText + "'");
        }
    }


}