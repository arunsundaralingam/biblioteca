package com.twu28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    Map userList;
    List bookList;
    Map reservedBooks;
    BufferedReader br;
    Library(){
        StaticDataGenerator generator = new StaticDataGenerator();
        userList = generator.getUserList();
        bookList = generator.getBookList();
        reservedBooks = new HashMap();
        br = new BufferedReader(new InputStreamReader(System.in));
    }
    public boolean doesUserIdExist(String userId) {
        for(Object user:userList.keySet()){
            if(((String)user).equals(userId))return true;
        }
        return  false;
    }

    public String getUserName(String userId) {
        return ((User)userList.get(userId)).getNameOfTheUser();
    }

    public void displayBooksReservedByTheUser(String userId) {
        System.out.println("Title\t\tAuthor\tPublication\t\tYearOfPublication\tISBN\tPrice\tCategory");
        int i = 0;
        if(reservedBooks.get(userId) == null) System.out.println("You Didn't register any book");
        else
        for(Object reservedBooksByTheUser:(List)reservedBooks.get(userId)){
            Book book = (Book)reservedBooksByTheUser;
            System.out.println("["+(i+1)+"] "+book.title+"\t"+book.author+"\t"+book.publication+"\t"+book.yearOfPublication+"\t"+book.ISBN+"\t"+book.price);
            i++;
        }
    }

    public void reserveBook(String userId) {
        browseAllBooks();
        System.out.println("Enter [1-10] to reserve the corresponding book");
        int indexOfTheBook = 0;
        try {
            indexOfTheBook = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            System.err.println("Some Error has been occurred while entering input.");
        }
        if(indexOfTheBook < 11 && indexOfTheBook > 0){
            if(isBookAvailable(indexOfTheBook)){
                reservedBooks.put(userList.get(userId),bookList.get(indexOfTheBook));
            }
            else System.err.println("The book you have entered is not available\n Please talk to the Librarian");
        }
        else System.err.println("You have entered an index out of bounds");
    }

    private boolean isBookAvailable(int indexOfTheBook) {
        for(Object users:reservedBooks.keySet()){
            if(((List)reservedBooks.get(users)).contains(bookList.get(indexOfTheBook-1))){
                return false;
            }
        }
        return true;  //To change body of created methods use File | Settings | File Templates.
    }

    public void returnBook(String userId) {
        displayBooksReservedByTheUser(userId);
        if(reservedBooks.get(userId) == null) System.err.println("You have no books to return");
        else {
            System.out.println("Enter index of the book you want to return : ");
            int selectedIndexOfTheReservedBooksByTheUser = 0;
            try {
                selectedIndexOfTheReservedBooksByTheUser = Integer.parseInt(br.readLine());
            } catch (IOException e) {
                System.err.println("Some error has been occurred while entering input");
            }
            List listOfBooksReservedByTheUser = (List)reservedBooks.get(userId);
            if(listOfBooksReservedByTheUser.isEmpty()) System.err.println("There are no books to return");
            else if(listOfBooksReservedByTheUser.get(selectedIndexOfTheReservedBooksByTheUser) == null)
                System.err.println("Please Enter valid index");
            else listOfBooksReservedByTheUser.remove(selectedIndexOfTheReservedBooksByTheUser);
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
