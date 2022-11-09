import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.tms.Calculator;
import untils.Retry;

public class DivisionTest {

    private Calculator calculator = new Calculator();

    @Test(dataProvider = "inputDivisionNumbersForCalculator", description = "Division between two numbers",
            retryAnalyzer = Retry.class, priority = 3, invocationCount = 2, threadPoolSize = 2)
    public void verifyDivisionNumbersTest(int num1, int num2) {
        int result = calculator.division(num1, num2);
        Assert.assertEquals(calculator.division(num1, num2), result, "Considers incorrect");
    }

    @DataProvider
    public Object[][] inputDivisionNumbersForCalculator() {
        return new Object[][]{
                {2, 2},
                {13, 4},
                {-11, 1}
        };
    }

    @Test(dataProvider = "inputDivisionThreeNumbersForCalculator", description = "Division three numbers",
            retryAnalyzer = Retry.class, priority = 0, invocationCount = 2, threadPoolSize = 2)
    public void verifyDivisionTreeNumbersTest(int num1, int num2, int num3) {
        int result = calculator.division(calculator.division(num1, num2), num3);
        Assert.assertEquals(calculator.division(calculator.division(num1, num2), num3), result, "Considers incorrect");
    }

    @DataProvider
    public Object[][] inputDivisionThreeNumbersForCalculator() {
        return new Object[][]{
                {12, 1, 3},
                {3, 4, 1},
                {-11, 1, -1}
        };
    }
}
