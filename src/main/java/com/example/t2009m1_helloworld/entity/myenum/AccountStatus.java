package com.example.t2009m1_helloworld.entity.myenum;

public enum AccountStatus {
    ACTIVE(1), DEACTIVE(0),DELETED(-1),UNDIFENED(-2);
    private int value;
    AccountStatus (int value){this.value=value; }
    public int getValue(){
        return value;
    }
    public static AccountStatus of (int value){
        for (AccountStatus accountStatus :
        AccountStatus.values()){
            if (accountStatus.getValue() == value){
                return accountStatus;
            }
        }
        return AccountStatus.UNDIFENED;
    }
}
