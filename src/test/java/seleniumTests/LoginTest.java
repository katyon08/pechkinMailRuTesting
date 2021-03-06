package seleniumTests;

import accounts.DAO.AccountDAOFactory;
import accounts.util.Account;
import loggers.LoggerOperator;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Pechkin.LoginPage;
import java.sql.SQLException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class LoginTest extends AbstractTest {

    private static final String headerTitle = "Рабочий стол | Pechkin-mail.ru";

    private static final String logginedAsXpath = "/html/body/div[2]/div[2]/ul[2]/li/a";

    private static final String loginErrorXpath = "/html/body/div/div[1]/div[5]/div[2]/div[2]/ul/li";

    private static final String loginErrorTextValue = "Неверный логин и/или пароль.";

    private static final String loginErrorHeaderTitleValue = "Логин | Pechkin-mail.ru";

    @BeforeTest
    public void beforeTest() {
        goToPage(LoginPage.PATH);
    }

    @Test(suiteName = "Login page testing", testName = "try login with registered account")
    public void loginTest1() {
        LoginPage loginPage = LoginPage.initPage(LoginPage.class);
        Account account = getLastRegisteredAccount();
        goToPage(LoginPage.PATH);
        loginPage.loginAs(account);
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
                                account.getUsername() + Account.domainName + "▼"
                        )));
    }

    @Test(suiteName = "Login page testing", testName = "try login with unregistered account")
    public void loginTest2() {
        LoginPage loginPage = LoginPage.initPage(LoginPage.class);
        goToPage(LoginPage.PATH);
        Account account = Account.generateNewAccount();
        loginPage.loginAs(account);
        assertTrue(
                (getWebDriver().
                        getDriver().
                        getTitle().
                        equals(loginErrorHeaderTitleValue)
                ) && (getWebDriver().
                        getDriver().
                        findElement(By.
                                xpath(loginErrorXpath)).
                        getText().
                        equals(loginErrorTextValue)));
    }

    private Account getLastRegisteredAccount() {
        List<Account> accounts = null;
        try {
            accounts = AccountDAOFactory.
                    getInstance().
                    getAccountDAO().
                    getAllAccounts();
        } catch (SQLException e) {
            LoggerOperator.getLogger().error("Could not add new created account to database", e);
        }
        return accounts.isEmpty() ?
                null :
                accounts.get(accounts.size() - 1);
    }

}
