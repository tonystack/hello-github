package com.ata.member.beans;

public class UserAccount {
    private String userName;   
    private String userPassword;
     
  
    public UserAccount() {
         
    }
     
    public String getUserName() {
        return userName;
    }
  
    public void setUserName(String userName) {
        this.userName = userName;
    }
     
    public String getUserPassword() {
        return userPassword;
    }
  
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
