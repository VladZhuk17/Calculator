import org.testng.annotations.*;
import org.tms.Calculator;

@Listeners
public abstract class BaseTest {

    protected Calculator calculator;

    @BeforeMethod
    public void beforeMethod() {
        Calculator calculator = new Calculator();
        System.out.println("BEFORE METHOD BASE");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("BEFORE METHOD BASE");
    }
}