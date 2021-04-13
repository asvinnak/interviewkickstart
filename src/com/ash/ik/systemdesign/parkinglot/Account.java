package com.ash.ik.systemdesign.parkinglot;

import com.ash.ik.systemdesign.parkinglot.enums.AccountStatus;
import com.ash.ik.systemdesign.parkinglot.model.Person;


public abstract class Account {
    private String userName;
    private String password;
    private AccountStatus status;
    private Person person;

     public boolean resetPassword() {
        return true;
     }
}
