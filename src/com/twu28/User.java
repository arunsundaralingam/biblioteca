package com.twu28;

public class User {
    String userID;
    String password;

    public String getUserID() {
        return userID;
    }

    public String getPassword() {
        return password;
    }

    public User(String userID , String password){
        this.userID = userID;
        this.password = password;
    }
    public String toString(){
        return userID;
    }
}
