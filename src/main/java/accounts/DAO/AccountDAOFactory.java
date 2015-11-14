package accounts.DAO;

public class AccountDAOFactory {
    private static AccountDAO accountDAO = null;
    private static AccountDAOFactory instance = null;

    public static synchronized AccountDAOFactory getInstance() {
        if (instance == null) {
            instance = new AccountDAOFactory();
        }
        return instance;
    }

    public AccountDAO getAccountDAO() {
        if (accountDAO == null) {
            accountDAO = new AccountDAOImplemention();
        }
        return accountDAO;
    }
}
