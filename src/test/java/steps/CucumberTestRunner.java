package steps;

/**
 * Created by v.demyanova on 5/22/17.
 */
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

//@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features/cars.feature")
public class CucumberTestRunner extends AbstractTestNGCucumberTests {
}
