package testng;

import base.BaseTest;
import org.testng.annotations.Test;

public class TestNgTestAnotations extends BaseTest {
    /**
     * This method executes a test case by navigating to the specified URL and prints a success message.
     */
    @Test
    public void testMethod(){
        driver.get("https://www.saucedemo.com/");
        System.out.println("The website is opened. Test passed!");
    }

}
