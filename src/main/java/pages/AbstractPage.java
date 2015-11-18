package pages;

import drivers.BrowserDriver;
import loggers.LoggerOperator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static loggers.LoggerOperator.getLogger;

public abstract class AbstractPage {

    private static BrowserDriver browserDriver;

    public static BrowserDriver getBrowserDriver() {
        return browserDriver;
    }

    public static void setBrowserDriver(BrowserDriver browserDriver) {
        AbstractPage.browserDriver = browserDriver;
    }

    public static <T extends AbstractPage> T initPage(Class<T> pageClass) {
        getLogger().debug("Before initializing elements");
        T t = PageFactory.initElements(browserDriver.getDriver(), pageClass);
        getLogger().debug("After initializing elements");
        return t;
    }

}
