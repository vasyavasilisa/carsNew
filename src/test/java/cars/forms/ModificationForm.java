package cars.forms;

import cars.model.Car;
import framework.BrowserFactory;
import framework.Button;
import framework.CheckBox;
import framework.Label;
import org.openqa.selenium.By;

/**
 * Created by USER on 21.05.2017.
 */
public class ModificationForm extends BaseForm{
    //private static final String ENGINE_LOCATOR = "//td[@id='engine']";
    // private static final String TRANSMISSION_LOCATOR = "//td[@id='transmission']";
    private static final String CHECKBOX_LOCATOR = "//div[@class='trim_listing__footer']//div//div[@class='checkbox']";
            //"//div[@class='trim_listing'][1]//label[@id='checkbox-trim-']";
    private static final String BUTTON_LOCATOR = "//button[@class='cui-button']";
    private Label lblEngine = new Label(By.xpath("//td[@id='engine']"));
    private Label lblTransmision = new Label(By.xpath("//td[@id='transmission']"));
    private CheckBox ckbCompare;
    private Button btnCompareNow;

    public ModificationForm() {

    }

    public Car saveModification() {
        BrowserFactory.waitForPageToLoad();
        //lblEngine = new Label(By.xpath(ENGINE_LOCATOR));
        // lblTransmision = new Label(By.xpath(TRANSMISSION_LOCATOR));
        Car car = new Car(lblEngine.getText(), lblTransmision.getText());
        System.out.println(car.toString());
        return car;
    }

    public void checkCarToCompare() {
        ckbCompare = new CheckBox(By.xpath(CHECKBOX_LOCATOR));
        ckbCompare.check();
        BrowserFactory.waitLoadingPage();
       btnCompareNow = new Button(By.xpath(BUTTON_LOCATOR));
       btnCompareNow.click();
        BrowserFactory.waitLoadingPage();

    }
}
