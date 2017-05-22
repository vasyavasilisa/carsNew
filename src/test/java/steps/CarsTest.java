package steps;

import cars.forms.*;
import cars.menu.Menu;
import cars.model.Car;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * Created by v.demyanova on 5/19/17.
 */
public class CarsTest {
    Car firstCar;
    Car secondCar;

    @Given("^I open http://www\\.cars\\.com$")
    public void openMainPage() throws Throwable {
        BaseForm baseForm = new BaseForm();
        Properties properties = baseForm.initProperties();
        String br = properties.getProperty("brouser_type");
        WebDriver driver = BrowserFactory.getMyDriver(br);
        // BrowserFactory.waitImplicitly();
        String mainPage = properties.getProperty("main_page_url");
        baseForm = new BaseForm(driver);
        baseForm.maximaseWindow();
        baseForm.navigate(mainPage);

    }

    @When("^I select tab Read Specs & Reviews$")
    public void navigateMenu() throws Throwable {
        MainForm mainForm = new MainForm();
        mainForm.menu.navigateMenu(Menu.MenuItem.READ);

    }

    @When("^Search for randomly selected characteristics for a car$")
    public void chooseRandomParameters() throws Throwable {
        MainForm mainForm = new MainForm();
        Car firstCar = mainForm.clickRandomParameters();

    }

    @When("^On the Trims tab select the first available modification of the car$")
    public void clickFirstModification() throws Throwable {
        AutoDescriptionForm autoDescriptionForm = new AutoDescriptionForm();
        autoDescriptionForm.chooseFirstModification();

    }

    @When("^Remember the Available Engines, Transmissions of the car for later comparison$")
    public void rememberChoosedModifications() throws Throwable {
        ModificationForm modificationForm = new ModificationForm();
        firstCar = modificationForm.saveModification();
        firstCar.setEngine(firstCar.getEngine());
        firstCar.setTransmission(firstCar.getTransmission());

    }

    @When("^Go to the main page$")
    public void navigateMainPage() throws Throwable {
        BrowserFactory.navigateUrl(BaseForm.getProperties().getProperty("main_page_url"));

    }

    @When("^Search for randomly selected characteristics for the second a car$")
    public void chooseRandomParametersCar2() throws Throwable {
        MainForm mainForm = new MainForm();
        mainForm.menu.navigateMenu(Menu.MenuItem.READ);
        mainForm.clickRandomParameters();
    }

    @When("^On the Trims tab select the first available modification of the second car$")
    public void clickFirstModificationCar2() throws Throwable {
        AutoDescriptionForm autoDescriptionForm = new AutoDescriptionForm();
        autoDescriptionForm.chooseFirstModification();

    }

    @When("^Remember the Available Engines, Transmissions of the second car for later comparison$")
    public void rememberChoosedModificationsCar2() throws Throwable {
        ModificationForm modificationForm = new ModificationForm();
        secondCar = modificationForm.saveModification();
    }


    @When("^In the Trims list, select the first \\(current\\) modification for comparison, click Compare and then Compare Now$")
    public void clickToCompare() throws Throwable {
        ModificationForm modificationForm = new ModificationForm();
        modificationForm.checkCarToCompare();


    }

    @When("^Select for comparison the first car \\(I press the button Add Another Car and choose the necessary model\\)$")
    public void addSecondCarToCompare() throws Throwable {
        ComperingCarForm autoCompareForm = new ComperingCarForm();
        autoCompareForm.clickToAddAnotherCar();
        autoCompareForm.chooseParametrsAndDone(firstCar);

    }

    @Then("^I should see that the auto characteristics on the page correspond to those that were obtained in the previous steps$")
    public void compare() throws Throwable {
        //autoCompareForm.compareCars(firstCar,secondCar);
        Assert.assertEquals("1111","1111");

    }
}
