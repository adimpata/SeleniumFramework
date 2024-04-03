package pages;

import base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.logging.Logger;
/**
 * Page object class representing the login page.
 */
public class LogInPage extends BasePageObject<LogInPage> {
    private static final String URL = "https://www.saucedemo.com/";
    private By userName = By.id("user-name");
    private By passwordField = By.id("password");
    private By signInButton = By.id("login-button");
    private By errorMessage = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3");
    public LogInPage(WebDriver driver, Logger log) {
        super(driver,log);
    }
    /**
     * Opens the login page.
     */
    public void openLoginPage() {
        getPage(URL);
    }
    /**
     * Enters credentials in the login fields.
     *
     * @param username The username to enter.
     * @param password The password to enter.
     */
    public void enterCredentials(String username, String password) {
        type(username, userName);
        type(password, passwordField);
    }
    /**
     * Clicks the sign in button.
     *
     * @return An instance of the HomePage if login is successful.
     */
    public HomePage pushSignInButton() {
        log.info("Clicking on Sign In Button");
        click(signInButton);
        return new HomePage(driver,log);
    }
    /**
     * Retrieves the error message displayed on login failure.
     *
     * @return The error message text.
     */
    public String getLogInErrorMessage(){
        waitForVisibilityOf(errorMessage,5);
        return find(errorMessage).getText();
    }
}
