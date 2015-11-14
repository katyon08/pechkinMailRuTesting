package accounts.DAO;

import accounts.util.Account;
import accounts.util.HibernateUtil;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import loggers.LoggerOperator;

public class AccountDAOImplemention implements AccountDAO {

    private Session session = null;

    @Override
    public void addStudent(Account account) throws SQLException {
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
    public void updateStudent(Account account) throws SQLException {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(account);
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
            account = (Account) session.load(Account.class, username);
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
}