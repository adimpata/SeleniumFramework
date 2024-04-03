package testng;

import base.BaseTest;
import base.CsvDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Cart;
import pages.Checkout;
import pages.HomePage;
import pages.LogInPage;
import java.util.Map;

public class LoginTest extends BaseTest {
    /**
     * Test method for successful login and checkout process.
     */
    @Test
    public void logInTest() {
        LogInPage logInPage = new LogInPage(driver,log);
        logInPage.openLoginPage();
        //Fill up email and password
        logInPage.enterCredentials("standard_user", "secret_sauce");
        //Push Sign In button and wait for page inventory to load and select a product from this page
        HomePage homePage = logInPage.pushSignInButton();
        homePage.selectProduct();
        //Navigate to the shopping cart where you check the added product
        Cart cart = homePage.goToCart();
        log.info("Verification");
        cart.verifyProduct("carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.");
        //Fill in the details and complete the payment
        Checkout checkout = cart.goToCheckout();
        log.info("Verification");
        checkout.enterCredentialsCheckout("Adrian", "Marian", 200100);
        checkout.button();
        checkout.verifyMessage("Thank you for your order!");
        checkout.back();
    }
    /**
     * Test method for negative login scenarios using data provider.
     *
     * @param testData The test data for negative login scenarios.
     */
    @Test(dataProvider = "CsvDataProvider",dataProviderClass =  CsvDataProvider.class)
    public void negativeLogInTest(Map<String,String> testData){
        String expectedErrorMessage = "Username and password do not match any user in this service";
        String testNumber = testData.get("no");
        String username = testData.get("username");
        String password = testData.get("password");
        String description = testData.get("description");
        log.info("Test No #" + testNumber + " for " + description + "Where\nUsername: " + username + "\nPassword: " + password);
        LogInPage logInPage = new LogInPage(driver,log);
        logInPage.openLoginPage();
        //Fill up email and password
        logInPage.enterCredentials("standard_user", "secret_sauce");
        //Push Sign In button
        logInPage.pushSignInButton();
        String errorMessage = logInPage.getLogInErrorMessage();
        Assert.assertTrue(errorMessage.contains(expectedErrorMessage),
                "Error message is not expected.Expected: " + expectedErrorMessage + "\nActual: " + errorMessage + ".");

    }
}
