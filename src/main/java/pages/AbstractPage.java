package pages;

import loggers.LoggerOperator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static loggers.LoggerOperator.getLogger;

public abstract class AbstractPage {

    private static WebDriver browserDriver;

    public static WebDriver getFFDriver() {
        return browserDriver;
    }

    public static void setFFDriver(WebDriver browserDriver) {
        AbstractPage.browserDriver = browserDriver;
    }

    public static <T extends AbstractPage> T initPage(Class<T> pageClass) {
        getLogger().debug("Before initializing elements");
        T t = PageFactory.initElements(browserDriver, pageClass);
        getLogger().debug("After initializing elements");
        return t;
    }

}
