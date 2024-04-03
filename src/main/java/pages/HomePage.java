package pages;

import base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.logging.Logger;
/**
 * Page object class representing the home page.
 */
public class HomePage extends BasePageObject<HomePage> {

    private By product = By.xpath("//*[@id=\"item_4_title_link\"]/div");
    private By addToCart = By.id("add-to-cart");
    private By cart = By.xpath("//*[@id=\"shopping_cart_container\"]/a");
    protected HomePage(WebDriver driver, Logger log){
        super(driver,log);
    }
    /**
     * Selects a product from the home page and adds it to the cart.
     */
    public void selectProduct(){
        click(product);
        waitForVisibilityOf(addToCart,5);
        click(addToCart);
    }
    /**
     * Navigates to the cart page.
     *
     * @return An instance of the Cart page.
     */
    public Cart goToCart(){
        click(cart);
        return new Cart(driver,log);
    }
}
