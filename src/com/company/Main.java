package com.company;

import java.util.ArrayList;

public class Main {

    private static ArrayList<books> myBookList = new ArrayList<>();

    public static void main(String[] args) {
	// write your code here
    }

    //int ISBN, String bookName, String authorName, String genre
    books WW2 = new books(7349, "WW2", "Nick", "non-fiction");

    books Castle = new books(7777, "Castle", "Nick#2", "horror");

    myBookList.add(WW2);
    myBookList.add(Castle);
}
