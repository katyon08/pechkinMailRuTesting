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

    private static WebDriver ffdriver;

    public static WebDriver getWebDriver() {
        return ffdriver;
    }

    static {
        LoggerOperator.createLogger();
        ffdriver = new FirefoxDriver();
//        ffdriver = TORDriver.tryIt();
        ffdriver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        //uncomment the next line to set fullscreen mode!
        //ffdriver.manage().window().maximize();
        //uncomment the next line to move the window to the left screen!
        //ffdriver.manage().window().setPosition(new Point(-1500, 0));
    }

    @BeforeTest
    public void initializeAbstractPageDriver() {
        AbstractPage.setFFDriver(ffdriver);
    }

    @AfterTest
    public void afterTest() {

        ffdriver.close();
    }


}
