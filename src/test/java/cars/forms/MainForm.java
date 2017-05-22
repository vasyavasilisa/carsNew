package cars.forms;


import cars.menu.Menu;
import cars.model.Car;
import framework.*;
import framework.services.CommonFunctions;
import org.openqa.selenium.By;

import java.util.List;

/**
 * Created by v.demyanova on 5/19/17.
 */
public class MainForm extends BaseForm {

    private static final String MAKE_LOCATOR = "//div[@class='input-group-xl']//select[@ng-model='selections.make']";
    private static final String CONCRETE_MAKE_LOCATOR = "//div[@class='input-group-xl']//select[@ng-model='selections.make']/option";
    private static final String MODEL_LOCATOR = "//div[@class='input-group-xl']//select[@ng-model='selections.model']";
    private static final String CONCRETE_MODEL_LOCATOR = "//div[@class='input-group-xl']//select[@ng-model='selections.model']/option";
    private static final String YEAR_LOCATOR = "//div[@class='input-group-xl']//select[@ng-model='selections.year']";
    private static final String CONCRETE_YEAR_LOCATOR = "//div[@class='input-group-xl']//select[@ng-model='selections.year']/option";
    private static final String SEARCH_LOCATOR = "//input[@data-linkname='Research']";
    private static final String LOCATOR = "//div[@class='tab-contents']//div[@class='cui-input-group']//input[@type='submit']";

    private Button btnSearch;
    public Menu menu = new Menu();

    public MainForm() {
        super(By.xpath("//div[@class='promo-copy container']"), null);
    }


    public Car clickRandomParameters() {
        BrowserFactory.waitLoadingPage();
       // BrowserFactory.waitExplicide(By.xpath(MAKE_LOCATOR));
        List<Label> llblSelectMake = Label.getConvertedElements(CONCRETE_MAKE_LOCATOR);
        System.out.println(llblSelectMake.size());
        int rand = CommonFunctions.generateRandDigit(llblSelectMake.size());
        System.out.println(rand);
        String locator = CONCRETE_MAKE_LOCATOR + "[" + rand + "]";
        ComboBox cmbMake = new ComboBox(By.xpath(MAKE_LOCATOR), By.xpath(locator));
        cmbMake.dropDownAndClick();
        Car car= new Car();
        car.setMake(cmbMake.getText());
        List<Label> llblSelectModel = Label.getConvertedElements(CONCRETE_MODEL_LOCATOR);
        System.out.println(llblSelectModel.size());
        rand = CommonFunctions.generateRandDigit(llblSelectModel.size());
        System.out.println(rand);
        locator = CONCRETE_MODEL_LOCATOR + "[" + rand + "]";
        ComboBox cmbModel = new ComboBox(By.xpath(MODEL_LOCATOR), By.xpath(locator));
        cmbModel.dropDownAndClick();
        car.setModel(cmbModel.getText());
        List<Label> llblSelectYear = Label.getConvertedElements(CONCRETE_YEAR_LOCATOR);
        System.out.println(llblSelectYear.size());
        rand = CommonFunctions.generateRandDigit(llblSelectYear.size());
        System.out.println(rand);
        locator = CONCRETE_YEAR_LOCATOR + "[" + rand + "]";
        ComboBox cmbYear = new ComboBox(By.xpath(YEAR_LOCATOR), By.xpath(locator));
        cmbYear.dropDownAndClick();
        car.setYear(Integer.valueOf(cmbYear.getText()));
        BrowserFactory.waitForPageToLoad();
        btnSearch =  new Button(By.xpath(SEARCH_LOCATOR));
        btnSearch.submit();
        return car;

    }


}
