package seleniumTests;

import accounts.DAO.AccountDAOFactory;
import accounts.util.Account;
import loggers.LoggerOperator;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.RegistrationPage;

import java.sql.SQLException;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;


public class RegistrationTesting extends AbstractTest {


    @BeforeTest
    public void before() {
        getWebDriver().navigate().to(RegistrationPage.PATH);
    }

    @Test(suiteName = "Registration test", testName = "Register new account")
    public void registrationTest1() {
        RegistrationPage registrationPage = RegistrationPage.initPage(RegistrationPage.class);
        Account account = Account.generateNewAccount();
        try {
            AccountDAOFactory.getInstance().getAccountDAO().addAccount(account);
        } catch (SQLException e) {
            LoggerOperator.getLogger().error("Could not add new created account to database", e);
        }

    }
}
