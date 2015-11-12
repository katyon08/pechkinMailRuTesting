package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

    private static WebDriver fFDriver;

    public static WebDriver getFFDriver() {
        return fFDriver;
    }

    public static void setFFDriver(WebDriver fFDriver) {
        AbstractPage.fFDriver = fFDriver;
    }

    public static <T extends AbstractPage> T initPage(Class<T> pageClass) {
        return PageFactory.initElements(fFDriver, pageClass);
    }

}
