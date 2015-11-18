package accounts.DAO;

import accounts.util.Account;
import accounts.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import loggers.LoggerOperator;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class AccountDAOImplemention implements AccountDAO {

    volatile private static Session session = null;

    @Override
    public void addAccount(Account account) throws SQLException {
        LoggerOperator.getLogger().info("adding new Account");
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(account);
            session.getTransaction().commit();
        } catch (Exception e) {
            LoggerOperator.getLogger().error("Could not add Account to database", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
            session = null;
        }
    }

    @Override
    public void updateAccount(Account account) throws SQLException {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            Account previous = (Account) session.get(Account.class, account.getId());
            previous.setUsername(account.getUsername());
            previous.setPassword(account.getPassword());
            previous.setCreationTimeStamp(account.getCreationTimeStamp());
            if (account.isAllreadyregistred()) previous.setAllreadyregistred();
            session.update(previous);
            session.getTransaction().commit();
        } catch (Exception e) {
            LoggerOperator.getLogger().error("Could not update Account in database", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
            session = null;
        }
    }

    @Override
    public Account getAccountById(int id) throws SQLException {
        Account account = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            account = (Account) session.load(Account.class, id);
        } catch (Exception e) {
            LoggerOperator.getLogger().error("Could not get Account by id from database", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
            session = null;
        }
        return account;
    }

    @Override
    public Account getAccountByUsername(String username) throws SQLException {
        Account account = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Account.class);
            criteria.add(Restrictions.eq("username", username));
            account = (Account) criteria.uniqueResult();
        } catch (Exception e) {
            LoggerOperator.getLogger().error("Could not get Account by username from database", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
            session = null;
        }
        return account;
    }

    @Override
    public List getAllAccounts() throws SQLException {
        List<Account> accounts = new ArrayList<Account>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            accounts = session.createCriteria(Account.class).list();
        } catch (Exception e) {
            LoggerOperator.getLogger().error("Could not get all list of Accounts from database", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
            session = null;
        }
        return accounts;
    }

    @Override
    public void deleteAccount(Account account) throws SQLException {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(account);
            session.getTransaction().commit();
        } catch (Exception e) {
            LoggerOperator.getLogger().error("Could not delete Account from database", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
            session = null;
        }
    }

    @Override
    public boolean containsAccount(Account account) throws SQLException {
        if (account == null) throw new NullPointerException();
        Account otherAccount;
        if (account.getId() == null) {
            otherAccount = getAccountByUsername((account.getUsername()));
            if (otherAccount == null) return false;
            otherAccount.setId(null);
        } else {
            otherAccount = getAccountById(account.getId());
            if (otherAccount == null) return false;
        }
        return !(account.equals(otherAccount));
    }

    @Override
    public boolean stupidContainsAccount(Account account) throws SQLException {
        if (account == null) throw new NullPointerException();
        ArrayList<Account> otherAccounts = (ArrayList) getAllAccounts();
        boolean containsId = !(account.getId() == null);
        for (Account otherAccount : otherAccounts) {
            if (!containsId) {
                otherAccount.setId(null);
            }
            if (account.equals(otherAccount)) return true;
        }
        return false;
    }

}
