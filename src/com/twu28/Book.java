package com.twu28;

public class Book {
    int serialNumber;
    String title;
    String author;
    String publication;
    int yearOfPublication;
    long ISBN;
    double price;

    public Book(int serialNumber , String title, String author, String publication, int yearOfPublication, long ISBN, double price){
        this.serialNumber = serialNumber;
        this.title = title;
        this.author = author;
        this.publication = publication;
        this.yearOfPublication = yearOfPublication;
        this.ISBN = ISBN;
        this.price = price;
    }

    public  String getNameOfBook(){
        return title;
    }
}
