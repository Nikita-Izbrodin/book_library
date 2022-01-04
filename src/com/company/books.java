package com.company;

public class books {

    private int ISBN;
    private String bookName;
    private String authorName;
    private String genre;

    public books(int ISBN, String bookName, String authorName, String genre) {
        this.ISBN = ISBN;
        this.bookName = bookName;
        this.authorName = authorName;
        this.genre = genre;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString(){
        return ISBN + ", " + bookName + ", " + authorName + ", " + genre;
    }

}
