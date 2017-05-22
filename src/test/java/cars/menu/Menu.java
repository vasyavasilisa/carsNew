package cars.menu;

import framework.BrowserFactory;
import framework.Select;
import org.openqa.selenium.By;

/**
 * Created by v.demyanova on 5/19/17.
 */
public class Menu {

    private static final String tabsLocator = "//span[@class='at-least-desktop-inline' and contains(text(),'%s')]";


    public enum MenuItem{
        SEARCH("Search Cars for Sale"),
        READ("Read Specs & Reviews"),
        FIND("Find Service Centers & Dealers");

        private String name;

        MenuItem(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public Menu() {
    }

    public void navigateMenu(MenuItem concreteItem){
        BrowserFactory.waitLoadingPage();
        new Select(By.xpath(String.format( tabsLocator,concreteItem.getName()))).click();
    }
}
