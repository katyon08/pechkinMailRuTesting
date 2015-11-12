package seleniumTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class AbstractTest {

    private static WebDriver ffdriver;

    public static WebDriver getWebDriver() {
        return ffdriver;
    }

    public AbstractTest() {
        if (ffdriver == null) {
            ffdriver = new FirefoxDriver();
            ffdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            ffdriver.manage().window().maximize();
        }
    }

    @BeforeTest
    public void openBrowser() {

    }

}
