package accounts.util;

import accounts.DAO.AccountDAOFactory;
import loggers.LoggerOperator;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;

@Entity
@Table(name = "registered")
public class Account {

    public final int USERNAMELENGTH = 10;

    public final int PASSWORDLENGTH = 10;

    //probability of collision = ( n / (26 ^ USERNAMELENGTH)) ^ (GENERATIONTRYS), where n = amount of already registered accounts;
    public final int GENERATIONTRYS = 10; //probability of collision with 1 registered account with default USERNAMELENGTH=GENERATIONTRYS=10 equals about 3e-142

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "creationtimestamp")
    private Timestamp creationTimeStamp;

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private Integer id;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getCreationTimeStamp() {
        return creationTimeStamp;
    }

    public void setCreationTimeStamp(Timestamp creationTimeStamp) {
        this.creationTimeStamp = creationTimeStamp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "id = " + id + "; username = " + username + "; password = " + password + "; timestamp = " + creationTimeStamp + ";";
    }

    public Account generateRandomAccount() {
        Account account = new Account();
        account.setUsername(randomString(USERNAMELENGTH));
        account.setPassword(randomString(PASSWORDLENGTH));
        account.setCreationTimeStamp(new Timestamp(new Date().getTime()));
        return account;
    }

    public Account generateNewAccount() {
        Account account = null;
        for (int i = 0; i < GENERATIONTRYS; i++) {
            account = generateRandomAccount();
            try {
                if (!AccountDAOFactory.getInstance().getAccountDAO().containsAccount(account)) {
                    break;
                }
            } catch (SQLException e) {
                LoggerOperator.getLogger().error("Could not generate new Account", e);
            }
            account = null;
        }
        return account;
    }

    private String randomString(int length) {
        Random random = new Random();
        String string = "";
        for (int i = 0; i < length; i++) {
            string.concat(
                    Character.toString(
                            (char) random.nextInt(256)));
        }
        return string;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof Account)) return false;
        Account otherAccount = (Account) other;
        if (!(this.id == otherAccount.id)) return false;
        if (!this.username.equals(otherAccount.username)) return false;
        if (!this.password.equals(otherAccount.password)) return false;
        if (!this.creationTimeStamp.equals(otherAccount.creationTimeStamp)) return false;
        return true;

    }
}
