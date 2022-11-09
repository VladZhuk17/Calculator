package untils;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
            public void onTestStart (ITestResult iTestResult) {
            System.out.println(String.format("======== STARTING TEST %s ========", iTestResult.getName()));
        }
    }
