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
                        "\n(X) View all books" +
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

    static int searchISBN(int search) {
        int counter =0;
        for (books i : myBookList) {
            if (i.getISBN()==search) {
                System.out.println(i.getISBN());
                return counter;
            }
            counter++;
        }
        return -1;
    }

    static void allBooks() {
        /*
        for (books i : myBookList) {
            System.out.print("\n");
            System.out.println("ISBN: " + i.getISBN());
            System.out.println("Book name: " + i.getBookName());
            System.out.println("Author: " + i.getAuthorName());
            System.out.println("Genre: " + i.getGenre());
        }
         */
        for (int i = 0; i == myBookList.size(); i++) {
            System.out.println(myBookList.get(i));
        }
    }

    static void a_addBook(){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter ISBN: ");
        int ISBN = input.nextInt();

        System.out.println("Enter book name: ");
        String name = input.next();

        System.out.println("Enter author: ");
        String author = input.next();

        System.out.println("Enter genre: ");
        String genre = input.next();

        books bookName = new books(ISBN, name, author, genre);
        System.out.println(bookName.toString());
    }

    static void b_editBook() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter ISBN: ");
        int index = searchISBN(input.nextInt());

        if (index == -1) {
            System.out.println("Could not find book.");
            return;
        }

        books tempBook = myBookList.get(index);

        System.out.println("Enter new ISBN: ");
        tempBook.setISBN(input.nextInt());
        System.out.println("Enter new book name: ");
        tempBook.setBookName(input.next());
        System.out.println("Enter new author name: ");
        tempBook.setAuthorName(input.next());
        System.out.println("Enter new genre: ");
        tempBook.setGenre(input.next());

        myBookList.set(index, tempBook);

        /*
        System.out.println("Enter the name of which book you would like to edit: ");

        System.out.println("Enter ISBN: ");
        int ISBN = input.nextInt();

        System.out.println("Enter book name: ");
        String name = input.next();

        System.out.println("Enter author: ");
        String author = input.next();

        System.out.println("Enter genre: ");
        String genre = input.next();
         */
    }

    static void c_deleteBook() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter ISBN:");
        int ISBN = input.nextInt();

        for (books i : myBookList) {
            //System.out.println(i.getISBN());
            if (i.getISBN() == ISBN) {
                System.out.println(i.getISBN());
                // make code to make indexes of book to null
            }
        }
    }

    static void _1addBorrow() {
        Scanner input = new Scanner(System.in);
        String borrower = input.next();
        borrowers.add(borrower);
    }

    static void _2editBorrow() {
        Scanner input = new Scanner(System.in);
        /*
        for (books i : borrowers) {
            //System.out.println(i.getISBN());
            System.out.println("Please enter ISBN: ");
            int ISBN = input.nextInt();
            if (i.getISBN() == ISBN) {
                System.out.println(i.getISBN());
                // make code to make indexes of book to null
            }
        }

         */
    }

    static void _3deleteBorrow() {
        Scanner input = new Scanner(System.in);

    }

    private static ArrayList<books> myBookList = new ArrayList<>();

    public static void main(String[] args) {

        ArrayList<String> borrowers = new ArrayList<String>();
        addDefaultBooks();

        //String search = "WW2";
        //for (books i : myBookList) {
        //    if (i.getBookName().equals(search)) {
        //       System.out.println(i.getBookName());
        //    }


        System.out.println("Welcome to the Online Library!");

        String menuChoice = mainMenu();
        if (menuChoice.equals("x")) {
            allBooks();
        }
        else if ( menuChoice.equals("a")) {
            a_addBook();
        }
        else if ( menuChoice.equals("b")) {
            b_editBook();
        }
        else if ( menuChoice.equals("c")) {
            c_deleteBook();
        }
        else if ( menuChoice.equals("1")) {
            _1addBorrow();
        }
        else if ( menuChoice.equals("2")) {
            _2editBorrow();
        }
        else if ( menuChoice.equals("3")) {
            _3deleteBorrow();
        } else {
            System.out.println("Incorrect input. Please enter labeled options.");
        }

        //for (books i : myBookList) {
        //    System.out.println(i.getISBN());
        //}
    }
}
