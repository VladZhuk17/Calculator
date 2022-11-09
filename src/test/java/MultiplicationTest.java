import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.tms.Calculator;
import untils.Retry;

public class MultiplicationTest {

    private Calculator calculator = new Calculator();

    @Test(dataProvider = "inputMultiplicationNumbersForCalculator", description = "Multiplication between two numbers",
            retryAnalyzer = Retry.class, priority = 3, invocationCount = 2, threadPoolSize = 2)
    public void verifyMultiplicationNumbersTest(int num1, int num2) {
        int result = calculator.multiplication(num1, num2);
        Assert.assertEquals(calculator.multiplication(num1, num2), result, "Considers incorrect");
    }

    @DataProvider
    public Object[][] inputMultiplicationNumbersForCalculator() {
        return new Object[][]{
                {1, 42},
                {1, 14},
        };
    }

    @Test(dataProvider = "inputMultiplicationThreeNumbersForCalculator", description = "Multiplication between two numbers",
            retryAnalyzer = Retry.class, priority = 3, invocationCount = 2, threadPoolSize = 2)
    public void verifyMultiplicationThreeNumbersTest(int num1, int num2, int num3) {
        int result = calculator.multiplication(calculator.multiplication(num1, num2), num3);
        Assert.assertEquals(calculator.multiplication(num1, num2), result, "Considers incorrect");
    }

    @DataProvider
    public Object[][] inputMultiplicationThreeNumbersForCalculator() {
        return new Object[][]{
                {1, 12, 1},
                {1, 54, 1},
                {1, 21, 1}
        };
    }
}
