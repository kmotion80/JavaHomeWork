package com.pb.shovyrin.hw5;

import java.util.ArrayList;

public class Reader {
    private String fio;
    private String readerNumber;
    private String fakultet;
    private String birthDay;
    private String phoneNumber;
    private ArrayList<Book> arrayTakeBook;

    public String getReaderNumber() {
        return readerNumber;
    }

    public void setReaderNumber(String readerNumber) {
        this.readerNumber = readerNumber;
    }

    public void setFakultet(String fakultet) {
        this.fakultet = fakultet;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Reader(String fio, String readerNumber, String fakultet, String birthDay, String phoneNumber) {
        this.fio = fio;
        this.readerNumber = readerNumber;
        this.fakultet = fakultet;
        this.birthDay = birthDay;
        this.phoneNumber = phoneNumber;
    }

    public Reader(String fio, String readerNumber, String birthDay){
        this.fio = fio;
        this.readerNumber = readerNumber;
        this.birthDay = birthDay;
    }
    public Reader(String fio, String birthDay){
        this.fio = fio;
        this.birthDay = birthDay;
    }

    public void takeBook(int countBook) {
        System.out.println(this.fio + " взял " + countBook + " книг" + this.getCountEnds(countBook));
    }

    public void takeBook(String... books) {
        System.out.println(this.fio + " взял книги: ");
        for (String book : books) {
            System.out.print(book + ", ");
        }
        System.out.println("");
    }

    public void takeBook(Book... books) {
        System.out.println(this.fio + " взял книги: ");
        for (Book book : books) {
            System.out.print(book.printBook() + ",");
        }
        System.out.println("");
    }

    public void returnBook(int countBook) {
        System.out.println(this.fio + " вернул " + countBook + " книг" + this.getCountEnds(countBook));
    }

    public void returnBook(String... books) {
        System.out.println(this.fio + " вернул книги: ");
        for (String book : books) {
            System.out.print(book + ", ");
        }
        System.out.println("");
    }

    public void returnBook(Book... books) {
        System.out.println(this.fio + " вернул книги: ");
        for (Book book : books) {
            System.out.print(book.printBook() + ", ");
        }
        System.out.println("");
    }

    private String getCountEnds(int cnt) {
        int count = cnt % 10;
        return count == 1 ? "у" : count <= 4 ? "и" : "";
    }

    public void getPersonInfo(){
        System.out.println("ФИО: " +fio + "\nДата рождения: " + birthDay + "\nЧитательский номер:" + readerNumber + "\nФакультет: " + fakultet + "\nНомер телефона: " + phoneNumber);
    }
}
