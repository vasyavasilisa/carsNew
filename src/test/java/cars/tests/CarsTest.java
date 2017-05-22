package cars.tests;

import cars.forms.*;
import cars.menu.Menu;
import cars.model.Car;
import framework.BrowserFactory;
import org.testng.Assert;

import java.io.UnsupportedEncodingException;

/**
 * Created by v.demyanova on 5/19/17.
 */
public class CarsTest {

    public void runTest() throws UnsupportedEncodingException {
        MainForm mainForm = new MainForm();
        mainForm.menu.navigateMenu(Menu.MenuItem.READ);
        Car firstCar = mainForm.clickRandomParameters();
        AutoDescriptionForm autoDescriptionForm = new AutoDescriptionForm();
        autoDescriptionForm.chooseFirstModification();
        ModificationForm modificationForm = new ModificationForm();
        Car car = modificationForm.saveModification();
        firstCar.setEngine(car.getEngine());
        firstCar.setTransmission(car.getTransmission());
        BrowserFactory.navigateUrl(BaseForm.getProperties().getProperty("main_page_url"));
        mainForm = new MainForm();
        mainForm.menu.navigateMenu(Menu.MenuItem.READ);
        mainForm.clickRandomParameters();
        autoDescriptionForm = new AutoDescriptionForm();
        autoDescriptionForm.chooseFirstModification();
        modificationForm = new ModificationForm();
        Car secondCar = modificationForm.saveModification();
        modificationForm.checkCarToCompare();
        ComperingCarForm autoCompareForm = new ComperingCarForm();
        autoCompareForm.clickToAddAnotherCar();
        autoCompareForm.chooseParametrsAndDone(firstCar);
        autoCompareForm.compareCars(firstCar,secondCar);
        Assert.assertEquals("1111","1111");


    }
}
