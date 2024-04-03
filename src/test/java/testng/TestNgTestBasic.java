package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
/**
 * A basic TestNG test class demonstrating a simple test method.
 */
public class TestNgTestBasic {
    /**
     * Test method to open a website using WebDriver.
     * This method opens the website "https://ultimateqa.com/automation" and prints a success message.
     * It then quits the WebDriver instance.
     */
    @Test
    public void testMethod() {
        // Set the system property for GeckoDriver
        System.getProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        // Initialize FirefoxDriver
        WebDriver driver = new FirefoxDriver();
        // Open website
        driver.get("https://ultimateqa.com/automation");
        System.out.println("Website opened.Test passed!");
        // Quit WebDriver
        driver.quit();

    }
}
