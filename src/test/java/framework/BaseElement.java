package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public abstract class BaseElement extends BaseEntity {

By by;

    WebDriver driver;

    public BaseElement() {

    }

    public abstract void click();

    public abstract String getText();

    public abstract String getAttribute(String str);

    public abstract void moveTo();

    public abstract  boolean isDisplayed();

    public static List<WebElement> findElements(String by) {
        return getDriver().findElements(By.xpath(by));

    }


    public WebElement findElement(By locator) {

        return getDriver().findElement(locator);
    }


}
