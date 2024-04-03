package pages;

import base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.logging.Logger;
/**
 * Page object class representing the shopping cart page.
 */
public class Cart extends BasePageObject {
    private By productDetails = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[1]");
    private By checkoutButton = By.id("checkout");
    protected Cart(WebDriver driver, Logger log) {
        super(driver,log);
    }

    /**
     * Verifies the presence of a product in the shopping cart.
     *
     * @param expectedText The expected text of the product.
     */
    public void verifyProduct(String expectedText) {
        assertTextEquals(expectedText,productDetails);
    }
    /**
     * Navigates to the checkout page.
     *
     * @return An instance of the Checkout page.
     */
    public Checkout goToCheckout() {
        click(checkoutButton);
        return new Checkout(driver,log);
    }
}
