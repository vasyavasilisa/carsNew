package cars.forms;

import framework.BaseEntity;
import framework.BrowserFactory;
import framework.Label;
import framework.services.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

/**
 * Created by v.demyanova on 5/19/17.
 */
public class BaseForm extends BaseEntity{


    private static final String MAIN_PROPERTY_PATH = "brouser.properties";
    private static Properties properties;
    private By titleLocator;
    private String title;

    public BaseForm() {
    }


    public BaseForm(By titleLocator, String title) {
        init(titleLocator, title);
        assertIsOpen();
    }

    public BaseForm(WebDriver driver) {
        super(driver);
    }

    public void maximaseWindow() {
        BrowserFactory.maximaseWindow();
    }

    public void navigate(String url) {
        BrowserFactory.navigateUrl(url);
    }


    public void exit() {
        BrowserFactory.exit();
    }


    public Properties initProperties() {
        CommonFunctions commonFunctions = new CommonFunctions();
        properties = commonFunctions.readProperties(MAIN_PROPERTY_PATH);
        return properties;
    }


    public static Properties getProperties() {
        return properties;
    }

    /*public static Properties getTextlocatorProperties() {
        return textlocatorProperties;
    }*/

   /* public static void setTextlocatorProperties(Properties textlocatorProperties) {
        BaseForm.textlocatorProperties = textlocatorProperties;
    }*/


    public void init(By titleLocator, String title) {
        if (title != null) {
            this.title = CommonFunctions.convertToUTF8(title);
            this.titleLocator = By.xpath(String.format(titleLocator.toString().split(" ")[1], this.title));
        } else {
            this.titleLocator = titleLocator;
        }
    }

    public void assertIsOpen() {
        assertTrue(Label.isPresent(titleLocator));
    }
}
