package cars.tests;

import cars.forms.BaseForm;
import framework.BaseEntity;
import framework.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.io.UnsupportedEncodingException;
import java.util.Properties;


public class BaseTest extends BaseEntity {
    BaseForm baseForm;
    Properties properties;
    WebDriver driver;
    CarsTest carsTest;

    public BaseTest() {
    }


    @BeforeTest
    public void setUp() {
        baseForm = new BaseForm();
        properties = baseForm.initProperties();
        String br = properties.getProperty("brouser_type");
        driver = BrowserFactory.getMyDriver(br);
       // BrowserFactory.waitImplicitly();
        String mainPage = properties.getProperty("main_page_url");
        carsTest = new CarsTest();
        baseForm = new BaseForm(driver);
        baseForm.maximaseWindow();
        baseForm.navigate(mainPage);
    }


    @Test
    public void xTest() throws UnsupportedEncodingException {
        carsTest.runTest();
    }

  /*  @AfterTest
    public void exit() {
        baseForm.exit();
    }*/
}
