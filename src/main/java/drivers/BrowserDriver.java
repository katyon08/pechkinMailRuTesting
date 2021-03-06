package drivers;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

public class BrowserDriver {
    private Browser browser;
    private WebDriver driver;

    public BrowserDriver(WebDriver webDriver, Browser browser) {
        this.browser = browser;
        this.driver = webDriver;
    }

    public void setFullScreen() {
        driver.manage().window().maximize();
    }

    public void setPosition(int x, int y) {
        driver.manage().window().setPosition(new Point(x, y));
    }

    public void moveToLeftScreen() {
        setPosition(-1300, 0);
    }

    public Browser getBrowser() {
        return browser;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
