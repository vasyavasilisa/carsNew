package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Label extends BaseElement {


    WebElement label;

    public Label() {

    }

    public Label(By by) {
        this.label = findElement(by);
    }

    public Label(WebElement label) {
        this.label = label;
    }


    @Override
    public void click() {
        label.click();
    }

    @Override
    public void moveTo() {
    }

    @Override
    public String getAttribute(String str) {
        return null;
    }

    public static Label findElementByInd(List<Label> elements, int ind) {
        return elements.get(ind);

    }

    public String getText() {
        return label.getText();
    }


    public static List<Label> getConvertedElements(String by) {
        List<WebElement> webElementList = findElements(by);
        List<Label> labelList = new ArrayList<>();
        for (WebElement webel : webElementList) {
            labelList.add(new Label(webel));
        }
        return labelList;
    }

    @Override
    public boolean isDisplayed() {
        return label.isDisplayed();
    }

    public  static boolean isPresent(By by) {
        if (getDriver().findElements(by).size()> 0){
            return true;
        }
        return false;
    }

}
