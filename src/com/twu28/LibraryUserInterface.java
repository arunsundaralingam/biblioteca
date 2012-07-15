package com.twu28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LibraryUserInterface {
    public static void main(String[] args) {
        System.out.println("Welcome to Biblioteca !");
        System.out.println("________________________");
        LibraryUserInterface libraryUserInterface = new LibraryUserInterface();
        libraryUserInterface.interactWithUser();
    }
    public void interactWithUser(){
        com.twu28.Library library  = new Library();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String userId = "";
        while (true){
            System.out.println("[Hint]:An Example User ID : u0001");
            System.out.print("\nPlease Enter Your UserID <OR> Type exit to EXIT  :  ");
            try {
                userId = br.readLine();
            } catch (IOException e) {
                System.err.println("Some Error has been occurred while getting input from you.");
                continue;
            }
            if(userId.equalsIgnoreCase("EXIT")){
                System.out.println("Thank you Visit Again !");
                System.exit(0);
            }
            else if(library.doesUserIdExist(userId)){
                while (true){
                    System.out.println("Hi "+library.getUserName(userId));
                    System.out.println("Please select any one of these options\n");
                    System.out.println("[1] Books reserved by you");
                    System.out.println("[2] Reserve a book");
                    System.out.println("[3] Return a book");
                    System.out.println("[4] Search for a book");
                    System.out.println("[5] Browse all books");
                    System.out.println("[6] Exit");
                    int selectionFromTheUser = 0;
                    try {
                        selectionFromTheUser = Integer.parseInt(br.readLine());
                    } catch (Exception e) {
                        System.err.println("Some Error has been occurred while getting input from you.");
                    }
                    switch (selectionFromTheUser){
                        case 1:
                            library.displayBooksReservedByTheUser(userId);
                            break;
                        case 2:
                            library.reserveBook(userId);
                            break;
                        case 3:
                            library.returnBook(userId);
                            break;
                        case 4:
                            library.searchForBook();
                            break;
                        case 5:
                            library.browseAllBooks();
                            break;
                        case 6:
                            System.exit(0);
                            break;
                        default:
                            System.err.println("Invalid Option. Please select [1-6]");
                            break;
                    }
                }
            }
            else {
                System.err.println("User Id Invalid");
            }

        }
    }
}