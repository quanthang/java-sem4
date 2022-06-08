package com.example.t2009m1_helloworld.service;

import com.example.t2009m1_helloworld.Model.AccountModel;
import com.example.t2009m1_helloworld.entity.Accounts;
import com.example.t2009m1_helloworld.util.SHA512Hasher;

public class AccountService {
    private AccountModel accountModel;
    public AccountService(){
        this.accountModel= new MySqlAccountModel();
    }
    public Accounts register(Accounts accounts){
        String salt = SHA512Hasher.randomString(7);
        String passwordHash = SHA512Hasher.encode(accounts.getPassword(), salt);
        accounts.getPassword(passwordHash + "." + salt);
        AccountModel.save(accounts);
        return accounts;
    }
    public Accounts login(String username, String password){
        Accounts accounts = AccountModel.findByUsername(username);
        if (accounts !=null && SHA512Hasher.checkPassword(accounts.getPassword(), password)){
            return accounts;
        }
        return null;
    }
}
