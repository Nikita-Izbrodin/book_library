package com.company;

import java.util.Locale;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    static void addDefaultBooks() {
        //int ISBN, String bookName, String authorName, String genre
        books WW2 = new books(7349, "WW2", "Nick", "non-fiction");

        books Castle = new books(7777, "Castle", "Nick#2", "horror");

        bookList.add(WW2);
        bookList.add(Castle);
    }

    static String mainMenu() {
        System.out.println(
                        "Would you like to :" +
                        "\n(X) View all books" +
                        "\n(A) Add a book" +
                        "\n(B) Edit a book" +
                        "\n(C) Delete a book" +
                        "\n" +
                        "\n(Q) View all borrowers" +
                        "\n(1) Add a borrower" +
                        "\n(2) Edit a borrower" +
                        "\n(3) Delete a borrower" +
                        "\n(W) Exit" +
                        "\n");

        Scanner input = new Scanner(System.in);
        String menuChoiceTemp = input.next().toLowerCase(Locale.ROOT);
        //System.out.println(menuChoiceTemp); //test to see if scanner works
        return menuChoiceTemp;
    }

    static int searchISBN(int search) {
        int counter =0;
        for (books i : bookList) {
            if (i.getISBN()==search) {
                System.out.println(i.getISBN());
                return counter;
            }
            counter++;
        }
        return -1;
    }

    static int searchID(int search) {
        int counter =0;
        for (borrowers i : borrowersList) {
            if (i.getUserID()==search) {
                System.out.println(i.getUserID());
                return counter;
            }
            counter++;
        }
        return -1;
    }

    static void allBooks() throws InterruptedException {
        for (int i = 0; i < bookList.size(); i++) {
            System.out.println(bookList.get(i));
        }
        System.out.println();
        Thread.sleep(2000);
    }

    static void a_addBook() throws InterruptedException {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter ISBN: ");
        try {
            int ISBN = input.nextInt();

            System.out.println("Enter book name: ");
            String name = input.next();

            System.out.println("Enter author: ");
            String author = input.next();

            System.out.println("Enter genre: ");
            String genre = input.next();

            books bookName = new books(ISBN, name, author, genre);
            bookList.add(bookName);
            System.out.println(bookName.toString() + "\n");
            Thread.sleep(2000);
        }
        catch(Exception e) {
            System.out.println("Invalid input. Please enter a number.");
            Thread.sleep(2000);
        }
    }

    static void b_editBook() throws InterruptedException {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter ISBN: ");
        try {
            int index = searchISBN(input.nextInt());

            System.out.println("Book found.");

            if (index == -1) {
                System.out.println("Could not find book.\n");
                Thread.sleep(2000);
                return;
            }

            books tempBook = bookList.get(index);

            System.out.println("Enter new ISBN: ");
            tempBook.setISBN(input.nextInt());
            System.out.println("Enter new book name: ");
            tempBook.setBookName(input.next());
            System.out.println("Enter new author name: ");
            tempBook.setAuthorName(input.next());
            System.out.println("Enter new genre: ");
            tempBook.setGenre(input.next());

            bookList.set(index, tempBook);
            System.out.println("Book edited.\n");
            Thread.sleep(2000);

        }
        catch(Exception e){
            System.out.println("Invalid input. Please enter numbers.");
            Thread.sleep(2000);
        }
    }

    static void c_deleteBook() throws InterruptedException {
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("Enter ISBN:");
            int ISBN = input.nextInt();

            for (books i : bookList) {
                if (i.getISBN() == ISBN) {
                    bookList.remove(i);
                    System.out.println("Book removed successfully.");
                    Thread.sleep(2000);
                }
            }
        }
        catch(Exception e) {
            System.out.println("Invalid input. Please enter a number.");
            Thread.sleep(2000);
        }
    }


    static void allBorrowers() throws InterruptedException {
        for (int i = 0; i < borrowersList.size(); i++) {
            System.out.println(borrowersList.get(i));
        }
        System.out.println();
        Thread.sleep(2000);
    }

    static void _1addBorrow() throws InterruptedException {
        Scanner input = new Scanner(System.in);

        try {
            System.out.println("Enter name: ");
            String name = input.next();

            Random rand = new Random();
            int userID = rand.nextInt(10000);
            System.out.println(userID);

            borrowers borrower = new borrowers(name, userID);
            borrowersList.add(borrower);
            System.out.println("Borrower added.");
            System.out.println(borrower.toString());
            Thread.sleep(2000);
        }
        catch(Exception e){
            System.out.println("Invalid input.");
        }
    }

    static void _2editBorrow() throws InterruptedException {
        try{
            Scanner input = new Scanner(System.in);
            System.out.println("Please enter User ID: ");
            int index = searchID(input.nextInt());
            System.out.println("User found.");

            if (index == -1) {
                System.out.println("Could not find user.\n");
                Thread.sleep(2000);
                return;
            }

            borrowers tempBorrower = borrowersList.get(index);

            System.out.println("Enter new User ID: ");
            tempBorrower.setUserID(input.nextInt());
            System.out.println("Enter new name: ");
            tempBorrower.setName(input.next());

            borrowersList.set(index, tempBorrower);
            System.out.println("User edit successful.\n");
            Thread.sleep(2000);
        }
        catch(Exception e){
            System.out.println("Invalid input.");
        }
    }

    static void _3deleteBorrow() throws InterruptedException {
        try{
            Scanner input = new Scanner(System.in);

            System.out.println("Enter user ID:");
            int userID = input.nextInt();

            for (borrowers i : borrowersList) {
                if (i.getUserID() == userID) {
                    borrowersList.remove(i);
                    System.out.println("User removed successfully.");
                    Thread.sleep(2000);
                    return;
                }
            }
        }
        catch(Exception e){
            System.out.println("Invalid input.");
        }
    }

    private static ArrayList<books> bookList = new ArrayList<>();
    private static ArrayList<borrowers> borrowersList = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {

        addDefaultBooks();

        ArrayList<String> borrowers = new ArrayList<String>();

        System.out.println("Welcome to the Online Library!");

        boolean run = true;

        while (run == true) {
            String menuChoice = mainMenu();
            if (menuChoice.equals("x")) {
                allBooks();
            } else if (menuChoice.equals("a")) {
                a_addBook();
            } else if (menuChoice.equals("b")) {
                b_editBook();
            } else if (menuChoice.equals("c")) {
                c_deleteBook();
            } else if (menuChoice.equals("q")) {
                allBorrowers();
            } else if (menuChoice.equals("1")) {
                _1addBorrow();
            } else if (menuChoice.equals("2")) {
                _2editBorrow();
            } else if (menuChoice.equals("3")) {
                _3deleteBorrow();
            } else if (menuChoice.equals("w")) {
                run = false;
            } else {
                System.out.println("Incorrect input. Please enter labeled options.");
            }
        }
    }
}
