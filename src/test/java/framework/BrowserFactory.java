package framework;

import framework.services.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static java.time.zone.ZoneRulesProvider.refresh;


public abstract class BrowserFactory {

    private static final String MAIN_PROPERTY_PATH="brouser.properties";
    private static WebDriver driver;
    private static Properties properties;
    static  Long started;

public static WebDriver getMyDriver(String type){
    switch (type) {
        case "chrome": {
            driver=ChromeFactory.getInstance();
            initProperties();
            return driver;
        }
        case "firefox": {
            driver=FirefoxFactory.getInstance();
            initProperties();
            return driver;
        }
    }
    throw new RuntimeException();
}


public static void initProperties(){
    CommonFunctions commonFunctions = new CommonFunctions();
    properties = commonFunctions.readProperties(MAIN_PROPERTY_PATH);
}

    public static void waitForPageToLoad(){
        WebDriverWait wait1 = new WebDriverWait(driver, getTimeForLoadPage());
        try {
            wait1.until(new ExpectedCondition<Boolean>() {
                public Boolean apply(final WebDriver d) {
                    if (!(d instanceof JavascriptExecutor)) {
                        return true;
                    }
                    Object result = ((JavascriptExecutor) d).executeScript("return document['readyState'] ? 'complete' == document.readyState : true");
                    if (result != null && result instanceof Boolean && (Boolean) result) {
                        long now = System.currentTimeMillis();
                        if (now - started > getTimeForLoadPage()) {
                            return true;
                        }else {
                            started = System.currentTimeMillis();
                        }
                    }
                    return false;
                }
            });
        } catch (Exception e) {
            refresh();
        }
    }

public static void waitLoadingPage(){
    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}

  /*  public static void waitImplicitly(){
        driver.manage().timeouts().pageLoadTimeout(getTimeForLoadElement(), TimeUnit.SECONDS);
    }*/


    public static void waitVisible(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public static void waitExplicide(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

       public static void maximaseWindow(){
        driver.manage().window().maximize();

    }

    public static void navigateUrl(String url){
        driver.navigate().to(url);

    }

    public static Long getTimeForLoadPage(){
        return Long.parseLong(properties.getProperty("timeoutJs"));

    }

    public static Long getTimeForLoadElement(){
        return Long.parseLong(properties.getProperty("timeout"));

    }

    public static void exit(){
        driver.close();
    }

}
