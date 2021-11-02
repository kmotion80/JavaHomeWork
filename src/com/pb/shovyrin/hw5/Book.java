package com.pb.shovyrin.hw5;

public class Book {
    private String bookName;
    private String bookAuthor;
    private int year;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Book (String bookName, String bookAuthor, int year){
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.year = year;
    }

    public Book() {

    }

    public String printBook() {
        return bookName + "(" + bookAuthor + " " + year + " г.)";
    }
}
