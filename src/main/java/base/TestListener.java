package base;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
/**
 * A custom test listener class for handling test execution events.
 */
public class TestListener extends TestListenerAdapter {
    @Override
    public void onTestSuccess(ITestResult tr) {
        super.onTestSuccess(tr);
        System.out.println(tr.getTestContext().getCurrentXmlTest().getName() + " Test Succes");
    }
    @Override
    public void onTestFailure(ITestResult tr) {
        super.onTestFailure(tr);
        System.out.println(tr.getTestContext().getCurrentXmlTest().getName() + " Test Failure");
    }
    @Override
    public void onStart(ITestContext testContext) {
        super.onStart(testContext);
        System.out.println(testContext.getCurrentXmlTest().getName() + " Test Start");
    }
    @Override
    public void onFinish(ITestContext testContext) {
        super.onFinish(testContext);
        System.out.println(testContext.getCurrentXmlTest().getName() + " Test Finish");
    }
}
