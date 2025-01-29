package Service;

import DAO.AccountDAO;
import Model.Account;

import java.util.List;

public class AccountService {
    public AccountDAO accountDAO;

    public AccountService(){
        accountDAO = new AccountDAO();
    }

    public AccountService(AccountDAO accountDAO){
        this.accountDAO = accountDAO;
    }

    public Account addAccount(Account account){
        if(accountDAO.getAccount(account.getUsername()) != null || account.getPassword().length() < 4 || account.getUsername().equals("")){
            System.out.println("Account service returning null");
            return null;
        }else{
            return accountDAO.createAccount(account);
        }
    }

    public Account getAccount(String username, String password){
        return accountDAO.getAccount(username, password);
    }
}
