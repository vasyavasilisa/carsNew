package cars.forms;

import framework.BrowserFactory;
import framework.Image;
import org.openqa.selenium.By;

public class AutoDescriptionForm extends BaseForm{
    private static final String MODIFICATION_LOCATOR = "//div[@class='trim_listing'][1]/*/div[@class='trim_listing__image']/img";
    Image imgFirstModif;


    public AutoDescriptionForm() {
    }

    public void chooseFirstModification(){
        BrowserFactory.waitLoadingPage();
        BrowserFactory.waitLoadingPage();
        imgFirstModif = new Image(By.xpath(MODIFICATION_LOCATOR));
        imgFirstModif.click();
    }
}
