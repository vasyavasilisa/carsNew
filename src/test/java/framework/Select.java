package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


/**
 * Created by v.demyanova on 5/15/17.
 */
public class Select extends BaseElement {
    @Override
    public boolean isDisplayed() {
        return false;
    }

    WebElement select;

    public Select(By by) {
        this.select = findElement(by);

    }

    @Override
    public void click() {

        Actions action = new Actions(super.getDriver());
        action.moveToElement(select).build().perform();
        select.click();


    }

    @Override
    public String getText() {
        return select.getText();
    }


    @Override
    public void moveTo() {
        Actions action = new Actions(super.getDriver());
        action.moveToElement(select).build().perform();
    }

    @Override
    public String getAttribute(String str) {
        return null;
    }
}
