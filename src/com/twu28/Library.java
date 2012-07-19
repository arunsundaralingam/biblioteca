package com.twu28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    List bookList;
    List movieList;
    List reservedBooks;
    List userList;
    BufferedReader br;
    User currentUser;
    public int startIndexOfBooks;
    public int lastIndexOfBooks;
    private int startIndexOfMovies;
    private int lastIndexOfMovies;
    private boolean hasTheUserLoggedIn;

    Library(){
        StaticDataGenerator generator = new StaticDataGenerator();
        bookList = generator.getBookList();
        movieList = generator.getMovieList();
        userList = generator.getUserList();
        startIndexOfBooks = 1;
        lastIndexOfBooks = bookList.size();
        startIndexOfMovies = 1;
        lastIndexOfMovies =movieList.size();
        hasTheUserLoggedIn = false;
        reservedBooks = new ArrayList();
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public int getStartIndexOfBooks() {
        return startIndexOfBooks;
    }

    public int getLastIndexOfBooks() {
        return lastIndexOfBooks;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public List getBookList() {
        return bookList;
    }
    public List getMovieList(){
        return movieList;
    }
    public List getReservedBooks() {
        return reservedBooks;
    }

    public boolean isBookInsideTheBounds(int indexOfTheBook){
        return indexOfTheBook <= lastIndexOfBooks && indexOfTheBook > startIndexOfBooks;
    }
    public boolean isMovieInsideTheBounds(int indexOfTheMovie){
        return indexOfTheMovie <= lastIndexOfMovies && indexOfTheMovie > startIndexOfMovies;
    }
    public boolean isThePersonAlreadyReservedTheBook(int indexOfTheBook){
        return reservedBooks.contains(bookList.get(indexOfTheBook));
    }

    public int getStartIndexOfMovies() {
        return startIndexOfMovies;
    }

    public int getLastIndexOfMovies() {
        return lastIndexOfMovies;
    }

    public void addThisBookToHisCollection(int indexOfTheBook) {
        getReservedBooks().add(getBookList().get(indexOfTheBook));
    }

    public Movie getMovieFromIndex(int indexOfTheMovie) {
        return (Movie)(movieList.get(indexOfTheMovie));
    }
    public int getUserIndexFromID(String userID){
        for (int i=0;i<userList.size();i++){
            if(((User)(userList.get(i))).getUserID().equals(userID)) return i;
        }
        return -1;
    }
    public boolean isValidPasswordForTheUser(int userIndex,String password){
        return (((User)(userList.get(userIndex))).getPassword().equals(password));
    }
    public void performLogin(String userID , String password){
        currentUser = getUserFromUserID(userID);
        if(currentUser != null)
        hasTheUserLoggedIn = true;
    }
    public User getUserFromUserID(String userID){
        User aUser = null;
        for(Object anObject:userList) {
            aUser = (User)anObject;
            if(aUser.getUserID().equals(userID)) return aUser;
        }
        return aUser;
    }
    public boolean isUserHasLoggedIn(){
        return hasTheUserLoggedIn;
    }
}
