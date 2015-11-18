package drivers;

import TOR.TOROperator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.concurrent.TimeUnit;

public class BrowserDriverFactory {

    private BrowserDriverFactory() {
    }

    public static BrowserDriver getDriver(Browser browser) throws BrowserNotFoundException, NotImplementedException {
        WebDriver driver;
        if (browser == Browser.FIREFOX) {
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
            return new BrowserDriver(driver, Browser.FIREFOX);
        } else if (browser == Browser.CHROME) {
            throw new NotImplementedException();
        } else if (browser == Browser.OPERA) {
            throw new NotImplementedException();
        } else if (browser == Browser.BUNDLE) {
            driver = TOROperator.startTor();
            return new BrowserDriver(driver, Browser.BUNDLE);
        } else throw new BrowserNotFoundException();
    }
}
