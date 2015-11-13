package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by katyon08 on 12.11.2015.
 */
public class RegistrationPage extends AbstractPage {

    public final static String PATH = "https://web.pechkin-mail.ru/registration4.php";

    private final static String emailFieldXPath = "//input[@id='email']";

    private final static String passwordFieldXPath = "//input[@id='password']";

    private final static String dogovorCheckboxXPath = "//input[@id='dogovor']";

    private final static String persCheckboxXPath = "//input[@id='pers']";

    private final static String regSubmitButtonXPath = "//input[@id='reg_submit']";


    @FindBy(xpath = emailFieldXPath)
    private WebElement emailField;

    @FindBy(xpath = passwordFieldXPath)
    private WebElement passwordField;

    @FindBy(xpath = dogovorCheckboxXPath)
    private WebElement dogovorCheckbox;

    @FindBy(xpath = persCheckboxXPath)
    private WebElement persCheckbox;

    @FindBy(xpath = regSubmitButtonXPath)
    private WebElement regSubmitButton;

    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getDogovorCheckbox() {
        return dogovorCheckbox;
    }

    public WebElement getPersCheckbox() {
        return persCheckbox;
    }

    public WebElement getRegSubmitButton() {
        return regSubmitButton;
    }

}
