package framework;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public abstract class BaseEntity {

   private static WebDriver driver;

    public BaseEntity() {

    }

    public BaseEntity(WebDriver driver1) {
        driver = driver1;
    }

    public   static WebDriver getDriver() {
        return driver;
    }

    public void assertTrue(boolean isTrue){
        Assert.assertTrue(isTrue);

    }


}
