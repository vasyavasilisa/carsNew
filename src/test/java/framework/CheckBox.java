package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class CheckBox extends BaseElement {
    WebElement checkBox;
    public CheckBox() {
        super();
    }

    public CheckBox(By by) {
        this.checkBox = findElement(by);

    }

    @Override
    public void click() {

    }

    @Override
    public String getText() {
        return null;
    }

    @Override
    public String getAttribute(String str) {
        return null;
    }

    @Override
    public void moveTo() {

    }

    @Override
    public boolean isDisplayed() {
        return false;
    }

    @Override
    public WebElement findElement(By locator) {
        return super.findElement(locator);
    }

    public void check(){
        checkBox.click();

    }
}
