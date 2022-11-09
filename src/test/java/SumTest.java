import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.tms.Calculator;
import untils.Retry;

public class SumTest {

    private Calculator calculator = new Calculator();

    @Test(dataProvider = "inputSumNumberForCalculator", description = "Sum between two numbers",
            retryAnalyzer = Retry.class, priority = 0, invocationCount = 2, threadPoolSize = 2)
    public void verifySumTest(int num1, int num2) {
        int result = calculator.sum(num1, num2);
        Assert.assertEquals(calculator.sum(num1, num2), result, "Considers incorrect");
    }

    @DataProvider
    public Object[][] inputSumNumberForCalculator() {
        return new Object[][]{
                {232, 323},
                {4813, 44},
                {12, 0}
        };
    }

    @Test(dataProvider = "inputSumNegativeNumbersForCalculator", description = "Sum between two numbers",
            retryAnalyzer = Retry.class, priority = 2, invocationCount = 2, threadPoolSize = 2)
    public void verifySumNegativeNumbersTest(int num1, int num2) {
                int result = calculator.sum(num1, num2);
        Assert.assertEquals(calculator.sum(num1, num2), result, "Considers incorrect");
    }

    @DataProvider
    public Object[][] inputSumNegativeNumbersForCalculator() {
        return new Object[][]{
                {-22, -3},
                {-23, -9},
                {-1, 0}
        };
    }

    @Test(dataProvider = "inputSumNumbersForCalculator", description = "Sum between two numbers",
            retryAnalyzer = Retry.class, priority = 3, invocationCount = 2, threadPoolSize = 2)
    public void verifySumDifferentNumbersTest(int num1, int num2) {
                int result = calculator.sum(num1, num2);
        Assert.assertEquals(calculator.sum(num1, num2), result, "Considers incorrect");
    }

    @DataProvider
    public Object[][] inputSumNumbersForCalculator() {
        return new Object[][]{
                {-22, 0},
                {23, -2},
                {-1, 10}
        };
    }
}
