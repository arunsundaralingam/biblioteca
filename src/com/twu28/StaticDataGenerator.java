package com.twu28;

import java.util.*;

public class StaticDataGenerator {
    List bookList;
    List movieList;
    List userList;
    public StaticDataGenerator(){
        bookList = new ArrayList();
        movieList = new ArrayList();
        userList = new ArrayList();
        generateBooks();
        generateMovies();
        generateUsers();
    }
    private void generateUsers(){
        for(int i=1;i<=5;i++){
            userList.add(new User("111-111"+(i),"pass"+(1)));
        }
    }
    private void generateBooks() {
        bookList.add(new Book(1,"Head First Java","Kathy Sierra","O'Reilly Publications",2010, 1234567890L,20.00));
        bookList.add(new Book(1,"Head First Design Patterns","Kathy Sierra","O'Reilly Publications",2010, 1234567891L,25.00));
        bookList.add(new Book(1,"Head First OOAD","Gary Pollice","O'Reilly Publications",2010, 1234567893L,20.00));
        bookList.add(new Book(1,"Java2 Complete Reference","Herbert Schildt","TMH Publications",2011, 1234567892L,21.00));
        bookList.add(new Book(1,"Let Us C","Yashavant kanetkar","GPB Publications",2009, 1234567894L,20.00));
        bookList.add(new Book(1,"Programming in ANSI C","Balagurusamy E","TMH Publications",2003, 1234567895L,20.00));
        bookList.add(new Book(1,"Let Us C++","Yashavant Kanetkar","GPB Publications",2010, 1234567896L,20.00));
        bookList.add(new Book(1,"Clean Code: A Handbook of Agile Software Craftsmanship","Robert C Martin","Prentice Hall Publications",2010, 1234567897L,20.00));
        bookList.add(new Book(1,"Art of Living","Osho","Ram Publications",2010, 1234567898L,20.00));
        bookList.add(new Book(1,"Core Java","Cav S Hostmann","Sun Publications",2012, 1234567899L,50.00));
    }
    private void generateMovies(){
        movieList.add(new Movie("Ladri di biciclette (Bicycle Thieves)","Vittorio De Sica","8"));
        movieList.add(new Movie("La Passion de Jeanne d'Arc (The Passion of Joan of Arc)","Carl Theodor Dreyer","9"));
        movieList.add(new Movie("La Grande Illusion (Grand Illusion)","Jean Renoir","9"));
        movieList.add(new Movie("Greed","Erich von Stroheim","N/A"));
        movieList.add(new Movie("Intolerance: Love's Struggle Through the Ages","D. W. Griffith","N/A"));
        movieList.add(new Movie("Мать (Mother)","Vsevolod Pudovkin","7"));
        movieList.add(new Movie("Citizen Kane","Orson Welles","10"));
        movieList.add(new Movie("Земля (Earth)","Alexander Dovzhenko","9"));
        movieList.add(new Movie("Der letzte Mann (The Last Laugh)","F.W. Murnau","9"));
        movieList.add(new Movie("Das Cabinet des Dr. Caligari (The Cabinet of Dr. Caligari)","Robert Wiene","N/A"));
        movieList.add(new Movie("Pirates of the Caribbean: The Curse of the Black Pearl","Gore Verbinski","10"));
        movieList.add(new Movie("Slumdog Millionaire","Danny Boyle","10"));
        movieList.add(new Movie("Edward Scissorhands","Tim Burton","N/A"));
        movieList.add(new Movie("Darren Aronofsky","Requiem for a Dream","8"));
        movieList.add(new Movie("The Gold Rush","Charles Chaplin","10"));
    }
    public List getBookList() {
        return bookList;
    }
    public List getMovieList() {
        return movieList;
    }
    public List getUserList(){
        return userList;
    }
}
