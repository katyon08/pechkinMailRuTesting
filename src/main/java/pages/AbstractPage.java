package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

    public static WebDriver ffdriver;

    public static <T extends AbstractPage> T initPage(Class<T> pageClass) {
        return PageFactory.initElements(ffdriver, pageClass);
    }

}
