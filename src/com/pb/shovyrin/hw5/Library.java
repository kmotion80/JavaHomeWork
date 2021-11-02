package com.pb.shovyrin.hw5;

import java.util.ArrayList;

public class Library {
    public static void main(String[] args) {
        ArrayList<Book> arrayBook = new ArrayList();
        ArrayList<Reader> arrayReaders = new ArrayList();

        Book book1 = new Book("Изучаем Java", "Кэти Сьерра, Берт Бейтс", 2019);
        arrayBook.add(book1);

        Book book2 = new Book();
        book2.setBookName("Искусство программирования");
        book2.setBookAuthor("Дональд Кнут");
        book2.setYear(2018);
        arrayBook.add(book2);

        Book book3 = new Book("Java для чайников, 7-е издание", "Барри Берд", 2017);
        arrayBook.add(book3);

        System.out.println("Книги в библеотеке: ");
        for (Book book : arrayBook) {
            System.out.println(book.printBook());
        }
        System.out.println("-------------------------------------------");

        //Persons
        Reader reader1 = new Reader("Иванов А. А.", "DNH10000001", "developer", "19990901", "+380501452369");
        reader1.setFakultet("marketing");
        reader1.setPhoneNumber("+380670000000");
        arrayReaders.add(reader1);

        Reader reader2 = new Reader("Шехшов В. В.", "DNH10000002", "19750102");
        reader2.setFakultet("cooking");
        reader2.setPhoneNumber("+380670000022");
        arrayReaders.add(reader2);

        Reader reader3 = new Reader("Васичкин Р. О.", "19770502");
        reader3.setFakultet("developer");
        reader3.setPhoneNumber("+380670033000");
        reader3.setReaderNumber("DNH10000003");
        arrayReaders.add(reader3);

        System.out.println("Наши читатели: ");
        for (Reader reader : arrayReaders) {
            reader.getPersonInfo();
            System.out.println("-------------------------------------------");
        }

        //library work
        reader1.takeBook(book2, book1);
        reader1.returnBook(book2);
        reader1.returnBook(book1.getBookName());

        reader1.takeBook(1);
        reader1.returnBook(1);
        System.out.println("-------------------------------------------");

        reader2.takeBook(book1.getBookName(), book2.getBookName());
        reader2.returnBook(1);
        reader2.returnBook(book1);
        System.out.println("-------------------------------------------");

        reader3.takeBook(1);
        reader3.takeBook(book2, book3);
        reader3.returnBook(3);
    }
}
