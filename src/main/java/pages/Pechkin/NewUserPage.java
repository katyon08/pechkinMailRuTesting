package pages.Pechkin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;

import java.util.List;

public class NewUserPage extends AbstractPage {
    public static final String PATH = "https://web.pechkin-mail.ru/new-user.php";

    private static final String submitButtonXpath = "/html/body/form/div/input";

    private static final String elementsXpath =
            "//input[@id = 'fname']|" +
                    "//input[@id = 'lname']|" +
                    "//input[@id = 'address']|" +
                    "//input[@id = 'city']|" +
                    "//input[@id = 'state-select']|" +
                    "//input[@id = 'zip']";

    @FindBy(xpath = submitButtonXpath)
    private static WebElement submitButton;

    @FindBy(xpath = elementsXpath)
    private static List<WebElement> elements;

    public static List<WebElement> getElements() {
        return elements;
    }

    public static WebElement getSubmitButton() {
        return submitButton;
    }
}
