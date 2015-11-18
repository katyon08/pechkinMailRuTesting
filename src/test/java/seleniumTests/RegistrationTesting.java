package seleniumTests;

import accounts.DAO.AccountDAOFactory;
import accounts.util.Account;
import loggers.LoggerOperator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Pechkin.NewUserPage;
import pages.Pechkin.RegistrationPage;
import pages.YOPmail.YOPMailMainPage;
import java.sql.SQLException;

import static org.testng.Assert.assertTrue;

public class RegistrationTesting extends AbstractTest {

    private static final String headerTitle = "Рабочий стол | Pechkin-mail.ru";

    private static final String logginedAsXpath = "/html/body/div[2]/div[2]/ul[2]/li/a";

    @BeforeTest
    public void before() {
        goToPage(RegistrationPage.PATH);
    }

    @Test(suiteName = "Registration test", testName = "Register new account")
    public void registrationTest1() {
        RegistrationPage registrationPage = RegistrationPage.initPage(RegistrationPage.class);
        Account account = Account.generateNewAccount();
        try {
            AccountDAOFactory.
                    getInstance().
                    getAccountDAO().
                    addAccount(account);
        } catch (SQLException e) {
            LoggerOperator.getLogger().error("Could not add new created account to database", e);
        }
        typeRegistrationInformation(registrationPage, account);
        registrationPage.getRegSubmitButton().click();
        confirmThrowYOPEmail(account.getUsername());
        addNewUser(account.getUsername());
        assertTrue(
                (getWebDriver().
                        getDriver().
                        getTitle().
                        equals(headerTitle)
                ) && (getWebDriver().
                        getDriver().
                        findElement(By.
                                xpath(logginedAsXpath)).
                        getText().
                        equals(
                                account.getUsername() + "@yopmail.com▼"
                        )));
    }

    private void typeRegistrationInformation(RegistrationPage registrationPage, Account account) {

        registrationPage.getEmailField().sendKeys(account.getUsername() + "@yopmail.com");
        registrationPage.getPasswordField().sendKeys(account.getPassword());
        registrationPage.getPersCheckbox().click();
        registrationPage.getDogovorCheckbox().click();
    }

    private void confirmThrowYOPEmail(String address) {
        YOPMailMainPage yopMailMainPage = YOPMailMainPage.initPage(YOPMailMainPage.class);
        goToPage(YOPMailMainPage.PATH);
        YOPMailMainPage.getAddress().sendKeys(address);
        YOPMailMainPage.getSubmitButton().submit();
        YOPMailMainPage.initialLastEmail();
        YOPMailMainPage.accessConfirmation();
//        updateDatabaseAccountAsAllreadyRegistred(address);
    }

    private void updateDatabaseAccountAsAllreadyRegistred(String address) {
        try {
            Account account = AccountDAOFactory.
                    getInstance().
                    getAccountDAO().
                    getAccountByUsername(address);
            account.setAllreadyregistred();
            AccountDAOFactory.
                    getInstance().
                    getAccountDAO().
                    updateAccount(account);
        } catch (SQLException e) {
            LoggerOperator.getLogger().fatal(
                    "Could not mark account with address ='" + address + "' in database.", e);
        }
    }

    private void addNewUser(String key) {
        NewUserPage newUserPage = NewUserPage.initPage(NewUserPage.class);
        goToPage(NewUserPage.PATH);
        for (WebElement element : NewUserPage.getElements()) {
            element.sendKeys(key);
        }
        NewUserPage.getSubmitButton().submit();
    }
}
