package accounts.DAO;

import accounts.util.Account;

import java.sql.SQLException;
import java.util.List;

public interface AccountDAO {
    void addAccount(Account account) throws SQLException;

    void updateAccount(Account account) throws SQLException;

    Account getAccountById(int id) throws SQLException;

    Account getAccountByUsername(String username) throws SQLException;

    List getAllAccounts() throws SQLException;

    void deleteAccount(Account account) throws SQLException;

    boolean containsAccount(Account account) throws SQLException;

    boolean stupidContainsAccount(Account account) throws SQLException;
}
