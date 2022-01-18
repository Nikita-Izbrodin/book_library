package com.company;

public class borrowers {

    String name;
    String userID;

    public borrowers(String name, String userID) {
        this.name = name;
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "borrowers{" +
                "name='" + name + '\'' +
                ", userID='" + userID + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}