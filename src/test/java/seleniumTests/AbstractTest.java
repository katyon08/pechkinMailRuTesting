package seleniumTests;

import drivers.*;
import loggers.LoggerOperator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.AbstractPage;

import static loggers.LoggerOperator.getLogger;

public class AbstractTest {

    private final static Browser browserType = Browser.FIREFOX;

    private static BrowserDriver browserDriver;

    public static BrowserDriver getWebDriver() {
        return browserDriver;
    }

    static {
        LoggerOperator.createLogger();
        try {
            browserDriver = BrowserDriverFactory.getDriver(browserType);
        } catch (BrowserNotFoundException e) {
            getLogger().fatal("Could not get driver for " + browserType, e);
        }
    }

    @BeforeTest
    public void initializeAbstractPageDriver() {
        AbstractPage.setBrowserDriver(browserDriver.driver);
    }

    @AfterTest
    public void afterTest() {
        try {
            BrowserDriverCloser.close(browserDriver);
        } catch (BrowserNotFoundException e) {
            getLogger().fatal("Could not close driver for " + browserType, e);
        }
    }


}
