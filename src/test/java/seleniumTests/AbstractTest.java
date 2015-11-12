package seleniumTests;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.log4testng.Logger;
import pages.AbstractPage;

import java.util.concurrent.TimeUnit;

public class AbstractTest {

    private static WebDriver ffdriver;

    private static Logger logger;

    public static WebDriver getWebDriver() {
        return ffdriver;
    }

    public static Logger getLogger() {
        return logger;
    }

    static {
        logger = Logger.getLogger(AbstractTest.class);
        ffdriver = new FirefoxDriver();
        ffdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

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
