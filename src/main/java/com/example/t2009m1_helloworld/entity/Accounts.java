package com.example.t2009m1_helloworld.entity;

import com.example.t2009m1_helloworld.entity.base.BaseEntity;
import com.example.t2009m1_helloworld.entity.myenum.AccountStatus;

import java.time.LocalDateTime;

public class Accounts extends BaseEntity {
    public static Object AccountBuilder;
    private int id;
    private String username;
    private String email;
    private String password;
    private String confirmPassword;
    private String fullName;

    public Accounts(int id, String username, String email, String password, String confirmPassword, String fullName, int roleId, AccountStatus accountStatus) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.fullName = fullName;
        RoleId = roleId;
        this.accountStatus = accountStatus;
    }

    public Accounts() {
    }

    public Accounts(LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt, int createdBy, int updatedBy, int deletedBy, ProductStatus productStatus) {
        super(createdAt, updatedAt, deletedAt, createdBy, updatedBy, deletedBy, productStatus);
    }

    @Override
    public String getPassword(String s) {
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getRoleId() {
        return RoleId;
    }

    public void setRoleId(int roleId) {
        RoleId = roleId;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    private int RoleId;
    private AccountStatus accountStatus;

    public boolean isValid() {
        return false;
    }
}
