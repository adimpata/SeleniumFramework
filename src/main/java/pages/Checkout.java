package pages;

import base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.logging.Logger;
/**
 * Page object class representing the checkout page.
 */
public class Checkout extends BasePageObject {
    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By postalCode = By.id("postal-code");
    private By buttonContinue = By.id("continue");
    private By buttonFinish = By.id("finish");
    private By message = By.cssSelector("#checkout_complete_container > h2");
    private By backButton = By.id("back-to-products");
    protected Checkout(WebDriver driver, Logger log) {
        super(driver,log);
    }
    /**
     * Enters credentials during checkout.
     *
     * @param firstname  The first name to enter.
     * @param lastname   The last name to enter.
     * @param postalcode The postal code to enter.
     */
    public void enterCredentialsCheckout(String firstname,String lastname,Integer postalcode){
        type(firstname,firstName);
        type(lastname,lastName);
        type(postalcode,postalCode);
    }
    /**
     * Clicks the buttons to proceed with checkout.
     */
    public void button(){
        click(buttonContinue);
        waitForVisibilityOf(buttonFinish,5);
        click(buttonFinish);
    }
    /**
     * Verifies a message displayed after completing the checkout process.
     *
     * @param expectedText The expected text of the message.
     */
    public void verifyMessage(String expectedText){
       assertTextEquals(expectedText,message);
    }
    /**
     * Clicks the back button to return to the products page.
     */
    public void back(){
        click(backButton);
    }
}
