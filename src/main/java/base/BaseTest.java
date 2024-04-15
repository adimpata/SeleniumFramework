package base;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.util.logging.Logger;
/**
 * Base class for test classes.
 */
public class BaseTest {
   protected WebDriver driver;
   protected Logger log;
    /**
     * Sets up the class before executing any test methods.
     *
     * @param ctx The context for the test class.
     */
   @BeforeClass
   protected void setUpClass(ITestContext ctx){
       String testName = ctx.getCurrentXmlTest().getName();
       log = Logger.getLogger(testName);
   }
    /**
     * Sets up the environment before executing a test method.
     *
     * @param browser The browser to be used for testing.
     */
    @Parameters({"browser"})
    @BeforeMethod
    public void methodSetUp(@Optional("chrome")String browser) {
        log.info("Method set up");
        driver = Browser.getDriver(browser,log);
    }
    /**
     * Tears down the environment after executing a test method.
     */
    @Parameters({"browser"})
    @AfterMethod
    public void methodTearDown() {
        log.info("Method tear down");
        driver.quit();
    }
}
