package pages.Pechkin;

import accounts.util.Account;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;

/**
 * Created by katyon08 on 13.11.2015.
 */
public class LoginPage extends AbstractPage {

    public final static String PATH = "https://web.pechkin-mail.ru/login.php";

    private final static String emailFieldXPath = "//input[@id='username']";

    private final static String passwordFieldXPath = "//input[@id='password']";

    private final static String submitButtonXPath = "//input[@class='button'][@type='submit']";


    @FindBy(xpath = emailFieldXPath)
    private WebElement emailField;

    @FindBy(xpath = passwordFieldXPath)
    private WebElement passwordField;

    @FindBy(xpath = submitButtonXPath)
    private WebElement submitButton;

    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public void loginAs(Account account) {
        emailField.sendKeys(account.getUsername() + Account.domainName);
        passwordField.sendKeys(account.getPassword());
        submitButton.submit();
    }
}
