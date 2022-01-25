package com.company;

public class borrowers {

    String name;
    int userID;

    public borrowers(String name, int userID) {
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

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}