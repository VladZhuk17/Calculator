import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.tms.Calculator;
import untils.Retry;

public class DifferenceTest extends BaseTest {

    Calculator calculator = new Calculator();

    @Test(dataProvider = "inputNumberForCalculator", description = "Difference between two numbers",
            retryAnalyzer = Retry.class, priority = 0, invocationCount = 2, threadPoolSize = 2)
    public void verifyDeferenceTest(int num1, int num2) {
        int result = calculator.difference(num1, num2);
        Assert.assertEquals(calculator.difference(num1, num2), result, "Considers incorrect");
    }

    @DataProvider
    public Object[][] inputNumberForCalculator() {
        return new Object[][]{
                {2, 3},
                {8, 4},
        };
    }

    @Test(dataProvider = "inputNegativeNumbersForCalculator", description = "Difference between two negative numbers",
            retryAnalyzer = Retry.class, priority = 2, invocationCount = 2, threadPoolSize = 2)
    public void verifyDeferenceForNegativeNumbersTest(int num1, int num2) {
        int result = calculator.difference(num1, num2);
        Assert.assertEquals(calculator.difference(num1, num2), result, "Considers incorrect");
    }

    @DataProvider
    public Object[][] inputNegativeNumbersForCalculator() {
        return new Object[][]{
                {-2, -33},
                {-21, -14},
        };
    }

    @Test(dataProvider = "inputTreeNumbersForCalculator", description = "Difference between two numbers",
            retryAnalyzer = Retry.class, priority = 3, invocationCount = 2, threadPoolSize = 2)
    public void verifyDeferenceTreeNumbersTest(int num1, int num2, int num3) {
        int result = calculator.difference(calculator.difference(num1, num2), num3);
        Assert.assertEquals(calculator.difference(calculator.difference(num1, num2), num3), result, "Considers incorrect");
    }

    @DataProvider
    public Object[][] inputTreeNumbersForCalculator() {
        return new Object[][]{
                {52, 31, 23},
                {831, 1234, 34},
                {23, 2332, 12}
        };
    }
}
