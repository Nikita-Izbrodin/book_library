package com.company;

import java.util.Locale;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    static void addDefaultBooks() {
        //int ISBN, String bookName, String authorName, String genre
        books WW2 = new books(7349, "WW2", "Nick", "non-fiction");

        books Castle = new books(7777, "Castle", "Nick#2", "horror");

        myBookList.add(WW2);
        myBookList.add(Castle);
    }

    static String mainMenu() {
        System.out.println(
                        "Would you like to :" +
                        "\n(A) Add a book" +
                        "\n(B) Edit a book" +
                        "\n(C) Delete a book" +
                        "\n" +
                        "\n(1) Add a borrower" +
                        "\n(2) Edit a borrower" +
                        "\n(3) Delete a borrower" +
                        "\n");

        Scanner input = new Scanner(System.in);
        String menuChoiceTemp = input.next().toLowerCase(Locale.ROOT);
        //System.out.println(menuChoiceTemp); //test to see if scanner works
        return menuChoiceTemp;
    }

    static void a_addBook(){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter ISBN: ");
        int ISBN = input.nextInt();

        System.out.println("Enter book name: ");
        String name = input.next();
        String bookName = name;

        System.out.println("Enter author: ");
        String author = input.next();

        System.out.println("Enter genre: ");
        String genre = input.next();

        books bookName = new books(ISBN, name, author, genre);
    }
    static void b_editBook() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the name of which book you would like to edit: ");
        //books bookToEdit = input.next();

        System.out.println("Enter ISBN: ");
        int ISBN = input.nextInt();

        System.out.println("Enter book name: ");
        String name = input.next();
        //String bookName = name;

        System.out.println("Enter author: ");
        String author = input.next();

        System.out.println("Enter genre: ");
        String genre = input.next();

        books bookToEdit = new books(ISBN, name, author, genre);
    }
    static void c_deleteBook() {
        Scanner input = new Scanner(System.in);
        String bookToDel = input.next();
        books bookToDel = null;
    }

    static void _1addBorrow() {
        Scanner input = new Scanner(System.in);

    }

    private static ArrayList<books> myBookList = new ArrayList<>();

    public static void main(String[] args) {

        addDefaultBooks();

        System.out.println("Welcome to the Online Library!");

        String menuChoice = mainMenu();
        if ( menuChoice.equals("a")) {
            a_addBook();
        }
        if ( menuChoice.equals("b")) {
            b_editBook();
        }
        if ( menuChoice.equals("c")) {
            c_deleteBook();
        }
        if ( menuChoice.equals("1")) {
            _1addBorrow();
        }
        if ( menuChoice.equals("2")) {
            //_2editBorrow();
        }
        if ( menuChoice.equals("3")) {
            //_3deleteBorrow();
        } else {
            System.out.println("Incorrect input. Please enter labeled options.");
        }

    }
}
