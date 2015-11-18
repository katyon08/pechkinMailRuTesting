package seleniumTests;

//import TOR.TORDriver;

import loggers.LoggerOperator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.AbstractPage;

import java.util.concurrent.TimeUnit;

public class AbstractTest {

    private static WebDriver browserDriver;

    public static WebDriver getWebDriver() {
        return browserDriver;
    }

    static {
        LoggerOperator.createLogger();
        browserDriver = new FirefoxDriver();
//        browserDriver = TOROperator.startTor();
        browserDriver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
//        uncomment the next line to set fullscreen mode!
//        browserDriver.manage().window().maximize();
//        uncomment the next line to move the window to the left screen!
//        browserDriver.manage().window().setPosition(new Point(-1500, 0));
    }

    @BeforeTest
    public void initializeAbstractPageDriver() {
        AbstractPage.setFFDriver(browserDriver);
    }

    @AfterTest
    public void afterTest() {
//        TOROperator.killFirefox();
        browserDriver.quit();// close();
    }


}
