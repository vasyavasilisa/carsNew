package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class ComboBox extends BaseElement {
    WebElement cmbDropDown;
    WebElement cmbSelect;

    public ComboBox( By byDropDown,By bySelect) {
        this.cmbDropDown=findElement(byDropDown);
        this.cmbSelect = findElement(bySelect);

    }


    public ComboBox() {
        super();
    }


    public void dropDownAndClick(){
        Actions action = new Actions(super.getDriver());
        action.moveToElement(cmbDropDown).build().perform();
        cmbDropDown.click();
        cmbDropDown.click();
        action.moveToElement(cmbSelect).build().perform();
        cmbSelect.click();

    }

    @Override
    public void click() {
        Actions action = new Actions(super.getDriver());
        action.moveToElement(cmbSelect).build().perform();
        cmbSelect.click();
        cmbSelect.click();
    }

    @Override
    public String getText() {

            return cmbSelect.getText();

    }

    @Override
    public String getAttribute(String str) {
        return null;
    }

    @Override
    public void moveTo() {

    }

    public static List<WebElement> findElements(String by) {
        return findElements(by);
    }

    @Override
    public WebElement findElement(By locator) {
        return super.findElement(locator);
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }
}
