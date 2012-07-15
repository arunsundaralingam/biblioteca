package com.twu28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: M. Arun Sundaralingam
 * Date: 7/15/12
 * Time: 12:57 PM
 */
public class Library {
    List bookList;
    List reservedBooks;
    BufferedReader br;
    Library(){
        StaticDataGenerator generator = new StaticDataGenerator();
        bookList = generator.getBookList();
        reservedBooks = new ArrayList();
        br = new BufferedReader(new InputStreamReader(System.in));
    }
    public void displayBooksReservedByTheUser() {
        System.out.println("Title\t\tAuthor\tPublication\t\tYearOfPublication\tISBN\tPrice\tCategory");
        int i = 0;
        if(reservedBooks.isEmpty())
        System.out.println("You Didn't register any book");
        else
        for(Object reservedBooksByTheUser:reservedBooks){
            Book book = (Book)reservedBooksByTheUser;
            System.out.println("["+(i+1)+"] "+book.title+"\t"+book.author+"\t"+book.publication+"\t"+book.yearOfPublication+"\t"+book.ISBN+"\t"+book.price);
            i++;
        }
    }

    public void reserveBook() {
        browseAllBooks();
        System.out.println("Enter [1-10] to reserve the corresponding book");
        int indexOfTheBook = 0;
        try {
            indexOfTheBook = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            System.err.println("Some Error has been occurred while entering input.");
        }
        if(indexOfTheBook < 11 && indexOfTheBook > 0){
            if(reservedBooks.contains(bookList.get(indexOfTheBook))){
                System.out.println("You have already reserved the book");
            }
            else{
                reservedBooks.add(bookList.get(indexOfTheBook));
                System.out.println("Thank You! Enjoy the book");
            }
        }
    }

    public void returnBook() {
        displayBooksReservedByTheUser();
        if(reservedBooks.isEmpty()) System.err.println("You have no books to return");
        else {
            System.out.println("Enter index of the book you want to return : [starts from 1]");
            int selectedIndexOfTheReservedBooksByTheUser = 0;
            try {
                selectedIndexOfTheReservedBooksByTheUser = Integer.parseInt(br.readLine());
            } catch (IOException e) {
                System.err.println("Some error has been occurred while entering input");
            }
            reservedBooks.remove(selectedIndexOfTheReservedBooksByTheUser - 1);
        }

    }

    public void searchForBook() {
        String searchString = "";
        System.out.println("Enter part of the title of the book you are looking for  :  ");
        try {
            searchString = br.readLine();
        } catch (IOException e) {
            System.out.println("Some error has been occurred while entering input");
        }
        boolean bookNotFound = false;
        for(Object bookObject:bookList){
            Book book = (Book)bookObject;
            if(((Book)book).getNameOfBook().toUpperCase().contains(searchString.toUpperCase())){
                System.out.println(book.title+"\t"+book.author+"\t"+book.publication+"\t"+book.yearOfPublication+"\t"+book.ISBN+"\t"+book.price);
                bookNotFound = true;
            }
        }
        if(!bookNotFound) System.err.println("Sorry we don't have that book yet");
    }

    public void browseAllBooks() {
        System.out.println("Title\t\tAuthor\tPublication\t\tYearOfPublication\tISBN\tPrice\tCategory");
        for(int i = 0; i < bookList.size(); i++){
            Book book = (Book)bookList.get(i);
            System.out.println("["+(i+1)+"] "+book.title+"\t"+book.author+"\t"+book.publication+"\t"+book.yearOfPublication+"\t"+book.ISBN+"\t"+book.price);
        }
    }
}
