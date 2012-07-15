package com.twu28;

public class User {
    public String getUserID() {
        return userID;
    }

    public String getNameOfTheUser() {
        return nameOfTheUser;
    }

    String userID;
    String nameOfTheUser;

    public User(String userID, String nameOfTheUser) {
        this.userID = userID;
        this.nameOfTheUser = nameOfTheUser;
    }

}
