package com.twu28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class LibraryUserInterface {
    public Library getLibrary() {
        return library;
    }

    Library library;
    public static void main(String[] args) {
        System.out.println("Welcome to Biblioteca !");
        System.out.println("________________________");
        LibraryUserInterface libraryUserInterface = new LibraryUserInterface();
        libraryUserInterface.interactWithUser();
    }
    public void interactWithUser(){
        library = new Library();
        while (true){
                    System.out.println("Please select any one of these options\n");
                    System.out.println("[1] Books reserved by you");
                    System.out.println("[2] Reserve a book");
                    System.out.println("[3] View a movie");
                    System.out.println("[4] Browse all books");
                    System.out.println("[5] Browse all movies");
                    System.out.println("[6] Check Library Number");
                    System.out.println("[7] Login");
                    System.out.println("[8] Exit");
                    int selectionFromTheUser = 0;
                    try {
                        selectionFromTheUser = Integer.parseInt(getInputString());
                    } catch (Exception e) {
                        System.out.println("Please enter a valid integer");
                    }
                    switch (selectionFromTheUser){
                        case 1:
                            displayBooksReservedByTheUser();
                            break;
                        case 2:
                            reserveBook();
                            break;
                        case 3:
                            viewMovie();
                            break;
                        case 4:
                            browseAllBooks();
                            break;
                        case 5:
                            browseAllMovies();
                            break;
                        case 6:
                            checkLibraryNumber();
                            break;
                        case 7:
                            login();
                            break;
                        case 8:
                            sayGoodBye();
                            break;
                        default:
                            System.out.println("Invalid Option. Please select [1-7]");
                            break;
                    }
                }


        }

    private void checkLibraryNumber() {
        if(library.isUserHasLoggedIn()){
            System.out.println("Your Library Number is : "+library.getCurrentUser());
        }
        else {
            System.out.println("Please talk to librarian. Thank you");
        }
    }

    private void viewMovie() {
        if(library.isUserHasLoggedIn()){
            int indexOfTheMovie = 0;
            System.out.println("Select Index["+library.getStartIndexOfMovies()+"-"+library.getLastIndexOfMovies()+"] of movie to view");
            try {
                indexOfTheMovie = Integer.parseInt(getInputString());
            } catch (Exception e) {
                System.out.println("Enter A valid Integer.");
            }
            if(library.isMovieInsideTheBounds(indexOfTheMovie)){
                System.out.println(library.getMovieFromIndex(indexOfTheMovie));
            }
            else {
                System.out.println("Please enter valid index ["+library.getStartIndexOfMovies()+"-"+library.getLastIndexOfMovies()+"]");
            }
        }
        else {
            System.out.println("You must login to use this option");
        }
    }

    public String getInputString(){
        BufferedReader reader;
        reader = new BufferedReader(new InputStreamReader(System.in));
        String inputString = "";
        try{
            inputString = reader.readLine();
        }   catch (Exception e){System.out.println("Some error has been occurred while getting input from you");}
        return inputString;
    }
    private void sayGoodBye() {
        System.out.println("Thank you \n\nVisit Again !");
        System.exit(0);
    }

    private void login() {
        if(library.isUserHasLoggedIn()){
            System.out.println("You are already logged in");
        }
        else {
            String userID = "";
            String password = "";
            System.out.println("Enter User ID : ");
            userID = getInputString();
            int userIndex = library.getUserIndexFromID(userID);
            if(userIndex == -1) {
                System.out.println("UserID does not exist");
            }
            else{
                System.out.println("Enter password : ");
                password = getInputString();
                if(library.isValidPasswordForTheUser(userIndex , password)){
                    library.performLogin(userID , password);
                }
                else {
                    System.out.println("Password does not match");
                }
            }
        }
    }

    private void reserveBook() {
        //browseAllBooks();
        if(library.isUserHasLoggedIn()){
            System.out.println("Enter ["+library.getStartIndexOfBooks()+"-"+library.getLastIndexOfBooks()+"] to reserve the corresponding book");
            int indexOfTheBook = 0;
            try {
                indexOfTheBook = Integer.parseInt(getInputString());
            } catch (Exception e) {
                System.out.println("Enter A valid Integer.");
            }
            if(library.isBookInsideTheBounds(indexOfTheBook)){
                if(library.isThePersonAlreadyReservedTheBook(indexOfTheBook)){
                    System.out.println("You have already reserved the book");
                }
                else{
                    library.addThisBookToHisCollection(indexOfTheBook);
                    System.out.println("Thank You! Enjoy the book");
                }
            }
            else{
                System.out.println("Select a valid index from ["+library.getStartIndexOfBooks()+"-"+library.getLastIndexOfBooks()+"]");
            }
        }
        else {
            System.out.println("You must login to use this option");
        }
    }

    private void browseAllBooks() {
        System.out.println("Title\t\tAuthor\tPublication\t\tYearOfPublication\tISBN\tPrice\tCategory");
        List bookList = library.getBookList();
        for(int i = 0; i < bookList.size(); i++){
            Book book = (Book)bookList.get(i);
            System.out.println("["+(i+1)+"] "+book);
        }
    }

    private void browseAllMovies() {
        System.out.println("Movie Name\t\t\tDirector\t\tRating");
        List movieList = library.getMovieList();
        for(int i = 0; i < movieList.size(); i++){
            Movie movie = (Movie)movieList.get(i);
            System.out.println("["+(i+1)+"] "+movie);
        }
    }

    private void displayBooksReservedByTheUser() {
        if(library.isUserHasLoggedIn()){
            int i = 0;
            List reservedBooks = library.getReservedBooks();
            if(reservedBooks.isEmpty())
                System.out.println("You Didn't register any book");
            else {
                System.out.println("Title\t\tAuthor\tPublication\t\tYearOfPublication\tISBN\tPrice\tCategory");
                for (Object reservedBooksByTheUser : reservedBooks) {
                    Book book = (Book) reservedBooksByTheUser;
                    System.out.println("[" + (i + 1) + "] " + book);
                    i++;
                }
            }
        }
        else {
            System.out.println("You must login to use this option");
        }
    }

}