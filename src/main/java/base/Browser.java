package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.logging.Logger;
/**
 * A utility class for obtaining WebDriver instances based on the specified browser.
 */
public class Browser {
    /**
     * Returns a WebDriver instance based on the specified browser.
     *
     * @param browser The browser for which to obtain the WebDriver instance. Supported values: "firefox", "chrome".
     * @param log     The logger instance for logging messages.
     * @return The WebDriver instance corresponding to the specified browser.
     */
    public static WebDriver getDriver(String browser, Logger log) {
        WebDriver driver;
        System.out.println("Starting " + browser + " driver");
        switch (browser){
            case "firefox":
                System.getProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case "chrome":
                System.getProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            default:
                System.getProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
        }
        driver.manage().window().maximize();
        return driver;
    }
}
