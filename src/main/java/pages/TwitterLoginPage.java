package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.FindsByXPath;
import org.openqa.selenium.support.FindBy;

public class TwitterLoginPage extends AbstractPage {

    public static final String PATH = "https://twitter.com/";

    private static final String loginPath = "(//input[@id='signin-email'])[2]";

    private static final String passwordPath = "(//input[@id='signin-password'])[2]";

    private static final String submitPath = "//button[@type='submit']";

    //    @FindBy(xpath = loginPath)
    private static WebElement login;

    @FindBy(xpath = passwordPath)
    private static WebElement password;

    @FindBy(xpath = submitPath)
    private static WebElement submit;

    static {
        login = (WebElement) By.xpath(loginPath);
    }

    public static WebElement getLogin() {
        return login;
    }

    public static WebElement getPassword() {
        return password;
    }

    public static WebElement getSubmit() {
        return submit;
    }
}
